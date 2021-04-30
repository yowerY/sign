
<#include "header.ftl">
<div class="container">
    <div class="commentbox">
        <textarea cols="80" rows="50" placeholder="来说几句吧......" class="mytextarea" id="content"></textarea>
        <div>
        <div class="btn btn-info pull-right" style="margin-top: 12px;" id="comment">评论</div>

        <div class="rating-stars block">
            <div class="rating-stars-container">
                <div class="rating-star">
                    <i class="fa fa-star"></i>
                </div>
                <div class="rating-star">
                    <i class="fa fa-star"></i>
                </div>
                <div class="rating-star">
                    <i class="fa fa-star"></i>
                </div>
                <div class="rating-star">
                    <i class="fa fa-star"></i>
                </div>
                <div class="rating-star">
                    <i class="fa fa-star"></i>
                </div>
            </div>
        </div>
        </div>

    </div>
    <div class="comment-list">
        <#list list as comment>
            <div class="comment-info">
                <header><img src="../images/git.png"></header>
                <div class="comment-right">
                    <h3>匿名</h3>
                    <div class="comment-content-header">
                        <span>
                            <i class="glyphicon glyphicon-time"></i> ${comment.commentTime?string('yyyy-MM-dd HH:mm:ss')}
                        </span>
                        <#--<span>-->
                            <#--<i class="glyphicon glyphicon-map-marker"></i>深圳-->
                        <#--</span>-->
                    </div>
                    <p class="content">
                        ${comment.comment}
                    </p>
                    <div class="comment-content-footer">
                        <#--<div class="row">-->
                            <#--<div class="col-md-10">-->
                                <#--<span><i class="glyphicon glyphicon-pushpin"></i> 来自:win10 </span><span><i class="glyphicon glyphicon-globe"></i> chrome 55.0.2883.87</span>-->
                            <#--</div>-->
                            <#--<div class="col-md-2"><span class="reply-btn">回复</span></div>-->
                        <#--</div>-->
                    </div>
                    <div class="reply-list"></div>
                </div>
            </div>
        </#list>
    </div>
</div>


<#include "footer.ftl">
</div>

</body>

<script>
        $(function(){
            $("#comment").click(function(){
                var content=$("#content").val();

                if(!content || content == ''){
                    alert("请填写评论");
                    return;
                }
                var courseId = getUrlParam("courseId");
                var level = $(".is--active").length;
                if(level == 0){
                    alert("请先评分");
                    return;
                }

                $.ajax({
                    url: '/courseComment/add',
                    data: {comment: content,courseId:courseId,level:level},
                    type: "post",
                    success: function (ret) {
                        if (ret.code == '200') {
                            window.location.reload();
                        } else {
                            alert(ret.message);
                        }
                    }
                });

            });
        })

        function getUrlParam(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
            var r = window.location.search.substr(1).match(reg);  //匹配目标参数
            if (r != null) return unescape(r[2]); return null; //返回参数值
        }

       $(document).ready(function () {
           var ratingOptions = {
               selectors: {
                   starsSelector: '.rating-stars',
                   starSelector: '.rating-star',
                   starActiveClass: 'is--active',
                   starHoverClass: 'is--hover',
                   starNoHoverClass: 'is--no-hover',
                   targetFormElementSelector: '.rating-value'
               }
           };

           $(".rating-stars").ratingStars(ratingOptions);
           $(".rating-stars").on("ratingChanged", function (ev, data) {
               $("#ratingChanged").html(data.ratingValue);
           });

           $(".rating-stars").on("ratingOnEnter", function (ev, data) {
               $("#ratingOnEnter").html(data.ratingValue);
           });

           $(".rating-stars").on("ratingOnLeave", function (ev, data) {
               $("#ratingOnLeave").html(data.ratingValue);
           });
       })

</script>
<link href="../css/accordion.css" rel="stylesheet">
<link href="../css/star.css" rel="stylesheet">
<link href="../css/comment.css" rel="stylesheet">
<script src="../js/jquery.comment.js"></script>
<script src="../js/jquery.rating-stars.min.js"></script>
<style>



</style>
</html>