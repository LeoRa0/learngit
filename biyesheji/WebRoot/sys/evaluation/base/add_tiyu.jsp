<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>体育素质分录入页面</title>
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
           width:550px;
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
          if(s1==""||s2==""||s3==""||s4==""||s5==""||s6==""||s7==""){
             alert('分数项不能为空，若无加分或扣分，分数应填写为零！');
          }else{
            var frm=$("frm");
            frm.action="addMes_tiyu.action";
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
           <th>项目</th>
           <th>内容</th>
           <th>加分</th>
           <th>扣分</th>
         </tr>
         <tr>
           <td class="td1" rowspan="2">体育课成绩</td>
           <td>上学期体育课考试成绩</td>
           <td>
             <input type="text" id="s1" name="ty.score_1" value="${requestScope.ty['score_1']}" size="3"/>
           </td>  
           <td></td>
         </tr>
         <tr>
           <td>上学期体育课考试成绩</td>
           <td>
             <input type="text" id="s2" name="ty.score_2" value="${requestScope.ty['score_2']}" size="3"/>
           </td>  
           <td></td>
         </tr>
         <tr>
           <td class="td1" rowspan="5">体质健康分</td>
           <td>体能达标测试成绩</td>
           <td>
             <input type="text" id="s3" name="ty.score_3" value="${requestScope.ty['score_3']}" size="3"/>
           </td>  
           <td></td>
         </tr>
         <tr>
           <td>坚持课外体育锻炼,提高身体素质，积极参加学院（班级）组织的各类体育活动。加5分</td>
           <td>
             <input type="text" id="s4" name="ty.score_4" value="${requestScope.ty['score_4']}" size="3"/>
           </td>  
           <td></td>
         </tr>
         <tr>
           <td>保持心理健康,能适应紧张的学习生活,按时晨练、出早操。加10分</td>
           <td>
             <input type="text" id="s5" name="ty.score_5" value="${requestScope.ty['score_5']}" size="3"/>
           </td>  
           <td></td>
         </tr>
         <tr>
           <td>不能坚持正常学习，一学年内病假住院累计四周以上扣3分，非住院请病假者超出10学时部分，每3学时扣1分。</td>
           <td></td>
           <td>
             <input type="text" id="s6" name="ty.score_6" value="${requestScope.ty['score_6']}" size="3"/>
           </td>  
         </tr>
         <tr>
           <td>晨练、早操，迟到1次扣1分（迟到3次记一次旷操），旷操1次扣2分。</td>
           <td></td>
           <td>
             <input type="text" id="s7" name="ty.score_7" value="${requestScope.ty['score_7']}" size="3"/>
           </td>  
         </tr>
         <tr>
            <td colspan="3" class="td1" style="border-width:0px;padding-top:15px;">
               <input type="hidden" value="${requestScope.ty['userId']}" name="ty.userId">
               <input type="button" value="保存" onclick="chkVal()"/>
               &nbsp;&nbsp;&nbsp;
               <input type="button" value="离开" onclick="window.close();"/>
            </td>
         </tr>
      </table> 
      </form>
  </body>
</html>
