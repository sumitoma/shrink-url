const express = require('express');
const router = express.Router();
const bodyParser = require('body-parser');
const process = require('process');
const UrlComponent = require('../components/UrlComponent');

const urlArray = [];
/**
 * creates minimized url
 */
router.post('/', bodyParser.json(), (req, res)=>{
        const body = req.body;
        if(body && body.originalUrl){
            const urlId = UrlComponent.minimizeUrl(body.originalUrl);
            urlArray.push({
                id: urlId,
                originalUrl: body.originalUrl
            });
            res.send({
                originalUrl: body.originalUrl,
                shrinkedUrl: UrlComponent.authority() + "/" + urlId
            });
        } else {
            res.sendStatus(400);
        }
    })

/**
 * returns original url for id
 */
router.get('/:id', (req, res)=>{
        const id = req.params.id;
        if(id){
            const url = urlArray.find(url => url.id === id);
            if(url){
                res.set('Location', url.originalUrl);
                res.sendStatus(302);
            } else {
                res.sendStatus(404);
            }
        } else {
            res.sendStatus(400);
        }
    });

module.exports = router;