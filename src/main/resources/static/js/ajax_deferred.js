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

function getWeather() {

}

function getFineDust() {

}

function makeTopMenu() {

}

setInterval(function () {
    $.when(loadingInterval(makeTopMenu),
        loadingInterval(getWeather),
        loadingInterval(getFineDust)).done(function (re1, re2, re3) {
        console.log(re1, re2, re3);
    });
}, 38000);

