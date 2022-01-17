<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/11/2022
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Setting</h3>
<form:form action="/update" method="post" modelAttribute="email">
    <fieldset>
        <legend>Setting</legend>
        <table>
            <tr>
                <td>Languages</td>
                <td>
                    <form:select path="languages">
                        <form:option value="English"> English</form:option>
                        <form:option value="Vietnamese"> Vietnamese</form:option>
                        <form:option value="Japanese">Japanese</form:option>
                        <form:option value="Chinese">Chinese</form:option>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Page Size</td>
                <td>
                    Show
                    <form:select path="pageSize">
                        <form:option value="5">5</form:option>
                        <form:option value="10">10</form:option>
                        <form:option value="15">15</form:option>
                        <form:option value="25">25</form:option>
                        <form:option value="50">50</form:option>
                        <form:option value="100">100</form:option>
                    </form:select>
                    emails per page
                </td>
            </tr>
            <tr>
                <td>Spams filter</td>
                <td>
                    <form:checkbox path="spamFilter" value="1"/> Enable spams filter
                </td>
            </tr>
            <tr>
                <td>Signature</td>
                <td>
                    <form:textarea path="signature" rows="4" />
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <form:button>Update</form:button>
                    <a href="" style="margin-left: 20px"><button>Cancel</button></a>
                </td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>