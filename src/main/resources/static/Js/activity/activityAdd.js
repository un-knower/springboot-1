var List = new Array();//定义一个全局变量去接受文件名和id
$(function(){
    $.ajax({
        url:"/activity/getClassName",
        type:"post",
        dataType:'json',
        success:function(data){
            var str="<option value='-1'>全校级</option>";
            $.each(data,function(index,result){
                str+="<option value='"+result.classId+"'>"+result.gradeName+result.className+"</option>"
            });
            $("#classId").append(str);
        }
    });
    //初始化富文本
    UE.getEditor('editor', {
        toolbars: [
            [
                'source', //源码
                'undo', //撤销
                'bold', //加粗
                'italic', //斜体
                'underline', //下划线
                'strikethrough', //删除线
                'formatmatch', //格式刷
                'selectall', //全选
                'print', //打印
                'link', //超链接
                'unlink', //取消链接
                'fontfamily', //字体
                'fontsize', //字号
                'simpleupload', //单图上传
                'insertimage', //多图上传
                'help', //帮助
                'justifyleft', //居左对齐
                'justifyright', //居右对齐
                'justifycenter', //居中对齐
                'justifyjustify', //两端对齐
                'forecolor', //字体颜色
                'backcolor', //背景色
                'touppercase', //字母大写
                'tolowercase', //字母小写
            ]
        ],
        autoHeightEnabled: false,
        autoFloatEnabled: true,
        initialFrameWidth : 715,
        initialFrameHeight: 590
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
        maxFileCount: 5,/*允许最大上传数，可以多个，当前设置单个*/
        maxFilesNum : 5,//上传最大的文件数量
        enctype: 'multipart/form-data',
        //allowedPreviewTypes : [ 'image' ],
        //allowedFileTypes: ['image', 'video', 'flash'],
        allowedFileExtensions : ["jpg", "png","gif","jpeg"],/*上传文件格式*/
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
    if($.trim($("#title").val())==""){
        $.messager.alert("错误消息","活动主题不能为空！");
        return false;
    }
    if($.trim($("#place").val())==""){
        $.messager.alert("错误消息","活动地点不能为空！");
        return false;
    }
    clearInterval(tempInveral);
    $('#photo').val(JSON.stringify(List));//拿到后台传回来的id，给图片的id赋值序列化表单用
    if(UE.getEditor('editor').hasContents() == true){
        //只取ueditor的纯文本内容存进数据库，
        $('#content').val($('#content').html(UE.getEditor('editor').getContentTxt()).text());
        $.ajax({
            url: '/activity/activityAdd',
            data:$('#form').serialize(),// 你的formid
            type:"POST",
            dataType:'json',
            async: false,
            error:function(){},
            success : function(data) {
                if (data){
                    $.messager.alert("成功消息", "新增成功");
                    parent.$('#data_dg').datagrid('reload');
                    parent.$('#data_dialog').dialog('close');
                } else {
                    $.messager.alert("错误消息", "新增失败");
                }
            }
        });
    }else{
        $.messager.alert("错误消息","信息内容不能为空！");
    }
}

function hasContent() {
    var arr = [];
    arr.push( "使用editor.hasContents()方法判断编辑器里是否有内容" );
    arr.push( "判断结果为：" );
    arr.push(  UE.getEditor('editor').hasContents() );
    alert( arr.join( "\n" ) );
}