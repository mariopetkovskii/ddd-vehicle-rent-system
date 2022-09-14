

const Account = (props) => {


    console.log(props.userDetails)

    return (
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"row"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Name</th>
                            <th scope={"col"}>Surname</th>
                            <th scope={"col"}>Email</th>
                            <th scope={"col"}>Money</th>
                            <th scope={"col"}>Total rents</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>{props.userDetails.firstName}</td>
                            <td>{props.userDetails.lastName}</td>
                            <td>{props.userDetails.email}</td>
                            <td>${props.userDetails.money?.amount}</td>
                            <td>{props.userDetails.numOfRents}</td>
                        </tr>
                        </tbody>
                        <div className={"text-right"}>
                            <a href="/add-money" className={"btn btn-primary"}>Add money</a>
                        </div>
                    </table>
                </div>
            </div>
        </div>
    )

}

export default Account