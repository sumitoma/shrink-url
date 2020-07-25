import React, { Component } from "react";
import { TextField, Button, Container, Avatar, Typography } from "@material-ui/core";
import {withStyles} from "@material-ui/core/styles";
import { LockOutlined as LockOutlinedIcon } from "@material-ui/icons";

const useStyles = (theme)=>({
    formContainer: {
        marginTop: theme.spacing(2),
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center'
    },
    avatar: {
        margin: theme.spacing(1.5),
        backgroundColor: theme.palette.secondary.main
    },
    submitButton: {
        margin: theme.spacing(2, 0, 2)
    }
});

class LoginForm extends Component{

    constructor(props){
        super(props);
        this.state = {
            loginStatus: ''
        }
        this.onLogin = this.onLogin.bind(this);
    }

    onLogin(){
        this.setState({
            loginStatus: 'Succeeded!'
        });
    }

    render(){
        const { classes } = this.props;
        return (
            <Container maxWidth="xs">
                <div className={classes.formContainer}>
                    <Avatar className={classes.avatar}><LockOutlinedIcon /></Avatar>
                    <TextField autoFocus required margin="normal" name="username" label="Username" variant="outlined" fullWidth/> 
                    <TextField name="password" margin="normal" required label="Password" type="password" variant="outlined" fullWidth/> 
                    <Button onClick={this.onLogin} className={classes.submitButton} variant="contained" color="primary" fullWidth>Login</Button>
                    <Typography color="textPrimary">{this.state.loginStatus}</Typography>
                </div> 
            </Container>
        )
    }
}

export default withStyles(useStyles)(LoginForm);