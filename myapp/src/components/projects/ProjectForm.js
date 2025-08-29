import React, { useState } from 'react';
import api from '../../api/api';
import '../../styles/form.css';

export default function ProjectForm() {
  const [project, setProject] = useState({ name: '', status: '' });

  const handleSubmit = e => {
    e.preventDefault();
    api.post('/projects', project).then(() => alert('Project added!'));
  };

  return (
    <form className="styled-form" onSubmit={handleSubmit}>
      <h2>Add Project</h2>
      <input type="text" placeholder="Name" value={project.name}
        onChange={e => setProject({ ...project, name: e.target.value })} />
      <input type="text" placeholder="Status" value={project.status}
        onChange={e => setProject({ ...project, status: e.target.value })} />
      <button type="submit">Save</button>
    </form>
  );
}