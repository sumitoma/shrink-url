import React, { Component } from "react";
import { TextField, Button, Container, Avatar, Paper, Grid } from '@material-ui/core';
import { LockOutlined as LockOutlinedIcon, FullscreenExit } from '@material-ui/icons';
import { withStyles } from '@material-ui/core/styles';

const useStyles= (theme) => ({
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

class RegisterForm extends Component{
    render(){
        const { classes  } = this.props ;
        return (
            <Container maxWidth="xs">
                <div className={classes.formContainer}>
                    <Avatar className={classes.avatar}><LockOutlinedIcon /></Avatar>
                    <Grid container spacing={2}>
                        <Grid item xs={12} sm={6}>
                            <TextField name="firstname" label="First Name" variant="outlined" fullWidth required autoFocus/>
                        </Grid>
                        <Grid item xs={12} sm={6}>
                            <TextField name="lastname" label="Last Name" variant="outlined" fullWidth required/>
                        </Grid>
                        <Grid item xs={12}>
                            <TextField name="email" label="Email" variant="outlined" fullWidth autoComplete="off" required/>
                        </Grid>
                        <Grid item xs={12} sm={6}>
                            <TextField name="password" label="Password" type="password" variant="outlined" fullWidth required/> 
                        </Grid>
                        <Grid item xs={12} sm={6}>
                            <TextField name="confirmPassword" label="Confirm Password" type="password" variant="outlined" fullWidth required/> 
                        </Grid>
                    </Grid>
                    <Button className={classes.submitButton} variant="contained" color="primary" fullWidth required>Sign Up</Button>
                </div>
            </Container>
        )
    }
}

export default withStyles(useStyles)(RegisterForm);