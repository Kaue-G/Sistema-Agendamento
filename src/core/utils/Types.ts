export type Office = {
    id: number,
    name: string,
    totalChairs: number,
    totalRooms: number,
    days: Day[]
}

export type Day = {
    date: string;
    day: number;
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

