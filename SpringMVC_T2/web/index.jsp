<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/19
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="${pageContext.request.contextPath}/user/login">访问USerController</a><br/>
  <a href="${pageContext.request.contextPath}/hello/test1">modelandview测试</a><br/>
  <a href="${pageContext.request.contextPath}/hello/test2">model map  modelMap测试</a><br/>
  <a href="${pageContext.request.contextPath}/hello/param1?str=ht">参数测试1</a><br/>
  <a href="${pageContext.request.contextPath}/hello/param2">参数测试2</a><br/>
  <a href="${pageContext.request.contextPath}/hello/param3?id=1&uname=zhangsan&hight=175.5">参数测试2</a><br/>
  <form action="${pageContext.request.contextPath}/hello/param4" method="post">
    <input name="id"/><br/>
    <input name="uname"/><br/>
    <input name="age"/><br/>
    <input name="hight"/><br/>
    <input type="submit" value="提交">
    <a href="${pageContext.request.contextPath}/hello/param5/123">参数测试2</a><br/>
    <a href="${pageContext.request.contextPath}/hello/param6?uname=zhangsan&role.rid=123&role.uname=lisi">参数测试2</a><br/>
  </form>
  </body>
</html>
