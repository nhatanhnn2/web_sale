$("#loginForm").submit(function (e) {
    e.preventDefault();
    var formData = $("#loginForm").serializeArray();
    var data = {};
    $.each(formData, function (i, v) {
        data["" + v.name + ""] = v.value;
    });
    $.ajax({
        url: "/api/auth/login",
        method: "POST",
        data: JSON.stringify(data),
        contentType: "application/json",
        success: function (result) {
            localStorage.setItem("access-token", result.jwt);
            window.location.href = "/admin/home";
        },
        error: function (err) {
            alert("Sai tài khoản hoặc mật khẩu")
            console.log(JSON.stringify(err))
        }

    })
});