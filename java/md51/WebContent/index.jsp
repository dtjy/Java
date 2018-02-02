<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h5{
		margin: 2px 0 4px 0;
	}
	.textth{
		width: 180px;
		text-align: center;
	}
	.cdiv{
		margin: 10px 20px 10px 20px;
		padding: 10px 20px 10px 20px;
		border: 2px black solid;
	}
	#add_form input{
		margin: 2px 0 2px 0;
		
	}
	#update input{
		margin: 2px 0 2px 0;
		
	}
	#tdiv{
		margin-top: 20px;
		border: 2px black solid;
		float: left;
	}
	td{
	text-align: center;
	}
</style>
<script type="text/javascript">
window.onload=function(){
}
var xmlHttp;
function createXMLHttp(){
	var xmlHttp;
	if(window.XMLHttpRequest){
		xmlHttp=new XMLHttpRequest();
	}
	if(window.ActiveXObject){
		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		if(!xmlHttp){
			xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		}
	}
	return xmlHttp;
}
function getall(){
	//使用ajax异步传输
	xmlHttp=createXMLHttp();
	var url = "md?method=find_all";
	var tbody = document.getElementById("td");
	document.getElementById("td").innerHTML="";
	//xmlHttp绑定回调函数，回来每次xmlHttp状态改变时被调用0-4.只关心4状态
	xmlHttp.onreadystatechange=function(){
		if(xmlHttp.readyState==4&&xmlHttp.status==200){
			//接受服务器响应的数据,是文本数据，JSON也是文本数据
			var result=xmlHttp.responseText;
			//解析数据
			var json=eval("("+result+")");
			for(var i=0;i<json.length;i++){
				var tr = document.createElement("tr");
				var checkbox = document.createElement('input');  //创建input节点
				checkbox.setAttribute('type', 'checkbox');  //定义类型是checkbox
				checkbox.setAttribute('value', json[i].id);
				checkbox.setAttribute('class', "checked");
			//	checkbox.type="checkbox";
				var td1 = document.createElement("td");
				var td2 = document.createElement("td");
				var td3 = document.createElement("td");
				var td4 = document.createElement("td");
				var td5 = document.createElement("td");
				var td6 = document.createElement("td");
				var td7 = document.createElement("td");
				var button = document.createElement('input');  //创建input节点
				button.setAttribute('type', 'button');  //定义类型是button
			//	button.type="button";
				button.setAttribute('value', '编辑修改');
				button.setAttribute("onclick","updateOne(this)");
				var jiemi = document.createElement('input');  //创建input节点
				jiemi.setAttribute('type', 'button');  //定义类型是button
				jiemi.setAttribute('value', '解密密码');
	//			button.setAttribute("onclick","jiemi(this)");
				td1.appendChild(checkbox);
				td2.innerText = json[i].comp;
				td3.innerText = json[i].account;
				td4.innerText = json[i].password;
				td5.appendChild(button);
				td6.appendChild(jiemi);
				td7.innerText = "已加密";
				tr.appendChild(td1);
				tr.appendChild(td2);
				tr.appendChild(td3);
				tr.appendChild(td4);
				tr.appendChild(td5);
				tr.appendChild(td6);
				tr.appendChild(td7);
				tbody.appendChild(tr);
			}
			
		}
	}
	//true表示JavaScript脚本会在send()方法后继续执行而不会等待来自服务器的响应
	xmlHttp.open("GET",url,true);
	xmlHttp.send();
	
}
function find(){
	//使用ajax异步传输
	xmlHttp=createXMLHttp();
	var input = document.getElementById("find_by").value;
	var tbody = document.getElementById("td");
	tbody.innerHTML="";
	if(input==null){
		getall();
		return;
	}
	var url = "md?method=find_by&condition="+input;
	//xmlHttp绑定回调函数，回来每次xmlHttp状态改变时被调用0-4.只关心4状态
	xmlHttp.onreadystatechange=function(){
		if(xmlHttp.readyState==4&&xmlHttp.status==200){
			//接受服务器响应的数据,是文本数据，JSON也是文本数据
			var result=xmlHttp.responseText;
			//解析数据
			var json=eval("("+result+")");
			if(json.length>0){
				for(var i=0;i<json.length;i++){
					var tr = document.createElement("tr");
					var checkbox = document.createElement('input');  //创建input节点
					checkbox.setAttribute('type', 'checkbox');  //定义类型是checkbox
					checkbox.setAttribute('value', json[i].id);
					checkbox.setAttribute('class', "checked");
				//	checkbox.type="checkbox";
					var td1 = document.createElement("td");
					var td2 = document.createElement("td");
					var td3 = document.createElement("td");
					var td4 = document.createElement("td");
					var td5 = document.createElement("td");
					var td6 = document.createElement("td");
					var td7 = document.createElement("td");
					var button = document.createElement('input');  //创建input节点
					button.setAttribute('type', 'button');  //定义类型是button
				//	button.type="button";
					button.setAttribute('value', '编辑修改');
					button.setAttribute("onclick","updateOne(this)");
					var jiemi = document.createElement('input');  //创建input节点
					jiemi.setAttribute('type', 'button');  //定义类型是button
					jiemi.setAttribute('value', '解密密码');
		//			button.setAttribute("onclick","jiemi(this)");
					td1.appendChild(checkbox);
					td2.innerText = json[i].comp;
					td3.innerText = json[i].account;
					td4.innerText = json[i].password;
					td5.appendChild(button);
					td6.appendChild(jiemi);
					td7.innerText = "已加密";
					tr.appendChild(td1);
					tr.appendChild(td2);
					tr.appendChild(td3);
					tr.appendChild(td4);
					tr.appendChild(td5);
					tr.appendChild(td6);
					tr.appendChild(td7);
					tbody.appendChild(tr);
				}
			}
			
		}
	}
	//true表示JavaScript脚本会在send()方法后继续执行而不会等待来自服务器的响应
	xmlHttp.open("GET",url,true);
	xmlHttp.send();
}
function addOne(){
	var comp = document.getElementById("addcond").value;
	var account = document.getElementById("addacc").value;
	var password = document.getElementById("pwd").value;
	//使用ajax异步传输
	xmlHttp=createXMLHttp();
	var url = "md?method=add&comp="+comp+"&account="+account+"&password="+password;
	//xmlHttp绑定回调函数，回来每次xmlHttp状态改变时被调用0-4.只关心4状态
	xmlHttp.onreadystatechange=function(){
		if(xmlHttp.readyState==4&&xmlHttp.status==200){
			//接受服务器响应的数据,是文本数据，JSON也是文本数据
			var result=xmlHttp.responseText;
			var tip = document.getElementById("addtip");
			tip.innerText = result;
			comp.value="";
			account.value="";
			password.value="";
			getall();
		}
	}
	//true表示JavaScript脚本会在send()方法后继续执行而不会等待来自服务器的响应
	xmlHttp.open("GET",url,true);
	xmlHttp.send();
}

function updateOne(button){
	var tr = button.parentNode.parentNode;
	var id = document.getElementById("updateid");
	var input1 = document.getElementById("updatecond");
	var input2 = document.getElementById("updateacc");
	var input3 = document.getElementById("updatepwd");
	id.value = tr.childNodes[0].childNodes[0].value;
	input1.value = tr.childNodes[1].innerText;
	input2.value = tr.childNodes[2].innerText;
	input3.value = tr.childNodes[3].innerText;
}
function sureUpdate(){
	var flag = confirm("确定修改");
	if(!flag){
		return;
	}
	var id = document.getElementById("updateid").value;
	var comp = document.getElementById("updatecond").value;
	var account = document.getElementById("updateacc").value;
	var password = document.getElementById("updatepwd").value;
	
	xmlHttp=createXMLHttp();
	var url = "md?method=update&id="+id+"&comp="+comp+"&account="+account+"&password="+password;
	//xmlHttp绑定回调函数，回来每次xmlHttp状态改变时被调用0-4.只关心4状态
	xmlHttp.onreadystatechange=function(){
		if(xmlHttp.readyState==4&&xmlHttp.status==200){
			//接受服务器响应的数据,是文本数据，JSON也是文本数据
			var p = document.getElementById("updateMsg");
			p.innerText = xmlHttp.responseText;
			getall();
		}
	}
	//true表示JavaScript脚本会在send()方法后继续执行而不会等待来自服务器的响应
	xmlHttp.open("GET",url,true);
	xmlHttp.send();
}
function deleteAcc(){
	var flag = confirm("确定删除");
	if(!flag){
		return;
	}
	var checkboxs = document.getElementsByClassName("checked");
	var arr = new Array();
	for(var i=0;i<checkboxs.length;i++){
		if(checkboxs[i].checked){
			console.log(checkboxs[i].value);
			arr.push(checkboxs[i].value);
		}
	}
	xmlHttp=createXMLHttp();
	var url = "md?method=delete&ids="+arr;
	//xmlHttp绑定回调函数，回来每次xmlHttp状态改变时被调用0-4.只关心4状态
	xmlHttp.onreadystatechange=function(){
		if(xmlHttp.readyState==4&&xmlHttp.status==200){
		//	接受服务器响应的数据,是文本数据，JSON也是文本数据
			var p = document.getElementById("deleteMsg");
			p.innerText = xmlHttp.responseText;
			getall();
		}
	}
	//true表示JavaScript脚本会在send()方法后继续执行而不会等待来自服务器的响应
	xmlHttp.open("GET",url,true);
	xmlHttp.send();
}
function clears(){
	document.getElementById("deleteMsg").innerText="";
	document.getElementById("dupdateMsg").innerText="";
}
</script>
</head>
<body>
	<div style="float: left;">
		<div class="cdiv">
			<h5>查看全部操作</h5>
			<button id="getAll" value="查询全部" onclick="getall()" type="button">查询全部</button><br>
		</div>
		<div class="cdiv">
			<h5>条件查询操作</h5>
			<input  id="find_by" type="text" width="200px" onkeyup="find()" placeholder="请输入查询的关键字"><br>
			<button id="getAll" value="查询全部" onclick="getall()" type="button">条件查寻</button><br>
		</div>
		<div class="cdiv">
			<form id="add_form" method="post">
				<h5>新增操作</h5>
				<input id="addcond" name="comp" type="text" width="200px" placeholder="请输入关键字"><br>
				<input id="addacc" name="account" type="text" width="200px" placeholder="请输入帐号"><br>
				<input id="pwd" name="password" type="text" width="200px" placeholder="请输入密码"><br>
				<input id="add" value="确认添加" type="button" onclick="addOne()"/><br>
				<p id="addtip"></p>
			</form>
		</div>
		<div id="update" class="cdiv">
			<h5>更新操作</h5>
			<input id="updateid" name="id" type="text" width="200px"disabled="disabled"><br>
			<input id="updatecond" name="comp" type="text" width="200px"><br>
			<input id="updateacc" name="account" type="text" width="200px"><br>
			<input id="updatepwd" name="password" type="text" width="200px"><br>
			<button id="sureupdate" value="查询全部" onclick="sureUpdate()" type="button">确认修改</button><br>
			<p id="updateMsg" style="color: red;"></p>
		</div>
		<div class="cdiv">
			<button id="delete" value="查询全部" onclick="deleteAcc()" type="button">确认删除</button><br>
			<p id="deleteMsg" style="color: red;"></p>
		</div>
	</div>
	
	
	<div id="tdiv">
		<table id="tb" border="1px solid black" cellspacing="1">
			<thead>
				<tr>
					<th class="chechth" width="10px"><input type="checkbox" disabled="disabled"></th>
					<th class="textth">所属</th>
					<th class="textth">帐号</th>
					<th class="textth">密码</th>
					<th>编辑修改</th>
					<th>密码解密</th>
					<th width="200">明文</th>
				</tr>
			</thead>
			<tbody id="td">
				
			</tbody>
		</table>
	</div>
</body>
</html>