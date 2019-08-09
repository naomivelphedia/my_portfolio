<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="models.Health" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>診断結果</title>
    </head>
    <body>
        <h1>診断結果</h1>
        <p>
            身長：<%= Health.getHeight() %><br>
            体重：<%= health.getWeight() %><br>
            BMI ：<%= health.getBmi() %><br>
            体格：<%= health.getBodyType() %>
        </p>
        <a href="/JspTest/HealthCheck" method="get">戻る</a>
    </body>
</html>