import axios from 'axios';

const api = axios.create({ 
    baseURL: 'https://fcam-booking.herokuapp.com/'
});

export default api;