<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>用户表格</title>
  <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/layui/css/layui.css"  media="all">
</head>
<body>
<h1 align="center" style="margin-top:5px" >用户管理</h1>
<table id="demo" lay-filter="demo" class="layui-hide" lay-data="{height: 'full-50', cellMinWidth: 80}">
	  <thead>
	    <tr>
	      <th lay-data="{field:'id', width:80}">ID</th>
	      <th lay-data="{field:'name',sort:true}">昵称</th>
	      <th lay-data="{field:'realname',sort:true}">姓名</th>
	      <th lay-data="{field:'tel', sort:true}">电话</th>
	      <th lay-data="{field:'emal', sort:true}">邮箱</th>
	      <th lay-data="{fixed:'right',toolbar: '#barDemo', width:150}">操作</th>
	    </tr> 
	  </thead>
	  
</table>
//赋予角色
<div style="display: none;" id="editrole" class="change-pas-box">
	<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 20px;">
			<legend>赋予角色</legend>
		</fieldset>
	<table id="UR" lay-filter="UR" class="layui-hide" lay-data="{height: 400, cellMinWidth: 80}">
	  <thead>
	    <tr>
	      <th lay-data="{field:'id',sort:true,width:150}">所属角色ID</th>
	      <th lay-data="{field:'name',sort:true,width:180}">所属角色名</th>
	      <th lay-data="{fixed:'right',toolbar: '#barUR', width:50}">操作</th>
	    </tr> 
	  </thead>
	  
	</table>
	<form class="layui-form" method="post" action="">
			<div class="layui-form-item">
				<label class="layui-form-label">添加角色</label>
				<div class="layui-input-inline">
					<input id="rolename" type="text" name="rolename" lay-verify="title" autocomplete="off" placeholder="请输入要添加的角色名"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button type="reset" class="layui-btn layui-btn-primary"  id="update">添加</button>
					<button type="reset" class="layui-btn layui-btn-primary" id="celupdate">取消</button>
				</div>
			</div>
		</form>
</div>
<script type="text/html" id="barUR">
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delUR">删除</a>
</script>


	<script src="<%=request.getContextPath() %>/layui/layui.js" charset="utf-8"></script>
	<script src="<%=request.getContextPath() %>/js/jquery.js" charset="utf-8"></script>
	<script src="<%=request.getContextPath() %>/js/jquery.min.js" charset="utf-8"></script> 
 	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-xs" lay-event="edit">角色编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
	
<script>
layui.use(['table','form','layer'],function(){
    var table = layui.table
    ,layer=layui.layer
    
    ,$ = layui.jquery//加载表格模块
    table.init('demo', {
         hight:500  
        ,url:'<%=request.getContextPath() %>/ListAllUser' //设置高度
        ,page:true //开启分页
        ,limits: [30,60,90]
        ,limit: 30 //每页默认显示的数量
    });
  //监听工具条
  var rrr;
    table.on('tool(demo)', function (obj) {
            var data = obj.data;
            var event = obj.event;
            
            if (event === 'del') {
                //删除数据在这里可以使用Ajax异步  就和平常使用一样简单
                var msg='';
                $.ajax({
                    url: '<%=request.getContextPath()%>/DeletUser',
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
            	   layer.confirm('真的删除'+data.realname+'么?', function(index){
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
            else{
            	rrr=data.id;
            	
            	layer.msg(rrr);
            	table.init('UR', {
                    hight:500
                   ,url:'<%=request.getContextPath()%>/ListUR?userID='+rrr //设置高度
                   ,page:true //开启分页
                   ,limits: [5,10,15]
                   ,limit: 5 //每页默认显示的数量
               });
            	layer.open({
                    type: 1,
                    btnAlign: 'c',
                    area: ['390px', '600px'],
                    title: false,
                    content: $("#editrole"), 
                });
            }
    });
    
    
    table.on('tool(UR)', function (obj) {
        var data = obj.data;
        var event = obj.event;
        if (event === 'delUR') {
        	var msg='';
        	$.ajax({
                url: '<%=request.getContextPath()%>/DeleteUR',
                type: "GET",
                async: false,
                data: {
                    userId:rrr,
                    roleId:data.id
                },
                dataType: 'HTML',
               success: function (data) {
                   msg = data;
                } 
            });
        	if(msg=='1'){
         	   layer.confirm('真的删除此角色么?', function(index){
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
    $('#update').on('click',function(){
    	var msg;
  	  $.ajax({
            url: '<%=request.getContextPath()%>/AddUR',
            type: "GET",
            async: false,
            data: {
            	userId:rrr,
                rolename:$('#rolename').val()
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
    $('#celupdate').on('click',function(){
    	layer.closeAll();
	});

});


</script>
</body>
</html>