/**
 * Created with IntelliJ IDEA.
 * User: karmstrong
 * Date: 12/13/12
 * Time: 9:56 AM
 * To change this template use File | Settings | File Templates.
 */
var dojoConfig = {
    baseUrl: "http://mpagesmock01/cdn/libs/",
    async: 1,
    cacheBust: 1,
    parseOnLoad: true,
    tlmSiblingOfDojo: true,
    packages: [
        { name: "dojo", location: "dojo/1.8.0/sdk/dojo" },
        { name: "dijit", location: "dojo/1.8.0/sdk/dijit" },
        { name: "dojox", location: "dojo/1.8.0/sdk/dojox" },
        { name: "dgrid", location: "dojo/1.8.0/sdk/dgrid" },
        { name: "put-selector", location: "dojo/1.8.0/sdk/put-selector" },
        { name: "xstyle", location: "dojo/1.8.0/sdk/xstyle" },
        { name: "bootstrap", location: "bootstrap" }
    ]
};