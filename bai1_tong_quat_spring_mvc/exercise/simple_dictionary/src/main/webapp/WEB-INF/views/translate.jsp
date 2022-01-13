<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/11/2022
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<html>
<head>
    <title>Title</title>

</head>
<body>
<h2> Dictionary</h2>
<form method="post" action="/translate">
    <input  id="inputWord" type="text" name="wordSearch" placeholder="Enter your word: "><br><br>
    <input type="submit" id="submit" value="Search"><br>
    <h2>${result}</h2>
</form>
</body>
</html>