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
});

/*选项卡*/
window.onload=function(){//原生js选项卡写法
var oDiv = document.getElementById('tab');
var tab_a = oDiv.getElementsByTagName('a');
var report =document.getElementsByClassName("report");
console.log(report);
	for(var i=0;i<tab_a.length;i++){
	  	tab_a[i].index = i;
	  	tab_a[i].style.cursor='pointer';
	  	console.log("index"+tab_a[i].index);
	  	tab_a[i].onclick = function(){
			for(var j=0;j<tab_a.length;j++){
	    		tab_a[j].className = '';
				report[j].style.display="none";
	   		}
			report[this.index].style.display="block";
			this.className= 'on';
	   	}
	}
}












