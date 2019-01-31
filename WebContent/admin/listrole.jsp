<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>角色表格</title>
  <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/layui/css/layui.css"  media="all">
</head>
<body>

     <button class="layui-btn addrole" style="margin-top:5px;float:right">
	  <i class="layui-icon">&#xe608;</i> 添加
	</button>
	<h1 align="center" style="margin-top:5px" >角色管理</h1>
	<div style="clear:both"></div>

	<table id="demo2" lay-filter="demo2" class="layui-hide" lay-data="{height: 'full-50', cellMinWidth: 80}">
	  <thead>
	    <tr>
	      <th lay-data="{field:'id', width:80}">ID</th>
	      <th lay-data="{field:'name',sort:true}">角色名</th>
	      <th lay-data="{fixed:'right',toolbar: '#barDemo2', width:200}">操作</th>
	    </tr> 
	  </thead>
	</table>
	<!-- //赋予角色 -->
	<div style="display: none;" id="editpermission" class="change-pas-box">
		<fieldset class="layui-elem-field layui-field-title"
				style="margin-top: 20px;">
				<legend>赋予权限</legend>
			</fieldset>
		<table id="RP" lay-filter="RP" class="layui-hide" lay-data="{height: 400, cellMinWidth: 80}">
		  <thead>
		    <tr>
		      <th lay-data="{field:'id',width:80}">权限ID</th>
		      <th lay-data="{field:'name'}">所属权限名</th>
		      <th lay-data="{field:'description'}">权限描述</th>
		      <th lay-data="{fixed:'right',toolbar: '#barRP', width:50}">操作</th>
		    </tr> 
		  </thead>
		  
		</table>
		<form class="layui-form" method="post" action="">
				<div class="layui-form-item">
					<label class="layui-form-label">添加权限</label>
					<div class="layui-input-inline">
						<input id="pername" type="text" name="pername" lay-verify="title" autocomplete="off" placeholder="请输入要添加的权限名"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button type="reset" class="layui-btn layui-btn-primary"  id="updateRP">添加</button>
						<button type="reset" class="layui-btn layui-btn-primary" id="celupdatePR">取消</button>
					</div>
				</div>
			</form>
	</div>
	<script type="text/html" id="barRP">
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delRP">删除</a>
	</script>
	
	
	
	
	<!-- 弹出添加角色界面 -->
	<div style="display: none;" id="addrole" class="change-pas-box">
		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 20px;">
			<legend>添加角色</legend>
		</fieldset>
		<form class="layui-form" method="post" action="">
			<div class="layui-form-item">
				<label class="layui-form-label">角色名</label>
				<div class="layui-input-inline">
					<input id="rolename" type="text" name="rolename" lay-verify="title" autocomplete="off" placeholder="请输入用户名"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button type="reset" class="layui-btn layui-btn-primary"  id="add">添加</button>
					<button type="reset" class="layui-btn layui-btn-primary" id="celadd">取消</button>
				</div>
			</div>
		</form>
	</div>
	<!-- 弹出修改角色界面 -->
	<div style="display: none;" id="updaterole" class="change-pas-box">
		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 20px;">
			<legend>修改角色</legend>
		</fieldset>
		<form class="layui-form" method="post" action="">
			<div class="layui-form-item">
				<label class="layui-form-label">角色名</label>
				<div class="layui-input-inline">
					<input id="rolename2" type="text" name="rolename" lay-verify="title" autocomplete="off" placeholder="请输入角色名"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button type="reset" class="layui-btn layui-btn-primary"  id="update">修改</button>
					<button type="reset" class="layui-btn layui-btn-primary" id="celupdate">取消</button>
				</div>
			</div>
		</form>
	</div>




	<script src="<%=request.getContextPath()%>/layui/layui.js" charset="utf-8"></script>
	<script src="<%=request.getContextPath() %>/js/jquery.js" charset="utf-8"></script>
	<script src="<%=request.getContextPath() %>/js/jquery.min.js" charset="utf-8"></script> 
 	<script type="text/html" id="barDemo2">
  		<a class="layui-btn layui-btn-xs" lay-event="edit">权限编辑</a>
		<a class="layui-btn layui-btn-xs" lay-event="edit2">编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>

<script>
layui.use(['table','form','layer'],function(){
    var table = layui.table
    ,layer=layui.layer
    
    ,$ = layui.jquery//加载表格模块
    table.init('demo2', {
         hight:500  
        ,url:'<%=request.getContextPath() %>/ListAllRole' //设置高度
        ,page:true //开启分页
        ,limits: [30,60,90]
        ,limit: 30 //每页默认显示的数量
    });
  //监听工具条
  var rrr;
  var id;
    table.on('tool(demo2)', function (obj) {
            var data = obj.data;
            var event = obj.event;
            
            if (event === 'del') {
                //删除数据在这里可以使用Ajax异步  就和平常使用一样简单
                var msg='';
                $.ajax({
                    url: '<%=request.getContextPath()%>/DeletRole',
                    type: "GET",
                    async: false,
                    data: {
                        userId:data.id
                    },
                    dataType: 'HTML',
                    
                   success: function (data) {
                       msg = data;
                    } 
                });
               if(msg=='1'){
            	   layer.confirm('真的删除'+data.name+'么?', function(index){
            		   layer.msg('删除成功', { icon: 1, time: 1500 }, function () {
                           obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                           $(".layui-laypage-btn").click();
                       });
            	        layer.close(index);
            	      });
            	   } 
               else
            	   layer.msg('删除失败', { icon: 2, time: 1500 });
            }else if(event=='edit2'){
            	id=data.id;
            	layer.open({
                    type: 1,
                    btnAlign: 'c',
                    area: ['350px', '180px'],
                    title: false,
                    content: $("#updaterole"), 
                });
            	
            	$('#rolename2').val(data.name);
            }else{
				rrr=data.id;
            	layer.msg(rrr);
            	table.init('RP', {
                    hight:500
                   ,url:'<%=request.getContextPath()%>/ListRP?roleID='+rrr //设置高度
                   ,page:true //开启分页
                   ,limits: [5,10,15]
                   ,limit: 5 //每页默认显示的数量
               });
            	layer.open({
                    type: 1,
                    btnAlign: 'c',
                    area: ['390px', '600px'],
                    title: false,
                    content: $("#editpermission"), 
                });
            	
            	
            	
            	
            }
    });
    table.on('tool(RP)', function (obj) {
        var data = obj.data;
        var event = obj.event;
        if (event === 'delRP') {
        	var msg='';
        	$.ajax({
                url: '<%=request.getContextPath()%>/DeleteRP',
                type: "GET",
                async: false,
                data: {
                    roleId:rrr,
                    perId:data.id
                },
                dataType: 'HTML',
               success: function (data) {
                   msg = data;
                } 
            });
        	if(msg=='1'){
         	   layer.confirm('真的删除此权限么?', function(index){
         		   layer.msg('删除成功', { icon: 1, time: 1500 }, function () {
                        obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                        $(".layui-laypage-btn").click();
                    });
         	        layer.close(index);
         	      });
         	   } 
            else
         	   layer.msg('删除失败', { icon: 2, time: 1500 });
        }
    });
    $('#updateRP').on('click',function(){
    	var msg;
  	  $.ajax({
            url: '<%=request.getContextPath()%>/AddRP',
            type: "GET",
            async: false,
            data: {
            	roleId:rrr,
                pername:$('#pername').val()
            },
            dataType: 'HTML',
           success: function (data) {
        	   msg=data;
            } 
        });
  	  if(msg=='1'){
  		layer.msg('添加成功');
  		$(".layui-laypage-btn").click();
  	  }else{
  		layer.msg('添加失败,没有此角色');
  	  }
    });
    $('#celupdateRP').on('click',function(){
    	layer.closeAll();
	});
    
    
    
    
    
    
    
  //修改角色按钮事件
  $('#update').on('click',function(){
	  $.ajax({
          url: '<%=request.getContextPath()%>/UpdateRole',
          type: "GET",
          async: false,
          data: {
              roleID:id,
              rolename:$('#rolename2').val()
          },
          dataType: 'HTML',
         success: function (data) {
          } 
      });
	  layer.msg('修改成功，2秒后关闭');
		setTimeout("layer.closeAll()",2000);
	   $(".layui-laypage-btn")[0].click()
  });
//点击修改取消按钮事件
  $('#celupdate').on('click',function(){
				layer.closeAll();
	});
  //添加角色按钮事件
    $('.addrole').on('click', function () {
		layer.open({
            type: 1,
            btnAlign: 'c',
            area: ['350px', '180px'],
            title: false,
            content: $("#addrole"), 
        });
    });
  //提交添加角色按钮事件
   $('#add').on('click',function(){
	   $.ajax({
           url: '<%=request.getContextPath()%>/AddRole',
           type: "GET",
           async: false,
           data: {
               rolename:$('#rolename').val()
           },
           dataType: 'HTML',
           
          success: function (data) {
           } 
       });
	   layer.msg('添加成功，2秒后关闭');
		setTimeout("layer.closeAll()",2000);
	   $(".layui-laypage-btn")[0].click();
	});
  //点击添加取消按钮事件
  $('#celadd').on('click',function(){
				layer.closeAll();
	});

});


</script>
</body>
</html>