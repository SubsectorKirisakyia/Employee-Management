import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { addEmployee } from '../services/EmployeeService';

const EmployeeComponent = () => {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');

    const [errors, setErrors] = useState({
        firstName: '',
        lastName: '',
        email: ''
    });

    const navigator = useNavigate();

    function saveEmployee(e){
        e.preventDefault();

        const employee = {firstName, lastName, email}
        addEmployee(employee).then((response) => {
            console.log(response.data);
            navigator('/employees');
        });
    }

    function backToIndex(e){
        e.preventDefault();
        navigator('/');
    }

    function validateForm(){
        let valid = true;

        const errorsCopy = {... errors};
    }

  return (
    <div className='container'>
        <br/>
        <div className='row'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
                <h2 className='text-center'>Add Employees</h2>
                <div className='card-body'>
                <button className='btn btn-secondary text-end' onClick={backToIndex}>Go Back</button>
                    <form>
                        <div className='form-group mb-2'>
                        <label className='form-label d-flex flex-row'>First Name: </label>
                        <input 
                            type='text'
                            placeholder='Input First Name'
                            name='firstName'
                            className='form-control'
                            value={firstName}
                            onChange={(e) => setFirstName(e.target.value)}
                        />
                        </div>
                        <div className='form-group mb-2'>
                        <label className='form-label d-flex flex-row'>Last Name: </label>
                        <input 
                            type='text'
                            placeholder='Input Last Name'
                            name='lastName'
                            className='form-control'
                            value={lastName}
                            onChange={(e) => setLastName(e.target.value)}
                        />   
                        </div>
                        <div className='form-group mb-2'>
                        <label className='form-label d-flex flex-row'>Email: </label>
                        <input 
                            type='text'
                            placeholder='Input Email'
                            name='email'
                            className='form-control'
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                        />    
                        </div>
                        <button className='btn btn-success' onClick={saveEmployee}>Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
  )
}

export default EmployeeComponent