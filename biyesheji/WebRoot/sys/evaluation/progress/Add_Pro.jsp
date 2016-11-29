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
           width:750px;
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
          if(s1==""||s2==""||s3==""||s4==""||s5==""||s6==""||s7==""||s8==""||s9==""||s10==""){
             alert('加分项不能为空，若无加分项，分数应填写为零！');
          }else{
            var frm=$("frm");
            frm.action="addPro.action";
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
         </tr>
         <tr>
           <td class="td1">思想政治与道德修养10分</td>
           <td>学校、学院、班级各类荣誉称号者分别得获加8、6、4分。</td>
           <td>
             <input type="text" id="s1" name="pro.score_1" value="${requestScope.pro['score_1']}" size="3"/>
           </td>
         </tr>
         <tr>
           <td class="td1" rowspan="3">创新创造能力25分</td>
           <td>积极参加科技学术活动，公开报刊发表学术文章加15分，在校内刊物上发表文章加3分。</td>
           <td>
             <input type="text" id="s2" name="pro.score_2" value="${requestScope.pro['score_2']}" size="3"/>
           </td>
         </tr>
         <tr>
           <td>科技制作及竞赛获校级、院级奖，分别加8、6分。</td>
           <td>
             <input type="text" id="s3" name="pro.score_3" value="${requestScope.pro['score_3']}" size="3"/>
           </td>
         </tr>
         <tr>
           <td>在完成本专业学业同时辅修其他专业，并取得辅修专业证书加5分。</td>
           <td>
             <input type="text" id="s4" name="pro.score_4" value="${requestScope.pro['score_4']}" size="3"/>
           </td>  
         </tr>
         <tr>
           <td class="td1">组织管理能力20分</td>
           <td>学生干部不论职务高低，以履行职责，为学生服务为准则，均参加学年考核并确定等级担任社会工作满－学期以上，工作认真负责的部，依据工作成绩及考核等级加3-20分。</td>
           <td>
             <input type="text" id="s5" name="pro.score_5" value="${requestScope.pro['score_5']}" size="3"/>
           </td>
         </tr>
         <tr>
           <td class="td1">社会实践与自愿者服务15分</td>
           <td>获学校、学院、班级社会实践、志愿服务先进称号分别加8、6、4分。</td>
           <td>
             <input type="text" id="s6" name="pro.score_6" value="${requestScope.pro['score_6']}" size="3"/>
           </td>
         </tr>
         <tr>
           <td class="td1" rowspan="2">文体特长15分</td>
           <td>积极参与各种文体活动，按每项活动加2分。（累计最多加8分）。</td>
           <td>
             <input type="text" id="s7" name="pro.score_7" value="${requestScope.pro['score_7']}" size="3"/>
           </td>
         </tr>
         <tr>
           <td>参加学校、学院文体活动获奖励或表彰者，分别加6、4分。</td>
           <td>
             <input type="text" id="s8" name="pro.score_8" value="${requestScope.pro['score_8']}" size="3"/>
           </td>  
         </tr>
         <tr>
           <td class="td1" rowspan="2">操作技能15分</td>
           <td>通过国家英语考试六、四级者，加10、8分。通过计算机考试一、二、三级者，加3、6、8分。</td>
           <td>
             <input type="text" id="s9" name="pro.score_9" value="${requestScope.pro['score_9']}" size="3"/>
           </td>
         </tr>
         <tr>
           <td>普通话测试达标加4分，获得职业技能（国际认证或劳动部认证）初级、中级、高级岗位资格证书者分别加4、6、10分。</td>
           <td>
             <input type="text" id="s10" name="pro.score_10" value="${requestScope.pro['score_10']}" size="3"/>
           </td>  
         </tr>
         <tr>
            <td colspan="3" class="td1" style="border-width:0px;padding-top:15px;">
               <input type="hidden" value="${requestScope.pro['userId']}" name="pro.userId">
               <input type="button" value="保存" onclick="chkVal()"/>
               &nbsp;&nbsp;&nbsp;
               <input type="button" value="离开" onclick="window.close();"/>
            </td>
         </tr>
      </table> 
      </form>
  </body>
</html>
