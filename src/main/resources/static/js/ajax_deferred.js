var loadingInterval = function(func) {
    var def = $.Deferred();
    try {
        func();
        def.resolve("success")
    } catch (e) {
        def.error(e);
    }
    return def.promise();
};
setInterval(function () {
    $.when(loadingInterval(getWeather), loadingInterval(getFineDust)).done(function (re1, re2) {
        console.log(re1, re2);
    });
}, 38000);

