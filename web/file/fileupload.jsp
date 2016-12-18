<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!doctype html>
<html>
<head>
	<base href="<%=basePath%>">

	<title>ICwhich</title>

	<link href="/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
	<link href="/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
	<link href="/assets/css/main-min.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
		.dl-log-quit{
			font-weight: normal;
		}
		.dl-log{
			line-height: 20px;
		}

	</style>
</head>
<body>

<form id="Form2" method="post"  enctype="multipart/form-data">
	<h1>采用multipart提供的file.transfer方法上传文件</h1>
	<input type="file" name="file">
	<input type="submit" value="upload"/>
</form>
<script src="/assets/js/jquery-1.8.1.min.js"></script>
<script src="/assets/js/jquery.form.js"></script>
<script>
	$(function(){
		var options = {
			url:'/system/file/upload',
			beforeSubmit:  function(){},  //提交前处理
			success:       function(r){
				alert(r.message);
			},  //处理完成
			resetForm: true,
			dataType:  'json'
		};

		$('#Form2').submit(function() {
			$(this).ajaxSubmit(options);
			return false;//防止dialog 自动关闭

		});
	});

</script>
</body>
</html>
