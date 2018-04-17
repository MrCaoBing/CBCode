var salChanceInfoTab;
var table;
var layer;
var form;
var open1;
$(function() {
	$("#open").css("display", "none");
	layui.use('layer', function() {
		layer = layui.layer;
	});
	layui.use('table', function() {
		table = layui.table, form = layui.form;

		salChanceInfoTab = table.render({
			elem : '#tab',
			id : 'chcTabId',
			url : 'findAllSalChanceInfo',
			page : true,
			limit : 10,
			limits : [ 10, 20, 30, 40, 50 ],
			loading : false,
			cols : [ [ {
				field : 'chcId',
				title : '编号',
				align : 'center',
				width:60
			}, {
				field : 'chcCustName',
				title : '客户名称',
				align : 'center',
				edit : 'text'
			}, {
				field : 'chcSource',
				title : '机会来源',
				align : 'center',
				templet:function(d){
		        	   return '<span class="sysRole">'+d.chcSource+'</span>'}
			}/*
				 * , { field : 'chcRate', title : '成功几率', align : 'center', edit :
				 * 'text' }
				 */, {
				field : 'chcTitle',
				title : '概要',
				align : 'center',
				edit : 'text'
			}, {
				field : 'chcLinkman',
				title : '联系人',
				align : 'center',
				edit : 'text'
			},{
				field : 'chcDesc',
				title : '机会描述',
				align : 'center',
				edit : 'text'
			},{
				field : 'chcMobile',
				title : '创建人电话',
				align : 'center',
				edit : 'text'
			}/*,{ 
				field : 'chcCreateUser.usrId',
				title : '创建人', 
				align : 'center',
				templet : function(data) { 
					return data.chcCreateUser.usrName 
					} 
			}*//*, {
			field : 'chcCreateDate', title : '创建时间', align : 'center' }*/
			 /*
				 * , { field : 'chcDueUser', title : '指派人', align : 'center',
				 * templet : function(data) { return data.chcDueUser.usrName } }
				 */, {
				field : 'chcStatus',
				title : '状态',
				align : 'center',
				sort : true,
				templet : function(data) {
					if (data.chcStatus == 1) {
						return "未指派";
					} else if (data.chcStatus == 2) {
						return "已指派";
					} else if (data.chcStatus == 3) {
						return "开发成功";
					} else {
						return "终止开发";
					}
				}
			}, {
				field : 'operate',
				title : '操作',
				align : 'center',
				templet : "#tubiao",
					width:150
			} ] ],
			where:{
				usrId:$("[name=usrId]").val(),
				roleId:$("[name=roleId]").val()
			}
		});

		table.on('tool(test)', function(obj) { // 注：tool是工具条事件名，test是table原始容器的属性
			// lay-filter="对应的值"
			var data = obj.data; // 获得当前行数据
			var layEvent = obj.event; // 获得 lay-event 对应的值（也可以是表头的 event
			// 参数对应的值）
			var tr = obj.tr; // 获得当前行 tr 的DOM对象
			if (layEvent == 'del') { // 删除
				layer.confirm('真的删除行么', function(index) {
					if (data.chcStatus == 1) {
						if (data.chcCreateUser.usrId == $("#usrId").val()
								|| $("#roleId").val() == 2|| $("#roleId").val() == 16) {
							obj.del(); // 删除对应行（tr）的DOM结构，并更新缓存
							layer.close(index);
							/*
							 * $.ajax({ type : "get", url : "delSalChanceInfo",
							 * data:{chcId:data.chcId}, success :
							 * function(result) { if (result > 0) {
							 * layer.msg("删除成功!"); } else { layer.msg("删除失败!"); } }
							 * });
							 */
							$.get("delSalChanceInfo", {
								chcId : data.chcId
							}, function(result) {
								if (result > 0) {
									layer.msg("删除成功!");
								} else {
									layer.msg("删除失败!");
								}
							});
						} else {
							layer.msg("您没有权限删除该销售机会!");
						}
					} else {
						layer.msg("请选择状态为指派的销售机会!");
					}
				});
			} else if (layEvent == 'cust') {
				if (data.chcStatus == 2) {
					location.href = "jsp/custDevelopPlan.jsp?chcId="
							+ data.chcId + "&chcCustName=" + data.chcCustName
							+ "&chcSource=" + data.chcSource + "&chcTitle="
							+ data.chcTitle + "&chcRate=" + data.chcRate
							+ "&chcLinkman=" + data.chcLinkman + "&chcMobile="
							+ data.chcMobile + "&chcDesc=" + data.chcDesc
							+ "&chcTel="+data.chcTel
							+ "&chcCreateId=" + data.chcCreateUser.usrId
							+ "&chcCreateName=" + data.chcCreateUser.usrName
							+ "&chcCreateDate=" + data.chcCreateDate
							+ "&chcDueId=" + data.chcDueUser.usrId
							+ "&chcDueName=" + data.chcDueUser.usrName
							+ "&chcDueDate=" + data.chcDueDate
							
				} else {
					layer.msg("请选择状态为已指派的销售信息!");
				}
			} else if (layEvent == 'app') {
				if (data.chcStatus == 1) {
					open1 = layer.open({
						type : 1,
						title : "指派给",
						area : [ '260px' ],
						closeBtn : 0,
						shadeClose : true,
						content : $("#open"), // 这里content是一个普通的String
						success : function(layero, index) {
							form.render();
						}
					});
					$(document).on("click", ".layui-select-title", function() {
						$(this).parents(".layui-layer-content").css({
							"overflow" : "visible"
						});
						// $(this).next().css({"display":"block","overflow":"visible"})
					});
					form.on('select(test1)', function(data1) {
						if (data1.value!= '') {
							var confirm = layer.confirm('确定要指派给'
									+ $(this).text() + '吗?', {
								title : '提示'
							}, function(index) {
								$.get("setSalChanceInfo", eval('({"chcDueId":"'
										+ data1.value + '","chcId":"'
										+ data.chcId + '","chcStatus":"2"})'),
										function(result) {
											if (result > 0) {
												layer.closeAll();
												layer.msg("指派成功!");
												page();
											} else {
												layer.msg("指派失败!");
											}
										});
							});
						}
					});
				} else {
					layer.msg("请选择状态为未指派的销售机会!");
				}
			}
		});
		table.on('edit(test)', function(obj) {
			var value = obj.value // 得到修改后的值
			, data = obj.data // 得到所在行所有键值
			, field = obj.field; // 得到字段
			var flag=true;
			if(field=="chcCustName"){
				if(value==""){
					layer.msg("填写信息不能为空!",function(){});flag=false;
				}else{
					flag=true;
				}
			}
			if(field=="chcTitle"){
				if(value==""){
					layer.msg("填写信息不能为空!",function(){});flag=false;
				}else{
					flag=true;
				}
			}
			if(field=="chcLinkman"){
				if(value==""){
					layer.msg("填写信息不能为空!",function(){});flag=false;
				}else{
					flag=true;
				}
			}
			if(field=="chcDesc"){
				if(value==""){
					layer.msg("填写信息不能为空!",function(){});flag=false;
				}else{
					flag=true;
				}
			}
			if(field=="chcMobile"){
				if(value==""){
					layer.msg("填写信息不能为空!",function(){});flag=false;
				}else{
					flag=true;
				}
				if(!/^0?(13[0-9]|15[012356789]|17[013678]|18[0-9]|14[57])[0-9]{8}$/.test(value)){
					layer.msg("联系人电话格式不正确!",function(){});flag=false;
				}else{
					flag=true;
				}
			}
			if(flag==true){
				$.ajax({
					type : "post",
					url : "setSalChanceInfo",
					data : eval('({' + field + ':"' + value + '",chcId:"'
							+ data.chcId + '"})'),
					success : function(result) {
						if (result > 0) {
							layer.msg('修改成功!');
						} else {
							layer.msg('修改失败!');
						}
					}
				});
			}
		});

	});
	$(".layui-table-page *").css("text-align", "center");
});

function page() {
	salChanceInfoTab.reload({
		where : {
			chcCustName : $("[name=chcCustName]").val(),
			chcTitle : $("[name=chcTitle]").val(),
			chcLinkman : $("[name=chcLinkman]").val(),
			usrId:$("[name=usrId]").val(),
			roleId:$("[name=roleId]").val()
		},
		method : "post"
	});
}
$(document).on("click",".sysRole",function(event){
	var sysRoleId = $(this);
	$("#selectRo option").attr("selected",false);
	$("#selectRo option:contains("+$(this).text()+")").attr("selected",true);
	layer.open({
		type: 1, 
		title:false,
		shadeClose : true,
		offset : [ getTop(this)-10, getLeft(this) -20],
		area: ['109px', '38px'],
		shade : [ 0, 'rgba(250, 248, 255, 0)' ],
		content : '<div class="layui-form" lay-filter="test2" id="fromUsr">'+$("#selectRo").html()+'</div>',
		success: function(layero, index){
			form.render();								
		 }
	});
	form.on('select(seRo)', function(data){
		  var id = sysRoleId.parents("tr").children(1).children("div").html();
		  if($(data.elem).children("option:selected").text()!=""){
		  sysRoleId.text($(data.elem).children("option:selected").text());
		  layer.closeAll('page'); // 关闭所有页面层
			  $.post("setSalChanceInfo", {chcSource:data.value,chcId:id}, function(data) {
	  			if (data > 0) {
	  				layer.msg('修改成功!', {
	  					time : 1500,
	  				});
	  			} else {
	  				layer.msg('修改失败!', {
	  					time : 2000
	  				});
	  			}
	  		});
		  }
		});      
});

$(document).on("click","#fromUsr .layui-select-title",function(){
	$(this).parents(".layui-layer-content").css({"overflow":"visible"});	
	// $(this).next().css({"display":"block","overflow":"visible"})
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