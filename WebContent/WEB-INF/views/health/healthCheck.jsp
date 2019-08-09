<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="models.Health" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>健康診断ツール</title>
    </head>
    <body>
        <h1>あなたの情報を入力してください</h1>
        <form action="/JspTest/HealthCheck" method="post">
        身長：<input type="text" name="height">(cm)<br>
        体重：<input type="text" name="weight">(kg)<br>
        <input type="submit" value="診断">
        </form>
    </body>
</html>