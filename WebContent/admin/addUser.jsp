<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>layui</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="<%=request.getContextPath() %>/layui/css/layui.css"
	media="all">
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>



	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>添加新用户</legend>
	</fieldset>

	<form class="layui-form" method="post" action="<%=request.getContextPath() %>/AddUser">
		<div class="layui-form-item">
			<label class="layui-form-label">用户名</label>
			<div class="layui-input-block">
				<input id="namea" type="text" name="username" lay-verify="title"
					autocomplete="off" placeholder="请输入用户名" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">真实姓名</label>
			<div class="layui-input-block">
				<input type="text" name="realname" lay-verify="title2"
					autocomplete="off" placeholder="请输入姓名" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码</label>
			<div class="layui-input-inline">
				<input id="pwd" type="password" name="password" lay-verify="pass"
					placeholder="请输入密码" autocomplete="off" class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux">请填写6到12位密码</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">重复密码</label>
			<div class="layui-input-inline">
				<input type="password" name="password2" lay-verify="pass2"
					placeholder="请输入密码" autocomplete="off" class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux">填写重复密码</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">手机号</label>
				<div class="layui-input-inline">
					<input type="tel" name="phone" lay-verify="required|phone"
						autocomplete="off" placeholder="请输入电话" class="layui-input">
				</div>
		</div>
		<div class="layui-form-item">
		<label class="layui-form-label">邮箱</label>
				<div class="layui-input-inline">
					<input type="text" name="email" lay-verify="email"
						autocomplete="off" placeholder="请输入邮箱" class="layui-input">
				</div>
		</div>



		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
	<script src="<%=request.getContextPath() %>/layui/layui.js" charset="utf-8"></script>
	<script src="<%=request.getContextPath() %>/js/jquery.js" charset="utf-8"></script>
	<script src="<%=request.getContextPath() %>/js/jquery.min.js" charset="utf-8"></script> 
	
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
	<script>
layui.use(['form', 'layedit', 'laydate','layer'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
  //日期
  laydate.render({
    elem: '#date'
  });
  laydate.render({
    elem: '#date1'
  });
  
  //创建一个编辑器
  var editIndex = layedit.build('LAY_demo_editor');
 
  //自定义验证规则
  form.verify({
    title: function(value){
      if(value.length < 5){
        return '昵称至少得5个字符啊';
      }
      $.ajax({
     	 
          url: '<%=request.getContextPath()%>/checkUserName',
          type: "GET",
          async: false,
          data: {
              username:value
          },
          dataType: 'HTML',
          
         success: function (data) {
             msg = data;
          } 
      });
     if(msg=='Served at: /Work1'){return "用户名重复，请重新输入！";} 
    },
  	title2: function(value){
  		if(value.length<3){
  			return '姓名格式不正确啊';
  		}
  	}
    ,pass: [/(.+){6,12}$/, '密码必须6到12位']
    ,pass2:function(value){
    	var repassvalue = $('#pwd').val();
    	if(value != repassvalue){
    	return '两次输入的密码不一致!';}
    }
    
    ,content: function(value){
      layedit.sync(editIndex);
    }
  });
  
 
  
  //监听提交
  form.on('submit(demo1)', function(data){
	  layer.msg('success');
     
    
  });
 
  
  
  
});
</script>

</body>
</html>