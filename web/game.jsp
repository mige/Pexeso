<%-- 
    Document   : game
    Created on : 9.5.2012, 18:02:22
    Author     : mige
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- JSTL core --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="/header.jspf" %>

<div class="right">
    <h3>Aktuální hra</h3>
    <table class="stats">
        <tr>
            <th>Hráč</th>
            <th>Nalezeno dvojic</th>
        </tr>
    <c:forEach items="${sessionScope.game.getPlayers()}" var="player">
        ${player}
    </c:forEach>
    </table>
    <%@include file="/stats.jspf" %>
</div>

<div class="left">
    <div class="main-content">
        <div style="text-align: center">
            <c:choose>
                <c:when test="${requestScope.gameFinished}">
                    <div class="maininfo">Konec hry</div>
                    <div class="maininfo">${requestScope.winnertext}</div>
                    <a href="index.jsp" class="submit">Začít novou hru</a>
                </c:when>
                <c:otherwise>
                    <div class="maininfo"><span style="color: #666666;">Na řadě je hráč:</span> ${sessionScope.game.getNowPlayingPlayer().getName()}</div>
                    <c:if test="${requestScope.refresh}">
                        <div class="info">Karty se zpět otočí za 5 vteřin. Chete je <a href="Game">otočit ihned</a>?</div>
                    </c:if>
                    <c:forEach items="${sessionScope.game.getCardsList()}" var="card" varStatus="status">
                        <c:choose>
                            <c:when test="${card.isRemoved()}">
                                <img src="themes/blank.gif" />
                            </c:when>
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
</div>

<%@include file="/footer.jspf" %>
