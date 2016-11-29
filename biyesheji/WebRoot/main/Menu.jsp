<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
	<head>
		<title>menu</title>
		<link href="../css/styles_menu.css" rel="stylesheet" type="text/css" />
	 	<script type="text/javascript" src="../js/global.js"></script>
	    <style type="text/css">
	       body{
	         margin:0px;
	       }
	       #divTheMenu{
	         position:absolute;
	         top:0px;
	         left:0px;
	         bottom:0px;
	         width:185px;
	         height:100%;
	         background-color:#bfe5d5;
	       }
	       font{
	          font-family:"宋体";
	       }
	      #divTheMain{
	         position:absolute;
	         top:0px;
	         left:185px;
	         bottom:0px;
	         right:0px;
	         height:100%;
	       }
	    </style>
	</head>
	<body>
       <form action="" id="Form1" name="Form1" method="post">
          <input type="hidden" name="__VIEWSTATE" value="" />
          <script type="text/javascript">
             <!--
            var user_level='${user.user_level}';
             
            var RGB_Atvbord='1px solid #f4fffb';
			var RGB_Atvfont='#015436';
			var RGB_Atvbgrd='#89bfa7';
			var RGB_FontHover='#333333';
			var RGB_Chkbord='0px solid #f4fffb';
			var RGB_Chkfont='#318262';
			var RGB_Chkbgrd='#89bfa7';
			var barActiveStyle=" valign=bottom style='height:20px; cursor:pointer;     background-color:"+RGB_Atvbgrd+";color:"+RGB_Atvfont+"; border:"+RGB_Atvbord+"' "; 
			var barCheckStyle =" valign=bottom style='height:20px; cursor:pointer; background-color:"+RGB_Chkbgrd+";color:"+RGB_Chkfont+"; border:"+RGB_Chkbord+"' "; 
			var tableStyle=" style='height:100%;width:100%' border=0 valign=middle align=center cellspacing='0' cellpadding='0' ";

            function KingoMenu(){
				this.barArray=new Array();
				this.addBar=addBar;
				this.curBarIndex=-1;
				this.lastLinkObj='';
				this.lastLayerID='';
				this.showBar=showBar;
			}

			var KingoMenuBar=new KingoMenu();

			function addBar(pText,pID){
				KingoMenuBar.barArray[KingoMenuBar.barArray.length]=new textArray(pText,pID);
			}

			function textArray(pText,pID){
				this.id=pID;
				this.text=pText;
			}

			function openTheBar(pIndex){
			  if(pIndex==0){  
				 window.frames['frmMain'].location.replace("./XSXJ/KingosLove.htm");
			  }else if(pIndex==6){
			     window.frames['frmMain'].location.replace("../sys/evaluation/detail_Score.jsp");
			  }else if(pIndex==5){
			     window.frames['frmMain'].location.replace("../sys/evaluation/Syn_Score.jsp");
			  }else if(pIndex==4){
			     window.frames['frmMain'].location.replace("../sys/evaluation/peculiar/Peculiar.jsp");
			  }else if(pIndex==3){
			     window.frames['frmMain'].location.replace("../sys/evaluation/progress/Progress.jsp");
			  }else{	
			     var whichEl; 
				 var lastIndex;
				 lastIndex = KingoMenuBar.curBarIndex;
				 if ((pIndex!=lastIndex)&&(pIndex<KingoMenuBar.barArray.length)){
					KingoMenuBar.curBarIndex=pIndex;	
					document.getElementById("blankdiv").style.display='none';
					if(lastIndex!=-1) 
					    doBar('close',lastIndex);	
					doBar('open',pIndex);
					hideTheMenu('T');
				 }
			   }
			}

			function doBar(pDo,pIndex){
			    try{
					var theObj=document.getElementById("memuBarText"+pIndex);
					if(pDo=='close'){
						document.getElementById("memuLinkDiv"+pIndex).style.display='none';
						document.getElementById("memuLinkDiv"+pIndex).style.height="100%";
						theObj.style.cursor='pointer';
						theObj.style.border=RGB_Atvbord;
						theObj.style.background=RGB_Atvbgrd;
						theObj.style.color=RGB_Atvfont;
					}else if(pDo=='open'){
						document.getElementById("memuLinkDiv"+pIndex).style.display='';
						document.getElementById("memuLinkDiv"+pIndex).style.height="100%";
						theObj.style.cursor='';
						theObj.style.border=RGB_Chkbord;
						theObj.style.background=RGB_Chkbgrd;
						theObj.style.color=RGB_Chkfont;
					}
			    }catch(e){}
			}

			function openTheMenu(pIndex,pLayerID){
				try{
					openTheBar(pIndex);
					if (pLayerID!=''){
					var objDiv=eval("divGrp"+pLayerID);
					var objImg=eval("imgGrp"+pLayerID);
					if(typeof(objDiv)=='object')
					objDiv.style.display='';
					objImg.src='../images/tree/-1.gif';
					KingoMenuBar.lastLayerID=pLayerID;	
					}
				}catch(e){}
			}

			function hideTheMenu(pTF){
				try{
					var objBar,objLnk;
					var vID=KingoMenuBar.curBarIndex;
					for(i=0;i<KingoMenuBar.barArray.length;i++){
						objBar = document.getElementById('memuBarBtn'+i);
						objLnk = document.getElementById('memuLnkBtn'+i);
						if(i!=vID){
							if(objBar.style.display==''){
								objBar.style.display='none';
								objLnk.style.display='none';
							}else{
								objBar.style.display='';
								objLnk.style.display='';
							}
						}else if(pTF=='F'){	 
							doBar('close',vID);
							document.getElementById("blankdiv").style.display='';
							KingoMenuBar.curBarIndex=-1;
						}else{
							parent.frames['menu'].onhide2_Ex('down');
						}
					}
					return true;
				}catch(e){return false}}

			function addLinkGroup(pID,pGrpName,pDis,pLists){
				var s,pL,vN,vU,vT;
				var pAry=pLists.split('|');
				var vLen=pAry.length;
				s ="<tr height=20px style='cursor:pointer' onclick=showLay('"+pID+"')>";
				s+="<td valign=middle width=20px><img id='imgGrp"+pID+"' border=0 width=20px "; 
				s+=(pDis=='none')?" src='../images/tree/add.gif'></td>":" src='../images/tree/-1.gif'></td>";
				s+="<td valign=middle width=154px align=left></b>"+pGrpName+"</b><br></td></tr>";
				s+="<tr height=20px id='divGrp"+pID+"' style='display:"+pDis+";'>";
				s+="<td colspan=2><table align=left border=0 style='width:174px' CELLPADDING=0 CELLSPACING=0>";
				for(i=0;i<vLen;i++){
					pL=pAry[i];
					vN=pL.split(';')[0]; 
					vU=pL.split(';')[1]; 
					vT=pL.split(';')[2];	
					if((vN.length>12)&&(i>0)) 
						s+="<tr height=2px><td colspan=2 height=2px></td></tr>";
					s+="<tr height=20px><td valign=middle width=20px><img border=0 height=20px width=20px";
					s+=(i+1==vLen)?" src='../images/tree/t1.gif'></td>":" src='../images/tree/t0.gif'></td>";
					s+="<td valign=middle width=154px align=left style='color:black' value='"+vU+"' title='"+vT+"' onclick=ToLink(this) onmouseover=MouseOver(this) onmouseout=MouseOut(this)>"+vN+"</td></tr>";
					if((vN.length>12)&&(i+1!=vLen)) 
						s+="<tr height=4px><td colspan=2 height=4px></td></tr>";
				}
				s+="</table></td></tr>";
				return s;
			}

			function addLinkBlock(pAry){
				var s,vN,vU,vT;
				vN=pAry.split(';')[0]; 
				vU=pAry.split(';')[1]; 
				vT=pAry.split(';')[2];
				s ="<tr height=20px><td valign=middle><img src='../images/tree/tree0.gif' border=0px width=20px>";
				s+="<td valign=middle width=154px align=left><span value='"+vU+"' title='"+vT+"' style='color:black' onclick=ToLink(this) onmouseover=MouseOver(this) onmouseout=MouseOut(this)>"+vN+"</span><br></td>";
				s+="</tr>";
				if(vN.length>12){
					s ="<tr height=2px><td colspan=2 height=2px></td></tr>"+s;
					s+="<tr height=2px><td colspan=2 height=2px></td></tr>";
				}
				return s;
			}

			function addTempDiv(pID,pStr){
				var s;
				var vStr=pStr;
				s ="<tr><td></td><td id='divTemp"+pID+"' width=174px>"+vStr+"</td></tr>";
				return s;
			}

			var RGB_NONE='#cccccc';
			var RGB_LINK='black';
			var RGB_OVER='#3eb268';
			var RGB_CHECK='red';
			function MouseOver(arg){
				arg.style.cursor='pointer';
				arg.style.color=RGB_OVER;
			}

			function MouseOut(arg){
				arg.style.color=RGB_LINK;
			}

			function showLay(divId){
				var objDiv = document.getElementById('divGrp'+divId);
				var objImg = document.getElementById('imgGrp'+divId);
				var whichEl=KingoMenuBar.lastLayerID;
				var vTREE_Multi=parent.frames['banner'].js_SysTREE_Multi;
				if(vTREE_Multi!=true){
					if(whichEl!='')
						if(whichEl!=divId){
							document.getElementById('divGrp'+whichEl).style.display='none';
							document.getElementById('imgGrp'+whichEl).src='../images/tree/add.gif';
						}
				}
				if(objDiv.style.display=='none'){
					objImg.src='../images/tree/-1.gif';
					objDiv.style.display='';
				}else{ 
					objImg.src='../images/tree/add.gif';
					objDiv.style.display='none';
				}
				KingoMenuBar.lastLayerID=divId;
			}

			function ToLink(theObj){		
				var whichEl,vTitle;
				whichEl = KingoMenuBar.lastLinkObj;
				if(whichEl!=''){
					if(whichEl.style.color==RGB_CHECK) 
						whichEl.style.color=RGB_LINK;
				}
				theObj.style.color =RGB_CHECK;
				KingoMenuBar.lastLinkObj=theObj;
				if(theObj.value!=''){
					vTitle =parent.frames['banner'].js_ServerTheCustomer;	
					vTitle+='信息工程学院网站 ['+KingoMenuBar.barArray[KingoMenuBar.curBarIndex].text;
					vTitle+='--'+theObj.innerHTML+']';
					
					window.frames['frmMain'].location=theObj.getAttribute('value');
					if(vTitle.indexOf('&nbsp;')>-1) 
						vTitle=clearBlank(vTitle,'&nbsp;');
					if(vTitle.indexOf('<br>')>-1) 
						vTitle=clearBlank(vTitle,'<br>');
					parent.document.title=vTitle;
					parent.frames['banner'].bgwav.src=parent.frames['banner'].bgwav.src;
				}else{
					alert('不能点击空链接!');
				}
			}

			function clearBlank(str,rStr){
				try{
					 if(str.indexOf(rStr)==-1){
						 return str;	
					 }else{
						 str=str.replace(rStr,'');
						 return clearBlank(str,rStr);	
					 }
				}catch(err){ 
				   return str;
				}
			}
			
			function showBar(){
				var sHTML="<table "+tableStyle+">"; 
				for (i=0;i<(KingoMenuBar.barArray.length);i++)	{
					sHTML+="<tr id=memuBarBtn"+i+" name=memuBarBtn"+i+" >";
					sHTML+="<td id=memuBarText"+i+" name=memuBarText"+i+" align=center "+barActiveStyle;
					sHTML+=" onmouseover='this.style.color=RGB_FontHover'  onmouseout='this.style.color=RGB_Atvfont' onclick='openTheBar("+i+")' key='"+KingoMenuBar.barArray[i].id+"' >";
					sHTML+="<b>"+KingoMenuBar.barArray[i].text+"</b></td></tr>";
					sHTML+="<tr id=memuLnkBtn"+i+" name=memuLnkBtn"+i+" >";
					sHTML+="<td id=memuLinkDiv"+i+" name=memuLinkDiv"+i+" valign=top align=center style='position:relative;width:100%;";
					sHTML+=(i!=KingoMenuBar.curBarIndex)?"display:none'>":"'><br></td></tr>"
				}
				sHTML+="<tr><td id=blankdiv name=blankdiv valign=top align=center style='height:100%;width:100%'";
				sHTML+=(i!=KingoMenuBar.curBarIndex)?"display:none'>":"'>";
				sHTML+="<br></td></tr>";
				sHTML+="</table>";
				document.getElementById('divTheMenu').innerHTML=sHTML;
			}
			
			 function ShowMenuTree(){
					var sTree,sKey;
					var i,barLen=KingoMenuBar.barArray.length;
					for(i=0;i<barLen;i++){
						sTree=''; 
						sKey=KingoMenuBar.barArray[i].id;
						eval("sTree=showMenu_"+sKey+"()");
						sTree="<table style='width:174px' border=0 align=left CELLPADDING=0 CELLSPACING=0>"+sTree+"</table>";
						sTree="<div style='position:absolute;top:20px;left:0px;bottom:0px;overflow:auto;width:100%;'>"+sTree+"</div>";
						eval("document.getElementById('memuLinkDiv"+i+"').innerHTML=sTree");
					}
			}
             
			
			function showMenu_D00(){
			  var sTree='';
			  sTree+=addLinkBlock('评分细则;./XSXJ/KingosLove.htm');
			  return(sTree)
			}
			
			function showMenu_D01(){
				var sTree='';
				//sTree+=addLinkBlock('个人信息;../sys/user/personMessage.jsp;');
				if(user_level=='0'){
				   sTree+=addLinkBlock('班级信息;../sys/ClassMes.jsp');
				}
				sTree+=addLinkBlock('用户信息;../sys/user/UserMes.jsp;');
				//sTree+=addLinkBlock("修改密码;../sys/MyWeb/User_ModPWD.jsp;");
				return(sTree);
			}
			
			
			function showMenu_D02(){
				var sTree='';
				//sTree+=addLinkBlock('学年必修课程;../sys/evaluation/base/course.jsp;');
				var linkGroup='';
				if(user_level!='2'){
				    linkGroup+='德育测评;../sys/evaluation/base/redirect_deyu.action;|';
				}
				linkGroup+='智育测评;../sys/evaluation/base/redirect_zhiyu.action;'
						  +'|体育测评;../sys/evaluation/base/redirect_tiyu.action;'
						  +'|基础素质总分;../sys/evaluation/base/redirect_totalScore.action;'
				sTree+=addLinkGroup('D0202','基础素质测评','none',
						 linkGroup);
				return(sTree);
			}
			
			function showMenu_D03(){
				var sTree='';
				sTree+=addLinkBlock('查看发展性素质分;../sys/evaluation/progress/check_Pro.jsp;');
				sTree+=addLinkBlock('录入发展性素质分;../sys/evaluation/progress/add_Pro.jsp;');
				return(sTree);
			}
			
			function showMenu_D04(){
				var sTree='';
				sTree+=addLinkBlock('查看特殊加分;../sys/evaluation/peculiar/check_Pec.jsp;');
				sTree+=addLinkBlock('录入特殊加分;../sys/evaluation/peculiar/add_Pec.jsp;');
				return(sTree);
			}
			
			function showMenu_D05(){
				var sTree='';
				sTree+=addLinkBlock('查看综合分数;../sys/evaluation/Syn_Score.jsp;');
				return(sTree);
			}
			
			function showMenu_D06(){
				var sTree='';
				sTree+=addLinkBlock('查看分数详表;../sys/evaluation/detail_Score.jsp;');
				return(sTree);
			}
			
			function showMenu_WEB(){
				var sTree='';
				sTree+=addLinkBlock("修改个人密码;../sys/MyWeb/User_ModPWD.jsp;");
				//sTree+=addLinkBlock("查看个人登录日志;../sys/MyWeb/M_Log.jsp;");
				return(sTree);
			}
			
			KingoMenuBar.addBar('评分细则','D00');
            KingoMenuBar.addBar('信息管理','D01');
			KingoMenuBar.addBar('基础素质','D02');
			KingoMenuBar.addBar('发展素质','D03');
			KingoMenuBar.addBar('特殊加分','D04');
			KingoMenuBar.addBar('综合分数','D05');
			KingoMenuBar.addBar('分数详表','D06');
			//KingoMenuBar.addBar('其&nbsp;&nbsp;&nbsp;&nbsp;它','WEB');
			
			window.setTimeout('KingoMenuBar.showBar()',50);
			window.setTimeout('ShowMenuTree()',500);
             
             
             
            parent.frames['banner'].js_UserID='${user.userId}';
			parent.frames['banner'].js_UserName='${user.user_name}';
			parent.frames['banner'].js_UserRight='${user.user_identity}';
			parent.frames['banner'].js_UserLVID=user_level;
			parent.frames['banner'].js_UserGroup='${user.user_identity}';
			parent.frames['banner'].js_UserDepart='_';
			parent.frames['banner'].js_UserLogTime='${user.loginTime}';

			try{
			   parent.frames['frmFoot'].document.getElementById('TheFootMemo').innerHTML=
			                        '&nbsp;&nbsp;&nbsp;${user.user_identity}：[${user.userId}]${user.user_name}';
			}catch(e){}
             //-->
          </script>
          <div id="divTheMenu" >
             <font style="font-family:'宋体'"></font>
	       </div>
          <div id="divTheMain">
             <iframe id="frmMain" name="frmMain" src="./XSXJ/KingosLove.htm" 
             frameborder="0" scrolling="no" height="100%" width="100%"></iframe>
          </div>
       </form>
    </body>
</html>