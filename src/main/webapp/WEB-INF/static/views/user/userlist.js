//datatable全局变量
var table;

//增加管理员
function addUser(){
    $("#mymodal").modal("toggle");
}

$(function(){

    //刷新表格
    function refresh(){
        table.draw();
    }

    //查询按钮触发加载数据
    $("#search").click(function(){
        refresh();
    })

    //禁用管理员
    $("#dtable").on("click",".lock",function(){
        var id = $(this).attr("data");
        $.ajax({
            url:webapp+"/user/lock",
            data:{"id":id},
            type:"post",
            dataType:"json",
            success:function(data){
                if(data.success){
                    refresh();
                }else{
                    alert(data.msg);
                }
            }
        })
    })

    //解禁管理员
    $("#dtable").on("click",".unlock",function(){
        var id = $(this).attr("data");
        $.ajax({
            url:webapp+"/user/unlock",
            data:{"id":id},
            type:"post",
            dataType:"json",
            success:function(data){
                if(data.success){
                    refresh();
                }else{
                    alert(data.msg);
                }
            }
        })
    })

    //查看详细信息
    $("#dtable").on("click",".view",function(){
        var id = $(this).attr("data");
        window.location.href=webapp+"/user/detail?id="+id;
    })


    //监听modal显示事件
    $('#mymodal').on('show.bs.modal', function (e) {

    })
    //监听modal关闭事件
    $('#mymodal').on('hide.bs.modal', function (e) {
        $(this).find('form')[0].reset();
    })

    //新增管理员
    $("#save-user-btn").on("click", function () {
        $.ajax({
            url:webapp+"/user/adduser",
            type:"POST",
            data:$("#add-user-form").serializeObject(),
            dataType:"json",
            success: function (data) {
                if(data.success){
                    $("#mymodal").modal("hide");
                    refresh();
                }
            }
        })
    })

    var table = $('#dtable').DataTable( {
        processing: false,
        serverSide: true,
        lengthChange:false,
        searching:false,
        ordering:false,

        ajax: {
            url: webapp+"/user/querydata",
            type: "POST"
        },
        fnServerParams: function (aoData) {
            delete aoData.columns;
            delete aoData.search;
            param = $("#user-search").serializeObject();
            for(key in param){
                var value = param[key];
                if(param[key]!=""){
                    aoData[key]=param[key];
                }
            }
        },
        columnDefs:[
            {
                targets:0,
                render:function(data,type,row){
                    if(row.userName){
                        return row.userName;
                    }else{
                        return "";
                    }
                }
            },
            {
                targets:1,
                render:function(data,type,row){
                    if(row.email){
                        return row.email;
                    }else{
                        return "";
                    }
                }
            },
            {
                targets:2,
                render:function(data,type,row){
                    if(row.sex){
                        if(row.sex=="W"){
                            return "女";
                        }else{
                            return "男";
                        }

                    }else{
                        return "";
                    }
                }
            },
            {
                targets:3,
                render:function(data,type,row){
                    if(row.age){
                        return row.age;
                    }else{
                        return "";
                    }
                }
            },
            {
                targets:4,
                render:function(data,type,row){
                    if(row.status==1){
                        return "正常";
                    }else if(row.status==2){
                        return "冻结";
                    }else{
                        return "未知状态";
                    }
                }
            },
            {
                targets:5,
                render:function(data,type,row){
                    if(row.createTime){
                        return formatDateTime(new Date(row.createTime));
                    }else{
                        return "";
                    }
                }
            },
            {
                targets:6,
                render:function(data,type,row){
                    if(row.updateTime){
                        return formatDateTime(new Date(row.updateTime));
                    }else{
                        return "";
                    }
                }
            },
            {
                targets:7,
                render:function(data,type,row){
                    var html = "";
                    if(row.status==1){
                        html += '<button type="button" class="btn btn-default btn-sm lock" data="'+row.id+'">禁用</button>';
                        html += '<button type="button" class="btn btn-default btn-sm view" data="'+row.id+'">查看</button>';
                    }else if(row.status==2){
                        html += '<button type="button" class="btn btn-default btn-sm unlock" data="'+row.id+'">解禁</button>';
                        html += '<button type="button" class="btn btn-default btn-sm view" data="'+row.id+'">查看</button>';
                    }
                    return html;
                }
            }]
    } );

})
