<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>智育素质分录入页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/ajax.js"></script>
    <style type="text/css">
      .table1{
           border-collapse:collapse;
           font-size:14px;
           font-family:"宋体";
           width:300px;
           margin:0px auto;
       }
       .table1 tr th{
          background:url(${pageContext.request.contextPath}/images/head.gif);
          border:1px solid #A6A6A6;
          height:25px;
       }
       .table1 tr td{
          border:1px solid #A6A6A6;
          height:25px;
       }
       .td1{
         text-align:center;
       }
    </style>
    <script type="text/javascript">
       function chkVal(){
          var s1=$('s1').value;
          var s2=$('s2').value;
          var s3=$('s3').value;
          var s4=$('s4').value;
          var s5=$('s5').value;
          var s6=$('s6').value;
          var s7=$('s7').value;
          var s8=$('s8').value;
          var s9=$('s9').value;
          var s10=$('s10').value;
          var s11=$('s11').value;
          var s12=$('s12').value;
          if(s1==""||s2==""||s3==""||s4==""||s5==""||s6==""||s7==""||
             s8==""||s9==""||s10==""||s11==""||s12==""){
             alert('分数项不能为空，若无加分或扣分，分数应填写为零！');
          }else{
            var frm=$("frm");
            frm.action="addMes_zhiyu.action";
            frm.method="post";
            frm.submit();
            window.returnValue=true; 
            window.close();
          }
       
       }
    </script>
  </head>
  <body>
     <form action="" id="frm">
      <table class="table1" cellpadding="5px">
         <tr>
           <th>学期</th>
           <th>课程</th>
           <th>分数</th>
         </tr>
         <tr>
           <td class="td1" rowspan="6">上学期课程</td>
           <td>大学英语（1）</td>
           <td>
             <input type="text" id="s1" name="zy.score_1" value="${requestScope.zy['score_1']}" size="3"/>
           </td>  
         </tr>
         <tr>
           <td>高等数学（1）</td>
           <td>
             <input type="text" id="s2" name="zy.score_2" value="${requestScope.zy['score_2']}" size="3"/>
           </td>  
         </tr>
         <tr>
           <td>马克思主义与四观教育</td>
           <td>
             <input type="text" id="s3" name="zy.score_3" value="${requestScope.zy['score_3']}" size="3"/>
           </td>  
         </tr>
         <tr>
           <td>中国近现代史纲要</td>
           <td>
             <input type="text" id="s4" name="zy.score_4" value="${requestScope.zy['score_4']}" size="3"/>
           </td>  
         </tr>
         <tr>
           <td>计算机应用基础</td>
           <td>
             <input type="text" id="s5" name="zy.score_5" value="${requestScope.zy['score_5']}" size="3"/>
           </td>  
         </tr>
         <tr>
           <td>C语言程序设计</td>
           <td>
             <input type="text" id="s6" name="zy.score_6" value="${requestScope.zy['score_6']}" size="3"/>
           </td>  
         </tr>
         <tr>
           <td class="td1" rowspan="6">下学期课程</td>
           <td>大学英语（2）</td>
           <td>
             <input type="text" id="s7" name="zy.score_7" value="${requestScope.zy['score_7']}" size="3"/>
           </td>  
         </tr>
         <tr>
           <td>高等数学（2）</td>
           <td>
             <input type="text" id="s8" name="zy.score_8" value="${requestScope.zy['score_8']}" size="3"/>
           </td>  
         </tr>
         <tr>
           <td>思想道德修养与法律基础</td>
           <td>
             <input type="text" id="s9" name="zy.score_9" value="${requestScope.zy['score_9']}" size="3"/>
           </td>  
         </tr>
         <tr>
           <td>马克思主意基本原理</td>
           <td>
             <input type="text" id="s10" name="zy.score_10" value="${requestScope.zy['score_10']}" size="3"/>
           </td>  
         </tr>
         <tr>
           <td>数据库原理与应用</td>
           <td>
             <input type="text" id="s11" name="zy.score_11" value="${requestScope.zy['score_11']}" size="3"/>
           </td>  
         </tr>
         <tr>
           <td>大学物理</td>
           <td>
             <input type="text" id="s12" name="zy.score_12" value="${requestScope.zy['score_12']}" size="3"/>
           </td>  
         </tr>
         <tr>
            <td colspan="3" class="td1" style="border-width:0px;padding-top:15px;">
               <input type="hidden" value="${requestScope.zy['userId']}" name="zy.userId">
               <input type="button" value="保存" onclick="chkVal()"/>
               &nbsp;&nbsp;&nbsp;
               <input type="button" value="离开" onclick="window.close();"/>
            </td>
         </tr>
      </table> 
      </form>
  </body>
</html>
