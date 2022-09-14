import Modal from 'react-modal';
import * as React from 'react';

const customStyles = {
    content: {
        top: '50%',
        left: '50%',
        right: 'auto',
        width: '25%',
        bottom: 'auto',
        marginRight: '-50%',
        transform: 'translate(-50%, -50%)',
        zIndex: 1300,

    }
};

function RentVehicleModal(props) {


    const [formData, updateFormData] = React.useState({
        days: 1
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const days = formData.days
        props.onRentVehicle(props.dynData.id.id, days);
    }

    function afterOpenModal(e) {
        props.onOpenModal(e, 'After Modal Opened');
    }

    function onModalClose(event) {
        let data = {name: 'example', type: 'closed from child'};
        props.onCloseModal(event, data);
    }

    return (
        props.dynData ? <div>
                <Modal
                    isOpen={props.IsModalOpened}
                    onAfterOpen={e => afterOpenModal(e)}
                    style={customStyles}
                    ariaHideApp={true}
                    scrollable={true}
                >
                    <h3>{"Rent for " + props.dynData.name.name + " " + props.dynData.brand.brand}</h3>

                    <hr/>

                    <h6>{"Rent for " + props.dynData.name.name + " " + props.dynData.brand.brand + " per day costs $" + props.dynData.price.amount}</h6>
                    <h6>How many days do you want to rent this car ?</h6>
                    <form onSubmit={onFormSubmit}>
                        <div className={"row"}>
                            <div className={"col-md-3"}>
                                <input type="number"
                                       className="form-control"
                                       id="days"
                                       name="days"
                                       required
                                       placeholder="Days"
                                       onChange={handleChange}
                                />
                            </div>
                            <div class={"col-md-3"}>
                                <button id="submit" type="submit" className="btn btn-outline-dark">Rent</button>
                            </div>

                        </div>
                    </form>
                    <div>


                    </div>
                    <div className="modal-footer pt-3">
                        <button className={"btn btn-danger"} onClick={e => onModalClose(e)}>Close</button>
                    </div>

                </Modal>
            </div>
            :
            <div></div>
    );
}

export default RentVehicleModal;
