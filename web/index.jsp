<%-- 
    Document   : index
    Created on : 17.5.2012, 16:15:32
    Author     : mige
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- JSTL core --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="/header.jspf" %>

<c:if test="${!empty requestScope.error}">
        <h2 class="error">${requestScope.error}</h2>
</c:if>

<form action="NewGame">
    <table class="main-content">
        <tr>
            <td>Jméno hráče:</td>
            <td><input type="text" name="user" /></td>
        </tr>
        <tr>
            <td>Jméno hráče:</td>
            <td><input type="text" name="user" /></td>
        </tr>
        <tr>
            <td>Počet karet:</td>
            <td>
                <select name="size">
                    <option value="16">4x4</option>
                    <option value="64">8x8</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Styl karet:</td>
            <td>
                <select name="theme">
                    <option value="lfg">Looking for group</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Obtížnost soupeře:</td>
            <td>
                <select name="difficulty">
                    <option value="easy">Jednoduchá</option>
                    <option value="medium">Střední</option>
                    <option value="hard">Těžká</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><input type="submit" value="Hrát!" class="submit" /></td>
        </tr>
    </table>
</form>

<%@include file="/footer.jspf" %>