const header = (props) => {
    if (!props.isUserLoggedIn) {
        return (
            <header>
                <nav className="navbar navbar-expand-md navbar-dark bg-warning">
                    <div className="container">
                        <a className="navbar-brand" href="/" style={{color: "black"}}>Vehicle rent system</a>
                        <button className="navbar-toggler" type="button" data-toggle="collapse"
                                data-target="#navbarsExampleDefault"
                                aria-controls="navbarsExampleDefault" aria-expanded="false"
                                aria-label="Toggle navigation">
                            <span className="navbar-toggler-icon"></span>
                        </button>

                        <div className="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                            <ul className="navbar-nav m-auto">
                                <li className="nav-item m-auto">
                                    <a href="/vehicles" className="nav-link active" style={{color: "black"}}>Home</a>
                                </li>
                                <li className="nav-item m-auto">
                                    <a href="/vehicles" className="nav-link" style={{color: "black"}}>Vehicles</a>
                                </li>
                            </ul>
                            <ul className="nav navbar-nav navbar-right">
                                <li className="nav-item">
                                    <a href="/register" className="nav-link" style={{color: "black"}}>Register</a>
                                </li>
                                <li className="nav-item">
                                    <a href="/login" className="nav-link" style={{color: "black"}}>Login</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </header>
        )
    }
    else{
        return(
        <header>
            <nav className="navbar navbar-expand-md navbar-dark bg-warning">
                <div className="container">
                    <a className="navbar-brand" href="/" style={{color: "black"}}>Vehicle rent system</a>
                    <button className="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarsExampleDefault"
                            aria-controls="navbarsExampleDefault" aria-expanded="false"
                            aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>

                    <div className="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                        <ul className="navbar-nav m-auto">
                            <li className="nav-item m-auto">
                                <a href="/home" className="nav-link active" style={{color: "black"}}>Home</a>
                            </li>
                            <li className="nav-item m-auto">
                                <a href="/vehicles" className="nav-link" style={{color: "black"}}>Vehicles</a>
                            </li>
                            <li className="nav-item m-auto">
                                <a href="/rented-vehicles" className="nav-link" style={{color: "black"}}>My vehicles</a>
                            </li>
                        </ul>
                        <ul className="nav navbar-nav navbar-right">
                            <li className="nav-item">
                                <a href="/add-money" className="nav-link" style={{color: "black"}}>${props.userDetails.money?.amount}</a>
                            </li>
                            <li className="nav-item">
                                <a href="/account" className="nav-link" style={{color: "black"}}>
                                    {props.userDetails.firstName +
                                    ' '
                                    + props.userDetails.lastName}</a>
                            </li>
                            <li className="nav-item">
                                <a href="" onClick={props.logout} className="nav-link" style={{color: "black"}}>Logout</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
    )
    }
}

export default header;