<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="../../css/common.css"/>
	<script type="text/javascript" src="../../js/ajax.js"></script>
	<script type="text/javascript" src="../../js/Common.js"></script>
    <style type="text/css">
       .table1{
           border-collapse:collapse;
           font-size:14px;
           font-family:"宋体";
       }
       .tab_header th{
          background:url(../../images/head.gif);
          border:1px solid #A6A6A6;
          height:25px;
       }
       .table1 tr td{
          text-align:center;
          border:1px solid #A6A6A6;
          height:25px;
       }
       .tr1{
          background-color:#F0F8FF
       }
    </style>
    <script type="text/javascript">
		var frm=parent.document.getElementsByName("form1")[0];
	    var level=frm.sel_level.value;
	    var class_abbr="";
	    if(level=="3"){
	       class_abbr=frm.cla.value;
	    }
		
		//更新数据
		function updateValue(N,url,w,h){
		   var frm=document.getElementById(N);
		   var aa = frm.getElementsByTagName("input");
		   var j=0;
		   var data;
		   for (var i=0; i<aa.length; i++){
	  			if (aa[i].type=="checkbox"&&aa[i].checked ==true){
                         j++;
                         if(j==1){
                           data=aa[i].value;
                         }
                }
		   }
		   if(j<1){
		      alert("请选择一条记录！");
		   }else if(j>1){
              alert("您只能选择一条记录进行修改！");
           }else{
			  var bb=$("tr"+data).getElementsByTagName("td");
			  //alert(bb[0].getElementsByTagName("input")[0].value);
			  //Object
			  //document.getElementById("delcla").value=bb;
			  var features="dialogWidth="+w+"px;dialogHeight="+h+"px;resizable=no;center=yes;dialogLeft="
	                    +(window.screen.width-w)/2+"px;dialogTop="+(window.screen.height-h)/2+"px;";
	          var grade=window.showModalDialog(url,bb,features);
			  if(grade!=null){
			     level=grade.level;
			     class_abbr=grade.abbr;
			     frm.action="listUser.action?level="+level+"&class_abbr="+class_abbr;
	             frm.method="post";
	             frm.submit();
			  }
			  /*
			  for(var i=0;i<bb.length;i++){
			     alert(bb[i].innerHTML);
			  }
			  */
		   }  
		}
		
		
		//删除数据（批量删除）
		function deleteValue(N){
		   var frm=document.getElementById(N);
		   var aa = frm.getElementsByTagName("input");
		   var j=0;
		   var datas=[];//存放Json对象的数组
		   for (var i=0; i<aa.length; i++){
	  			if (aa[i].type=="checkbox"&&aa[i].checked ==true){
                         j++;
                         var data={};//Json对象
                         data["id"]=aa[i].value;
                         datas.push(data);
                }
		   }
		   var jsonString=JSON.stringify(datas);
		   //alert(jsonString);
		   if(j<1){
		      alert("请选择至少一条记录！");
		   }else{
		      //document.getElementById("delcla").value=jsonString;
			  frm.action="deleteUser.action?jsonString="+jsonString+"&level="+level+"&class_abbr="+class_abbr;
			  frm.method="post";
			  frm.submit();
			  
			  //this.parent.chkValue();
		   }  
		}
    </script>
  </head>
  <body>
    <form id="form1">
    <center>
     <div>
       <table id="table1" class="table1" width="600px">
         <tr class="tab_header">
           <th width="3%"></th>
           <th width="7%">序号</th>
           <th width="15%">账号</th>
           <th width="10%">姓名</th>
           <th width="15%">用户身份</th>
           <th width="10%">年级</th>
           <th width="40%">班级</th>
         </tr>
         <s:iterator value="userList" var="user" status="stat">
	       <s:if test="#stat.count%2==0">
	         <tr class="tr1" id="tr<s:property value='#user.id'/>">
	       </s:if>
	       <s:else>
	         <tr id="tr<s:property value='#user.id'/>">
	       </s:else>
	           <td>
	             <input type="checkbox" value="<s:property value='#user.id'/>" name="checkbox"/>
	           </td>
	           <td><s:property value="#stat.count"/></td>
	           <td><s:property value="#user.userId"/></td>
	           <td><s:property value="#user.user_name"/></td>
	           <td><s:property value="#user.user_identity"/></td>
	           <td><s:property value="#user.grade"/>级</td>
	           <td><s:property value="#user.major_name"/><s:property value="#user.class_name"/>（<s:property value="#user.edu_bg"/>）</td>
	         </tr>
         </s:iterator>
             <tr>
               <td style="border-width:0px;text-align:left;vertical-align:bottom;font-size:12px;" colspan="3">
                  <a href="javascript:void(0);" onclick="cc2('form1')">全选/全不选</a>
               </td>
             </tr>
       </table>
       <span style="margin-top:20px;width:300px;">
           <input type="hidden" id="delcla" name=""/>
	       <input type="button" value="修改" onclick="updateValue('form1','DetailUser.jsp',437,543)"/>
	       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	       <input type="button" value="删除" onclick="deleteValue('form1')"/>
       </span>
     </div>
    </center>
    </form>
  </body>
</html>
