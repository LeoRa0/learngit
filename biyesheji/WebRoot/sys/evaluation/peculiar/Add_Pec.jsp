<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>特殊加分录入页面</title>
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
           width:350px;
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
          if(s1==""||s2==""||s3==""||s4==""||s5==""){
             alert('加分项不能为空，若无加分项，分数应填写为零！');
          }else{
            var frm=$("frm");
            frm.action="addPS.action";
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
           <th width="12%">序号</th>
           <th>项目</th>
           <th>加分</th>
         </tr>
         <tr>
           <td class="td1">1</td>
           <td>获国家、省（自治区）级演讲、音乐、舞蹈、设计三等奖以上加2、3、5分。</td>
           <td>
             <input type="text" id="s1" name="ps.score_1" value="${requestScope.ps['score_1']}" size="3"/>
           </td>
         </tr>
         <tr>
           <td class="td1">2</td>
           <td>国家级刊物发表文章加5分、论文加10分。</td>
           <td>
             <input type="text" id="s2" name="ps.score_2" value="${requestScope.ps['score_2']}" size="3"/>
           </td>
         </tr>
         <tr>
           <td class="td1">3</td>
           <td>社会调查报告获省（自治区）级加3分、国家级加5分。</td>
           <td>
             <input type="text" id="s3" name="ps.score_3" value="${requestScope.ps['score_3']}" size="3"/>
           </td>
         </tr>
         <tr>
           <td class="td1">4</td>
           <td>自然灾害及突发事件中表现突出的加5分。</td>
           <td>
             <input type="text" id="s4" name="ps.score_4" value="${requestScope.ps['score_4']}" size="3"/>
           </td>
         </tr>
         <tr>
           <td class="td1">5</td>
           <td>获国家、省（自治区）级先进集体每个学生加4、3、2分，先进个人加6、5、4分。</td>
           <td>
             <input type="text" id="s5" name="ps.score_5" value="${requestScope.ps['score_5']}" size="3"/>
           </td>
         </tr>
         <tr>
           <td colspan="3" class="td1" style="border-width:0px;padding-top:15px;">
             <input type="hidden" value="${requestScope.ps['userId']}" name="ps.userId">
             <input type="button" value="保存" onclick="chkVal()"/>
             &nbsp;&nbsp;&nbsp;
             <input type="button" value="离开" onclick="window.close();"/>
           </td>
         </tr>
      </table> 
      </form>
  </body>
</html>
