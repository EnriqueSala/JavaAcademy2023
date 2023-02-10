$(document).ready(function() {
    $.get("localhost:8080/usuario/1", function(data){
        console.log(data);
    })
});