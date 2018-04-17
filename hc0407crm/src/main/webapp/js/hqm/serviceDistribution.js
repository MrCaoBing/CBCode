var dataDictionTab = {
	id : 'tab',
	elem : '#dataDictionTab',
	url : 'findCstServiceTiaojian.do',
	page : true,
	skin : 'row',
	method : 'POST',
	even : true,
	limits : [ 10, 15, 20 ],
	limit : 10,
	page : {
		curr : 1
	// 重新从第 1 页开始
	},
	cols : [ [ // 表头
	{
		field : 'svrId',
		width : 100,
		title : '编号'
	}, {
		field : 'svrCustCustomer',
		title : '客户',
		templet : function(d) {
			return d.svrCustCustomer.custName
		}
	}, {
		field : 'svrTitle',
		title : '概要'
	}, {
		field : 'svrType',
		width : 200,
		title : '服务类型'
	}, {
		field : 'svrCreateUser',
		title : '创建人',
		templet : function(d) {
			return d.svrCreateUser.usrName
		}
	}, {
		field : 'svrCreateDate',
		title : '创建日期'
	}, {
		field : '',
		title : '分配给',
		templet : function(d) {
			return '<span class="allot">点击分配</span>';
		}
	}, {
		fixed : 'right',
		align : 'center',
		toolbar : '#barDemo',
		title : '操作'
	} ] ]
};

function reload() {
	table.reload("tab", {
	});
}
layui.use('laydate', function() {
	var laydate = layui.laydate;
	// 执行一个laydate实例
	laydate.render({
		elem : "#svrCreateDate"// 指定元素
	});
	laydate.render({
		elem : "#svrCreateDate1"// 指定元素
	});
});


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
				$.get("delCstService.do", {
					id : data.svrId
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
			var svrCustCustomer = $('#svrCustCustomer').val();
			var svrTitle = $('#svrTitle').val();
			var svrType = $('#svrType').val();
			var svrCreateDate = $('#svrCreateDate').val();
			var svrCreateDate1 = $('#svrCreateDate1').val();
			dataDictionTab.where = {
				'map[\'svrCustCustomer\']' : svrCustCustomer,
				'map[\'svrTitle\']' : svrTitle,
				'map[\'svrType\']' : svrType,
				'map[\'svrCreateDate\']' : svrCreateDate,
				'map[\'svrCreateDate1\']' : svrCreateDate1
			}
		} else {
			dataDictionTab.where = {};
		}
		if(svrCreateDate!==''&&svrCreateDate1!=''){
			svrCreateDate<svrCreateDate1
		}
		table.init('basDataTab', dataDictionTab);
		// 保持分页居中
		$(".layui-table-page *").css("text-align", "center");
	});
});
var form;
layui.use('form', function() {
	form = layui.form;
	// 监听提交
	form.on('submit(formcheck)', function(data) {
		layer.msg("获取数据中");
		return false;
	});
});


$(document).on("click",".allot",function(event){
	var sysRoleId = $(this)
	$("#selectRo option").attr("selected",false)
	$("#selectRo option:contains("+$(this).text()+")").attr("selected",true)
	layer.open({
		type: 1, 
		title:false,
		shadeClose : true,
		offset : [ getTop(this)-12, getLeft(this) -16],
		area: ['193px', '38px'],
		shade : [ 0, 'rgba(250, 248, 255, 0)' ],
		content : '<div class="layui-form" lay-filter="test2" id="fromUsr">'+$("#selectRo").html()+'</div>',
		success: function(layero, index){
			form.render();								
		 }
	});
	form.on('select(seRo)', function(data){
		  console.log(data.elem); //得到select原始DOM对象
		  console.log(data.value); //得到被选中的值
		  console.log(data.othis); //得到美化后的DOM对象
		  var id = sysRoleId.parents("tr").children(1).children("div").html();
		  sysRoleId.text($(data.elem).children("option:selected").text());
		  layer.closeAll('page'); //关闭所有页面层
		  $.post("setCstService.do", eval('({svrDueUser:"' + data.value
  				+ '",svrId:"' + id + '"})'), function(data) {
  			if (data > 0) {
  				layer.msg('分配成功!', {
  					time : 1500,
  				});
  				$(".layui-laypage-btn").click();
  			} else {
  				layer.msg('分配失败:请选择客户经理!', {
  					time : 2000
  				});
  				reload();
  			}
  		});
		});      
});


// 获取元素的纵坐标
function getTop(e) {
	var offset = e.offsetTop;
	if (e.offsetParent != null)
		offset += getTop(e.offsetParent);
	return offset;
}
// 获取元素的横坐标
function getLeft(e) {
	var offset = e.offsetLeft;
	if (e.offsetParent != null)
		offset += getLeft(e.offsetParent);
	return offset;
}

$(document).on("click","#fromUsr .layui-select-title",function(){
	$(this).parents(".layui-layer-content").css({"overflow":"visible"});	
	//$(this).next().css({"display":"block","overflow":"visible"})
});
