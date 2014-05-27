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
	
    //Show Overlay
	$(".facebookFriendsList .inviteTrigger").bind("click", function(e){
		e.preventDefault();
        el = $(e.currentTarget);
        
        $("#btnHumilhe").attr("data-profile-id", el.attr('data-profile-id'));
        $("#profilePic").attr("src", el.attr('data-picture'));
        $("#txtNameHumilhe").text(el.attr('data-name'));
        
		$("#overlay").fadeIn(1000, function(){
			var element = $(this), 
				btnClose = element.find(".overlayBtnClose");
				
			btnClose.bind("click", function(e){
				e.preventDefault();
				element.fadeOut(1000, function(){});
			});
				
		});
	});
    
    //Função Doar
    $("#btnDonate").bind('click', function(e){
        e.preventDefault();
        value = $("#txtDonationField").val();
        showLoading();
        $.ajax({
            url: APPLICATION_CONTEXT_PATH+"/doar/"+value,
            type: "POST",
            dataType: "json",
            success : function(data){
                if(data.id){
                    hideLoading();
                    $("#_xclickPaypal").submit();
                }
            }
        })        
    })
    
    
    $("#btnLoginFace").bind('click', function(e){
        e.preventDefault();
        
    });
    
    $("#btnSearch").bind('click', function(e){
        e.preventDefautl();
        $("#frmPesquisar").submit();
    });
    
    $("#btnHumilhe").bind('click', function(e){
        e.preventDefault();
        $("input[name='friendId']").val($("#btnHumilhe").attr("data-profile-id"));
        $("input[name='friendName']").val($("#txtNameHumilhe").text());
        $("#frmHumiliate").submit();
        
    });
    $.prettyLoader({
			animation_speed: 'fast', /* fast/normal/slow/integer */
			bind_to_ajax: true, /* true/false */
			delay: false, /* false OR time in milliseconds (ms) */
            loader: APPLICATION_CONTEXT_PATH+'/assets/ajax-loader.gif',
			offset_top: 13, /* integer */
			offset_left: 10 /* integer */
    });
    
    $(".btnHumiliate").bind('click', function(e){
        e.preventDefault();
        showLoading();
        var message = $("#humiliation").val();
        $.ajax({
            url: APPLICATION_CONTEXT_PATH+"/app/batalhar/humiliate/{requestId}/",
            data : { mensagem: message },
            type: "POST",
            dataType: "json",
            success : function(data){
                if(data.sucess){
                    hideLoading();
                }
            }
        })  
    });
});

function showLoading(){
    $.prettyLoader.show();
}


function hideLoading(){
    $.prettyLoader.hide();
}