

var ifSubmit = false;
layui.use('layer', function() {
	var layer = layui.layer;
	$(function() {
		$("#svrCustCustomerName").change(function() {
			var custName = $("#svrCustCustomerName").val();
			$.ajax({
	  			url:"idOnCustomerIfExists.do",
	  			type:'POST',
	  			async:false,
	  			data:{custName:custName},
	  			success:function(data){
	        		if(data != ''){	        			
	        			ifSubmit = true;
	        			$("#svrCustCustomer").val(data.custNo)
					} else {
						layer.msg('客户不存在!');
						ifSubmit = false;
					}
	  			}
	  		});   
		})
	})
});

layui.use('form', function() {
	var form = layui.form;
	form.verify({
	  	 ifName:function(value, item){
	        	if(!ifSubmit){
	        		return "客户不存在!";
	        	}
	  	  }
	  	});    
	// 监听提交
	form.on('submit(formDemo)', function(data) {
		layer.msg('表单提交');
		if ($("#addOrSet").text() == '添加') {
			// 添加客户
			$.post("addCstService.do", data.field, function(data) {
				if (data > 0) {
					layer.msg('添加成功！', {
						time : 3000, // 3s后自动关闭
						/* btn : [ '', '继续添加' ], */
						btn1 : function(index, layero) {
							location.href = ".jsp";
						}
					});
					$(".reset").click();
				} else {
					layer.msg('提交失败！', {
						time : 2000
					});
				}
			});
		}
		return false;
	});
});
$(function(){
	$(".reset").click();
	
	$( "#svrCustCustomerName" ).autocomplete({
		source: 'idOnCustomerNamePrompt.do'
	});
})
