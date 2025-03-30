jQuery(function ($) {
    $(document).ready(function () {
        getAllRole();

        $('#btnCreate').click(function () {
            createUser();
        });

        $('#btnUpdate').click(function () {
            updateUser();
        });



        function getUser(id){
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
                    $('#roleId').val(result.roleId)
                    $('#status').val(result.status)
                    $('#gender').val(result.gender)
                },
                error: function (err) {
                    alert("Fail")
                    console.log(JSON.stringify(err))
                }
            })
        };

        function getAllRole(){
            jQuery.ajax({
                url: "/api/admin/role/getAll",
                method: "GET",
                headers: {"AUTH-TOKEN": localStorage.getItem("access-token")},
                contentType: "application/json",
                success: function (result) {
                    console.log(result)
                    var s = '';

                    $(result).each(function (index, v) {
                        s += '<option value="' + v.id + '">' + v.name + '</option>'
                    });
                    $('#roleId').html(s);

                    let userId = $('#userId').val();
                    if (userId){
                        getUser(userId);
                        $('#btnCreate').hide();
                    }  else {
                        $('#btnUpdate').hide();
                    }
                },
                error: function (err) {
                    alert("Fail")
                    console.log(JSON.stringify(err))
                }
            })
        };

        function createUser() {
            let data = getDataForm();

            jQuery.ajax({
                url: "/api/admin/user/create",
                method: "POST",
                headers: {
                    "AUTH-TOKEN": localStorage.getItem("access-token")
                },
                contentType: "application/json",
                data: JSON.stringify(data),
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



        function getDataForm() {
            var data = {};
            var formData = $('#formSubmit').serializeArray();
            $.each(formData, function (i, v) {
                data["" + v.name + ""] = v.value;
            });
            return data;
        }

    })
});