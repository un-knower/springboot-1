$(function() {
    initSchool();
    initDatagrid();
    $(".size_style").click(function () {
        search();
    });
    $(".datagrid-wrap.panel-body.panel-body-noheader").css("height","617px");
});

/**
 *初始化
 */
function initDatagrid() {
    var toolbar = [{
        id: "add-btn",
        text: "新增",
        iconCls: "icon-add",
        handler: function() {
            addInfo();
        }
    }, '-',
        {
            id: "edit-btn",
            text: "编辑",
            iconCls: "icon-edit",
            handler: function() {
                editInfo();
            }
        }, '-',
        {
            id: "delete-btn",
            text: "删除",
            iconCls: "icon-remove",
            handler: function() {
                deleteInfo();
            }
        }, '-'
    ];

    var columns = [
        [
            {field: 'id',title: 'id',width: 50,halign: 'center',align: 'center',checkbox:true},
            {field: 'title',title: '活动主题',width: 300,halign: 'center',align: 'center'},
            {field: 'place',title: '活动地点',width: 200,halign: 'center',align: 'center'},
            {field: 'schoolId',title: '所在学校',width: 150,halign: 'center',align: 'center',
                formatter: schoolFormat},

            {field: 'classId',title: '所在班级',width: 150,halign: 'center',align: 'center',
                formatter: classFormat },
            {field: 'gradeId',title: '所在年级',width: 150,halign: 'center',align: 'center',
                formatter: gradeFormat },
            {field: 'playStartDate',title: '有效期开始时间',width: 150,halign: 'center',align: 'center',
                formatter : function(value){
                    if (value != null) {
                        var date = new Date(value);
                        return date.getFullYear() + '-' + (date.getMonth() + 1) + '-'
                            + date.getDate();
                    }
                }},
            {field: 'playEndDate',title: '有效期结束时间',width: 150,halign: 'center',align: 'center',
                formatter : function(value){
                    if (value != null) {
                        var date = new Date(value);
                        return date.getFullYear() + '-' + (date.getMonth() + 1) + '-'
                            + date.getDate();
                    }
                }},
            {field: ' ',title: '操作',width: 150,halign: 'center',align: 'center',formatter: function(value, row, index) {
                return '<a onclick="editInfoDo(\''+row.id+'\')" class="bootstrap_up_btn" >修改</a><a  onclick="deleteInfoStr(\''+row.id+'\')" class="bootstrap_del_btn" >删除</a>';
            }
            }
        ]
    ];
    var url = '/activity/getActivityList';
    $('#data_dg').datagrid({
        url: url,
        height: 'auto',
        method: 'get',
        rownumbers: true, //行号
        nowrap: false,
        striped: true,
        border: true,
        fitColumns: false,
        collapsible: false, //是否可折叠的
        fit: true, //自动大小
        pagination: true,
        remoteSort: false,
        idField: 'id', //在删除的时候，可以翻页选择，框架能知道选了哪些
        singleSelect: false, //是否单选
        toolbar: toolbar,
        columns: columns,
        checkOnSelect: false,
        checkbox: true,
        selectOnCheck: false,
        onDblClickRow: function(index, row) {
            $('#data_dg').datagrid('selectRow', index);
            var selectedRow = $('#data_dg').datagrid('getSelected');
            editInfoDo(selectedRow.id);
        },
        onLoadSuccess: function(data) {}
    });
}

/*新增教师管理*/
function addInfo() {
    if($("#data_dialog").length == 0) { //因为关闭的时候，是强制销毁的，入股没有这个3行代码，再次点击新增或修改时，时不能创建dialog
        $(document.body).append("<div id='data_dialog'></div>");
    }
    var href = '/activity/openAddView';
    var content = '<iframe id="dataIframe" src="' + href + '" width="100%" height="99%" frameborder="0" scrolling="auto"></iframe>';

    $('#data_dialog').dialog({
        title: '新增',
        width: 1000,
        height: 600,
        closed: false,
        cache: false,
        content: content,
        onClose:function(){
            $('#data_dialog').dialog('destroy');
        },
        buttons :[
            {
                text:"保存",
                iconCls:'icon-save',
                plain : false,
                handler:function(){
                    $("#dataIframe")[0].contentWindow.submitForm();
                    //下面的访问会存在跨域问题
                    //$(window.parent.document).contents().find("#tmodeUrgentIframe").contents()
                       // .find("#dataIframe")[0].contentWindow .submitForm();
                }
            },{
                text:"取消",
                iconCls:'icon-cut',
                handler:function(){
                    $("#data_dialog").dialog('close');
                }
            }
        ],
        modal: true
    });

};


/*编辑*/
function editInfo() {
    var selectedRows = $("#data_dg").datagrid("getChecked");
    if(selectedRows.length ==0){
        //alert("您没有可编辑的数据，请选择一条记录！");
        $.messager.alert("系统提示", "您没有可编辑的数据，请选择一条记录！");
    }else if(selectedRows.length >1){
        $.messager.alert("系统提示", "请选择一条记录！");
    }else{
        var id = selectedRows[0].id;
        editInfoDo(id);
    }
}


/*编辑*/
function editInfoDo(id) {
    if(!id){
        $.messager.alert("系统提示","您没有可编辑的数据，请选择一条记录！");
    }else{
        if($("#data_dialog").length == 0) { //因为关闭的时候，是强制销毁的，入股没有这个3行代码，再次点击新增或修改时，时不能创建dialog
            $(document.body).append("<div id='data_dialog'></div>");
        }
        var href = '/activity/openEditView?id='+id;
        var content = '<iframe id="dataIframe" src="' + href + '" width="100%" height="99%" frameborder="0" scrolling="auto"></iframe>';
        $('#data_dialog').dialog({
            title: '编辑',
            width: 1000,
            height: 600,
            closed: false,
            cache: false,
            content: content,
            onClose:function(){
                $('#data_dialog').dialog('destroy');
            },
            buttons :[
                {
                    text:"保存",
                    iconCls:'icon-save',
                    plain : false,
                    handler:function(){
                       $ ("#dataIframe")[0].contentWindow.submitForm();
                    }
                },{
                    text:"取消",
                    iconCls:'icon-cut',
                    handler:function(){
                        $("#data_dialog").dialog('close');
                    }
                }
            ],
            modal: true
        });
    }

};

//批量删除
function deleteInfo() {
    var selectedRows = $("#data_dg").datagrid("getChecked");
    var length = selectedRows.length;
    if(length == 0){
        $.messager.alert("系统提示", "请至少选择一条记录！");
    }else{
        var id = [];
        for (var i = 0; i < length ; i++) {
            id.push(selectedRows[i].id);
        }
        var ids = JSON.stringify(id);
        deleteInfoDo(ids);
    }
}

function deleteInfoStr(id) {
    var idArray = [];
    idArray.push(id);
    var ids = JSON.stringify(idArray);
    deleteInfoDo(ids);
}

function deleteInfoDo(ids){
    var url ='/activity/activityDel';
    $.messager.confirm('删除', '确定要删除数据吗?', function (r) {
        location.reload();
        if (r) {
            $.post(url, { ids: ids }, function (data) {
                if (data) {
                    $.messager.alert("成功","删除成功!");
                    $('#data_dg').datagrid('reload');
                } else {
                    $.messager.alert("错误信息","删除失败!");
                }
            },'json');
        }
    });
}

function formatterHeadUrl(value, row, index) {
    if(value) {
        return '<img src="' + value + '" style="width:50px;">';
    } else {
        return "无图片";
    }

}

/**
 * 年级
 * @param cellvalue
 * @param options
 * @param rowObject
 */
 function gradeFormat(cellvalue, options, rowObject){
     var value="";
    $.ajax({
        url:  '/vw/getGradeName',
        data:{
            classId:gradeFlag
        },
        type:"POST",
        dataType:'json',
        async: false,
        success : function(data) {
            value=data.name;
        }
    });
    return value ;
 }

 var gradeFlag;
/**
 * 班级名称
 */
function classFormat(cellvalue, options, rowObject){
    gradeFlag=cellvalue;
    var value="";
    $.ajax({
        url:  '/vw/getClassName',
        data:{
          classId:cellvalue
        },
        type:"POST",
        dataType:'json',
        async: false,
        error:function(){},
        success : function(data) {
            value=data.className;
        }
    });
        return value ;
}
/**
 * 学校名称
 */
var schoolList;
function initSchool() {
    $.ajax({
        url: '/vw/getSchoolName',
        type:"POST",
        dataType:'json',
        async: false,
        success : function(data) {
            schoolList=data;
        }
    });
}
function schoolFormat(cellvalue, options, rowObject){
        if(cellvalue == schoolList.id){
            return schoolList.schoolName;
        }
    return cellvalue || '' ;
}

function search(){
    var indexCode = $('#indexCode').val();
    var indexName = $("#indexName").val();
    indexName = $.trim(indexName);
    $('#data_dg').datagrid('load',{
        indexCode:indexCode,
        indexName:indexName
    });
}
