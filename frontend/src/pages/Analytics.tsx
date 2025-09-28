import React from 'react';
import { useQuery } from '@tanstack/react-query';
import { analyticsAPI } from '../services/api';
import { BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, ResponsiveContainer } from 'recharts';

const Analytics: React.FC = () => {
  const { data: vendorPerformance, isLoading } = useQuery({
    queryKey: ['vendor-performance'],
    queryFn: () => analyticsAPI.getVendorPerformance().then(res => res.data),
  });

  if (isLoading) {
    return (
      <div className="flex items-center justify-center h-64">
        <div className="animate-spin rounded-full h-12 w-12 border-b-2 border-railway-blue"></div>
      </div>
    );
  }

  return (
    <div className="space-y-6">
      <div className="border-b border-gray-200 pb-4">
        <h1 className="text-2xl font-bold text-gray-900">Analytics</h1>
        <p className="mt-1 text-sm text-gray-600">Performance insights and trends</p>
      </div>

      <div className="card p-6">
        <h2 className="text-lg font-medium text-gray-900 mb-4">Vendor Performance</h2>
        <div className="h-64">
          <ResponsiveContainer width="100%" height="100%">
            <BarChart data={vendorPerformance}>
              <CartesianGrid strokeDasharray="3 3" />
              <XAxis dataKey="vendor_name" />
              <YAxis />
              <Tooltip />
              <Bar dataKey="failure_rate" fill="#dc2626" name="Failure Rate %" />
            </BarChart>
          </ResponsiveContainer>
        </div>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
        <div className="card p-6">
          <h3 className="text-lg font-medium text-gray-900 mb-4">Top Performing Vendors</h3>
          <div className="space-y-3">
            {vendorPerformance?.slice(0, 5).map((vendor: any, index: number) => (
              <div key={vendor.vendor_id} className="flex items-center justify-between">
                <div>
                  <div className="text-sm font-medium text-gray-900">{vendor.vendor_name}</div>
                  <div className="text-xs text-gray-500">{vendor.vendor_code}</div>
                </div>
                <div className="text-right">
                  <div className="text-sm font-medium text-green-600">
                    {(100 - vendor.failure_rate).toFixed(1)}% Success
                  </div>
                  <div className="text-xs text-gray-500">
                    {vendor.total_components} components
                  </div>
                </div>
              </div>
            ))}
          </div>
        </div>

        <div className="card p-6">
          <h3 className="text-lg font-medium text-gray-900 mb-4">Quality Ratings</h3>
          <div className="space-y-3">
            {vendorPerformance?.slice(0, 5).map((vendor: any) => (
              <div key={vendor.vendor_id} className="flex items-center justify-between">
                <div className="text-sm font-medium text-gray-900">{vendor.vendor_name}</div>
                <div className="flex items-center">
                  <div className="text-sm text-gray-900 mr-2">{vendor.quality_rating}/5.0</div>
                  <div className="w-16 bg-gray-200 rounded-full h-2">
                    <div
                      className="bg-railway-blue h-2 rounded-full"
                      style={{ width: `${(vendor.quality_rating / 5) * 100}%` }}
                    ></div>
                  </div>
                </div>
              </div>
            ))}
          </div>
        </div>
      </div>
    </div>
  );
};

export default Analytics;
