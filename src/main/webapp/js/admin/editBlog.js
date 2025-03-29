jQuery(function ($) {
    $(document).ready(function () {
        let blogId = $('#blogId').val();
        getListBlog(blogId);

        function getListBlog(id){
            jQuery.ajax({
                url: "/api/admin/blog/get/"+id,
                method: "GET",
                headers: {"AUTH-TOKEN": localStorage.getItem("access-token")},
                contentType: "application/json",
                success: function (result) {
                    console.log(result)
                    $('#content').val(result.content)
                    $('#description').val(result.description)

                },
                error: function (err) {
                    alert("Fail")
                    console.log(JSON.stringify(err))
                }

            })


        };

    })
});