import React, {useState} from 'react';


function Registration(props) {

    const [formData, updateFormData] = React.useState({
        firstName: "",
        lastName: "",
        email: "",
        password: "",
        confirmPassword: ""
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const firstName = formData.firstName;
        const lastName = formData.lastName;
        const email = formData.email;
        const password = formData.password;
        const confirmPassword = formData.confirmPassword;
        props.onRegister(firstName, lastName, email, password, confirmPassword);
    }

    return (
        <div className={"row"}>
            <div className={"col-md-6 offset-md-3"}>
                <div className="form">
                    <div className="form-body">
                        <form onSubmit={onFormSubmit}>
                            <div className="form-group">
                                <label htmlFor="firstName">First name</label>
                                <input type="text"
                                       className="form-control"
                                       id="firstName"
                                       name="firstName"
                                       required
                                       placeholder="Enter first name"
                                       onChange={handleChange}
                                />
                                <label htmlFor="lastName">Last Name</label>
                                <input type="text"
                                       className="form-control"
                                       id="lastName"
                                       name="lastName"
                                       required
                                       placeholder="Enter brand"
                                       onChange={handleChange}
                                />
                                <label htmlFor="email">Email</label>
                                <input type="text"
                                       className="form-control"
                                       id="email"
                                       name="email"
                                       required
                                       placeholder="Enter email"
                                       onChange={handleChange}
                                />
                                <label htmlFor="password">Password</label>
                                <input type="password"
                                       className="form-control"
                                       id="password"
                                       name="password"
                                       required
                                       placeholder="Enter Password"
                                       onChange={handleChange}
                                />
                                <label htmlFor="confirmPassword">Confirm Password</label>
                                <input type="password"
                                       className="form-control"
                                       id="confirmPassword"
                                       name="confirmPassword"
                                       required
                                       placeholder="Confirm password"
                                       onChange={handleChange}
                                />
                            </div>
                            <br/>
                            <button id="submit" type="submit" className="btn btn-outline-dark">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Registration;