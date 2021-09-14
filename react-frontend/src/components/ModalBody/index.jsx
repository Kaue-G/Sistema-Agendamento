import './style.css'

const ModalBody = ({ children, onClose, onModalAction }) => {
   
    console.log(children);
    console.log(onClose);
    console.log(onModalAction);
   
   return <div className="modal-container">
        <div className="main-modal-body">
            <div className="main-modal-content">
                {children}
            </div>
            <div className="button-content">
                <button className="" onClick={onClose}>Voltar</button>
                <button className="" onClick={onModalAction}>Confirmar</button>
            </div>
        </div>
    </div>
}

export default ModalBody;