import React from 'react';
import { useQuery } from '@tanstack/react-query';
import {
  CubeIcon,
  BuildingStorefrontIcon,
  ClipboardDocumentCheckIcon,
  ExclamationTriangleIcon,
} from '@heroicons/react/24/outline';
import {
  BarChart,
  Bar,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  ResponsiveContainer,
  PieChart,
  Pie,
  Cell,
  LineChart,
  Line,
} from 'recharts';
import { analyticsAPI } from '../services/api';

const Dashboard: React.FC = () => {
  const { data: dashboardData, isLoading } = useQuery({
    queryKey: ['dashboard'],
    queryFn: () => analyticsAPI.getDashboard().then(res => res.data),
  });

  if (isLoading) {
    return (
      <div className="flex items-center justify-center h-64">
        <div className="animate-spin rounded-full h-12 w-12 border-b-2 border-railway-blue"></div>
      </div>
    );
  }

  const stats = [
    {
      name: 'Total Components',
      stat: dashboardData?.total_components?.toLocaleString() || '0',
      icon: CubeIcon,
      color: 'bg-blue-500',
    },
    {
      name: 'Active Vendors',
      stat: dashboardData?.vendor_count?.toString() || '0',
      icon: BuildingStorefrontIcon,
      color: 'bg-green-500',
    },
    {
      name: 'Recent Inspections',
      stat: dashboardData?.recent_inspections?.toString() || '0',
      icon: ClipboardDocumentCheckIcon,
      color: 'bg-yellow-500',
    },
    {
      name: 'Failed Components',
      stat: dashboardData?.failed_components?.toString() || '0',
      icon: ExclamationTriangleIcon,
      color: 'bg-red-500',
    },
  ];

  // Prepare chart data
  const componentTypeData = dashboardData?.components_by_type
    ? Object.entries(dashboardData.components_by_type).map(([key, value]) => ({
        name: key.replace('_', ' ').replace(/\b\w/g, (l: string) => l.toUpperCase()),
        value: value as number,
      }))
    : [];

  const componentStatusData = dashboardData?.components_by_status
    ? Object.entries(dashboardData.components_by_status).map(([key, value]) => ({
        name: key.replace('_', ' ').replace(/\b\w/g, (l: string) => l.toUpperCase()),
        count: value as number,
      }))
    : [];

  const COLORS = ['#1e40af', '#16a34a', '#ea580c', '#dc2626', '#7c3aed', '#0891b2'];

  return (
    <div className="space-y-6">
      {/* Header */}
      <div className="border-b border-gray-200 pb-4">
        <h1 className="text-2xl font-bold text-gray-900">Dashboard</h1>
        <p className="mt-1 text-sm text-gray-600">
          Overview of track fittings management system
        </p>
      </div>

      {/* Stats */}
      <div className="grid grid-cols-1 gap-5 sm:grid-cols-2 lg:grid-cols-4">
        {stats.map((item) => (
          <div key={item.name} className="card p-5">
            <div className="flex items-center">
              <div className="flex-shrink-0">
                <div className={`w-8 h-8 rounded-md ${item.color} flex items-center justify-center`}>
                  <item.icon className="w-5 h-5 text-white" />
                </div>
              </div>
              <div className="ml-4">
                <dt className="text-sm font-medium text-gray-500 truncate">
                  {item.name}
                </dt>
                <dd className="text-2xl font-semibold text-gray-900">
                  {item.stat}
                </dd>
              </div>
            </div>
          </div>
        ))}
      </div>

      {/* Charts */}
      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
        {/* Component Types Distribution */}
        <div className="card p-6">
          <h3 className="text-lg font-medium text-gray-900 mb-4">
            Component Types Distribution
          </h3>
          <div className="h-64">
            <ResponsiveContainer width="100%" height="100%">
              <PieChart>
                <Pie
                  data={componentTypeData}
                  cx="50%"
                  cy="50%"
                  labelLine={false}
                  label={({ name, percent }) => `${name} ${(percent * 100).toFixed(0)}%`}
                  outerRadius={80}
                  fill="#8884d8"
                  dataKey="value"
                >
                  {componentTypeData.map((entry, index) => (
                    <Cell key={`cell-${index}`} fill={COLORS[index % COLORS.length]} />
                  ))}
                </Pie>
                <Tooltip />
              </PieChart>
            </ResponsiveContainer>
          </div>
        </div>

        {/* Component Status */}
        <div className="card p-6">
          <h3 className="text-lg font-medium text-gray-900 mb-4">
            Component Status Overview
          </h3>
          <div className="h-64">
            <ResponsiveContainer width="100%" height="100%">
              <BarChart data={componentStatusData}>
                <CartesianGrid strokeDasharray="3 3" />
                <XAxis 
                  dataKey="name" 
                  angle={-45}
                  textAnchor="end"
                  height={80}
                  fontSize={12}
                />
                <YAxis />
                <Tooltip />
                <Bar dataKey="count" fill="#1e40af" />
              </BarChart>
            </ResponsiveContainer>
          </div>
        </div>
      </div>

      {/* Quality Rating */}
      <div className="card p-6">
        <div className="flex items-center justify-between mb-4">
          <h3 className="text-lg font-medium text-gray-900">
            System Health Metrics
          </h3>
          <span className="text-sm text-gray-500">Last 30 days</span>
        </div>
        <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
          <div className="text-center">
            <div className="text-3xl font-bold text-green-600">
              {dashboardData?.average_quality_rating?.toFixed(1) || '0.0'}
            </div>
            <div className="text-sm text-gray-500 mt-1">Average Quality Rating</div>
            <div className="w-full bg-gray-200 rounded-full h-2 mt-2">
              <div
                className="bg-green-600 h-2 rounded-full"
                style={{
                  width: `${((dashboardData?.average_quality_rating || 0) / 5) * 100}%`,
                }}
              ></div>
            </div>
          </div>
          <div className="text-center">
            <div className="text-3xl font-bold text-blue-600">
              {(((dashboardData?.total_components || 0) - (dashboardData?.failed_components || 0)) / (dashboardData?.total_components || 1) * 100).toFixed(1)}%
            </div>
            <div className="text-sm text-gray-500 mt-1">Success Rate</div>
            <div className="w-full bg-gray-200 rounded-full h-2 mt-2">
              <div
                className="bg-blue-600 h-2 rounded-full"
                style={{
                  width: `${((dashboardData?.total_components || 0) - (dashboardData?.failed_components || 0)) / (dashboardData?.total_components || 1) * 100}%`,
                }}
              ></div>
            </div>
          </div>
          <div className="text-center">
            <div className="text-3xl font-bold text-yellow-600">
              {dashboardData?.recent_inspections || 0}
            </div>
            <div className="text-sm text-gray-500 mt-1">Recent Inspections</div>
            <div className="w-full bg-gray-200 rounded-full h-2 mt-2">
              <div className="bg-yellow-600 h-2 rounded-full w-3/4"></div>
            </div>
          </div>
        </div>
      </div>

      {/* Quick Actions */}
      <div className="card p-6">
        <h3 className="text-lg font-medium text-gray-900 mb-4">Quick Actions</h3>
        <div className="grid grid-cols-1 md:grid-cols-4 gap-4">
          <button 
            className="btn-primary text-center py-3"
            onClick={() => window.location.href = '/components'}
          >
            Add New Component
          </button>
          <button 
            className="btn-secondary text-center py-3"
            onClick={() => window.location.href = '/qr-generator'}
          >
            Generate QR Codes
          </button>
          <button 
            className="btn-secondary text-center py-3"
            onClick={() => window.location.href = '/inspections'}
          >
            Schedule Inspection
          </button>
          <button 
            className="btn-secondary text-center py-3"
            onClick={() => window.location.href = '/analytics'}
          >
            View Analytics
          </button>
        </div>
      </div>
    </div>
  );
};

export default Dashboard;
