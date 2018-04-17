//将表格配置封装成对象
    var custInfoTab = {
        	id:'tab'
          ,elem: '#lostTable'
          ,url:'listCstLost.do'
          ,page:true
          ,skin: 'row'
          ,method:'POST'
          ,even: true
          ,limits:[7,10,15]
          ,limit:10
          ,page: {
        	    curr: 1 //重新从第 1 页开始
        		}              
          ,cols: [[ //表头
            {field:'lstId', width:50,title:'ID'}
           ,{field:'lstLastOrderDate', width:100,title:'上次下单时间',sort: true}
           ,{field:'custName', width:190,title:'客户名称',templet:function(d){
        	  return d.cstCustomer.custName;
           }}
           ,{field:'cstCustomer', width:150,templet:function(d){return d.cstCustomer.sysUser.usrName},title:'客户经理'}
           ,{field:'lstDelay', width:200,title:'挽留措施'}
           ,{field:'lstStatus', width:200,title:'状态',templet:function(d){
        	   if(d.lstStatus == 1){
        		   return '预警';
        	   } else if(d.lstStatus == 2){
        		   return '暂缓';
        	   } else if(d.lstStatus == 3){
        		   return '流失';
        	   }
           }}
           ,{fixed: 'right', width:140, align:'center', toolbar: '#barDemo',title:'操作'}
          ]]
        };
    	var table;
        layui.use('table', function(){
        	table = layui.table;
        	table.init('custTab',custInfoTab);
            //监听工具条
            table.on('tool(custTab)', function(obj){
                var data = obj.data; 
                if (data.cstCustomer.sysUser.usrId != $("#usrId").val()) {
                	layer.open({
  					  title: '系统提示'
  					  ,shadeClose:true
  					 ,offset: 'auto'
  					  ,shade: [0, 'rgba(250, 248, 255, 0)']
  					  ,content:'强制:每个客户经理只能对自己的客户进行流失或暂缓操作!'
  					  ,btn: ['确定']
  					});
          		  return;
                }
               if(obj.event === 'rescue') {
            	   if(data.lstStatus == 3){
			    		  layer.msg("该客户已流失,不可暂缓,好好维护现有客户吧!");
			    		  return;
			    	  }
            	   layer.open({
 					  title: '添加暂缓措施'
 					  ,shadeClose:true
 					 ,offset: 'auto'
 					  ,shade: [0, 'rgba(250, 248, 255, 0)']
 					  ,content:' <textarea id="lstDelay" cols="30" rows="10">'+data.lstDelay+'</textarea>'
 					  ,btn: ['确定']
 				      ,yes: function(index, layero){
 				    	  $.post("setCstLost.do", {lstDelay:$("#lstDelay").val(),lstId:data.lstId,lstStatus:2}, function(data) {
 								if (data > 0) {
 									layer.msg('修改成功!', {
 										time : 1500
 									});
 									table.init('custTab',custInfoTab);
 								} else {
 									layer.msg('修改失败:原因不明!', {
 										time : 2000
 									});
 								}
 							}); 
 					  } 
 					});
                 
              } else if(obj.event === 'lost') {
            	  if(data.lstStatus == 3){
		    		  layer.msg("该客户已流失,不可再次流失,好好维护现有客户吧!");
		    		  return;
		    	  }
            	  layer.open({
 					  title: '确认流失,添加流失原因'
 					  ,shadeClose:true
 					 ,offset: 'auto'
 					  ,shade: [0, 'rgba(250, 248, 255, 0)']
 					  ,content:' <textarea id="lostReason" cols="30" rows="10">没有添加流失原因!</textarea>'
 					  ,btn: ['确定']
 				      ,yes: function(index, layero){
 				    	  $.post("setCstLost.do", {lostReason:$("#lostReason").val(),custNo:data.cstCustomer.custNo,custStatus:2,lstId:data.lstId,lstStatus:3}, function(data) {
 								if (data > 0) {
 									layer.msg('修改成功!', {
 										time : 1500
 									});
 									table.init('custTab',custInfoTab);
 								} else {
 									layer.msg('修改失败:原因不明!', {
 										time : 2000
 									});
 								}
 							}); 
 					  } 
 					});
              }         
            }); 
            //初始化页面
            $('.tableInit').on('click', function(){
            	//如果用户选择查询
				if($(this).attr('query') == 'query'){
					//拿到条件参数
					var custName = $('#custName').val();
					var sysUser = $('#sysUser option:selected').val();
					var lstStatus = $('#lstStatus').val();
					//为配置对象添加新属性，传递参数
	            	custInfoTab.where = {
	            			'map[\'custName\']':custName,
	            			'map[\'userNo\']':sysUser,
	            			'map[\'lstStatus\']':lstStatus
	            	}
	            	
				} else {
					custInfoTab.where = {};
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
        
        
        
        
        