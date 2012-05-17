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
            <c:choose>
                <c:when test="${status.count % sessionScope.game.getWidth() == 0}">
                    <br />
                </c:when>
            </c:choose>
        </c:forEach>
    </div>
</div>

<div class="right">
    Hráč: ${sessionScope.username}
    <%@include file="/stats.jspf" %>
</div>

<%@include file="/footer.jspf" %>
