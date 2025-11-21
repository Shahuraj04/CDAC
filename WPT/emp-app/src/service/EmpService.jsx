import axios from "axios";
const baseUrl="http://localhost:7777";

class EmpService{
    getAllEmployees(){
        return axios.get(baseUrl+"/employee")
    }

}

export default new EmpService()