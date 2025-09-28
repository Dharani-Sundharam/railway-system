import React, { createContext, useContext, useState, useEffect, ReactNode } from 'react';
import { api } from '../services/api';

interface User {
  id: number;
  username: string;
  email: string;
  full_name: string;
  role: string;
  is_active: boolean;
}

interface AuthContextType {
  user: User | null;
  login: (username: string, password: string) => Promise<void>;
  bypassLogin: () => Promise<void>;
  logout: () => void;
  loading: boolean;
}

const AuthContext = createContext<AuthContextType | undefined>(undefined);

export const useAuth = () => {
  const context = useContext(AuthContext);
  if (context === undefined) {
    throw new Error('useAuth must be used within an AuthProvider');
  }
  return context;
};

interface AuthProviderProps {
  children: ReactNode;
}

export const AuthProvider: React.FC<AuthProviderProps> = ({ children }) => {
  const [user, setUser] = useState<User | null>(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // Auto-login as admin user (no authentication required)
    setUser({
      id: 1,
      username: 'admin',
      email: 'admin@indianrailways.gov.in',
      full_name: 'System Administrator',
      role: 'admin',
      is_active: true
    });
    setLoading(false);
  }, []);

  const login = async (username: string, password: string) => {
    try {
      const response = await api.post('/api/auth/login', { username, password });
      const { access_token } = response.data;
      
      localStorage.setItem('token', access_token);
      api.defaults.headers.common['Authorization'] = `Bearer ${access_token}`;
      
      // Set user data (in a real app, you'd get this from the token or a separate API call)
      setUser({
        id: 1,
        username,
        email: `${username}@indianrailways.gov.in`,
        full_name: username === 'admin' ? 'System Administrator' : username,
        role: username === 'admin' ? 'admin' : 'inspector',
        is_active: true
      });
    } catch (error) {
      throw error;
    }
  };

  const bypassLogin = async () => {
    try {
      const response = await api.get('/api/test-login');
      const { access_token } = response.data;
      
      localStorage.setItem('token', access_token);
      api.defaults.headers.common['Authorization'] = `Bearer ${access_token}`;
      
      // Set user data for admin user
      setUser({
        id: 1,
        username: 'admin',
        email: 'admin@indianrailways.gov.in',
        full_name: 'System Administrator',
        role: 'admin',
        is_active: true
      });
    } catch (error) {
      throw error;
    }
  };

  const logout = () => {
    localStorage.removeItem('token');
    delete api.defaults.headers.common['Authorization'];
    setUser(null);
  };

  const value = {
    user,
    login,
    bypassLogin,
    logout,
    loading
  };

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
};
