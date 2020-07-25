import React, { Component } from 'react';
import { Alert } from '@material-ui/lab';
import { Snackbar } from '@material-ui/core';

class MessageBar extends Component{
    constructor(props){
        super(props);
        this.onMessageClose = this.onMessageClose.bind(this);
    }



    onMessageClose(event, reason){
        if(reason === "clickaway"){
            return;
        }
        this.props.onClose();
    }

    render(){
        const { message, severity, open } = this.props; 
        
        return(
             <Snackbar anchorOrigin={{ vertical: 'top', horizontal: 'right'}} open={open} autoHideDuration={5000} onClose={this.onMessageClose} >
                <Alert elevation={6} variant="filled" onClose={this.onMessageClose} severity={severity}>
                    {message}
                </Alert>    
             </Snackbar>
        );
    }
}

export default MessageBar;