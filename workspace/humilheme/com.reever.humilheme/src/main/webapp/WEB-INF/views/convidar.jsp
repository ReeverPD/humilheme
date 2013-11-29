<%-- 
    Document   : welcome
    Created on : Nov 4, 2013, 11:32:29 PM
    Author     : iuriandreazza
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/invite.css" media="all" />
        <title>Humilhe.me - Convidar Seu amigo</title>
    </head>
    <body>
        
    <div id="invite">
    
    	<div class="leftCol">
        	<div class="inviteTitle">
            	<h2>Convide um amigo à estragar seu dia. </h2>
            </div>
            
            <div class="leftColBox">
    			
                <div style="width:527px; height:40px; line-height:40px; margin-bottom:10px;">
                    <h3 style="float:left; font-family: 'Pacifico', cursive; color:#888; text-shadow:1px 1px 0px #212121; font-size:20px; font-weight:normal; line-height:40px;">Sugestões</h3>
                    <div style="float:right;">
                        <form enctype="application/x-www-form-urlencoded" method="post">
                            <input type="text" placeholder="Pesquisar amigos do facebook" style="color:#FFF; float:left; margin-right:10px; background:rgba(0, 0, 0, 0.4); border:none; padding:6px 10px; width:280px; height:28px; line-height:28px; font-size:12px; font-family: 'PT Sans', sans-serif;" />
                            <input type="image" src="${pageContext.servletContext.contextPath}/resources/img/btnSearch.png" style="float:right;" />
                            <div class="clear"></div>
                        </form>
                    </div>
                    <div class="clear"></div>
                </div>
                
                <ul class="facebookFriendsList">
                    
                    <li>
                    	<img src="${pageContext.servletContext.contextPath}/resources/img/egua.jpg">
                        <span class="friendName">Fulano de Tal</span>
                    	<a href="#" class="inviteTrigger">Convidar</a>
                    </li>
                    <li>
                    	<img src="${pageContext.servletContext.contextPath}/resources/img/egua2.jpg">
                        <span class="friendName">Fulano de Tal</span>
                    	<a href="#" class="inviteTrigger">Convidar</a>
                    </li>
                    <li>
                    	<img src="${pageContext.servletContext.contextPath}/resources/img/egua3.jpg">
                        <span class="friendName">Fulano de Tal</span>
                    	<a href="#" class="inviteTrigger">Convidar</a>
                    </li>
                    <li>
                    	<img src="img/egua4.jpg">
                        <span class="friendName">Fulano de Tal</span>
                    	<a href="#" class="inviteTrigger">Convidar</a>
                    </li>
                    <li>
                    	<img src="img/egua5.jpg">
                        <span class="friendName">Fulano de Tal</span>
                    	<a href="#" class="inviteTrigger">Convidar</a>
                    </li>
                    
                    <li>
                    	<img src="img/egua2.jpg">
                        <span class="friendName">Fulano de Tal</span>
                    	<a href="#" class="inviteTrigger">Convidar</a>
                    </li>
                    <li>
                    	<img src="img/egua3.jpg">
                        <span class="friendName">Fulano de Tal</span>
                    	<a href="#" class="inviteTrigger">Convidar</a>
                    </li>
                    <li>
                    	<img src="img/egua4.jpg">
                        <span class="friendName">Fulano de Tal</span>
                    	<a href="#" class="inviteTrigger">Convidar</a>
                    </li>
                    <li>
                    	<img src="img/egua5.jpg">
                        <span class="friendName">Fulano de Tal</span>
                    	<a href="#" class="inviteTrigger">Convidar</a>
                    </li>
                    <li>
                    	<img src="img/egua.jpg">
                        <span class="friendName">Fulano de Tal</span>
                    	<a href="#" class="inviteTrigger">Convidar</a>
                    </li>
                    
                    <li>
                    	<img src="img/egua3.jpg">
                        <span class="friendName">Fulano de Tal</span>
                    	<a href="#" class="inviteTrigger">Convidar</a>
                    </li>
                    <li>
                    	<img src="img/egua4.jpg">
                        <span class="friendName">Fulano de Tal</span>
                    	<a href="#" class="inviteTrigger">Convidar</a>
                    </li>
                    <li>
                    	<img src="img/egua5.jpg">
                        <span class="friendName">Fulano de Tal</span>
                    	<a href="#" class="inviteTrigger">Convidar</a>
                    </li>
                    <li>
                    	<img src="img/egua2.jpg">
                        <span class="friendName">Fulano de Tal</span>
                    	<a href="#" class="inviteTrigger">Convidar</a>
                    </li>
                    <li>
                    	<img src="img/egua3.jpg">
                        <span class="friendName">Fulano de Tal</span>
                    	<a href="#" class="inviteTrigger">Convidar</a>
                    </li>
                    
                </ul>
                <div class="clear"></div>
            </div>
            
        </div>
        
        <style type="text/css">
        
        </style>
        
        <div class="margin_bottom_30 rightCol">
        	
            <jsp:include page="../includes/donate.jsp"/>
            
            <div class="hr margin_bottom_20"></div>
            
            <jsp:include page="../includes/adsense.jsp"/>
            
        </div>
        
            <jsp:include page="../includes/footer.jsp"/>

    </div>
    </body>
</html>
