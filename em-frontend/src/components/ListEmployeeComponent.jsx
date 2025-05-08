import React, { useEffect, useState } from 'react'
import { listEmployees } from '../services/EmployeeService'
import { useNavigate } from 'react-router-dom'

const ListEmployeeComponent = () => {

  const [employees, setEmployees] = useState([]);
  const navigator = useNavigate();

  useEffect(() => {
    listEmployees().then((response) => {
      setEmployees(response.data);
    }).catch(error => {
      console.error(error);
    })
  }, [])

  function addNewEmployee(){
    navigator('/add-employee');
  }

  function editEmployee(id){
    navigator(`/edit-employee/${id}`);
  }

  function deleteEmployee(id){
    navigator(`/delete-employee/${id}`);
  }

  return (
    <div className='container'>
      <h2 className='text-center'>List of Employees</h2>
        <table className='table table-striped table-bordered'>
          <thead>
            <tr>
            <th>Employee Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {
              employees.map(employee =>
                <tr key={employee.id}>
                  <td>{employee.id}</td>
                  <td>{employee.firstName}</td>
                  <td>{employee.lastName}</td>
                  <td>{employee.email}</td>
                  <td><button className='btn btn-info' onClick={() => editEmployee(employee.id)}>UPDATE</button> <button className='btn btn-danger' onClick={() => deleteEmployee(employee.id)}>DELETE</button></td>
                </tr>
              )
            }
          </tbody>
          <tfoot className='justify-content-center'>
            <tr><td colSpan={4}><button className='btn btn-primary md-2' onClick={addNewEmployee}>Add Employee</button></td></tr>
          </tfoot>
        </table>
        
      </div>
  )
}

export default ListEmployeeComponent