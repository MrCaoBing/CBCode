//将表格配置封装成对象
	var lstStatus = 3;
    var custInfoTab = {
        	id:'tab'
          ,elem: '#lostTable'
          ,url:'listCstLost.do'
          ,page:true
          ,skin: 'row'
          ,method:'POST'
          ,even: true
          ,limits:[7,10,15]
          ,limit:7
          ,page: {
        	    curr: 1 //重新从第 1 页开始
        		}              
          ,cols: [[ //表头
            {field:'lstId', width:50,title:'ID'}
           ,{field:'lstLastOrderDate', width:100,title:'上次下单时间'}
           ,{field:'custName', width:140,title:'客户名称',templet:function(d){
        	  return d.cstCustomer.custName;
           }}
           ,{field:'cstCustomer', width:200,title:'客户经理',templet:function(d){
        	  return d.cstCustomer.sysUser.usrName;
           }}
           ,{field:'cstCustomer', width:400,title:'流失原因',templet:function(d){
        	  return d.cstCustomer.lostReason;
           }}          
          ]]
        };
    	var table;
        layui.use('table', function(){
        	table = layui.table;
        	custInfoTab.where = {'map[\'lstStatus\']':lstStatus};
        	table.init('custTab',custInfoTab);
           
            //初始化页面
            $('.tableInit').on('click', function(){
            	//如果用户选择查询
				if($(this).attr('query') == 'query'){
					//拿到条件参数
					var custName = $('#custName').val();
					var sysUser = $('#sysUser option:selected').val();
					var lstStatus = 3;
					//为配置对象添加新属性，传递参数
	            	custInfoTab.where = {
	            			'map[\'custName\']':custName,
	            			'map[\'userNo\']':sysUser,
	            			'map[\'lstStatus\']':lstStatus
	            	}	            	
				} else {
					custInfoTab.where = {'map[\'lstStatus\']':lstStatus};
				}           
            	//初始化表格，custInfoTab为上文的配置对象
				table.init('custTab',custInfoTab);
            	 //保持分页居中
            	$(".layui-table-page *").css("text-align", "center");         	 
            });
        });
        layui.use('form', function(){
            var form = layui.form;
            //监听提交
            form.on('submit(formDemo)', function(data){
                layer.msg("获取数据中");
                return false;
            });
        });

        
        $(function() {
        	// 指定图的元素
        	var myPillar = echarts.init(document.getElementById('pillar'));
        	$.get("listCustLost.do", function(da) {
        		option = {
        			title : {
        				text : '年度客户流失统计'
        			},
        			tooltip : {
        				trigger : 'axis'
        			},
        			/*legend : {
        				data : [ '咨询服务', '反馈服务', '投诉服务' ]
        			},*/
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
                              	  location.href ="custLostParseExcel.do";
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

        
        
