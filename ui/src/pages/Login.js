import React, { Component } from "react";
import LoginForm from "./../components/LoginForm";
import MessageBar from "./../components/MessageBar";

class Login extends Component {
  constructor(props) {
    super(props);
    this.state={
        message: {
            message: '',
            severity: '',
            open: false
        }
    }

    this.displayMessage = this.displayMessage.bind(this);
    this.hideMessage = this.hideMessage.bind(this);
  }

  displayMessage(message){
    this.setState({
        message: {
            message: message.message,
            severity: message.severity,
            open: true
        }
    });
  }

  hideMessage(){
      this.setState({
        message: {
            open: false
        }
      });
  }

  render() {
    return (
        <React.Fragment>
            <MessageBar {...this.state.message} onClose={this.hideMessage} />
            <LoginForm displayMessage={this.displayMessage} />
        </React.Fragment>
    );
  }
}

export default Login;
