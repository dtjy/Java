function getAll(){
	$.ajax({
		url:"add",
		type:"post",
		data:{method:"find_all"},
		success:function(data){
			var list = JSON.parse(data);
			console.log(data);
			console.log(list);
		}
	});
	
}