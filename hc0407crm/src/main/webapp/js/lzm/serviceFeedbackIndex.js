var table;
var form;
var laydate;
$(function(){
	$("#svrCreateDate1").css("display", "none");
	layui.use('laydate', function() {
		laydate = layui.laydate;

		// 执行一个laydate实例
		laydate.render({
			elem : '#svrCreateDate', // 指定元素
			done : function(value, date, endDate) {
				if ($("#svrCreateDate").val() == '') {
					$("#svrCreateDate1").css("display", "none");
					$("#svrCreateDate1").val("");
					page();
				} else {
					$("#svrCreateDate1").css("display", "block");
				}
				if ($("#svrCreateDate").val() != ''
						&& $("#svrCreateDate1").val() != '') {
					page();
				}
			}
		});
		laydate.render({
			elem : '#svrCreateDate1', // 指定元素
			done : function(value, date, endDate) {
				if ($("#svrCreateDate").val() != ''
						&& $("#svrCreateDate1").val() != '') {
					page();
				}
			}
		});
		laydate.render({
			elem : '#svrCreateDate1' // 指定元素
		});
	});
	layui.use('table', function() {
		table = layui.table, form = layui.form;
		table.render({
			elem : '#tab',
			id : 'svrTabId',
			url : 'findCstServiceInfo',
			limit:10,
			limits:[10,20,30,40,50],
			page : true,
			loading : false,
			cols : [ [ {
				field : 'svrId',
				title : '编号',
				align : 'center'
			}, {
				field : 'svrCustCustomerName',
				title : '客户',
				align : 'center',
				templet : function(data) {
					return data.svrCustCustomer.custName
				}
			}, {
				field : 'svrTitle',
				title : '概要',
				align : 'center',
			}, {
				field : 'svrType',
				title : '服务类型',
				align : 'center',
			}, {
				field : 'svrCreateUserUsrId',
				title : '创建人',
				align : 'center',
				templet : function(data) {
					return data.svrCreateUser.usrName
				}
			}, {
				field : 'svrCreateDate',
				title : '创建时间',
				align : 'center'
			}, {
				field : 'svrStatus',
				title : '状态',
				align : 'center',
				templet : function(data) {
					if(data.svrStatus==3){
						return "已处理";
					}
				}
			}, {
				field : 'operate',
				title : '操作',
				align : 'center',
				templet : "#tubiao"
			} ] ],
			where:{
				svrStatus:3
			}
		});
		table.on('tool(test)', function(obj) { // 注：tool是工具条事件名，test是table原始容器的属性
			// lay-filter="对应的值"
			var data = obj.data; // 获得当前行数据
			var layEvent = obj.event; // 获得 lay-event 对应的值（也可以是表头的 event
			// 参数对应的值）
			var tr = obj.tr; // 获得当前行 tr 的DOM对象

			if (layEvent == 'feedback') {
				location.href = 'jsp/serviceFeedback.jsp?svrId=' + data.svrId
						+ '&svrType=' + data.svrType + '&svrTitle='
						+ data.svrTitle + '&svrCustCustomerName='
						+ data.svrCustCustomer.custName + '&svrStatus='
						+ data.svrStatus + '&svrRequest=' + data.svrRequest
						+ '&svrCreateName=' + data.svrCreateUser.usrName
						+ '&svrCreateDate=' + data.svrCreateDate
						+ '&svrDueName=' + data.svrDueUser.usrName
						+ '&svrDueDate=' + data.svrDueDate
						+ '&svrDeal='+data.svrDeal
						+ '&svrDealDate='+data.svrDealDate
			}
		});
		form.on('select(test1)', function(data1) {
			page();
		});
		
	});
});
function page() {
	table.reload("svrTabId", {
		where : {
			svrTitle : $("[name=svrTitle]").val(),
			svrType : $("[name=svrType]").val(),
			svrCreateDate : $("[name=svrCreateDate]").val(),
			svrCreateDate1 : $("[name=svrCreateDate1]").val()
		},
		page : {
			curr : 1
		},
		method : "post"
	});
}