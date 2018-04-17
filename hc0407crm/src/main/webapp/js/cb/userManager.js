//将表格配置封装成对象
var table;
var ifName;
//加载角色信息  
$.get("listSysRole.do",function(data){
	var roleOption = "";
	for(var a in data.data){
		roleOption += '<option value="'+data.data[a].roleId+'">'+data.data[a].roleName+'</option>';
	}
	$(".usrRole").html(roleOption);
});
    var custInfoTab = {
        	id:'tab'
          ,elem: '#userTab'
          ,id:'userTabId'
          ,url:'listSysUser.do'
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
            {field:'usrId', width:250,title:'编号'}
           ,{field:'usrName', width:290,title:'名称',edit:'text'}
           ,{field:'sysRole', width:292,title:'角色',templet:function(d){
        	   return d.sysRole!=null?'<span class="sysRole">'+d.sysRole.roleName+'</span>':''}}
           ,{fixed: 'right', width:140, align:'center', toolbar: '#barDemo',title:'操作'}
          ]]
        };
    	
        layui.use('table', function(){
        	table = layui.table;
        	table.init('userTab',custInfoTab);
            //初始化页面
            $('.tableInit').on('click', function(){
            	//如果用户选择查询
				if($(this).attr('query') == 'query'){
					//拿到条件参数
					var usrName = $('#queryName').val();
					//为配置对象添加新属性，传递参数
	            	custInfoTab.where = {
	            			'map[\'usrName\']':usrName
	            	}
	            	
				} else {
					custInfoTab.where = {};
				}           
            	//初始化表格，custInfoTab为上文的配置对象
				table.init('userTab',custInfoTab);
            	 //保持分页居中
            	$(".layui-table-page *").css("text-align", "center");         	 
            });
            
         // 监听工具条
        	table.on('tool(userTab)', function(obj) {
        		var data = obj.data;
        		if (obj.event === 'del') {
        			layer.confirm('真的删除该用户吗', function(index) {
        				// ajax传递数据
        				$.post("setSysUser.do?usrId=" + data.usrId+"&usrFlag="+0, function(data) {
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
        		}else if(obj.event === 'updPwd'){
        			layer.open({
        				type:1,
        				title:'请设置'+data.usrName+'的新密码',
        				shadeClose : true,
        				area: ['250px', '230px'],
        				shade : [ 0, 'rgba(250, 248, 255, 0)' ],
        				content : '<form class="layui-form" lay-filter="fromUsrPwd" id="fromUsrPwd">'
        								+'<input type="password" id="usrPwd1" maxlength="20" placeholder="请输入新密码(必填)" lay-verify="required" class="layui-input">'
        								+'<input type="password" id="usrPwd2" maxlength="20" placeholder="请确认新密码(必填)" lay-verify="required" class="layui-input">'
        							+'</form>'	,        				
        				btn: ['确认修改密码'],
        		        btn1: function(index, layero){
        		        	var ifSet = true;
        		        	if($("#usrPwd1").val() == '' || $("#usrPwd2").val() == ''){
        		        		layer.msg('密码能不为空!', {
        							time : 1500,
        						});       		               		        		
        		        		ifSet = false;
        		        		return;
        		        	}
        		        	if($("#usrPwd1").val() != $("#usrPwd2").val()){
        		        		layer.msg('两次密码需要一致!', {
        							time : 1500,
        						});       		               		        		
        		        		ifSet = false;
        		        		return;
        		        	}
        		        	
        		        	if(!/^[1-9a-zA-Z\.@]{6,12}$/.test($("#usrPwd1").val())){
        		        		layer.msg('密码只能为数字和字母与.@符号,并且6至12个字符!', {
        							time : 1500,
        						});       		               		        		
        		        		ifSet = false;
        		        		return;
        		        	}
        		        	if(ifSet){
        		        		layer.close(1);
        		        		$.post("setSysUser.do",{usrId: data.usrId,usrPwd:$("#usrPwd1").val()}, function(data) {
                					if (data > 0) {               						
                						layer.msg('修改成功!', {
                							time : 1500,
                						});
                					} else {
                						layer.msg('修改失败:原因不明!', {
                							time : 2000
                						});
                					}
                				});
        		        	}       		        	
        		       }
        			});
        		}
        	});
        	function loadPage(){
        		table.reload('userTabId');
        	}
        	 // 监听单元格编辑
        	table.on('edit(userTab)', function(obj) {
        		var value = obj.value // 得到修改后的值
        		, data = obj.data // 得到所在行所有键值
        		, field = obj.field; // 得到字段
        		var updateSB = false;
        		if (field == "usrName") {
        			if (value == "") {
        				layer.msg('用户名不能为空,该修改不生效!');
        				updateSB = true;
        			}
        			if(ifNameExists(value)){
        				updateSB = true;
        			}
        		}
        		if(updateSB){
        			setTimeout(loadPage,1000);//延时1秒       			
        			return;
        		}
        		$.post("setSysUser.do", eval('({' + field + ':"' + value
        				+ '",usrId:"' + data.usrId + '"})'), function(data) {
        			if (data > 0) {
        				layer.msg('修改成功!', {
        					time : 1500,
        				});
        			} else {
        				layer.msg('修改失败:原因不明!', {
        					time : 2000
        				});
        			}
        		});
        	});
        	
        });
        
        
      
    	$(document).on("click",".sysRole",function(event){
    		var sysRoleId = $(this)
    		$("#selectRo option").attr("selected",false)
    		$("#selectRo option:contains("+$(this).text()+")").attr("selected",true)
    		layer.open({
    			type: 1, 
    			title:false,
				shadeClose : true,
				offset : [ getTop(this)-12, getLeft(this) -16],
				area: ['293px', '38px'],
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
    			  $.post("setSysUser.do", eval('({roleId:"' + data.value
          				+ '",usrId:"' + id + '"})'), function(data) {
          			if (data > 0) {
          				layer.msg('修改成功!', {
          					time : 1500,
          				});
          			} else {
          				layer.msg('修改失败:原因不明!', {
          					time : 2000
          				});
          			}
          		});
    			});      
    	});
    	

    	var form;
        layui.use('form', function(){
            form = layui.form;
            form.verify({
            	  username: function(value, item){ //value：表单的值、item：表单的DOM对象
            	    if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
            	      return '用户名不能有特殊字符';
            	    }
            	    if(/(^\_)|(\__)|(\_+$)/.test(value)){
            	      return '用户名首尾不能出现下划线\'_\'';
            	    }
            	    if(/^\d+\d+\d$/.test(value)){
            	      return '用户名不能全为数字';
            	    }
            	  } 
            	  ,pass: [
            	    /^[\S]{6,12}$/
            	    ,'密码必须6到12位，且不能出现空格'
            	  ]
            	  ,pwdRe:function(value, item){
            		  if($("#usrPwd").val() != value) {
            		    return '两次输入的密码需一致!';
            		  }
            	  }
            	  ,ifName:function(value, item){
                  	if(ifNameExists(value)){
                  		return "该用户名已经被使用!";
                  	}
            	  }
            	});      
            //监听提交
            form.on('submit(formDemo)', function(data){
            	if(ifName) return;
        		layer.msg("正在向后台提交数据！");
        		// 添加客户
        		$.post("addSysUser.do", data.field, function(data) {
        			if (data > 0) {
        				layer.msg('添加成功');
        				$(".layui-laypage-btn").click();
        			} else {
        				layer.msg('添加失败:原因不明,请仔细核查数据后继续提交！', {
        					time : 3000
        				});
        			}
        		});
        		return false;
        	});                        
        });
        
        
        layui.use('layer', function() {
        	var layer = layui.layer;
        	$(function() {    
        		 $("#usrName").blur(function(){
     	        	if($(this).val() == ""){
     	        		return;
     	        	} 
     	        	ifNameExists($(this).val())     	        		 	        			
        		 });
        	})
        });
        
      function ifNameExists (name){ 
    	  		$.ajax({
    	  			url:"ifNameExists.do",
    	  			async:false,
    	  			data:{usrName:name},
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
    	
    	$(".sysRole").click();