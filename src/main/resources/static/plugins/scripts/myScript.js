$(function(){
//	导航栏回到顶部
	var nav = $(".hd-navbg"),
	offseth =nav.offset();
	var returnli = $(".return li");
	$(document).on('scroll',function(){
		var	scroll_h = $(document).scrollTop();
		if(offseth.top<=scroll_h){
			nav.css({'position':'fixed','top':'0','background':'rgba(62, 188, 213, 0.9)'});
			returnli.css({'position':'fixed','top':'0','right':'200px','z-index':'999'});
			}else{
				nav.css({'position':'relative','top':'none','background':'#2392ba'});
				returnli.css({'position':'relative','top':'none','right':'none'});
				}
		});
	
	
	
	$(".change-user").click(function(){
		var str=$(this).next().hasClass("on");
		if(str==true){
			$(this).next().removeClass("on");
		}else{
			$(this).next().addClass("on");
		}
	});
	$(".info-user").click(function(){
		var str=$(this).next().hasClass("on");
		if(str==true){
			$(this).next().removeClass("on");
		}else{
			$(this).next().addClass("on");
		}
	});
	$(".dec").click(function(){
		var str=$(this).find("a:eq(0)").hasClass("select");
		var str1=$(this).siblings().find("div:eq(0)").hasClass("on");
		if(str==false){
			$(this).find("a:eq(0)").addClass("select");
			$(this).find("a:eq(0)").find("i").attr("class","jiantou1");
			$(this).siblings().find("a:eq(0)").removeClass("select");
			$(this).siblings().find("a:eq(0)").find("i").attr("class","jiantou");
		}
		if(str1==true){
			$(this).siblings().find("div:eq(0)").removeClass("on");
		}
	});
	/*头部信息切换结束*/
	/*选项卡切换*/
	$('.zzsc .content ul').width(296*$('.zzsc .content li').length+'px');
	$(".zzsc .tab a").click(function(){
		$(this).addClass('on').siblings().removeClass('on');
		var index = $(this).index();
		number = index;
		var distance = -296*index;
		$('.zzsc .content ul').stop().animate({
			left:distance
		});
	});
	/*选项卡结束*/
	/*导航栏开始*/
	$(".daohang-bt").mouseover(function(){
		$(this).find(".daohang").addClass("on");
		$(this).css("background","#ff6160");
	});
	$(".daohang-bt").mouseout(function(){
		$(this).find(".daohang").removeClass("on");
		$(this).css("background","none");
	});
	$(".nav-fr li a").click(function(){
		var sel=$(this).hasClass("select");
		if(sel==false){
			$(this).addClass("select");
			$(this).parent().siblings().find("a").removeClass("select");
		}
	});
	/*导航栏结束*/
	/*二维码开始*/
	$(".icon-app").mouseover(function(){
		$(this).find(".appDown").addClass("on");
	}).mouseout(function(){
		$(this).find(".appDown").removeClass("on");
	});
	/*二维码结束*/
	var right=$("#right").height();
	var left=$("#left").height();
	if (left<right) {
		$("#left").css({"height":right});
	}
});