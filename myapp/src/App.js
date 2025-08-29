import React from 'react';
import EmployeeList from './components/employees/EmployeeList';
import EmployeeForm from './components/employees/EmployeeForm';
import ClientList from './components/clients/ClientList';
import ClientForm from './components/clients/ClientForm';
import ProjectList from './components/projects/ProjectList';
import ProjectForm from './components/projects/ProjectForm';
import './styles/global.css';

function App() {
  return (
    <div className="app-container">
      <h1>Project Management System Dashboard</h1>
      <div className="section">
        <EmployeeForm />
        <EmployeeList />
      </div>
      <div className="section">
        <ClientForm />
        <ClientList />
      </div>
      <div className="section">
        <ProjectForm />
        <ProjectList />
      </div>
    </div>
  );
}
export default App;