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
    ArrayList<DoAnDat> listDoAnDat=new ArrayList<>();

    if (session.getAttribute("listDoAnDat")!=null)
        listDoAnDat = (ArrayList<DoAnDat>) session.getAttribute("listDoAnDat");

    int diem=0;
    if(request.getParameter("diemDoi")!=null){
        diem=Integer.parseInt(request.getParameter("diemDoi"));
    }
    int sl,kcID;
    if (request.getParameter("soLuong")!=null && request.getParameter("kichCo")!=null){
        sl=Integer.parseInt(request.getParameter("soLuong"));
        kcID=Integer.parseInt(request.getParameter("kichCo"));

        DoAnDat doAnDat=new DoAnDat();
        doAnDat.setGiaMua(10000);

        KichCoDAO kichCoDAO=new KichCoDAO();
        if (session.getAttribute("doAn")!=null){
            doAnDat.setDoAn((DoAn) session.getAttribute("doAn"));
            doAnDat.setSoLuong(sl);
            doAnDat.setKichCo(kichCoDAO.getKichCoByID(kcID));
        }
        listDoAnDat.add(doAnDat);
    }

    int tongTien=0-diem;
%>
<body>
<h2> Chọn ngành </h2>

<table style="border: 1px solid black;border-collapse: collapse;">
    <thead>
        <td style="border: 1px solid black; padding:0 15px 0 15px;">Ma do an</td>
        <td style="border: 1px solid black; padding:0 15px 0 15px;">Ten Do An</td>
        <td style="border: 1px solid black; padding:0 15px 0 15px;">Gia</td>
        <td style="border: 1px solid black; padding:0 15px 0 15px;">Kich co</td>
        <td style="border: 1px solid black; padding:0 15px 0 15px;">So Luong</td>
    </thead>
    <%
        if(listDoAnDat != null)
            for(int i=0; i<listDoAnDat.size(); i++){
                tongTien+=listDoAnDat.get(i).getGiaMua();
    %>
    <tr>
        <td style="text-align:center; padding:0 15px 0 15px;"><%=(i+1) %></td>
        <td style="text-align:center; padding:0 15px 0 15px;"><%=listDoAnDat.get(i).getDoAn().getTen() %></td>
        <td style="padding:0 15px 0 15px;"><%=listDoAnDat.get(i).getGiaMua() %></td>
        <td style="padding:0 15px 0 15px;"><%=listDoAnDat.get(i).getKichCo().getTen() %></td>
        <td style="padding:0 15px 0 15px;"><%=listDoAnDat.get(i).getSoLuong() %></td>

    </tr>
    <%} %>
</table>

<%if (diem>0){%>
    <h3>Diem da doi: -<%=diem%></h3>
<%}%>
<h3>Tong tien: <%=tongTien%></h3>
<br>
<button onclick="document.location='gdChonMonAn.jsp'">Them mon</button>
<button onclick="document.location='gdChinh.jsp'">Trang chu</button>
<button onclick="document.location='doLuuHoaDon.jsp'">Thanh toan</button>
<button onclick="document.location='gdDoiDiem.jsp'">Doi diem</button>

</form>
</body>
</html>