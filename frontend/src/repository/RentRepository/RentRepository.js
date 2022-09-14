import axios_rent from "../../axios/axios_rent";


const rentRepository = {
    rentVehicle: (vehicleId, days) => {
        return axios_rent.post("/rent/vehicle/rent", {
            "email": "petkomario@gmail.com",
            "vehicleId": vehicleId,
            "days": days
        })
            .catch(error => {
                return error.response.data.message
            })
    },
}

export default rentRepository;