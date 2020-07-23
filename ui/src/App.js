import React, { Component } from "react";
import "./App.css";
import AppHeader from './components/AppHeaderBar';
import { withStyles } from "@material-ui/core/styles"; 
import UrlForm from "./components/UrlForm";
import Login from "./components/Login";
import Register from "./components/Register";

const useStyles = theme => ({
  helloThereStyle : {
    color: 'red'
  }
}); 

class App extends Component{

  state = {
    currentPage: 'urlForm'
  }

  onPageChange = (page)=>{
    this.setState({
      currentPage: page
    });
  }

  getCurrentPage(){
    switch(this.state.currentPage){
      case 'urlForm':
        return <UrlForm />;
      case 'login':
        return <Login />;
      case 'register':
        return <Register />; 
      default:
        return <Login />; 
    }
  }

  render() {
    const { classes } = this.props;

    return (
      <div>
        <AppHeader onPageChange={this.onPageChange} />
        <div style={{marginTop: 40, textAlign: 'center'}}>
          {this.getCurrentPage()}
        </div>
      </div>
    );
  }
}

export default withStyles(useStyles)(App);
