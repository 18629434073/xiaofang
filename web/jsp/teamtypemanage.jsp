<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>队伍类型管理</title>
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<script type="text/javascript" src="../js/frame.js"></script>

</head>

<body>
<div style="width:80%;left:30px; position:absolute; height:auto">
<div style="margin-top:20px">
	<input type="text" style="width:150px; padding:5px; border-radius:5px; border:1px solid #CCC" />
   <input type="button" style="width:50px; padding:5px; border-radius:5px; background:#c00; border:none; color:#fff"  value="搜索" />
	 <a href="teamtypeadduser.html"><span style="float:right; cursor:pointer;" id="adduser">新增用户</span></a>
</div>
<table class="teamtable" cellspacing="0">
	<table class="teamtable_title" cellspacing="0">
    	<tr>
            <td>id</td>
            <td>队伍名称</td>
            <td>编辑</td>
        </tr>
    </table>
    <table class="teamtable_main" cellspacing="0">
    	<tr>
        	<td>id</td>
            <td>队伍名称</td>
            <td>
           	 <a href="teamtypereviseuser.html">编 辑</a>
             <span onclick="deleteuser()" style="color:#cc0000; cursor:pointer;"> 删 除
             </span>
            </td>
        </tr>
    </table>
 </table>
</div>


</body>
</html>
