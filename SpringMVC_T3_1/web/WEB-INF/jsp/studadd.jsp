<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/22
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.min.js"></script>
    <script>
        function check(){
            var sname = $("#stuname").val();
            $.post("${pageContext.request.contextPath}/stud/checkname",{stuname:sname},function(data){
                    if(data){//存在
                        alert("该学生已存在！");
                    }else{
                       //提交表单
                        $("#frm").submit();
                    }
                }
            ,"json");
        }
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/stud/add" method="post" id="frm">
学生姓名： <input type="text" name="stuname" id="stuname"><br/>
学生性别： <input type="radio" name="sex" value="男">男<input type="radio" name="sex" value="女">女<br/>
生日： <input type="date" name="birth"><br/>
班级编号： <input type="text" name="classno"><br/>
身高： <input type="text" name="hight"><br/>
    <input type="button" value="提交" onclick="check()">
</form>

</body>
</html>
