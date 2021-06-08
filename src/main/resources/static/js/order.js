
/*创建dataGrid*/
const orderListGrid = $('#orderListGrid');
orderListGrid.datagrid({
    fit:true,
    border:false,
    url:'/system/order/list',
    idField:'id',
    treeField:'name',
    columns:[[
        {field:'id',title:'订单id',width:100,align: 'center'},
        {field:'uid',title:'用户id',width:100,align: 'center'},
        {field:'userName',title:'用户名',width:100,align: 'center'},
        {field:'status',title:'订单状态',width:100,align: 'center'},
        {field:'orderTime',title:'订单时间',width:80,align:'center'},
        {field:'orderPrice',title:'金额',width:80,align:'center'},
        {field:'pid',title:'商品id',width:150,align:'center'},
        {field:'productName',title:'商品名称',width:80,align:'center'},
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
var gridPanel = orderListGrid.datagrid("getPanel")

//给操作按钮绑定事件
gridPanel.on("click","a.edit",function () {
    var id =this.dataset.id;
    formDialog(id);
}).on("click","a.delete",function () {
    var id =this.dataset.id;
    $.messager.confirm("提示","是否删除？",function (r) {
        if (r){
            $.get("/system/order/delete?id="+id).success(function () {
                orderListGrid.datagrid("reload");
            })
        }
    })
})

/*表单窗口*/
function formDialog(id) {
    const dialog = $('<div/>').dialog({
        title:(id?'编辑':'添加')+'商品',
        href: '/system/order/'+(id?'load?id='+id:'form'),
        width: 420,
        height: 590,
        onClose: function () {
            $(this).dialog("destroy");
        },
        buttons: [
            {
                text: '保存',
                iconCls:'icon-ok',
                handler: function () {
                    const orderForm = $('#orderForm');
                    if (orderForm.form("validate")) {
                        $.post("/system/order/"+(id?'update':'save'),
                            orderForm.serialize()
                        ).success(function () {
                            orderListGrid.datagrid("reload");
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
                        $('#orderForm').dialog('close');		// close the dialog
                        $('#orderListGrid').datagrid('reload');	// reload the user data
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

function searchByOrderId() {
    $('#orderListGrid').datagrid('load',{
        id: $('#orderId').val()
    });
}