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
	<link rel="stylesheet" href="../plugin/tooltips/darktooltip.min.css"><!--提示工具-->
	<link rel="stylesheet" href="../../static/plugin/pagination/jquery.pagination.css"><!--分页工具-->
	<link href="../../static/css/font-awesome.min.css" rel="stylesheet">
	<link href="../../static/plugin/flexslider/flexslider.css" rel="stylesheet">
	<link href="../plugin/slicknav/slicknav.min.css" rel="stylesheet">
	<link href="../../static/css/main.css" rel="stylesheet">
	<link href="../../static/css/forum.css" rel="stylesheet">

	<script src="../../static/plugin/jquery-3.1.1.min.js"></script>
	<script src="../../static/plugin/jquery-migrate.min.js"></script>

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
					<i class="fa fa-home fa-lg"></i>
					<a href="">论坛</a>&gt;
					<a href="">灵感交流</a>
				</div>

				<div class="top-title">
					<button type="button" style="border-radius: 3px;" class="btn btn-warning" onclick="javascript:location.href='/html/module_forum/topic_new.html'">发布新帖子</button>
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
							<a href="topic_detail.html">建议与发展讨论</a><br>
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
							<a href="topic_detail.html"> 建议与发展讨论</a><br>
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
	<script src="../plugin/bootstrap/bootstrap.min.js"></script>
	<script src="../plugin/pagination/jquery.pagination.min.js"></script> <!--分页工具-->
	<script src="../../static/plugin/flexslider/jquery.flexslider-min.js"></script>
	<script src="../plugin/slicknav/jquery.slicknav.min.js"></script>
	<script src="../plugin/tooltips/jquery.darktooltip.min.js"></script><!--提示工具-->

	<script src="../../static/js/common.js"></script>
	<script src="../../static/js/forum/topic_list.js"></script>

</body>

</html>