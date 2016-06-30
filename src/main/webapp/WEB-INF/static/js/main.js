function getContextPath() {
    var contextPath = document.location.pathname;
    var index =contextPath.substr(1).indexOf("/");
    contextPath = contextPath.substr(0,index+1);
    delete index;
    return contextPath;
}

var webapp = getContextPath();

$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

function checkList(form,names){
    for(key in form){
        var list = new Array();
        for(var i=0;i<names.length;i++){
            var name =names[i];
            if(key==name){
                if(!isArray(form[key])){
                    if(form[key]!=null||form[key]!=''){
                        list.push(form[key]);
                    }
                    delete form[name];
                    form[name]=list;
                }
            }
        }
    }
    return form;
};

function isArray(obj) {
    return Object.prototype.toString.call(obj) === '[object Array]';
};

function formatDateTime(date) {
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    m = m < 10 ? ('0' + m) : m;
    var d = date.getDate();
    d = d < 10 ? ('0' + d) : d;
    var h = date.getHours();
    var minute = date.getMinutes();
    minute = minute < 10 ? ('0' + minute) : minute;
    return y + '-' + m + '-' + d+' '+h+':'+minute;
};

function formatDate(date) {
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    m = m < 10 ? '0' + m : m;
    var d = date.getDate();
    d = d < 10 ? ('0' + d) : d;
    return y + '-' + m + '-' + d;
};

//处理图片加载失败默认图片
function imgError(o){
    o.src=webapp+"/static/img/error.png";
}

function displayResult(item, val, text) {
    console.log(item);
    $('.alert').show().html('You selected <strong>' + val + '</strong>: <strong>' + text + '</strong>');
}

$(function(){
    jQuery.each(jQuery("img"), function (i, n) {
        jQuery(n).error(function () { n.src = webapp+'/static/img/error.jpg'; });
        n.src = n.src;
    });
})


