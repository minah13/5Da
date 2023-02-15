$(document).ready(function(){
	
	// 카카오로그인 버튼
	$("#googleLoginBtn").on('click',function(){
		location.href = "/oauth2/authorization/google";
		/*$.ajax({
			url : "/adminboardlist",
			type : "get",
			data : {"b_type" : "not"},
			success : function(result){				
				$("#adminnoticetable").html("<tr><th>게시물명</th><th>작성자</th><th>작성일</th><th> </th><th> </th></tr>");
				for(var i=0;i<result.length;i++){
					$("#adminnoticetable").append("<tr><td class='tabname'>"+ result[i].b_title +"</td>" +
					"<td class='tabname'>" +result[i].id + "</td>" +
					"<td class='tabname'>" + result[i].regdate + "</td>" +
					"<td><input class='tabmodbtn' id='comment' type='button' value='댓글작성' onclick='comment("+result[i].b_no + ")'></td>" +
					"<td><input class='tabmodbtn' id='boardmod' type='button' value='수정' onclick='boardmod("+ result[i].b_no +")'></td>"+
					"<td><input class='tabdelbtn' id='boarddel' type='button' value='삭제' onclick='boarddel("+ result[i].b_no +")'></td></tr>");
				}
				location.href = "adminmember";
					
			}
		});*/
	}); // notice button click end
	
})