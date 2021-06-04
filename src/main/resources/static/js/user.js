function  formDialog(){
    var dialog = $("<div/>".dialog({
        title:'添加用户',
        href:'/system/user/form',
        width:400,
        height:500,
        onClose:function (){
            $(this).dialog("destroy");
        }
    }))
}