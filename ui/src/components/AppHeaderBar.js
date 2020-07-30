import React, { useState } from 'react';
import {AppBar, Toolbar, Typography, Button} from '@material-ui/core';
import { useHistory } from 'react-router-dom';


function AppHeader(props){

  const history = useHistory();

  return (
    <AppBar position="static">
      <Toolbar>
        <Typography variant="h6" style={{flexGrow: 1}}>Cloud Console</Typography>
        <Button color="inherit" onClick={()=>{ history.push('/login') }}>Login</Button>
        <Button color="inherit" onClick={()=>{ history.push('/register')}}>Sign Up</Button>
      </Toolbar>
    </AppBar>
  );

}

export default AppHeader;