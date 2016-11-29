<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link style="text/css" rel="stylesheet" href="../../css/common.css"/>
	<script type="text/javascript" src="../../js/ajax.js"></script>
	<script type="text/javascript">
	    function chkValue(){
	       var frm=document.getElementsByName("form1")[0];
	       var level=frm.sel_level.value;
	       var class_abbr="";
	       if(level=="3"){
	          class_abbr=frm.cla.value;
	       }
	       if(level==""){
	          alert("请选择用户身份");
	       }else if(level=="3"&&class_abbr==""){
	          alert("请选择班级！");
	       }else{
	          frm.action="listUser.action?level="+level+"&class_abbr="+class_abbr;
	          frm.method="post";
	          frm.submit();
	       }
	    }
	    
	    function openChild(url,w,h){
	       var features="dialogWidth="+w+"px;dialogHeight="+h+"px;resizable=no;center=yes;dialogLeft="
	                    +(window.screen.width-w)/2+"px;dialogTop="+(window.screen.height-h)/2+"px;";
	       var data=window.showModalDialog(url,window,features);//获得子窗体传回的值
	       if(data!=null){
	           var frm=document.getElementsByName("form1")[0];
	           var level=data.level;
	           var class_abbr=data.abbr;
		       frm.action="listUser.action?level="+level+"&class_abbr="+class_abbr;
		       frm.method="post";
		       frm.submit();
		       //setTimeout(alert("用户信息添加成功！"),2000);
	       }
	    }
	    
	    function chkLevel(obj){
	       var s=obj.value;
	       if(s=="3"){
	           $("selcla").style.visibility="";
	       }else{
	           $("selcla").style.visibility="hidden";
	       }
	    }
	    
	    function ajaxClass(v,s){
	       //利用get方式发送请求
	       var xhr=getXhr();
	       xhr.open('get','selClasses.action?grade='+v,true);
	       xhr.onreadystatechange=function(){
	          if(xhr.readyState==4){
	             var txt=xhr.responseText;
	             //处理返回的字符串（json格式）
	             var jsonCla=eval(eval(txt));//转化为json对象
	             $("cla").options.length=0;
	             $("cla").options[0]=new Option("--选择班级--","");
	             for(var i=0;i<jsonCla.length;i++){
	                var jc=jsonCla[i];
	                var op=new Option(jc.name,jc.abbr);
	                if(s==jc.abbr){
	                  op.selected=true;
	                }
	                $("cla").options[i+1]=op;
	             }
	             if(s!=""){
	               chkValue();
	             }
	          }
	       };
	       xhr.send(null);
	    }
	</script>
	<script type="text/javascript" src="../../js/ind_HTML_hr.js"></script>
  </head>
  <body>
     <form name="form1" action="" method="post" target="frmRpt">
		 <table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
			<tr>
			  <td valign="top" align="center">
                 <table width="760" border=0 cellspacing="0" cellpadding="0" align="center" height="26">
                   <tr><td valign="bottom" align="center"><b>用户信息</b></td></tr>
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
			      <c:if test="${user['user_level']=='1'||user['user_level']=='2'}">
		            <td width="30%" height=28px><font class="font1">用户身份：</font>
		                <span onmousemove="this.setCapture();" onmouseout="this.releaseCapture();" > 
		                  <select name="sel_level"  style="width:110px;" onfocus="this.blur();">
								<option value="">--选择身份--</option>
								<option value="1">班主任</option>
								<option value="2">学习委员</option>
								<option value="3" selected="selected">学生</option>
							</select>
		                </span>
					</td>
					<td>
					    <span id="selcla" onmousemove="this.setCapture();" onmouseout="this.releaseCapture();" >
							<s:select list="#{'09':'09级','10':'10级','11':'11级','12':'12级'}" listValue="value" 
							  listKey="key" name="grade" id="grade" theme="simple" onfocus="this.blur();" 
							  value="#session.user.grade" headerKey="" headerValue="--年级--"/>
							
							<select id="cla" name="cla" onfocus="this.blur();">
							   <option value="">--选择班级--</option>
							</select>
						</span>
		            </td>
		            <td  width="10%"  align="left" height=28px>
				        <input class="but20"  type="button" name="subBtn" value="检索" disabled="disabled"/>
					</td>
		            <script type="text/javascript">
							var grade=$('grade').value;
							var abbr="${sessionScope.user['class_abbr']}";
							ajaxClass(grade,abbr);
					</script>
	    		    </c:if>
	    		    <c:if test="${user['user_level']=='0'}">
			            <td width="30%" height=28px><font class="font1">用户身份：</font>
			                <select name="sel_level" style="width:110px;" onchange="chkLevel(this)">
								<option value="">--选择身份--</option>
								<option value="1">班主任</option>
								<option value="2">学习委员</option>
								<option value="3">学生</option>
							</select>
						</td>
						<td>
						    <span id="selcla" style="visibility:hidden;">
								<select id="grade" name="grade" onchange="ajaxClass(this.value,'')">
								   <option value="">--年级--</option>
								   <option value="09">09级</option>
								   <option value="10">10级</option>
								   <option value="11">11级</option>
								   <option value="12">12级</option>
								</select>
								<select id="cla" name="cla">
								   <option value="">--选择班级--</option>
								</select>
							</span>
			            </td>
		    		    <td  width="10%"  align="left" height=28px>
				           <input class="but20"  type="button" name="subBtn" value="检索" onclick="chkValue()" />
						</td>
						</c:if>
					<td width="15%" align="right" height="28px">
					   <input type="button" class="but2" value="添加用户" onclick="openChild('AddUser.jsp',437,600)"/>
					</td>
    			</tr>
    		  </table>
		   </td>
	     </tr>
     	 <tr>
     	    <td valign="top" align="center" height="5%"><br></td>
     	 </tr> 
	     <tr>
	   	   <td valign="top" align="center" height="100%">
         	  <iframe name="frmRpt" src="" width="99%" height="99%" frameborder="0"></iframe>
       	   </td>
     	 </tr>
       </table>
     </form>          
  </body>
</html>
