import axios from "axios";
const baseUrl="http://localhost:3435"

class empService{
    adminLogin(data){
        return axios.post(baseUrl+"/loginadmin",data)
    }


}
export default new empService()