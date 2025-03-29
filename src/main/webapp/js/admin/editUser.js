jQuery(function ($) {
    $(document).ready(function () {
        let userId = $('#userId').val();
        getListUser(userId);

        function getListUser(id){
            jQuery.ajax({
                url: "/api/admin/user/get/"+id,
                method: "GET",
                headers: {"AUTH-TOKEN": localStorage.getItem("access-token")},
                contentType: "application/json",
                success: function (result) {
                    console.log(result)
                    $('#email').val(result.email)
                    $('#name').val(result.name)
                    $('#phone').val(result.phone)
                    $('#role').val(result.role)
                },
                error: function (err) {
                    alert("Fail")
                    console.log(JSON.stringify(err))
                }

            })


        };

    })
});