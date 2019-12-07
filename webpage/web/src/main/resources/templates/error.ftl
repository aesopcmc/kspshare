<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户资料</title>

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i&amp;subset=latin-ext"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:300,400,700&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,500,500i,700,700i,900,900i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,300i,400,400i,700,700i,900&amp;subset=latin-ext" rel="stylesheet">

    <link href="${ctx.contextPath}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${ctx.contextPath}/plugin/flexslider/flexslider.css" rel="stylesheet">
    <link href="${ctx.contextPath}/plugin/slicknav/slicknav.min.css" rel="stylesheet">
    <link href="${ctx.contextPath}/css/main.css" rel="stylesheet">

<#--jq需要放在顶部-->
    <script src="${ctx.contextPath}/plugin/jquery-3.1.1.min.js"></script>
    <script src="${ctx.contextPath}/plugin/jquery-migrate.min.js"></script>


</head>

<body>
<!-- header-->
	<#include "/common/hearder.ftl">

<!-- main-->
<div class="page-wrapper">
    <main class="container-message">
        <div class="row module-container message-container">
            <#if code==500>
                <p style="text-align: center;margin-bottom: 0px">
                    <img src="${ctx.contextPath}/images/error/500-3.png" width="20%" height="20%" alt=""/>
                    <br>
                    <span class="error-code">500</span>
                </p>
                <p style="text-align: center">
                    bibi ~ 服务器内部错误。崩溃啦 ！
                </p>

            <#elseif code==404>
                <p style="text-align: center;margin-bottom: 0px">
                    <img src="${ctx.contextPath}/images/error/404.png" width="14%" height="14%" alt=""/>
                    <br>
                    <span class="error-code">404</span>
                </p>
                <p style="text-align: center">
                    糟糕 ~ 您访问的页面飞走啦！
                </p>
            <#else>
                <p style="text-align: center;margin-bottom: 0px">
                    <img src="${ctx.contextPath}/images/error/404.png" width="14%" height="14%" alt=""/>
                    <br>
                    <span class="error-code">${code}</span>
                </p>
                <p style="text-align: center">
                    很抱歉出错啦 ！
                </p>
            </#if>

        </div>
    </main>
</div>

<!-- footer -->
	<#include "/common/footer.ftl">

<!-- Required Plugins and Scripts -->
<script src="${ctx.contextPath}/plugin/bootstrap/bootstrap.min.js"></script>
<script src="${ctx.contextPath}/plugin/flexslider/jquery.flexslider-min.js"></script>
<script src="${ctx.contextPath}/plugin/slicknav/jquery.slicknav.min.js"></script>
<script src="${ctx.contextPath}/js/common.js"></script>

</body>
</html>
