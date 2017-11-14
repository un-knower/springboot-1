var List = new Array();//定义一个全局变量去接受文件名和id
var strArray=new Array();
$(function(){
     $.ajax({
        url:"/activity/getClassName",
         type:"post",
        dataType:'json',
        success:function(data){
            var str="";
            $.each(data,function(index,result){
                if(result.classId==$("#classHidden").val()){
                    str+="<option value='"+result.classId+"' selected='selected'>"+result.gradeName+result.className+"</option>";
                }else{
                    str+="<option value='"+result.classId+"'>"+result.gradeName+result.className+"</option>";
                }
           });
          $("#classId").append(str);
       }
    });

    //初始化上传文件框
    $('#attachment').fileinput({
        showUpload : false,
        showRemove : false,
        uploadAsync: false,
        //uploadLabel: "上传",//设置上传按钮的汉字
        //uploadClass: "btn btn-primary",//设置上传按钮样式
        //showCaption: false,//是否显示标题
        language: "zh",//配置语言
        uploadUrl: "/upload/uploadActivity",
        maxFileSize : 0,
        maxFileCount: 1,/*允许最大上传数，可以多个，当前设置单个*/
        maxFilesNum :1,//上传最大的文件数量
        enctype: 'multipart/form-data',
        //allowedPreviewTypes : [ 'image' ],
        //allowedFileTypes: ['image', 'video', 'flash'],
        allowedFileExtensions : ["doc", "docx","xls","pptx","ppt","xlsx"],/*上传文件格式*/
        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
        //dropZoneTitle: "请通过拖拽图片文件放到这里",
        //dropZoneClickTitle: "或者点击此区域添加图片",
        uploadExtraData: {"locationType": "tnews"},//这个是外带数据
        //showBrowse: false,
        //browseOnZoneClick: true,
        dropZoneEnabled: false,//是否显示拖拽区域
        /* slugCallback: function (text) {
        	alert(text);
            return String(text).replace(/[\-\[\]\/\{}:;#%=\(\)\*\+\?\\\^\$\|<>&"',]/g, '_');
        }, */
        layoutTemplates:{
            actionUpload:'',
            //actionDelete:'',
            //actionView:'',

        }
    });
    //文件上传成功，回调函数
    $('#attachment').on("filebatchuploadsuccess", function(event, data, previewId, index) {
        var list=eval("("+JSON.stringify(data)+")").response;
       if(list.success=='0'){
            alert(list.msg);
            return false;
        }else{
           $.each(list.list,function(index,data){
               List.push(data);
           });
        }
    });

});
var tempInveral;
function submitForm(){
    if (!$('#form').Validform()) {
        return false;
    }
    var fileCount = $('#attachment').fileinput('getFilesCount');
    if(fileCount == 0){ //没有附件
        submitFormSave();
    }else{
        $("#attachment").fileinput('upload'); //调用文件上传,在文件上传成功后的回调函数中保存表单
    }
    tempInveral = setInterval(function(){
        if(List.length > 0){
            submitFormSave();
        }
    },1000);
}

function submitFormSave(){
    clearInterval(tempInveral);
    if(List==null||List.length==0){
        strArray.push($("#hiddenUrl").val());
        $('#fileUrl').val(JSON.stringify(strArray));
    }else{
        $('#fileUrl').val(JSON.stringify(List));//拿到后台传回来的id，给图片的id赋值序列化表单用
    }
        $.ajax({
            url: '/schedule/scheduleEdit',
            data:$('#form').serialize(),// 你的formid
            type:"POST",
            dataType:'json',
            async: false,
            error:function(){},
            success : function(data) {
                if (data){
                    $.messager.alert("成功消息", "修改成功");
                    parent.$('#data_dg').datagrid('reload');
                    parent.$('#data_dialog').dialog('close');
                } else {
                    $.messager.alert("错误消息", "修改失败");
                }
            }
        });
}
