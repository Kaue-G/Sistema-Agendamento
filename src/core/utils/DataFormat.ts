import { format, parse } from "date-fns";

const stringToDate = (text : string) => {
    let date = parse(text,'dd/MM/yyyy',new Date())
    return format(date,"yyyy-MM-dd");
}

export default stringToDate;