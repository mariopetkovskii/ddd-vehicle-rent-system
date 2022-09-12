import rentRepository from "../../repository/RentRepository/RentRepository";


const rentService = {
    rentVehicle: (vehicleId) => {
        return rentRepository.rentVehicle(vehicleId)
    }
}

export default rentService;