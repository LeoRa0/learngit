<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" 
import="java.io.*"%>
<%
  //注册页面验证码判断
  response.setContentType("text/json;charset=utf-8");
  PrintWriter pw=response.getWriter();

  String num=request.getParameter("num").toUpperCase();
  String code=(String)session.getAttribute("code");
  System.out.println(num+":"+code);
  if(num!=null&&code!=null){
    if(num.equals(code.toLowerCase())){
      pw.print("true");
    }else{
      pw.print("false");
    }
  }
  pw.close();
%>