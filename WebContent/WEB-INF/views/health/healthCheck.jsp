<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="models.Health" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${errors != null}">
            <div class="errors_message">
                <c:out value="${errors}"></c:out>
            </div>
        </c:if>
        <h2>あなたの情報を入力してください</h2>
        <br />

        <form method="POST" action="<c:url value='index.html' />">

        <label for="age">年齢（必須）</label><br />
        <input type="text" name="age" value="${health.age}" /><p>　歳</p>
        <br /><br />

        <label for="gender_flag">性別</label><br />
        <select name="gender_flag">
            <option value="0"<c:if test="${health.gender_flag == 0}"> selected</c:if>>男</option>
            <option value="1"<c:if test="${health.gender_flag == 1}"> selected</c:if>>女</option>
        </select>
        <br /><br />

        <label for="height">身長（必須）</label><br />
        <input type="text" name="height" value="${health.height}" /><p>　cm</p>
        <br /><br />

        <label for="weight">体重（必須）</label><br />
        <input type="text" name="weight" value="${health.weight}" /><p>　kg</p>
        <br /><br />

        <label for="fat_percentage">体脂肪率</label><br />
        <input type="text" name="fat_percentage" value="${health.fat_percentage}" /><p>　％</p>
        <br /><br />

        <label for="waist">腹囲</label><br />
        <input type="text" name="waist" value="${health.waist}" /><p>　cm</p>
        <br /><br />

        <p>　・あなたの1日の活動量を選択してください</p>
        <br />
        <input type="radio" name="activity" value="low" checked="checked"<c:if test="${health.activity == low}"></c:if>class="activity_button" /><p>低い（静的な活動が多く、デスクワークが中心。また、生活の大部分が座位中心の場合）</p>
        <br />
        <input type="radio" name="activity" value="usually"<c:if test="${health.activity == usually}"></c:if> class="activity_button" /><p>普通（座位中心だが、短距離の移動や立位作業、あるいは接客や家事、軽いスポーツ活動を含む）</p>
        <br />
        <input type="radio" name="activity" value="high"<c:if test="${health.activity == high}"></c:if> class="activity_button" /><p>高い（移動や立位の作業が多い従事者。また、定期的にスポーツなどの活発な運動習慣を持っている場合）</p>
        <br /><br />

        <input type="hidden" name="_token" value="${_token}" />
        <button type="submit">診断</button>

        </form>
    </c:param>
</c:import>