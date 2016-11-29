<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
	<head>
		<title>工具栏</title>
		<link href="../css/styles_menu.css" rel="stylesheet" type="text/css">
	    <script type="text/javascript">   
         <!--
    		window.onbeforeunload = function(){
				var n = window.event.screenX - window.screenLeft;
				var b = n > document.documentElement.scrollWidth-20;
				//alert("abc");
				if(b && window.event.clientY < 0 || window.event.altKey){
					//alert("123");
					document.Rpt.location.href='logout.action';
				}
		   }
        // -->   
	    </script>
		<script language="javascript" src="../js/Main_tools.js"></script>
		<style type="text/css">
		   body{
		     background:url(../images/_menu/Buttonback.gif);
		     margin:0px;
		   }
		</style>
	</head>
	<body >
		<div style="float:left;display:inline-block;width:20px;line-height:20px;background-image:url('../images/_menu/push.gif');"><br></div>
		<div id="W" style="float:left;display:inline-block;width:50px;line-height:20px">
			<img id='PW' src='../images/_menu/push.gif' border="0"  title="隐藏主控菜单" onclick="onhide1(this)">
		</div>
		<div  style="float:left;display:inline-block;width:32px;line-height:20px;background-image:url('../images/_menu/blank.gif');"><br></div>
		<div id="W" style="float:left;display:inline-block;width:85px;line-height:20px;">
			<img id='PU' src='../images/_menu/blank.gif' border="0"  title="" onclick="onhide2(this)">
		</div>
		<div id="theInfo" style="float:left;width:20px;line-height:20px;">
			<marquee width="100%" style="color:#000000;font-size:12px;" onmouseover="this.stop()" onmouseout="this.start()"  scrollAmount='1' scrollDelay='50' direction='left' height='20' >
			  <span>欢迎登录信息工程学院学生综合测评管理系统</span>
			</marquee>
		</div>
		<div style="float:right;display:inline;line-height:20px;text-align:right;">
			<div style="float:left;display:inline">
				<img id='T6' src='../images/_menu/home.gif' border='0'  alt='back' title='首页' onmouseover="DoMouse(this)" onmouseout="DoMouse(this)" onclick="openWinHome('../','winHome',790,425)"/>
			</div>
			<div style="float:left;display:inline">
				<img id='T1' src='../images/_menu/back.gif' border='0'  alt='back' title='后退' onmouseover="DoMouse(this)" onmouseout="DoMouse(this)" onclick="try{parent.frmbody.frmMain.history.go(-1)}catch(goErr){}"/>
			</div>
			<div style="float:left;display:inline">
				<img id='T3' src='../images/_menu/fresh.gif' border='0'  alt='fresh' title='刷新' onmouseover="DoMouse(this)" onmouseout="DoMouse(this)" onclick="Fresh()"/>
			</div>
			<div style="float:left;display:inline">
				<img id='T4' src='../images/_menu/help.gif' border='0'  alt='help' title='帮助' onclick="Help()" onmouseover="DoMouse(this)" onmouseout="DoMouse(this)"/>
			</div>
			<div style="float:left;display:inline" id="td_ty">
				<img id='T5' src='../images/_menu/close.gif' border='0'  alt='close' title='注销'  onclick="LogOut();" onmouseover="DoMouse(this)" onmouseout="DoMouse(this)" />
			</div>
		</div>
		<iframe name="Rpt" id="Rpt" style="display:none" frameborder="0"></iframe>
		<input type="hidden" name="typeName" id="typeName" value="${user.user_level }">
	</body> 
	<script language="javascript">
	window.onload = window.onresize = function(){resizeMarquee();}
	function resizeMarquee(){
		try{
		    document.getElementById('theInfo').style.width=
			                          (document.body.offsetWidth-490)+'px';
	    }catch(err){}
	}
	function Help()
	{
		var TypeName="";
		TypeName=document.getElementById('typeName').value;
		//TypeName=TypeName.substring(0,3);
		//alert(TypeName);
		if(TypeName=="0")
		  openWinX('../_help/master/index.htm','',437,543);
		else if(TypeName=="1")
		  openWinX('../_help/admin/index.htm','',437,543);
		else if(TypeName=="2")
		  openWinX('../_help/teacher/index.htm','',437,543);
		else if(TypeName=="3")
		  openWinX('../_help/student/index.htm','',437,543);
	}
	</script>
</html>