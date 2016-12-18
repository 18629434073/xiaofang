<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>重点单位管理</title>
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
      <option value="1">辖区中队</option>
      <option value="2">未央区</option>
      <option value="3">新城区</option>
	</select>

    </form>
	 <a href="importunitadd.html"><span style="float:right; cursor:pointer;" id="adduser">新增重点单位</span></a>
</div>
<table class="teamtable" cellspacing="0">
	<table class="teamtable_title" cellspacing="0">
    	<tr>
            <td>单位类型</td>
            <td>单位名称</td>
             <td>联系人</td>
            <td>建筑层数</td>
             <td>辖区中队</td>
             <td>单位地址</td>
            <td>建筑类型</td>
             <td>建筑高度</td>
             <td>总建筑面积</td>
              <td>标准层面积</td>
            <td>编辑</td>
        </tr>
    </table>
    <table class="teamtable_main" cellspacing="0">
    	<tr>
        	 <td>单位类型</td>
            <td>单位名称</td>
             <td>联系人</td>
            <td>建筑层数</td>
             <td>辖区中队</td>
             <td>单位地址</td>
             <td>建筑高度</td>
            <td>建筑类型</td>
             <td>总建筑面积</td>
              <td>标准层面积</td>
            <td>
           	 <a href="importunitrevise.html">编 辑</a>
             <span onclick="deleteuser()" style="color:#cc0000; cursor:pointer;"> 删 除
             </span>
            </td>
        </tr>
    </table>
 </table>
</div>


</body>
</html>
