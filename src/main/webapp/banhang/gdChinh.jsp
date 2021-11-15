<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="ducanh.qlbhanuong.model.*"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file ="../header.jsp" %>
    <title>Trang chu quan ly</title>
</head>
<body>
<%
    NhanVien sv = (NhanVien) session.getAttribute("nvbh");
    if(sv==null){
        response.sendRedirect("index.jsp?err=timeout");
    }
    List<DoAnDat> list=new ArrayList<>();
    session.setAttribute("listDoAnDat", list);
%>
<h2> Trang chủ sinh viên </h2>
<button onclick="document.location='gdChonMonAn.jsp'">Ban hang an uong</button>
</body>
</html>
