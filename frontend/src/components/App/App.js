import './App.css';
import {Component} from "react";
import Header from "../Header/Header";
import vehicleService from "../../service/VehicleService/VehicleService";
import {Navigate, Route, Routes} from "react-router-dom";
import Vehicle from "../Vehicle/vehicles";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            vehicles: []
        }
    }

    render() {
        return (
            <div>
                <Header/>
                <Routes>
                    <Route path={"/vehicles"} exact element={<Vehicle onAddVehicle={this.addVehicle}/>}/>
                </Routes>
            </div>
        )
    }

    listVehicles = () => {
        vehicleService.listAll()
            .then((data) => {
                this.setState({
                    vehicles: data.data
                })
            });
    }

    addVehicle = (name, brand, price, type, numOfRents) => {
        vehicleService.addVehicle(name, brand, price, type, numOfRents)
            .then(() => {
                window.location.href = "/vehicles"
            })
    }

}

export default App;
