//datatable全局变量
var table;

//增加目的地
function addDestination(){
    window.location.href=webapp+"/destination/adddestination";
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

    //修改
    $("#dtable").on("click",".update", function () {
        var id = $(this).attr("data");
        window.location.href = webapp+"/destination/updatedestination?id="+id;
    })

    //详情
    $("#dtable").on("click",".detail", function () {
        var id = $(this).attr("data");
        window.location.href = webapp+"/destination/detail?id="+id;
    })

    //监听modal显示事件
    $('#mymodal').on('show.bs.modal', function (e) {

    })
    //监听modal关闭事件
    $('#mymodal').on('hide.bs.modal', function (e) {
        $(this).find('form')[0].reset();
    })

    //新增区域
    $("#save-user-btn").on("click", function () {
        $.ajax({
            url:webapp+"/destination/adddestination",
            type:"POST",
            data:$("#add-area-form").serializeObject(),
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
            url: webapp+"/destination/querydata",
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
                    if(row.destinationName){
                        return row.destinationName;
                    }else{
                        return "";
                    }
                }
            },
            {
                targets:1,
                render:function(data,type,row){
                    if(row.country){
                        return row.country;
                    }
                }
            },
            {
                targets:2,
                render:function(data,type,row){
                    if(row.state){
                        return row.state;
                    }
                }
            },
            {
                targets:3,
                render:function(data,type,row){
                    if(row.status){
                        if(row.status==1){
                            return "正常";
                        }else{
                            return "异常";
                        }
                    }
                }
            },
            {
                targets:4,
                render:function(data,type,row){
                    if(row.createTime){
                        return formatDateTime(new Date(row.createTime));
                    }else{
                        return "";
                    }
                }
            },
            {
                targets:5,
                render:function(data,type,row){
                    if(row.updateTime){
                       return formatDateTime(new Date(row.updateTime));
                    }else{
                        return "";
                    }
                }
            },
            {
                targets:6,
                render:function(data,type,row){
                    var html = "";
                    html+='<button type="button" class="btn btn-default btn-sm update" data="'+row.id+'">修改</button>';
                    html+='<button type="button" class="btn btn-default btn-sm detail" data="'+row.id+'">详情</button>';
                    return html;
                }
            }]
    } );

})
