<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,ducanh.qlbhanuong.dao.*,ducanh.qlbhanuong.model.*"%>
<%@ page import="ducanh.qlbhanuong.model.NhanVien" %>
<%@ page import="ducanh.qlbhanuong.model.DoAn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>DANH SÁCH ĐỒ ĂN</title>
    <%@include file ="../header.jsp" %>
</head>
<%
    //lay id sinh vien
    NhanVien nv = (NhanVien) session.getAttribute("nvbh");
    if(nv==null){
        response.sendRedirect("../gdDangNhap.jsp?err=timeout");
    }

    ArrayList<DoAnDat> listDoAnDat=new ArrayList<>();

    if (session.getAttribute("listDoAnDat")!=null)
        listDoAnDat = (ArrayList<DoAnDat>) session.getAttribute("listDoAnDat");

    int diem=session.getAttribute("diem")==null?0: (int) session.getAttribute("diem");

    if(request.getParameter("diemDoi")!=null){
        diem=Integer.parseInt(request.getParameter("diemDoi"));
    }
    session.setAttribute("diem",diem);
    int sl,kcID;
    if (request.getParameter("soLuong")!=null && request.getParameter("kichCo")!=null){
        sl=Integer.parseInt(request.getParameter("soLuong"));
        kcID=Integer.parseInt(request.getParameter("kichCo"));

        DoAnDat doAnDat=new DoAnDat();


//        KichCoDAO kichCoDAO=new KichCoDAO();
        KichCoDoAnDAO kichCoDoAnDAO=new KichCoDoAnDAO();

//        day du lieu vao do an dat
        if (session.getAttribute("doAn")!=null){
            DoAn doAn= (DoAn) session.getAttribute("doAn");
            doAnDat.setDoAn((DoAn) session.getAttribute("doAn"));
            doAnDat.setSoLuong(sl);
            doAnDat.setKichCo(kichCoDoAnDAO.getKichCoDA(doAn.getId(),kcID).getKichCo());
            doAnDat.setGiaMua(kichCoDoAnDAO.getKichCoDA(doAn.getId(),kcID).getGia());
        }
        listDoAnDat.add(doAnDat);

    }
    //xoa list do an dat
    if (request.getParameter("delete")!=null){
        int vt =Integer.parseInt(request.getParameter("delete"));
        listDoAnDat.remove(vt);
        session.setAttribute("listDoAnDat",listDoAnDat);
        response.sendRedirect("gdHoaDon.jsp");
    }

    int tongTien=0-diem;
%>
<body>
<h2> DANH SÁCH ĐỒ ĂN ĐÃ CHỌN </h2>

<table class="table table-bordered">
    <thead>
    <tr>
        <th >STT</th>
        <th >Tên</th>
        <th >Giá</th>
        <th >Kích cỡ</th>
        <th >Số lượng</th>
        <th >Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <%
        if(listDoAnDat != null)
            for(int i=0; i<listDoAnDat.size(); i++){
                tongTien+=listDoAnDat.get(i).getGiaMua()*listDoAnDat.get(i).getSoLuong();
    %>
    <tr>
        <td style="text-align:center; padding:0 15px 0 15px;"><%=(i+1) %></td>
        <td style="text-align:center; padding:0 15px 0 15px;"><%=listDoAnDat.get(i).getDoAn().getTen() %></td>
        <td style="padding:0 15px 0 15px;"><%=listDoAnDat.get(i).getGiaMua() %></td>
        <td style="padding:0 15px 0 15px;"><%=listDoAnDat.get(i).getKichCo().getTen() %></td>
        <td style="padding:0 15px 0 15px;"><%=listDoAnDat.get(i).getSoLuong() %></td>
        <td style="text-align:center; padding:0 15px 0 15px;">
            <a class="btn btn-danger" href="gdHoaDon.jsp?delete=<%=i%>">Xóa</a>
        </td>
    </tr>
    <%} %>
    </tbody>
</table>

<%if (diem>0){%>
    <h4>Điểm đã đổi: <%=diem%></h4>
<%}%>
<h4>Tổng tiền: <%=tongTien%> VND</h4>
<br>
<button class="btn btn-primary" onclick="document.location='gdChonMonAn.jsp'">Thêm đồ ăn</button>
<button class="btn btn-warning" onclick="document.location='gdChinh.jsp'">Trang chủ</button>
<%if (listDoAnDat.size()>0){%>
    <button class="btn btn-success" onclick="document.location='doLuuHoaDon.jsp'">Thanh toán</button>
    <button class="btn btn-info" onclick="document.location='gdDoiDiem.jsp'">Đổi điểm</button>
<%}%>
</form>
</body>
</html>