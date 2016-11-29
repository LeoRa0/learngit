//全选、全不选、反选
function cc(N,bool){  
		var aa = document.getElementById(N).getElementsByTagName("input");
		for (var i=0; i<aa.length; i++){
			if (aa[i].type=="checkbox")
			aa[i].checked = bool==1 ? true : (bool==0 ? false : !aa[i].checked);
	}  
}

//全选/全不选
function cc2(N){
    var aa = document.getElementById(N).getElementsByTagName("input");
		var m=0;
		var n=0;
		for (var i=0; i<aa.length; i++){
			if (aa[i].type=="checkbox"){
			    m++;
			    if(aa[i].checked==true){
			      n++;
			    }
			}
	}
	if(n<m){
	   for(var i=0; i<aa.length; i++){
	      aa[i].checked=true;
	   }
	}else if(n==m){
	    for(var i=0; i<aa.length; i++){
	      aa[i].checked=false;
	   }
	}  
}
