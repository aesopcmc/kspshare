<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>坎星人登录</title>

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
	<link href="${ctx.contextPath}/css/loginRegist.css" rel="stylesheet">

</head>
<body>

	<!-- Page Wrapper -->
	<div class="page-wrapper">
		<section class="subscribe sections section-padding login-bg">
			<a href="index" class="home-logo"><img src="${ctx.contextPath}/images/logo1.png" alt="Antarctica"></a>

			<div class="container">
				<div class="input-bg">
					<h3 class="title">KSPS论坛登陆</h3>
					<form action="${ctx.contextPath}/login" method="post" class="subscribe-form" novalidate="novalidate">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<div class="row">
							<div class="input-line">
								<div class="form-group">
									<input type="text" name="username" id="username" placeholder="账 号 / 邮 箱" required="required">
									<i class="fa fa-user"></i>
								</div>
							</div>
							<div class="input-line">
								<div class="form-group">
									<input type="password" name="password" id="password" placeholder="密 码" required="required">
									<i class="fa fa-lock"></i>
								</div>
							</div>
							<div style="color:#f75544">
								<#if RequestParameters['error']??>
									账号或密码错误
								</#if>
							</div>
							<div class="input-line">
								<div class="form-group">
									<input type="submit" value="登 录" id="subscribe-submit" class="btn-submit">
								</div>
							</div>
							<div class="input-line">
								<div class="form-group">
                                    <input type="checkbox" name="remember-me" id="remember-me" />自动登录
								</div>
							</div>

						</div>
					</form>
					<p><a href="" class="now-regist">忘记密码</a> | <a href="${ctx.contextPath}/register" class="now-regist">立即注册</a></p>
					<!--<p>Nam scelerisque velit et neque tin hendrerit morbi mollis eu mauris placer.</p>-->
					<!--<p><strong>We dont do spam.</strong></p>-->
				</div>
			</div>
		</section>

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
	<script src="${ctx.contextPath}/plugin/flexslider/jquery.flexslider-min.js"></script>
	<script src="${ctx.contextPath}/plugin/slicknav/jquery.slicknav.min.js"></script>
	<script src="${ctx.contextPath}/js/common.js"></script>
</body>

</html>
