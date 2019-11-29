<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/28
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/user/upload" method="post" enctype="multipart/form-data">
    <spring:message code="index.face"/> <input type="file" name="face" /><br/>
    <input type="submit" value="<spring:message code="index.sub"/>"/>
  </form>

  <a href="${pageContext.request.contextPath}/user/testdate?sdate=2019-11-28 15:33:00"><spring:message code="index.a1"/></a><br/>
  <a href="${pageContext.request.contextPath}/user/testdate2?sdate=2019-11-28 15:33:00"><spring:message code="index.a2"/></a><br/>
  </body>
</html>
