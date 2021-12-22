<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,ducanh.qlbhanuong.dao.*,ducanh.qlbhanuong.model.*"%>
<%@ page import="ducanh.qlbhanuong.model.NhanVien" %>
<%@ page import="ducanh.qlbhanuong.model.DoAn" %>
<%@ page import="java.util.stream.Collectors" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CHỌN KÍCH CỠ SỐ LƯỢNG</title>
    <%@include file ="../header.jsp" %>
</head>
<%
    //lay id nhan vien
    NhanVien sv = (NhanVien) session.getAttribute("nvbh");
    if(sv==null){
        response.sendRedirect("../gdDangNhap.jsp?err=timeout");
    }

    int idDA=0;
    if(request.getParameter("idDoAn") !=null){
        idDA=Integer.parseInt(request.getParameter("idDoAn"));
        DoAnDAO doAnDAO=new DoAnDAO();
        session.setAttribute("doAn",doAnDAO.getDoAnByID(idDA));
    }

    List<KichCoDoAn> listKichCo=new ArrayList<>();

//    listKichCo=kichCoDAO.getKichCoByDA(idDA);

    KichCoDoAnDAO kichCoDoAnDAO=new KichCoDoAnDAO();
//    listKichCo=kichCoDoAnDAO.getKichCoDAByDA(idDA).stream().map(kc->kc.getKichCo()).collect(Collectors.toList());
    listKichCo=kichCoDoAnDAO.getKichCoDAByDA(idDA);
%>

<body>

<h2> CHỌN KÍCH CỠ SỐ LƯỢNG ĐỒ ĂN </h2>

<form name="chonKCSL" action="gdHoaDon.jsp" method="post">
    <table border="0">
        <td>Chọn Kích cỡ:</td>
        <td><select class="form-control" name="kichCo" size=1 >
<%--            <option value="1" selected>--Chon kich co--</option>--%>
            <option value="<%=listKichCo.get(0).getKichCo().getId()%>" selected><%=listKichCo.get(0).getKichCo().getTen()%></option>
            <% for(int i=1;i<listKichCo.size();i++){
                System.out.println(listKichCo.get(i).getKichCo().getId());
            %>
            <option value="<%=listKichCo.get(i).getKichCo().getId()%>">
                <%=listKichCo.get(i).getKichCo().getTen() %></option>
            <%}
            %>
        </select>
        </td>

        <tr>
            <td>Số lượng:</td>
            <td><input  type="number" name="soLuong" id="soLuong" value="1" min="1" max="100" required /></td>
        </tr>
        <tr>
            <td></td>
            <td><input class="btn btn-success" type="submit" value="OK" /></td>
        </tr>
    </table>
</form>

<button type="button" class="btn btn-warning" onclick="document.location='gdChonMonAn.jsp'">Quay lại</button>
</body>
</html>