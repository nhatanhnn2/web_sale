jQuery(function ($) {
    $(document).ready(function () {
        $('#createUserBtn').click(function () {
            createUser();
        });
    });

    function createUser() {
        let user = {
            email: $('#email').val(),
            name: $('#name').val(),
            phone: $('#phone').val(),
            role: $('#role').val()
        };

        $.ajax({
            url: "/api/admin/user/create",
            method: "POST",
            headers: {
                "AUTH-TOKEN": localStorage.getItem("access-token")
            },
            contentType: "application/json",
            data: JSON.stringify(user),
            success: function (result) {
                alert("User created successfully!");
                console.log(result);
                window.location.href = "/admin/user/list";
            },
            error: function (err) {
                alert("Failed to create user!");
                console.log(JSON.stringify(err));
            }
        });
    }
});
