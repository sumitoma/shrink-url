const crypto = require('crypto');
const process = require('process');

class UrlComponent {

    static minimizeUrl(url){
        return crypto.Hash('md5').update(url).digest('base64');
    }

    static authority(){
        return (process.env.HOST ? process.env.HOST : 'localhost')
        + (process.env.PORT ? ":" + process.env.PORT : ':3000');
    }

}

module.exports = UrlComponent;