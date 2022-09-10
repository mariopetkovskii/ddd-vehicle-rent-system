import axios_users from "../../axios/axios_users";
import jwt_decode from "jwt-decode";

const AUTH_TOKEN = 'auth_token';

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
            return res;
        }).catch(error => {
            console.log(error);
        })
    },

    logout: () => {
        localStorage.removeItem(AUTH_TOKEN);
    }

}

export default userRepository;