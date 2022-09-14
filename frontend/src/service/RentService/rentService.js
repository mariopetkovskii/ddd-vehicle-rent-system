import rentRepository from "../../repository/RentRepository/RentRepository";


const rentService = {
    rentVehicle: (vehicleId, days) => {
        return rentRepository.rentVehicle(vehicleId, days)
    }
}

export default rentService;