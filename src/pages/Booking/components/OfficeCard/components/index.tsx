import './style.scss'

type Props = {
    state: string;
    room: string;
}

const RoomIcon = ({state, room} : Props) => (<div className={`room-icon ${state}`}>{room}</div>)

export default RoomIcon;