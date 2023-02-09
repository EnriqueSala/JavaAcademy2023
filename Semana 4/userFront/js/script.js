// function ajaxRequest(params) {
//     var url = 'localhost:8080/api/users/1'
//     $.get(url + '?' + $.param(params.data)).then(function (res) {
//       params.success(res)
//     })
//   }
//   var url = 'localhost:8080/api/users'

$(document).ready(function() {
    $.ajax({
        url: "localhost:8080/api/users/2"
    }).then(function(data) {
       $('.greeting-id').append(data.id);
       $('.greeting-content').append(data.firstName);
    });
});