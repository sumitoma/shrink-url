import React, { Component } from 'react';
import {AppBar, Toolbar, Typography, Button} from '@material-ui/core';
import { withRouter } from 'react-router-dom';

class AppHeader extends Component{

    render(){
        const { history } = this.props; 
        return (
            <AppBar position="static">
              <Toolbar>
                <Typography variant="h6" style={{flexGrow: 1}}>Cloud Console</Typography>
                <Button color="inherit" onClick={()=>{ history.push('/login') }}>Login</Button>
                <Button color="inherit" onClick={()=>{ history.push('/register')}}>Sign Up</Button>
              </Toolbar>
            </AppBar>
        )
    }
}

export default withRouter(AppHeader);
