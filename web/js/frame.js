// JavaScript Document
	function changeurl(id){
		var mainframe=document.getElementById("mainframe");
		//document.getElementById(id).style.backgroundColor="rgb(255, 0, 0)";
		//mainframe.src=id+".html"
		switch(id){
			case "usermanage":
				mainframe.src="jsp/usermanage.jsp";
			break;
			case "teammanage":
				mainframe.src="jsp/teammanage.jsp";
			break;
			case "officmanage":
				mainframe.src="jsp/officmanage.jsp";
			break;
			case "teamtypemanage":
				mainframe.src="jsp/teamtypemanage.jsp";
			break;
			case "watermanage_list":
				mainframe.src="jsp/watermanage_list.jsp";
			break;
			case "record_list":
				mainframe.src="jsp/record_list.jsp";
			break;
			
			case "hyfrantmanage":
				mainframe.src="jsp/hyfrantmanage.jsp";
			break;
			
			case "otherwater":
				mainframe.src="jsp/otherwatermanage.jsp";
			break;
			case "six_list":
				mainframe.src="jsp/six_list.jsp";
			break;
			
			case "importunit_list":
				mainframe.src="jsp/importunit_list.jsp";
			break;
			
			case "otherplaces_list":
				mainframe.src="jsp/otherplaces_list.jsp";
			break;
			}
		
		}
function quit(){
	alert("确认退出吗");
}
function deleteuser(){
	alert("确认删除吗");
	}