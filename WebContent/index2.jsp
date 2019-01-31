<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>角色用户权限资源管理</title>

<link rel="stylesheet" href="layui/css/layui.css" />
<style type="text/css">
.haha{
	height:100%;
}

</style>
<script type="text/javascript" src="<%=request.getContextPath() %>/layui.all.js"></script>
</head>
<body>
	
	<div class="layui-layout layui-layout-admin">
		 <div class="layui-header" >
    <div class="layui-logo">角色用户权限资源管理</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
         ${user.realname }
        </a>
        <dl class="layui-nav-child">
          <dd><a href="javascript:;" class="check" href-url="">修改资料</a></dd>
          <dd><a href="Javascript:;" class="changePassword">密码修改</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="<%=request.getContextPath()%>/Exit">退了</a></li>
    </ul>
  </div>
		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->

				<ul class="layui-nav layui-nav-tree site-demo-nav" lay-filter="demo">
					<li class="layui-nav-item layui-nav-itemed"><a
						href="javascript:;">用户管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="admin/listuser2.jsp" target="option">用户编辑</a>
							</dd>
							<dd>
								<a href="admin/addUser.jsp" target="option">用户添加</a>
							</dd>
							
						</dl>
					</li>
					<li class="layui-nav-item layui-nav-itemed"><a
						href="javascript:;">用户管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="admin/listrole.jsp" target="option">角色管理</a>
							</dd>
							<dd>
								<a href="admin/listpermission.jsp" target="option">权限管理</a>
							</dd>
							<dd>
								<a href="admin/listresources.jsp" target="option">资源管理</a>
							</dd>
							
						</dl>
					</li>
					<li class="layui-nav-item"><a href="javascript:;">资源查看</a>
						<dl class="layui-nav-child">
							 <c:forEach items="${res }" var="li" > 
							      <dd>
									<a href="${li.description }" target="option">${li.name }</a>
								  </dd>
							</c:forEach>
						</dl>
					</li>
					
				</ul>
			</div>
		</div>
		<div class="layui-body" id="haha">
			<iframe id="option" name="option" src="welcome.jsp"
				style="overflow: visible;" scrolling="no" frameborder="no"
				width="100%" height="100%"></iframe>
		</div>
		<!-- 弹出修改个人信息界面 -->
		<div style="display: none;" id="changeArea" class="change-pas-box">
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
				<legend>修改个人信息</legend>
			</fieldset>
			<form class="layui-form" method="post"
				action="">
				<div class="layui-form-item">
					<label class="layui-form-label">用户名</label>
					<div class="layui-input-inline">
						<input id="namea" type="text" name="username" lay-verify="title" disabled="disabled"
							autocomplete="off" value='${user.name}' class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">真实姓名</label>
					<div class="layui-input-inline">
						<input id="realname" type="text" name="realname" lay-verify="title2"
							autocomplete="off" value="${user.realname }" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">手机号</label>
					<div class="layui-input-inline">
						<input id="tel" type="tel" name="phone" lay-verify="required|phone"
							autocomplete="off" value="${user.tel }" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">邮箱</label>
					<div class="layui-input-inline">
						<input id="emal" type="text" name="email" lay-verify="email"
							autocomplete="off" value="${user.emal }" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="demo1">修改</button>
				<button type="reset" class="layui-btn layui-btn-primary" id="cel">取消</button>
			</div>
		</div>
			</form>
		</div>
	<!-- 修改密码界面 -->
		<div style="display: none;" id="changePass" class="change-pas-box">
			<fieldset class="layui-elem-field layui-field-title"
				style="margin-top: 20px;">
				<legend>修改密码</legend>
			</fieldset>
			<form class="layui-form" method="post" action="">
			
				<div class="layui-form-item">
					<label class="layui-form-label"> 旧密码</label>
					<div class="layui-input-inline">
						<input id="opwd" type="password" name="oldpassword" lay-verify="pass3" 
							placeholder="请输入旧密码" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label"> 密码</label>
					<div class="layui-input-inline">
						<input id="pwd" type="password" name="password" lay-verify="pass"
							placeholder="请输入新密码" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">重复密码</label>
					<div class="layui-input-inline">
						<input type="password" name="password2" lay-verify="pass2"
							placeholder="请再次输入密码" autocomplete="off" class="layui-input">
					</div>
				</div>


				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="demo2">修改</button>
						<button type="reset" class="layui-btn layui-btn-primary" id="cel2">取消</button>
					</div>
				</div>
			</form>
		</div>


	</div>


	<script type="text/javascript" src="<%=request.getContextPath()%>/layui/layui.js"></script>
	<script src="<%=request.getContextPath() %>/js/jquery.js" charset="utf-8"></script>
	<script src="<%=request.getContextPath() %>/js/jquery.min.js" charset="utf-8"></script> 
	<script>
		layui.use(['element','util','layer','form'], function() {
			var element = layui.element
			,$ = layui.jquery
			,util=layui.util
			,layer=layui.layer
			,form=layui.form
			element.on('nav(demo)', function(elem) {
				//layer.msg(elem.text());
				//alert(elem);
			});
			//取消按鈕
			$('#cel').on('click',function(){
				layer.closeAll();
			})
			$('#cel2').on('click',function(){
				var pa=$('#opwd').val();
				layer.msg(pa);
				//layer.closeAll();
			})
			//修改信息按鈕
			$('.check').on('click', function () {
				layer.open({
                    type: 1,
                    btnAlign: 'c',
                    area: ['350px', '370px'],
                    title: false,
                    content: $("#changeArea"), 
                });
		    });
			//修改密码按鈕
			$('.changePassword').on('click', function () {
				
				layer.open({
                    type: 1,
                    
                    area: ['350px', '370px'],
                    title: false,
                    content: $("#changePass"), 
                });
		    });
			//自定意表单验证
			form.verify({
			    title: function(value){
			      if(value.length < 5){
			        return '昵称至少得5个字符啊';
			      }
			    },
			  	title2: function(value){
			  		if(value.length<3){
			  			return '姓名格式不正确啊';
			  		}
			  	}
			    ,pass3:function(value){
			    	
			    	var msg = '';
			    	//layer.msg(old);
			    	$.ajax({
				          url: '<%=request.getContextPath()%>/CheckOldPass',
				          type: "get",
				          async: false,
				          data: {
				             username:$('#namea').val(),
				             oldpass:value
				          },
				          dataType: 'HTML',
				          
				         success: function (data) {
				            msg=data;
				          } 
				      });
			    	if(msg=='0') return '旧密码输入错误';
			    }
			    ,pass: [/(.+){6,12}$/, '密码必须6到12位']
			    ,pass2:function(value){
			    	var repassvalue = $('#pwd').val();
			    	if(value != repassvalue){
			    	return '两次输入的密码不一致!';}
			    }
			  });
			//修改信息表单提交事件
			form.on('submit(demo1)', function(data){
				$.ajax({
			     	 
			          url: '<%=request.getContextPath()%>/ChangeUser',
			          type: "post",
			          async: false,
			          data: {
			             username:$('#namea').val(),
			             realname:$('#realname').val(),
			           	 tel:$('#tel').val(),
			           	 emal: $('#emal').val()
			          },
			          dataType: 'HTML',
			          
			         success: function (data) {
			            
			          } 
			      });
				  layer.msg('修改成功，2秒后关闭');
				  setTimeout("layer.closeAll()",2000);
				return false;
				  
			  }); 
			form.on('submit(demo2)', function(data){
				$.ajax({
			          url: '<%=request.getContextPath()%>/ChangePass',
			          type: "post",
			          async: false,
			          data: {
			             username:$('#namea').val(),
			             pass:$('#pwd').val()
			          },
			          dataType: 'HTML',
			         success: function (data) {
			          } 
			      });
				  layer.msg('修改成功，2秒后关闭');
				  setTimeout("layer.closeAll()",2000);
				return false;
				  
			  });  
		});
		
	</script>
	<script>
//JavaScript代码区域
	</script>
</body>
</html>