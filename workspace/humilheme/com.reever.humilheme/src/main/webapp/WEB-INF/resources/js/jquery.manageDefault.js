(function($) {

   $.fn.manageDefault = function () {
   
       return this.each(function(){
       
           var self = $(this);
           
           if (self.find(".manageDefault").length) {
               
               var resetDefault = function(el) {
                   el.val(el.attr("title"));
               }
               
               var bindManageDefault = function(el) {
                   
                   el.bind("focusin", function(e){
   
                       var element,
                           oldElement = $(this).clone(),
                           inputType = $(this).attr("type"),                         
                           inputClass = $(this).attr("class"),
                           inputName = $(this).attr("name"),
                           inputValue = $(this).val(),
                           inputTitle = $(this).attr("title"),
                           newElementHtml = '<input type="password" class="' + inputClass + '" name="' + inputName + '" value="' + inputValue + '" title="' + inputTitle + '" />';
                       					   
                       if ($(this).is(".txtToPass")) { 
                           element = $(newElementHtml);
                           $(this).replaceWith(element);
                           $(this).unbind(e.type);
                           element.focus();
                       } else {
                           element = $(this);
                       }
                           
                       if (element.val() == inputTitle) {
                           element.val("");
                       }
                           
                       element.bind("focusout", function(){
                           if (element.val() == "") {
                               element = oldElement;
                               $(this).replaceWith(element);
                               bindManageDefault(element);
                               resetDefault(element);
                           }
                       });
                   
                   });
                   
               }
               
               self.find(".manageDefault").each(function(){
                   resetDefault($(this));
               });
               
               self.find(".manageDefault").each(function(){
                   bindManageDefault($(this));
               });
           }
                       
       });
   }

})(jQuery);