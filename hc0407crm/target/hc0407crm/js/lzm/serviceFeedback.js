var form;
var table;
$(function() {
	layui.use('table', function() {
		table = layui.table, form = layui.form;
	});
});
function setserviceHandle() {
	layui.use('layer', function() {
		layer = layui.layer;
	});
	// 监听提交
	if($("#svrResult").val() == ''){
		layer.msg("处理结果不能为空!")
		return;
	}
	var svrSatisfy=$("input:radio[name=svrSatisfy]:checked").val();
	$.post("setCstServiceInfo", eval('({"svrId":"' + $("[name=svrId]").val()
			+ '","svrResult":"' + $("[name=svrResult]").val()
			+ '","select":"1","svrSatisfy":"' + svrSatisfy
			+ '"})'), function(result) {
		if (result > 0) {
			layer.msg("保存成功!", {
				title : "3秒后将跳转页面",
				time : 3000
			}, function() {
				location.href = 'jsp/serviceFeedbackIndex.jsp'
			});
		} else {
			layer.msg("保存失败!");
		}
	});
}