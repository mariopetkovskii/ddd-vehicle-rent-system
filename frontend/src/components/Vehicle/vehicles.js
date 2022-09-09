import * as React from 'react';
import {useState} from 'react';
import MaterialTable from 'material-table';
import VehicleAddModal from "./vehicleAddModal";
import vehicleService from "../../service/VehicleService/VehicleService";


const Vehicle = (props) => {

    const [openModal, setOpenedModal] = useState(null);
    const [modalIsOpen, setIsOpen] = React.useState(false);

    function openModalAddVehicle(addVehicleModal) {
        setOpenedModal(addVehicleModal)
        setIsOpen(true)
    }

    function handleCloseModal() {
        setIsOpen(false);
    }

    function handleAfterOpen(event, data) {
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
                IsModalOpened={modalIsOpen}
                onCloseModal={handleCloseModal}
                onAfterOpen={handleAfterOpen}
                onAddVehicle={props.onAddVehicle}
            />


            <div className="container">
                <div className="justify-content-end d-flex">
                    <button className={"btn btn-dark mt-2"}
                            onClick={(openModal) => openModalAddVehicle(openModal)}>Add
                        Vehicle
                    </button>
                </div>
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
                                // backgroundColor:
                                // selectedRow === rowData.tableData.id ? '#67aeae' : '#FFF',
                                maxHeight: "11vh",
                                height: "11vh",
                                maxWidth: "7vh",
                                width: "7vh"
                            })
                        }}

                    />
                </div>

            </div>
        </div>
    );
};
export default Vehicle;