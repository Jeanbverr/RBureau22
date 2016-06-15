function  gettingJSON(id) {

    $.getJSON("http://api.openweathermap.org/data/2.5/weather?id=" + id + "&appid=34b463766284143afb6c59bc98bb34c0", function (json) {
//        document.getElementById('myDiv').innerHTML = "http://api.openweathermap.org/data/2.5/weather?id=" + id + "&appid=34b463766284143afb6c59bc98bb34c0";
        var temp = parseInt(json.main.temp);
        temp = temp - 273,
                document.innerHTML = temp;
//          document.getElementById('myDiv').innerHTML = temp;
        return false;
    });

}



window.onload = function findTemperatureCity() {
    //var id = $(".myDiv").attr("value");77

    $(".myDiv").each(function () {
        var temp;
        var div = $(this);
        
        var name = $(this).attr("value");
//        console.log(id);

        $.getJSON("http://api.openweathermap.org/data/2.5/weather?q=" + name + "&appid=34b463766284143afb6c59bc98bb34c0", function (json) {
//        document.getElementById('myDiv').innerHTML = "http://api.openweathermap.org/data/2.5/weather?id=" + id + "&appid=34b463766284143afb6c59bc98bb34c0";
            console.log("name: " + name);
            temp = parseInt(json.main.temp);
            console.log(json.weather[0].icon);
            src = "http://openweathermap.org/img/w/" + json.weather[0].icon + ".png";
            temp = temp - 273;
            div.find("p").html(temp + " °C");
            div.find("img").attr("src",src);
//            div.html(temp + " °C");
            console.log(temp);
        });
//        console.log("temperatuur: " +temp);
//        $(this).html(temp.toString());

//    var id =  document.getElementsByClassName("myDiv")[0].value; 
//   alert(id);
//    alert(test);
//    gettingJSON(id);

    });
//body.onload = function findTemperatureCity(id) {
//    gettingJSON(id);
//    return false;
//};
}