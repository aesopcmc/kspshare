<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>发帖</title>

	<!-- Google Fonts -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i&amp;subset=latin-ext">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto+Slab:300,400,700&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,500,500i,700,700i,900,900i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300,300i,400,400i,700,700i,900&amp;subset=latin-ext">

	<link rel="stylesheet" href="${ctx.contextPath}/plugin/pagination/jquery.pagination.css" />
	<link rel="stylesheet" href="${ctx.contextPath}/plugin/jqueryUi/jquery-ui.min.css" />
	<link rel="stylesheet" href="${ctx.contextPath}/css/font-awesome.min.css">
	<link rel="stylesheet" href="${ctx.contextPath}/plugin/flexslider/flexslider.css">
	<link rel="stylesheet" href="${ctx.contextPath}/plugin/slicknav/slicknav.min.css">
	<link rel="stylesheet" href="${ctx.contextPath}/plugin/editor/wangEditor.css" />
	<link rel="stylesheet" href="${ctx.contextPath}/plugin/tagInput/jquery.tagsinput-revisited.min.css" />
	<link rel="stylesheet" href="${ctx.contextPath}/plugin/switch/titatoggle-dist.css">

	<!--自定义样式-->
	<link rel="stylesheet" href="${ctx.contextPath}/css/main.css" >
	<link rel="stylesheet" href="${ctx.contextPath}/css/forum.css">

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
					<a href="" class="normal-color">论坛</a>
					&nbsp;<i class="normal-color">&gt;</i>&nbsp;
					<a href="" class="normal-color">综合</a>
					&nbsp;<i class="normal-color">&gt;</i>&nbsp;
					<a href="" class="normal-color">论坛公告</a>
				</div>

				<div class="top-title">
					<h3 class="new-subject">发表帖子</h3>
				</div>


				<div class="row module-container topic-container">
					<!--<div class="module-title">创建新主题</div>-->
					<main>
						<div class="input-group">
							<label for="topicTitle" class="in-title">标题</label>&nbsp;&nbsp;&nbsp;<span class="must-input">必填</span>
							<input type="text" id="topicTitle" class="form-control" style="width: 500px;" placeholder="请输入标题">
						</div>

						<div class="input-group">
							<label for="topicTag" class="in-title">标签</label>
							<input type="text" value="鱼,猫咪" id="topicTag" class="form-control">
						</div>

						<div class="input-group">
							<span class="must-input">必填</span>
							<div class="replay-area myEditor"></div>
						</div>
						<div class="input-group">
							<button type="button" style="border-radius: 3px;" class="btn btn-warning topic-opr-item"><i class="fa fa-paper-plane-o"></i> 发表帖子</button>
							<div class="checkbox checkbox-slider--b-flat topic-opr-item">
								<label>
									<input type="checkbox"><span>转播给听众</span>
								</label>
							</div>
						</div>
					</main>
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
	<script src="${ctx.contextPath}/plugin/jqueryUi/jquery-ui.min.js"></script>
	<script src="${ctx.contextPath}/plugin/jquery-migrate.min.js"></script>
	<script src="${ctx.contextPath}/plugin/bootstrap/bootstrap.min.js"></script>
	<script src="${ctx.contextPath}/plugin/pagination/jquery.pagination.min.js"></script>
	<script src="${ctx.contextPath}/plugin/flexslider/jquery.flexslider-min.js"></script>
	<script src="${ctx.contextPath}/plugin/slicknav/jquery.slicknav.min.js"></script>
	<script src="${ctx.contextPath}/plugin/editor/wangEditor.js"></script>
	<script src="${ctx.contextPath}/plugin/tagInput/jquery.tagsinput-revisited.min.js"></script>

	<!--自定义Js-->
	<script src="${ctx.contextPath}/js/common.js"></script>
	<script src="${ctx.contextPath}/js/nav.js"></script>
	<script src="${ctx.contextPath}/js/forum/topic_new.js"></script>

</body>

</html>
