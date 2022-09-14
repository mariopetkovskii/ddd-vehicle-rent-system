import axios_rent from "../../axios/axios_rent";

const loggedInEmail = 'loggedEmail'


const rentRepository = {
    rentVehicle: (vehicleId, days) => {
        return axios_rent.post("/rent/vehicle/rent", {
            "email": localStorage.getItem(loggedInEmail),
            "vehicleId": vehicleId,
            "days": days
        })
            .catch(error => {
                console.log(error.response.data.message)
                return error.response.data.message
            })
    },
}

export default rentRepository;