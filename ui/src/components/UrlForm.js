import React, { useState } from "react";
import { TextField, Button, Typography} from '@material-ui/core';


function UrlForm(props){
    
    const [url, setUrl] = useState('');
    const [minimizedUrl, setMinimizedUrl] = useState(url);

    function onClick(event){
        setMinimizedUrl( url + "minimized");
    };
    
   function onUrlChange(event){
        setUrl(event.target.vale);
    };

    return  (
        <div>
            <TextField name="url" style={{ minWidth: 400}} label="URL" autoFocus
             onChange={onUrlChange}></TextField>  
            <Button variant="contained" color="primary"
            onClick={onClick}>
                Shrink
            </Button>
            <Typography>{minimizedUrl}</Typography>
        </div>
    );

}

export default UrlForm;