var table;
var param;

function showdetail(id){
    window.location.href=webapp+"/guide/detail?id="+id;
}

function verify(id){
    window.location.href=webapp+"/guide/toverify?id="+id;
}

$(function(){
    function refresh(){
        table.draw();
    }

    //禁用
    $("#dtable").on("click",".lock", function () {
        var id = $(this).attr("data");
        $.ajax({
             url:webapp+"/guide/lock",
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

    //解禁
    $("#dtable").on("click",".unlock", function () {
        var id = $(this).attr("data");
        $.ajax({
            url:webapp+"/guide/unlock",
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

    $("#search").click(function(){
        refresh();
    })

    var table = $('#dtable').DataTable( {
        processing: false,
        serverSide: true,
        lengthChange:false,
        searching:false,
        ordering:false,

        ajax: {
            url: webapp+"/guide/querydata",
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
                    if(row.phone){
                        return row.phone;
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
                        return "禁用";
                    }else if(row.status==3){
                        return "已拒绝";
                    }else if(row.status==4){
                        return "待审核";
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
                        html= '<button type="button" data="'+row.id+'" class="btn btn-default btn-sm lock">禁用</button>';
                        html+='<button type="button" data="'+row.id+'" onclick="javascript:showdetail('+row.id+')" class="btn btn-default btn-sm">详情</button>'
                    }else if(row.status==2){
                        html = '<button type="button" data="'+row.id+'" class="btn btn-default btn-sm unlock">解禁</button>';
                        html+='<button type="button" data="'+row.id+'" onclick="javascript:showdetail('+row.id+')" class="btn btn-default btn-sm">详情</button>'
                    }else if(row.status==4){
                        html = '<button type="button" data="'+row.id+'" onclick="javascript:verify('+row.id+')" class="btn btn-default btn-sm">审核</button>';
                    }
                    return html;
                }
            }]
    } );

})