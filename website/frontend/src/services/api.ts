import axios from 'axios';

const API_BASE_URL = process.env.REACT_APP_API_URL || 'http://localhost:8000';

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
    api.post('/auth/login', credentials),
};

export const componentsAPI = {
  getAll: (params?: { skip?: number; limit?: number }) =>
    api.get('/components/', { params }),
  getById: (id: string) => api.get(`/components/${id}`),
  create: (data: any) => api.post('/components/', data),
  generateQR: (id: string) => api.post(`/components/${id}/qr`),
  bulkCreate: (data: any[]) => api.post('/components/bulk-create', data),
};

export const vendorsAPI = {
  getAll: (params?: { skip?: number; limit?: number }) =>
    api.get('/vendors/', { params }),
  create: (data: any) => api.post('/vendors/', data),
};

export const inspectionsAPI = {
  getAll: (params?: { skip?: number; limit?: number }) =>
    api.get('/inspections/', { params }),
  create: (data: any) => api.post('/inspections/', data),
};

export const analyticsAPI = {
  getDashboard: () => api.get('/analytics/dashboard'),
  getVendorPerformance: () => api.get('/analytics/vendor-performance'),
  getComponentLifecycle: (id: string) =>
    api.get(`/analytics/component-lifecycle/${id}`),
};

export const scanAPI = {
  scan: (id: string, data: any) => api.post(`/scan/${id}`, data),
};
