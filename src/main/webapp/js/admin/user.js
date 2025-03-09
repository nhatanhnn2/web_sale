jQuery(function ($) {
    $(document).ready(function () {

        function getListUser(dataSearch){
            $.ajax({
                url: "/admin/api/user/list",
                method: "GET",
                // headers: {"X-AUTH-TOKEN": localStorage.getItem("access-token")},
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
                    +'<td>' + v.gender + '</td>'
                    +'<td>' + v.status + '</td>'
                +'</tr>';
            })
            $('#list-user').html(s);
        }

        function getDataSearch(){
            var data = {};
            data['page'] = 1;
            data['pageSize'] = 2;
            data['name'] = '';
            data['status'] = '';
            return data;
        }

    });
});