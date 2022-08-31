import React, { useEffect, useState } from 'react'
import axios from  'axios';
import { Link, useParams } from 'react-router-dom';

export default function Home() {

    const [users, setUsers]=useState([])

    const {id}=useParams()

    useEffect(()=>{
        loadUsers();
    },[])

    const api_url = 'http://localhost:8080/api'

    const loadUsers=async()=>{
        const result=await axios.get(api_url+"/users")
        setUsers(result.data)
    }

    const deleteUser= async (id)=>{
        await axios.delete(api_url+`/users/${id}`)
        loadUsers()
    }

    return (
        <div className='container'>
            <div className='py-4'>
                <table className="table border shadow">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Username</th>
                            <th scope="col">Email</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            users.map((user, index)=>(
                                <tr>
                                <th scope="row" key={index}>{index+1}</th>
                                <td>{user.name}</td>
                                <td>{user.username}</td>
                                <td>{user.email}</td>
                                <td>
                                    <button className='btn btn-primary mx-2'>View</button>
                                    <Link className='btn btn-outline-primary mx-2' to={`/edituser/${user.id}`}>Edit</Link>
                                    <button onClick={()=>deleteUser(user.id)} className='btn btn-danger mx-2'>Delete</button>
                                </td>
                            </tr> 
                            ))
                        }                      
                    </tbody>
                </table>
            </div>
        </div>
    )
}
