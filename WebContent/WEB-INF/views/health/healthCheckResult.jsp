<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="models.Health" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>診断結果</h2>
        <div class="bmi_contents">
            <table>
                <tbody>
                    <tr>
                        <th class="bmi_num">BMI数値</th>
                        <th class="bmi_state">状態</th>
                    </tr>
                    <tr>
                        <td class="too_skinny">16.00未満</td>
                        <td class="too_skinny">痩せすぎ</td>
                    </tr>
                    <tr>
                        <td class="skinny">16.00～18.49</td>
                        <td class="skinny">痩せぎみ</td>
                    </tr>
                    <tr>
                        <td class="standard">18.50～24.99</td>
                        <td class="standard">普通</td>
                    </tr>
                    <tr>
                        <td class="light_obesity">25.00～29.99</td>
                        <td class="light_obesity">肥満度1</td>
                    </tr>
                    <tr>
                        <td class="middle_obesity">30.00～34.99</td>
                        <td class="middle_obesity">肥満度2</td>
                    </tr>
                    <tr>
                        <td class="serious_obesity">35.00～39.99</td>
                        <td class="serious_obesity">肥満度3</td>
                    </tr>
                    <tr>
                        <td class="super_obesity">40.00以上</td>
                        <td class="super_obesity">肥満度4</td>
                    </tr>
                </tbody>
            </table>
            <p>体脂肪量：</p><p class="body_fat_result">"<c:out value="${health.body_fat}" />"</p><br>
            <p>BMI：</p><p class="bmi_result">"<c:out value="${health.bmi}" />"</p><br>
            <p>BMI判定：</p><p class="bodyType_result">"<c:out value="${health.bodyType}" />"</p><br>
            <p>※体脂肪量が低くBMI値が高い方の場合、筋量が多い可能性があるため、<br>
            BMI値が多少高いのは問題ありません。</p>
        </div>

        <div class="metabo_contents">
            <table>
                <tbody>
                    <tr>
                        <th class="gender">性別</th>
                        <th class="waist">腹部肥満（メタボリック）</th>
                    </tr>
                    <tr>
                        <td class="man">男性</td>
                        <td class="man_waist">85.0cm以上</td>
                    </tr>
                    <tr>
                        <td class="woman">女性</td>
                        <td class="woman_waist">90.0cm以上</td>
                    </tr>
                </tbody>
            </table>
            <p>
            メタボリック判定：</p><p class="metabo_result">"<c:out value="${health.metabo}" />"</p>
        </div>

        <div class="nutrition">
        <h2>あなたに必要な栄養素量の目安</h2>
            <p>炭水化物量/日：</p><p class="carbo_result">約<c:out value="${Math.round(health.carbo)}g" /><br></p>
            <p>　たんぱく質量/日：</p><p class="protein_result">約<c:out value="${Math.round(health.protein)}g" /><br></p>
            <p>　脂質量/日：</p><p class="fat_result">約<c:out value="${Math.round(health.fat)}g" /><br></p>
            <p>　総摂取カロリー/日：</p><p class="calorie_result">約<c:out value="${Math.round(health.calorie)}kcal" /></p>
        </div>
    </c:param>
</c:import>