import React from 'react';
import DataTable from 'react-data-table-component';

const columns = [
  { name: 'Name', selector: row => row.name },
  { name: 'Email', selector: row => row.email },
  { name: 'Age', selector: row => row.age }
];

const data = [
  { id: 1, name: 'Mi Nombre', email: 'asdfasdf@gmail.com', age: 23 },
  { id: 2, name: 'Mi Nombre', email: 'asdfasdf@gmail.com', age: 23 },
  { id: 3, name: 'Mi Nombre', email: 'asdfasdf@gmail.com', age: 23 },
  { id: 4, name: 'Mi Nombre', email: 'asdfasdf@gmail.com', age: 23 },
  { id: 5, name: 'Mi Nombre', email: 'asdfasdf@gmail.com', age: 23 },
  { id: 6, name: 'Mi Nombre', email: 'asdfasdf@gmail.com', age: 23 },
  { id: 7, name: 'Mi Nombre', email: 'asdfasdf@gmail.com', age: 23 }
];

export default function DataTableResults() {
  return (
    <div className="rounded-2xl container mt-5 p-3">
      <DataTable columns={columns} data={data} />
    </div>
  );
}