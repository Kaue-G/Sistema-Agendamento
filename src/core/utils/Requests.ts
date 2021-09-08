import axios, { Method } from 'axios'
const BASE_URL = 'http://fcam-booking.herokuapp.com'

type Params = {
    method?: Method;
    url: string;
    data?: object;
    params?: object;
}

const doRequest = ({method = 'GET', url, data, params} : Params) => {
    return axios({
        method,
        url: `${BASE_URL}${url}`,
        data,
        params
    })
}

export default doRequest