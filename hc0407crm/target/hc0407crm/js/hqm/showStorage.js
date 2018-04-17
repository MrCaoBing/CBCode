var dataDictionTab = {
		id : 'tab',
		elem : '#dataDictionTab',
		url : 'listStorageTiaojian.do',
		page : true,
		skin : 'row',
		method : 'POST',
		even : true,
		limits : [ 10, 15, 20 ],
		limit : 10,
		page : {
			curr : 1
		//重新从第 1 页开始
		},
		cols : [ [ //表头
		{
			field : 'stkId',
			title : '序号'
		}, {
			field : 'product',
			title : '产品',
			templet:function(d){
				return d.product.prodName
			}
		}, {
			field : 'stkWarehouse',
			title : '仓库'
		}, {
			field : 'stkWare',
			title : '货位'
		}, {
			field : 'stkCount',
			title : '件数'
		}, {
			field : 'stkMemo',
			title : '备注'
		} ] ]
	};
	var table;
	layui.use('table', function() {
		table = layui.table;
		table.init('basDataTab', dataDictionTab);
		//初始化页面
		$('.tableInit').on('click', function() {
			//如果用户选择查询
			if ($(this).attr('query') == 'query') {
				//拿到条件参数
				var product = $('#product').val();
				var stkWarehouse = $('#stkWarehouse').val();
				dataDictionTab.where = {
					'map[\'product\']' : product,
					'map[\'stkWarehouse\']' : stkWarehouse
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