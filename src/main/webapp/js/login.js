$("#loginForm").submit(function (e) {
    e.preventDefault();
    var formData = $("#loginForm").serializeArray();
    var data = {};
    $.each(formData, function (i, v) {
        data["" + v.name + ""] = v.value;
    });
    $.ajax({
        url: "/auth/login",
        method: "POST",
        data: JSON.stringify(data),
        contentType: "application/json",
        success: function (result) {
            localStorage.setItem("access-token", result.jwt);
            var href = result.redirectUrl;
            const token = localStorage.getItem("access-token");

            fetch(href, {
                method: "GET",
                headers: {
                    "Authorization": "Bearer " + token,
                    "Content-Type": "application/json"
                }
            })
                .then(response => {
                    if (response.ok) {
                        window.location.href = href;
                    } else {
                        alert("Access Denied");
                    }
                })
                .catch(error => console.error("Error:", error));

        },
        error: function (err) {
            alert("Sai tài khoản hoặc mật khẩu")
            console.log(JSON.stringify(err))
        }

    })
});