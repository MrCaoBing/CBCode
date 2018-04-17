//将表格配置封装成对象
var custInfoTab = {
	id : 'tab',
	elem : '#custTable',
	url : 'listCustServiceByPage.do',
	page : true,
	skin : 'row',
	method : 'POST',
	even : true,
	limits : [ 7, 10, 15 ],
	limit : 7,
	page : {
		curr : 1
	// 重新从第 1 页开始
	},
	cols : [ [ // 表头
	{
		field : 'name',
		width : 250,
		title : '服务名称'
	}, {
		field : 'type',
		width : 481,
		title : '月份',
		templet : function(d) {
			return d.type + '月份'
		}
	}, {
		field : 'value',
		width : 250,
		title : '服务数量'
	} ] ]
};
var table;
layui.use('table', function() {
	table = layui.table;
	table.init('custDataTab', custInfoTab);
});
layui.use('form', function() {
	var form = layui.form;
	// 监听提交
	form.on('submit(formDemo)', function(data) {
		layer.msg("获取数据中");
		return false;
	});
});

$(function() {

	// 指定图的元素
	var myPillar = echarts.init(document.getElementById('pillar'));
	$.get("listCustService.do", function(da) {
		option = {
			title : {
				text : '年度服务统计'
			},
			tooltip : {
				trigger : 'axis'
			},
			legend : {
				data : [ '咨询', '反馈', '投诉','售后' ]
			},
			toolbox : {
				show : true,
				feature : {
					dataView : {
						show : true,
						readOnly : false
					},
					magicType : {
						show : true,
						type : [ 'line', 'bar' ]
					},
					restore : {
						show : true
					},
					saveAsImage : {
						show : true
					},
					dataZoom: { //数据缩放视图
                        show: true
                    },
                    myTool : {  
                        show : true,  
                        title : '导出为Excel',  
                        icon :  'image://http://localhost:8080/hc0407crm/images/excel.png',
                        onclick : function (){  
                      	  location.href ="custServiceParseExcel.do";
                        }  
                     },
				}
			},
			calculable : true,
			xAxis : [ {
				type : 'category',
				data : [ '1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月',
						'10月', '11月', '12月' ]
			} ],
			yAxis : [ {
				type : 'value'
			} ],
			series : da

		};
		// 配置项和数据显示图表。
		myPillar.setOption(option);
	});
});

/*
 * [
 *  { name:'蒸发量', type:'bar', data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6,
 * 162.2, 32.6, 20.0, 6.4, 3.3], markPoint : { data : [ {type : 'max', name:
 * '最大值'}, {type : 'min', name: '最小值'} ] }, markLine : { data : [ {type :
 * 'average', name: '平均值'} ] } },
 */

