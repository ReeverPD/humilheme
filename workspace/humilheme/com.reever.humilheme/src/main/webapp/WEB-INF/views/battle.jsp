<%-- 
    Document   : battle
    Created on : Dec 2, 2013, 1:07:07 PM
    Author     : iuriandreazza
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/invite.css" media="all" />
        <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/humiliate.css" media="all" />
        <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/battle.css" media="all" />

        <title>Humilhe.me - Modo de Batalha! ${userA.profileName} vs ${userB.profileName}</title>
    </head>
    <body>
        
        <div id="invite">
    
    	<div class="leftCol">
        	<div class="inviteTitle">
            	<h2>Battle mode!</h2>
            </div>
                        
            <div class="leftColBox">
    			
                <div class="fightersBox">
                	<div class="left">
                    	<span class="fighterName">${userA.profileName}</span>
                    	<span><img src="http://graph.facebook.com/${userA.profileId}/picture?width=66&height=66" /></span>
                    </div>
                    <div class="right">
                    	<span><img src="http://graph.facebook.com/${userB.profileId}/picture?width=66&height=66" /></span>
                        <span class="fighterName">${userB.profileName}</span>
                    </div>
                	<div class="clear"></div>
                </div>
                <c:if test="${showXingamentoBox eq true}">
                    <div class="humiliationBox">
                        <textarea name="humiliation" id="humiliation" placeholder="Digite aqui sua humilhação e estrague o dia do seu amigo!"></textarea>
                        <div class="sub">
                            <span class="asterisk">*</span> 
                            <span class="text">Sua humilhação será postada na timeline de seu amigo.</span>
                            <div class="clear"></div>
                            <span class="asterisk">*</span> 
                            <span class="text">Seu amigo poderá se vingar, e será postada em sua timeline.</span>
                            <div class="clear"></div>
                        </div>
                        <input type="image" src="${pageContext.servletContext.contextPath}/resources/img/btnHumiliate.png" title="Humilhar" class="btnHumiliate" />
                        <div class="clear"></div>
                    </div>

                    <div class="suggestions">
                        <h3>Sugestões:</h3>
                        <ul>
                            <li><span>&bull;</span>Faça uma comparação</li>
                            <li><span>&bull;</span>Exponha um fato constrangedor</li>
                            <li><span>&bull;</span>Faça piada de seus problemas</li>
                            <li><span>&bull;</span>Menospreze suas conquistas</li>
                        </ul>
                        <div class="clear"></div>
                    </div>
                </c:if>
                <c:if test="${showXingamentoBox eq false}">
                    <div class="xingamentosBox">
                        <c:forEach var="cuss" items="${lstBattle}">
                            <div class="xingamento">
                                <span class="xingamentoMessage">${cuss.mensagem}</span>
                            </div>
                        </c:forEach>
                        <div class="clear"></div>
                    </div>
                </c:if>
                <div class="clear"></div>
            </div>
            
        </div>
                
        <div class="margin_bottom_30 rightCol">
        	
            <jsp:include page="../includes/donate.jsp"/>
            
            <div class="hr margin_bottom_20"></div>
            
            <jsp:include page="../includes/adsense.jsp"/>
            
        </div>
        
            <jsp:include page="../includes/footer.jsp"/>

    </div>
        
        
    </body>
</html>
