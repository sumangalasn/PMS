import React, { useState } from 'react';
import api from '../../api/api';
import '../../styles/form.css';

export default function EmployeeForm() {
  const [employee, setEmployee] = useState({ name: '', email: '', role: '' });

  const handleSubmit = e => {
    e.preventDefault();
    api.post('/employees', employee).then(() => alert('Employee added!'));
  };

  return (
    <form className="styled-form" onSubmit={handleSubmit}>
      <h2>Add Employee</h2>
      <input type="text" placeholder="Name" value={employee.name}
        onChange={e => setEmployee({ ...employee, name: e.target.value })} />
      <input type="email" placeholder="Email" value={employee.email}
        onChange={e => setEmployee({ ...employee, email: e.target.value })} />
      <input type="text" placeholder="Role" value={employee.role}
        onChange={e => setEmployee({ ...employee, role: e.target.value })} />
      <button type="submit">Save</button>
      <button type="delete" onClick={() => setEmployee({ name: '', email: '', role: '' })}>Clear</button>
      <button type="update" onClick={() => alert('Update functionality not implemented yet')}>Update</button>
    </form>
  );
}