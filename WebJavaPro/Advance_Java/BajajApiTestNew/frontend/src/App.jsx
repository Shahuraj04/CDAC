import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Select from 'react-select';
import './App.css';

const API_URL = 'http://localhost:8081/test';

const options = [
  { value: 'alphabets', label: 'Alphabets' },
  { value: 'numbers', label: 'Numbers' },
  { value: 'highest_lowercase', label: 'Highest lowercase alphabet' }
];

const customStyles = {
  control: (base, state) => ({
    ...base,
    background: 'rgba(15, 23, 42, 0.5)',
    borderColor: state.isFocused ? '#6366f1' : 'rgba(148, 163, 184, 0.2)',
    borderRadius: '12px',
    padding: '4px',
    '&:hover': {
      borderColor: '#6366f1'
    }
  }),
  menu: (base) => ({
    ...base,
    background: '#1e293b',
    border: '1px solid rgba(148, 163, 184, 0.2)',
    borderRadius: '12px'
  }),
  option: (base, state) => ({
    ...base,
    background: state.isSelected ? '#6366f1' : state.isFocused ? 'rgba(99, 102, 241, 0.1)' : 'transparent',
    color: '#f8fafc',
    '&:active': {
      background: '#6366f1'
    }
  }),
  multiValue: (base) => ({
    ...base,
    background: 'rgba(99, 102, 241, 0.2)',
    borderRadius: '8px'
  }),
  multiValueLabel: (base) => ({
    ...base,
    color: '#6366f1',
    fontWeight: '500'
  }),
  multiValueRemove: (base) => ({
    ...base,
    color: '#6366f1',
    '&:hover': {
      background: 'rgba(99, 102, 241, 0.3)',
      color: '#f43f5e'
    }
  })
};

function App() {
  const [jsonInput, setJsonInput] = useState('');
  const [error, setError] = useState('');
  const [responseData, setResponseData] = useState(null);
  const [selectedOptions, setSelectedOptions] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    // Set title as roll number (from backend DTO or hardcoded for now)
    document.title = "2580";
  }, []);

  const validateAndSubmit = async () => {
    try {
      const parsedJson = JSON.parse(jsonInput);
      if (!parsedJson.data || !Array.isArray(parsedJson.data)) {
        throw new Error('JSON Must contain a "data" array');
      }

      setError('');
      setLoading(true);

      const response = await axios.post(API_URL, parsedJson);
      setResponseData(response.data);
      if (response.data.roll_number) {
        document.title = response.data.roll_number;
      }
    } catch (err) {
      setError(err.message === 'Unexpected end of JSON input' ? 'Invalid JSON format' : err.message);
      setResponseData(null);
    } finally {
      setLoading(false);
    }
  };

  const renderSection = (key, label) => {
    if (!responseData || !responseData[key] || responseData[key].length === 0) return null;

    return (
      <div className="result-item" key={key}>
        <div className="result-label">{label}</div>
        <div className="result-values">
          {responseData[key].map((item, index) => (
            <span key={index} className="badge">{item}</span>
          ))}
        </div>
      </div>
    );
  };

  const filteredResponse = () => {
    if (!responseData || selectedOptions.length === 0) return null;

    return (
      <div className="result-card">
        {selectedOptions.find(o => o.value === 'alphabets') && renderSection('alphabets', 'Alphabets')}
        {selectedOptions.find(o => o.value === 'numbers') && renderSection('numbers', 'Numbers')}
        {selectedOptions.find(o => o.value === 'highest_lowercase') && renderSection('highest_lowercase', 'Highest Lowercase Alphabet')}
      </div>
    );
  };

  return (
    <div className="container">
      <h1>Data Processor</h1>

      <div className="input-group">
        <label>API Input (JSON)</label>
        <textarea
          className="json-input"
          placeholder='{ "data": ["A", "C", "z"] }'
          value={jsonInput}
          onChange={(e) => setJsonInput(e.target.value)}
        />
        {error && <div className="error-msg">{error}</div>}
      </div>

      <button
        className="submit-btn"
        onClick={validateAndSubmit}
        disabled={loading}
      >
        {loading ? 'Processing...' : 'Submit'}
      </button>

      {responseData && (
        <div className="response-section">
          <div className="select-group">
            <label>Filter Response</label>
            <Select
              isMulti
              options={options}
              styles={customStyles}
              onChange={setSelectedOptions}
              placeholder="Select categories to display..."
            />
          </div>

          {filteredResponse()}
        </div>
      )}

      {loading && (
        <div className="loader">
          <div className="dot-pulse"></div>
        </div>
      )}
    </div>
  );
}

export default App;
