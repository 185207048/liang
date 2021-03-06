jQuery(document).ready(function($){
	var mainHeader = $('.contain-top'),
		belowNavHeroContent = $('.sub-nav-hero');
	//set scrolling variables
	var scrolling = false,
		previousTop = 0,
		currentTop = 0,
		scrollDelta = 10,
		scrollOffset = 150;

	$(window).on('scroll', function(){
		if( !scrolling ) {
			scrolling = true;
			(!window.requestAnimationFrame)
				? setTimeout(autoHideHeader, 250)
				: requestAnimationFrame(autoHideHeader);
		}
	});

	function autoHideHeader() {
		var currentTop = $(window).scrollTop();

		( belowNavHeroContent.length > 0 ) 
			? checkStickyNavigation(currentTop) // secondary navigation below intro
			: checkSimpleNavigation(currentTop);

	   	previousTop = currentTop;
		scrolling = false;
	}

	function checkSimpleNavigation(currentTop) {
		//there's no secondary nav or secondary nav is below primary nav
	    if (previousTop - currentTop > scrollDelta) {
	    	//if scrolling up...
	    	mainHeader.removeClass('is-hidden');
	    } else if( currentTop - previousTop > scrollDelta && currentTop > scrollOffset) {
	    	//if scrolling down...
	    	mainHeader.addClass('is-hidden');
	    }
	}
	$(".bk1").mouseover(function(){
		$(".bk1").hide();
	   	$(".bk11").show();
	})
	$(".bk11").mouseleave(function(){
		$(".bk1").show();
	   	$(".bk11").hide();
	})
	$(".bk2").mouseover(function(){
		$(".bk2").hide();
   		$(".bk22").show();
	})
	$(".bk22").mouseleave(function(){
		$(".bk2").show();
	   	$(".bk22").hide();
	})
	$(".bk3").mouseover(function(){
		$(".bk3").hide();
   		$(".bk33").show();
	})
	$(".bk33").mouseleave(function(){
		$(".bk3").show();
	   	$(".bk33").hide();
	})

})
/*选项卡*/
window.onload = function(){//原生js选项卡写法
var oDiv = document.getElementById('tab');
var tab_a = oDiv.getElementsByTagName('a');
var bCon = oDiv.getElementsByClassName('con');
	for(var i=0;i<tab_a.length;i++){
	  	tab_a[i].index = i;
	  	tab_a[i].style.cursor='pointer';
	  	tab_a[i].onclick = function(){
			for(var i=0;i<tab_a.length;i++){
	    		tab_a[i].className = '';
	    		bCon[i].style.display = 'none';
	   		}
		this.className= 'on';
	   	bCon[this.index].style.display = 'block';
	   	}
	}
}