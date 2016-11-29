<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
	<head>
		<title></title>
		<script type="text/javascript">
	         //服务端变量 
			var js_ServerTheCustomer='西藏民族学院';

			//客户端变量
			var js_ClientIP='';
			var js_ClientPCInfo='';

			//当前用户变量
			var js_UserID='';
			var js_UserName='';
			var js_UserRight='';
			var js_UserLVID='';
			var js_UserGroup='';
			var js_UserDepart='';
			var js_UserLogTime='';

			//当前系统变量
			var js_SysTREE_Multi=true;
			var js_SysMsg_POP_DELAY='5';
			var js_SysDEBUG_DOOR='1';
			var js_SysPageSize_Door='';
			var js_SysTREE_Single='';

			var js_Sys_vkxrq='20120903';
			var js_shoolcode='10695';
			var js_ssosite='';//系统集成参数	
		</script>
	 	<script type="text/javascript" src="../js/time.js"></script>
	    <style type="text/css">
           	 body{
           	   margin:0px;
           	 }
           	 #hiden1{
           	   Z-INDEX: -1; 
           	   LEFT: 0px; 
           	   VISIBILITY: hidden; 
           	   WIDTH: 100px; 
           	   POSITION: absolute; 
           	   TOP: 0px; 
           	   HEIGHT: 7px;
           	 }  
 	    </style>
	</head>
	<body>
		<div id="hiden1"></div>
		<font face="宋体"></font>
		<table width="100%" height="82px" border="0" cellspacing="0" cellpadding="0">
			<!-- BANNER区 -->
			<tr>
				<td width="70%" nowrap="nowrap" background="../images/banner.jpg"><br></td>
				<!-- 
				<td width="25%" background="../images/banner_centerl.gif"><br></td>
				<td width="460" nowrap="nowrap" valign="middle" background="../images/banner_center.gif" ><br></td>
				-->
				<td width="30%" background="../images/banner_centerr.gif"><br></td>
				<td width="280" nowrap="nowrap" align="right" valign="middle" background="../images/banner_right.gif">
					<table border="0" cellpadding="0" cellspacing="0" height="100%" width="200">
						<tr>
							<td align="right" valign="bottom"><br>
							</td>
						</tr>
						<tr>
							<td align="right" valign="bottom">
								<!--统计在线人数-->
								<span id="onTimeNum" style='FONT-SIZE:9pt;COLOR:white'>
								      在线人数：${activeUserNum }&nbsp;
								</span>
							</td>
						</tr>
						<tr>
							<td align="right" valign="bottom" nowrap="nowrap">
								<span style='FONT-SIZE:9pt;COLOR:white'>
									<script type="text/javascript">
                                         document.write(time()+"&nbsp;");
                                    </script>
								</span>
							</td>
						</tr>
						<tr>
							<td align="right" valign="bottom" nowrap="nowrap">
								<span style='FONT-SIZE:9pt;COLOR:white'>
									<script type="text/javascript">
                                         document.write(getTermAndWeek()+"&nbsp;");
                                    </script>
								</span>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<script language="javascript">
			function StartLoadMenu(){
			  try{
				  parent.frames["frmbody"].location='Menu.jsp';
			  }catch(e){
			      alert('加载菜单数据失败，请刷新页面！');
			  }
			}
			window.setTimeout("StartLoadMenu()",300);
		</script>
	</body>
</html>