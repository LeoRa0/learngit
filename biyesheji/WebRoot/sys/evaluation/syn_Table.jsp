<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>综合素质测评综合分数表</title>
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
           width:750px;
           margin:0px auto;
       }
       .tab_header th{
          background:url(${pageContext.request.contextPath}/images/head.gif);
          border:1px solid #A6A6A6;
          height:25px;
          font-size:12px;
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
  </head>
  <body>
     <table class="table1">
       <tr class="tab_header">
         <th>序号</th>
         <th  width="80px;">学号</th>
         <th width="60px;">姓名</th>
         <th>基础性素质测评成绩×85%</th>
         <th>发展性素质测评成绩×15%</th>
         <th>特殊加分</th>
         <th>综合素质测评总分</th>
       </tr>
       <s:iterator value="listSyn" var="syn" status="stat">
       <tr class="tr<s:property value="#stat.count%2"/>">
         <td><s:property value="#stat.count"/></td>
         <td><s:property value="#syn.ps.userId"/></td>
         <td><s:property value="#syn.ps.user_name"/></td>
         <td><s:property value="#syn.bs.zh_totalScore"/></td>
         <td><s:property value="#syn.ps.zhehe_total"/></td>
         <td><s:property value="#syn.peculiar"/></td>
         <td><s:property value="#syn.totalScore"/></td>
       </tr>
       </s:iterator>
     </table>
  </body>
</html>
