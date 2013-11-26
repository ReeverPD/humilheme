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
        if($("#termos").is(":checked")){
            $("#overlay").fadeIn(1000, function(){
                var element = $(this), 
                    btnClose = element.find(".overlayBtnClose");

                btnClose.bind("click", function(e){
                    e.preventDefault();
                    element.fadeOut(1000, function(){});
                });

            });
        }else{
           $("#termosSpan").css("color", "red");
        }
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
    
    $("#btnDonate").bind('click', function(e){
        e.preventDefault();
        value = $("#txtDonationField").val();
        $.ajax({
            url: APPLICATION_CONTEXT_PATH+"/Doar/"+value,
            type: "POST",
            dataType: "json",
            success : function(data){
                alert(data.sucess);
                if(data.sucess){
                    $("#_xclickPaypal").submit();
                }
            }
        })        
    })
    
    
    $("#btnLoginFace").bind('click', function(e){
        e.preventDefault();
        $("#_frmLoginFace").submit();
    });
    
    
});