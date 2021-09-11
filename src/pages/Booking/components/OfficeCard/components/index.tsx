import './style.scss'

type Props = {
    state: string;
}

const RoomIcon = ({state} : Props) => (<div className={`room-icon ${state}`}>A1</div>)

export default RoomIcon;