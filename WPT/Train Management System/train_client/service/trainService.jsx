import axios from "axios";
const baseUrl = "http://localhost:3435/"

class trainService{

    gettrains(data){
        return axios.get(baseUrl+"addtrain",data)
    }


}
export default new trainService()