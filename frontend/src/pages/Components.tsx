import React, { useState } from 'react';
import { useQuery, useMutation } from '@tanstack/react-query';
import { Link } from 'react-router-dom';
import {
  MagnifyingGlassIcon,
  PlusIcon,
  QrCodeIcon,
  EyeIcon,
  DocumentTextIcon,
} from '@heroicons/react/24/outline';
import { componentsAPI, reportsAPI } from '../services/api';
import { format } from 'date-fns';
import ReportModal from '../components/ReportModal';

interface Component {
  id: number;
  serial_id: string;
  component_type: string;
  current_status: string;
  vendor: {
    name: string;
    vendor_code: string;
  };
  manufacturing_date: string;
  warranty_end_date: string;
  location?: {
    zone: string;
    division: string;
  };
}

const Components: React.FC = () => {
  const [searchTerm, setSearchTerm] = useState('');
  const [statusFilter, setStatusFilter] = useState('all');
  const [typeFilter, setTypeFilter] = useState('all');
  const [selectedComponents, setSelectedComponents] = useState<string[]>([]);
  const [reportModalOpen, setReportModalOpen] = useState(false);
  const [currentReport, setCurrentReport] = useState<any>(null);

  const { data: components, isLoading } = useQuery({
    queryKey: ['components'],
    queryFn: () => componentsAPI.getAll({ limit: 100 }).then(res => res.data),
  });

  const { data: reportServiceStatus } = useQuery({
    queryKey: ['reportServiceStatus'],
    queryFn: () => reportsAPI.getServiceStatus().then(res => res.data),
    retry: false,
  });

  const generateReportMutation = useMutation({
    mutationFn: (componentId: string) => reportsAPI.generateComponentReport(componentId),
    onSuccess: (data) => {
      setCurrentReport(data.data);
      setReportModalOpen(true);
    },
    onError: (error) => {
      console.error('Failed to generate report:', error);
      alert('Failed to generate report. Please try again.');
    },
  });

  const generateBulkReportMutation = useMutation({
    mutationFn: (componentIds: string[]) => reportsAPI.generateBulkReport(componentIds, 'individual'),
    onSuccess: (data) => {
      setCurrentReport(data.data);
      setReportModalOpen(true);
    },
    onError: (error) => {
      console.error('Failed to generate bulk report:', error);
      alert('Failed to generate bulk report. Please try again.');
    },
  });

  const filteredComponents = components?.filter((component: Component) => {
    const matchesSearch = 
      component.serial_id.toLowerCase().includes(searchTerm.toLowerCase()) ||
      component.vendor.name.toLowerCase().includes(searchTerm.toLowerCase());
    
    // Normalize status comparison (backend returns uppercase, frontend uses lowercase)
    const normalizedStatus = component.current_status.toLowerCase();
    const matchesStatus = statusFilter === 'all' || normalizedStatus === statusFilter;
    
    // Normalize type comparison (backend returns uppercase, frontend uses lowercase)
    const normalizedType = component.component_type.toLowerCase();
    const matchesType = typeFilter === 'all' || normalizedType === typeFilter;
    
    return matchesSearch && matchesStatus && matchesType;
  }) || [];

  const getStatusBadge = (status: string) => {
    const normalizedStatus = status.toLowerCase();
    const statusClasses = {
      manufactured: 'status-manufactured',
      shipped: 'status-shipped',
      received: 'status-received',
      installed: 'status-installed',
      in_service: 'status-in_service',
      maintenance: 'status-maintenance',
      failed: 'status-failed',
      withdrawn: 'status-withdrawn',
    };
    
    return (
      <span className={statusClasses[normalizedStatus as keyof typeof statusClasses] || 'status-badge bg-gray-100 text-gray-800'}>
        {normalizedStatus.replace('_', ' ').replace(/\b\w/g, (l: string) => l.toUpperCase())}
      </span>
    );
  };

  const getTypeDisplay = (type: string) => {
    const normalizedType = type.toLowerCase();
    return normalizedType.replace('_', ' ').replace(/\b\w/g, (l: string) => l.toUpperCase());
  };

  const handleComponentSelect = (componentId: string) => {
    setSelectedComponents(prev => 
      prev.includes(componentId) 
        ? prev.filter(id => id !== componentId)
        : [...prev, componentId]
    );
  };

  const handleGenerateReport = (componentId: string) => {
    if (!reportServiceStatus?.available) {
      alert('Report generation service is not available. Please check if the Google Generative AI package is installed.');
      return;
    }
    generateReportMutation.mutate(componentId);
  };

  const handleGenerateBulkReport = () => {
    if (!reportServiceStatus?.available) {
      alert('Report generation service is not available. Please check if the Google Generative AI package is installed.');
      return;
    }
    if (selectedComponents.length === 0) {
      alert('Please select at least one component to generate a report.');
      return;
    }
    generateBulkReportMutation.mutate(selectedComponents);
  };

  const handleSelectAll = () => {
    if (selectedComponents.length === filteredComponents.length) {
      setSelectedComponents([]);
    } else {
      setSelectedComponents(filteredComponents.map((c: Component) => c.serial_id));
    }
  };

  if (isLoading) {
    return (
      <div className="flex items-center justify-center h-64">
        <div className="animate-spin rounded-full h-12 w-12 border-b-2 border-railway-blue"></div>
      </div>
    );
  }

  return (
    <div className="space-y-6">
      {/* Header */}
      <div className="flex justify-between items-center">
        <div>
          <h1 className="text-2xl font-bold text-gray-900">Components</h1>
          <p className="mt-1 text-sm text-gray-600">
            Manage track fittings and components
          </p>
        </div>
        <div className="flex items-center space-x-3">
          {selectedComponents.length > 0 && (
            <button
              onClick={handleGenerateBulkReport}
              disabled={generateBulkReportMutation.isPending || !reportServiceStatus?.available}
              className="btn-secondary flex items-center disabled:opacity-50 disabled:cursor-not-allowed"
              title={!reportServiceStatus?.available ? 'Report generation service not available' : ''}
            >
              <DocumentTextIcon className="w-4 h-4 mr-2" />
              {generateBulkReportMutation.isPending ? 'Generating...' : `Generate Report (${selectedComponents.length})`}
            </button>
          )}
          {!reportServiceStatus?.available && (
            <div className="text-sm text-amber-600 bg-amber-50 px-3 py-1 rounded-lg">
              ⚠️ AI Report service unavailable
            </div>
          )}
          <button className="btn-primary flex items-center">
            <PlusIcon className="w-4 h-4 mr-2" />
            Add Component
          </button>
        </div>
      </div>

      {/* Filters */}
      <div className="card p-4">
        <div className="grid grid-cols-1 md:grid-cols-4 gap-4">
          {/* Search */}
          <div className="relative">
            <MagnifyingGlassIcon className="w-5 h-5 absolute left-3 top-1/2 transform -translate-y-1/2 text-gray-400" />
            <input
              type="text"
              placeholder="Search components..."
              className="input-field pl-10"
              value={searchTerm}
              onChange={(e) => setSearchTerm(e.target.value)}
            />
          </div>

          {/* Status Filter */}
          <select
            className="input-field"
            value={statusFilter}
            onChange={(e) => setStatusFilter(e.target.value)}
          >
            <option value="all">All Status</option>
            <option value="manufactured">Manufactured</option>
            <option value="shipped">Shipped</option>
            <option value="received">Received</option>
            <option value="installed">Installed</option>
            <option value="in_service">In Service</option>
            <option value="maintenance">Maintenance</option>
            <option value="failed">Failed</option>
            <option value="withdrawn">Withdrawn</option>
          </select>

          {/* Type Filter */}
          <select
            className="input-field"
            value={typeFilter}
            onChange={(e) => setTypeFilter(e.target.value)}
          >
            <option value="all">All Types</option>
            <option value="elastic_rail_clip">Elastic Rail Clip</option>
            <option value="liner">Liner</option>
            <option value="rail_pad">Rail Pad</option>
            <option value="sleeper">Sleeper</option>
          </select>

          {/* Results count */}
          <div className="flex items-center text-sm text-gray-600">
            {filteredComponents.length} of {components?.length || 0} components
          </div>
        </div>
      </div>

      {/* Components Table */}
      <div className="card overflow-hidden">
        <div className="overflow-x-auto">
          <table className="min-w-full divide-y divide-gray-200">
            <thead className="bg-gray-50">
              <tr>
                <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                  <input
                    type="checkbox"
                    checked={selectedComponents.length === filteredComponents.length && filteredComponents.length > 0}
                    onChange={handleSelectAll}
                    className="rounded border-gray-300 text-railway-blue focus:ring-railway-blue"
                  />
                </th>
                <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                  Component
                </th>
                <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                  Type
                </th>
                <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                  Status
                </th>
                <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                  Vendor
                </th>
                <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                  Manufacturing Date
                </th>
                <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                  Warranty
                </th>
                <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                  Location
                </th>
                <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                  Actions
                </th>
              </tr>
            </thead>
            <tbody className="bg-white divide-y divide-gray-200">
              {filteredComponents.map((component: Component) => (
                <tr key={component.id} className="hover:bg-gray-50">
                  <td className="px-6 py-4 whitespace-nowrap">
                    <input
                      type="checkbox"
                      checked={selectedComponents.includes(component.serial_id)}
                      onChange={() => handleComponentSelect(component.serial_id)}
                      className="rounded border-gray-300 text-railway-blue focus:ring-railway-blue"
                    />
                  </td>
                  <td className="px-6 py-4 whitespace-nowrap">
                    <div className="text-sm font-medium text-gray-900">
                      {component.serial_id}
                    </div>
                  </td>
                  <td className="px-6 py-4 whitespace-nowrap">
                    <div className="text-sm text-gray-900">
                      {getTypeDisplay(component.component_type)}
                    </div>
                  </td>
                  <td className="px-6 py-4 whitespace-nowrap">
                    {getStatusBadge(component.current_status)}
                  </td>
                  <td className="px-6 py-4 whitespace-nowrap">
                    <div className="text-sm text-gray-900">{component.vendor.name}</div>
                    <div className="text-sm text-gray-500">{component.vendor.vendor_code}</div>
                  </td>
                  <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-900">
                    {component.manufacturing_date 
                      ? format(new Date(component.manufacturing_date), 'MMM dd, yyyy')
                      : 'N/A'
                    }
                  </td>
                  <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-900">
                    {component.warranty_end_date 
                      ? format(new Date(component.warranty_end_date), 'MMM dd, yyyy')
                      : 'N/A'
                    }
                  </td>
                  <td className="px-6 py-4 whitespace-nowrap">
                    {component.location ? (
                      <div className="text-sm text-gray-900">
                        {component.location.zone}
                        <div className="text-xs text-gray-500">
                          {component.location.division}
                        </div>
                      </div>
                    ) : (
                      <span className="text-sm text-gray-500">Not assigned</span>
                    )}
                  </td>
                  <td className="px-6 py-4 whitespace-nowrap text-sm font-medium">
                    <div className="flex space-x-2">
                      <Link
                        to={`/components/${component.serial_id}`}
                        className="text-railway-blue hover:text-blue-700"
                        title="View Details"
                      >
                        <EyeIcon className="w-4 h-4" />
                      </Link>
                      <button
                        onClick={() => handleGenerateReport(component.serial_id)}
                        disabled={generateReportMutation.isPending || !reportServiceStatus?.available}
                        className="text-green-600 hover:text-green-700 disabled:text-gray-400 disabled:cursor-not-allowed"
                        title={!reportServiceStatus?.available ? 'AI Report service unavailable' : 'Generate AI Report'}
                      >
                        <DocumentTextIcon className="w-4 h-4" />
                      </button>
                      <button
                        className="text-gray-600 hover:text-gray-900"
                        title="Generate QR"
                        onClick={() => {
                          // Handle QR generation
                        }}
                      >
                        <QrCodeIcon className="w-4 h-4" />
                      </button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>

        {filteredComponents.length === 0 && (
          <div className="text-center py-12">
            <div className="text-gray-500">
              {searchTerm || statusFilter !== 'all' || typeFilter !== 'all'
                ? 'No components match your filters'
                : 'No components found'
              }
            </div>
          </div>
        )}
      </div>

      {/* Report Modal */}
      <ReportModal
        isOpen={reportModalOpen}
        onClose={() => {
          setReportModalOpen(false);
          setCurrentReport(null);
        }}
        report={currentReport}
        isLoading={generateReportMutation.isPending || generateBulkReportMutation.isPending}
      />
    </div>
  );
};

export default Components;
