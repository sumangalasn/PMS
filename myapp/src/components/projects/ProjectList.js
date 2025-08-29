import React, { useEffect, useState } from 'react';
import api from '../../api/api';
import '../../styles/table.css';

export default function ProjectList() {
  const [projects, setProjects] = useState([]);

  useEffect(() => {
    api.get('/projects').then(res => setProjects(res.data));
  }, []);

  return (
    <div className="table-container">
      <h2>Projects</h2>
      <table className="styled-table">
        <thead><tr><th>ID</th><th>Name</th><th>Status</th></tr></thead>
        <tbody>
          {projects.map(p => (
            <tr key={p.id}><td>{p.id}</td><td>{p.name}</td><td>{p.status}</td></tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}