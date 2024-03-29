import axios_users from "../../axios/axios_users";
import jwt_decode from "jwt-decode";
import axios_rent from "../../axios/axios_rent";

const AUTH_TOKEN = 'auth_token';
const loggedInEmail = 'loggedEmail'

const userRepository = {

    register: (firstName, lastName, email, password, confirmPassword) => {
        return axios_users.post("/user/register", {
            "firstName": firstName,
            "lastName": lastName,
            "email": email,
            "password": password,
            "confirmPassword": confirmPassword
        })
    },

    login: (email, password) => {
        return axios_users.post("/user/login", {}, {
            auth: {
                username: email,
                password: password
            }
        }).then(res => {
            localStorage.setItem(AUTH_TOKEN, res.data)
            localStorage.setItem(loggedInEmail, email)
            return res;
        }).catch(error => {
            console.log(error);
        })
    },

    logout: () => {
        localStorage.removeItem(AUTH_TOKEN);
        localStorage.removeItem(loggedInEmail);
    },

    userDetails: () => {
        return axios_users.post("/user/details", {
            "email": localStorage.getItem(loggedInEmail)
        })
    },

    addMoney: (amount) => {
        return axios_users.post("/user/addMoney", {
            "email": localStorage.getItem(loggedInEmail),
            "amount": amount
        })
    },

    getAllRentedVehicles: (id) => {
        return axios_rent.post("/rent/vehicle/getUserVehicles", {
            "id": id
        })
    }

}

export default userRepository;