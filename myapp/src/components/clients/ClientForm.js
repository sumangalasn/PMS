import React, { useState } from 'react';
import api from '../../api/api';
import '../../styles/form.css';

export default function ClientForm() {
  const [client, setClient] = useState({ name: '', email: '' });

  const handleSubmit = e => {
    e.preventDefault();
    api.post('/clients', client).then(() => alert('Client added!'));
  };

  return (
    <form className="styled-form" onSubmit={handleSubmit}>
      <h2>Add Client</h2>
      <input type="text" placeholder="Name" value={client.name}
        onChange={e => setClient({ ...client, name: e.target.value })} />
      <input type="email" placeholder="Email" value={client.email}
        onChange={e => setClient({ ...client, email: e.target.value })} />
      <button type="submit">Save</button>
    </form>
  );
}