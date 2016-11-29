<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>特殊加分表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
    <style type="text/css">
       .table1{
           border-collapse:collapse;
           font-size:14px;
           font-family:"宋体";
           width:600px;
           margin:0px auto;
       }
       .tab_header th{
          background:url(${pageContext.request.contextPath}/images/head.gif);
          border:1px solid #A6A6A6;
          height:25px;
       }
       .table1 tr td{
          text-align:center;
          border:1px solid #A6A6A6;
          height:25px;
       }
       .tr0{
          background-color:#F0F8FF
       }
    </style>
    <script type="text/javascript">
       function openChild(url,w,h){
	       var features="dialogWidth="+w+"px;dialogHeight="+h+"px;resizable=no;center=yes;dialogLeft="
	                    +(window.screen.width-w)/2+"px;dialogTop="+(window.screen.height-h)/2+"px;";
	       var data=window.showModalDialog(url,window,features);//获得子窗体传回的值
	       if(data!=null){
	          parent.chkVal();
	       }
	    }
    </script>
  </head>
  <body>
     <table class="table1">
       <tr class="tab_header">
         <th>序号</th>
         <th>学号</th>
         <th>姓名</th>
         <th>加分1</th>
         <th>加分2</th>
         <th>加分3</th>
         <th>加分4</th>
         <th>加分5</th>
         <th>总分</th>
         <th>分数操作</th>
       </tr>
       <s:iterator value="listPS" var="ps" status="stat">
       <tr class="tr<s:property value="#stat.count%2"/>">
         <td><s:property value="#stat.count"/></td>
         <td><s:property value="#ps.userId"/></td>
         <td><s:property value="#ps.user_name"/></td>
         <td><s:property value="#ps.score_1"/></td>
         <td><s:property value="#ps.score_2"/></td>
         <td><s:property value="#ps.score_3"/></td>
         <td><s:property value="#ps.score_4"/></td>
         <td><s:property value="#ps.score_5"/></td>
         <td><s:property value="#ps.sum"/></td>
         <td>
           <a href="javascript:void(0);" onclick="openChild('listPSMes.action?userId=<s:property value="#ps.userId"/>',450,350)">录入/修改</a>
         </td>
       </tr>
       </s:iterator>
     </table>
  </body>
</html>
