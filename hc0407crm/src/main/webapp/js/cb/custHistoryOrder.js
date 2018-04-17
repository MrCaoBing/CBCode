layui.use('table', function() {
		var table = layui.table;
		var tatol = 0;
		//监听工具条
		table.on('tool(demo)', function(obj) {
			tatol = 0
			var data = obj.data;
			var ordersLine;
			
			
			var OrdersLineHtml = "";
			if (obj.event === 'minxi')
				
				if($("#ordersLineTr"+data.odrId).length > 0){
					$("#ordersLineTr"+data.odrId).prev().removeClass("ordersTr");
					$("#ordersLineTr"+data.odrId).remove();				
				}else{
					
					$(this).parents("tr").after(
							"<tr id='ordersLineTr"+data.odrId+"'>"+
							"<td class='ordersLineTd' colspan='6'><div class='ordersLineDiv'>"+							
								"<table id='ordersLinrTab' class='layui-table'>"+
									"<tr>"+
										"<th width='300px' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;商品</th>"+
										"<th width='120px' >&nbsp;&nbsp;数量</th>"+
										"<th width='120px' >&nbsp;&nbsp;单位</th>"+
										"<th width='120px' >&nbsp;&nbsp;单价（元）</th>"+
										"<th width='150px' >&nbsp;&nbsp;金额（元）</th>"+								
									"</tr>"+
									"<tr id='ordersLinrHead"+data.odrId+"'>"+
										"<td colspan='5'>&nbsp;&nbsp;&nbsp;订单总额:￥<strong id='tatol"+data.odrId+"'></strong></td>"+
									"</tr>"+
								"</table></div></td>"+	
						"</tr>")			
						$.get("listOrdersLine.do?ordId="+data.odrId,function(ord){								
							OrdersLineHtml = "";
							for (var i in ord) {
								tatol += (ord[i].oddCount*ord[i].product.prodPrice);
								OrdersLineHtml += 
								"<tr id='ordersLinrHead'>"+
									"<td>&nbsp;&nbsp;&nbsp;"+ord[i].product.prodName+"</th>"+
									"<td>&nbsp;&nbsp;&nbsp;"+ord[i].oddCount+"</th>"+
									"<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ord[i].product.prodUnit+"</th>"+
									"<td>&nbsp;&nbsp;&nbsp;"+ord[i].product.prodPrice+"</th>"+
									"<td>&nbsp;&nbsp;&nbsp;￥"+(ord[i].oddCount*ord[i].product.prodPrice).toFixed(2)+"</th>"+
								"<tr>";
							}
							$("#ordersLineTr"+data.odrId).prev().addClass("ordersTr");
							$("#ordersLinrHead"+data.odrId).after(OrdersLineHtml);
							$("#tatol"+data.odrId).text(tatol.toFixed(2))		
					});
				}
				
		}); 
			
	});