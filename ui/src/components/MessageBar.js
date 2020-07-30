import React, { userState } from 'react';
import { Alert } from '@material-ui/lab';
import { Snackbar } from '@material-ui/core';

function MessageBar(props){
    const { message, severity, open } = props; 

    function onMessageClose(event, reason){
        if(reason === "clickaway"){
            return;
        }
        this.props.onClose();
    }

    return(
        <Snackbar anchorOrigin={{ vertical: 'top', horizontal: 'right'}} open={open} autoHideDuration={5000} onClose={onMessageClose} >
           <Alert elevation={6} variant="filled" onClose={onMessageClose} severity={severity}>
               {message}
           </Alert>    
        </Snackbar>
   );
}

export default MessageBar;