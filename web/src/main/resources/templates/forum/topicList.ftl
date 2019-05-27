<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>帖子列表</title>

	<!-- Google Fonts -->
	<link href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i&amp;subset=latin-ext"
	    rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:300,400,700&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese"
	    rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,500,500i,700,700i,900,900i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese"
	    rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Lato:300,300i,400,400i,700,700i,900&amp;subset=latin-ext" rel="stylesheet">

    <!--提示工具-->
	<link href="${ctx.contextPath}/plugin/tooltips/darktooltip.min.css" rel="stylesheet">
    <!--分页工具-->
	<link href="${ctx.contextPath}/plugin/pagination/jquery.pagination.css" rel="stylesheet">
	<link href="${ctx.contextPath}/css/font-awesome.min.css" rel="stylesheet">
	<link href="${ctx.contextPath}/plugin/flexslider/flexslider.css" rel="stylesheet">
	<link href="${ctx.contextPath}/plugin/slicknav/slicknav.min.css" rel="stylesheet">
	<link href="${ctx.contextPath}/css/main.css" rel="stylesheet">
	<link href="${ctx.contextPath}/css/forum.css" rel="stylesheet">

	<script src="${ctx.contextPath}/plugin/jquery-3.1.1.min.js"></script>
	<script src="${ctx.contextPath}/plugin/jquery-migrate.min.js"></script>

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
					<i class="fa fa-home fa-lg"></i>
					<a href="/forum">论坛</a>&gt;
					<a href="">灵感交流</a>
				</div>

				<div class="top-title">
					<button type="button" style="border-radius: 3px;" class="btn btn-warning" onclick="javascript:location.href='/forum/new'">发布新帖子</button>
				</div>


				<!--顶部分页-->
				<div class="page-box subleft">
					<div id="pagination4" class="page fl"></div>
				</div>
				<div class="row module-container">
					<!--<div class="module-title" style="border-left: none;">-->
						<!--&lt;!&ndash;顶部分页&ndash;&gt;-->
						<!--<div class="box">-->
							<!--<div id="pagination4" class="page fl"></div>-->
						<!--</div>-->
					<!--</div>-->
					<div class="row-topic">
						<div class="col-dot">
							<span><i class="fa fa-circle"></i></span>
						</div>
						<div class="col-topic">
							<span class="top"><i class="fa fa-thumb-tack"></i></span>
							<a href="/forum/detail">建议与发展讨论</a><br>
							<span class="gray">
								<a href="" class="gray">冬日里的温情</a>&nbsp;&nbsp;&nbsp;1小时前 &nbsp;
								<!--标签-->
								<a href="#" class="ipsTag" title="按标签搜索">
									<span style="position: absolute;left: -3px;">●</span><span>组件</span>
								</a>
							</span>
						</div>
						<div class="col-info">
							<div class="replies-views1">
								<span data-tooltip="被回复">999&nbsp;<i class="fa fa-paper-plane"></i></span><br>
								<span class="gray" data-tooltip="被查看">2700&nbsp;<i class="fa fa-eye"></i></span>
							</div>
							<div class="replies-views2">
								<a href="#"><img src="../images/headx-default.png" width="40px" height="40px" alt=""></a>
							</div>
							<div class="replies-views3">
								<span>玫瑰花的葬礼</span>
								<span class="gray">2017年08月09日</span>
							</div>
						</div>
					</div>

					<div class="row-topic led">
						<div class="col-dot">
							<span><i class="fa fa-circle"></i></span>
						</div>
						<div class="col-topic">
							<a href="/forum/detail"> 建议与发展讨论</a><br>
							<span class="gray">关注并讨论开发。建议和发展讨论就在这里。</span>
						</div>
						<div class="col-info">
							<div class="replies-views1">
								<span data-tooltip="被回复">999+&nbsp;<i class="fa fa-paper-plane"></i></span><br>
								<span class="gray" data-tooltip="被查看">2700&nbsp;<i class="fa fa-eye"></i></span>
							</div>
							<div class="replies-views2">
								<a href="#"><img src="../images/headx-default.png" width="40px" height="40px" alt=""></a>
							</div>
							<div class="replies-views3">
								<span>玫瑰花的葬礼</span>
								<span class="gray">2017年08月09日</span>
							</div>
						</div>
					</div>
				</div>
				<!--底部分页-->
				<div class="page-box subleft">
					<div id="pagination3" class="page fl"></div>
					<span class="total-page">共101页</span>
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
	<script src="${ctx.contextPath}/plugin/bootstrap/bootstrap.min.js"></script>
	<script src="${ctx.contextPath}/plugin/pagination/jquery.pagination.min.js"></script> <!--分页工具-->
	<script src="${ctx.contextPath}/plugin/flexslider/jquery.flexslider-min.js"></script>
	<script src="${ctx.contextPath}/plugin/slicknav/jquery.slicknav.min.js"></script>
	<script src="${ctx.contextPath}/plugin/tooltips/jquery.darktooltip.min.js"></script><!--提示工具-->

	<script src="${ctx.contextPath}/js/common.js"></script>
	<script src="${ctx.contextPath}/js/forum/topic_list.js"></script>

</body>

</html>
