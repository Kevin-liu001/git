<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>垃圾分类信息化管理系统</title>
	 	<link href="css/base.css" rel="stylesheet">
	    <link href="css/login/login.css" rel="stylesheet">
	    <script type="text/javascript" src="js/jquery.min.js"></script>
	    <script type="text/javascript">
	    function register()
	    {
	    window.location.href="html/register.html";
	    }
			function login(){
				var user_name=$("#user_name").val();
				var user_pwd=$("#user_pwd").val();
				var yzm=$("#yzm").val();
				if(user_name==null||user_name==""){
					$("#massagers").html("*用户名不能为空")
				}else if(user_pwd==null||user_pwd==""){
					$("#massagers").html("*密码不能为空");
				}else if(yzm==null||yzm==""){
					$("#massagers").html("*验证码不能为空");
				}else{
					$("#form1").submit();
				}
			}
			
			$(function(){
				var user_name=$("#user_name").val();
				var user_pwd=$("#user_pwd").val();
				var yzm=$("#yzm").val();
				
				$("#user_name").blur(function(){
					if(user_name!=null||user_name!=""){
						$("#massagers").html("请输入用户信息");
					}
				});
				$("#user_pwd").blur(function(){
					if(user_pwd!=null||user_pwd!=""){
						$("#massagers").html("请输入用户信息");
					}
				});
				$("#yzm").blur(function(){
					if(yzm!=null||yzm!=""){
						$("#massagers").html("请输入用户信息");
					}
				});
				
				var error=getQueryString("error");
				var yzm=getQueryString("yzm");
				var user_name=getQueryString("user_name");
				var user_pwd=getQueryString("user_pwd");
				if(yzm=="null"){
					yzm="";
				}
				if(user_name=="null"){
					user_name="";
				}
				if(user_pwd=="null"){
					user_pwd="";
				}
				if(error==1){
					$("#massagers").html("*验证码错误");
					$("#user_name").val(user_name);
					$("#user_pwd").val(user_pwd);
					$("#yzm").val(yzm);
				}
				if(error==2){
					$("#massagers").html("*用户名或者密码错误");
					$("#user_name").val(user_name);
					$("#user_pwd").val(user_pwd);
					$("#yzm").val(yzm);
				}
				
			});
			
			function loadImage(){
				document.getElementById("randImage").src="${pageContext.request.contextPath }/images/image.jsp?"+Math.random();
			}
			
			function getQueryString(name){
				 var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
				 var url=decodeURI(decodeURI(window.location.search));	//获取返回路径
				 var r=url.substr(1).match(reg);
				 if(r!=null){
					 return unescape(r[2]);
				 }
				 return null;
			}
		</script>
	</head>
	<body>
		<div class="login-hd">
			<div class="left-bg"></div>
			<div class="right-bg"></div>
			<div class="hd-inner">
				<span class="logo"></span>
				<span class="split"></span>
				<span class="sys-name" style="color: #fff;font-size: 40px;font-family: '隶书'">垃圾分类信息化管理系统</span>
			</div>
		</div>
		<div class="login-bd">
			<div class="bd-inner">
				<div class="inner-wrap">
					<div class="lg-zone">
						<div class="lg-box">
							<div class="lg-label"><h4>用户登录</h4></div>
							<div class="alert alert-error">
				              <i class="iconfont">&#xe62e;</i>
				              <span id="massagers" style="font-size: 16px;font-weight: bold;">请输入用户信息</span>
				            </div>
							<form action="${pageContext.request.contextPath }/userInfo/login.do" method="post" id="form1">
								<div class="lg-username input-item clearfix">
									<i class="iconfont">&#xe60d;</i>
									<input type="text" name="user_name" id="user_name" placeholder="请输入用户名">
								</div>
								<div class="lg-user_pwd input-item clearfix">
									<i class="iconfont">&#xe634;</i>
									<input type="password" name="user_pwd" id="user_pwd" placeholder="请输入密码">
								</div>
								<div class="lg-check clearfix">
									<div class="input-item">
										<i class="iconfont">&#xe633;</i>
										<input type="text" onkeydown="if(event.keyCode==13)form1.submit()" maxlength="4" name="yzm" id="yzm" placeholder="验证码">
									</div>
									<span class="check-code">
										<img title="换一张试试" onclick="javascript:loadImage()" src="${pageContext.request.contextPath }/images/image.jsp" id="randImage" name="randImage" style="width: 114px;height: 41px;"/>
									</span>
								</div>
								<div class="tips clearfix">
									<label><input type="checkbox" checked="checked">记住用户名</label>
									<a href="javascript:register()" class="register">立即注册</a>
									<a href="javascript:;" class="forget-pwd">忘记密码？</a>
								</div>
								<div class="enter" style="text-align: center;">
									<a href="javascript:login()" class="purchaser">登录</a>
								</div>
							</form>
						</div>
					</div>
					<div class="lg-poster"></div>
				</div>
			</div>
		</div>
		<div class="login-ft">
			<div class="ft-inner">
				<div class="about-us">
					<a href="javascript:;">关于我们</a>
					<a href="javascript:;">法律声明</a>
					<a href="javascript:;">服务条款</a>
					<a href="javascript:;">联系方式</a>
				</div>
				<div class="address">地址：陕西省西安市碑林区高速大厦&nbsp;邮编：2019&nbsp;&nbsp;Copyright&nbsp;©&nbsp;2006&nbsp;-&nbsp;2019&nbsp;北邮在线-专注于IT精英&nbsp;版权所有</div>
				<div class="other-info">建议使用IE8及以上版本浏览器&nbsp;&nbsp;09003078号&nbsp;E-mail：1191619897@qq.com</div>
			</div>
		</div>
	</body>
</html>