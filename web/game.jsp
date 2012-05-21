<%-- 
    Document   : game
    Created on : 9.5.2012, 18:02:22
    Author     : mige
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- JSTL core --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="/header.jspf" %>

<div class="left">
    <div class="main-content">
        <c:choose>
            <c:when test="${requestScope.gameFinished}">
                <h3>Konec hry.</h3>
            </c:when>
            <c:otherwise>
                <c:forEach items="${sessionScope.game.getCardsList()}" var="card" varStatus="status">
                    <c:choose>
                        <c:when test="${!card.isFacing()}">
                            <a href="Game?action=turn&position=${status.count}"><img src="themes/${sessionScope.theme}/back.gif" /></a>
                        </c:when>
                        <c:when test="${card.getIdCard() < 10}">
                            <img src="themes/${sessionScope.theme}/0${card.getIdCard()}.gif" />
                        </c:when>
                        <c:otherwise>
                            <img src="themes/${sessionScope.theme}/${card.getIdCard()}.gif" />
                        </c:otherwise>
                    </c:choose>
                    <c:if test="${status.count % sessionScope.game.getWidth() == 0}">
                        <br />
                    </c:if>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </div>
</div>

<div class="right">
    Na řadě je hráč: ${sessionScope.game.getNowPlayingPlayer().getName()}
    <%@include file="/stats.jspf" %>
</div>

<%@include file="/footer.jspf" %>
