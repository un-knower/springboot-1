/*!
 * FileInput Chinese Translations
 *
 * This file must be loaded after 'fileinput.js'. Patterns in braces '{}', or
 * any HTML markup tags in the messages must not be converted or translated.
 *
 * @see http://github.com/kartik-v/bootstrap-fileinput
 * @author kangqf <kangqingfei@gmail.com>
 *
 * NOTE: this file must be saved in UTF-8 encoding.
 */
(function ($) {
    "use strict";

    $.fn.fileinputLocales['zh'] = {
        fileSingle: '文件',
        filePlural: '个文件',
        browseLabel: '选择 &hellip;',
        removeLabel: '移除',
        removeTitle: '清除选中文件',
        cancelLabel: '取消',
        cancelTitle: '取消进行中的上传',
        uploadLabel: '上传',
        uploadTitle: '上传选中文件',
        msgNo: '没有',
        msgNoFilesSelected: '',
        msgCancelled: '取消',
        msgZoomModalHeading: '详细预览',
        msgSizeTooSmall: 'File "{name}" (<b>{size} KB</b>) is too small and must be larger than <b>{minSize} KB</b>.',
        msgSizeTooLarge: '文件 "{name}" (<b>{size} KB</b>) 超过了允许大小 <b>{maxSize} KB</b>.',
        msgFilesTooLess: '你必须选择最少 <b>{n}</b> {files} 来上传. ',
        msgFilesTooMany: '选择的上传文件个数 <b>({n})</b> 超出最大文件的限制个数 <b>{m}</b>.',
        msgFileNotFound: '文件 "{name}" 未找到!',
        msgFileSecured: '安全限制，为了防止读取文件 "{name}".',
        msgFileNotReadable: '文件 "{name}" 不可读.',
        msgFilePreviewAborted: '取消 "{name}" 的预览.',
        msgFilePreviewError: '读取 "{name}" 时出现了一个错误.',
        msgInvalidFileName: 'Invalid or unsupported characters in file name "{name}".',
        msgInvalidFileType: '不正确的类型 "{name}". 只支持 "{types}" 类型的文件.',
        msgInvalidFileExtension: '不正确的文件扩展名 "{name}". 只支持 "{extensions}" 的文件扩展名.',
        msgFileTypes: {
            'image': 'image',
            'html': 'HTML',
            'text': 'text',
            'video': 'video',
            'audio': 'audio',
            'flash': 'flash',
            'pdf': 'PDF',
            'object': 'object'
        },
        msgUploadAborted: '该文件上传被中止',
        msgUploadThreshold: 'Processing...',
        msgUploadBegin: 'Initializing...',
        msgUploadEnd: 'Done',
        msgUploadEmpty: 'No valid data available for upload.',
        msgValidationError: '验证错误',
        msgLoading: '加载第 {index} 文件 共 {files} &hellip;',
        msgProgress: '加载第 {index} 文件 共 {files} - {name} - {percent}% 完成.',
        msgSelected: '{n} {files} 选中',
        msgFoldersNotAllowed: '只支持拖拽文件! 跳过 {n} 拖拽的文件夹.',
        msgImageWidthSmall: '宽度的图像文件的"{name}"的必须是至少{size}像素.',
        msgImageHeightSmall: '图像文件的"{name}"的高度必须至少为{size}像素.',
        msgImageWidthLarge: '宽度的图像文件"{name}"不能超过{size}像素.',
        msgImageHeightLarge: '图像文件"{name}"的高度不能超过{size}像素.',
        msgImageResizeError: '无法获取的图像尺寸调整。',
        msgImageResizeException: '错误而调整图像大小。<pre>{errors}</pre>',
        msgAjaxError: 'Something went wrong with the {operation} operation. Please try again later!',
        msgAjaxProgressError: '{operation} failed',
        ajaxOperations: {
            deleteThumb: 'file delete',
            uploadThumb: 'file upload',
            uploadBatch: 'batch file upload',
            uploadExtra: 'form data upload'
        },
        dropZoneTitle: '拖拽文件到这里 &hellip;<br>支持多文件同时上传',
        dropZoneClickTitle: '<br>(或点击{files}按钮选择文件)',
        fileActionSettings: {
            removeTitle: '删除文件',
            uploadTitle: '上传文件',
            zoomTitle: '查看详情',
            dragTitle: '移动 / 重置',
            indicatorNewTitle: '没有上传',
            indicatorSuccessTitle: '上传',
            indicatorErrorTitle: '上传错误',
            indicatorLoadingTitle: '上传 ...'
        },
        previewZoomButtonTitles: {
            prev: '预览上一个文件',
            next: '预览下一个文件',
            toggleheader: '缩放',
            fullscreen: '全屏',
            borderless: '无边界模式',
            close: '关闭当前预览'
        }
    };
}

function PreviewImage(fileObj,imgPreviewId,divPreviewId){  
    var allowExtention=".jpg,.bmp,.gif,.png";// 允许上传文件的后缀名document.getElementById("hfAllowPicSuffix").value;
    var extention=fileObj.value.substring(fileObj.value.lastIndexOf(".")+1).toLowerCase();              
    var browserVersion= window.navigator.userAgent.toUpperCase();  
    if(allowExtention.indexOf(extention)>-1){   
        if(fileObj.files){// HTML5实现预览，兼容chrome、火狐7+等
            if(window.FileReader){  
                var reader = new FileReader();   
                reader.onload = function(e){  
                    document.getElementById(imgPreviewId).setAttribute("src",e.target.result);  
                }    
                reader.readAsDataURL(fileObj.files[0]);  
            }else if(browserVersion.indexOf("SAFARI")>-1){  
                alert("不支持Safari6.0以下浏览器的图片预览!");  
            }  
        }else if (browserVersion.indexOf("MSIE")>-1){  
            if(browserVersion.indexOf("MSIE 6")>-1){// ie6
                document.getElementById(imgPreviewId).setAttribute("src",fileObj.value);  
            }else{// ie[7-9]
                fileObj.select();  
                if(browserVersion.indexOf("MSIE 9")>-1)  
                    fileObj.blur();// 不加上document.selection.createRange().text在ie9会拒绝访问
                var newPreview =document.getElementById(divPreviewId+"New");  
                if(newPreview==null){  
                    newPreview =document.createElement("div");  
                    newPreview.setAttribute("id",divPreviewId+"New");  
                    newPreview.style.width = document.getElementById(imgPreviewId).width+"px";  
                    newPreview.style.height = document.getElementById(imgPreviewId).height+"px";  
                    newPreview.style.border="solid 1px #d2e2e2";  
                }  
                newPreview.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src='" + document.selection.createRange().text + "')";                              
                var tempDivPreview=document.getElementById(divPreviewId);  
                tempDivPreview.parentNode.insertBefore(newPreview,tempDivPreview);  
                tempDivPreview.style.display="none";                      
            }  
        }else if(browserVersion.indexOf("FIREFOX")>-1){// firefox
            var firefoxVersion= parseFloat(browserVersion.toLowerCase().match(/firefox\/([\d.]+)/)[1]);  
            if(firefoxVersion<7){// firefox7以下版本
                document.getElementById(imgPreviewId).setAttribute("src",fileObj.files[0].getAsDataURL());  
            }else{// firefox7.0+
                document.getElementById(imgPreviewId).setAttribute("src",window.URL.createObjectURL(fileObj.files[0]));  
            }  
        }else{  
            document.getElementById(imgPreviewId).setAttribute("src",fileObj.value);  
        }           
    }else{  
        alert("仅支持"+allowExtention+"为后缀名的文件!");  
        fileObj.value="";// 清空选中文件
        if(browserVersion.indexOf("MSIE")>-1){                          
            fileObj.select();  
            document.selection.clear();  
        }                  
        fileObj.outerHTML=fileObj.outerHTML;  
    }  
}

)(window.jQuery);