import axios  from "axios";
const baseurl = "http://localhost:5000/appointments/"

class AppointmentService{

    getAllAppointments(){
        return axios.get(baseurl+"getall")
    }
    addnewAppointment(data){
        return axios.post(baseurl+"addappoinntment",data)
    }

    deleteAppointment(id){
        return axios.delete(baseurl+`delete/${id}`)
    }

    updateAppointment(id,data){
        return axios.put(baseurl+`edit/${id}`,data)
    }
}

export default new AppointmentService();