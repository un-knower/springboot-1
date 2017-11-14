function shanchu(msg){
	$(msg).parent().parent().parent().remove();
}
function shanchu1(msg){
	$(msg).parent().remove();
	var liindex=$(msg).parent().index();
	$(".con-menu-list1").find("ul").eq(liindex).remove();
}
/*正文编辑区方法*/
function reshow(msg){
	var on1=$(msg).parent().find(".input-group").hasClass("on1");
		if (on1==true) {
			$(msg).parent().find(".input-group").removeClass("on1");
		}else{
			$(msg).parent().find(".input-group").addClass("on1");
	}
}
function rename(msg){
	var str1=$(msg).prev().val();
	$(msg).parent().parent().find(".menu-tp").html(str1);
	$(msg).parent().addClass("on1");
}
function lichange(msg){
	$(msg).addClass("select");
	$(msg).siblings().removeClass("select");
	var index=$(msg).parent().find("li[class='select']").index();
	$(msg).parent().parent().next().find(".menu-cont").eq(index).addClass("on");
	$(msg).parent().parent().next().find(".menu-cont").eq(index).siblings().removeClass("on");	
}
function bianji(msg){
	$(".menu-list li img").removeClass("on1");
	$(".menu-list li i").removeClass("on1");	
}
function quxiao(msg){
	$(".menu-list li img").addClass("on1");
	$(".menu-list li i").addClass("on1");
}

/*正文编辑区方法结束*/
/*背景改变事件方法*/
function changetheme(){
	$(".theme-bg").css({"width":$(window).width(),"height":$(window).height()});
	$(".theme-bg").css({'background-position':'center center','background-repeat':'space'});
}
/*背景改变事件方法结束*/
$(function(){
	/*禁止页面右键*/
    $(document).bind("contextmenu",function(e){
         return false;
     });
	/*背景图片设置*/
		$(".theme-bg").css({"width":$(window).width(),"height":$(window).height()});
	/*背景图片设置结束*/
	/*屏幕改变响应事件*/
	window.addEventListener("resize", function() {
		changetheme();
		var total = document.documentElement.clientHeight-106;
		/*主内容*/
		$('.main-contain').height(total);
		/*主内容结束*/
		/*视频内容响应*/
		$(".video-con iframe").width($(window).width()-160);
		$(".video-con iframe").height($(window).height()-102);
		$(".contain-video").css({"margin-left":"-"+($(window).width()-160)/2+"px","width":$(window).width()-160});
		/*视频内容响应结束*/
	}, false);
	/*屏幕改变响应事件结束*/
	/*头部菜单hover状态*/
	$(".top-hover2").mouseover(function(){
		$(this).find("span").css({"color":"#13c0d7"});
		var str=$(this).find("img").attr("src");
		var ret=/\/(.*)\./.exec(str);
		var ret1="images/"+ret[1]+"1.png";
		$(this).find("img").attr("src",ret1);
	});
	
	$(".top-hover2").mouseout(function(){
		$(this).find("span").css({"color":"#fff"});
		var str=$(this).find("img").attr("src");
		var ret=/\/(.*)1/.exec(str);
		var ret1="images/"+ret[1]+".png";
		$(this).find("img").attr("src",ret1);
	});
	/*头部菜单hover状态结束*/
	/*正文内容效果*/
	$(".menu-del").click(function(){
		var on1=$(this).parent().parent().parent().find(".shanchu").hasClass("on");
		if (on1==true) {
			$(this).parent().parent().parent().find(".shanchu").removeClass("on");
			$(this).addClass("on1");
			$(this).siblings("a").removeClass("on1");
			$(this).parent().parent().next().find(".newfold").removeClass("on");
		}else{
			$(this).parent().parent().parent().find(".shanchu").addClass("on");
			$(this).addClass("on1");
			$(this).siblings("a").removeClass("on1");
			$(this).parent().parent().next().find(".newfold").addClass("on");
		}
	});
	$(".menu-tp1").click(function(){
		var on1=$(this).next(".input-group").hasClass("on1");
		if (on1==true) {
			$(this).next(".input-group").removeClass("on1");
		}else{
			$(this).next(".input-group").addClass("on1");
		}
	});
	$(".xinjian").on("click",function(){
		var str1=$(this).prev().val();
		var str2='<li onclick="lichange(this)"><img src="images/tubiao/bianji.png" onclick="reshow(this)"><span class="menu-tp">'+str1+'</span><i class="reshanchu" onclick="shanchu1(this)"></i><div class="input-group xiugai-con on1"><input type="text" class="form-control"><span class="input-group-addon" onclick="rename(this)">修改</span></div></li>';
		var str3='<ul class="menu-cont"><li><img src="images/tubiao/add.png" alt=""><span>教学评价</span></li></ul>';
		$(this).parent().parent().before(str2);
		$(this).parent().parent().parent().parent().next().find("ul:last-child").after(str3);
		$(this).parent().addClass("on1");
	});
	$(".menuone-cont li").click(function(){
		var sel=$(this).find("i").hasClass("on");
		if (sel==false) {
			$(this).addClass("flag");
			$(this).find("i").addClass("on");
		}else{
			$(this).removeClass("flag");
			$(this).find("i").removeClass("on");
		}
	});
	/*$(".shanchu").bind("click",function(){
		$(this).parent().remove();
	});*/
	$(".menuone-close").click(function(){
		$(this).parent().parent().removeClass("on");
	});
	$(".col-md-add1").click(function(){
		$(".col-md-add2").addClass("on");
	});
	$(".menuone-select input").click(function(){
		var str=$(this).parent().prev().find("li.flag").size();
		var arr=[];
		$(this).parent().prev().find("li.flag").each(function(){
			arr.push($(this).find("span").text());
		});
		$(this).parent().parent().removeClass("on");
	
	});
	/*正文菜单拖动效果开始*/
	$(".col-md-add2").draggable();
	$(".menu-cont").sortable({
          cursor: "move",
          items :"li",                        //只是li可以拖动
          opacity: 0.6,                       //拖动时，透明度为0.6
          revert: true,                       //释放时，增加动画
          update : function(event, ui){       //更新排序之后
              /*回调*/
          }
         });
	/*正文菜单拖动效果结束*/
	/*正文内容效果结束*/
	/*主题切换开始*/
	$(".theme-ch").click(function(){
		var on1=$(".contain-theme").hasClass("on");
		if (on1==false) {
			$(".contain-theme").addClass("on");
		}else{
			$(".contain-theme").removeClass("on");
		}
	});
	$(".close-theme").click(function(){
		var on1=$(".contain-theme").hasClass("on");
		if (on1==true) {
			$(".contain-theme").removeClass("on");
		}else{
			$(".contain-theme").addClass("on");
		}
	});

		var $li =$("#skin img");
		$li.click(function(){
			var ret=this.src;
			var ret1=ret.split('mainmenu/');
			switchSkin(ret1[1]);
		});
	    var cookie_skin = $.cookie( "MyCssSkin");//优化了代码，将功能模块化了
	    if (cookie_skin) {
	        switchSkin( cookie_skin );
	    }
	function switchSkin(skinName){
	    $(".theme-bg").css({'background':'url(images/mainmenu/'+skinName+')','background-position':'center center','background-size':'100% auto'}); //设置不同皮肤
	    $.cookie( "MyCssSkin" , skinName , { path: '/', expires: 10 });
	}
	/*轮播生成*/
	var i=0; //图片标识
	var img_num=$(".img_ul").children("li").length; //图片个数
	$(".img_ul li").hide(); //初始化图片
	if($(".img_hd ul li img").height()>=$(".img_hd ul li").height()) {
		$(".img_hd ul li img").height($(".img_hd ul li").height());
	}	
	play();
	$(function(){
		 $(".img_hd ul").css("width",($(".img_hd ul li").outerWidth(true))*img_num); //设置ul的长度
		 
		 $(".bottom_a").css("opacity",0.7);	//初始化底部a透明度
		 //$("#play").css("height",$("#play .img_ul").height());
		 if (!window.XMLHttpRequest) {//对ie6设置a的位置
		 $(".change_a").css("height",$(".change_a").parent().height());}
		 $(".change_a").focus( function() { this.blur(); } );
		 $(".bottom_a").hover(function(){//底部a经过事件
			 $(this).css("opacity",1);	
			 },function(){
			$(this).css("opacity",0.7);	 
				 });
		 $(".change_a").hover(function(){//箭头显示事件
			 $(this).children("span").show();
			 },function(){
			 $(this).children("span").hide();
				 });
		 $(".img_hd ul li").click(function(){
			 i=$(this).index();
			 play();
			 });
		 $(".prev_a").click(function(){
			 //i+=img_num;
			 i--;
			 //i=i%img_num;
			 i=(i<0?0:i);
			 play();
			 }); 
		 $(".next_a").click(function(){
			 i++;
			 //i=i%img_num;
			 i=(i>(img_num-1)?(img_num-1):i);
			 play();
			 }); 
		 }); 
	function play(){//动画移动	
	var img=new Image(); //图片预加载
	img.onload=function(){img_load(img,$(".img_ul").children("li").eq(i).find("img"))};
	img.src=$(".img_ul").children("li").eq(i).find("img").attr("src");
	//$(".img_ul").children("li").eq(i).find("img").(img_load($(".img_ul").children("li").eq(i).find("img")));

	$(".img_hd ul").children("li").eq(i).addClass("on").siblings().removeClass("on");
	if(img_num>7){//大于7个的时候进行移动
		if(i<img_num-3){ //前3个
		$(".img_hd ul").animate({"marginLeft":(-($(".img_hd ul li").outerWidth()+4)*(i-3<0?0:(i-3)))});
		}
		else if(i>=img_num-3){//后3个
			$(".img_hd ul").animate({"marginLeft":(-($(".img_hd ul li").outerWidth()+4)*(img_num-7))});
			}
	}
	if (!window.XMLHttpRequest) {//对ie6设置a的位置
	$(".change_a").css("height",$(".change_a").parent().height());}
	}
	/*轮播方法*/
	function img_load(img_id,now_imgid){//大图片加载设置 （img_id 新建的img,now_imgid当前图片）

	if(img_id.width/img_id.height>1)
	{
		if(img_id.width >=$("#play").width()) $(now_imgid).width($("#play").width());
		}
	else {
		if(img_id.height>=500) $(now_imgid).height(500);
		}
		$(".img_ul").children("li").eq(i).show().siblings("li").hide(); //大小确定后进行显示
	}

	/*主题切换结束*/
/*音乐播放器开始*/
	$(".contain-music").draggable();
	$(".contain-music1").draggable();
	$(".music-bt").click(function(){
		var on1=$(".contain-music").hasClass("on");
		if (on1==false) {
			$(".contain-music").addClass("on");
		}else{
			$(".contain-music").removeClass("on");
		}
	});
	$("#mc-title1").click(function(){
		$(this).parent().parent().removeClass("on");
	});
	$("[id='mc-title2'").click(function(){
		$(this).parent().parent().removeClass("on");
		$(this).parent().next(".mc-cont").html(' ');
	});
	$("#mc-title3").click(function(){
		$(this).parent().parent().removeClass("on");
		$(".min-cd").addClass("on");
	});
	$(".music-list li").click(function(){
		var on1=$(".contain-music1").hasClass("on");
		var music=$(this).find(".add-music").html();
		var music1='<iframe frameborder="no" border="0" marginwidth="0" marginheight="0" width=330 height=450 src="'+music+'"></iframe>';
		if (on1==false) {
			$(".contain-music1").addClass("on");
		}
		$(".mc-cont").html(music1);
	});
	$(".min-cd img").click(function(){
		var on1=$(".contain-music1").hasClass("on");
		$(this).parent().removeClass("on");
		if (on1==false) {
			$(".contain-music1").addClass("on");
		}
	});
/*音乐播放结束*/
/*视频开始*/
	$(".vedio-bt").click(function(){
		var on=$(".contain-video").hasClass("on");
		var ifra1='<iframe frameborder=0 marginheight="0" marginwidth="0" src="http://www.iqiyi.com/"></iframe>';
		if (on==false) {
			$(".contain-video").addClass("on");
			$(".video-con").html(ifra1);
		}else{
			$(".contain-video").removeClass("on");
			$(".video-con").html("");
		}
		$(".video-con iframe").width($(window).width()-160);
		$(".video-con iframe").height($(window).height()-102); 
	});
	$(".contain-video").draggable();
	$(".contain-video").css({"margin-left":"-"+($(window).width()-160)/2+"px","width":$(window).width()-160});
	$(".video-menu li").click(function(){
		var dec1=$(this).hasClass("dec1");
		var ifra=$(this).find("div").html();
		var ifra1='<iframe frameborder=0 marginheight="0" marginwidth="0" src="'+ifra+'"></iframe>';
		if (dec1==false) {
			$(".video-con").html(ifra1);
			$(this).addClass("dec1");
			$(this).siblings().removeClass("dec1");
		}
		$(".video-con iframe").width($(window).width()-160);
		$(".video-con iframe").height($(window).height()-102);
	});
/*视频结束*/
/*搜索框开始*/
	$(".research>input").focus(function(){
		$(".resear-ul").addClass("on");
	}).blur(function(){
		$(".resear-ul").removeClass("on");
	});
/*搜索框结束*/
});