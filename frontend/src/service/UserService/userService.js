import userRepository from "../../repository/UserRepository/UserRepository";

const AUTH_TOKEN = 'auth_token';

const userService = {

    register: (firstName, lastName, email, password, confirmPassword) => {
        return userRepository.register(firstName, lastName, email, password, confirmPassword)
    },

    login: (email, password) => {
        return userRepository.login(email, password)
    },

    checkIfUserLoggedIn: () => {
        return localStorage.getItem(AUTH_TOKEN) !== null;
    },

    logout: () => {
        userRepository.logout();
    },

    userDetails: () => {
        return userRepository.userDetails();
    },

    addMoney: (amount) => {
        return userRepository.addMoney(amount);
    },

    getAllRentedVehicles: (id) => {
        return userRepository.getAllRentedVehicles(id);
    }

}

export default userService