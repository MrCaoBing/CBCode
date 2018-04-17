//将表格配置封装成对象
    var custInfoTab = {
        	id:'tab'
          ,elem: '#custTable'
          ,url:'listCustConstituteByPage.do'
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
            {field:'name', width:481,title:'名称'}
           ,{field:'value', width:485,title:'数量'}
          ]]
        };
    	var table;
        layui.use('table', function(){
        	table = layui.table;
        	table.init('custDataTab',custInfoTab);
        });
        layui.use('form', function(){
            var form = layui.form;
            //监听提交
            form.on('submit(formDemo)', function(data){
                layer.msg("获取数据中");
                return false;
            });
        });
  
        $(function(){
        	//指定饼图的元素
            var myPie = echarts.init(document.getElementById('pie')); 
            $.get("listCustConstitute.do",function(data){           	     	 
            	  option = {
                  	    title : {
                  	        text: '客户构成',
                  	        x:'center'
                  	    },
                  	    tooltip : {
                  	        trigger: 'item',
                  	        formatter: "{a} <br/>{b} : {c} ({d}%)"
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
	                              	  location.href ="custConstituteParseExcel.do";
	                                }, 
	                             },
	                             myTool2 : {  
			                            show : true,  
			                            title : '导出为PDF',  
			                            icon :  'image://http://localhost:8080/hc0407crm/images/crm_bb_pdf.png',
			                            onclick : function (){  
			                            location.href ="custConstituteParsePDF.do";
			                            }
	                             }
	                        }
	                    },
                  	    calculable : true,
                  	    series : [{
                  	            name:'客户',
                  	            type:'pie',
                  	            radius : [150, 300],
                  	            center : ['50%', '40%'],
                  	            roseType : 'area',
                  	            data:data
                  	         }]
                  	};
            	  // 配置项和数据显示图表。
                  myPie.setOption(option);
            });
                      	      
        });
  