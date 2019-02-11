<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
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

    <script src="${ctx.contextPath}/plugin/jquery-3.1.1.min.js"></script>
    <script src="${ctx.contextPath}/plugin/jquery-migrate.min.js"></script>
</head>

<body>
	<!-- Header -->
	<#include "/common/hearder.ftl">
	<!-- Page Wrapper -->
	<div class="page-wrapper">

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
									<div class="digest1"><a href="forum/topic_list.html"> 建议与发展讨论</a></div>
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
									<div class="digest1"><a href="forum/topic_list.html"> 建议与发展讨论</a></div>
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
