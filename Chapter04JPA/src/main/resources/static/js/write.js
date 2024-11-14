$(function(){
	// 가입 버튼 클릭
	$('#writeBtn').click(function(){
		$('#idDiv').empty();
		$('#pwdDiv').empty();
		$('#nameDiv').empty();
		
		if($('#id').val() == ''){
			$('#idDiv').text('아이디입력');
			$('#id').focus();
		}else if($('#pwd').val() == ''){
			$('#pwdDiv').text('아이디입력');
			$('#pwd').focus();
		}else if($('#name').val() == ''){
			$('#nameDiv').text('아이디입력');
			$('#name').focus();
		}else {
			$.ajax({
				type:'post',
				url:'/member/write',
				data:$('#writeForm').serialize(),   // 변수=값&변수=값....
				success:function(data){
					alert("회원가입완료");
					location.href='/member/list'
				},
				error: function(e){
					console.log(e);
				}
			});
		}
	}); 
	
	// 아이디 중복체크
	$('#id').focusout(function(){
		
		$('#idDiv').empty();
		
		if($('#id').val() == ''){
			$('#idDiv').text('아이디입력');
		} else{
			$.ajax({
				type:'post',
				url:'/member/isExistId',
				data:'id='+$('#id').val(),
				dataType:'text',
				success: function(data){
					//alert(data)
					if(data=='exist'){
						$('#idDiv').html('사용불가능').css('color','red');
					}else if(data='non_exist'){
						$('#idDiv').html('사용 가능').css('color','blue');
					}
				},
				error: function(e){
					console.log(e);
				}
			});
		}
	});
});