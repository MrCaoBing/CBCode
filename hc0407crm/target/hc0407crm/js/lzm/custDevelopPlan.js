var layer;
var table;
$(function() {
	layui.use('layer', function() {
		layer = layui.layer;
	});
	layui.use('table', function() {
		table = layui.table;
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
					title : '计划项(可编辑)',
					align : 'center',
					edit:true
			   },
			   {
					field : 'operate',
					title : '操作',
					align : 'center',
					templet : "#tubiao"
				}
			]],
			where:{
				chcId:$("[name=chcId]").val()
			}
		});
		table.on('tool(test)', function(obj) {
			var data = obj.data;
			var layEvent = obj.event;
			if (layEvent == 'del') { // 删除
				layer.confirm('确认要删除该信息吗?',{
					icon : 2,
					title : '警告'
				}, function(index) {
					obj.del(); // 删除对应行（tr）的DOM结构，并更新缓存
					layer.close(index);
					$.get("delSalPlanInfo", {
						plaId : data.plaId
					}, function(result) {
						if (result > 0) {
							layer.msg("删除成功!");
						} else {
							layer.msg("删除失败!");
						}
					});
				});
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
			})
		});
	});
});
function addSalPlan() {
	$.ajax({
		type : "post",
		data : {
			plaTodo : $("[name=plaTodo]").val(),
			"salChance.chcId" : $("[name=chcId]").val()
		},
		url : "addSalPlanInfo",
		success : function(result) {
			if (result > 0) {
				layer.msg("制定成功!");
				$("[name=plaTodo]").val("");
				show();
			} else {
				layer.msg("制定失败!");
			}
		}
	});
}
function show(){
	table.reload('salPlanTab',{
		where:{
			chcId:$("[name=chcId]").val()
		}
	})
}
function locationSalPlan() {
		location.href = "jsp/execPlan.jsp?chcId="+ $("[name=chcId]").val()
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