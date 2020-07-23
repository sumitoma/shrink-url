import React, { Component } from "react";
import { TextField, Button, Typography} from '@material-ui/core';

class UrlForm extends Component{

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
          [event.target.name]: event.target.value
        });
    };

    render(){
        return (
            <div>
                <TextField name="url" style={{ minWidth: 400}} label="URL" autoFocus
                 onChange={this.onChange}></TextField>  
                <Button variant="contained" color="primary"
                onClick={this.onClick}>
                    Shrink
                </Button>
                <Typography>{this.state.minimizedUrl}</Typography>
            </div>
        )
    }
}

export default UrlForm;