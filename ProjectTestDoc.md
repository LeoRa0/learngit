#<center>系统测试及调试报告</center>#
##1、引言##
###&emsp;&emsp;1.1 文件读者###

&emsp;&emsp;此文件读者为软件质量检验员（QA）。

###&emsp;&emsp;1.2 开发软件的名称###

&emsp;&emsp;小学生四则运算测试系统。

###&emsp;&emsp;1.3 项目的任务提出者、开发者、用户###

&emsp;&emsp;**任务提出者：**现代软件工程课老师。  
 
&emsp;&emsp;**开发者：**杨斌项目小组（成员：田强、杨斌、曹悦、饶龙龙）。 
 
&emsp;&emsp;**用&emsp;户：**小学一、二年级学生（十岁以下）。

###&emsp;&emsp;1.4 项目于其他软件或其他系统的关系###
&emsp;&emsp;本软件为独立软件，不与其他软件配合，无依赖关系。

###&emsp;&emsp;1.5 术语定义###

####&emsp;&emsp;1.5.1&emsp;四则运算：####
&emsp;&emsp;加、减、乘、除，四种运算规则。

####&emsp;&emsp;1.5.2&emsp;真分数：####
&emsp;&emsp;真分数就是分子小于分母的分数，我们把这样的分数叫做真分数。

###&emsp;&emsp;1.5 参考资料，参考文献###

&emsp;&emsp;此次使用的编码规范主要包括文件的规范和程序格式即排版的规范，采用了当今流行的格式。

##2、计划##
###&emsp;&emsp;2.1&emsp;测试方案###
&emsp;&emsp;测试方案采用黑盒测试方法。首先对各个模块和功能进行测试，然后进行集成测试。总结得出整个软件的质量。

###&emsp;&emsp;2.2&emsp;测试项目###
####&emsp;&emsp;测试1####
&emsp;&emsp;名称：账号注册测试。  
&emsp;&emsp;目的：测试软件的账号注册功能。  
&emsp;&emsp;内容：用户名、密码、确认密码的提交、合法性检查，用户名，密码检验，错误提示。注册新用户的功能是否正常。  
&emsp;&emsp;进度：0.5小时。

####&emsp;&emsp;测试2####
&emsp;&emsp;名称：账号登陆测试。  
&emsp;&emsp;目的：测试软件的登陆功能。  
&emsp;&emsp;内容：用户名，密码提交、合法性检查，用户名，密码检验，错误提示。登录账号的功能是否正常。  
&emsp;&emsp;进度：0.5小时。

####&emsp;&emsp;测试3####
&emsp;&emsp;名称：题目练习测试。  
&emsp;&emsp;目的：测试软件的题目练习功能。  
&emsp;&emsp;内容：练习题生成是否合理，答案是否正确，自动判卷功能是否准确，添加记录功能是否正常，错误提示机制是否正常。  
&emsp;&emsp;进度：2小时。

####&emsp;&emsp;测试4####
&emsp;&emsp;名称：软件查看记录功能测试。  
&emsp;&emsp;目的：测试软件查看得分记录的功能。  
&emsp;&emsp;内容：记录显示是否准确、完整。  
&emsp;&emsp;进度：1小时。

####&emsp;&emsp;测试5####
&emsp;&emsp;名称：退出功能测试。  
&emsp;&emsp;目的：测试软件的退出功能。  
&emsp;&emsp;内容：软件能否正常退出，资源释放情况。  
&emsp;&emsp;进度：0.5小时。

###&emsp;&emsp;2.3&emsp;测试准备###
&emsp;&emsp;测试开始之前先要在PC上安装小学生四则运算测试系统，确保PC系统为Windows XP及以上，.Net版本4.5及以上。

###&emsp;&emsp;2.4&emsp;测试机构###
&emsp;&emsp;小组测试人员。  
&emsp;&emsp;职责：找出程序中的错误。

##3、测试项目说明##
####&emsp;&emsp;测试1####
&emsp;&emsp;名称：账号注册测试。  
&emsp;&emsp;目的：测试软件的账号注册功能。  
&emsp;&emsp;内容：用户名，密码，确认密码的提交、合法性检查，用户名，密码检验，错误提示。注册新用户的功能是否正常。  
&emsp;&emsp;条件：PC已安装小学生四则运算测试系统。  
&emsp;&emsp;测试用例如表1所示：  
&emsp;&emsp;**<center>表1&emsp;账号注册测试用例</center>**
<center>
<table class="table table-striped table-condensed" border="1" cellspacing="0" align="center">
	<tr valign="middle" align="center">
		<th>用例</th>
		<th>输入</th>
		<th>输出</th>
	</tr>
	<tr valign="middle" align="center">
		<td>测试用例1</td>
		<td>点击“点此注册”按钮</td>
		<td>弹出注册窗口</td>
	</tr>
	<tr valign="middle" align="center">
		<td>测试用例2</td>
		<td>点击“注册”按钮</td>
		<td>显示“用户名和密码不能为空</td>
	</tr>
	<tr valign="middle" align="center">
		<td>测试用例3</td>
		<td>输入用户名“test”，点击“注册”按钮</td>
		<td>显示“用户名和密码不能为空”</td>
	</tr>
	<tr valign="middle" align="center">
		<td>测试用例4</td>
		<td>输入密码“123”，点击“注册”按钮</td>
		<td>显示“用户名和密码不能为空</td>
	</tr>
	<tr valign="middle" align="center">
		<td>测试用例5</td>
		<td>输入确认密码“456”，点击“注册”按钮</td>
		<td>显示“两次输入密码必须相同”</td>
	</tr>
	<tr valign="middle" align="center">
		<td>测试用例6</td>
		<td>输入确认密码“123”，点击“注册”按钮</td>
		<td>显示“注册成功”</td>
	</tr>
	<tr valign="middle" align="center">
		<td colspan="3">&emsp;</td>
	</tr>
	<tr valign="middle" align="center">
		<td>步骤及操作</td>
		<td colspan="2">操作完毕，提示信息或转入界面</td>
	</tr>
	<tr valign="middle" align="center">
		<td>允许偏差</td>
		<td colspan="2">不允许有任何偏差</td>
	</tr>
</table>
</center>
&emsp;&emsp;测试资料：系统帮助与使用说明手册。

####&emsp;&emsp;测试2####
&emsp;&emsp;名称：账号登录测试。  
&emsp;&emsp;目的：测试软件登录功能。  
&emsp;&emsp;内容：用户名，密码提交、合法性检查，用户名，密码检验，错误提示。登录账号的功能是否正常。
&emsp;&emsp;条件：已经成功注册账号。  
&emsp;&emsp;测试用例如表2所示：  
&emsp;&emsp;**<center>表2&emsp;账号登测试用例</center>**
<center>
<table class="table table-striped table-condensed" border="1" cellspacing="0" align="center">
	<tr valign="middle" align="center">
		<th>用例</th>
		<th>输入</th>
		<th>输出</th>
	</tr>
	<tr valign="middle" align="center">
		<td>测试用例1</td>
		<td></td>
		<td>用户名或密码错误</td>
	</tr>
	<tr valign="middle" align="center">
		<td>测试用例2</td>
		<td>test1，123</td>
		<td>用户名或密码错误</td>
	</tr>
	<tr valign="middle" align="center">
		<td>测试用例3</td>
		<td>test，456</td>
		<td>用户名或密码错误</td>
	</tr>
	<tr valign="middle" align="center">
		<td>测试用例4</td>
		<td>test，123</td>
		<td>成功登陆，进入软件</td>
	</tr>
	<tr valign="middle" align="center">
		<td colspan="3">&emsp;</td>
	</tr>
	<tr valign="middle" align="center">
		<td>步骤及操作</td>
		<td colspan="2">操作完毕，提示信息或转入界面</td>
	</tr>
	<tr valign="middle" align="center">
		<td>允许偏差</td>
		<td colspan="2">不允许有任何偏差</td>
	</tr>
</table>
</center>
&emsp;&emsp;测试资料：系统帮助与使用说明手册。

####&emsp;&emsp;测试3####
&emsp;&emsp;名称：题目练习测试。  
&emsp;&emsp;目的：测试软件的题目练习功能。  
&emsp;&emsp;内容：练习题生成是否合理，答案是否正确，自动判卷功能是否准确，添加记录功能是否正常，错误提示机制是否正常。
&emsp;&emsp;条件：成功登录，进入软件菜单。  
&emsp;&emsp;测试用例如表3所示：  
&emsp;&emsp;**<center>表3&emsp;题目练习测试用例</center>**
<center>
<table class="table table-striped table-condensed" border="1" cellspacing="0" align="center">
	<tr valign="middle" align="center">
		<th>用例</th>
		<th>输入</th>
		<th>输出</th>
	</tr>
	<tr valign="middle" align="center">
		<td>测试用例1</td>
		<td>点击“开始答题（简单）”按钮</td>
		<td>新窗口，显示20道简单四则运算的题目</td>
	</tr>
	<tr valign="middle" align="center">
		<td>测试用例2</td>
		<td>填写10道题，全部填写正确答案，点击“提交”</td>
		<td>显示“还没有做完呢”</td>
	</tr>
	<tr valign="middle" align="center">
		<td>测试用例3</td>
		<td>继续填写10道题，全部填写错误答案，点击“提交”</td>
		<td>显示得分10分，显示错误题的正确答案</td>
	</tr>
	<tr valign="middle" align="center">
		<td>测试用例4</td>
		<td>点击“关闭”按钮</td>
		<td>窗口关闭</td>
	</tr>
	<tr valign="middle" align="center">
		<td>测试用例5</td>
		<td>点击“开始答题（混合）”按钮</td>
		<td>新窗口，显示20道混合四则运算的题目</td>
	</tr>
	<tr valign="middle" align="center">
		<td>测试用例6</td>
		<td>填写10道题，全部填写正确答案，点击“提交”</td>
		<td>显示“还没有做完呢”</td>
	</tr>
	<tr valign="middle" align="center">
		<td>测试用例7</td>
		<td>继续填写10道题，全部填写错误答案，点击“提交”</td>
		<td>显示得分10分，显示错误题的正确答案</td>
	</tr>
	<tr valign="middle" align="center">
		<td>测试用例8</td>
		<td>点击“关闭”按钮</td>
		<td>窗口关闭</td>
	</tr>
	<tr valign="middle" align="center">
		<td>测试用例9</td>
		<td>点击“开始答题（真分数）”按钮</td>
		<td>新窗口，显示20道真分数四则运算的题目</td>
	</tr>
	<tr valign="middle" align="center">
		<td>测试用例10</td>
		<td>填写10道题，全部填写正确答案，点击“提交”</td>
		<td>显示“还没有做完呢”</td>
	</tr>
	<tr valign="middle" align="center">
		<td>测试用例11</td>
		<td>继续填写10道题，全部填写错误答案，点击“提交”</td>
		<td>显示得分10分，显示错误题的正确答案</td>
	</tr>
	<tr valign="middle" align="center">
		<td>测试用例12</td>
		<td>点击“关闭”按钮/td>
		<td>窗口关闭</td>
	</tr>
	<tr valign="middle" align="center">
		<td colspan="3">&emsp;</td>
	</tr>
	<tr valign="middle" align="center">
		<td>步骤及操作</td>
		<td colspan="2">操作完毕，提示信息或转入界面</td>
	</tr>
	<tr valign="middle" align="center">
		<td>允许偏差</td>
		<td colspan="2">不允许有任何偏差</td>
	</tr>
</table>
</center>
&emsp;&emsp;测试资料：系统帮助与使用说明手册。

####&emsp;&emsp;测试4####
&emsp;&emsp;名称：软件查看记录功能测试。  
&emsp;&emsp;目的：测试软件查看得分记录的功能。  
&emsp;&emsp;内容：记录显示是否准确、完整。  
&emsp;&emsp;条件：成功登录，完成3次练习测试。  
&emsp;&emsp;测试用例如表4所示：  
&emsp;&emsp;**<center>表4&emsp;得分记录测试用例</center>**
<center>
<table class="table table-striped table-condensed" border="1" cellspacing="0" align="center">
	<tr valign="middle" align="center">
		<th>用例</th>
		<th>输入</th>
		<th>输出</th>
	</tr>
	<tr valign="middle" align="center">
		<td>测试用例1</td>
		<td>输入用户名密码：test，123，点击“登录”</td>
		<td>成功进入主页面</td>
	</tr>
	<tr valign="middle" align="center">
		<td>测试用例2</td>
		<td>观察主页</td>
		<td>记录列表显示有三次做题记录，且记录分数与答题正确数匹配</td>
	</tr>
	<tr valign="middle" align="center">
		<td colspan="3">&emsp;</td>
	</tr>
	<tr valign="middle" align="center">
		<td>步骤及操作</td>
		<td colspan="2">操作完毕，转入界面，显示信息。</td>
	</tr>
	<tr valign="middle" align="center">
		<td>允许偏差</td>
		<td colspan="2">不允许有任何偏差</td>
	</tr>
</table>
</center>
&emsp;&emsp;测试资料：系统帮助与使用说明手册。

####&emsp;&emsp;测试5####
&emsp;&emsp;名称：退出功能测试。  
&emsp;&emsp;目的：测试软件退出功能。  
&emsp;&emsp;内容：软件能否正常退出，资源释放情况。
&emsp;&emsp;条件：进入主页。  
&emsp;&emsp;测试用例如表5所示：  
&emsp;&emsp;**<center>表5&emsp;退出功能测试用例</center>**
<center>
<table class="table table-striped table-condensed" border="1" cellspacing="0" align="center">
	<tr valign="middle" align="center">
		<th>用例</th>
		<th>输入</th>
		<th>输出</th>
	</tr>
	<tr valign="middle" align="center">
		<td>测试用例1</td>
		<td>点击右上角叉形按钮</td>
		<td>软件正常退出</td>
	</tr>
	<tr valign="middle" align="center">
		<td colspan="3">&emsp;</td>
	</tr>
	<tr valign="middle" align="center">
		<td>步骤及操作</td>
		<td colspan="2">操作完毕，显示信息。</td>
	</tr>
	<tr valign="middle" align="center">
		<td>允许偏差</td>
		<td colspan="2">不允许有任何偏差</td>
	</tr>
</table>
</center>
&emsp;&emsp;测试资料：系统帮助与使用说明手册。

##4、评价##
###&emsp;&emsp;4.1范围###
&emsp;&emsp;测试计划说明书中的测试用例能基本上包括所有的情况，基本上能反应此软件是否存在错误。

###&emsp;&emsp;4.2准则###
&emsp;&emsp;以发现错误为准则。

##5、测试结果##
&emsp;&emsp;以上测试用例均测试通过，该软件质量合格。测试过程截图记录如下：