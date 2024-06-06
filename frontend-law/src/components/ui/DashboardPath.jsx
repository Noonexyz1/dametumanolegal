import { Routes, Route, Navigate } from "react-router-dom";
import Dashboard from "./Dashboard";
import Form from "./Form";
import DataTableResults from "./DataTableResults";
import CardsAndStats from "./CardsAndStats";

export default function DashboardPath() {
  return (
    <Routes>
      <Route path="/" element={<Dashboard />}>
        
        {/* Redirigir de "/dash" a "/dash/tab" */}
        <Route index element={<Navigate to="stat" />} />

        <Route path="stat" element={<CardsAndStats />} />
        <Route path="form" element={<Form />} />
        <Route path="tab" element={<DataTableResults />} />
        <Route path="*" element={<div>404 característica no implementada</div>} />
      </Route>
    </Routes>
  );
}