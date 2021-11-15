<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,ducanh.qlbhanuong.dao.*,ducanh.qlbhanuong.model.*"%>
<%@ page import="ducanh.qlbhanuong.model.NhanVien" %>
<%@ page import="ducanh.qlbhanuong.model.DoAn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Chon nganh hoc</title>
</head>
<%
    //lay id sinh vien
    NhanVien sv = (NhanVien) session.getAttribute("nvbh");
    if(sv==null){
        response.sendRedirect("index.jsp?err=timeout");
    }
    String ma=request.getParameter("maTV");

%>

<body>

<h2> Chọn ngành </h2>

<form name="doidoem" action="gdDoiDiem.jsp" method="post">

    <table border="0">
        <tr>
            <td>Ma thanh vien:</td>
            <td><input type="text" name="maTV" id="maTV" required /></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Tim kiem" /></td>
        </tr>
    </table>
</form>
<form name="doidiem" action="gdHoaDon.jsp" method="post">
    <%
        if(ma != null ) {
            KhachHangDAO khachHangDAO=new KhachHangDAO();
            KhachHang khachHang=khachHangDAO.getKhachHangByMaTV(ma);
            session.setAttribute("khachHang",khachHang);
            if (!Objects.isNull(khachHang)){
    %>
    <table border="0">
        <tr><td>Ma thanh vien: <%=khachHang.getMaTV()%></td></tr>
        <tr><td>Ten: <%=khachHang.getTen()%></td></tr>
        <tr><td>Dia chi: <%=khachHang.getDiaChi()%></td></tr>
        <tr><td>SDT: <%=khachHang.getSdt()%></td></tr>
        <tr><td >Diem: <%=khachHang.getDiem()%></td></tr>
        <tr><td>Diem doi:</td>
            <td><input type="text" name="diemDoi" id="diemDoi" value="<%=khachHang.getDiem()%>" required /></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Xac nhan doi diem" /></td>
        </tr>
    </table>
    <%}} %>
</form>
</body>
</html>
