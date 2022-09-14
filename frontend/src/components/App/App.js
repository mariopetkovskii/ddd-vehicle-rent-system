import './App.css';
import {Component} from "react";
import Header from "../Header/Header";
import vehicleService from "../../service/VehicleService/VehicleService";
import {Navigate, Route, Routes} from "react-router-dom";
import Vehicle from "../Vehicle/vehicles";
import Registration from "../Auth/Register";
import userService from "../../service/UserService/userService";
import Login from "../Auth/Login";
import rentService from "../../service/RentService/rentService";
import Account from "../Account/account";
import AddMoney from "../Account/add-money";
import RentedVehicles from "../Account/rented-vehicles";
import jwt_decode from "jwt-decode";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            vehicles: [],
            isUserLoggedIn: userService.checkIfUserLoggedIn(),
            userDetails: [],
            rentedVehicles: []
        }
    }

    render() {
        return (
            <div>
                <Header isUserLoggedIn={this.state.isUserLoggedIn}
                        logout={this.logout}
                        userDetails={this.state.userDetails}
                />
                <div className={"container"}>
                    <Routes>
                        <Route path={"/vehicles"} exact element={<Vehicle onAddVehicle={this.addVehicle}
                                                                          onRent={this.rentVehicle}
                                                                          userDetails={this.state.userDetails}
                                                                          isLoggedIn={this.state.isUserLoggedIn}/>}/>
                        <Route path={"/register"} exact element={<Registration onRegister={this.register}/>}/>
                        <Route path={"/login"} exact element={<Login onLogin={this.login}/>}/>
                        <Route path={"/account"} exact element={<Account userDetails={this.state.userDetails}/>}/>
                        <Route path={"/add-money"} exact element={<AddMoney onAddMoney={this.addMoney}/>}/>
                        <Route path={"/rented-vehicles"} exact element={<RentedVehicles rentedVehicles={this.state.rentedVehicles}
                                                                                        onLoad={this.getAllRentedUserVehicles}/>}/>
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

    addVehicle = (name, brand, price, type, numOfRents) => {
        vehicleService.addVehicle(name, brand, price, type, numOfRents)
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

    rentVehicle = (vehicleId, days) => {
        // console.log(vehicleId.id)

        rentService.rentVehicle(vehicleId, days)
            .then(() => {
                window.location.href = "/vehicles"
            })
    }

    userDetails = () => {
        userService.userDetails()
            .then((data) => {
                this.setState({
                    userDetails: data.data
                })
            });
    }

    addMoney = (amount) => {
        userService.addMoney(amount)
            .then(() => {
                window.location.href = "/account"
            })
    }

    getAllRentedUserVehicles = () => {
        userService.getAllRentedVehicles(jwt_decode(localStorage.getItem('auth_token')).id).then((data) => {
            this.setState({
                rentedVehicles: data.data
            })
        })
    }

    componentDidMount() {
        this.userDetails()
        if(userService.checkIfUserLoggedIn())
            this.getAllRentedUserVehicles()
    }


}

export default App;
