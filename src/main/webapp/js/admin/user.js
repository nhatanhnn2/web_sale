jQuery(function ($) {
    $(document).ready(function () {

        getListUser(getDataSearch());
        function getListUser(dataSearch){
            jQuery.ajax({
                url: "/api/admin/user/list",
                method: "POST",
                headers: {"AUTH-TOKEN": localStorage.getItem("access-token")},
                data: JSON.stringify(dataSearch),
                contentType: "application/json",
                success: function (result) {
                    var listUser = result.listData;
                    showUser(listUser);
                },
                error: function (err) {
                    alert("Fail")
                    console.log(JSON.stringify(err))
                }

            })

        };

        $("#add-user").click(function() {
            window.location.href = "/admin/createUser";
        });

        $('#search-user').click(function (){
            var dataSearch = getDataSearch();
            getListUser(dataSearch);
        });

        function showUser(data){
            var s = '';
            if (data.length === 0){

            }
            $(data).each(function (index, v){
                s+= '<tr>'
                    +'<td>' + v.name + '</td>'
                    +'<td>' + v.email + '</td>'
                    +'<td>' + v.phone + '</td>'
                    if(v.gender == 1){
                        s+='<td>nam</td>'
                    }

                    if(v.gender == 0){
                        s+='<td>nữ</td>'
                    }

                    if(v.status == 1){
                        s+='<td>Đang hoạt động</td>'
                    }
                    if(v.status == 0){
                        s+='<td>Không hoạt động</td>'
                    }
                    // s+='<td><a href="/admin/user/create-profile/' + v.id + '"><i class="fa fa-plus" aria-hidden="true"></i></a></td>'
                    s+='<td><a href="/admin/user/edit-profile/' + v.id + '"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a></td>'
                +'</tr>';
            })
            $('#list-user').html(s);
        }

        function getDataSearch(){
            var data = {};
            data['page'] = 1;
            data['pageSize'] = 10;
            data['name'] = $('#search-name').val();
            data['status'] = '';
            return data;
        }

    });
});