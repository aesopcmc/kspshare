<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>论坛</title>

	<!-- Google Fonts -->
	<link href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i&amp;subset=latin-ext"
	    rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:300,400,700&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese"
	    rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,500,500i,700,700i,900,900i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese"
	    rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Lato:300,300i,400,400i,700,700i,900&amp;subset=latin-ext" rel="stylesheet">

	<!-- Stylesheet -->
	<link href="${ctx.contextPath}/css/font-awesome.min.css" rel="stylesheet">
	<link href="${ctx.contextPath}/plugin/flexslider/flexslider.css" rel="stylesheet">
	<link href="${ctx.contextPath}/plugin/slicknav/slicknav.min.css" rel="stylesheet">
	<link href="${ctx.contextPath}/css/main.css" rel="stylesheet">
	<link href="${ctx.contextPath}/css/forum.css" rel="stylesheet">


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
										<img src="${ctx.contextPath}/images/logo1s.png" alt="Antarctica">
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
										<a href="index.html">首页</a>
									</li>
									<li>
										<a href="forum.html">论坛</a>
									</li>
									<li>
										<a href="portfolio.html">MOD搬运</a>
									</li>
									<!-- <li><a href="blog.html">Blog</a></li> -->
									<li>
										<a href="about-us.html">关于我们</a>
									</li>
									<li>
										<a href="contact.html">反馈</a>
									</li>
								</ul>
							</nav>


							<nav class="main-navigation nv2">
								<ul class="menu-primary clearfix">
									<li class="login-li">
										<button type="button" class="login-btn btn btn-success btn-sm">登陆</button>
									</li>
									<li>
										<a href="module_user/user_regist.html" class="theme-color regist">注册</a>
									</li>
									<li>
										<div class="top-line line-r"></div>
									</li>
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
										<a href="module_user/user_profile.html" class="top-head"><img src="images/headx-default.png" alt="" width="30" height="30"></a>
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
										<p><a href="/logout">退出</a></p>
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

 <!-- style="background-image: url('images/services-sub-header-bg.jpg');" -->
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
					<a href="">论坛</a>
				</div>
					
				 <!-- 版块 -->
				<div class="row">
					<div class="col-md-9">
						<!--<div class="top-title">-->
							<!--<button type="button" style="border-radius: 3px;" class="btn btn-warning">发布新帖子</button>-->
						<!--</div>-->

						 <!--板块begin -->
						<div class="row module-container panel panel-success" style="margin-bottom: 20px;">
							<div class="module-title">板块一</div>

							<div class="module-row">
								<div class="col-md-1 module-item" style="text-align: center;">
									<a href=""><img class="pub-head" src="${ctx.contextPath}/images/headx.jpg"	width="50px" height="50px" alt=""></a>
								</div>	
								<div class="col-md-6 module-item" style="width: auto;">
									<div class="digest1"><a href="module_forum/topic_list.html"> 建议与发展讨论</a></div>
									<div class="digest2">关注并讨论开发。建议和发展讨论就在这里。</div>
								</div>
								<div class="col-md-3 module-item person-info">
									<div style="float:left">
										<a href="#"> <img src="${ctx.contextPath}/images/headx-default.png"	width="40px" height="40px" alt=""></a>
									</div>
									<a href="#" class="replay-info">
										<li style="color: #5CB85C;">丶放肆的流言</li>
										<li class="normal-color">不错的东西 虽然不用 但还是顶下</li>
										<li class="gray">6小时前</li>
									</a>
								</div>
								<div class="col-md-2 module-item topic-count">
									<div class="count1">
										<span>1120</span>
									</div>
									<div class="gray">帖子</div>
								</div>
							</div>

							<div class="module-row led">
								<div class="col-md-1 module-item" style="text-align: center;">
									<a href=""><img class="pub-head" src="${ctx.contextPath}/images/headx.jpg"	width="50px" height="50px" alt=""></a>
								</div>
								<div class="col-md-6 module-item" style="width: auto;">
									<div class="digest1"><a href="module_forum/topic_list.html"> 建议与发展讨论</a></div>
									<div class="digest2">关注并讨论开发。建议和发展讨论就在这里。</div>
								</div>
								<div class="col-md-3 module-item person-info">
									<div style="float:left">
										<a href="#"> <img src="${ctx.contextPath}/images/headx-default.png"	width="40px" height="40px" alt=""></a>
									</div>
									<a href="#" class="replay-info">
										<li style="color: #5CB85C;">丶放肆的流言</li>
										<li class="normal-color">不错的东西 虽然不用 但还是顶下</li>
										<li class="gray">6小时前</li>
									</a>
								</div>
								<div class="col-md-2 module-item topic-count">
									<div class="count1">
										<span>1120</span>
									</div>
									<div class="gray">帖子</div>
								</div>
							</div>


						</div>
							
						 <!--帖子统计 -->
						<div class="row module-container" style="margin-bottom: 20px;">
							<div class="module-title">论坛总计</div>
							<div class="col-md-6 module-item" style="text-align: center;">
								<div class="count1">
									<span>4096</span>
								</div>
								<div class="gray">总帖子数</div>
							</div>	
							<div class="col-md-6 module-item" style="text-align: center;">
								<div class="count1">
									<span>50006</span>
								</div>
								<div class="gray">总回复数</div>
							</div>
						</div>
						
						<!-- 会员统计 -->
						<div class="row module-container" style="margin-bottom: 20px;">
							<div class="module-title">会员总计</div>
							<div class="col-md-4 module-item" style="text-align: center;">
								<div class="count1">
									<span>4096</span>
								</div>
								<div class="gray">会员总数</div>
							</div>	
							<div class="col-md-4 module-item" style="text-align: center;">
								<div class="count1">
									<span>50006</span>
								</div>
								<div class="gray">当前在线</div>
							</div>
							
							 <!--style="    line-height: 60px;" -->
							<div class="col-md-4 module-item" >
								<div class="splice-line"></div>
								<div class="splice-right">
									<a href="#" class="new-head"> <img src="${ctx.contextPath}/images/headx-default.png" width="40px" height="40px" alt=""></a>
									<span>欢迎新成员 <a href="" style="color: #5CB85C;">小绿人橱窗FAA</a> 加入</span><br>
									<span class="gray">6小时前</span>
								</div>
								<!-- 
								<div class="count1">
									<span>50006</span>
								</div>
								<div class="gray">总回复数</div> -->
							</div>
						</div>
						
						
					</div>
					<div class="col-md-3">
						<!-- <h3>最近热帖</h3> -->
						<div class="hot-item-container">
							<div class="module-title">最近热帖</div>
							<div class="hot-item">
								<div class="col-md-8 ">
									<div class="hot-title"><a href="">谁还需要一个水平跑道呢？</a></div>
									<div class="digest2">
										<a href="" class="normal-color">漆黑中的萤火虫</a>
										<span class="gray">5小时前</span>
									</div>
								</div>
								<div class="col-md-4 ">
									<div class="replay-tag" title="回复">
										<i class="fa fa-caret-left fa-2x edge" aria-hidden="true"></i>
										<span>955</span>
									</div>
								</div>
							</div>
							
							<div class="hot-item">
								<div class="col-md-8 ">
									<div class="hot-title"><a href="">谁还需要一个水平跑道呢？</a></div>
									<div class="digest2">
										<a href="" class="normal-color">漆黑中的萤火虫</a>
										<span class="gray">5小时前</span>
									</div>
								</div>
								<div class="col-md-4 ">
									<div class="replay-tag" title="回复">
										<i class="fa fa-caret-left fa-2x edge" aria-hidden="true"></i>
										<span>955</span>
									</div>
								</div>
							</div>
						</div>

						<div class="hot-item-container">
							<div class="module-title">活跃用户</div>
							<ol class="act-user">
								<li>
									&nbsp;&nbsp;<a href="#"><img src="${ctx.contextPath}/images/headx-default.png"	width="40px" height="40px" alt=""></a>
									<a href="#" style="color: #5CB85C;">丶放肆的流言</a>
								</li>
								<li>
									&nbsp;&nbsp;<a href="#"><img src="${ctx.contextPath}/images/headx-default.png"	width="40px" height="40px" alt=""></a>
									<a href="#" style="color: #5CB85C;">丶放肆的流言</a>
								</li>
							</ol>
						</div>
					</div>
				</div>
				<!-- Our Services -->

			</main>
		</div>

		<!-- Call to Action -->

		<!-- Footer -->
		<footer id="footer" class="footer">
			<!--<div class="container">
				<aside class="row footer-widgets">
					<div class="widget-column col-sm-6 col-md-3">
						<section class="widget widget_text">
							<h2 class="widget-title">&nbsp;</h2>
							<div class="textwidget">
								<div class="footer-logo-widget">
									<a href="index.html">
										<img src="images/footer-logo.png" alt="">
									</a>
									<p>Integer fermentum trique velit a lacinia.</p>
								</div>
							</div>
						</section>
					</div>

					<div class="widget-column col-sm-6 col-md-3">
						<section class="widget widget_nav_menu">
							<h2 class="widget-title">Quick Links</h2>
							<ul>
								<li>
									<a href="#">Speciality Services</a>
								</li>
								<li>
									<a href="#">Sredit Cars</a>
								</li>
								<li>
									<a href="#">Support Forums</a>
								</li>
								<li>
									<a href="#">Faqs</a>
								</li>
								<li>
									<a href="#">Terms and Conditions</a>
								</li>
								<li>
									<a href="#">Financial Planner</a>
								</li>
								<li>
									<a href="#">Tax Helper</a>
								</li>
								<li>
									<a href="#">Contact Us</a>
								</li>
							</ul>
						</section>
					</div>

					<div class="clearfix visible-sm"></div>

					<div class="widget-column col-sm-6 col-md-3">
						<section class="widget widget_featured_posts">
							<h2 class="widget-title">Feature Blogs</h2>
							<ul>
								<li>
									<div class="post-thumb">
										<a href="#">
											<img src="images/widget/f-1.jpg" alt="#">
										</a>
									</div>
									<div class="post-content">
										<h3 class="post-title">
											<a href="#">Women Work in Office</a>
										</h3>
										<span class="post-date">18 Dec 2017</span>
									</div>
								</li>
								<li>
									<div class="post-thumb">
										<a href="#">
											<img src="images/widget/f-2.jpg" alt="#">
										</a>
									</div>
									<div class="post-content">
										<h3 class="post-title">
											<a href="#">Women Work in Office</a>
										</h3>
										<span class="post-date">18 Dec 2017</span>
									</div>
								</li>
								<li>
									<div class="post-thumb">
										<a href="#">
											<img src="images/widget/f-3.jpg" alt="#">
										</a>
									</div>
									<div class="post-content">
										<h3 class="post-title">
											<a href="#">Women Work in Office</a>
										</h3>
										<span class="post-date">18 Dec 2017</span>
									</div>
								</li>
							</ul>
						</section>
					</div>

					<div class="widget-column col-sm-6 col-md-3">
						<section class="widget widget_twitter">
							<h2 class="widget-title">Latest Tweets</h2>
							<ul>
								<li>
									<p>
										<a href="#">@Antarctica,</a> Lorem ipsum dolor Sit amet consectetur
										<span class="tweet-time">2 hours ago</span>
									</p>
								</li>
								<li>
									<p>
										<a href="#">@Antarctica,</a> Lorem ipsum dolor Sit amet consectetur
										<span class="tweet-time">2 hours ago</span>
									</p>
								</li>
								<li>
									<p>
										<a href="#">@Antarctica,</a> Lorem ipsum dolor Sit amet consectetur
										<span class="tweet-time">2 hours ago</span>
									</p>
								</li>
							</ul>
						</section>
					</div>
				</aside>
			</div>
-->
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
	<script src="${ctx.contextPath}/plugin/flexslider/jquery.flexslider-min.js"></script>
	<script src="${ctx.contextPath}/plugin/slicknav/jquery.slicknav.min.js"></script>
	<script src="${ctx.contextPath}/js/common.js"></script>
	<script src="${ctx.contextPath}/js/nav.js"></script>
</body>

</html>
