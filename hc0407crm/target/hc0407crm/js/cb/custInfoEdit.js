var ifSubmit = false;
//修改之前的名字
$(function(){
	$(".reset").click();
})
layui.use('form', function(){
            var form = layui.form;
            form.verify({
       	  	 ifName:function(value, item){
       	        	if(ifSubmit){
       	        		return "客户已存在!";
       	        	}
       	  	  }
       	  	});   
            //监听提交
            form.on('submit(formDemo)', function(data){
                layer.msg('表单提交');
                if($("#addOrSet").text() == '添加'){
                	//添加客户
                	$.post("addCstCustomer.do",data.field,function(data){
                		if(data > 0){
                			$(".reset").click();
                			layer.msg('添加成功！您希望?(10秒后自动关闭)', {
                		        time: 10000, //10s后自动关闭                		     
                		        btn: ['回到主页', '继续添加'],
                		        btn1: function(index, layero){
                		            location.href="jsp/custInfoManager.jsp";
                		          }
                		      }); 
                		}else{
                			layer.msg('修改失败:原因不明,请仔细核查数据后继续提交！',{ time: 3000});
                		}
                	});
                }else{
                	//修改客户
                	$.post("setCstCustomer.do",data.field,function(data){
                		if(data > 0){
                			layer.msg('修改成功！您希望?(10秒后自动关闭)', {
                		        time: 10000, //10s后自动关闭                		     
                		        btn: ['回到主页', '继续修改'],
                		        btn1: function(index, layero){
                		            location.href="jsp/custInfoManager.jsp";
                		          }
                		      }); 
                		}else{
                			layer.msg('修改失败:原因不明,请仔细核查数据后继续提交！',{ time: 3000});
                		}
                	});
                }
                return false;
            });
        });   
 

 layui.use('layer', function() {
 	var layer = layui.layer;
 	$(function() {
 		$("#custName").change(function() {
 			var custName = $("#custName").val();
 			//如果该用户是修改并且没有改变名字
 			if($("#custNameRe").val() == custName) return;
 			$.ajax({
 	  			url:"idOnCustomerIfExists.do",
 	  			type:'POST',
 	  			async:false,
 	  			data:{custName:custName},
 	  			success:function(data){
 	        		if(data != ''){	        			
 	        			ifSubmit = true;
 						layer.msg('该客户已存在!');
 					} else {
 						ifSubmit = false;
 					}
 	  			}
 	  		});   
 		})
 	})
 });