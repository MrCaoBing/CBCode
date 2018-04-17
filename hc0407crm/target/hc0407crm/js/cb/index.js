/**
 * Created by Administrator on 2018/1/7.
 */
$(function(){
    $('#rights').tree({
        onClick: function(node){
            if($('#rights').tree("isLeaf",node.target)){

            }
        }
    });

    layui.use('element', function(){
        var element = layui.element;
    });
    $(".layui-nav-child a").click(function(){
        var title = $(this).text();
        var pageUrl = $(this).attr("pageUrl");
        if ($("#optionTabs").tabs("exists", title)) {
            //如果存在，则选项该选项卡
            $("#optionTabs").tabs("select", title);
        } else {
            //如果不存在，则添加选项卡
            $("#optionTabs")
                .tabs("add",{
                    title : title,
                    content : "<iframe src='"
                    + pageUrl
                    + "' width='100%' height='100%' frameborder='0' scrolling='yes'><iframe>",
                    closable : true
                });
        }
    });
});