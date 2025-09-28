import React from 'react';
import { useQuery } from '@tanstack/react-query';
import { vendorsAPI } from '../services/api';

const Vendors: React.FC = () => {
  const { data: vendors, isLoading } = useQuery({
    queryKey: ['vendors'],
    queryFn: () => vendorsAPI.getAll().then(res => res.data),
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
        <h1 className="text-2xl font-bold text-gray-900">Vendors</h1>
        <p className="mt-1 text-sm text-gray-600">Manage vendor information and performance</p>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
        {vendors?.map((vendor: any) => (
          <div key={vendor.id} className="card p-6">
            <div className="flex items-center justify-between mb-4">
              <h3 className="text-lg font-medium text-gray-900">{vendor.name}</h3>
              <span className="text-sm text-gray-500">{vendor.vendor_code}</span>
            </div>
            <div className="space-y-2">
              <div className="text-sm">
                <span className="text-gray-500">Contact:</span> {vendor.contact_person || 'N/A'}
              </div>
              <div className="text-sm">
                <span className="text-gray-500">Phone:</span> {vendor.phone || 'N/A'}
              </div>
              <div className="text-sm">
                <span className="text-gray-500">Quality Rating:</span> {vendor.quality_rating}/5.0
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Vendors;
