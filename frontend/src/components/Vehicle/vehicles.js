import * as React from 'react';
import {useState} from 'react';
import MaterialTable from 'material-table';
import VehicleAddModal from "./vehicleAddModal";
import RentVehicleModal from "./rentVehicleModal";
import jwt_decode from "jwt-decode";
import {useNavigate} from "react-router-dom";


const Vehicle = (props) => {

    const [openModal, setOpenedModal] = useState(null);
    const [openModalRent, setOpenedModalRent] = useState(null);
    const [modalIsOpenAddVehicle, setIsOpen] = React.useState(false);
    const [modalIsOpenRent, setIsOpenRent] = React.useState(false);
    const [selectedRow, setSelectedRow] = useState(null);
    const [errorMessage, updateErrorMessage] = React.useState()
    let addVehicle;

    const token = localStorage.getItem("auth_token");
    if (token !== null) {
        const decoded_token = jwt_decode(token);
        if (decoded_token.authority.includes('ROLE_ADMIN')) {
            addVehicle = <div className="justify-content-end d-flex">
                <button className={"btn btn-dark mt-2"}
                        onClick={(openModal) => openModalAddVehicle(openModal)}>Add
                    Vehicle
                </button>
            </div>
        }
    }
    const history = useNavigate();


    function openModalAddVehicle(addVehicleModal) {
        setOpenedModal(addVehicleModal)
        setIsOpen(true)
    }

    function openModalVehicleRent(addVehicleModal) {
        setOpenedModalRent(addVehicleModal)
        setIsOpenRent(true)
    }

    function openFromParent(rowData) {
        setSelectedRow(rowData)
        setIsOpenRent(true);
        // props.onRent(rowData.id)
        console.log(rowData.id)
    }

    function handleCloseModalAddVehicle() {
        setIsOpen(false);
    }

    function handleCloseModalRent() {
        setIsOpenRent(false);
    }

    function handleAfterOpenAddVehicle(event, data) {
    }

    function handleAfterOpenRent(event, data) {
    }

    const columns = [
        {title: 'Name', field: 'name.name'},
        {title: 'Brand', field: 'brand.brand'},
        {title: 'Price', field: 'price.amount'},
        {title: 'Type', field: 'type'},
        {title: 'Number of rents', field: 'numOfRents'},
    ];

    function isValidDate(d) {
        return d instanceof Date && !isNaN(d);
    }

    // const addVehicle = (name, brand, price, type, numOfRents) => {
    //     vehicleService.addVehicle(name, brand, price, type, numOfRents)
    //         .then(() => {
    //             window.location.href = "/location"
    //         })
    // }


    return (
        <div>
            <VehicleAddModal
                dynData={openModal}
                IsModalOpened={modalIsOpenAddVehicle}
                onCloseModal={handleCloseModalAddVehicle}
                onAfterOpen={handleAfterOpenAddVehicle}
                onAddVehicle={props.onAddVehicle}
                isLoggedIn={props.isLoggedIn}
            />

            <RentVehicleModal
                dynData={selectedRow}
                IsModalOpened={modalIsOpenRent}
                onCloseModal={handleCloseModalRent}
                onOpenModal={handleAfterOpenRent}
                onRentVehicle={props.onRent}
                userDetails={props.userDetails}
            />


            <div className="container">
                {addVehicle}
                <div className="justify-content-center col-md-15 offset-sm-0 row-md-9 pt-2">
                    <MaterialTable
                        style={{
                            zIndex: 0,
                        }}
                        columns={columns}
                        data={query =>
                            new Promise((resolve) => {
                                let fetchData = "http://localhost:9090/rest/vehicle/pagination/" + query.page + "/" + query.pageSize
                                fetch(fetchData).then(response => response.json()).then(response => {
                                    resolve({
                                        data: response.content,
                                        page: query.page,
                                        totalCount: response.totalElements,
                                    });
                                })
                            })
                        }
                        title={<h5><strong>Vehicles</strong></h5>}
                        options={{
                            actionsColumnIndex: -1,
                            search: false,
                            paging: true,
                            draggable: false,
                            sorting: false,
                            loadingType: 'linear',
                            // filtering: true,
                            headerStyle: {
                                fontWeight: "bold",
                                maxWidth: "7vh",
                                width: "7vh",
                            },
                            rowStyle: rowData => ({
                                backgroundColor:
                                    selectedRow === rowData.tableData.id ? '#67aeae' : '#FFF',
                                maxHeight: "11vh",
                                height: "11vh",
                                maxWidth: "7vh",
                                width: "7vh"
                            })
                        }}
                        actions={[
                            {
                                icon: () => <button className={"btn btn-warning"}>Rent</button>,
                                tooltip: 'Open Details',
                                onClick: (event, rowData) => openFromParent(rowData)
                            }]
                        }

                    />
                </div>
                {errorMessage}
            </div>
        </div>
    );
};
export default Vehicle;