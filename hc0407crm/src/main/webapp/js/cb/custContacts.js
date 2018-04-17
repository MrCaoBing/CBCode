var form, table;
layui.use('table', function() {
	table = layui.table;
	form = layui.form;

	// 监听工具条
	table.on('tool(lkmData)', function(obj) {
		var data = obj.data;
		if (obj.event === 'del') {
			layer.confirm('真的删除行么', function(index) {
				// ajax传递数据
				$.post("delCstLinkman.do?lkmId=" + data.lkmId, function(data) {
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
	table.on('edit(lkmData)', function(obj) {
		var value = obj.value // 得到修改后的值
		, data = obj.data // 得到所在行所有键值
		, field = obj.field; // 得到字段
		if (field == "lkmTel") {
			if (value == "") {
				layer.msg('电话不能为空,该修改不生效!');
				table.reload('idTest');
				return;
			}
		}
		$.post("setCstLinkman.do", eval('({' + field + ':"' + value
				+ '",lkmId:"' + data.lkmId + '"})'), function(data) {
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

	// 监听性别操作
	form.on('switch(sexDemo)', function(obj) {
		// 拿到行对象id
		var id = $(obj.elem).parents("tr").children().first().text();
		var sex = '男';
		// 判断是否被选中
		if (obj.elem.checked) {
			sex = '女';
		}
		$.post("setCstLinkman.do", eval('({lkmSex:"' + sex + '",lkmId:"' + id
				+ '"})'), function(data) {
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

layui.use('form', function() {
	var form = layui.form;
	// 监听提交
	form.on('submit(formDemo)', function(data) {
		layer.msg("正在向后台提交数据！");
		// 添加客户
		$.post("addCstLinkman.do", data.field, function(data) {
			if (data > 0) {
				layer.msg('添加成功');
				table.init('lkmData');
			} else {
				layer.msg('添加失败:原因不明,请仔细核查数据后继续提交！', {
					time : 3000
				});
			}
		});
		return false;
	});
});