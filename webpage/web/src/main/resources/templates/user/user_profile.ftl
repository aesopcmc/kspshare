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
	<link href="${ctx.contextPath}/css/forum.css" rel="stylesheet">

	<#--jq需要放在顶部-->
    <script src="${ctx.contextPath}/plugin/jquery-3.1.1.min.js"></script>
    <script src="${ctx.contextPath}/plugin/jquery-migrate.min.js"></script>


</head>

<body>
	<!-- Header -->
	<#include "/common/hearder.ftl">
	<!-- Page Wrapper -->
	<div class="page-wrapper">
		<div class="services-page">
			<!-- Main Content -->
			<main id="main" class="main container">

				<div class="row module-container" style="background:transparent;border: none;">
					<div class="profile-head-panel">
						<div class="info-black">
							<a href="" class="user-head"><img src="${ctx.contextPath}/images/headx-profile.png" width="120px" height="120px"></a>
							<a href="" class="fa fa-photo head-upload"></a>
							<div class="user-btn-group">
								<span class="user-name">名字</span>
								<a href="" class="fa fa-plus follow"> 关注</a>
								<!--<a href="" class="fa fa-check following"> 已关注</a>-->
							</div>

							<ul class="user-head-inline">
								<li>
									<span class="name">发帖数</span>
									<span class="value">150</span>
								</li>
								<li>
									<span class="name">加入时间</span>
									<span class="value">8月12日</span>
								</li>
								<li>
									<span class="name">上次访问</span>
									<span class="value"><i class="fa fa-circle theme-color"></i>&nbsp;&nbsp;在线</span>
								</li>
							</ul>
						</div>
					</div>

					<div class="profile-left-panel">
						<section class="info-panel">
							<!--<h4 class="info-title">标题</h4>-->
							<div class="info-container">
								<p class="level-name">
									星系
									<a href="#" title="等级规则" class="fa fa-info-circle"></a>
								</p>
								<p class="level-fa">
									<i class="fa fa-certificate yellow"></i>
									<i class="fa fa-certificate yellow"></i>
									<i class="fa fa-certificate yellow"></i>
									<i class="fa fa-certificate yellow"></i>
								</p>
							</div>
						</section>
						<section class="info-panel">
							<h4 class="info-title">50 粉丝</h4>
							<div class="info-container">
								<a href="" class="follow-img" title="拉拉"><img src="${ctx.contextPath}/images/headx-follow.jpg" alt="" width="44px" height="44px"></a>
								<a href="" class="follow-img"><img src="${ctx.contextPath}/images/headx-follow.jpg" alt="" width="44px" height="44px"></a>
								<a href="" class="follow-img"><img src="${ctx.contextPath}/images/headx-follow.jpg" alt="" width="44px" height="44px"></a>
								<a href="" class="follow-img _right"><img src="${ctx.contextPath}/images/headx-follow.jpg" alt="" width="44px" height="44px"></a>

								<a href="" class="follow-img"><img src="${ctx.contextPath}/images/headx-follow.jpg" alt="" width="44px" height="44px"></a>
								<a href="" class="follow-img"><img src="${ctx.contextPath}/images/headx-follow.jpg" alt="" width="44px" height="44px"></a>
								<a href="" class="follow-img"><img src="${ctx.contextPath}/images/headx-follow.jpg" alt="" width="44px" height="44px"></a>
								<a href="" class="follow-img _right"><img src="${ctx.contextPath}/images/headx-follow.jpg" alt="" width="44px" height="44px"></a>

								<a href="" class="follow-img"><img src="${ctx.contextPath}/images/headx-follow.jpg" alt="" width="44px" height="44px"></a>
								<a href="" class="follow-img"><img src="${ctx.contextPath}/images/headx-follow.jpg" alt="" width="44px" height="44px"></a>
								<a href="" class="follow-img"><img src="${ctx.contextPath}/images/headx-follow.jpg" alt="" width="44px" height="44px"></a>
								<a href="" class="follow-img _right"><img src="${ctx.contextPath}/images/headx-follow.jpg" alt="" width="44px" height="44px"></a>
							</div>
							<div class="info-bottom">
								<a href="">
									查看所有粉丝
									<i class="fa fa-caret-right"></i>
								</a>
							</div>
						</section>
						<section class="info-panel">
							<h4 class="info-title">标题</h4>
							<div class="info-container">
								sfsf <br>
								kfjeij
							</div>
						</section>
					</div>

					<!--右边消息列表-->
					<div class="profile-right-panel">
						<p>哈哈哈哈哈哈哈哈打</p>
						<p>哈哈哈哈哈哈哈哈打</p>
						<p>aesop1 started following TriggerAu October 21</p>
						<p>哈哈哈哈哈哈哈哈打</p>
					</div>
				</div>
			</main>
		</div>

	</div>

    <!-- Footer -->
	<#include "/common/footer.ftl">

	<!-- Required Plugins and Scripts -->
	<script src="${ctx.contextPath}/plugin/bootstrap/bootstrap.min.js"></script>
	<script src="${ctx.contextPath}/plugin/flexslider/jquery.flexslider-min.js"></script>
	<script src="${ctx.contextPath}/plugin/slicknav/jquery.slicknav.min.js"></script>
	<script src="${ctx.contextPath}/js/common.js"></script>

</body>

</html>
