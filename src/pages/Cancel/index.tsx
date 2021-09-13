import ModalBody from 'core/components/ModalBody';
import doRequest from 'core/utils/Requests';
import { useState } from 'react';
import './style.scss'
import { toast } from 'react-toastify';

const Cancel = () => {
    const [modalVisible,setModalVisible] =  useState(false);

    const [ticketId, setTicketId] = useState('');

    const handleOnChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setTicketId(e.target.value)
    }

    const modalAction = () => {

        doRequest({url: `/offices/bookings/${ticketId}`, method: 'DELETE'})
        .then(() => toast.success(`Ticket  ${ticketId} cancelado com sucesso`))
        .catch(() => toast.error(`Ticket não encontrado`))

        setModalVisible(false)
    }

    return (
        <div className="cancel-container">
            <div className="header-cancel">
                <h2>Cancelar ticket de agendamento</h2>
                <p>Para cancelar uma reserva já realizada, por favor insira o número do ticket correspondente à esse agendamento no espaço abaixo.</p>
            </div>
            <div className="action-cancel">
                <input type="text" onChange={handleOnChange} value={ticketId} />
                <button className={`btn btn-primary btn-lg ${ticketId === '' ? 'disabled':''}`} onClick={() => setModalVisible(true)}>Cancelar ticket</button>
            </div>
            { modalVisible && <ModalBody onClose={() => {setModalVisible(false)}} onModalAction={modalAction}>
                <p style={{fontSize: '24px', lineHeight: '34px'}}>Tem certeza que deseja cancelar <br/>o ticket <b>{ticketId}</b>?</p>
                <span style={{fontSize: '14px', lineHeight: '17px', color: 'rgba(0, 0, 0, 0.5)'}}><b>Atenção!</b> Depois de confirmada, essa ação não poderá ser desfeita.</span>
                </ModalBody>}
        </div>      
    )
}

export default Cancel;