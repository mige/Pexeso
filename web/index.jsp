<%-- 
    Document   : index
    Created on : 6.4.2012, 14:17:26
    Author     : mige
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="cs" lang="cs">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta http-equiv="content-language" content="cs" />
        <meta name="author" content="Aleš Nejdr" />
        <title>Pexeso</title>
    </head>
    <body>
        <h1>Pexeso</h1>
        <form>
            Jméno hráče: <input type="text" name="user" /><br />
            Počet karet:
            <select name="size">
                <option value="16">4x4</option>
                <option value="64">8x8</option>
            </select>
            <br />
            Styl karet:
            <select name="theme">
                <option value="lfg">Looking for group</option>
            </select>
            <br />
            Obtížnost soupeře:
            <select name="difficulty">
                <option value="easy">Jednoduchá</option>
                <option value="medium">Střední</option>
                <option value="hard">Těžká</option>
            </select>
            <br />
            <input type="submit" value="Hrát!" />
        </form>
    </body>
</html>