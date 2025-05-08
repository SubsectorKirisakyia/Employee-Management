import React, { useState, useEffect } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import { getEmployee, deleteEmployee } from '../services/EmployeeService';

const EmployeeDetailComponent = () => {
    const {id} = useParams();

    const [firstName, fetchFirstName] = useState('');
    const [lastName, fetchLastName] = useState('');
    const [email, fetchEmail] = useState('');

    const navigator = useNavigate();
    useEffect(() => {
        getEmployee(id).then((response) => {
            fetchFirstName(response.data.firstName);
            fetchLastName(response.data.lastName);
            fetchEmail(response.data.email);
        }).catch(error => {
            console.error("Error fetching employee: ", error);
        })
    }, [id])

    function backToIndex(e){
        e.preventDefault();
        navigator('/');
    }

    function confirmRemove(e){
        e.preventDefault();
        deleteEmployee(id).then((response)=>{
            console.log(response.status);
            navigator('/');
        }).catch(error => console.error("Failed to Delete: ", error));
    }

  return (
    <div className='container'>
        <br/>
        <div className='row'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
                <h2 className='text-center'>Delete Employee</h2>
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
                        <button className='btn btn-danger' onClick={confirmRemove}>Confirm</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
  )
}

export default EmployeeDetailComponent