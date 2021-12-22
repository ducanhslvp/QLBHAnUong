<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,ducanh.qlbhanuong.dao.*,ducanh.qlbhanuong.model.*"%>
<%@ page import="ducanh.qlbhanuong.model.NhanVien" %>
<%@ page import="ducanh.qlbhanuong.model.DoAn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CHỌN MÓN ĂN</title>
    <%@include file ="../header.jsp" %>
</head>
<%
//lay id nhan vien
        NhanVien sv = (NhanVien) session.getAttribute("nvbh");
        if(sv==null){
            response.sendRedirect("../gdDangNhap.jsp?err=timeout");
        }
        ArrayList<DoAn> listDoAn=null;
        if (request.getParameter("name")!=null){
            String name =request.getParameter("name");
            DoAnDAO doAnDAO=new DoAnDAO();
            listDoAn=doAnDAO.getDoAnByName(name);
            session.setAttribute("listTimKiem",listDoAn);
        }

//        session.setAttribute("luuHD",false);

%>

<body>

<h2> CHỌN MÓN ĂN </h2>
<div class="container">
<form name="dangnhap" action="gdChonMonAn.jsp" method="post">
    <table border="0">
        <tr>
            <td>Tên món ăn:</td>
            <td><input type="text" name="name" id="name" required/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" class="btn btn-success" value="Tìm kiếm" /></td>
        </tr>
    </table>
</form>
<br>
<%--    ---------------%>
    <%if(listDoAn!=null){%>
    <table class="table table-bordered" >
        <thead>
        <tr>
            <th>STT</th>
            <th>Tên</th>
            <th>Chọn</th>
        </tr>
        </thead>
        <tbody>
        <%
//            if(listDoAn != null)
                for(int i=0; i<listDoAn.size(); i++){
        %>
        <tr>
            <td ><%=(i+1) %></td>
            <td ><%=listDoAn.get(i).getTen() %></td>
            <td >
                <a href="gdChonKichCoSL.jsp?idDoAn=<%=listDoAn.get(i).getId()%>">Chọn</a>
            </td>
        </tr>
        <%} %>
        </tbody>
    </table>
<%} else if (request.getParameter("name")!=null){%>
    <div class="alert alert-danger">
        <strong>Không tìm thấy đồ ăn nào!</strong>
    </div>
    <%}%>
    <br>
<button type="button" class="btn btn-warning" onclick="document.location='gdChinh.jsp'">Quay lại</button>
</form>
</div>
</body>
</html>