import React, {useState} from 'react';


function Login(props) {

    const [formData, updateFormData] = React.useState({
        email: "",
        password: ""
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const email = formData.email;
        const password = formData.password;
        props.onLogin(email, password);
    }

    return (
        <div className={"row"}>
            <div className={"col-md-6 offset-md-3"}>
                <div className="form">
                    <div className="form-body">
                        <form onSubmit={onFormSubmit}>
                            <div className="form-group">
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

export default Login;