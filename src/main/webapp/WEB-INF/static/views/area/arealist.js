//datatable全局变量
var table;

//
function addState(){

    $("#modal-title").html("添加洲");
    $("#model-type").val(1);
    $("#model-parentId").val("0");
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

    $("#dtable").on("click",".add-country", function () {
        $("#modal-title").html("添加国家");
        var id = $(this).attr("data");
        $("#model-type").val(2);
        $("#model-parentId").val(id);
        $("#mymodal").modal("toggle");
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
            url:webapp+"/area/addarea",
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
            url: webapp+"/area/querydata",
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
                    if(row.type){
                        if(row.type==1){
                            return "大洲";
                        }else if(row.type==2){
                            return "国家";
                        }else{
                            return "";
                        }
                    }else{
                        return "";
                    }
                }
            },
            {
                targets:1,
                render:function(data,type,row){
                    if(row.areaName){
                        return row.areaName;
                    }else{
                        return "";
                    }
                }
            },

            {
                targets:2,
                render:function(data,type,row){
                    var html = "";
                    if(row.type==1){
                        html += '<button type="button" class="btn btn-default btn-sm add-country" data="'+row.id+'">添加国家</button>';
                    }
                    return html;
                }
            }]
    } );

})
