<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>系统登录界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="../js/ajax.js"></script>
	<!-- 为什么此处引入无效？
	<link type="text/css" href="../css/common.css" rel="stylesheet"/>
	 -->
	<style type="text/css">
	    body{
	      font-size: 12px; 
		  font-family: "宋体"; 
		  background-color:#bfe5d5;
		  overflow-x:hidden;
		  overflow-y:hidden;
	    }
	    
	    .login{
	      margin:250px auto;
	      width:370px;
	    }
	    
	    .td1{
	      text-align:right;
	    }
	    
	    .td2{
	      text-align:center;
	    }
	    
	    table{
	      width:400px;
	    }
	    
	    a {
			cursor: pointer;
			text-decoration: none;
			color: #666;
			font-family: "宋体";
			font-size: 12px;
		}
		
		a:link {
			color: #0041D3;
			text-decoration: none
		}
		
		a:visited {
			color: #0041D3;
			text-decoration: none
		}
		
		a:hover {
			color: #ff7000;
			text-decoration: underline
		}
		
		a:active {
			color: #bc2931;
			text-decoration: underline
		}
	</style>
	<script type="text/javascript">
	    function chkCode(v){
	      if(v==""){
	        alert("验证码不能为空");
	      }else{
	       //利用post方式发送请求
	       alert("sdfsd");
			var xhr = getXhr();
			xhr.open('post','numCheck.jsp?dt='+new Date().getTime(),true);
			xhr.setRequestHeader('content-type',
			'application/x-www-form-urlencoded');
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4){
					var txt=xhr.responseText;
					alert(txt);
				}
			};
			xhr.send('num='+v);
		  }
	    }
	
	</script>
  </head>
  <body>
     <div class="login">
       <form action="login.action" method="post" id="f">
        <table>
           <tr>
             <td class="td1">账号：</td>
             <td>
               <input type="text" id="userId" name="user.userId"/>
             </td>
           </tr>
           <tr>
             <td class="td1">密码：</td>
             <td>
               <input type="password" id="password" name="user.password"/>
             </td>
           </tr>
           <tr>
             <td class="td1" >身份：</td>
             <td>
               <select id="user_level" name="user.user_level">
                  <option value="">--选择身份--</option>
                  <!-- 
                  <option value="3">学生</option>
                   -->
                  <option value="2">学习委员</option>
                  <option value="1">班主任</option>
                  <option value="0">管理员</option>
               </select>
             </td>
           </tr>
           <tr>
             <td class="td1">验证码：</td>
             <td style="height:40px;">
               <input type="text" id="checkCode" name="checkCode" size="7" />
               <img id="imgCode" style="width:80px;height:30px;" alt="验证码" src="${pageContext.request.contextPath}/checkCode.action"
                onclick="document.getElementById('imgCode').src='${pageContext.request.contextPath}/checkCode.action?t='+Math.random()"/>
               <a href="javascript:void(0);" 
                     onclick="document.getElementById('imgCode').src='${pageContext.request.contextPath}/checkCode.action?t='+Math.random()"> 看不清，换一张</a>
             </td>
           </tr>
           <tr>
             <td>&nbsp;
               <span id="info" style="color:red;"></span>
             </td>
           </tr>
           <tr>
             <td class="td2" colspan="2">
               <input type="submit" value="登录" />
               &nbsp;&nbsp;&nbsp;&nbsp;
               <input type="reset" value="重置">
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             </td>
           </tr>
        </table>
       </form>
     </div>
  </body>
</html>
