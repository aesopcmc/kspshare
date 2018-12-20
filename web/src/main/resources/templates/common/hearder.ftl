
<script src="${ctx.contextPath}/js/nav.js"></script>

<script>
    $(function () {
        var token = '${_csrf.token}';
        //异步方式退出登录
        $("#logout").click(function(){
            $.ajax({
                type: "post",
                url: "/logout",
                data: {_csrf:token},
                // dataType: "json",
                success: function(data){
                    location.reload()
                }
            });
        })
    })
</script>
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
                                <a href="/index">首页</a>
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
                                <form action="#" >
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
                                <a href="" class="top-head"><img src="${ctx.contextPath}/images/headx-default.png" alt="" width="30" height="30"></a>
                                <div class="top-username black noselect" unselectable="on">
                                    <apan>箭镞大师</apan>
                                    <i class="fa fa-caret-down"></i>
                                </div>
                                <!--弹出层-->
                                <section class="user-panel" style="display: none">
                                    <div class="triangle2"></div>
                                    <p><a href="">哈哈打</a></p>
                                    <p><a href="">纷纷嘎</a></p>
                                    <p><a href="">牛逼啦</a></p>
                                    <p><a href="">朝野</a></p>
                                    <p class="split-line"></p>
                                    <p><a id="logout" href="javascript:void(0)">退出</a></p>
                                    <#--
                                   提交表单方式退出登录
                                   <form action="/logout" method="post">
                                       <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                       <p><button type="submit">退出</button></p>
                                   </form>-->
                                </section>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</header>
