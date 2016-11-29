/*
 * 返回当天的中文星期名称
 * */
function time(){
   var today=new Date();
   var names=new Array(7);
   names[0]="星期日";
   names[1]="星期一";
   names[2]="星期二";
   names[3]="星期三";
   names[4]="星期四";
   names[5]="星期五";
   names[6]="星期六";
   
   return today.toLocaleDateString()+"  "+names[today.getDay()];
}

/*
 * 返回所给日期是今年的第几周
 * */
function getWeeks(year, month, day){
    var day1 = new Date(year, month-1, day);
    var day2 = new Date(year, 0, 1);
    
    var firstweek = day2.getDay();//1月1日是星期几
    if(firstweek == 0) {
    firstweek = 6;
    }else {
    firstweek = firstweek - 1;
    }//转化为0表示星期一,6表示星期日
    firstweek = (7 - firstweek) % 7;//计算1月1日离第一周的天数
    var day3 = new Date(year, 0, 1+firstweek)
    var result = Math.round((day1.getTime() - day3.getTime())/(1000*60*60*24));
    result = Math.floor(result / 7)+2;//这个地方应该用floor返回最小次数然后+2
    return result;
}

/*
 * 获得学期和周数
 * */
function getTermAndWeek(){
	   var this_Intake=eval("parent.frames['banner'].js_Sys_vkxrq");
	   //var this_Intake='20120903';//本学期结束前重设置
	   
	   var now=new Date();
	   var year=now.getFullYear();
	   var month=now.getMonth()+1;
	   var day=now.getDate();
	   
	   var this_Intake_Y=this_Intake.substring(0,4);
	   var this_Intake_M=this_Intake.substring(4,6);
	   var this_Intake_D=this_Intake.substring(6);
	   var startWeeks=getWeeks(this_Intake_Y,this_Intake_M,this_Intake_D);
	   var nowWeeks=getWeeks(year,month,day);
	   
	   var term="";
	   if(this_Intake_M>6){
	     term=year+"-"+(year+1)+"学年第一学期"
	   }else{
	     term=(year-1)+"-"+year+"学年第二学期";
	   }
	   term=term+"  第"+(nowWeeks-startWeeks+1)+"周";
	   
	   return term;
}