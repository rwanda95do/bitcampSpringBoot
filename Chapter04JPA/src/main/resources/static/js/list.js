$(function(){
	// 검색
	$('#searchListBrn').click(function(){
		if($('#value').val() == ''){
			alert("검색어를 입력하세요");
		} else {
			$.ajax({
				type:'get',
				url:'/member/getSearchList',
				data: {
					'columnName' : $('#columnName').val(),
					'value' : $('#value').val()
				},
				dataType: 'json',
				success: function(data){
					console.log(data);
					
					$('#listTable tr:gt(0)').remove();
					$.each(data, function(index, item){
						let result = `<tr>`+
										`<td align="center">`+ item.seq +`</td>` +
										`<td align="center">`+ item.id +`</td>` +
										`<td align="center">`+ item.pwd +`</td>` +
										`<td align="center">`+ item.name +`</td>` +
									  `</tr>`;
						
						$('#listTable').append(result)
					});//each
				},
				error: function(e){console.log(e);}
			})
		}
	});
});