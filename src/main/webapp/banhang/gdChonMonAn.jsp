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
        ArrayList<DoAn> listDoAn=new ArrayList<>();
        if (session.getAttribute("listTimKiem")!=null)
            listDoAn = (ArrayList<DoAn>) session.getAttribute("listTimKiem");
//        else listDoAn = (new DoAnDAO()).getDoAnByName("a");
//if (listDoAn.isEmpty()) listDoAn=new ArrayList<>();
//lay danh sach do an


//session.setAttribute("listSVK", listNganh);
////lay danh sach ki hoc dang mo dang ki
//ArrayList<Kihoc> listKi = (new KihocDAO()).getKihocdangki();
%>

<body>

<h2> Chọn ngành </h2>

<form name="dangnhap" action="doTimKiem.jsp" method="post">
    <table border="0">
        <tr>
            <td>Ten mon an:</td>
            <td><input type="text" name="name" id="name" required /></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Tim kiem" /></td>
        </tr>
    </table>
</form>

<%--    ---------------%>

    <table style="border: 1px solid black;border-collapse: collapse;">
        <thead><td style="border: 1px solid black; padding:0 15px 0 15px;">Ma mon</td>
        <td style="border: 1px solid black; padding:0 15px 0 15px;">Ten do an</td>
        <td style="border: 1px solid black; padding:0 15px 0 15px;">Gia tham khao</td>

        <td style="border: 1px solid black; padding:0 15px 0 15px;">Chọn</td>
        </thead>
        <%
            if(listDoAn != null)
                for(int i=0; i<listDoAn.size(); i++){
        %>
        <tr>
            <td style="text-align:center; padding:0 15px 0 15px;"><%=(i+1) %></td>
            <td style="text-align:center; padding:0 15px 0 15px;"><%=listDoAn.get(i).getTen() %></td>
            <td style="padding:0 15px 0 15px;"><%=listDoAn.get(i).getTen() %></td>
            <td style="text-align:center; padding:0 15px 0 15px;">
                <a href="gdChonKichCoSL.jsp?idDoAn=<%=listDoAn.get(i).getId()%>">Chọn</a>
            </td>
        </tr>
        <%} %>
    </table>

</form>
</body>
</html>