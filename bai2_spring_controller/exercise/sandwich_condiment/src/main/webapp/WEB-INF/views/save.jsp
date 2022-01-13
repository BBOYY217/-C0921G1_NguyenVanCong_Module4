<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/11/2022
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/sandwich" method="post">
    <div>
        <input type="checkbox" name="sandwichCheckbox" id="lettuce" value="Lettuce"> <label for="lettuce">Lettuce</label>
        <input type="checkbox" name="sandwichCheckbox" id="tomato" value="Tomato"> <label for="tomato">Tomato</label>
        <input type="checkbox" name="sandwichCheckbox" id="mustard" value="Mustard"> <label for="mustard">Mustard</label>
        <input type="checkbox" name="sandwichCheckbox" id="sprouts" value="Sprouts"> <label for="sprouts">Sprouts</label>
    </div>
    <div>
        <button type="submit">Save</button>
    </div>
    <c:if test="${requestScope['sandwichCheckbox'] != null}">
        <ul>
            <c:forEach items="${requestScope['sandwichCheckbox']}" var="sandwich">
                <li><c:out value="${sandwich}"/></li>
            </c:forEach>
        </ul>
    </c:if>
</form>
</body>
</html>