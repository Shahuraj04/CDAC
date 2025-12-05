import axios from "axios"; 

const baseurl = "http://localhost:5151/"

class DeliveryService{

    getAllDeliveries(){
        return axios.get(baseurl+"delivery/showall")

    }
    addnewDelivery(data){
        return axios.post(baseurl+"delivery/deliveries",data)

    }
}

export default new DeliveryService();