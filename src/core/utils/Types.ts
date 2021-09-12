export type Office = {
    id: number,
    name: string,
    restrictedCapacity: number,
    totalRooms: number,
    address: string,
    days: Day[]
}

export type Day = {
    date: string;
    dayNumber: number;
    verbose: string;
}

export type OfficeState = {
    officeId: number,
    restrictedCapacity: number,
    totalEmployees: number,
    totalRooms: number,
}

export type Booking = {
    begin: number,
    chair: number,
    employee_id: string,
    end: number,
    id: number,
    moment: string,
    officeName: string,
    type: string,
    weight: number,
}

export type Room = {
    id: number,
    office_id: number,
    available: boolean,
    bookingsAmout: number,
    name: string
}

export type RoomResponse = {
    content: Room[]
}

