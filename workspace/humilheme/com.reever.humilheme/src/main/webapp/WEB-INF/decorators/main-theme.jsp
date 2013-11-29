<%-- 
    Document   : main-theme
    Created on : Nov 22, 2013, 4:48:43 PM
    Author     : iuriandreazza
--%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    
    <script type="text/javascript">
        APPLICATION_CONTEXT_PATH = '${pageContext.servletContext.contextPath}';
    </script>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/reset.css" media="all" />

    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/fonts.css" media="all" />
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/main.css" media="all" />

    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/jquery.vegas.css" media="all" />
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/jquery.jscrollpane.css" media="all" />

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
    
    <div id="fb-root"></div>
    <script>(function(d, s, id) {
      var js, fjs = d.getElementsByTagName(s)[0];
      if (d.getElementById(id)) return;
      js = d.createElement(s); js.id = id;
      js.src = "//connect.facebook.net/pt_BR/all.js#xfbml=1&appId=273665462654543";
      fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));</script>
    
    <div id="adcontainer2"></div>
    <script type="text/javascript" charset="utf-8"> 
    var pageOptions = { 
      'pubId': 'test pub-id',
      'query': 'hotel',
      'channel': '123456789',
      'hl': 'en',
      'adtest': 'on',
      'domainLinkAboveDescription': true,
      'siteLinks': false
    };

    var adblock1 = { 
      'container': 'adcontainer2',
      'maxTop': 2,
      'width': '320px',
      'fontFamily': 'tahoma',
      'fontSizeTitle': 13,
      'fontSizeDescription': 10,
      'fontSizeDomainLink': 9,
      'colorTitleLink': '#4F8C3F',
      'colorDomainLink': '#747D80',
      'colorBackground': '#000000',
      'colorAdBorder': '#000000'
    };

    _googCsa('ads', pageOptions, adblock1);

    </script>

    
</body>
</html>