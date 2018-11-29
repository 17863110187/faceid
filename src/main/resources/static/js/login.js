

$("#submit").click(function () {
    $.ajax({
        type: "POST",
        dataType:"json",
        url:"/user/login",
        data: {
            id: $("#inputUsername").val(),
            psw: $("#inputPassword").val()
        },
        async: false,
        success: function (data) {
            if(data.success){
                alert(data.message);
            }else {
                alert(data.message);
            }
        }
    });
});