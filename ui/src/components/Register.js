import React, { Component } from "react";
import { TextField, Button } from '@material-ui/core';

class Register extends Component{
    render(){
        return (
            <div>
                <TextField autoFocus name="email" label="Email" /> <br />
                <TextField name="firstname" label="First Name" /> <br />
                <TextField name="lastname" label="Last Name" /> <br />
                <TextField name="password" label="Password" /> <br />
                <TextField name="confirmPassword" label="Confirm Password" /> <br />
                <Button style={{ marginTop: 20}} variant="contained" color="primary">Register</Button>
            </div>
        )
    }
}

export default Register;