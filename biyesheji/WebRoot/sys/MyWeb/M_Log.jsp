<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
	<head>
		<title>查看个人登录日志</title>
		<link rel="stylesheet" href="../../css/styles_Qry.css" type="text/css"/>
		<script type="text/javascript" src="../../js/ind_HTML_hr.js"></script>
		<script type="text/javascript">
			function isDate(str){
			   var d=new Date(str);
			   return !isNaN(d);
			}
			function chkdate(theID){
			    if (!isDate(theID.value)){ 
			        alert("请输入正确格式的时间！"); 
			       	theID.value="2012-11-14 11:03:34";
				    theID.focus();
			    }
			}
		</script>
		<script language="javascript">
			function chkTimeSeg(obj){
				try{
					var s=obj.value;
					if(s=="5"){
						document.getElementById('chkTime').style.visibility="";
					}else{
						document.getElementById('chkTime').style.visibility="hidden";
					}
				}catch(e){alert(e);}
			}
			
			function chkValue(){
				var frm = document.getElementsByName('form1')[0];
				try{
					if(document.getElementById('chkTime').style.visibility==""){
						if(frm.txtTimeBeg.value==""){
							alert('请输入起始时间！');
							frm.txtTimeBeg.focus();
						}else if(frm.txtTimeEnd.value==""){
							alert('请输入结束时间！');
							frm.txtTimeEnd.focus();
						}else{
							frm.action="M_Log_Rpt.aspx";
							frm.method="post";
							frm.submit();
						}
					}else{
						frm.action="M_Log_Rpt.aspx";
						frm.method="post";
						frm.submit();
					}
				}catch(e){alert(e);}
			}
		</script>
	</head>
	<body style="margin-left:0px;margin-top:0px;">
       <form name="form1" action="" method="post" target="frmRpt">
		 <table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
			<tr>
			  <td valign="top" align="center">
                 <table width="760" border=0 cellspacing="0" cellpadding="0" align="center" height="26">
                   <tr><td valign="bottom" align="center"><b>查看个人登录日志</b></td></tr>
	               <tr><td valign="bottom" align="center">
	                  <script language="JavaScript">
	                     Draw_HR('99.5%')
	                  </script>
	               </td></tr>
                </table>   
             </td>
           </tr>
           <tr>
             <td valign="middle" align="center" height="5%">
			   <table width="700px" border="0" cellspacing="0" cellpadding="0" align="center" height="26" >
	 			  <tr valign="middle" align="left">
		            <td width="65%" height=28px>时间区段&nbsp;
		                <select name="sel_type" onchange="chkTimeSeg(this)" style="width:125px;">
							<option value="">--选择时间--</option>
							<option value="1">今天</option>
							<option value="2">本周</option>
							<option value="3">本月</option>
							<option value="4">本年</option>
							<option value="5">&lt;&lt;指定日期&gt;&gt;</option>
						</select>
			            <span id="chkTime" style="visibility:hidden;">
				           <input type="text" name="txtTimeBeg" value="" maxlength="30" onchange="chkdate(this)" style="width:120px;">
				           --<input type="text" name="txtTimeEnd" onchange="chkdate(this)" value="" maxlength="30" style="width:120px;">
			            </span>
		            </td>
		            <td width="25%" align="right">
			                              登录IP&nbsp;<input type="text" name="txtIPAddr" value="" style="width:125px;">
		            </td>
				    <td  width="10%"  align="right" height=28px>
			           <input class="but20"  type="button" name="subBtn" value="检索" onclick="chkValue()" >
					</td>
    			</tr>
    		  </table>
		   </td>
	     </tr>
     	 <tr><td valign="top" align="center" height="5%"><br>
        	<DIV id=theHead style='display: none;width:99%;'></DIV>
         </td></tr> 
	     <tr>
	   	   <td valign="top" align="center" height="100%">
         	  <iframe name="frmRpt" src="" width="99%" height="99%" frameborder=0></iframe>
       	   </td>
     	 </tr>
       </table>
     </form>
   </body>
</html>