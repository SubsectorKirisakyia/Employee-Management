import React, { useState } from 'react'

const EmployeeComponent = () => {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');


  return (
    <div className='container'>
        <br/>
        <div className='row'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
                <h2 className='text-center'>Add Employees</h2>
                <div className='card-body'>
                    <form>
                        <div className='form-group mb-2'>
                        <label className='form-label'>First Name: </label>
                        <input 
                            type='text'
                            placeholder='Input First Name'
                            value={firstName}
                            onChange={(e) => setFirstName(e.target.value)}
                        />
                        </div>
                        <div className='form-group mb-2'>
                        <label className='form-label'>Last Name: </label>
                        <input 
                            type='text'
                            placeholder='Input Last Name'
                            value={lastName}
                            onChange={(e) => setLastName(e.target.value)}
                        />   
                        </div>
                        <div className='form-group mb-2'>
                        <label className='form-label'>Email: </label>
                        <input 
                            type='text'
                            placeholder='Input Email'
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                        />    
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
  )
}

export default EmployeeComponent