#!/usr/bin/env node

'use strict';

//
// includes
//
var fs = require('fs');
var sqlite3 = require('sqlite3').verbose();
var express = require('express');
var morgan = require('morgan');
var bodyParser = require('body-parser');
var methodOverride = require('method-override');

//
// only continue if the database exists
//
var repository = 'db.sqlite';
fs.exists(repository, function (exists) {
    if (exists) {
        var db = new sqlite3.Database(repository);    
        
        var server = express();
        
        var port = process.env.PORT || 3000;
        
        // configuration
        server.use(express.static(__dirname + '/public'));
        server.use(morgan('dev'));
        server.use(bodyParser.urlencoded({'extended':'true'}));
        server.use(bodyParser.json());
        server.use(bodyParser.json({ type: 'application/vnd.api+json' }));
        server.use(methodOverride('X-HTTP-Method-Override'));
        
    // routes  ------------------------------------
        // api  ----------------------------------------
        // get all states
        server.get('/api/states', function (req, res) {
            db.serialize(function () {
               var rtn = [];
                var stmt = 'SELECT * FROM states';
                db.each(stmt, function(err, row) {
                    if (err) {
                        res.send(err);
                    }
                    rtn.push(row.state);                    
                }, function () {                
                    res.json(rtn);    
                }); 
            });                        
        });
        
        //get number of cities in states
        server.get('/api/states/cities/count', function (req, res) {
            db.serialize(function () {
               var rtn = [];
                var stmt = 'SELECT state, count(City) as cities FROM vw_zipcodes group by state order by cities desc';
                db.each(stmt, function(err, row) {
                    if (err) {
                        res.send(err);
                    }
                    rtn.push([row.state, row.cities]);                    
                }, function () {                
                    res.json(rtn);    
                }); 
            });                        
        });
        
        //get city, state by zipcode
        server.get('/api/zip/:code', function (req, res) {
            db.serialize(function () {
               var rtn = [];
                var stmt = 'SELECT Zipcode as zipcode, ZipCodeType as zipcodetype, City as city, abbr, state FROM vw_zipcodes WHERE Zipcode LIKE "' + req.params.code + '%"';
                db.each(stmt, function(err, row) {
                    if (err) {
                        res.send(err);
                    }
                    rtn.push(row);                    
                }, function () {                
                    res.json(rtn);    
                }); 
            });    
        });
                
        // application ----------------------------------------
        server.get('*', function (req, res) {
            var fileName = 'index.html';
            var options = {
                root: __dirname + '/public',
                dotfiles: 'deny',
                headers: {
                    'x-timestamp': Date.now(),
                    'x-sent': true
                }
            };
            res.sendFile(fileName, options, function (err) {
                if (err) {
                    console.log(err);
                    res.status(err.status).end();
                    //db.close();
                }   
            }); 
        });
        
        server.listen(port);        
        console.log('Server listening on port ' + port);
        
        //db.close();
    } else {
        console.log('Database does not exist, run broker_node_init.js first.');
    }
});