import { Error } from "core/utils/Types"
import { useEffect, useState } from "react"
import { useLocation } from "react-router"
import './style.scss'


const ErrorPage = () => {
    const location = useLocation<any>();
    const[error,setError] = useState<Error>();

    useEffect(() => {
        if(location.state !== undefined){
            setError(location.state.params)
        }
    },[location])

    return (<div className="main-error-container">
        {error && 
        <>
        <span>{error.date}</span><br/>
        <span>{error.status}</span><br/>
        {error.errors?.map(x => (
            <span key={x.message}>{x.message}</span>
        ))}
        </>
        }
    </div>)
}

export default ErrorPage;