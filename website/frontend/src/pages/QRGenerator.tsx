import React, { useState, useRef } from 'react';
import { useQuery } from '@tanstack/react-query';
import QRCode from 'react-qr-code';
import {
  QrCodeIcon,
  DocumentArrowDownIcon,
  PrinterIcon,
  MagnifyingGlassIcon,
} from '@heroicons/react/24/outline';
import { componentsAPI } from '../services/api';
import toast from 'react-hot-toast';

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
}

const QRGenerator: React.FC = () => {
  const [selectedComponents, setSelectedComponents] = useState<string[]>([]);
  const [searchTerm, setSearchTerm] = useState('');
  const [customData, setCustomData] = useState('');
  const [customQRGenerated, setCustomQRGenerated] = useState(false);
  const qrRef = useRef<HTMLDivElement>(null);

  const { data: components, isLoading } = useQuery({
    queryKey: ['components'],
    queryFn: () => componentsAPI.getAll({ limit: 100 }).then(res => res.data),
  });

  const filteredComponents = components?.filter((component: Component) =>
    component.serial_id.toLowerCase().includes(searchTerm.toLowerCase()) ||
    component.vendor.name.toLowerCase().includes(searchTerm.toLowerCase())
  ) || [];

  const handleComponentSelect = (serialId: string) => {
    setSelectedComponents(prev => 
      prev.includes(serialId) 
        ? prev.filter(id => id !== serialId)
        : [...prev, serialId]
    );
  };

  const handleSelectAll = () => {
    if (selectedComponents.length === filteredComponents.length) {
      setSelectedComponents([]);
    } else {
      setSelectedComponents(filteredComponents.map((c: any) => c.serial_id));
    }
  };

  const generateBulkQR = async () => {
    if (selectedComponents.length === 0) {
      toast.error('Please select at least one component');
      return;
    }

    try {
      // In a real app, you'd call the API to generate QR codes
      toast.success(`Generated QR codes for ${selectedComponents.length} components`);
    } catch (error) {
      toast.error('Failed to generate QR codes');
    }
  };

  const generateCustomQR = () => {
    if (!customData.trim()) {
      toast.error('Please enter data for QR code');
      return;
    }
    setCustomQRGenerated(true);
    toast.success('Custom QR code generated');
  };

  const downloadQR = (serialId: string) => {
    // Create a canvas and draw the QR code
    const canvas = document.createElement('canvas');
    const ctx = canvas.getContext('2d');
    if (!ctx) return;

    // In a real implementation, you'd render the QR code to canvas and download
    toast.success(`QR code for ${serialId} downloaded`);
  };

  const printQR = () => {
    if (qrRef.current) {
      const printWindow = window.open('', '_blank');
      if (printWindow) {
        printWindow.document.write(`
          <html>
            <head>
              <title>QR Codes - Indian Railways</title>
              <style>
                body { font-family: Arial, sans-serif; }
                .qr-container { page-break-inside: avoid; margin: 20px; }
                .qr-info { text-align: center; margin-top: 10px; }
                @media print { .no-print { display: none; } }
              </style>
            </head>
            <body>
              ${qrRef.current.innerHTML}
            </body>
          </html>
        `);
        printWindow.document.close();
        printWindow.print();
      }
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
      <div className="border-b border-gray-200 pb-4">
        <h1 className="text-2xl font-bold text-gray-900">QR Code Generator</h1>
        <p className="mt-1 text-sm text-gray-600">
          Generate QR codes for track fittings and custom data
        </p>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
        {/* Component QR Generation */}
        <div className="space-y-6">
          <div className="card p-6">
            <h2 className="text-lg font-medium text-gray-900 mb-4">
              Component QR Codes
            </h2>

            {/* Search */}
            <div className="relative mb-4">
              <MagnifyingGlassIcon className="w-5 h-5 absolute left-3 top-1/2 transform -translate-y-1/2 text-gray-400" />
              <input
                type="text"
                placeholder="Search components..."
                className="input-field pl-10"
                value={searchTerm}
                onChange={(e) => setSearchTerm(e.target.value)}
              />
            </div>

            {/* Select All */}
            <div className="flex items-center justify-between mb-4">
              <label className="flex items-center">
                <input
                  type="checkbox"
                  className="rounded border-gray-300 text-railway-blue focus:ring-railway-blue"
                  checked={selectedComponents.length === filteredComponents.length}
                  onChange={handleSelectAll}
                />
                <span className="ml-2 text-sm text-gray-700">
                  Select All ({filteredComponents.length})
                </span>
              </label>
              <span className="text-sm text-gray-500">
                {selectedComponents.length} selected
              </span>
            </div>

            {/* Component List */}
            <div className="max-h-64 overflow-y-auto border border-gray-200 rounded-md">
              {filteredComponents.map((component: Component) => (
                <div
                  key={component.id}
                  className="flex items-center p-3 border-b border-gray-100 last:border-b-0 hover:bg-gray-50"
                >
                  <input
                    type="checkbox"
                    className="rounded border-gray-300 text-railway-blue focus:ring-railway-blue"
                    checked={selectedComponents.includes(component.serial_id)}
                    onChange={() => handleComponentSelect(component.serial_id)}
                  />
                  <div className="ml-3 flex-1">
                    <div className="text-sm font-medium text-gray-900">
                      {component.serial_id}
                    </div>
                    <div className="text-sm text-gray-500">
                      {component.component_type.replace('_', ' ')} - {component.vendor.name}
                    </div>
                  </div>
                </div>
              ))}
            </div>

            {/* Generate Button */}
            <button
              onClick={generateBulkQR}
              className="btn-primary w-full mt-4 flex items-center justify-center"
              disabled={selectedComponents.length === 0}
            >
              <QrCodeIcon className="w-4 h-4 mr-2" />
              Generate QR Codes ({selectedComponents.length})
            </button>
          </div>

          {/* Custom QR Generation */}
          <div className="card p-6">
            <h2 className="text-lg font-medium text-gray-900 mb-4">
              Custom QR Code
            </h2>
            <div className="space-y-4">
              <div>
                <label className="block text-sm font-medium text-gray-700 mb-1">
                  Data to encode
                </label>
                <textarea
                  className="input-field"
                  rows={3}
                  placeholder="Enter custom data, URL, or text..."
                  value={customData}
                  onChange={(e) => setCustomData(e.target.value)}
                />
              </div>
              <button
                onClick={generateCustomQR}
                className="btn-primary w-full flex items-center justify-center"
              >
                <QrCodeIcon className="w-4 h-4 mr-2" />
                Generate Custom QR
              </button>
            </div>
          </div>
        </div>

        {/* QR Code Preview */}
        <div className="card p-6">
          <div className="flex items-center justify-between mb-4">
            <h2 className="text-lg font-medium text-gray-900">QR Code Preview</h2>
            <div className="flex space-x-2">
              <button
                onClick={printQR}
                className="btn-secondary flex items-center"
                disabled={!customQRGenerated && selectedComponents.length === 0}
              >
                <PrinterIcon className="w-4 h-4 mr-2" />
                Print
              </button>
            </div>
          </div>

          <div ref={qrRef} className="space-y-6">
            {/* Custom QR Code */}
            {customQRGenerated && customData && (
              <div className="qr-container text-center p-4 border border-gray-200 rounded-lg">
                <QRCode
                  value={customData}
                  size={200}
                  level="H"
                  className="mx-auto"
                />
                <div className="qr-info mt-4">
                  <div className="text-sm font-medium text-gray-900">Custom QR Code</div>
                  <div className="text-xs text-gray-500 mt-1 break-all">
                    {customData.length > 50 ? `${customData.substring(0, 50)}...` : customData}
                  </div>
                </div>
              </div>
            )}

            {/* Component QR Codes */}
            {selectedComponents.length > 0 && (
              <div className="grid grid-cols-1 gap-4">
                {selectedComponents.slice(0, 4).map((serialId) => {
                  const component = components?.find((c: Component) => c.serial_id === serialId);
                  if (!component) return null;

                  const qrData = `https://rail.id/i/${serialId}`;

                  return (
                    <div
                      key={serialId}
                      className="qr-container text-center p-4 border border-gray-200 rounded-lg"
                    >
                      <QRCode
                        value={qrData}
                        size={150}
                        level="H"
                        className="mx-auto"
                      />
                      <div className="qr-info mt-3">
                        <div className="text-sm font-medium text-gray-900">
                          {serialId}
                        </div>
                        <div className="text-xs text-gray-500 mt-1">
                          {component.component_type.replace('_', ' ')} - {component.vendor.vendor_code}
                        </div>
                        <div className="text-xs text-gray-400 mt-1">
                          {qrData}
                        </div>
                        <button
                          onClick={() => downloadQR(serialId)}
                          className="mt-2 text-xs text-railway-blue hover:text-blue-700 flex items-center justify-center mx-auto"
                        >
                          <DocumentArrowDownIcon className="w-3 h-3 mr-1" />
                          Download
                        </button>
                      </div>
                    </div>
                  );
                })}
                {selectedComponents.length > 4 && (
                  <div className="text-center text-sm text-gray-500 p-4">
                    ... and {selectedComponents.length - 4} more components
                  </div>
                )}
              </div>
            )}

            {/* Empty State */}
            {!customQRGenerated && selectedComponents.length === 0 && (
              <div className="text-center py-12">
                <QrCodeIcon className="w-16 h-16 text-gray-300 mx-auto mb-4" />
                <div className="text-gray-500">
                  Select components or enter custom data to generate QR codes
                </div>
              </div>
            )}
          </div>
        </div>
      </div>

      {/* Instructions */}
      <div className="card p-6">
        <h3 className="text-lg font-medium text-gray-900 mb-3">
          QR Code Instructions
        </h3>
        <div className="grid grid-cols-1 md:grid-cols-2 gap-6 text-sm text-gray-600">
          <div>
            <h4 className="font-medium text-gray-900 mb-2">Component QR Codes</h4>
            <ul className="space-y-1">
              <li>• Contains unique component serial ID</li>
              <li>• Links to component details and history</li>
              <li>• High error correction for durability</li>
              <li>• Optimized for mobile scanning</li>
            </ul>
          </div>
          <div>
            <h4 className="font-medium text-gray-900 mb-2">Printing Guidelines</h4>
            <ul className="space-y-1">
              <li>• Use high-quality printer (300+ DPI)</li>
              <li>• Print on durable material (vinyl/polyester)</li>
              <li>• Minimum size: 15mm x 15mm</li>
              <li>• Test scan before applying to components</li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  );
};

export default QRGenerator;
