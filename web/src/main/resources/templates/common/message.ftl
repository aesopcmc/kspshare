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
			<div class="row module-container">
				<#if RequestParameters['type']?? && RequestParameters['type']=="info">
					<p class="messageType-info">
						<i class="fa fa-info-circle fa-4x" ></i>
					</p>
				</#if>
				<#if RequestParameters['type']?? && RequestParameters['type']=="success">
					<p class="messageType-success">
						<i class="fa fa-check-circle fa-4x" ></i>
					</p>
				</#if>
				<p style="text-align: center">
					${RequestParameters['message']!''}
				</p>
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
