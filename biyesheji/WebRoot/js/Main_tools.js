var ie6;
var ie = new Array();
ie[0] = "MSIE 7";
ie[1] = "MSIE 6";
for ( var i = 0; i < ie.length;i++) {
	ie6 = window.navigator.userAgent.indexOf(ie[i]);
	if (ie6 > 0) {
		break;
	}
}

function openWinX(url, name, w, h) {
	var pop = window.open(url,name,"width="+ w + ",height="+ h + ",toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
	pop.moveTo((window.screen.width - w) / 2, (window.screen.height - h) / 2);
}

function openWinHome(url, name, w, h) {
	var pop;
	if (window.screen.height > 600) {
		w += 100;
		h += 30;
		pop = window.open(url,name,"width="+ w+ ",height="+ h+ ",toolbar=no,menubar=no,scrollbars=no,resizable=yes,location=no,status=no");
		pop.moveTo((window.screen.width - w) / 2,
				(window.screen.height - h) / 2);
	} else {
		pop = window.open(url,name,"width="+ w+ ",height="+ h+ ",toolbar=no,menubar=no,scrollbars=no,resizable=yes,location=no,status=no");
		pop.moveTo(0, 20);
	}
}

function Fresh() {
	try {
		parent.frmbody.frmMain.history.go(0)
	} catch (e) {
	}
}
function Min() {
	try {
		hhctrl.Click();
	} catch (e) {
	}
} //最小化

function LogOut() {
	try {//注销你确信要注销登录吗?
		var vU;
		if (!confirm('是否注销登录？'))
			return false;
		window.top.location.href = 'logout.action';
	} catch (e) {
	}
}

function LogOut_shty() {
	try {
		var vU;
		if (!confirm('是否注销登录？'))
			return false;
		window.top.location.href = '';// 上海体育学院注销专用
	} catch (e) {
	}
}

function Exit() {
	// if(window.event.button=="1"){
	// alert(window.event.type);
	// window.Rpt.location.href='../sys/Exit.aspx';
	// }
}

function DoMouse(theid) {
	var id;
	var imgSRC;
	id = theid.getAttribute('state');
	if (id == '1') {
		theid.setAttribute('state', '0');
		theid.style.cursor = '';
		imgSRC = '../images/_menu/' + theid.getAttribute('alt') + '.gif';
	} else {
		theid.setAttribute('state', '1');
		theid.style.cursor = 'pointer';
		imgSRC = '../images/_menu/' + theid.getAttribute('alt') + '2.gif';
	}
	// theid.src =imgSRC;
}

function onhide1(theID) {// try{
	var objFrm = parent.frames['frmbody'].document.getElementById('divTheMenu');
	var mainFrm = parent.frames['frmbody'].document
			.getElementById('divTheMain');

	if (objFrm.style.display == 'none') {
		objFrm.style.display = '';
		mainFrm.style.left = '185px';
		theID.src = "../images/_menu/push.gif";
		theID.title = '隐藏主控菜单';
		if (document.getElementById('PU').getAttribute('tag') == 'ok')
			onhide2_Ex('down');
		// if(ie6<=0) parent.frmbody.mfr.cols="132,*"
	} else {
		objFrm.style.display = 'none';
		mainFrm.style.left = '0px';
		theID.src = "../images/_menu/pull.gif";
		theID.title = '显示主控菜单';
		if (document.getElementById('PU').getAttribute('tag') == 'ok') {
			document.getElementById('PU').src = '../images/_menu/blank.gif';
			document.getElementById('PU').title = '';
			// if(ie6<=0) parent.frmbody.mfr.cols="0,*"
		}
	}

	// }catch(err){}
}

function onhide2(theID) { // try{
	if (document.getElementById('PU').title == '')
		return false;
	if (ie6 > 0)
		var bHide = parent.frmbody.hideTheMenu('F');
	else {
		var bHide = parent.frames['frmbody'].hideTheMenu('F');
	}
	if (!bHide)
		return false;
	onhide2_Ex('blank');
	// }catch(e){}
}

function onhide2_Ex(pS) { // try{
	var o = document.getElementById('PU');
	if (pS == 'down') {
		o.setAttribute('tag', 'ok');
		o.src = '../images/_menu/down.gif';
		o.title = '返回主控菜单';
	} else if (pS == 'blank') {
		o.setAttribute('tag', '');
		o.src = '../images/_menu/blank.gif';
		o.title = '';
	}
}// catch(e){}}

function MouseOver(spanId) {
	var objSpan = eval(spanId);
	if (objSpan.style.color == RGB_NONE) {
		objSpan.style.cursor = '';
		return false;
	}

	objSpan.style.cursor = 'pointer';
	if (objSpan.style.color != RGB_CHECK) {
		objSpan.style.color = RGB_OVER;
	}
}

function MouseOut(spanId) {
	var objSpan = eval(spanId);
	if (objSpan.style.color == RGB_NONE) {
		return false;
	}
	if (objSpan.style.color != RGB_CHECK) {
		objSpan.style.color = RGB_LINK;
	}
}
