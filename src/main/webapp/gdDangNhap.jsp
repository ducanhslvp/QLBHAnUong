<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.ArrayList,ducanh.qlbhanuong.dao.*,ducanh.qlbhanuong.model.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ĐĂNG NHẬP</title>
    <%@include file ="header.jsp" %>
</head>
<body>
<%
    if(request.getParameter("err") !=null &&
            request.getParameter("err").equalsIgnoreCase("timeout")){
%> <h4>Hết phiên làm việc. Làm ơn đăng nhập lại!</h4><%
}else if(request.getParameter("err") !=null &&
        request.getParameter("err").equalsIgnoreCase("fail")){
%> <h4 color="red">Sai tên đăng nhập/mật khẩu!</h4><%
    }
%>
<h2> Đăng nhập </h2>
<div class="container">
<form name="dangnhap" action="doDangNhap.jsp" method="post">

        <div class="form-group">
            <label for="username">Tên đăng nhập:</label>
            <input type="text" class="form-control" name="username" id="username" required/>
        </div>
        <div class="form-group">
            <label for="password">Mật khẩu:</label>
            <input type="password" class="form-control" name="password" id="password" required>
        </div>
    <br>
        <input type="submit" class="btn btn-success" value="Đăng nhập" />

</form>
</div>
</body>
</html>