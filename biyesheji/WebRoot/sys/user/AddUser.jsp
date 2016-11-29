<%@ page language="java" import="java.util.*" pageEncoding="utf8" contentType="text/html;charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加用户</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="../../css/common.css"/>
	<script type="text/javascript" src="../../js/prototype-1.6.0.3.js"></script>
	<script type="text/javascript" src="../../js/ajax.js"></script>
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
        function ajaxClass(v){
	       //利用get方式发送请求
	       var xhr=getXhr();
	       xhr.open('get','selClasses.action?grade='+v,true);
	       xhr.onreadystatechange=function(){
	          if(xhr.readyState==4){
	             var txt=xhr.responseText;
	             //处理返回的字符串（json格式）
	             var jsonCla=eval(eval(txt));//转化为json对象
	             $("cla").options.length=0;
	             $("cla").options[0]=new Option("----选择班级----","");
	             for(var i=0;i<jsonCla.length;i++){
	                var jc=jsonCla[i];
	                var op=new Option(jc.name,jc.abbr);
	                $("cla").options[i+1]=op;
	             }
	          }
	       };
	       xhr.send(null);
	    }
		
		var parent=window.dialogArguments;
		
		function chkValue(){
		   var frm=document.getElementById("form1");
		   if($F("userId")==""||$F("password")==""||$F("user_level")==""||$F("cla")==""){
		       alert("请填写完整的班级信息！（带*号为必填项）");
		   }else{
			   frm.action="addUser.action";
			   frm.method="post";
			   frm.submit();
			   var data={};//JSON对象
			   var level=$("user_level").value;
			   data["level"]=level;
			   if(level=="3"){
			      data["abbr"]=$F("cla");
			   }else{
			      data["abbr"]="";
			   }
			   window.returnValue=data;
			   setTimeout(window.close(),2000);
		   }
		}
		
		function setPwd(){
		   $("password").value="123456";
		}
    </script>
  </head>
  <body>
     <div class="addClass">
     <form action="" id="form1">
     <table width="435" height="370">
        <tr>
           <td class="td1">*账号：</td>
           <td class="td2">
              <input type="text" id="userId" name="user.userId" size="12"/>
           </td>       
        </tr>
        <tr>
           <td class="td1">*密码：</td>
           <td class="td2">
              <input type="password" id="password" name="user.password" size="12"/>
              <span><a href="javascript:void(0);" onclick="setPwd()">初始密码</a></span>
           </td>
        </tr>
        <tr>
           <td class="td1">姓名：</td>
           <td class="td2">
              <input type="text" name="user.user_name" size="12">
           </td>
        </tr>
        <tr>
           <td class="td1">*用户身份：</td>
           <td class="td2">
              <select name="user.user_level" id="user_level">
                 <option value="">--身份--</option>
                 <option value="1">班主任</option>
                 <option value="2">学习委员</option>
                 <option value="3">学生</option>
              </select>
           </td>       
        </tr>
        <tr>
           <td class="td1">*年级：</td>
           <td class="td2">
              <select name="user.grade" id="s2" onchange="ajaxClass(this.value)">
                 <option value="">--年级--</option>
                 <option value="09">09级</option>
                 <option value="10">10级</option>
                 <option value="11">11级</option>
                 <option value="12">12级</option>
              </select>
           </td>       
        </tr>
        <tr>
           <td class="td1">*班级：</td>
           <td class="td2">
              <select name="user.class_abbr" id="cla">
                  <option value="">----选择班级----</option>
              </select>
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
