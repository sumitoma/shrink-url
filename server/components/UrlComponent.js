const crypto = require('crypto');

class UrlComponent {

    static minimizeUrl(url){
        return crypto.Hash('md5').update(url).digest('base64');
    }


}

module.exports = UrlComponent;