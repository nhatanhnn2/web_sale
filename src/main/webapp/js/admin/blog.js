jQuery(function ($) {
    $(document).ready(function () {
        function getListBlog(dataSearch){
            jQuery.ajax({
                url: "/api/admin/blog/list",
                method: "POST",
                headers: {"AUTH-TOKEN": localStorage.getItem("access-token")},
                data: JSON.stringify(dataSearch),
                contentType: "application/json",
                success: function (result) {
                    var listBlog = result.listData;
                    showBlog(listBlog);
                },
                error: function (err) {
                    alert("Fail")
                    console.log(JSON.stringify(err))
                }

            })


        };

        $('#search-blog').click(function (){
            var dataSearch = getDataSearch();
            getListBlog(dataSearch);
        });

        function showBlog(data){
            var s = '';
            if (data.length === 0){

            }
            $(data).each(function (index, v){
                s+= '<tr>'
                    +'<td>' + v.content + '</td>'
                    +'<td>' + v.description + '</td>'
                s+='<td><a href="/admin/blog/edit-blog/' + v.id + '"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a></td>'

                    +'</tr>';
            })
            $('#list-blog').html(s);
        }

        function getDataSearch(){
            var data = {};
            data['page'] = 1;
            data['pageSize'] = 2;
            data['content'] = $('#search-content').val();
            data['description'] = '';
            return data;
        }

    });
});