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
    int idDA=0;
    if(request.getParameter("idDoAn") !=null){
        idDA=Integer.parseInt(request.getParameter("idDoAn"));
        DoAnDAO doAnDAO=new DoAnDAO();
        session.setAttribute("doAn",doAnDAO.getDoAnByID(idDA));
    }

    ArrayList<KichCo> listKichCo=new ArrayList<>();
    KichCoDAO kichCoDAO=new KichCoDAO();
    listKichCo=kichCoDAO.getKichCoByDA(idDA);

%>

<body>

<h2> Chọn Kich Co so luong </h2>

<form name="chonKCSL" action="gdHoaDon.jsp" method="post">
    <table border="0">
        <td>Chọn Kich co:</td>
        <td><select name="kichCo" size=1 >
<%--            <option value="1" selected>--Chon kich co--</option>--%>
            <option value="<%=listKichCo.get(0).getId()%>" selected><%=listKichCo.get(0).getTen()%></option>
            <% for(int i=1;i<listKichCo.size();i++){%>
            <option value="<%=listKichCo.get(i).getId()%>">
                <%=listKichCo.get(i).getTen() %></option>
            <%}
            %>
        </select>
        </td>

        <tr>
            <td>So luong:</td>
            <td><input type="text" name="soLuong" id="soLuong" value="1" required /></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="OK" /></td>
        </tr>
    </table>
</form>

<%--    ---------------%>

<%--<table style="border: 1px solid black;border-collapse: collapse;">--%>
<%--    <thead><td style="border: 1px solid black; padding:0 15px 0 15px;">Ma mon</td>--%>
<%--    <td style="border: 1px solid black; padding:0 15px 0 15px;">Ten do an</td>--%>
<%--    <td style="border: 1px solid black; padding:0 15px 0 15px;">Gia tham khao</td>--%>

<%--    <td style="border: 1px solid black; padding:0 15px 0 15px;">Chọn</td>--%>
<%--    </thead>--%>
<%--    <%--%>
<%--        if(listDoAn != null)--%>
<%--            for(int i=0; i<listDoAn.size(); i++){--%>
<%--    %>--%>
<%--    <tr>--%>
<%--        <td style="text-align:center; padding:0 15px 0 15px;"><%=(i+1) %></td>--%>
<%--        <td style="text-align:center; padding:0 15px 0 15px;"><%=listDoAn.get(i).getTen() %></td>--%>
<%--        <td style="padding:0 15px 0 15px;"><%=listDoAn.get(i).getTen() %></td>--%>
<%--        <td style="text-align:center; padding:0 15px 0 15px;">--%>
<%--            <a href="gdChonKichCoSL.jsp?idDoAn=<%=listDoAn.get(i).getId()%>">Chọn</a>--%>
<%--        </td>--%>
<%--    </tr>--%>
<%--    <%} %>--%>
<%--</table>--%>

</form>
</body>
</html>