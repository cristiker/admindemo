var table;
var param;

function showDetail(id){
    window.location.href=webapp+"/visitor/detail?id="+id;
}

$(function(){
    function refresh(){
        table.draw();
    }

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
            url: webapp+"/visitor/querydata",
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
                        html='';
                        /*html+= '<button type="button" class="btn btn-default btn-sm">冻结</button>';*/
                        html+= '<button type="button" onclick="showDetail('+row.id+')" class="btn btn-default btn-sm">详情</button>'
                    }else if(row.status==2){
                        html='';
                       /* html += '<button type="button" class="btn btn-default btn-sm">解冻</button>'*/
                        html+= '<button type="button" onclick="showDetail('+row.id+')" class="btn btn-default btn-sm">详情</button>'
                    }
                    return html;
                }
            }]
    } );

})