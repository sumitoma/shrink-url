import React, { Component } from "react";
import { TextField, Button } from "@material-ui/core";

class Login extends Component{
    render(){
        return (
            <div>
                <TextField autoFocus name="username" label="Username" /> <br />
                <TextField name="password" label="Password" type="password" /> <br />
                <Button style={{ marginTop: 20}} variant="contained" color="primary">Login</Button>
            </div>
        )
    }
}

export default Login;