$(document).ready(function(){
	
	//semeadores
	$(".btnSemeadores").bind("click", function(e){
		e.preventDefault();
		var element = $(this).parent();
		if (element.is(".opened")){
			element.removeClass("opened");
			element.animate({"right": "-495px"});
		} else {
			element.addClass("opened");
			element.animate({"right": "0px"});
		}
	});
	
	//overlay
	$(".btnEstrague").bind("click", function(e){
		e.preventDefault();
		$("#overlay").fadeIn(1000, function(){
			var element = $(this), 
				btnClose = element.find(".overlayBtnClose");
				
			btnClose.bind("click", function(e){
				e.preventDefault();
				element.fadeOut(1000, function(){});
			});
				
		});
	});
	
	$(".facebookFriendsList .inviteTrigger").bind("click", function(e){
		e.preventDefault();
		$("#overlay").fadeIn(1000, function(){
			var element = $(this), 
				btnClose = element.find(".overlayBtnClose");
				
			btnClose.bind("click", function(e){
				e.preventDefault();
				element.fadeOut(1000, function(){});
			});
				
		});
	});
});