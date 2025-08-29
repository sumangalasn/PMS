import React, { useEffect, useState } from 'react';
import api from '../../api/api';
import '../../styles/table.css';

export default function EmployeeList() {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    api.get('/employees').then(res => setEmployees(res.data));
  }, []);

  return (
    <div className="table-container">
      <h2>Employees</h2>
      <table className="styled-table">
        <thead>
          <tr><th>ID</th><th>Name</th><th>Email</th><th>Role</th></tr>
        </thead>
        <tbody>
          {employees.map(e => (
            <tr key={e.id}>
              <td>{e.id}</td><td>{e.name}</td><td>{e.email}</td><td>{e.role}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}