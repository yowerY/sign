<#include "header.ftl">
    <div class="container">
        <div class="row">
            <div class="col-md-offset-3 col-md-6">
                <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                    <#list courseList as course>
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="${course.id}-heading">
                                <h4 class="panel-title">
                                    <a role="button" data-toggle="collapse" data-parent="#accordion" href="#${course.id}-collapse" aria-expanded="false" aria-controls="${course.id}-collapse" class="collapsed">
                                        ${course.getName()}
                                        <#if course.status==1>
                                            <button style="margin-top: -2px;border-radius: 20px;float: right;disable" class="btn">
                                                未开始
                                            </button>
                                        </#if>
                                        <#if course.status==2>
                                            <button style="margin-top: -2px;border-radius: 20px;float: right;disable" class="btn btn-success">
                                                进行中
                                            </button>
                                        </#if>
                                        <#if course.status==3>
                                            <button style="margin-top: -2px;border-radius: 20px;float: right;disable" class="btn">
                                                已结束
                                            </button>
                                        </#if>

                                    </a>
                                </h4>
                            </div>
                            <div id="${course.id}-collapse" style="overflow: hidden ;"  class="" role="tabpanel" aria-labelledby="${course.id}-heading">
                                <div class="panel-body toggle-body" aria-labelledby="${course.id}-panel-body">
                                    <div style="background-color: rgb(246,235,172)">
                                        <p style="float: left;text-align: center">
                                            主讲:${course.courseUserName}
                                        <br/>
                                        ${course.startTime?string('MM-dd HH:mm')}
                                        </p>
                                        <#if course.status==2>
                                            <button style="float: right;margin-top: 3px" onclick="signRecord(${course.id})" type="button" style="float:right" class="btn btn-success signBtn">签到</button>
                                        </#if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </#list>
                </div>
            </div>
        </div>
    </div>

    <#include "footer.ftl">
    </div>

</body>
<link href="../css/accordion.css" rel="stylesheet">

<script>
        $(document).ready(function() {
            $("a").click(function(){
                var id = $(this).attr("aria-controls").split("-")[0];
                $("div[aria-labelledby="+id+"-panel-body]").toggleClass("toggle-body");
            })
        })

        function signRecord(id) {
            $.ajax({
                url: '/sign/add',
                data: {courseId: id},
                type: "post",
                success: function (ret) {
                    if (ret.code == '200') {
                        alert("签到成功")
                    } else {
                        alert(ret.message);
                    }
                }
            });
        }

    </script>
</html>