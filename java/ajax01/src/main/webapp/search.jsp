<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#mydiv{
		position: absolute;
		left: 50%;
		top: 50%;
		margin-left: -200px;
		margin-top: -50px;
	}
	.mouseOver{
		background: #708090;
		color: #FFFAFA
	}
	.mouseOut{
		background: #FFFAFA;
		color: #000000;
	}
</style>
<script type="text/javascript">
	var xmlHttp;
	function getMoreContents(){
		//首先获得用户文本输入
		var content = document.getElementById("keyword");
		if(content.value==""){
			//清除已有数据
		//	document.getElementById("content_table_body").innerHTML="";
			clearContent();
			return;
		}
		//然后要给服务器发送用户输入的内容
		//使用ajax异步传输
		xmlHttp=createXMLHttp();
		var url = "search?keyword="+escape(content.value);
		
		//xmlHttp绑定回调函数，回来每次xmlHttp状态改变时被调用0-4.只关心4状态
		xmlHttp.onreadystatechange=function(){
			if(xmlHttp.readyState==4&&xmlHttp.status==200){
				//接受服务器响应的数据,是文本数据，JSON也是文本数据
				var result=xmlHttp.responseText;
				//解析数据
				var json=eval("("+result+")");
				//每次调用该函数想清空 tbody中的数据
				//document.getElementById("content_table_body").innerHTML="";
				//动态显示数据，展示到输入框下面
				setContent(json)
			}
		}
		//true表示JavaScript脚本会在send()方法后继续执行而不会等待来自服务器的响应
		xmlHttp.open("GET",url,true);
		xmlHttp.send();
		
	}
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
	//设置关联数据的展示
	function setContent(content){
		//每次调用该函数想清空 tbody中的数据
		clearContent();
		setLocation();
		//获取关联数据的长度，以此确定生成多少tr
		var size = content.length;
		for(var i=0;i<size;i++){
			var nextNode=content[i];
			var tr=document.createElement("tr");
			var td=document.createElement("td");
			td.setAttribute("border", 0);
			td.setAttribute("bgcolor", "#FFFAFA");
			td.onmouseover=function(){
				this.className="mouseOver";
			};
			td.onmouseout=function(){
				this.className="mouseOut";
			};
			//通过冒泡事件，实现点击文本，让文本框显示该数据.td元素是tbody元素子元素，冒泡事件，先执行子元素事件，实现要求
			td.onmousedown = function(){
				console.log("onmousedown");
		        document.getElementById("keyword").value = this.innerText;
		    };
			td.onclick=function(){
				console.log(this.innerText);
				document.getElementById("keyword").value=this.innerText;
			}
			var text = document.createTextNode(nextNode);
			td.appendChild(text);
			tr.appendChild(td);
			document.getElementById("content_table_body").appendChild(tr);
		}
	}
	//清空之前数据
	function clearContent(){
		var contentBody = document.getElementById("content_table_body");
		var size = contentBody.childNodes.length;
		for(var i=size-1;i>=0;i--){
			contentBody.removeChild(contentBody.childNodes[i]);
		}
		document.getElementById("popdiv").style.border="none";
	}
	//失去焦点函数
	function keywordbour(){
		//document.getElementById("content_table_body").innerHTML="";
		console.log("keywordbour");
		clearContent();
	}
	//设置现实关联信息的位置
	function setLocation(){
		//位置与输入框一直
		var content = document.getElementById("keyword");
		var width=content.offsetWidth;
		var left=content["offsetLeft"];//距离左边框距离
		var top=content["offsetTop"]+content.offsetHeight;
		//获得显示数据的div
		var popdiv=document.getElementById("popdiv");
		popdiv.style.border="black 1px solid";
		popdiv.style.left=left+"px";
		popdiv.style.top=top+"px";
		popdiv.style.width=width+"px";
		document.getElementById("content_table").style.width=width+"px";
	}
</script>
</head>
<body>
	<div id="mydiv">
		<input id="keyword" type="text" size="50" onkeyup="getMoreContents()" onblur="keywordbour()" onfocus="getMoreContents()">
		<input type="button" value="搜索一下" width="50px">
		<!-- 内容展示区域 -->
		<div id="popdiv">
			<table id="content_table" bgcolor="#FFFAFA" border="0" cellpadding="0" cellspacing="0">
				<!-- 动态查询数据显示 -->
				<tbody id="content_table_body">
				
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>