<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/21
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form action="${pageContext.request.contextPath}/hello/login" method="post">
      用户名：<input type="text" name="uname"/><br/>
      密码：<input type="password" name="pwd"/><br/>
      <input type="submit" value="登录"/>
    </form>

  <br/>

    <a href="${pageContext.request.contextPath}/hello/test?abc=1234&aaa=88888888">测试MOdelAttribute</a><br/>
    <a href="${pageContext.request.contextPath}/hello/testCookie">测试testCookie</a><br/>
    <a href="${pageContext.request.contextPath}/hello/response/ContentType">测试返回JSON 格式数据</a><br/>
    <a href="javascript:void(0)" onclick="selUser()">Ajax请求</a>

    <script src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.min.js"></script>
    <script>
      function selUser(){
          $.post("${pageContext.request.contextPath}/hello/sel",{},function (data){
            alert(data.length);
            alert(data[0].uname+" "+data[0].pwd);
          },"json");
      }

    </script>


    <a href="${pageContext.request.contextPath}/hello/forwad">测试跳转</a>
  </body>
</html>
