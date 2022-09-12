import React from "react";


const AddMoney = (props) => {

    const [formData, updateFormData] = React.useState({
        amount: 0.
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const amount = formData.amount;
        console.log(amount)
        props.onAddMoney(amount);
    }

    return (
        <div className={"row"}>
            <div className={"col-md-6 offset-md-3"}>
                <div className="form">
                    <div className="form-body">
                        <form onSubmit={onFormSubmit}>
                            <div className="form-group">
                                <label htmlFor="amount">Amount</label>
                                <input type="number"
                                       className="form-control"
                                       id="amount"
                                       name="amount"
                                       required
                                       placeholder="Enter amount you want toa add"
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

export default AddMoney