import Modal from 'react-modal';
import * as React from 'react';

const customStyles = {
    content: {
        top: '50%',
        left: '50%',
        right: 'auto',
        width: '80%',
        bottom: 'auto',
        marginRight: '-50%',
        transform: 'translate(-50%, -50%)',
        zIndex: 1300,

    }
};

function VehicleAddModal(props) {
    function afterOpenModal(e) {
        props.onAfterOpen(e, 'After Modal Opened');
    }

    function onModalClose(event) {
        let data = {name: 'example', type: 'closed from child'};
        props.onCloseModal(event, data);
    }

    const [formData, updateFormData] = React.useState({
        name: "",
        brand: "",
        price: 0,
        type: "CAR"
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name;
        const brand = formData.brand;
        const price = formData.price;
        const type = formData.type;
        props.onAddVehicle(name, brand, price, type);
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
                <h2>Add Vehicle</h2>

                <div className="form mw-50 p-3">
                    <div className="form-body">
                        <form onSubmit={onFormSubmit}>
                            <div className="form-group">
                                <label htmlFor="name">Name</label>
                                <input type="text"
                                       className="form-control"
                                       id="name"
                                       name="name"
                                       required
                                       placeholder="Enter name"
                                       onChange={handleChange}
                                />
                                <label htmlFor="brand">Brand</label>
                                <input type="text"
                                       className="form-control"
                                       id="brand"
                                       name="brand"
                                       required
                                       placeholder="Enter brand"
                                       onChange={handleChange}
                                />
                                <label htmlFor="price">Price</label>
                                <input type="number"
                                       className="form-control"
                                       id="price"
                                       name="price"
                                       required
                                       placeholder="Enter brand"
                                       onChange={handleChange}
                                />
                                <label htmlFor="type">Type</label>
                                <input type="text"
                                       className="form-control"
                                       id="type"
                                       name="type"
                                       required
                                       placeholder="Enter type"
                                       onChange={handleChange}
                                />
                            </div>
                            <br/>
                            <button id="submit" type="submit" className="btn btn-outline-dark">Submit</button>
                        </form>
                    </div>
                </div>

                <div className="modal-footer pt-3">
                    <button className={"btn btn-danger"} onClick={e => onModalClose(e)}>Close</button>
                </div>

            </Modal>
        </div> : <div></div>
    );
}

export default VehicleAddModal;