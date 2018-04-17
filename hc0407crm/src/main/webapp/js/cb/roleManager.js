//将表格配置封装成对象
var table;
var ifName;
var form;
var roleName;
var ifUpdate = false;
var ifIniClick = false;

$(function(){
	$(".reset").click(function(){
		roleName = "";
		ifUpdate = false;
		$("#editOradd").text("添加")
	});
});
    var custInfoTab = {
        	id:'tab'
          ,elem: '#roleTab'
          ,height:'250px'
          ,id:'roleTabId'
          ,url:'listSysRole.do'
          ,skin: 'row'
          ,method:'POST'
          ,even: true            
          ,cols: [[ //表头
            {field:'roleId', width:250,title:'编号'}
           ,{field:'roleName', width:280,title:'名称'}
           ,{field:'roleDesc', width:302,title:'备注'}
           ,{fixed: 'right', width:140, align:'center', toolbar: '#barDemo',title:'操作'}
          ]]
        };
    	
        layui.use('table', function(){
        	table = layui.table;
        	table.init('roleTab',custInfoTab);
            //初始化页面
            $('.tableInit').on('click', function(){
            	//如果用户选择查询
				if($(this).attr('query') == 'query'){
					//拿到条件参数
					var usrName = $('#usrName').val();
					//为配置对象添加新属性，传递参数
	            	custInfoTab.where = {
	            			'map[\'roleName\']':roleName
	            	}	            	
				} else {
					custInfoTab.where = {};
				}           
            	//初始化表格，custInfoTab为上文的配置对象
				table.init('roleTabId',custInfoTab);
            	 //保持分页居中
            	$(".layui-table-page *").css("text-align", "center");         	 
            });
            $(".layui-form-checked").click();
            ifIniClick = true;
         // 监听工具条
        	table.on('tool(roleTab)', function(obj) {
        		var data = obj.data;
        		var roleId = data.roleId;        		
    			var roleDesc = data.roleDesc;
        		if (obj.event === 'del') {
        			layer.confirm('警告：真的弃用该角色吗,一旦弃用，所属用户将失去所有权限!可以通过更改用户角色来挽回！', function(index) {
        				// ajax传递数据
        				$.post("setSysRole.do?roleId=" + data.roleId+"&roleFlag="+0, function(data) {
        					if (data > 0) {
        						layer.msg('删除成功!', {
        							time : 1500,
        						});
        						obj.del();
        					} else {
        						layer.msg('删除失败:原因不明!', {
        							time : 2000
        						});
        					}
        				});
        			});       			
        		} else if (obj.event === 'edit') {
        			roleName = data.roleName;
        			$.ajax({
        	  			url:"listSysRightById.do",
        	  			data:{roleId:data.roleId},
        	  			success:function(data){
        	        		layer.msg("页面下方进入编辑状态,点击取消可退出!", {
    							time : 2000
    						});   
        	        		ifUpdate = true;       	        		
        	        		$("#roleId").val(roleId);
        	        		$("#roleName").val(roleName);
        	        		$("#roleDesc").val(roleDesc);
        	        		$("#editOradd").text("修改")
        	        		 
        	        		ifIniClick = false;
        	        		$(".layui-form-checked").click();
        	        		for(var a in data){
        	        			$("input[value="+data[a].rightCode+"]").each(function(index,domEle){
            	        			$(domEle).next(".layui-form-checkbox").click();
            		    		});	
        	        		}
        	        		ifIniClick = true;
        	  			}
        	  		});   
        		}
        	});   	
        });
        
        
        function ifNameExists (name){ 
        	if(roleName === name) return;
	  		$.ajax({
	  			url:"ifRoleNameExists.do",
	  			type:'POST',
	  			async:false,
	  			data:{roleName:name},
	  			success:function(data){
	        		if(data > 0){
	        			layer.msg("该用户名已经被使用!");
	        			ifName = true;
	        		}else{
	        			ifName = false;
	        		}
	  			}
	  		});   
	  		return ifName;
        }
    	
       
        layui.use('layer', function() {
        	var layer = layui.layer;
        	$(function() {    
        		 $("#roleName").blur(function(){
     	        	if($(this).val() == ""){
     	        		return;
     	        	} 
     	        	ifNameExists($(this).val())     	        		 	        			
        		 });
        	})
        });
    	
        layui.use('form', function(){
            form = layui.form; 
            form.verify({
          	  ifName:function(value, item){
                	if(ifNameExists(value)){
                		return "该用户名已经被使用!";
                	}
          	  }
          	});    
            
            //用来控制权限的合理性
            form.on('checkbox(right)', function(data){
                console.log(data.elem); //得到checkbox原始DOM对象
                console.log(data.elem.checked); //是否被选中，true或者false
                if(ifIniClick){
                	if($(data.elem).parent().attr("class") == "parentRight" && data.elem.checked == true){
                		if($(data.elem).parent().next().children(".layui-form-checked").length == 0){
                			$(data.elem).parent().next().children(".layui-form-checkbox").click();
                		}
                    }else if($(data.elem).parent().attr("class") == "parentRight" && data.elem.checked == false){
                    	$(data.elem).parent().next().children(".layui-form-checked").click();	      
                    }else if($(data.elem).parent().attr("class") == "childrenRight" && data.elem.checked == false){
                    	if($(data.elem).parent().children(".layui-form-checked").length == 0){
                        	$(data.elem).parent().prev().children(".layui-form-checked").click();	
                    	}                    	
                    }else if($(data.elem).parent().attr("class") == "childrenRight" && data.elem.checked == true){
                    	if($(data.elem).parent().prev().children(".layui-form-checked").length == 0){
                        	$(data.elem).parent().prev().children(".layui-form-checkbox").click();	
                    	}                    	
                    }              	
                }
                
               // form.render(); //刷新select选择框渲染
              });        
            //监听提交
            form.on('submit(formDemo)', function(data){
            	if(ifName) return;
        		layer.msg("正在向后台提交数据！");
        		var rightArr = ""
        		var rightArrLength = $("#roleTab .layui-form-checked").length;
        		$("#roleTab .layui-form-checked").each(function(index,domEle){      				
        			rightArr += $(domEle).prev().val();
        			if((rightArrLength-1) > index){
        				rightArr += ','
        		 }
                });	
        		data.field.rightArr = rightArr;
        		if(ifUpdate){
        			$.ajax({
						url: "setRoleRight.do",
						type: "post",
						data: data.field,
						dataType: "json",
						success: function (data) {
							if(data > 0){
	                			layer.msg('修改成功');   
	                			table.reload('roleTabId');
	                			$(".reset").click();
	                		}else{
	                			layer.msg('修改失败:原因不明,请仔细核查数据后继续提交！',{ time: 3000});
	                			table.reload('roleTabId');
	                		}
						}
					});
        			
        		}else{        			        	      			
        			 $.ajax({
							url: "addRoleRight.do",
							type: "post",
							data: data.field,
							dataType: "json",
							success: function (data) {
								if(data > 0){
		                			layer.msg('添加成功');   
		                			table.reload('roleTabId');
		                			$(".reset").click();
		                		}else{
		                			layer.msg('添加失败:原因不明,请仔细核查数据后继续提交！',{ time: 3000});
		                			table.reload('roleTabId');
		                		}
							}
						});        			
        		}
        		return false;
        	});          
        });

            
                  
       
