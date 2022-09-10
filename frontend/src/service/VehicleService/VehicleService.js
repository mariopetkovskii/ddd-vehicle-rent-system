import vehicleRepository from '../../repository/VehicleRepository/VehicleRepository'

const vehicleService = {

    listAll: () => {
        return vehicleRepository.listAll();
    },

    addVehicle: (name, brand, amount, type) => {
        return vehicleRepository.addVehicle(name, brand, amount, type)
    }

}

export default vehicleService;