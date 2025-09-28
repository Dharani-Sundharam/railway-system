import React from 'react';
import { XMarkIcon, DocumentTextIcon, PrinterIcon, ArrowDownTrayIcon } from '@heroicons/react/24/outline';

interface ReportModalProps {
  isOpen: boolean;
  onClose: () => void;
  report: {
    component_id: string;
    generated_at: string;
    report_content: string;
    component_summary: {
      serial_id: string;
      type: string;
      status: string;
      vendor: string;
      location: string;
      total_inspections: number;
      last_inspection?: string;
    };
  } | null;
  isLoading?: boolean;
}

const ReportModal: React.FC<ReportModalProps> = ({ isOpen, onClose, report, isLoading }) => {
  if (!isOpen) return null;

  const handlePrint = () => {
    window.print();
  };

  const handleDownload = () => {
    if (!report) return;
    
    const element = document.createElement('a');
    const file = new Blob([report.report_content], { type: 'text/plain' });
    element.href = URL.createObjectURL(file);
    element.download = `component-report-${report.component_id}-${new Date().toISOString().split('T')[0]}.txt`;
    document.body.appendChild(element);
    element.click();
    document.body.removeChild(element);
  };

  return (
    <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50 p-4">
      <div className="bg-white rounded-lg shadow-xl max-w-4xl w-full max-h-[90vh] flex flex-col">
        {/* Header */}
        <div className="flex items-center justify-between p-6 border-b border-gray-200">
          <div className="flex items-center space-x-3">
            <DocumentTextIcon className="w-6 h-6 text-railway-blue" />
            <div>
              <h2 className="text-xl font-semibold text-gray-900">
                Component Report
              </h2>
              {report && (
                <p className="text-sm text-gray-600">
                  {report.component_summary.serial_id} - Generated on {new Date(report.generated_at).toLocaleDateString()}
                </p>
              )}
            </div>
          </div>
          <div className="flex items-center space-x-2">
            {report && (
              <>
                <button
                  onClick={handlePrint}
                  className="p-2 text-gray-600 hover:text-gray-900 hover:bg-gray-100 rounded-lg transition-colors"
                  title="Print Report"
                >
                  <PrinterIcon className="w-5 h-5" />
                </button>
                <button
                  onClick={handleDownload}
                  className="p-2 text-gray-600 hover:text-gray-900 hover:bg-gray-100 rounded-lg transition-colors"
                  title="Download Report"
                >
                  <ArrowDownTrayIcon className="w-5 h-5" />
                </button>
              </>
            )}
            <button
              onClick={onClose}
              className="p-2 text-gray-600 hover:text-gray-900 hover:bg-gray-100 rounded-lg transition-colors"
            >
              <XMarkIcon className="w-5 h-5" />
            </button>
          </div>
        </div>

        {/* Content */}
        <div className="flex-1 overflow-y-auto p-6">
          {isLoading ? (
            <div className="flex items-center justify-center h-64">
              <div className="text-center">
                <div className="animate-spin rounded-full h-12 w-12 border-b-2 border-railway-blue mx-auto mb-4"></div>
                <p className="text-gray-600">Generating AI-powered report...</p>
                <p className="text-sm text-gray-500 mt-2">This may take a few moments</p>
              </div>
            </div>
          ) : report ? (
            <div className="space-y-6">
              {/* Component Summary */}
              <div className="bg-gray-50 rounded-lg p-4">
                <h3 className="text-lg font-semibold text-gray-900 mb-3">Component Summary</h3>
                <div className="grid grid-cols-2 md:grid-cols-3 gap-4 text-sm">
                  <div>
                    <span className="font-medium text-gray-700">Serial ID:</span>
                    <p className="text-gray-900">{report.component_summary.serial_id}</p>
                  </div>
                  <div>
                    <span className="font-medium text-gray-700">Type:</span>
                    <p className="text-gray-900">{report.component_summary.type}</p>
                  </div>
                  <div>
                    <span className="font-medium text-gray-700">Status:</span>
                    <p className="text-gray-900">{report.component_summary.status}</p>
                  </div>
                  <div>
                    <span className="font-medium text-gray-700">Vendor:</span>
                    <p className="text-gray-900">{report.component_summary.vendor}</p>
                  </div>
                  <div>
                    <span className="font-medium text-gray-700">Location:</span>
                    <p className="text-gray-900">{report.component_summary.location}</p>
                  </div>
                  <div>
                    <span className="font-medium text-gray-700">Inspections:</span>
                    <p className="text-gray-900">{report.component_summary.total_inspections}</p>
                  </div>
                </div>
              </div>

              {/* AI Generated Report */}
              <div className="prose max-w-none">
                <h3 className="text-lg font-semibold text-gray-900 mb-3">AI Generated Report</h3>
                <div className="bg-white border border-gray-200 rounded-lg p-4">
                  <pre className="whitespace-pre-wrap text-sm text-gray-800 font-sans leading-relaxed">
                    {report.report_content}
                  </pre>
                </div>
              </div>
            </div>
          ) : (
            <div className="text-center py-12">
              <DocumentTextIcon className="w-12 h-12 text-gray-400 mx-auto mb-4" />
              <p className="text-gray-600">No report data available</p>
            </div>
          )}
        </div>

        {/* Footer */}
        <div className="border-t border-gray-200 p-6">
          <div className="flex justify-end space-x-3">
            <button
              onClick={onClose}
              className="px-4 py-2 text-gray-700 bg-gray-100 hover:bg-gray-200 rounded-lg transition-colors"
            >
              Close
            </button>
            {report && (
              <button
                onClick={handleDownload}
                className="px-4 py-2 bg-railway-blue text-white hover:bg-blue-700 rounded-lg transition-colors flex items-center space-x-2"
              >
                <ArrowDownTrayIcon className="w-4 h-4" />
                <span>Download Report</span>
              </button>
            )}
          </div>
        </div>
      </div>
    </div>
  );
};

export default ReportModal;
