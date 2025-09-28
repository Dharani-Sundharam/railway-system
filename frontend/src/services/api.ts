import axios from 'axios';

const API_BASE_URL = process.env.REACT_APP_API_URL || '';

export const api = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

// Request interceptor to add auth token
api.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem('token');
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

// Response interceptor to handle errors
api.interceptors.response.use(
  (response) => response,
  (error) => {
    if (error.response?.status === 401) {
      localStorage.removeItem('token');
      window.location.href = '/login';
    }
    return Promise.reject(error);
  }
);

// API endpoints
export const authAPI = {
  login: (credentials: { username: string; password: string }) =>
    api.post('/api/auth/login', credentials),
};

export const componentsAPI = {
  getAll: (params?: { skip?: number; limit?: number }) =>
    api.get('/api/components/', { params }),
  getById: (id: string) => api.get(`/api/components/${id}`),
  create: (data: any) => api.post('/api/components/', data),
  generateQR: (id: string) => api.post(`/api/components/${id}/qr`),
  bulkCreate: (data: any[]) => api.post('/api/components/bulk-create', data),
};

export const vendorsAPI = {
  getAll: (params?: { skip?: number; limit?: number }) =>
    api.get('/api/vendors/', { params }),
  create: (data: any) => api.post('/api/vendors/', data),
};

export const inspectionsAPI = {
  getAll: (params?: { skip?: number; limit?: number }) =>
    api.get('/api/inspections/', { params }),
  create: (data: any) => api.post('/api/inspections/', data),
};

export const analyticsAPI = {
  getDashboard: () => api.get('/api/analytics/dashboard'),
  getVendorPerformance: () => api.get('/api/analytics/vendor-performance'),
  getComponentLifecycle: (id: string) =>
    api.get(`/api/analytics/component-lifecycle/${id}`),
};

export const scanAPI = {
  scan: (id: string, data: any) => api.post(`/api/scan/${id}`, data),
};

export const reportsAPI = {
  generateComponentReport: (componentId: string) =>
    api.post(`/api/reports/component/${componentId}`),
  generateBulkReport: (componentIds: string[], reportType: string = 'individual') =>
    api.post('/api/reports/bulk', { component_ids: componentIds, report_type: reportType }),
  getComponentPreview: (componentId: string) =>
    api.get(`/api/reports/component/${componentId}/preview`),
};