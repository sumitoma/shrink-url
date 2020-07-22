import React, { Component, Fragment } from "react";
import "./App.css";
import { Button, Typography, AppBar, Toolbar, TextField } from "@material-ui/core";
import { withStyles } from "@material-ui/core/styles"; 

const useStyles = theme => ({
  helloThereStyle : {
    color: 'red'
  }
}); 

class App extends Component {
  state = {
    url: "",
    minimizedUrl: this.url
  };


  onClick = (event) => {
    
    this.setState({
      minimizedUrl: this.state.url + "minimized"
    });
  };

  onChange = (event) => {
    this.setState({
      url: event.target.value
    });
  };

  render() {
    const { classes } = this.props;
    return (
      <div class="App">
        <AppBar position="static">
          <Toolbar>
            <Typography variant="h6" style={{flexGrow: 1}}>Shrink Url</Typography>
            <Button color="inherit">Register</Button>
            <Button color="inherit">Login</Button>
          </Toolbar>
        </AppBar>
        <div style={{marginTop: 40}}>
          <TextField style={{ minWidth: 400}} label="URL" autoFocus
            onChange={this.onChange}></TextField>  
          <Button variant="contained" color="primary"
          onClick={this.onClick}>
            Shrink
          </Button>
          <Typography>{this.state.minimizedUrl}</Typography>
        </div>
      </div>
    );
  }
}

export default withStyles(useStyles)(App);
