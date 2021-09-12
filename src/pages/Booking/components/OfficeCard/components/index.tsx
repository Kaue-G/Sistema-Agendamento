import './style.scss'
import { Room } from 'core/utils/Types'

type Props = {
    room: Room,
    onClick: Function 
}

const RoomIcon = ({room, onClick} : Props) => {

    return <div className={`room-icon ${room.available ? 'available' : ''}`} onClick={() => onClick(room.id)}>
        {room.name}
    </div>
}

export default RoomIcon;