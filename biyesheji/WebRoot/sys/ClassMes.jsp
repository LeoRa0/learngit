<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>班级信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link style="text/css" rel="stylesheet" href="../css/common.css"/>
	<script type="text/javascript" src="../js/ind_HTML_hr.js"></script>
	<script type="text/javascript">
	    function chkValue(){
	       var frm=document.getElementsByName("form1")[0];
	       var grade=frm.sel_grade.value;
	       if(grade==""){
	          alert("请选择年级");
	       }else{
	          frm.action="listAllClass.action?grade="+grade;
	          frm.method="post";
	          frm.submit();
	       }
	    }
	    function openWinX(url, name, w, h) {
	         var pop = window.open(url,name,"width="+ w + ",height="+ h 
	                   + ",toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
	         pop.moveTo((window.screen.width - w) / 2, (window.screen.height - h) / 2);
        }
	    function openChild(url,name,w,h){
	       var features="dialogWidth="+w+"px;dialogHeight="+h+"px;resizable=no;center=yes;dialogLeft="
	                    +(window.screen.width-w)/2+"px;dialogTop="+(window.screen.height-h)/2+"px;";
	       var flag=window.showModalDialog(url,name,features);
	       if(flag!=null){
	           var frm=document.getElementsByName("form1")[0];
	           var grade=flag;
		       frm.action="listAllClass.action?grade="+grade;
		       frm.method="post";
		       frm.submit();
		       setTimeout(alert("班级信息添加成功！"),2000);
	       }
	    }
	</script>
  </head>
  <body>
     <form name="form1" action="" method="post" target="frmRpt">
		 <table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
			<tr>
			  <td valign="top" align="center">
                 <table width="760" border=0 cellspacing="0" cellpadding="0" align="center" height="26">
                   <tr><td valign="bottom" align="center"><b>班级信息</b></td></tr>
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
			   <table width="500px" border="0" cellspacing="0" cellpadding="0" align="center" height="26" >
	 			  <tr valign="middle" align="left">
		            <td width="40%" height="28px"><font class="font1">年级：</font>
		                <select name="sel_grade" style="width:110px;">
							<option value="">--选择年级--</option>
							<option value="09">09级</option>
							<option value="10">10级</option>
							<option value="11">11级</option>
							<option value="12">12级</option>
							<option value="all">&lt;&lt;所有年级&gt;&gt;</option>
						</select>
		            </td>
				    <td  width="30%"  align="right" height=28px>
			           <input class="but20"  type="button" name="subBtn" value="检索" onclick="chkValue()" >
					</td>
					<td width="30%" align="right" height="28px">
					   <input type="button" class="but2" value="添加班级" onclick="openChild('AddClass.jsp','添加班级',437,543)"/>
					</td>
    			</tr>
    		  </table>
		   </td>
	     </tr>
     	 <tr><td valign="top" align="center" height="5%"><br>
         </td></tr> 
	     <tr>
	   	   <td valign="top" align="center" height="100%">
         	  <iframe name="frmRpt" src="" width="99%" height="99%" frameborder="0"></iframe>
       	   </td>
     	 </tr>
       </table>
     </form>          
  </body>
</html>
