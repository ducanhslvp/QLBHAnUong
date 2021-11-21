<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.ArrayList,ducanh.qlbhanuong.dao.*,ducanh.qlbhanuong.model.*"%>
<%@ page import="ducanh.qlbhanuong.model.NhanVien" %>
<%
        String username = (String)request.getParameter("username");
        String password = (String)request.getParameter("password");
        NhanVien tv = new NhanVien();
    tv.setUsername(username);
    tv.setPassword(password);
    NhanVienDAO dao = new NhanVienDAO();
    boolean kq = dao.kiemtraDangnhap(tv);
    if(kq && (tv.getVaiTro().equalsIgnoreCase("nvbh"))){
        session.setAttribute("nvbh", tv);
        response.sendRedirect("banhang\\gdChinh.jsp");
    }else

        response.sendRedirect("gdDangNhap.jsp?err=fail");

%>