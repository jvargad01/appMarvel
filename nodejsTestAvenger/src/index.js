import express from 'express'
import Request from 'request'

const app = express()
 
// settings
app.set("port", process.env.PORT || 80);
   

Request.post({
    "headers": { "content-type": "application/json" },
    "url": "http://127.0.0.1:8081/api/v1/domain/services/marvel/retrive/colaborators",
    "body": JSON.stringify({
        "name": "Iron Man" 
    })
}, (error, response, body) => {
    if(error) {
        return console.dir(error);
    }
    console.log("**** Consulta de colaborators de Iron Man ****"); 
    console.dir(JSON.parse(body));
});



Request.post({
    "headers": { "content-type": "application/json" },
    "url": "http://127.0.0.1:8081/api/v1/domain/services/marvel/retrive/characters",
    "body": JSON.stringify({
        "name": "Iron Man" 
    })
}, (error, response, body) => {
    if(error) {
        return console.dir(error);
    }
    console.log("**** Consulta de characters de Iron Man ****"); 
    console.dir(JSON.parse(body));
});

app.listen(app.get("port"))
console.log("listener port: ", app.get("port"));