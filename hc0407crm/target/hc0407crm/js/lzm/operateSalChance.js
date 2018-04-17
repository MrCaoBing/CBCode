var flag=true;
$(function() {
	layui.use('form', function() {
		var form = layui.form;
		// 监听提交
		form.on('submit(formDemo)', function(data) {
				$.post("addSalChanceInfo", data.field, function(result) {
					if (result > 0) {
						layer.msg("添加成功!", {
							btn : [ '继续添加', '返回' ],
							title : '10秒后自动关闭',
							time : 10000,
							btn2 : function() {
								location.href = 'jsp/salChanceManager.jsp'
							}
						});
					} else {
						layer.msg("添加失败!", {
							btn : [ '继续添加', '返回' ],
							title : '10秒后自动关闭',
							time : 10000,
							btn2 : function() {
								location.href = 'jsp/salChanceManager.jsp'
							}
						});
					}
				})
			return false;
		});
		form.verify({
			chcRate : function(value, item) {
				/*
				 * /^\d[0-100]$//
				 */
				if (!/^(0|1|[1-9]\d|100)$/.test(value)) {
					return "成功几率只能是数字,并数值为0-100";
				}
			},chcCustName:function(value,item){
				if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
				      return '客户名不能有特殊字符';
				    }
				    if(/(^\_)|(\__)|(\_+$)/.test(value)){
				      return '客户名首尾不能出现下划线\'_\'';
				    }
				    if(flag==false){
				    	return "客户名称已存在!";
				    }
				   /* if(/^[\u4e00-\u9fa5\\w]+$/.test(value)){
				      return '客户名只能为汉字';
				    }*/
				
			},chcMobile:function(value,item){
				if(value!=null&&value!=""){
					if(!/^0?(13[0-9]|15[012356789]|17[013678]|18[0-9]|14[57])[0-9]{8}$/.test(value)){
						return "电话格式不正确!";
					}
				}
			},chcLinkman:function(value,item){
				if($("[name=chcMobile]").val()!=""){
					if(value==""){
						return "请填写联系人!";
					}
					if(value=="null"){
						return "联系人填写错误!";
					}
				}
			}
			
		});
	});
});
function checkName() {
	if($("[name=chcCustName]").val()!=""){
		if ($("[name=chcCustName]").val()!="null") {
			$.post("findCheckchcCustName", {
				chcCustName : $("[name=chcCustName]").val()
			}, function(result) {
				if (result == 0) {
					layer.msg('该用户名可用');
					flag=true;
				} else {
					flag=false;
					layer.msg('该用户名已存在', function() {
					});
				}
			});
		}else{
			layer.msg('客户名称不正确!', function() {
			});
		}
	}
}