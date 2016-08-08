var corcovado = {
    getCookie : function(url, successCallback, errorCallback){
        cordova.exec(successCallback, errorCallback, 'Corcovado', 'getCookie', [url]);
    },
    setCookie : function(url, cookie, successCallback, errorCallback){
        cordova.exec(successCallback, errorCallback, 'Corcovado', 'setCookie', [url, cookie]);
    },
    clearCookies : function(successCallback, errorCallback){
        cordova.exec(successCallback, errorCallback, 'Corcovado', 'clearCookies', []);
    }
};
module.exports = corcovado;
