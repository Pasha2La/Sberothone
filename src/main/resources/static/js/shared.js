function openMenu() {
    var menu = $('#menu')[0];
    if(menu.style.display == 'none') {
        console.dir(menu);
        menu.style.display = 'block';
    } else {
        menu.style.display = 'none';
    }
}
function checkAuth(e) {
    var $form = $('#auth_form');
    var status = null;
    var login = $form[0][0].value;
    var password = $form[0][1].value;
    var info = {
        "login": login,
        "password": password
    };
    $.ajax({
        type: $form.attr('method'),
        url: $form.attr('action'),
        data: JSON.stringify(info),
        contentType: "application/json",
        async: false,
        success: function (data) {
            status = JSON.parse(data).code[0];
        }
    });
    console.log(status);
    if(status == 200) {
        window.location.href = "/account?login=" + login;
    } else {
        alert("fail");
    }
    e.preventDefault();
}