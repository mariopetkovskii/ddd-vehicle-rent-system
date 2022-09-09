import axios_vehicle from "../../axios/axios_vehicle";


const vehicleRepository = {
    listAll: () => {
        return axios_vehicle.get("/vehicle/listAll");
    },

    addVehicle: (name, brand, amount, type, numOfRents) => {
        return axios_vehicle.post("/vehicle/create", {
            "name": {
                "name": name
            },
            "brand": {
                "brand": brand
            },
            "price": {
                "amount": amount
            },
            "type": type,
            "numOfRents": numOfRents
        })
    }
}

export default vehicleRepository;