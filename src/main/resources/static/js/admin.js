/*创建dataGrid*/
const adminListGrid = $('#adminListGrid');
adminListGrid.datagrid({
    fit:true,
    border:false,
    url:'/system/admin/list',
    idField:'id',
    treeField:'name',
    columns:[[
        {field:'id',title:'管理员id',width:150,align: 'center'},
        {field:'name',title:'管理员名称',width:100,align: 'center'},
        {field:'pwd',title:'密码',width:150,align:'center'},
        {field:'role',title:'角色',width:100,align:'center'},
        {field:'operate',title:'操作',width:100,align:'center',
            formatter:function (val,row) {
                var buttons = [];
                buttons.push('<a data-id="'+row.id+'" class="actions edit">编辑</a>');
                buttons.push('<a data-id="'+row.id+'" class="actions delete">删除</a>');
                return buttons.join("");
            }}
    ]],
    toolbar:"#menu"
});

/*获取panel*/
var gridPanel = adminListGrid.datagrid("getPanel")

//给操作按钮绑定事件
gridPanel.on("click","a.edit",function () {
    var id =this.dataset.id;
    formDialog(id);
}).on("click","a.delete",function () {
    var id =this.dataset.id;
    $.messager.confirm("提示","是否删除？",function (r) {
        if (r){
            $.get("/system/admin/delete?id="+id).success(function () {
                adminListGrid.datagrid("reload");
            })
        }
    })
})
/*表单窗口*/
function formDialog(id) {
    const dialog = $('<div/>').dialog({
        title:(id?'编辑':'添加')+'管理员',
        href: '/system/admin/'+(id?'load?id='+id:'form'),
        width: 350,
        height: 380,
        onClose: function () {
            $(this).dialog("destroy");
        },
        buttons: [
            {
                text: '保存',
                iconCls:'icon-ok',
                handler: function () {
                    const adminForm = $('#adminForm');
                    if (adminForm.form("validate")) {
                        $.post("/system/admin/"+(id?'update':'save'),
                            adminForm.serialize()
                        ).success(function () {
                            adminListGrid.datagrid("reload");
                            dialog.dialog("close");
                        });
                    }
                },
                success: function(result){
                    var result = eval('('+result+')');
                    if (result.errorMsg){
                        $.messager.show({
                            title: 'Error',
                            msg: result.errorMsg
                        });
                    } else {
                        $('#adminForm').dialog('close');		// close the dialog
                        $('#adminListGrid').datagrid('reload');	// reload the user data
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
    $('#adminListGrid').datagrid('load',{
        id: $('#adminId').val()
    });
}
