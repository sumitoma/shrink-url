import React, { Component } from 'react';
import {AppBar, Toolbar, Typography, Button} from '@material-ui/core';

class AppHeader extends Component{

    render(){
       
        return (
            <AppBar position="static">
              <Toolbar>
                <Typography variant="h6" style={{flexGrow: 1}}>Shrink Url</Typography>
                <Button color="inherit" onClick={()=>{  this.props.onPageChange("register")}}>Register</Button>
                <Button color="inherit" onClick={()=>{  this.props.onPageChange("login")}}>Login</Button>
              </Toolbar>
            </AppBar>
        )
    }
}

export default AppHeader;
