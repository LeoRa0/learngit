<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>发展素质分数表</title>
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
           width:850px;
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
         <th  width="80px;">学号</th>
         <th width="60px;">姓名</th>
         <th>思想政治与道德修养10分</th>
         <th>创新创造能力25分</th>
         <th>组织管理能力20分</th>
         <th>社会实践与自愿者服务15分</th>
         <th>文体特长15分</th>
         <th>操作技能15分</th>
         <th>发展素质测评总分</th>
         <th>发展素质测评×15%</th>
         <th width="60px;">分数操作</th>
       </tr>
       <s:iterator value="listProSum" var="ps" status="stat">
       <tr class="tr<s:property value="#stat.count%2"/>">
         <td><s:property value="#stat.count"/></td>
         <td><s:property value="#ps.userId"/></td>
         <td><s:property value="#ps.user_name"/></td>
         <td><s:property value="#ps.sum_1"/></td>
         <td><s:property value="#ps.sum_2"/></td>
         <td><s:property value="#ps.sum_3"/></td>
         <td><s:property value="#ps.sum_4"/></td>
         <td><s:property value="#ps.sum_5"/></td>
         <td><s:property value="#ps.sum_6"/></td>
         <td><s:property value="#ps.total"/></td>
         <td><s:property value="#ps.zhehe_total"/></td>
         <td>
           <a href="javascript:void(0);" onclick="openChild('listProMes.action?userId=<s:property value="#ps.userId"/>',800,550)">录入/修改</a>
         </td>
       </tr>
       </s:iterator>
     </table>
  </body>
</html>
