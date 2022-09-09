import vehicleRepository from '../../repository/VehicleRepository/VehicleRepository'

const vehicleService = {

    listAll: () => {
        return vehicleRepository.listAll();
    },

    addVehicle: (name, brand, amount, type, numOfRents) => {
        return vehicleRepository.addVehicle(name, brand, amount, type, numOfRents)
    }

}

export default vehicleService;