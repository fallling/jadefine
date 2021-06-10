
/*创建DateGrid*/
const userListGrid = $('#userListGrid');
userListGrid.datagrid({
    fit:true,
    border:false,
    url:'/system/user/list',
    idField:'id',
    treeField:'name',
    columns:[[
        {field:'id',title:'用户id',width:80,align: 'center'},
        {field:'userName',title:'用户名',width:100,align: 'center'},
        {field:'password',title:'密码',width:150,align:'center'},
        {field:'realName',title:'真实姓名',width:100,align:'center'},
        {field:'sex',title:'性别',width:80,align:'center'},
        {field:'address',title:'地址',width:140,align:'center'},
        {field:'email',title:'邮箱',width:160,align:'center'},
        {field:'score',title:'等级',width:80,align:'center'},
        {field:'regDate',title:'注册日期',width:120,align:'center'},
        {field:'status',title:'状态',width:80,align:'center',
            formatter: function (val,row) {
                if(val == true){
                    return "可用"
                }else
                    return "禁用"
            }
        },
        {field:'operate',title:'操作',width:100,align:'center',
            formatter:function (val,row) {
                const buttons = [];
                buttons.push('<a data-id="'+row.id+'" class="actions edit">编辑</a>');
                buttons.push('<a data-id="'+row.id+'" class="actions delete">删除</a>');
                return buttons.join("");
            }}
    ]],
    toolbar:"#menu"
});

/*获取panel*/
var gridPanel = userListGrid.datagrid("getPanel")

//给操作按钮绑定事件
gridPanel.on("click","a.edit",function () {
    var id =this.dataset.id;
    formDialog(id);
}).on("click","a.delete",function () {
    var id =this.dataset.id;
    $.messager.confirm("提示","是否删除？",function (r) {
        if (r){
            $.get("/system/user/delete?id="+id).success(function (data) {
                if (data.msg){
                    $.messager.show({
                        title: 'Error',
                        msg: data.msg,
                        style:{}
                    });
                } else {
                    userListGrid.datagrid("reload");
                }
            })
        }
    })
})

/*表单窗口*/
function formDialog(id) {
    const dialog = $('<div/>').dialog({
        title:(id?'编辑':'添加')+'管理员',
        href: '/system/user/'+(id?'load?id='+id:'form'),
        width: 420,
        height: 550,
        onClose: function () {
            $(this).dialog("destroy");
        },
        buttons: [
            {
                text: '保存',
                iconCls:'icon-ok',
                handler: function () {
                    const userForm = $('#userForm');
                    if (userForm.form("validate")) {
                        $.post("/system/user/"+(id?'update':'save'),
                            userForm.serialize()
                        ).success(function (data) {
                            if (data.msg){
                                $.messager.show({
                                    title: 'Error',
                                    msg: data.msg,
                                    style:{}
                                });
                            } else {
                                $('#userForm').dialog('close');		// close the dialog
                                $('#userListGrid').datagrid('reload');	// reload the user data
                            }
                        });
                    }
                }
            },
            {
                text: '取消',
                iconCls:'icon-cancel',
                handler:function () {
                    dialog.dialog("close");

                }
            }
        ]
    });
}

/*搜索框*/
function searchById() {
    $('#userListGrid').datagrid('load',{
        id: $('#userId').val()
    });
}