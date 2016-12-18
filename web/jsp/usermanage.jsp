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
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="../js/frame.js"></script>

<link rel="stylesheet" type="text/css" href="../css/style.css" />
<title>队伍管理</title>
</head>

<body>
<div style="margin-top:20px; margin-left:30px">
	<form>
	<input type="text" style="width:150px; padding:5px; border-radius:5px; border:1px solid #CCC" />
   	<input type="button" style="width:50px; padding:5px; border-radius:5px; background:#c00; border:none; color:#fff"  value="搜索" />
    <select style="width:150px; padding:5px; margin-left:20px">
      <option value="1">所属辖区</option>
      <option value="2">未央区</option>
      <option value="3">碑林区</option>
      <option value="4">新城区</option>
	</select>
    
   </form>
	
</div>


<div style="width:990px;left:30px; height:auto; margin-left:30px">
<table class="teamtable" cellspacing="0">
	<table class="teamtable_title" cellspacing="0">
    	<tr>
        	<td>序号</td>
            <td>用户名</td>
            <td>密码</td>
            <td>权限</td>
            <td>所属辖区</td>
            <td>姓名</td>
            <td>头像</td>
            <td>上次登录</td>
            <td>编辑</td>
        </tr>
    </table>
    <table class="teamtable_main" cellspacing="0">
    	<tr>
        	<td>01</td>
            <td>admin</td>
            <td>123456sdgfergtregrthbysdcfsdfvfdgvfgvhtyh</td>
            <td>查看权限</td>
            <td>未央区</td>
            <td>张三</td>
            <td><img src="../img/logo.png" width="30px" height="20px" /></td>
            <td>2016-06-12</td>
            <td>
           		<a style="cursor:pointer" href="teamreviseuser.html">编 辑</a> |</span><span style="color:#cc0000; cursor:pointer" onclick="deleteuser()"> 删 除</span>
            </td>
        </tr>
        <tr>
        	<td>01</td>
            <td>admin</td>
            <td>123456</td>
            <td>查看权限</td>
            <td>未央区</td>
            <td>张三</td>
            <td><img src="../img/logo.png" width="30px" height="20px" /></td>
            <td>2016-06-12</td>
            <td>
           		<a style="cursor:pointer" href="teamreviseuser.html">编 辑</a> |</span><span style="color:#cc0000; cursor:pointer" onclick="deleteuser()"> 删 除</span>
            </td>
        </tr>
        <tr>
        	<td>01</td>
            <td>admin</td>
            <td>123456</td>
            <td>查看权限</td>
            <td>未央区</td>
            <td>张三</td>
            <td><img src="../img/logo.png" width="30px" height="20px" /></td>
            <td>2016-06-12</td>
            <td>
           		<a style="cursor:pointer" href="teamreviseuser.html">编 辑</a> |</span><span style="color:#cc0000; cursor:pointer" onclick="deleteuser()"> 删 除</span>
            </td>
        </tr>
    </table>
 </table>
</div>
</body>
</html>

