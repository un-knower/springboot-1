$(function() {
	/*登录*/
$("form").submit( function(){
    var str1=$("#user").val();
	var str2=$("#password").val();
	if(str1!='111'||str2!='111'){
		return false;
	}
} );
/*登录结束*/
/*页面响应*/
$(".contain-bg").css({"height":$(window).height()-172});
$(".img-animal").css({"height":$(window).height()-172});
$(".img-animal img").width(($(window).width())*0.4);
	if($(window).width()<1024){
		$(".img-animal").addClass("on");
		$(".hd-tips").addClass("on");
	}else{
		$(".img-animal").removeClass("on");
		$(".hd-tips").removeClass("on");
	}
window.addEventListener("resize", function() {
	relogin();
});
function relogin(){
	$(".contain-bg").css({"height":$(window).height()-172});
	$(".img-animal").css({"height":$(window).height()-172});
	$(".img-animal img").width(($(window).width())*0.4);
	if($(window).width()<1024){
		$(".img-animal").addClass("on");
		$(".hd-tips").addClass("on");
	}else{
		$(".img-animal").removeClass("on");
		$(".hd-tips").removeClass("on");
	}
}
/*页面响应结束*/
	
	
}