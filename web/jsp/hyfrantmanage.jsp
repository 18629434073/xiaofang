<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>消火栓管理</title>
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<script type="text/javascript" src="../js/frame.js"></script>

</head>

<body>
<div style="width:80%;left:30px; position:absolute; height:auto">
<div style="margin-top:20px">
	<input type="text" style="width:150px; padding:5px; border-radius:5px; border:1px solid #CCC" />
   <input type="button" style="width:50px; padding:5px; border-radius:5px; background:#c00; border:none; color:#fff"  value="搜索" />
    <select style="width:150px; padding:5px; margin-left:20px">
      <option value="1">辖区中队</option>
      <option value="2">未央区</option>
      <option value="3">碑林区</option>
      <option value="4">新城区</option>
	</select>
     <select style="width:150px; padding:5px; margin-left:20px">
      <option value="1">类型</option>
      <option value="2">市政消火栓</option>
      <option value="3">公共消火栓</option>
	</select>
	 <a href="hyfrant_add.html"><span style="float:right; cursor:pointer;" id="adduser">新增消防栓</span></a>
</div>
<table class="teamtable" cellspacing="0">
	<table class="teamtable_title" cellspacing="0">
    	<tr>
            <td>名称</td>
            <td>编号</td>
             <td>地址</td>
            <td>类型</td>
            <td>水压</td>
            <td>设置方式</td>
             <td>辖区中队</td>
             <td>方位图</td>
            <td>备注</td>
            <td>编辑</td>
        </tr>
    </table>
    <table class="teamtable_main" cellspacing="0">
    	<tr>
        	 <td>名称</td>
            <td>编号</td>
             <td>地址</td>
            <td>类型</td>
            <td>水压</td>
            <td>设置方式</td>
             <td>辖区中队</td>
             <td>方位图</td>
            <td>备注</td>
            <td>
           	 <a href="hyfrant_revise.html">编 辑</a>
             <span onclick="deleteuser()" style="color:#cc0000; cursor:pointer;"> 删 除
             </span>
            </td>
        </tr>
    </table>
 </table>
</div>


</body>
</html>
