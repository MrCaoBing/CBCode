//将表格配置封装成对象
    

var custInfoTab = {
        	id:'tab'
          ,elem: '#custTable'
          ,url:'listLoseCstCustomer.do'
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
            {field:'custNo', width:50,title:'ID'}
           ,{field:'custId', width:100,title:'客户编号'}
           ,{field:'custName', width:190,title:'名称'}
           ,{field:'custRegion', width:200,title:'地区'}
           ,{field:'sysUser', width:150,templet:function(d){return d.sysUser.usrName != null ? d.sysUser.usrName : ''},title:'客户经理'}
           ,{field:'custLevel', width:200,title:'客户等级',sort: true}
           ,{fixed: 'right', width:140, align:'center', toolbar: '#barDemo',title:'操作'}
          ]]
        };
    	var table;
        layui.use('table', function(){
        	table = layui.table;
        	table.init('custDataTab',custInfoTab);
            //监听工具条
            table.on('tool(custDataTab)', function(obj){
                var data = obj.data;       
                if (data.sysUser.usrId != $("#usrId").val()) {
                	layer.open({
  					  title: '系统提示'
  					  ,shadeClose:true
  					 ,offset: 'auto'
  					  ,shade: [0, 'rgba(250, 248, 255, 0)']
  					  ,content:'强制:每个客户经理只能对自己的客户进行操作!'
  					  ,btn: ['确定']
  					});
          		  return;
                }
              if(obj.event === 'del'){
                    layer.confirm('真的删除么', function(index){
                        obj.del();
                        $.post("setCstCustomer.do?custNo="+data.custNo+"&custStatus=3",function(data){
                			if(data > 0){                		
                    			layer.msg('删除成功!', {time: 1500,}); 
                    			obj.del();
                    			//初始化表格，custInfoTab为上文的配置对象
                				table.init('custDataTab',custInfoTab);
                    		}else{
                    			layer.msg('删除失败:原因不明!',{ time: 2000});
                    		}
                	}); 
                    });
                    //url表示拿到数据将去那个页面
              } else if(obj.event === 'hist') {
                  location.href = "skipToLinkmanPage.do?custNo="+data.custNo+"&url=jsp/custHistoryOrder";
              } else if(obj.event === 'sugg') {
                  location.href = "skipToLinkmanPage.do?custNo="+data.custNo+"&url=jsp/custContactRecord";	
              } else if(obj.event === 'cont') {
                  location.href = "skipToLinkmanPage.do?custNo="+data.custNo+"&url=jsp/custContacts";
              } else if(obj.event === 'edit') {
            	  location.href = "findCstCustomer.do?custNo="+data.custNo;	
              }            
            }); 
            //初始化页面
            $('.tableInit').on('click', function(){
            	//如果用户选择查询
				if($(this).attr('query') == 'query'){
					//拿到条件参数
	   				var custId = $('#custId').val();
					var custName = $('#custName').val();
					var custRegion = $('#custRegion').val();
					var sysUser = $('#sysUser option:selected').text();
					var custStatus = $('#custStatus option:selected').val();
					var custLevel = $('#custLevel').val();
					//为配置对象添加新属性，传递参数
	            	custInfoTab.where = {
	            			'map[\'custId\']':custId,
	            			'map[\'custName\']':custName,
	            			'map[\'custRegion\']':custRegion,
	            			'map[\'sysUser\']':sysUser,
	            			'map[\'custLevel\']':custLevel
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