
var ifSubmit = false;
$(".reset").click();
layui.use('layer', function() {
	var layer = layui.layer;
	$(function() {
		$("#dictItem1").change(function() {
			var dictItem1 = $("#dictItem1").val();
			//alert(dictItem1);
			$.ajax({
	  			url:"findDictItem.do",
	  			type:'POST',
	  			async:false,
	  			data:{dictItem1:dictItem1},
	  			success:function(data){
	        		if(data > 0){
	        			layer.msg('条目已经录入');
	        			ifSubmit = true;
					} else {						
						ifSubmit = false;
					}
	  			}
	  		});   
		})
	})
});

var dataDictionTab = {
	id : 'tab',
	elem : '#dataDictionTab',
	url : 'listBasDictTiaojian.do',
	page : true,
	skin : 'row',
	method : 'POST',
	even : true,
	limits : [ 5, 10, 15 ],
	limit : 5,
	page : {
		curr : 1
	// 重新从第 1 页开始
	},
	cols : [ [ // 表头
	{
		field : 'dictId',
		title : '编号'
	}, {
		field : 'dictType',
		title : '类别',
		edit : true
	}, {
		field : 'dictItem',
		title : '条目',
		edit : true
	}, {
		field : 'dictValue',
		title : '值',
		edit : true 
	}, {
		field : 'dictIsEdiTable',
		title : '是否可编辑',
		 templet: '#ifEdit',
		 unresize: true
	}, {
		fixed : 'right',
		align : 'center',
		toolbar : '#barDemo',
		title : '操作'
	}
	] ]

};

function panduan() {
	var dictIsEdiTable = dictIsEdiTable.value;
	if ($("#dictIsEdiTable".attr("checded"))) {
		dictIsEdiTable = 1
	} else {
		dictIsEdiTable = 0
	}
}

var table;
layui.use('table', function() {
	table = layui.table;
	table.init('basDataTab', dataDictionTab);
	// 监听工具条
	table.on('tool(basDataTab)', function(obj) {
		var data = obj.data;
		if (obj.event === 'del') {
			layer.confirm('确定删除吗', function(index) {
				obj.del();
				layer.close(index);
				$.get("delBasDict.do", {
					id : data.dictId
				}, function(result) {
					if (result > 0) {
						layer.msg('删除成功!', {
							time : 1500,
						});
						reload();
					} else {
						layer.msg('删除失败', {
							time : 2000
						});
					}
				});
			});
		}
	});
	
	// 初始化页面
	$('.tableInit').on('click', function() {
		// 如果用户选择查询
		if ($(this).attr('query') == 'query') {
			// 拿到条件参数
			var dictType = $('#dictType option:selected').val();
			var dictItem = $('#dictItem').val();
			var dictValue = $('#dictValue').val();
			dataDictionTab.where = {
				'map[\'dictType\']' : dictType,
				'map[\'dictItem\']' : dictItem,
				'map[\'dictValue\']' : dictValue
			}
		} else {
			dataDictionTab.where = {};
		}
		table.init('basDataTab', dataDictionTab);
		// 保持分页居中
		$(".layui-table-page *").css("text-align", "center");
	});
	// 监听单元格编辑
	table.on('edit(basDataTab)', function(obj) {
		var value = obj.value // 得到修改后的值
		, data = obj.data // 得到所在行所有键值
		, field = obj.field; // 得到字段

		if (field == "dictType") {
			if (value == "") {
				layer.msg('概要不能为空,该修改不生效!');
				reload();
				return;
			}
		}
		if (field == "dictItem") {
			if (value == "") {
				layer.msg('不能为空,该修改不生效!');
				reload();
				return;
			}
		}
		if (field == "dictValue") {
			if (value == "") {
				layer.msg('不能为空,该修改不生效!');
				reload();
				return;
			}
		}
		if (field == "dictIsEdiTable") {
			if (value == "") {
				layer.msg('不能为空,该修改不生效!');
				reload();
				return;
			}
		}
		if (field == "dictIsEdiTable") {
			if (value >= 2) {
				layer.msg('超出范围值!');
				reload();
				return;
			}
		}
		$.post("setBasDict.do", eval('({' + field + ':"' + value + '",dictId:"'
				+ data.dictId + '"})'), function(data) {

			if (data > 0) {
				layer.msg('修改成功!', {
					time : 1500,
				});
				reload();
			} else {
				layer.msg('修改失败:原因不明!', {
					time : 2000
				});
				reload();
			}
		});
	});
});

function reload() {
	table.reload("tab", {
	});
}
layui.use('form', function() {
	var form = layui.form;
	// 监听提交
	form.verify({
  	 ifName:function(value, item){
        	if(ifSubmit){
        		return "该用户名已经被使用!";
        	}
  	  }
  	});      
	form.on('submit(formDemo)', function(data) {
		if(ifSubmit) return;
		layer.msg('表单提交');
		if ($("#addOrSet").text() == '添加') {
			// 添加客户
			$.post("addBasDict.do", data.field, function(data) {
				if (data > 0) {
					layer.msg('添加成功！', {
						time : 3000, // 3s后自动关闭
						/* btn : [ '', '继续添加' ], */
					});
					reload();
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
	//监听锁定操作
	  form.on('switch(ifEditSwitch)', function(obj){
		// 拿到行对象id
			var id = $(obj.elem).parents("tr").children().first().text();		  
		  var value = 0;
	    if(obj.elem.checked){
	    	value = 1
	    }
	    $.post("setBasDict.do",{dictIsEdiTable:value,dictId:id}, function(data) {
			if (data > 0) {
				layer.msg('修改成功!', {
					time : 1500,
				});
			} else {
				layer.msg('修改失败:原因不明!', {
					time : 2000
				});
				reload();
			}
		});
	  });
});

layui.use('form', function() {
	var form = layui.form;
	// 监听提交
	form.on('submit(formcheck)', function(data) {
		layer.msg("获取数据中");
		return false;
	});
});
