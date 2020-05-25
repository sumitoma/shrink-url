const express = require('express');
const process = require('process');
const app = express();
const PORT = process.env.PORT? process.env.PORT: 3000;

const UrlService = require('./services/UrlService');

app.use('/urls', UrlService);

app.listen(PORT, ()=>{
    console.log(`server is listening on port: ${PORT}`);
});