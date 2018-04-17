$(function(){
            $('#rights').tree({
                onClick: function(node){
                    if($('#rights').tree("isLeaf",node.target)){
                        var a = $(node.target).children();
                        var title = $(node.target).text();
                        var pageUrl = $(a[4]).children().attr("pageUrl");
                        if ($("#optionTabs").tabs("exists", title)) {
                            //3.如果存在，则选项该选项卡
                            $("#optionTabs").tabs("select", title);
                        } else {
                            //4.如果不存在，则添加选项卡
                            $("#optionTabs")
                                .tabs("add",{
                                        title : title,
                                        content : "<iframe src='"
                                        + pageUrl
                                        + "' width='100%' height='100%' frameborder='0' scrolling='yes'><iframe>",
                                        closable : true
                                    });
                        }
                    }
                }
            });
        });