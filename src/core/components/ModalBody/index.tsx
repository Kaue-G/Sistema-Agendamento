import './style.scss'

type Props = {
    bookingId?: number;
    onClose: () => void;
    onModalAction: () => void;
}

const ModalBody = ({bookingId, onClose, onModalAction}:Props) => {
    return <div className="modal-container">
                <div className="modal-body">
                    <div className="modal-content">
                        Tem certeza que deseja cancelar o ticket 123456?
                    </div>
                    <div>
                        <button className="btn btn-lg btn-light go-back" onClick={onClose}>Voltar</button>
                        <button className=" btn btn-primary btn-lg go-confirm" onClick={onModalAction}>Confirmar</button>
                    </div>
                </div>
        </div>
}

export default ModalBody;