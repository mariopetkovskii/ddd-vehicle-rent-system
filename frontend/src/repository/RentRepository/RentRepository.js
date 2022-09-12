import axios_rent from "../../axios/axios_rent";


const rentRepository = {
    rentVehicle: (vehicleId) => {
        return axios_rent.post("/rent/vehicle/rent", {
            "email": "petkomario@gmail.com",
            "vehicleId": vehicleId
        })
            .catch(error => {
                return error.response.data.message
            })
    },
}

export default rentRepository;