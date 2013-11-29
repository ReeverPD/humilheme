<%-- 
    Document   : donate
    Created on : Nov 29, 2013, 3:52:21 PM
    Author     : iuriandreazza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="donation">
    <div class="donationContent">
        <form enctype="application/x-www-form-urlencoded" method="post" class="defaultForm">
            <div>
                <div class="donTop">
                    <h1>Humilhe-nos fazendo uma doação: </h1>
                    <input type="text" id="txtDonationField" name="donation_humilhation"  class="field" placeholder="sua blasfêmia aqui!" />
                </div>
                <div>
                    <div class="cardFlags" style=""><img src="${pageContext.servletContext.contextPath}/resources/img/cardFlags01.png" /></div>
                    <a href="#" id="btnDonate" class="btnDonate"></a>
                    <div class="clear"></div>
                </div>
                <div class="clear"></div>
            </div>
        </form>
    </div>
</div>
