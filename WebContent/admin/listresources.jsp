<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>资源表格</title>
  <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/layui/css/layui.css"  media="all">
</head>
<body>

     <button class="layui-btn addresources" style="margin-top:5px;float:right">
	  <i class="layui-icon">&#xe608;</i> 添加
	</button>
	<h1 align="center" style="margin-top:5px" >资源管理</h1>
	<div style="clear:both"></div>

	<table id="demo4" lay-filter="demo4" class="layui-hide" lay-data="{height: 'full-50', cellMinWidth: 80}">
	  <thead>
	    <tr>
	      <th lay-data="{field:'id', width:80}">ID</th>
	      <th lay-data="{field:'name',sort:true}">资源名</th>
	      <th lay-data="{field:'desceription',sort:true}">资源描述</th>
	      <th lay-data="{fixed:'right',toolbar: '#barDemo4', width:150}">操作</th>
	    </tr> 
	  </thead>
	</table>
	
	<!-- 弹出添加权限界面 -->
	<div style="display: none;" id="addresources" class="change-pas-box">
		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 20px;">
			<legend>添加资源</legend>
		</fieldset>
		<form class="layui-form" method="post" action="">
			<div class="layui-form-item">
				<label class="layui-form-label">资源名</label>
				<div class="layui-input-inline">
					<input id="resname" type="text" name="resname" lay-verify="title" autocomplete="off" placeholder="请输入资源名"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">资源描述</label>
				<div class="layui-input-inline">
					<input id="description" type="text" name="description" lay-verify="title" autocomplete="off" placeholder="请输资源描述"
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
	<div style="display: none;" id="updatresources" class="change-pas-box">
		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 20px;">
			<legend>资源权限</legend>
		</fieldset>
		<form class="layui-form" method="post" action="">
			<div class="layui-form-item">
				<label class="layui-form-label">资源名</label>
				<div class="layui-input-inline">
					<input id="resname2" type="text" name="resname" lay-verify="title" autocomplete="off" placeholder="请输入资源名"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">资源描述</label>
				<div class="layui-input-inline">
					<input id="description2" type="text" name="desceription" lay-verify="title" autocomplete="off" placeholder="请输入资源描述"
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
 	<script type="text/html" id="barDemo4">
		<a class="layui-btn layui-btn-xs" lay-event="edit2">编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>

<script>
layui.use(['table','form','layer'],function(){
    var table = layui.table
    ,layer=layui.layer
    
    ,$ = layui.jquery//加载表格模块
    table.init('demo4', {
         hight:500  
        ,url:'<%=request.getContextPath() %>/ListAllResources' //设置高度
        ,page:true //开启分页
        ,limits: [30,60,90]
        ,limit: 30 //每页默认显示的数量
    });
  //监听工具条
  var id;
    table.on('tool(demo4)', function (obj) {
            var data = obj.data;
            var event = obj.event;
            
            if (event === 'del') {
                //删除数据在这里可以使用Ajax异步  就和平常使用一样简单
                var msg='';
                $.ajax({
                    url: '<%=request.getContextPath()%>/DeletResources',
                    type: "GET",
                    async: false,
                    data: {
                        resourcesID:data.id
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
                    area: ['350px', '250px'],
                    title: false,
                    content: $("#updatresources"), 
                });
            	
            	$('#resname2').val(data.name);
            	$('#description2').val(data.desceription);
            }
    });
  //修改角色按钮事件
  $('#update').on('click',function(){
	  $.ajax({
          url: '<%=request.getContextPath()%>/UpdateResources',
          type: "GET",
          async: false,
          data: {
              resID:id,
              resname:$('#resname2').val(),
              resdescription:$('#description2').val()
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
    $('.addresources').on('click', function () {
		layer.open({
            type: 1,
            btnAlign: 'c',
            area: ['350px', '250px'],
            title: false,
            content: $("#addresources"), 
        });
    });
  //提交添加角色按钮事件
   $('#add').on('click',function(){
	   $.ajax({
           url: '<%=request.getContextPath()%>/AddResources',
           type: "GET",
           async: false,
           data: {
               resname:$('#resname').val(),
               resdescription:$('#description').val()
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