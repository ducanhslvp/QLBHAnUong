<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,ducanh.qlbhanuong.dao.*,ducanh.qlbhanuong.model.*"%>
<%@ page import="ducanh.qlbhanuong.model.NhanVien" %>
<%@ page import="ducanh.qlbhanuong.model.DoAn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Đổi điểm thành viên</title>
    <%@include file ="../header.jsp" %>
</head>
<%
    //lay id sinh vien
    NhanVien nv = (NhanVien) session.getAttribute("nvbh");
    if(nv==null){
        response.sendRedirect("../gdDangNhap.jsp?err=timeout");
    }
    String ma=request.getParameter("maTV");

%>

<body>

<h2> ĐỔI ĐIỂM THÀNH VIÊN</h2>

<form name="doidoem" action="gdDoiDiem.jsp" method="post">

    <table border="0">
        <tr>
            <td>Mã thành viên:</td>
            <td><input type="text" name="maTV" id="maTV" required /></td>
            <td></td>
            <td><input class="btn btn-success" type="submit" value="OK" /></td>
        </tr>
        <tr>

        </tr>
    </table>
</form>
<br>
<form name="doidiem" action="gdHoaDon.jsp" method="post">
    <%
        if(ma != null ) {
            KhachHangDAO khachHangDAO=new KhachHangDAO();
            KhachHang khachHang=khachHangDAO.getKhachHangByMaTV(ma);
            session.setAttribute("khachHang",khachHang);
            if (khachHang.getTen()!=null){
    %>
    <table border="0">
        <tr><td>Mã thành viên: <%=khachHang.getMaTV()%></td></tr>
        <tr><td>Tên: <%=khachHang.getTen()%></td></tr>
        <tr><td>Địa chỉ: <%=khachHang.getDiaChi()%></td></tr>
        <tr><td>SDT: <%=khachHang.getSdt()%></td></tr>
        <tr><td >Điểm: <%=khachHang.getDiem()%></td></tr>
        <tr><td>Điểm đổi:</td>
            <td><input type="text" name="diemDoi" id="diemDoi" value="<%=khachHang.getDiem()%>" required /></td>
        </tr>
        <tr>
            <td></td>
            <td><input class="btn btn-success" type="submit" value="Đổi điểm" /></td>
        </tr>
    </table>
    <%}} %>
    <button type="button" class="btn btn-warning" onclick="document.location='gdHoaDon.jsp'">Quay lại</button>
</form>
</body>
</html>
