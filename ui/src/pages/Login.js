import React, { useState } from "react";
import LoginForm from "./../components/LoginForm";
import MessageBar from "./../components/MessageBar";


function Login(props){
  const [message, setMessage] = useState({
    message: '',
    severity: '',
    open: false
  });

  function displayMessage(message){
    setMessage({
      message: message.message,
      severity: message.severity,
      open: true
    });
  }

  function hideMessage(){
      setMessage({
        open: false
      })
  }

  return (
    <React.Fragment>
        <MessageBar {...message} onClose={hideMessage} />
        <LoginForm displayMessage={displayMessage} />
    </React.Fragment>
  );
}

export default Login;
