$(function(){
	layui.use('table', function() {
		var table = layui.table;
		table.render({
			elem:"#tab",
			id:'salPlanTab',
			url : 'findSalPlanInfo',
			page : false,
			cols : [ [ 
			   {
					field : 'plaDate',
					title : '日期',
					align : 'center'
			   },
			   {
					field : 'plaTodo',
					title : '计划项',
					align : 'center'
			   },
			   {
					field : 'plaResult',
					title : '执行效果(可编辑)',
					edit:true,
					align : 'center'
			   }
			]],
			where:{
				chcId:$("[name=chcId]").val()
			}
		});
		table.on('edit(test)', function(obj) {
			var value = obj.value // 得到修改后的值
			, data = obj.data // 得到所在行所有键值
			, field = obj.field; // 得到字段
			$.ajax({
				type : "post",
				url : "setSalPlanInfo",
				data : eval('({' + field + ':"' + value + '",plaId:"'
						+ data.plaId + '"})'),
				success : function(result) {
					if (result > 0) {
						layer.msg('修改成功!');
					} else {
						layer.msg('修改失败!');
					}
				}
			});
		});
	});
});
function developStatus(status){
	if(status==3){
		$.ajax({
			type : "post",
			url : "setSalChanceInfo",
			data : eval('({"chcStatus":"' + status + '",chcId:"'
					+ $("[name=chcId]").val() + '","custName":"'+$("[name=chcCustName]").val()
					+'","lkmName":"'+$("[name=chcLinkman]").val()+'","lkmTel":"'+$("[name=chcTel]").val()
					+'","sysUser":"'+$("[name=usrId]").val()+'"})'),
			success : function(result) {
				if (result > 0) {
					layer.msg('开发成功!',{
						title : '3秒后将跳转页面',
						time : 3000,
					},function(){
						location.href='jsp/salChanceManager.jsp'
					});
				} else {
					layer.msg('开发失败!');
				}
			}
		});
	}else{
		$.ajax({
			type : "post",
			url : "setSalChanceInfo",
			data : eval('({"chcStatus":"' + status + '",chcId:"'
					+ $("[name=chcId]").val() + '"})'),
			success : function(result) {
				if (result > 0) {
					layer.msg('终止成功!',{
						title : '3秒后将跳转页面',
						time : 3000,
					},function(){
						location.href='jsp/salChanceManager.jsp'
					});
				} else {
					layer.msg('终止失败!');
				}
			}
		});
	}
}

function tiaozhuanDeveLop(){
	location.href = "jsp/custDevelopPlan.jsp?chcId="+ $("[name=chcId]").val()
	+"&chcCustName="+$("[name=chcCustName]").val()
	+"&chcSource="+$("[name=chcSource]").val()
	+"&chcTitle="+$("[name=chcTitle]").val()
	+"&chcRate="+$("[name=chcRate]").val()
	+"&chcLinkman="+$("[name=chcLinkman]").val()
	+"&chcMobile="+$("[name=chcMobile]").val()
	+"&chcDesc="+$("[name=chcDesc]").val()
	+"&chcCreateId="+$("[name=chcCreateId]").val()
	+"&chcCreateName="+$("[name=chcCreateName]").val()
	+"&chcCreateDate="+$("[name=chcCreateDate]").val()
	+"&chcDueId="+$("[name=chcDueId]").val()
	+"&chcDueName="+$("[name=chcDueName]").val()
	+"&chcDueDate="+$("[name=chcDueDate]").val()
	+"&chcTel="+$("[name=chcTel]").val()
}