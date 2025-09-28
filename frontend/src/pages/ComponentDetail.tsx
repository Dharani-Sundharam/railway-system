import React from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { useQuery } from '@tanstack/react-query';
import {
  ArrowLeftIcon,
  QrCodeIcon,
  ClockIcon,
  MapPinIcon,
  BuildingStorefrontIcon,
} from '@heroicons/react/24/outline';
import { componentsAPI, analyticsAPI } from '../services/api';
import { format } from 'date-fns';
import QRCode from 'react-qr-code';

const ComponentDetail: React.FC = () => {
  const { id } = useParams<{ id: string }>();
  const navigate = useNavigate();

  const { data: component, isLoading } = useQuery({
    queryKey: ['component', id],
    queryFn: () => componentsAPI.getById(id!).then(res => res.data),
    enabled: !!id,
  });

  const { data: lifecycle } = useQuery({
    queryKey: ['component-lifecycle', id],
    queryFn: () => analyticsAPI.getComponentLifecycle(id!).then(res => res.data),
    enabled: !!id,
  });

  if (isLoading) {
    return (
      <div className="flex items-center justify-center h-64">
        <div className="animate-spin rounded-full h-12 w-12 border-b-2 border-railway-blue"></div>
      </div>
    );
  }

  if (!component) {
    return (
      <div className="text-center py-12">
        <div className="text-gray-500">Component not found</div>
      </div>
    );
  }

  const getStatusBadge = (status: string) => {
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
      <span className={statusClasses[status as keyof typeof statusClasses] || 'status-badge bg-gray-100 text-gray-800'}>
        {status.replace('_', ' ').replace(/\b\w/g, (l: string) => l.toUpperCase())}
      </span>
    );
  };

  const qrData = `https://rail.id/i/${component.serial_id}`;

  return (
    <div className="space-y-6">
      {/* Header */}
      <div className="flex items-center">
        <button
          onClick={() => navigate('/')}
          className="mr-4 p-2 text-gray-400 hover:text-gray-600"
        >
          <ArrowLeftIcon className="w-5 h-5" />
        </button>
        <div className="flex-1">
          <h1 className="text-2xl font-bold text-gray-900">
            Component Details
          </h1>
          <p className="mt-1 text-sm text-gray-600">
            {component.serial_id}
          </p>
        </div>
        <div className="flex space-x-2">
          <button className="btn-secondary flex items-center">
            <QrCodeIcon className="w-4 h-4 mr-2" />
            Generate QR
          </button>
        </div>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
        {/* Main Info */}
        <div className="lg:col-span-2 space-y-6">
          {/* Basic Information */}
          <div className="card p-6">
            <h2 className="text-lg font-medium text-gray-900 mb-4">
              Basic Information
            </h2>
            <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
              <div>
                <label className="text-sm font-medium text-gray-500">Serial ID</label>
                <div className="text-sm text-gray-900">{component.serial_id}</div>
              </div>
              <div>
                <label className="text-sm font-medium text-gray-500">Type</label>
                <div className="text-sm text-gray-900">
                  {component.component_type.replace('_', ' ').replace(/\b\w/g, (l: string) => l.toUpperCase())}
                </div>
              </div>
              <div>
                <label className="text-sm font-medium text-gray-500">Status</label>
                <div className="mt-1">{getStatusBadge(component.current_status)}</div>
              </div>
              <div>
                <label className="text-sm font-medium text-gray-500">Material Specification</label>
                <div className="text-sm text-gray-900">{component.material_specification || 'N/A'}</div>
              </div>
              <div>
                <label className="text-sm font-medium text-gray-500">Batch Number</label>
                <div className="text-sm text-gray-900">{component.batch_number || 'N/A'}</div>
              </div>
              <div>
                <label className="text-sm font-medium text-gray-500">Lot Number</label>
                <div className="text-sm text-gray-900">{component.lot_number || 'N/A'}</div>
              </div>
              <div>
                <label className="text-sm font-medium text-gray-500">PO Number</label>
                <div className="text-sm text-gray-900">{component.po_number || 'N/A'}</div>
              </div>
            </div>
          </div>

          {/* Vendor Information */}
          {component.vendor && (
            <div className="card p-6">
              <h2 className="text-lg font-medium text-gray-900 mb-4 flex items-center">
                <BuildingStorefrontIcon className="w-5 h-5 mr-2" />
                Vendor Information
              </h2>
              <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                <div>
                  <label className="text-sm font-medium text-gray-500">Vendor Name</label>
                  <div className="text-sm text-gray-900">{component.vendor.name}</div>
                </div>
                <div>
                  <label className="text-sm font-medium text-gray-500">Vendor Code</label>
                  <div className="text-sm text-gray-900">{component.vendor.vendor_code}</div>
                </div>
                <div>
                  <label className="text-sm font-medium text-gray-500">Contact Person</label>
                  <div className="text-sm text-gray-900">{component.vendor.contact_person || 'N/A'}</div>
                </div>
                <div>
                  <label className="text-sm font-medium text-gray-500">Quality Rating</label>
                  <div className="text-sm text-gray-900">
                    {component.vendor.quality_rating ? `${component.vendor.quality_rating}/5.0` : 'N/A'}
                  </div>
                </div>
              </div>
            </div>
          )}

          {/* Location Information */}
          {component.location && (
            <div className="card p-6">
              <h2 className="text-lg font-medium text-gray-900 mb-4 flex items-center">
                <MapPinIcon className="w-5 h-5 mr-2" />
                Location Information
              </h2>
              <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                <div>
                  <label className="text-sm font-medium text-gray-500">Zone</label>
                  <div className="text-sm text-gray-900">{component.location.zone}</div>
                </div>
                <div>
                  <label className="text-sm font-medium text-gray-500">Division</label>
                  <div className="text-sm text-gray-900">{component.location.division}</div>
                </div>
                <div>
                  <label className="text-sm font-medium text-gray-500">Section</label>
                  <div className="text-sm text-gray-900">{component.location.section || 'N/A'}</div>
                </div>
                <div>
                  <label className="text-sm font-medium text-gray-500">Station Code</label>
                  <div className="text-sm text-gray-900">{component.location.station_code || 'N/A'}</div>
                </div>
                <div>
                  <label className="text-sm font-medium text-gray-500">Chainage</label>
                  <div className="text-sm text-gray-900">{component.location.chainage || 'N/A'}</div>
                </div>
                <div>
                  <label className="text-sm font-medium text-gray-500">Track Number</label>
                  <div className="text-sm text-gray-900">{component.location.track_number || 'N/A'}</div>
                </div>
              </div>
            </div>
          )}

          {/* Timeline */}
          {lifecycle?.timeline_events && (
            <div className="card p-6">
              <h2 className="text-lg font-medium text-gray-900 mb-4 flex items-center">
                <ClockIcon className="w-5 h-5 mr-2" />
                Component Timeline
              </h2>
              <div className="flow-root">
                <ul className="-mb-8">
                  {lifecycle.timeline_events.map((event: any, eventIdx: number) => (
                    <li key={eventIdx}>
                      <div className="relative pb-8">
                        {eventIdx !== lifecycle.timeline_events.length - 1 ? (
                          <span
                            className="absolute top-4 left-4 -ml-px h-full w-0.5 bg-gray-200"
                            aria-hidden="true"
                          />
                        ) : null}
                        <div className="relative flex space-x-3">
                          <div>
                            <span className="h-8 w-8 rounded-full bg-railway-blue flex items-center justify-center ring-8 ring-white">
                              <ClockIcon className="w-4 h-4 text-white" />
                            </span>
                          </div>
                          <div className="min-w-0 flex-1 pt-1.5">
                            <div>
                              <p className="text-sm font-medium text-gray-900">
                                {event.event}
                              </p>
                              <p className="text-sm text-gray-500">
                                {event.description}
                              </p>
                              {event.details && (
                                <p className="text-xs text-gray-400 mt-1">
                                  {event.details}
                                </p>
                              )}
                            </div>
                            <div className="mt-2 text-xs text-gray-500">
                              {format(new Date(event.date), 'MMM dd, yyyy HH:mm')}
                            </div>
                          </div>
                        </div>
                      </div>
                    </li>
                  ))}
                </ul>
              </div>
            </div>
          )}
        </div>

        {/* Sidebar */}
        <div className="space-y-6">
          {/* QR Code */}
          <div className="card p-6">
            <h2 className="text-lg font-medium text-gray-900 mb-4">QR Code</h2>
            <div className="text-center">
              <div className="inline-block p-4 bg-white border-2 border-gray-200 rounded-lg">
                <QRCode
                  value={qrData}
                  size={150}
                  level="H"
                />
              </div>
              <div className="mt-3 text-xs text-gray-500 break-all">
                {qrData}
              </div>
              <button className="mt-3 btn-secondary text-sm w-full">
                Download QR Code
              </button>
            </div>
          </div>

          {/* Dates */}
          <div className="card p-6">
            <h2 className="text-lg font-medium text-gray-900 mb-4">Important Dates</h2>
            <div className="space-y-3">
              {component.manufacturing_date && (
                <div>
                  <label className="text-xs font-medium text-gray-500 uppercase tracking-wider">
                    Manufacturing Date
                  </label>
                  <div className="text-sm text-gray-900">
                    {format(new Date(component.manufacturing_date), 'MMM dd, yyyy')}
                  </div>
                </div>
              )}
              {component.dispatch_date && (
                <div>
                  <label className="text-xs font-medium text-gray-500 uppercase tracking-wider">
                    Dispatch Date
                  </label>
                  <div className="text-sm text-gray-900">
                    {format(new Date(component.dispatch_date), 'MMM dd, yyyy')}
                  </div>
                </div>
              )}
              {component.receiving_date && (
                <div>
                  <label className="text-xs font-medium text-gray-500 uppercase tracking-wider">
                    Receiving Date
                  </label>
                  <div className="text-sm text-gray-900">
                    {format(new Date(component.receiving_date), 'MMM dd, yyyy')}
                  </div>
                </div>
              )}
              {component.installation_date && (
                <div>
                  <label className="text-xs font-medium text-gray-500 uppercase tracking-wider">
                    Installation Date
                  </label>
                  <div className="text-sm text-gray-900">
                    {format(new Date(component.installation_date), 'MMM dd, yyyy')}
                  </div>
                </div>
              )}
              {component.warranty_start_date && (
                <div>
                  <label className="text-xs font-medium text-gray-500 uppercase tracking-wider">
                    Warranty Start
                  </label>
                  <div className="text-sm text-gray-900">
                    {format(new Date(component.warranty_start_date), 'MMM dd, yyyy')}
                  </div>
                </div>
              )}
              {component.warranty_end_date && (
                <div>
                  <label className="text-xs font-medium text-gray-500 uppercase tracking-wider">
                    Warranty End
                  </label>
                  <div className="text-sm text-gray-900">
                    {format(new Date(component.warranty_end_date), 'MMM dd, yyyy')}
                  </div>
                </div>
              )}
            </div>
          </div>

          {/* Quick Actions */}
          <div className="card p-6">
            <h2 className="text-lg font-medium text-gray-900 mb-4">Quick Actions</h2>
            <div className="space-y-2">
              <button className="btn-primary w-full text-sm">
                Record Inspection
              </button>
              <button className="btn-secondary w-full text-sm">
                Update Status
              </button>
              <button className="btn-secondary w-full text-sm">
                View History
              </button>
              <button className="btn-secondary w-full text-sm">
                Generate Report
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ComponentDetail;
