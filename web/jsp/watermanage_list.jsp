<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>水源管理</title>
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<script type="text/javascript" src="../js/frame.js"></script>

</head>

<body>
<div style="width:80%;left:30px; position:absolute; height:auto">
<div style="margin-top:20px">
	<form>
	<input type="text" style="width:150px; padding:5px; border-radius:5px; border:1px solid #CCC" />
   <input type="button" style="width:50px; padding:5px; border-radius:5px; background:#c00; border:none; color:#fff"  value="搜索" />
    <select style="width:150px; padding:5px; margin-left:20px">
      <option value="1">水源类型</option>
      <option value="2">消火栓</option>
      <option value="3">其他水源</option>
	</select>
   </form>
	 <a href="otherwater_add.html"><span style="float:right;  margin:5px; cursor:pointer;" id="adduser">新增水源  </span></a>
     <a href="hyfrant_add.html"><span style="float:right; margin:5px; cursor:pointer;" id="adduser">新增消防栓 </span></a>
</div>
<table class="teamtable" cellspacing="0">
	<table class="teamtable_title" cellspacing="0">
    	<tr>
            <td>水源编号</td>
            <td>水源名称</td>
            <td>水源类型</td>
            <td>描述</td>
            <td>图片</td>
            <td>水源地址</td>
            <td>编辑</td>
        </tr>
    </table>
    <table class="teamtable_main" cellspacing="0">
    	<tr>
        	 <td>0001</td>
            <td>水源名称</td>
            <td>水源类型</td>
            <td>描述</td>
            <td>图片</td>
            <td>水原地址</td>
            <td>
            <a href="record_list.html">维护记录</a> |
           	 <a href="water_revise.html">编 辑</a> |
             <span onclick="deleteuser()" style="color:#cc0000; cursor:pointer;"> 删 除
             </span>
            </td>
        </tr>
    </table>
 </table>
</div>


</body>
</html>
