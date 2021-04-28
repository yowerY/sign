
<#include "header.ftl">
<div class="col-sm-6">
    <table id="data-table"></table>
</div>


<#include "footer.ftl">
</div>

</body>


<script>
    $(document).ready(function(){
        $('#data-table').bootstrapTable({
            columns: [{
                field: 'name',
                title: '培训内容'
            }, {
                field: 'courseUserName',
                title: '主讲人'
            }, {
                field: 'startTime',
                title: '开始时间'
            },{
                field: 'departmentName',
                title: '部门'
            }],
            data: [],
            //是否显示行间隔色
            striped: true,
            //是否显示分页
            pagination: true,
            //每页的记录行数
            pageSize: 10,
            //初始化加载第1页，默认第1页
            pageNumber: 1,
            //可供选择的每页的行数
            pageList: "[1,10,20]",
            paginationFirstText: "首页",
            paginationPreText: "上一页",
            paginationNextText: "下一页",
            paginationLastText: "末页",
            pagination:true,
            sidePagination: 'server',
            queryParams : function(params) {//上传服务器的参数
                var temp = {
                    current :params.offset + 1,// SQL语句起始索引
                    size : params.limit  // 每页显示数量
                };
                return temp;
            },
            url:"/course/queryPage",
        });
    })
</script>
<link href="../css/accordion.css" rel="stylesheet">
</html>