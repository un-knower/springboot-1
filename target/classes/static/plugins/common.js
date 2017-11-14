/**
 * 去除输入文本框中的空格
 */
function trimInputTextSpace() {
	$(":text").each(function(i,item){
		$(item).val($.trim($(item).val()));
	});
}
/**
 * 是否金额格式100.00
 */
function isMoneyFormat(value) {   
	 var regMoney = /^\d{1,9}(\.{1}\d{1,2})?$/; 
	 var reMoney= new RegExp(regMoney);
	 if (!reMoney.test(value)){
		  return false;
	 }else{
		  return true;
	 }
}
/**
 * 防止输入数字以外的字符
 */
function isNumber(e) {   
    if (jQuery.browser.msie) {   
        if ( ((event.keyCode > 47) && (event.keyCode < 58)) ||   
              (event.keyCode == 8) ) {   
            return true;   
        } else {   
            return false;   
        }   
    } else {   
        if ( ((e.which > 47) && (e.which < 58)) ||   
              (e.which == 8) ) {   
            return true;   
        } else {   
            return false;   
        }   
    }   
} 

/**
 * 防止输入数字和"."的字符 用于金额输入
 */
function isMoney(e) {   
    if (jQuery.browser.msie) {   
        if ( ((event.keyCode > 47) && (event.keyCode < 58)) ||   
              (event.keyCode == 8) || (event.keyCode == 46) || (event.keyCode == 45) ) {   
            return true;   
        } else {   
            return false;   
        }   
    } else {   
        if ( ((e.which > 47) && (e.which < 58)) ||   
              (e.which == 8) || (e.which == 46) || (e.which == 45) ) {   
            return true;   
        } else {   
            return false;   
        }   
    }   
}
/**
 * 数组去重
 * @param data
 * @returns
 */
function uniqueArray(data) {
	data = data || [];
	var a = {};
	len = data.length;
	for ( var i = 0; i < len; i++) {
		var v = data[i];
		if (typeof (a[v]) == 'undefined') {
			a[v] = 1;
		}
	}
	;
	data.length = 0;
	for ( var i in a) {
		data[data.length] = i;
	}
	return data;
}
/**
 * 验证手机号码
 * @return flag ( true 表示验证通过, false 表示验证不通过)
 */
function validateMobile(mobile){
	var reg = /^(13|15|18|14|16|17|19)\d{9}$/i;
	var flag = (reg).test(mobile);
	return flag;
}
/**
 * 防止输入数字和字母以外的字符
 * @param e
 */
function isNumberOrLetter(event){
	var keyCode = event.keyCode || event.which;
	if (jQuery.browser.msie) {   
		 if (keyCode == 8 || (keyCode >= 48 && keyCode <= 57) || (keyCode >= 65 && keyCode <= 90) || (keyCode >= 97 && keyCode <= 122)) {
				return true;
			}else{
				return false;
			} 
	} else {   
		if (keyCode == 8 || (keyCode >= 48 && keyCode <= 57) || (keyCode >= 65 && keyCode <= 90) || (keyCode >= 97 && keyCode <= 122)) {
			return true;
		}else{
			return false;
		}  
	}  
}




/**
 * 下载Excel 模板
 * @param fileName
 */
function downloadTemplateExcel(fileName){
	var url =basePath+"fileupload!downloadTemplateExcel.action?fileName="+fileName; 
	window.location.href=encodeURI(url);
}

/**
 * 导入excel
 */
function importExcel(url){

	var fileName = $("#files").val();
	if(fileName==""){
		dialogMsg("请先选择文件",0);
		return;
	}
	var contentType = fileName.substring(fileName.lastIndexOf("."),fileName.length);
	if (!(contentType.toLowerCase() == ".xls" || contentType.toLowerCase() == ".xlsx")) {
		dialogMsg("上传格式不正确",0);
		return;
	}
	
	$.ajaxFileUpload({
		url : url,// 用于文件上传的服务器端请求地址
		secureuri : false,// 一般设置为false
		fileElementId : ['files'],// 文件上传空间的id属性 <input type="file" id="file"
								// name="file" />
		dataType : 'json',// 返回值类型 一般设置为json
		success : function(data) { // 服务器成功响应处理函数
			var type = data.Type;			
			if(type == "1"){
				dialogCloseLook();
				$.currentIframe().$("#gridTable").trigger("reloadGrid");
			}else{
				dialogMsg("请选择模板内容的文件",0);
			}
		}
	});


}
