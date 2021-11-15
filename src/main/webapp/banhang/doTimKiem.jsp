<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.ArrayList,ducanh.qlbhanuong.dao.*,ducanh.qlbhanuong.model.*"%>
<%@ page import="ducanh.qlbhanuong.model.NhanVien" %>
<%
    String name = (String)request.getParameter("name");
    DoAnDAO doAnDAO=new DoAnDAO();
    ArrayList<DoAn> list=new ArrayList<>();
    list=doAnDAO.getDoAnByName(name);

    session.setAttribute("listTimKiem",list);
    response.sendRedirect("gdChonMonAn.jsp");
%>