import Modal from 'react-modal';
import * as React from 'react';
import rentService from "../../service/RentService/rentService";

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

    const [errorMessage, updateErrorMessage] = React.useState()
    const [formData, updateFormData] = React.useState({
        days: 1
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = async (e) => {
        e.preventDefault();
        const days = formData.days

        const submit = await rentService.rentVehicle(props.dynData.id.id, days);
        if(submit === "You can't rent this car"){
            updateErrorMessage(submit);
        }else if(submit === "Vehicle not available at this moment"){
            updateErrorMessage(submit)
        }else {
            window.location.href = "/vehicles"
        }
    }

    function afterOpenModal(e) {
        props.onOpenModal(e, 'After Modal Opened');
    }

    function onModalClose(event) {
        let data = {name: 'example', type: 'closed from child'};
        updateErrorMessage("")
        props.onCloseModal(event, data);
    }


    let infoAboutRent;
    if(props.userDetails.numOfRents >= 5){
        infoAboutRent = <h6>You will get 10% off because you are loyal user</h6>
    }else{
        infoAboutRent = <h6>You can't use the 10% off bonus, because you are not a loyal user.</h6>
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

                    <hr/>

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
                            <div className={"col-md-3"}>
                                <button id="submit" type="submit" className="btn btn-outline-dark">Rent</button>
                            </div>

                        </div>
                        <hr/>
                        <h6>Your balance: ${props.userDetails.money?.amount.toFixed(2)}</h6>
                        {infoAboutRent}
                    </form>
                    <h6>{errorMessage}</h6>
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
