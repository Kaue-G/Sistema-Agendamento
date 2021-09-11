import Aside from '../Aside';
import './style.scss'

type Props = {
    children: React.ReactNode;
}

const MainBody = ({children}:Props) => (<div className="body-container"><div className="aside-box"><Aside/></div> <div className="content-box">{children}</div></div>)

export default MainBody;