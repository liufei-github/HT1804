<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/22
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table cellspacing="1" bgcolor="#7fffd4" width="70%" align="center">
        <tr bgcolor="white">
            <th>编号</th>
            <th>姓名</th>
            <th>生日</th>
            <th>性别</th>
            <th>班级编号</th>
            <th>身高</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${p.datas}" var="d">
            <tr bgcolor="white">
                <td>${d.stuno}</td>
                <td>${d.stuname}</td>
                <td>${d.birth}</td>
                <td>${d.sex}</td>
                <td>${d.classno}</td>
                <td>${d.hight}</td>
                <td><a href="${pageContext.request.contextPath}/stud/toupd?stuno=${d.stuno}">修改</a> <a href="${pageContext.request.contextPath}/stud/del?stuno=${d.stuno}" onclick="return confirm('是否删除？')">删除</a></td>
            </tr>
        </c:forEach>
        <tr><td colspan="7">共${p.totalRow}条数据，当前第${p.currPage}/${p.totalPage}页 <a href="${pageContext.request.contextPath}/stud/list?currPage=1">首页</a> <a href="${pageContext.request.contextPath}/stud/list?currPage=${p.currPage-1}">上一页</a> <a href="${pageContext.request.contextPath}/stud/list?currPage=${p.currPage+1}">下一页</a> <a href="${pageContext.request.contextPath}/stud/list?currPage=${p.totalPage}">尾页</a></td></tr>
    </table>

    <a href="${pageContext.request.contextPath}/stud/toadd">添加</a>
</body>
</html>
