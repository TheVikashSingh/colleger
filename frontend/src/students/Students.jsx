import { QueryClient, useMutation, useQuery, useQueryClient } from '@tanstack/react-query';
import axios from 'axios'
import React, { useEffect, useState } from 'react'




const Students = () => {
    const studentApiURL = import.meta.env.VITE_STUDENT_API_URL;
    const [name, setName] = useState("");
    const [gender, setGender] = useState("");
    const [classOfStudent, setClassOfStudent] = useState("");

    const queryClient = useQueryClient();

    const getStudentDetails = async () => {
        const response = await axios.get(`${studentApiURL}`);
        return response.data;
    }

    const addAStudentFunction = async (new_student) => {
    const response = await axios.post(`${studentApiURL}`,new_student);
    }

    const deleteStudentFunction = async (id) => {
        const response = await axios.delete(`${studentApiURL}${id}`);
    }

    const {data, isLoading, isError, error} = useQuery({
        queryKey: ["show-all-students"],
        queryFn: getStudentDetails,
    });

    const {mutate} = useMutation({
        mutationFn: addAStudentFunction,
        onSuccess: () => {
            queryClient.invalidateQueries({ queryKey: ["show-all-students"] });
        },
    });

        const deleteStudentMutation = useMutation({
        mutationFn: deleteStudentFunction,
        onSuccess: () => {
            queryClient.invalidateQueries({ queryKey: ["show-all-students"] });
        },
    });

    if(isLoading){
        return <p>Loading...</p>
    }

    if(isError){
        return <p>An error occurred with message - {error.message}...</p>
    }

    function handleChangeStudentName(e_name){
        setName(e_name);
    }

    function handleChangeStudentGender(e_gender){
        setGender(e_gender);
    }

    function handleChangeStudentClass(e_class){
        setClassOfStudent(e_class);
    }

    function createStudentBtn (){
        const newStudent = 
            {
                "name": name,
                "gender": gender,
                "classofstudent": classOfStudent
            }
        mutate(newStudent);
    }

    function deleteAStudent(s_id){
        deleteStudentMutation.mutate(s_id);
    }

  return (
    <>
    <div style={{border:"2px solid black", padding:"0px",justifyContent:"center",display:"flex"}}>
    <div style={{display:"flex", alignItems:"center", justifyContent:"center", width:"100%"}}><h3>Student's Section</h3></div>
    
    <div style={{border:"1px solid black", padding:"10px"}}>
    <label>
    <span>Name:</span>
    <input type="text" value={name} onChange={(e) => handleChangeStudentName(e.target.value)} placeholder="Student's Name..."/>
    <br />
    <span> Gender:</span>
    <input type="text" value={gender} onChange={(e) => handleChangeStudentGender(e.target.value)} placeholder="Student's Gender..."/>
    <br />
    <span> Class:</span>
    <input type="text" value={classOfStudent} onChange={(e) => handleChangeStudentClass(e.target.value)} placeholder="Student's Class..."/>
    </label>
    <br /><br />
    <button onClick={createStudentBtn}>Add Student Details</button>
    </div>

    <div style={{border:"1px solid black", padding:"10px", display:"flex", justifyContent:"center"}}>
    <table border="1" cellPadding="8">
        <thead>
            <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Gender</th>
            <th>Class</th>
            <td></td>
            </tr>
        </thead>
        <tbody>
            {data.map((s) => (
                <tr key={s.id}>
                <td>{s.id}</td>
                <td>{s.name}</td>
                <td>{s.gender}</td>
                <td>{s.classofstudent}</td>
                <td><button onClick={() => deleteAStudent(s.id)}>DEL</button></td>
                </tr>
            ))}
        </tbody>
    </table>
    </div>
    </div>
    </>
  )
}

export default Students