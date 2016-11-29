<%@ page language="java" import="java.util.*" pageEncoding="utf8" contentType="text/html;charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加班级</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="../js/prototype-1.6.0.3.js"></script>
	<script type="text/javascript" src="../js/ajax.js"></script>
	<style type="text/css">
	   table{
	      width:350px;
	      border-collapse:collapse;
	   }
	   .td1{
	     text-align:right;
	     width:30%;
	     height:50px;
	     border:1px solid #bfe5d5;
	   }
	   .td2{
	     border:1px solid #bfe5d5;
	   }
	   .addClass{
	     width:400px;
	     margin:100px auto;
	   }
	</style>
    <script type="text/javascript">
        function createMajor(v1){
		    if(v1==""){
		      $("s2").options.length=0;
		      $("s2").options[0]=new Option("---选择专业---","");
		      return;
		    }
			//利用post方式发送请求
			var xhr = getXhr();
			xhr.open('post','createMajor.action',true);
			xhr.setRequestHeader('content-type',
			'application/x-www-form-urlencoded');
			xhr.onreadystatechange=function(){
			if(xhr.readyState==4){
					var txt=xhr.responseText;
					//处理返回的字符串
					var majors=txt.evalJSON().evalJSON();//转化为json对象
					$("s2").options.length=0;
					$("s2").options[0]=new Option("---选择专业---","");
					for(i=0;i<majors.length;i++){
						var mj=majors[i];
						var op=new Option(mj.name,mj.id);//op为对象
						$('s2').options[i+1]=op;
					}
				}
			};
			xhr.send('edu_bg='+v1);
		}
		
		var parent=window.dialogArguments;
		
		function chkValue(){
		   var frm=document.getElementById("form1");
		   if($F("grade")==""||$F("s1")==""||$F("class_name")==""||$F("class_abbr")==""){
		       alert("请填写完整的班级信息！");
		   }else{
			   frm.action="addClass.action";
			   frm.method="post";
			   frm.submit();
			   var grade=document.getElementById("grade").value;
			   window.returnValue=grade;
			   setTimeout(window.close(),2000);
		   }
		}
    </script>
  </head>
  <body>
     <div class="addClass">
     <form action="" id="form1">
     <table width="435" height="323">
        <tr>
           <td class="td1">年级：</td>
           <td class="td2">
              <input type="text" id="grade" name="cla.grade" size="5"/>&nbsp;级
           </td>       
        </tr>
        <tr>
           <td class="td1">学历：</td>
           <td class="td2">
              <select name="cla.edu_bg" id="s1" onchange="createMajor(this.value)">
                 <option value="">--学历--</option>
                 <option value="本科">本科</option>
                 <option value="专科">专科</option>
              </select>
           </td>       
        </tr>
        <tr>
           <td class="td1">专业：</td>
           <td class="td2">
              <select name="cla.major_ID" id="s2">
                 <option value="">---选择专业---</option>
              </select>
           </td>       
        </tr>
        <tr>
           <td class="td1">班级：</td>
           <td class="td2">
              <select name="cla.class_name" id="class_name">
                  <option value="">--班级--</option>
                  <option value="一班">一班</option>
                  <option value="二班">二班</option>
                  <option value="三班">三班</option>
                  <option value="四班">四班</option>
                  <option value="五班">五班</option>
              </select>
           </td>
        </tr>
        <tr>
          <td class="td1">班级名缩写：</td>
          <td class="td2">
             <input type="text" name="cla.class_abbr" id="class_abbr"/>
          </td>
        </tr>
        <tr>
           <td>
             &nbsp;
           </td>
           <td>
             <input type="button" value="保存" onclick="chkValue()"/>
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             <input type="button" value="放弃" onclick="window.close()"/>
           </td>
        </tr>
     </table> 
     </form>
    </div>
  </body>
</html>
