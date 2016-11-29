 $(function(){
	          $("#f").validate({
	             rules:{
	        	  checkCode:{
	                 required:true,
	                 remote:{
	                   url:"numCheck.jsp?dt="+new Date().getTime(),
	                   type:"post",
	                   dataType:"json",
	                   data:{
	        	         checkCode:function(){
	                       return $("#checkCode").val();
	                     }
	                   }
	                 }
	               }
	             },
	             messages:{
	            	checkCode:{
	                  required:"验证码不能为空！",
	                  "remote":"验证码输入错误！"
	               }
	             },
	             errorPlacement:function(error,element){
	               error.appendTo(element.next().find("span"));
	             }
	          
	          });
	       });