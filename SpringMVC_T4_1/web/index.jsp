<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/26
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="${pageContext.request.contextPath}/emp/test1">普通路径映射</a><br/>
  <a href="${pageContext.request.contextPath}/emp/test2/123/topics/abc">URI路径映射</a><br/>
  <a href="${pageContext.request.contextPath}/emp/product">URI路径映射</a><br/>
  <a href="${pageContext.request.contextPath}/emp/users/123/create">测试路径映射的优先级</a><br/>
  <a href="${pageContext.request.contextPath}/emp/pro/11">正则路径映射的优先级</a><br/>
  </body>
</html>
