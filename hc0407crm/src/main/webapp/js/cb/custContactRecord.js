var form, table;
layui.use('table', function() {
	table = layui.table;
	// 监听工具条
	table.on('tool(atvTab)', function(obj) {
		var data = obj.data;
		if (obj.event === 'del') {
			layer.confirm('真的删除么', function(index) {
				// ajax传递数据
				$.post("delCstActivity.do?atvId=" + data.atvId, function(data) {
					if (data > 0) {
						layer.msg('删除成功!', {
							time : 1500,
						});
						obj.del();
					} else {
						layer.msg('删除失败:原因不明!', {
							time : 2000
						});
					}
				});

			});
		}
	});
	// 监听单元格编辑
	table.on('edit(atvTab)', function(obj) {
		var value = obj.value // 得到修改后的值
		, data = obj.data // 得到所在行所有键值
		, field = obj.field; // 得到字段
		if (field == "atvPlace") {
			if (value == "") {
				layer.msg('概要不能为空,该修改不生效!');
				table.reload('idTest');
				return;
			}
		}
		if (field == "atvTitle") {
			if (value == "") {
				table.reload('idTest');
				layer.msg('详细信息不能为空,该修改不生效!');
				return;
			}
		}
		$.post("setCstActivity.do", eval('({' + field + ':"' + value
				+ '",atvId:"' + data.atvId + '"})'), function(data) {
			if (data > 0) {
				layer.msg('修改成功!', {
					time : 1500,
				});
			} else {
				layer.msg('修改失败:原因不明!', {
					time : 2000
				});
			}
		});
	});
});

layui.use('laydate', function() {
	var laydate = layui.laydate;

	// 执行一个laydate实例
	laydate.render({
		elem : '#date' // 指定元素
	});

});

layui.use('form', function() {
	form = layui.form;
	// 监听提交
	form.on('submit(formDemo)', function(data) {
		layer.msg("正在向后台提交数据！");
		// 添加客户
		$.post("addCstActivity.do", data.field, function(data) {
			if (data > 0) {
				layer.msg('添加成功');
				table.init('atvTab');
			} else {
				layer.msg('修改失败:原因不明,请仔细核查数据后继续提交！', {
					time : 3000
				});
			}
		});
		return false;
	});
});

$(function() {
	$("body")
			.on(
					"click",
					"td[data-field=atvDate]",
					function() {
						var id = $(this).prev().text();
						var thi = $(this)
						layer.open({
									title : '点击修改时间',
									shadeClose : true,
									offset : [ '100px', '50px' ],
									shade : [ 0, 'rgba(250, 248, 255, 0)' ],
									content : '<input style="width:220px;height:40px;"name="atvTitle" '
											+ 'value="'
											+ $(this).text()
											+ '" id="atvDate" lay-verify="required" class="layui-input">',
									btn : [ '确定' ],
									yes : function(index, layero) {
										$.post("setCstActivity.do", {
											atvDate : $("#atvDate").val(),
											atvId : id
										}, function(data) {
											if (data > 0) {
												layer.msg('修改成功!', {
													time : 1500
												});
												$(thi).children().first().text(
														$("#atvDate").val())
											} else {
												layer.msg('修改失败:原因不明!', {
													time : 2000
												});
											}
										});
									}
								});
						layui.use('laydate', function() {
							var laydate = layui.laydate;
							// 执行一个laydate实例
							laydate.render({
								elem : "#atvDate"// 指定元素
							});
						});
					});
});