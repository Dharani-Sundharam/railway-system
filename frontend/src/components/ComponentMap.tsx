import React from 'react';
import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet';
import L from 'leaflet';
import 'leaflet/dist/leaflet.css';

// Fix for default markers in react-leaflet
delete (L.Icon.Default.prototype as any)._getIconUrl;
L.Icon.Default.mergeOptions({
  iconRetinaUrl: 'https://unpkg.com/leaflet@1.7.1/dist/images/marker-icon-2x.png',
  iconUrl: 'https://unpkg.com/leaflet@1.7.1/dist/images/marker-icon.png',
  shadowUrl: 'https://unpkg.com/leaflet@1.7.1/dist/images/marker-shadow.png',
});

interface ComponentMapProps {
  latitude: number;
  longitude: number;
  componentId: string;
  location?: string;
  height?: string;
}

const ComponentMap: React.FC<ComponentMapProps> = ({ 
  latitude, 
  longitude, 
  componentId, 
  location,
  height = "300px" 
}) => {
  return (
    <div style={{ height, width: '100%' }} className="rounded-lg overflow-hidden border border-gray-200">
      <MapContainer
        center={[latitude, longitude]}
        zoom={15}
        style={{ height: '100%', width: '100%' }}
        scrollWheelZoom={true}
      >
        <TileLayer
          attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
          url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
        />
        <Marker position={[latitude, longitude]}>
          <Popup>
            <div className="p-2">
              <h3 className="font-semibold text-gray-900">Component Location</h3>
              <p className="text-sm text-gray-600 mt-1">
                <strong>ID:</strong> {componentId}
              </p>
              {location && (
                <p className="text-sm text-gray-600">
                  <strong>Location:</strong> {location}
                </p>
              )}
              <p className="text-sm text-gray-600">
                <strong>Coordinates:</strong> {latitude.toFixed(6)}, {longitude.toFixed(6)}
              </p>
            </div>
          </Popup>
        </Marker>
      </MapContainer>
    </div>
  );
};

export default ComponentMap;
