import React, { useState, useEffect } from 'react';
import axios from 'axios';

export default function App() {
  const [persons, setPersons] = useState([]);
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');

  const loadData = async () => {
    try {
      const res = await axios.get('/api/persons');
      setPersons(res.data);
    } catch {}
  };

  useEffect(() => { loadData(); }, []);

  const submit = async (e) => {
    e.preventDefault();
    await axios.post('/api/persons', { name, email });
    setName('');
    setEmail('');
    loadData();
  };

  return (
    <div style={{ padding: 20 }}>
      <h1>Person Manager</h1>
      <form onSubmit={submit}>
        <input value={name} onChange={(e) => setName(e.target.value)} placeholder="Name" />
        <input value={email} onChange={(e) => setEmail(e.target.value)} placeholder="Email" />
        <button type="submit">Add</button>
      </form>
      <ul>
        {persons.map((p) => (
          <li key={p.id}>{p.name} — {p.email}</li>
        ))}
      </ul>
    </div>
  );
}

