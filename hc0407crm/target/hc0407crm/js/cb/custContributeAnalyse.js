//将表格配置封装成对象
    var custInfoTab = {
        	id:'tab'
          ,elem: '#custTable'
          ,url:'listCustAccountedByPage.do'
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
            {field:'custId', width:250,title:'客户编号'}
           ,{field:'name', width:481,title:'名称'}
           ,{field:'value', width:250,title:'总金额(单位:人民币)',templet:function(d){return '￥'+(d.value/10000).toFixed(4)+'万元'}}
          ]]
        };
    	var table;
        layui.use('table', function(){
        	table = layui.table;
        	table.init('custDataTab',custInfoTab);
            //初始化页面
            $('.tableInit').on('click', function(){
            	//如果用户选择查询
				if($(this).attr('query') == 'query'){
					//拿到条件参数
					var custName = $('#custName').val();
					//为配置对象添加新属性，传递参数
	            	custInfoTab.where = {
	            			'map[\'custName\']':custName
	            	}
	            	
				} else {
					custInfoTab.where = {};
				}           
            	//初始化表格，custInfoTab为上文的配置对象
				table.init('custDataTab',custInfoTab);
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
        
        
        
        var dataAxis = "";
        var data = "";
        $(function(){
        	//指定图的元素
            var myPillar = echarts.init(document.getElementById('pillar')); 
            var dataAxis = "";
            var data = "";
            $.get("listCustAccounted.do",function(da){
            	dataAxis = "[";
            	data = "[";
  	        	for(var a in da){
  	        		dataAxis+="'"+da[a].name+"'";
  	        		data+="'"+da[a].value+"'";
  	        		if(a<da.length-1){
  	        			dataAxis+=",";
  	        			data+=",";
  	        		}
  	        	}
  	        	dataAxis+="]"
      	        data+="]";
  	        	option = {
	            	   title: {
	            		        text: '客户贡献'
	            		    },
	            	    color: ['#3398DB'],
	            	    tooltip : {
	            	        trigger: 'axis',
	            	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
	            	            type : 'line'        // 默认为直线，可选为：'line' | 'shadow'
	            	        }
	            	    },
	            	    toolbox: { //可视化的工具箱
	                        show: true,
	                        feature: {
	                            dataView: { //数据视图
	                                show: true
	                            },
	                            restore: { //重置
	                                show: true
	                            },
	                            dataZoom: { //数据缩放视图
	                                show: true
	                            },
	                            saveAsImage: {//保存图片
	                                show: true
	                            },
	                            magicType: {//动态类型切换
	                                type: ['bar', 'line']
	                            },
	                            myTool1 : {  
	                                show : true,  
	                                title : '导出为Excel',  
	                                icon :  'image://http://localhost:8080/hc0407crm/images/excel.png',
	                                onclick : function (){  
	                              	  location.href ="custAccountedParseExcel.do";
	                                }  
	                             },
	                             myTool2 : {  
		                                show : true,  
		                                title : '导出为PDF',  
		                                icon :  'image://http://localhost:8080/hc0407crm/images/crm_bb_pdf.png',
		                                onclick : function (){  
		                              	  location.href ="custAccountedParsePDF.do";
		                                }  
		                             },
	                        }
	                    },
	                    tooltip: { //弹窗组件
	                        show: true
	                    },
	            	    grid: {
	            	        left: '3%',
	            	        right: '4%',
	            	        bottom: '3%',
	            	        containLabel: true
	            	    },
	            	    xAxis : [
	            	        {
	            	            type : 'category',
	            	            data : eval("("+dataAxis+")"),
	            	            axisTick: {
	            	                alignWithLabel: true
	            	            }
	            	        }
	            	    ],
	            	    yAxis : [
	            	        {
	            	            type : 'value'
	            	        }
	            	    ],
	            	    series : [
	            	        {
	            	            name:'金额(人民币)',
	            	            type:'bar',
	            	            barWidth: '60%',
	            	            data:eval("("+data+")")
	            	        }
	            	    ]
	            	};
        
	         // 配置项和数据显示图表。
	         myPillar.setOption(option);
            });           
        });
       