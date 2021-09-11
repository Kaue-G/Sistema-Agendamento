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
    chairsOccupied: number,
    officeId: number,
    roomsOccupied: number,
    totalChairs: number,
    totalRooms: number
}

export type OfficeResponse = {
    content: Office[];
}

