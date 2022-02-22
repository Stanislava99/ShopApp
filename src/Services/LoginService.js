import axios from 'axios'

const SHOP_APP_API_BASE_URL = "http://localhost:8080/api/v1"

class LoginService {
    
    login(login, password) {
        return axios.post(SHOP_APP_API_BASE_URL + '/login', login,password);
    }

    register(login,password,email) {
        return axios.post(SHOP_APP_API_BASE_URL + '/register', login,password,email);
    }
}