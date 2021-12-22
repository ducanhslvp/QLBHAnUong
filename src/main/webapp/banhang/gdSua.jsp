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
    <title>SỬA KÍCH CỠ SỐ LƯỢNG</title>
    <%@include file ="../header.jsp" %>
</head>
<%
    //lay id nhan vien
    NhanVien sv = (NhanVien) session.getAttribute("nvbh");
    if(sv==null){
        response.sendRedirect("../gdDangNhap.jsp?err=timeout");
    }


    KichCoDoAnDAO kichCoDoAnDAO=new KichCoDoAnDAO();

    // thuc hien sua
    if(request.getParameter("idSua") !=null){
        int idSua =Integer.parseInt(request.getParameter("idSua"));

        // lay id do an
        ArrayList<DoAnDat> listDoAnDat=null;
        if (session.getAttribute("listDoAnDat")!=null)
            listDoAnDat = (ArrayList<DoAnDat>) session.getAttribute("listDoAnDat");
        int idDoAn=listDoAnDat.get(idSua).getDoAn().getId();

        int sl,kcID;
        if (request.getParameter("soLuong")!=null && request.getParameter("kichCo")!=null) {
            sl = Integer.parseInt(request.getParameter("soLuong"));
            kcID = Integer.parseInt(request.getParameter("kichCo"));
            listDoAnDat.get(idSua).setKichCo(kichCoDoAnDAO.getKichCoDA(idDoAn,kcID).getKichCo());
            listDoAnDat.get(idSua).setSoLuong(sl);

            response.sendRedirect("gdHoaDon.jsp");
        }


    }else{
        //hien thi list kich co
        int id =0;
        if(request.getParameter("id") !=null){
            id =Integer.parseInt(request.getParameter("id"));

        }else response.sendRedirect("gdHoaDon.jsp");

        // lay id do an
        ArrayList<DoAnDat> listDoAnDat=null;
        if (session.getAttribute("listDoAnDat")!=null)
            listDoAnDat = (ArrayList<DoAnDat>) session.getAttribute("listDoAnDat");
        int idDoAn=listDoAnDat.get(id).getDoAn().getId();

        List<KichCoDoAn> listKichCo=new ArrayList<>();
        listKichCo=kichCoDoAnDAO.getKichCoDAByDA(idDoAn);

%>

<body>

<h2> SỬA KÍCH CỠ SỐ LƯỢNG ĐỒ ĂN </h2>

<form name="chonKCSL" action="gdSua.jsp?idSua=<%=id%>" method="post">
    <table border="0">
        <td>Chọn Kích cỡ:</td>
        <td><select class="form-control" name="kichCo" size=1 >
            <%--            <option value="1" selected>--Chon kich co--</option>--%>
            <option value="<%=listKichCo.get(0).getKichCo().getId()%>" selected><%=listKichCo.get(0).getKichCo().getTen()%></option>
            <% for(int i=1;i<listKichCo.size();i++){%>
            <option value="<%=listKichCo.get(i).getKichCo().getId()%>">
                <%=listKichCo.get(i).getKichCo().getTen() %></option>
            <%}
            %>
        </select>
        </td>

        <tr>
            <td>Số lượng:</td>
            <td><input  type="number" name="soLuong" id="soLuong" value="<%=listDoAnDat.get(id).getSoLuong()%>" min="1" max="100" required /></td>
        </tr>
        <tr>
            <td></td>
            <td><input class="btn btn-success" type="submit" value="Sua" /></td>
        </tr>
    </table>
</form>
<%}%>
<button type="button" class="btn btn-warning" onclick="document.location='gdChonMonAn.jsp'">Quay lại</button>
</body>
</html>