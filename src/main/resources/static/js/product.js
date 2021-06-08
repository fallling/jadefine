
/*创建dataGrid*/
const productListGrid = $('#productListGrid');
productListGrid.datagrid({
    fit:true,
    border:false,
    url:'/system/product/list',
    idField:'id',
    treeField:'name',
    columns:[[
        {field:'id',title:'商品id',width:100,align: 'center'},
        {field:'code',title:'编号',width:100,align: 'center'},
        {field:'name',title:'名称',width:100,align: 'center'},
        {field:'type',title:'类型',width:80,align:'center'},
        {field:'brand',title:'品牌',width:80,align:'center'},
        {field:'pic',title:'图片',width:150,align:'center'},
        {field:'num',title:'数量',width:80,align:'center'},
        {field:'price',title:'价格',width:80,align:'center'},
        {field:'intro',title:'详情',width:150,align:'center'},
        {field:'status',title:'状态',width:80,align:'center'},
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
var gridPanel = productListGrid.datagrid("getPanel")

//给操作按钮绑定事件
gridPanel.on("click","a.edit",function () {
    var id =this.dataset.id;formDialog(id);}).on("click","a.delete",function () {
    var id =this.dataset.id;
    $.messager.confirm("提示","是否删除？",function (r) {
        if (r){
            $.get("/system/product/delete?id="+id).success(function () {
                productListGrid.datagrid("reload");
            })
        }
    })
})

/*表单窗口*/
function formDialog(id) {
    const dialog = $('<div/>').dialog({
        title:(id?'编辑':'添加')+'商品',
        href: '/system/product/'+(id?'load?id='+id:'form'),
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
                    const productForm = $('#productForm');
                    if (productForm.form("validate")) {
                        $.post("/system/product/"+(id?'update':'save'),
                            productForm.serialize()
                        ).success(function () {
                            productListGrid.datagrid("reload");
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
                        $('#productForm').dialog('close');		// close the dialog
                        $('#productListGrid').datagrid('reload');	// reload the user data
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
function searchByProductId() {
    $('#productListGrid').datagrid('load',{
        id: $('#productId').val()
    });
}

