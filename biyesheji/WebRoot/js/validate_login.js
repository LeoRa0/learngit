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
	                  required:"��֤�벻��Ϊ�գ�",
	                  "remote":"��֤���������"
	               }
	             },
	             errorPlacement:function(error,element){
	               error.appendTo(element.next().find("span"));
	             }
	          
	          });
	       });