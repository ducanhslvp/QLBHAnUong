<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,ducanh.qlbhanuong.dao.*,ducanh.qlbhanuong.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
//lay id sinh vien
    NhanVien nv = (NhanVien) session.getAttribute("nvbh");
    if(nv==null){
        response.sendRedirect("index.jsp?err=timeout");
}
//lay thong do an dat
    ArrayList<DoAnDat> list = (ArrayList<DoAnDat>)session.getAttribute("listDoAnDat");

    HoaDonDAO hoaDonDAO=new HoaDonDAO();
    HoaDon hoaDon=new HoaDon();
    hoaDon.setListDoAnDat(list);
    hoaDon.setNhanVien(nv);

//    lay thong tin khach hang
    if (session.getAttribute("khachHang")!=null){
        hoaDon.setKhachHang((KhachHang) session.getAttribute("khachHang"));
    }
    DoAnDatDAO doAnDatDAO=new DoAnDatDAO();
//   luu hoa don va do an dat
    if(hoaDonDAO.luuHoaDon(hoaDon) && doAnDatDAO.luuDoAnDat(list)){

%>
    <script type="text/javascript">
        alert("Thanh toan thanh cong!");
    </script>
        <%
    response.sendRedirect("gdChinh.jsp");
    }else{
%>
    <script type="text/javascript">
        alert("Thanh toan that bai!");
        history.back();
    </script>
        <%}%>
