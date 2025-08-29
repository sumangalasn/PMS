import React, { useEffect, useState } from 'react';
import api from '../../api/api';
import '../../styles/table.css';

export default function ClientList() {
  const [clients, setClients] = useState([]);

  useEffect(() => {
    api.get('/clients').then(res => setClients(res.data));
  }, []);

  return (
    <div className="table-container">
      <h2>Clients</h2>
      <table className="styled-table">
        <thead><tr><th>ID</th><th>Name</th><th>Email</th></tr></thead>
        <tbody>
          {clients.map(c => (
            <tr key={c.id}><td>{c.id}</td><td>{c.name}</td><td>{c.email}</td></tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}