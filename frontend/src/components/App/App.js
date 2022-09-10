import './App.css';
import {Component} from "react";
import Header from "../Header/Header";
import vehicleService from "../../service/VehicleService/VehicleService";
import {Navigate, Route, Routes} from "react-router-dom";
import Vehicle from "../Vehicle/vehicles";
import Registration from "../Auth/Register";
import userService from "../../service/UserService/userService";
import Login from "../Auth/Login";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            vehicles: [],
            isUserLoggedIn: userService.checkIfUserLoggedIn()
        }
    }

    render() {
        return (
            <div>
                <Header isUserLoggedIn={this.state.isUserLoggedIn}
                        logout={this.logout}/>
                <div className={"container"}>
                    <Routes>
                        <Route path={"/vehicles"} exact element={<Vehicle onAddVehicle={this.addVehicle}/>}/>
                        <Route path={"/register"} exact element={<Registration onRegister={this.register}/>}/>
                        <Route path={"/login"} exact element={<Login onLogin={this.login}/>}/>
                    </Routes>
                </div>
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

    addVehicle = (name, brand, price, type) => {
        vehicleService.addVehicle(name, brand, price, type)
            .then(() => {
                window.location.href = "/vehicles"
            })
    }

    register = (firstName, lastName, email, password, confirmPassword) => {
        userService.register(firstName, lastName, email, password, confirmPassword)
            .then(() => {
                window.location.href = "/login"
            })
    }

    login = (email, password) => {
        userService.login(email, password)
            .then(() => {
                window.location.href = "/vehicles"
            })
    }

    logout = () => {
        userService.logout()
        window.location.href = "/login"
    }

}

export default App;
