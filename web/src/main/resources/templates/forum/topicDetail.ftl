<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>帖子列详情</title>

	<!-- Google Fonts -->
	<link href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i&amp;subset=latin-ext"
	    rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:300,400,700&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese"
	    rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,500,500i,700,700i,900,900i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese"
	    rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Lato:300,300i,400,400i,700,700i,900&amp;subset=latin-ext" rel="stylesheet">

	<link rel="stylesheet" href="${ctx.contextPath}/plugin/pagination/jquery.pagination.css" />
	<link rel="stylesheet" href="${ctx.contextPath}/css/font-awesome.min.css" />
	<link rel="stylesheet" href="${ctx.contextPath}/plugin/flexslider/flexslider.css" />
	<link rel="stylesheet" href="${ctx.contextPath}/plugin/slicknav/slicknav.min.css" />

	<link rel="stylesheet" href="${ctx.contextPath}/css/normalize.css" />
	<link rel="stylesheet" href="${ctx.contextPath}/css/htmleaf-demo.css">
	<link rel="stylesheet" href="${ctx.contextPath}/css/icons.css" />
	<link rel="stylesheet" href="${ctx.contextPath}/plugin/editor/wangEditor.css" />

	<!--自定义样式-->
	<link rel="stylesheet" href="${ctx.contextPath}/css/main.css" />
	<link rel="stylesheet" href="${ctx.contextPath}/css/forum.css" />

</head>

<body>

	<!-- Page Wrapper -->
	<div class="page-wrapper">

		<!-- Header -->
		<#include "/common/hearder.ftl">
		<!-- Header end -->

		<div class="sub-header forum-head-bg">
			<div class="bg-overlay"></div>
			<div class="container">
				<h2 class="title">大自然的秩序，证明了宇宙确有它的建筑家。</h2>
				<p class="description">——〔德〕康德：《康德文集》</p>
			</div>
		</div>

		<div class="services-page">
			<!-- Main Content -->
			<main id="main" class="main container">
				<!--导航 -->
				<div class="row forum-nav">
					<i class="fa fa-home fa-lg normal-color"></i>
					<a href="/forum" class="normal-color">论坛</a>
					&nbsp;<i class="normal-color">&gt;</i>&nbsp;
					<a href="" class="normal-color">灵感交流</a>
				</div>


				<!--作者、标题信息-->
				<div class="topic-head-info">
					<div class="hi1">
						<a href=""><img src="../images/headx-default.png" width="54" height="54" alt=""></a>
					</div>
					<div class="hi2">
						<span class="hi2-title">需要一些基本部件的帮助</span>
						<a href="" class="theme-color">冬日里的温情</a>
						发布于 <span>2017-08-09 22:10</span>
						<span>MOD模组</span>
					</div>
				</div>

				<div class="top-title">
					<button type="button" style="border-radius: 3px;" class="btn btn-warning" onclick="javascript:document.getElementById('anchor1').scrollIntoView()">回复帖子</button>
					<!--<a href="" >回复帖子</a>-->
					<!--<a href="" class="top-tonew">发布新帖子</a>-->
				</div>

				<!--顶部分页-->
				<div class="page-box subleft">
					<div id="pagination4" class="page fl"></div>
				</div>
				<div class="row module-container detail-container">
					<div class="replay-left">
						<ul>
							<li class="title">陨落星辰</li>
							<li>等级：星系</li>
							<li>
								<i class="fa fa-certificate yellow"></i>
								<i class="fa fa-certificate yellow"></i>
								<i class="fa fa-certificate yellow"></i>
								<i class="fa fa-certificate yellow"></i>
							</li>
							<li>
								<a href="#"><img src="../images/headx-default.png" width="100px" height="100px" alt=""></a>
							</li>
							<li style="margin-top: 8px">
								<i class="fa fa-pencil-square-o"></i> <span>50</span>
							</li>
							<li>
								<i class="fa fa-database"></i> <span>9995</span>
							</li>
							<!--<li class="count-col">-->
								<!--<div class="cols line-r">-->
									<!--<span>215</span><br>-->
									<!--发帖数-->
								<!--</div>-->
								<!--<div class="cols line-r">-->
									<!--<span>65</span><br>-->
									<!--回复数-->
								<!--</div>-->
								<!--<div class="cols">-->
									<!--<span>65</span><br>-->
									<!--站排名-->
								<!--</div>-->
								<!--<div></div>-->
							<!--</li>-->
							<li></li>
						</ul>
					</div>
					<div class="replay-right">
						<div class="content-top gray">
							发布于 <span>2017-08-09 22:10</span>
							<span class="black bold">#1</span>
						</div>
						<div class="content-middle">
							那一年我也变成了光啊！

						</div>
						<div class="content-bottom">
							<div class="cb1">
								<!--回复多个-->
								<a href="" class="fa fa-plus multi normal-color"></a>&nbsp;&nbsp;
								<a href="" class="theme-color">回复</a>
							</div>
							<div class="cb2">
								<!--<div class="good-area">-->
									<!--<i class="fa fa-thumbs-up good"></i>-->
									<!--<span>40</span class=good-area">-->
								<!--</div>-->
								<div class="grid__item">
									<button class="icobutton icobutton--thumbs-up">
										<span class="fa fa-thumbs-up zan"></span>
									</button>
									<span class="like-count">150</span>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!--底部分页-->
				<div class="page-box subleft">
					<div id="pagination3" class="page fl"></div>
					<span class="total-page">共101页</span>
				</div>

				<!--回复-->
				<div class="reply-panel" id="anchor1">
					<div class="replay-author">
						回复主题：
					</div>
					<div class="replay-area myEditor"></div>
					<div class="replay-oper">
						<button type="button" style="border-radius: 3px;" class="btn btn-warning"><i class="fa fa-paper-plane-o"></i> 发表回复</button>
					</div>
				</div>
			</main>



		</div>

		<!-- Footer -->
		<footer id="footer" class="footer">
			<div class="sub-footer text-center">
				<div class="container">
					<p>Copyright &copy; 2017.aesop All rights reserved.</p>
				</div>
			</div>
		</footer>
	</div>

	<!-- Required Plugins and Scripts -->
	<script src="${ctx.contextPath}/plugin/jquery-3.1.1.min.js"></script>
	<script src="${ctx.contextPath}/plugin/jquery-migrate.min.js"></script>
	<script src="${ctx.contextPath}/plugin/bootstrap/bootstrap.min.js"></script>
	<script src="${ctx.contextPath}/plugin/pagination/jquery.pagination.min.js"></script>
	<script src="${ctx.contextPath}/plugin/flexslider/jquery.flexslider-min.js"></script>
	<script src="${ctx.contextPath}/plugin/slicknav/jquery.slicknav.min.js"></script>
	<script src="${ctx.contextPath}/js/common.js"></script>
	<script src="${ctx.contextPath}/plugin/like/mo.min.js"></script>
	<script src="${ctx.contextPath}/plugin/like/click-like.js"></script>
	<script src="${ctx.contextPath}/plugin/editor/wangEditor.js"></script>

	<!--自定义JS-->
	<script src="${ctx.contextPath}/js/nav.js"></script>
	<script src="${ctx.contextPath}/js/forum/topic_detail.js"></script>
</body>

</html>
