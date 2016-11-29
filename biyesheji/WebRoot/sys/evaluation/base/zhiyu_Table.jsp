<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>智育素质分数表</title>
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
           width:1050px;
           margin:0px auto;
       }
       .tab_header th{
          border:1px solid #A6A6A6;
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
         <th rowspan="2">序号</th>
         <th  width="80px;" rowspan="2">学号</th>
         <th width="60px;" rowspan="2">姓名</th>
         <th colspan="6">上学期成绩</th>
         <th rowspan="2">上学期平均成绩</th>
         <th colspan="6">下学期成绩</th>
         <th rowspan="2">下学期平均成绩</th>
         <th rowspan="2">学年平均成绩</th>
         <th rowspan="2">成绩提升分</th>
         <th rowspan="2">智育素质测评总分</th>
         <th rowspan="2">智育素质测评总分×83％</th>
         <th width="60px;" rowspan="2">分数操作</th>
       </tr>
       <tr class="tab_header">
         <th>大学英语（1）</th>
         <th>高等数学（1）</th>
         <th>马克思主义与四观教育</th>
         <th>中国近现代史纲要</th>
         <th>计算机应用基础</th>
         <th>C语言程序设计</th>
         <th>大学英语（2）</th>
         <th>高等数学（2）</th>
         <th>思想道德修养与法律基础</th>
         <th>马克思主意基本原理</th>
         <th>数据库原理与应用</th>
         <th>大学物理</th>
       </tr>
       <s:iterator value="listzy" var="zys" status="stat">
       <tr class="tr<s:property value="#stat.count%2"/>">
         <td><s:property value="#stat.count"/></td>
         <td><s:property value="#zys.zy.userId"/></td>
         <td><s:property value="#zys.zy.user_name"/></td>
         <td><s:property value="#zys.zy.score_1"/></td>
         <td><s:property value="#zys.zy.score_2"/></td>
         <td><s:property value="#zys.zy.score_3"/></td>
         <td><s:property value="#zys.zy.score_4"/></td>
         <td><s:property value="#zys.zy.score_5"/></td>
         <td><s:property value="#zys.zy.score_6"/></td>
         <td><s:property value="#zys.last_term_avg"/></td>
          <td><s:property value="#zys.zy.score_7"/></td>
         <td><s:property value="#zys.zy.score_8"/></td>
         <td><s:property value="#zys.zy.score_9"/></td>
         <td><s:property value="#zys.zy.score_10"/></td>
         <td><s:property value="#zys.zy.score_11"/></td>
         <td><s:property value="#zys.zy.score_12"/></td>
         <td><s:property value="#zys.next_term_avg"/></td>
         <td><s:property value="#zys.school_year_avg"/></td>
         <td><s:property value="#zys.promote_score"/></td>
         <td><s:property value="#zys.total_score"/></td>
         <td><s:property value="#zys.zhiyu_score"/></td>
         <td>
           <a href="javascript:void(0);" onclick="openChild('listMes_zhiyu.action?userId=<s:property value="#zys.zy.userId"/>',400,500)">录入/修改</a>
         </td>
       </tr>
       </s:iterator>
     </table>
  </body>
</html>
