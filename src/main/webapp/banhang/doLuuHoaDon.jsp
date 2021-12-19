<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,ducanh.qlbhanuong.dao.*,ducanh.qlbhanuong.model.*"%>
<%@ page import="java.util.concurrent.TimeUnit" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file ="../header.jsp" %>
        <%
//lay id sinh vien
    NhanVien nv = (NhanVien) session.getAttribute("nvbh");
    if(nv==null){
        response.sendRedirect("../gdDangNhap.jsp?err=timeout");
}
//lay thong do an dat
    ArrayList<DoAnDat> list = (ArrayList<DoAnDat>)session.getAttribute("listDoAnDat");

    HoaDonDAO hoaDonDAO=new HoaDonDAO();
    HoaDon hoaDon=new HoaDon();
    hoaDon.setListDoAnDat(list);
    hoaDon.setNhanVien(nv);
//lay diem doi
    int diem=0;
    if (session.getAttribute("diem")!=null){
        diem=Integer.parseInt(session.getAttribute("diem").toString());
    }
    hoaDon.setDiemDoi(diem);

//    lay thong tin khach hang
    KhachHang khachHang=new KhachHang();
    if (session.getAttribute("khachHang")!=null){
        khachHang=(KhachHang) session.getAttribute("khachHang");
        hoaDon.setKhachHang(khachHang);
    }
    int diemConLai=khachHang.getDiem()-diem;

    DoAnDatDAO doAnDatDAO=new DoAnDatDAO();
    KhachHangDAO khachHangDAO=new KhachHangDAO();
//   luu hoa don va do an dat
    boolean tinhTrang=false;
    if (session.getAttribute("luuHD")!=null) tinhTrang=(boolean) session.getAttribute("luuHD");

    if (!tinhTrang){
        if(hoaDonDAO.luuHoaDon(hoaDon)){
            if (doAnDatDAO.luuDoAnDat(list)){
                if (khachHang!=null){
                    if (khachHangDAO.updateDiem(khachHang,diemConLai)){
                        session.setAttribute("luuHD",true);
                        session.removeAttribute("khachHang");
                        session.removeAttribute("diem");
                        session.removeAttribute("listDoAnDat");
%>
                <%--    <script type="text/javascript">--%>
                <%--        alert("Thanh toán thành công!");--%>
                <%--    </script>--%>

                        <script>
                            window.alert("Thanh toán thành công!");
                            var timer = setTimeout(function() {
                                window.location='gdChinh.jsp'
                            }, 1000);
                        </script>
        <%

//    response.sendRedirect("gdChinh.jsp");
    }}}}}else{
%>
    <script type="text/javascript">
        alert("Thanh toán thất bại!");
        history.back();
    </script>
        <%}%>
