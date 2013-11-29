<%-- 
    Document   : intern-theme
    Created on : Nov 28, 2013, 7:52:50 PM
    Author     : iuriandreazza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    
    <script type="text/javascript">
        APPLICATION_CONTEXT_PATH = '${pageContext.servletContext.contextPath}';
    </script>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/reset.css" media="all" />

    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/fonts.css" media="all" />
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/main.css" media="all" />
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/internal.css" media="all" />

    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/jquery.vegas.css" media="all" />


    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.servletContext.contextPath}/resources/img/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.servletContext.contextPath}/resources/img/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.servletContext.contextPath}/resources/img/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.servletContext.contextPath}/resources/img/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" href="${pageContext.servletContext.contextPath}/resources/img/favicon.png">

        <title><sitemesh:write property='title'/> Humilhe.me - Totalmente desnecessário</title>
        
        <sitemesh:write property='head'/>

    <script type="text/javascript" charset="utf-8">
        (function(G,o,O,g,L,e){G[g]=G[g]||function(){(G[g]['q']=G[g]['q']||[]).push(
         arguments)},G[g]['t']=1*new Date;L=o.createElement(O),e=o.getElementsByTagName(
         O)[0];L.async=1;L.src='//www.google.com/adsense/search/async-ads.js';
        e.parentNode.insertBefore(L,e)})(window,document,'script','_googCsa');
      </script>

</head>
<body>

	<div id="overlay">
    	<div class="overlayContent confirmInviteFriend">
        	<a href="#" class="overlayBtnClose"></a>
            <h2>Deseja ser humilhado por <span>"Luba Shumeiko"</span>?</h2>
            
            <div>
            	<div style="float:left; margin-left:30px; margin-right:10px;"><img src="${pageContext.servletContext.contextPath}/resources/img/chumbaChumbeico.jpg" width="103" height="103" /></div>
            	<div style="float:left;">
                    <label style="display:block; line-height:22px; cursor:pointer;">
                        <input type="checkbox" name="" /> 
                        <span>Enviar 1 solicitação apenas</span>
                    </label>
                    <label style="display:block; line-height:22px; cursor:pointer;">
                        <input type="checkbox" name="" /> 
                        <span>
                            Battle mode! 
                            <a href="#" class="help" title="Ajuda">
                                <img src="${pageContext.servletContext.contextPath}/resources/img/iconHelp.png" />
                            </a>
                        </span>
                    </label>
                    <a href="#" class="btnHumiliate"></a>
             	</div>
            </div>
        </div>
    </div>

	<div id="top">
    	<div class="topContainer">
            <a href="#" class="topLogo"></a>
            <div class="language">
                <span>Português</span>
                <span>|</span>
                <a href="#">English</a>
            </div>
   		</div>
    </div>
    
    <sitemesh:write property='body'/>
    
    <form action="${pageContext.servletContext.contextPath}/Login-Facebook" id="_frmLoginFace" name="_frmLoginFace">
        <input type="hidden" name="x" value="1" />
    </form>
    
    <form name="_xclick" id="_xclickPaypal" action="https://www.paypal.com/br/cgi-bin/webscr" method="post">
        <input type="hidden" name="cmd" value="_xclick">
        <input type="hidden" name="business" value="iuri.andreazza@gmail.com">
        <input type="hidden" name="item_name" value="Humilhe-me Donation">
        <input type="hidden" name="currency_code" value="BRL">
        <input type="hidden" name="amount" value="10.00">
    <!--<input type="image" src="http://www.paypal.com/pt_BR/i/btn/x-click-butcc-donate.gif" border="0" name="submit" alt="Faça pagamentos com o PayPal - é rápido, grátis e seguro!">-->
    </form>
                            
    <script src="${pageContext.servletContext.contextPath}/resources/js/jquery-2.0.0.min.js"></script>    
	<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.vegas.js"></script>
	<script src="${pageContext.servletContext.contextPath}/resources/js/main.js"></script>
    
    <script type="text/javascript">

	$(document).ready(function(){
		
		$.vegas({
			src: "${pageContext.servletContext.contextPath}/resources/img/bg-02.jpg"
		});
				
	});
	
	</script>

</body>
</html>