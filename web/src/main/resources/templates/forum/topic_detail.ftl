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

	<link rel="stylesheet" href="../../static/plugin/pagination/jquery.pagination.css" />
	<link href="../../static/css/font-awesome.min.css" rel="stylesheet">
	<link href="../../static/plugin/flexslider/flexslider.css" rel="stylesheet">
	<link href="../plugin/slicknav/slicknav.min.css" rel="stylesheet">

	<link rel="stylesheet" type="text/css" href="../../static/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="../../static/css/htmleaf-demo.css">
	<link rel="stylesheet" type="text/css" href="../../static/css/icons.css" />
	<link rel="stylesheet" type="text/css" href="../plugin/editor/wangEditor.css" />

	<!--自定义样式-->
	<link href="../../static/css/main.css" rel="stylesheet">
	<link href="../../static/css/forum.css" rel="stylesheet">

</head>

<body>

	<!-- Page Wrapper -->
	<div class="page-wrapper">

		<!-- Header -->
		<header id="header" class="header header-one clearfix">
			<div class="container">
				<div class="row">
					<div class="col-xs-6 col-sm-4 col-lg-3">
						<div class="site-branding">
							<div class="wrap">
								<h1 class="site-title">
									<a href="index.html" rel="home">
										<img src="../images/logo1s.png" alt="Antarctica">
									</a>
								</h1>
							</div>
						</div>
					</div>
					<div class="col-xs-6 col-sm-8 col-lg-9">
						<div class="navigation-top clearfix">
							<nav id="site-navigation" class="main-navigation nv1">
								<ul class="menu-primary clearfix">
									<li>
										<a href="../index.html">首页</a>
									</li>
									<li>
										<a href="../forum.html">论坛</a>
									</li>
									<li>
										<a href="../portfolio.html">MOD搬运</a>
									</li>
									<!-- <li><a href="blog.html">Blog</a></li> -->
									<li>
										<a href="../about-us.html">关于我们</a>
									</li>
									<li>
										<a href="../contact.html">反馈</a>
									</li>
								</ul>
							</nav>


							<nav class="main-navigation nv2">
								<ul class="menu-primary clearfix">
									<!--<li class="login-li">-->
									<!--<button type="button" class="login-btn btn btn-success btn-sm">登陆</button>-->
									<!--</li>-->
									<!--<li>-->
									<!--<a href="#" class="theme-color regist">注册</a>-->
									<!--</li>-->
									<!--<li>-->
									<!--<div class="top-line line-r"></div>-->
									<!--</li>-->
									<li>
										<form action="#" class="header-search-form">
											<input type="text" name="s" id="s" value="" class="search-input" placeholder="Search">
										</form>
									</li>
									<li>
										<a href="">发帖</a>
									</li>
									<li style="overflow: visible">
										<!--消息提醒-->
										<div class="top-message black fa fa-bell-o noselect" unselectable="on">
											<span class="stamp">50</span>
										</div>
										<!--弹出层-->
										<section class="message-panel" style="display: none">
											<div class="triangle1"></div>
											<div class="title">新消息</div>
											<p>
												<i class="fa fa-circle news"></i>
												<span class="message-li1">坎星人 赞了你</span>
												<span class="message-li2">建议发展讨论</span>
											</p>
											<p>
												<i class="fa fa-circle news"></i>
												<span class="message-li1">多巴胺安抚 回复了你：打开mod文件...</span>
												<span class="message-li2">在ksp中如何安装Mod</span>
											</p>
											<a href="" class="bottom">查看更多→</a>
										</section>
									</li>

									<li style="overflow: visible">
										<a href="" class="top-head"><img src="../images/headx-default.png" alt="" width="30" height="30"></a>
										<div class="top-username black noselect" unselectable="on">
											<apan>箭镞大师</apan>
											<i class="fa fa-caret-down"></i>
										</div>
										<!--弹出层-->
										<section class="user-panel" style="display: none">
											<div class="triangle2"></div>
											<p>哈哈打</p>
											<p>纷纷嘎</p>
											<p>牛逼啦</p>
											<p>朝野</p>
											<p class="split-line"></p>
											<p>退出</p>
										</section>
									</li>
								</ul>
							</nav>

						</div>
					</div>
				</div>
			</div>
		</header>
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
	<script src="../../static/plugin/jquery-3.1.1.min.js"></script>
	<script src="../../static/plugin/jquery-migrate.min.js"></script>
	<script src="../plugin/bootstrap/bootstrap.min.js"></script>
	<script src="../plugin/pagination/jquery.pagination.min.js"></script>
	<script src="../../static/plugin/flexslider/jquery.flexslider-min.js"></script>
	<script src="../plugin/slicknav/jquery.slicknav.min.js"></script>
	<script src="../../static/js/common.js"></script>
	<script src="../plugin/like/mo.min.js"></script>
	<script src="../plugin/like/click-like.js"></script>
	<script src="../plugin/editor/wangEditor.js"></script>

	<!--自定义JS-->
	<script src="../../static/js/nav.js"></script>
	<script src="../../static/js/forum/topic_detail.js"></script>
</body>

</html>