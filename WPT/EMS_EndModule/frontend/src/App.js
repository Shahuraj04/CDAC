import { BrowserRouter, Routes, Route } from "react-router-dom";
import EmployeeList from "./pages/EmployeeList";
import AddEmployee from "./pages/AddEmployee";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<AddEmployee />} />
        <Route path="/employees" element={<EmployeeList />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
