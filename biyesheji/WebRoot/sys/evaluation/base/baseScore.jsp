<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title><s:property value="jspTitle"/></title>
	    <link style="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/ajax.js"></script>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/ind_HTML_hr.js"></script>
	    <script type="text/javascript">
	      function chkVal(){
	         var frm=$('frm');
	         var grade=$('grade').value;
	         var cla=$('cla').value;
	         if(grade==""||cla==""){
	           alert('请选择要检索的班级！');
	         }else{
	           frm.action="${actionName}";
	           frm.method="post";
	           frm.submit();
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
	               chkVal();
	             }
	          }
	       };
	       xhr.send(null);
	     }
	     
	     
	    </script>
	</head>
	<body>
      <table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
        <tr style="height:5%;">
		  <td valign="top" align="center">
            <table width="760" border="0" cellspacing="0" cellpadding="0" align="center" height="26">
               <tr><td valign="bottom" align="center"><b><s:property value="jspTitle"/></b></td></tr>
               <tr><td valign="bottom" align="center">
                  <script language="JavaScript">
                     Draw_HR('99.5%')
                  </script>
               </td></tr>
             </table>   
          </td>
        </tr>
        <tr style="height:5%;">
          <td valign="top" align="center">
           <form id="frm" target="frmP">
            <table width="560" border="0" cellspacing="0" cellpadding="0" align="center" height="26">
              <tr>
                <th>年级：</th>
                <c:if test="${sessionScope.user['user_level']=='1'||sessionScope.user['user_level']=='2'}">
	                <td>
	                  <s:select list="#{'09':'09级','10':'10级','11':'11级','12':'12级'}" listKey="key" listValue="value" 
	                     headerKey="" headerValue="--年级--" value="#session.user.grade" name="grade" id="grade" theme="simple" 
	                     onfocus="this.blur();"/>
	                </td>
	                <th>班级：</th>
	                <td style="width:40%;">
	                  <select id="cla" name="cla" onfocus="this.blur();">
	                    <option value="">--选择班级--</option>
	                  </select>
	                  <script type="text/javascript">
	                     var grade=$('grade').value;
	                     var abbr="${sessionScope.user['class_abbr']}";
	                     ajaxClass(grade,abbr);
	                  </script>
	                </td>
	                <td>
	                  <input type="button" value="检索" disabled="disabled"/>
	                </td>
                </c:if>
                <c:if test="${sessionScope.user['user_level']=='0'}">
	                <td>
	                  <s:select list="#{'09':'09级','10':'10级','11':'11级','12':'12级'}" listKey="key" listValue="value" 
	                     headerKey="" headerValue="--年级--" name="grade" theme="simple" onchange="ajaxClass(this.value,'')"/>
	                </td>
	                <th>班级：</th>
	                <td style="width:40%;">
	                  <select id="cla" name="cla">
	                    <option value="">--选择班级--</option>
	                  </select>
	                </td>
	                <td>
	                  <input type="button" value="检索" onclick="chkVal()"/>
	                </td>
                </c:if>
              </tr>
            </table>
           </form>
          </td>
        </tr>
        <tr>
     	   <td valign="top" align="center" height="5%"><br></td>
     	 </tr> 
	     <tr>
	   	   <td valign="top" align="center" height="100%">
            <iframe name="frmP" src="" width="99%" height="99%" frameborder="0"></iframe>
          </td>
        </tr>
      </table>	   
    </body>
</html>