var dataDictionTab = {
		id : 'tab',
		elem : '#dataDictionTab',
		url : 'listProductTiaojian.do',
		page : true,
		skin : 'row',
		method : 'POST',
		even : true,
		limits : [ 10, 15, 20],
		limit : 10,
		page : {
			curr : 1
		//重新从第 1 页开始
		},
		cols : [ [ //表头
		{
			field : 'prodId',
			width : 100,
			title : '编号'
		}, {
			field : 'prodName',
			width : 140,
			title : '名称'
		}, {
			field : 'prodType',
			width : 200,
			title : '型号'
		}, {
			field : 'prodBatch',
			width : 200,
			title : '等级/批次'
		}, {
			field : 'prodUnit',
			width : 200,
			title : '单位'
		}, {
			field : 'prodPrice',
			width : 200,
			title : '单价(元)'
		}, {
			field : 'prodMemo',
			width : 200,
			title : '备注'
		} ] ]
	};
	var table;
	layui.use('table', function() {
		table = layui.table;
		table.init('basDataTab', dataDictionTab);
		//监听工具条
		table.on('tool(basDataTab)', function(obj) {
			var data = obj.data;
			if (obj.event === 'del') {
				layer.confirm('确认删除吗', function(index) {
					obj.del();
					alert(data.username);
				});
			} else if (obj.event === 'edit') {
				location.href = "jsp/cb/custInfoEdit.jsp";
			}
		});
		//初始化页面
		$('.tableInit').on('click', function() {
			//如果用户选择查询
			if ($(this).attr('query') == 'query') {
				//拿到条件参数
				var prodName = $('#prodName').val();
				var prodType = $('#prodType').val();
				var prodBatch = $('#prodBatch').val();
				dataDictionTab.where = {
					'map[\'prodName\']' : prodName,
					'map[\'prodType\']' : prodType,
					'map[\'prodBatch\']' : prodBatch
				}

			} else {
				dataDictionTab.where = {};
			}
			table.init('basDataTab', dataDictionTab);
			//保持分页居中
			$(".layui-table-page *").css("text-align", "center");
		});
	});
	layui.use('form', function(){
	    var form = layui.form;
	    //监听提交
	    form.on('submit(formcheck)', function(data){
	        layer.msg("获取数据中");
	        return false;
	    });
	});