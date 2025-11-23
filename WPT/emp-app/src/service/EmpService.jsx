import axios from "axios";
const baseUrl="http://localhost:7777";

class EmpService{
    getAllEmployees(){
        return axios.get(baseUrl+"/employee")
    }
    addEmployee(data){
        return axios.post(baseUrl+"/employee/addemp",data)
    }
   deleteEmp(id) {
    return axios.delete(baseUrl + `/employee/${id}`);
}

    updateEmp(employee){
        return axios.put(baseUrl+`/employee/${employee.empId}`,employee)
    }


}

export default new EmpService()