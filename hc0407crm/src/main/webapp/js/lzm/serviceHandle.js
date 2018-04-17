var layer;
	layui.use('layer', function() {
		layer = layui.layer;
	});
  layui.use('form', function() {
		var form = layui.form;

		form.on('submit(*)', function(data) {
			// 监听提交
			if($("#svrDeal").val() == ''){
				layer.msg("服务处理不能为空!")
				return;
			}
		
			$.post("setCstServiceInfo",
					eval('({"svrId":"' + $("[name=svrId]").val() + '","svrDeal":"'
							+ $("[name=svrDeal]").val() + '","select":"0"})'),
					function(result) {
						if (result > 0) {
							layer.msg("处理成功!", {
								title : "3秒后将跳转页面",
								time : 3000
							}, function() {
								location.href = 'jsp/serviceHandleIndex.jsp'
							});
						} else {
							layer.msg("处理失败!");
						}
					});
			return false;
		});
	});