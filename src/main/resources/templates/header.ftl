<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/jquery.min.js"></script>
    <link rel="stylesheet" href="https://s2.pstatp.com/cdn/expire-1-M/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="../js/popper.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../shards-ui-master/dist/css/shards.css">
    <link rel="stylesheet" href="../shards-ui-master/dist/css/shards-extras.css">
    <link href="../css/bootstrap-table.min.css" rel="stylesheet">
    <script src="../js/bootstrap-table.min.js"></script>
    <script src="../js/bootstrap-table-zh-CN.js"></script>
    <style>
        .blog-article-list{
            margin-bottom: 3rem;
        }
        .blog-content{
            margin-top: 10px;
        }
        .blog-left-card{
            width: 100%;
            margin-bottom: 1rem;
        }
        .blog-main-content{
            margin-bottom: 1rem;
        }
        .blog-article-comment{
            margin-top: 1rem;
        }
        .blog-usre-header{
            width: 40px;
            height: 40px;
        }
        .navbar{
             padding: 0.5rem;
        }
        .article-img{
            width: 100%;
        }

        .hidden-course-detail{
            width: 100%;
            height: 0;
            visibility: hidden;
            transition: height 1s;
        }

        /*.collapse{display:none}*/

        /*.toggle-body{*/
            /*display: none;*/
        /*}*/
        /*@media screen and (max-device-width: 600px) {*/
            /*.navbar-dispaly{*/
                /*height:0px;*/
            /*}*/
        /*}*/

    </style>
</head>
<body>
<nav class="navbar navbar-dark bg-secondary navbar-expand-lg">
    <a class="navbar-brand" href="/index">Sign</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"   aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse navbar-dispaly" sid="navbarSupportedContent" id="navbarSupportedContent" >
        <ul id="navbar-ul" class="navbar-nav mr-auto">
            <#--<li class="nav-item <#if path == 'index'>active</#if>">-->
                <#--<a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a>-->
            <#--</li>-->
            <#--<li class="nav-item <#if path == 'articles'>active</#if> ">-->
                <a class="nav-link" href="/course/page">SignPage</a>
            <#--</li>-->
        </ul>
    </div>
</nav>
<div class="container blog-content">

    <div class="row">
        <div class="col-xl-8 blog-main-content">
