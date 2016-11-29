<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>德育素质分录入页面</title>
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
           width:800px;
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
          var s1=$('s1').value;var s14=$('s14').value;
          var s2=$('s2').value;var s15=$('s15').value;
          var s3=$('s3').value;var s16=$('s16').value;
          var s4=$('s4').value;var s17=$('s17').value;
          var s5=$('s5').value;var s18=$('s18').value;
          var s6=$('s6').value;var s19=$('s19').value;
          var s7=$('s7').value;var s20=$('s20').value;
          var s8=$('s8').value;var s21=$('s21').value;
          var s9=$('s9').value;var s22=$('s22').value;
          var s10=$('s10').value;var s23=$('s23').value;
          var s11=$('s11').value;var s24=$('s24').value;
          var s12=$('s12').value;var s25=$('s25').value;
          var s13=$('s13').value;var s26=$('s26').value;
          if(s1==""||s2==""||s3==""||s4==""||s5==""||s6==""||s7==""||
             s8==""||s9==""||s10==""||s11==""||s12==""||s13==""||s14==""||
             s15==""||s16==""||s17==""||s18==""||s19==""||s20==""||s21==""||
             s22==""||s23==""||s24==""||s25==""||s26==""){
             alert('分数项不能为空，若无加分或扣分，分数应填写为零！');
          }else{
            var frm=$("frm");
            frm.action="addMes_deyu.action";
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
           <td class="td1" rowspan="4">政治思想素质20分</td>
           <td>热爱祖国,维护国家利益和民族团结.坚持四项基本原则,树立正确的世界观、人生观、祖国观、民族观、成为有理想、有道德、有文化、有纪律的社会主义新人。  加10分</td>
           <td>
             <input type="text" id="s1" name="dy.score_1" value="${requestScope.dy['score_1']}" size="3"/>
           </td>  
           <td></td>
         </tr>
         <tr>
           <td>了解国情，关心国家大事，努力学习马列主义毛泽东思想、邓小平理论和“三个代表”理论。    加10分</td>
           <td>
             <input type="text" id="s2" name="dy.score_2" value="${requestScope.dy['score_2']}" size="3"/>
           </td>  
           <td></td>
         </tr>
         <tr>
           <td>从事或参与非法传销和宗教活动者扣20分。</td>
           <td></td>
           <td>
             <input type="text" id="s3" name="dy.score_3" value="${requestScope.dy['score_3']}" size="3"/>
           </td>  
         </tr>
         <tr>
           <td>学院（班级）组织的政治理论和形势政策学习，每缺席一次扣3分。</td>
           <td></td>
           <td>
             <input type="text" id="s4" name="dy.score_4" value="${requestScope.dy['score_4']}" size="3"/>
           </td>  
         </tr>
         <tr>
           <td class="td1" rowspan="5">道德素质15分</td>
           <td>弘扬传统美德,遵守社会公德.男女交往文明.尊敬师长,友爱同学.关心集体,积极向上，自觉抵制不良诱惑。   加5分</td>
           <td>
             <input type="text" id="s5" name="dy.score_5" value="${requestScope.dy['score_5']}" size="3"/>
           </td>  
           <td></td>
         </tr>
         <tr>
           <td>爱护公物,热心公益,爱护环境,珍惜资源.勇于同不良行为作斗争。   加5分</td>
           <td>
             <input type="text" id="s6" name="dy.score_6" value="${requestScope.dy['score_6']}" size="3"/>
           </td>  
           <td></td>
         </tr>
         <tr>
           <td>诚实守信,按时交纳学费和其他费用。  加5分</td>
           <td>
             <input type="text" id="s7" name="dy.score_7" value="${requestScope.dy['score_7']}" size="3"/>
           </td>  
           <td></td>
         </tr>
         <tr>
           <td>宿舍卫生差，受通报批评，每次每人扣2分（舍长扣3分）。</td>
           <td></td>
           <td>
             <input type="text" id="s8" name="dy.score_8" value="${requestScope.dy['score_8']}" size="3"/>
           </td>  
         </tr>
         <tr>
           <td>无故拖欠或不交纳学费者扣10分。</td>
           <td></td>
           <td>
             <input type="text" id="s9" name="dy.score_9" value="${requestScope.dy['score_9']}" size="3"/>
           </td>  
         </tr>
         <tr>
           <td class="td1" rowspan="8">遵纪守法30分</td>
           <td>遵守宪法、法律法规，遵守校记校规，增强社会责任感，依法履行义务。    加5分</td>
           <td>
             <input type="text" id="s10" name="dy.score_10" value="${requestScope.dy['score_10']}" size="3"/>
           </td>  
           <td></td>
         </tr>
         <tr>
           <td>遵守宿舍管理规定，按时就寝，不影响他人的正常学习和休息、不留宿校外人员。 加10分</td>
           <td>
             <input type="text" id="s11" name="dy.score_11" value="${requestScope.dy['score_11']}" size="3"/>
           </td>  
           <td></td>
         </tr>
         <tr>
           <td>遵守校园管理制度，不打架斗殴、不赌博、不酗酒，不在禁烟区吸烟。    加10分</td>
           <td>
             <input type="text" id="s12" name="dy.score_12" value="${requestScope.dy['score_12']}" size="3"/>
           </td>  
           <td></td>
         </tr>
         <tr>
           <td>遵守公寓管理规定，自觉讲文明、讲卫生、团结互助和热爱集体，评为文明宿舍，每人加3分（舍长加5）</td>
           <td>
             <input type="text" id="s13" name="dy.score_13" value="${requestScope.dy['score_13']}" size="3"/>
           </td>  
           <td></td>
         </tr>
         <tr>
           <td>违反宿舍管理规定，留宿他人、夜不归宿，经查实者每次扣5分。</td>
           <td></td>
           <td>
             <input type="text" id="s14" name="dy.score_14" value="${requestScope.dy['score_14']}" size="3"/>
           </td>  
         </tr>
         <tr>
           <td>私自在校外租房居住，经查实者扣10分。</td>
           <td></td>
           <td>
             <input type="text" id="s15" name="dy.score_15" value="${requestScope.dy['score_15']}" size="3"/>
           </td>  
         </tr>
         <tr>
           <td>违反校记校规，受到纪律处分者按不同级别警告、严重警告、记过、留校察看分别扣10-30分，受学院通报批评者每次扣5分。</td>
           <td></td>
           <td>
             <input type="text" id="s16" name="dy.score_16" value="${requestScope.dy['score_16']}" size="3"/>
           </td>  
         </tr>
         <tr>
           <td>寒暑假、“五一”、“十一”假期结束后，不按时返校者扣3分。</td>
           <td></td>
           <td>
             <input type="text" id="s17" name="dy.score_17" value="${requestScope.dy['score_17']}" size="3"/>
           </td>  
         </tr>
         <tr>
           <td class="td1" rowspan="4">学习纪律20分</td>
           <td>自觉维护教学秩序，遵守学习纪律，遵从学术规范，珍惜时间，学业有成。   加10分</td>
           <td>
             <input type="text" id="s18" name="dy.score_18" value="${requestScope.dy['score_18']}" size="3"/>
           </td>  
           <td></td>
         </tr>
         <tr>
           <td>本学年全勤者（无迟到、早退、病事假）。     加10分</td>
           <td>
             <input type="text" id="s19" name="dy.score_19" value="${requestScope.dy['score_19']}" size="3"/>
           </td>  
           <td></td>
         </tr>
         <tr>
           <td>违反学习纪律，旷课1学时扣2分（迟到、早退3次计旷课1学时），请事假每3学时扣1分。</td>
           <td></td>
           <td>
             <input type="text" id="s20" name="dy.score_20" value="${requestScope.dy['score_20']}" size="3"/>
           </td>  
         </tr>
         <tr>
            <td>违反考试纪律扣5分，另学年中有不及格课程1门扣1分。</td>
            <td></td>
           <td>
             <input type="text" id="s21" name="dy.score_21" value="${requestScope.dy['score_21']}" size="3"/>
           </td>  
         </tr>
         <tr>
           <td class="td1" rowspan="5">社会实践和劳动态度15分</td>
           <td>积极参加公益劳动，珍惜他人和社会劳动成果。    加5分</td>
           <td>
             <input type="text" id="s22" name="dy.score_22" value="${requestScope.dy['score_22']}" size="3"/>
           </td>  
           <td></td>
         </tr>
         <tr>
           <td>积极主动参加寒暑假期间的社会实践活动，并写出社会实践活动报告。    加5分</td>
           <td>
             <input type="text" id="s23" name="dy.score_23" value="${requestScope.dy['score_23']}" size="3"/>
           </td>  
           <td></td>
         </tr>
         <tr>
           <td>在校期间积极承担社会工作，协助老师搞好教学、科研及管理工作。   加5分</td>
           <td>
             <input type="text" id="s24" name="dy.score_24" value="${requestScope.dy['score_24']}" size="3"/>
           </td>  
           <td></td>
         </tr>
         <tr>
           <td>学院（班级）组织的各类集体性公益劳动，每缺一次扣2分。</td>
           <td></td>
           <td>
             <input type="text" id="s25" name="dy.score_25" value="${requestScope.dy['score_25']}" size="3"/>
           </td>  
         </tr>
         <tr>
           <td>无故不参加学校（学院）组织的假期社会实践活动或班级组织的各类活动每缺一次扣5分。</td>
           <td></td>
           <td>
             <input type="text" id="s26" name="dy.score_26" value="${requestScope.dy['score_26']}" size="3"/>
           </td>  
         </tr>
         <tr>
            <td colspan="3" class="td1" style="border-width:0px;padding-top:15px;">
               <input type="hidden" value="${requestScope.dy['userId']}" name="dy.userId">
               <input type="button" value="保存" onclick="chkVal()"/>
               &nbsp;&nbsp;&nbsp;
               <input type="button" value="离开" onclick="window.close();"/>
            </td>
         </tr>
      </table> 
      </form>
  </body>
</html>
