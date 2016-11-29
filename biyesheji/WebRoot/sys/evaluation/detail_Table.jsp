<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>综合素质测评分数详表</title>
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
           width:1450px;
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
  </head>
  <body>
     <table class="table1">
        <tr class="tab_header">
         <th rowspan="4">序号</th>
         <th  width="80px;" rowspan="4">学号</th>
         <th width="60px;" rowspan="4">姓名</th>
         <th colspan="29">基础性素质</th>
         <th rowspan="4">基础素质测评总分</th>
         <th rowspan="4">基础素质测评总分×85%</th>
         
         <th colspan="6">发展性素质</th>
         <th rowspan="4">发展素质测评总分</th>
         <th rowspan="4">发展素质测评总分×85%</th>
         
         <th rowspan="4">特殊加分</th>
         <th rowspan="4">综合测评总分</th>
       </tr>
       <tr class="tab_header">
         <th colspan="5">德育分</th>
         <th rowspan="3">德育素质测评总分</th>
         <th rowspan="3">德育素质测评总分×10%</th>
         
         <th colspan="16">智育分</th>
         <th rowspan="3">智育素质测评总分</th>
         <th rowspan="3">智育素质测评总分×83％</th>
         
         <th colspan="2">体育分</th>
         <th rowspan="3">体育素质测评总分</th>
         <th rowspan="3">体育素质测评总分×7%</th>
         
         <th rowspan="3">思想政治与道德修养10分</th>
         <th rowspan="3">创新创造能力25分</th>
         <th rowspan="3">组织管理能力20分</th>
         <th rowspan="3">社会实践与自愿者服务15分</th>
         <th rowspan="3">文体特长15分</th>
         <th rowspan="3">操作技能15分</th>
       </tr>
       <tr class="tab_header">
         <th rowspan="2">政治思想素质20分</th>
         <th rowspan="2">道德素质15分</th>
         <th rowspan="2">遵纪守法30分</th>
         <th rowspan="2">学习纪律20分</th>
         <th rowspan="2">社会实践和劳动态度15分</th>
         
         <th colspan="6">上学期成绩</th>
         <th rowspan="2">上学期平均成绩</th>
         <th colspan="6">下学期成绩</th>
         <th rowspan="2">下学期平均成绩</th>
         <th rowspan="2">学年平均成绩</th>
         <th rowspan="2">成绩提升分</th>
         
         <th rowspan="2">体育课考试平均成绩×85%</th>
         <th rowspan="2">体质健康总分×15%</th>
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
       <s:iterator value="listSyn" var="syn" status="stat">
       <tr class="tr<s:property value="#stat.count%2"/>">
         <td><s:property value="#stat.count"/></td>
         <td><s:property value="#syn.ps.userId"/></td>
         <td><s:property value="#syn.ps.user_name"/></td>
         <td><s:property value="#syn.bs.dys.sum_1"/></td>
         <td><s:property value="#syn.bs.dys.sum_2"/></td>
         <td><s:property value="#syn.bs.dys.sum_3"/></td>
         <td><s:property value="#syn.bs.dys.sum_4"/></td>
         <td><s:property value="#syn.bs.dys.sum_5"/></td>
         <td><s:property value="#syn.bs.dys.sum_6"/></td>
        <td><s:property value="#syn.bs.dys.sum_7"/></td>
         <td><s:property value="#syn.bs.zys.zy.score_1"/></td>
         <td><s:property value="#syn.bs.zys.zy.score_2"/></td>
         <td><s:property value="#syn.bs.zys.zy.score_3"/></td>
         <td><s:property value="#syn.bs.zys.zy.score_4"/></td>
         <td><s:property value="#syn.bs.zys.zy.score_5"/></td>
         <td><s:property value="#syn.bs.zys.zy.score_6"/></td>
         <td><s:property value="#syn.bs.zys.last_term_avg"/></td>
         <td><s:property value="#syn.bs.zys.zy.score_7"/></td>
         <td><s:property value="#syn.bs.zys.zy.score_8"/></td>
         <td><s:property value="#syn.bs.zys.zy.score_9"/></td>
         <td><s:property value="#syn.bs.zys.zy.score_10"/></td>
         <td><s:property value="#syn.bs.zys.zy.score_11"/></td>
         <td><s:property value="#syn.bs.zys.zy.score_12"/></td>
         <td><s:property value="#syn.bs.zys.next_term_avg"/></td>
         <td><s:property value="#syn.bs.zys.school_year_avg"/></td>
         <td><s:property value="#syn.bs.zys.promote_score"/></td>
         <td><s:property value="#syn.bs.zys.total_score"/></td>
         <td><s:property value="#syn.bs.zys.zhiyu_score"/></td>
         <td><s:property value="#syn.bs.tys.tiyuSumScore"/></td>
         <td><s:property value="#syn.bs.tys.tizhiSumScore"/></td>
         <td><s:property value="#syn.bs.tys.tiyuTotal"/></td>
         <td><s:property value="#syn.bs.tys.zhehe_tiyuTotal"/></td>
         <td><s:property value="#syn.bs.totalScore"/></td>
         <td><s:property value="#syn.bs.zh_totalScore"/></td>
         <td><s:property value="#syn.ps.sum_1"/></td>
         <td><s:property value="#syn.ps.sum_2"/></td>
         <td><s:property value="#syn.ps.sum_3"/></td>
         <td><s:property value="#syn.ps.sum_4"/></td>
         <td><s:property value="#syn.ps.sum_5"/></td>
         <td><s:property value="#syn.ps.sum_6"/></td>
         <td><s:property value="#syn.ps.total"/></td>
         <td><s:property value="#syn.ps.zhehe_total"/></td>
         <td><s:property value="#syn.peculiar"/></td>
         <td><s:property value="#syn.totalScore"/></td>
       </tr>
       </s:iterator>
     </table>
  </body>
</html>
