


const RentedVehicles = (props) => {

    //
    console.log(props.rentedVehicles)

    return (
        <div className={"container mm-4 mt-5"}>
            <h1>You have rented the following vehicles:</h1>
            <div className={"row"}>
                <div className={"row"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Name</th>
                            <th scope={"col"}>Brand</th>
                            <th scope={"col"}>Type</th>
                        </tr>
                        </thead>
                        <tbody>
                        {props.rentedVehicles.map((term) => {
                            return (
                                <tr>
                                    <td>{term.name.name}</td>
                                    <td>{term.brand.brand}</td>
                                    <td>{term.type}</td>
                                </tr>
                            )
                        })}
                        <tr>

                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    )

}

export default RentedVehicles;