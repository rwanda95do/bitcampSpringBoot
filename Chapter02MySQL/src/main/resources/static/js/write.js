$(function(){
// 아이디 중복체크
	$('#id').focusout(function () {
		$('#idDiv').empty();
		$('#idDiv').css({
		    'color': 'red',       
		    'font-size': '10pt'  
		});
		if($('#id').val()=='') $('#idDiv').html("아이디 입력하세요");
		else
			$.ajax({
				type : 'post',
				url : '/user/getExistId',
				data : 'id=' + $('#id').val(),
				dataType : 'text',
				success : function(data){
					//alert(data);
					if(data=='exist'){
						$('#idDiv').html("사용 불가능");
					} else if(data=='non_exist') {
						$('#idDiv').html("사용 가능");
						$('#idDiv').css('color','blue');
					}
				},
				error : function(e){console.log(e)}
				
			});	
	});
	
	
// 등록
	$('#writeBtn').click(function(){
		$('#idDiv').empty();
		$('#pwdDiv').empty();
		
		if($('#name').val()== '')
			 $('#nameDiv').html("이름 입력하세요");
		else if($('#id').val()== '')
			 $('#idDiv').html("아이디 입력하세요");
		else if($('#pwd').val()== '')
			 $('#pwdDiv').html("비밀번호 입력하세요");
		else 
			$.ajax({
				type : 'post',
				url : '/user/write',
				data : $('#userWriteForm').serialize(),
				success : function(){
					alert('회원가입 완료!');
					//location.href='/user/list';
				},
				error : function(e){console.log(e)}
				
			});			 
	});
	
	
	
	
	
});
