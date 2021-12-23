package ducanh.qlbhanuong.dao;

import ducanh.qlbhanuong.model.HoaDon;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class HoaDonDAO extends DAO{
    public HoaDonDAO() {
    }
    public boolean luuHoaDon(HoaDon hoaDon){
        boolean kq = false;
//        if (hoaDon.getListDoAnDat()==null || hoaDon.getNhanVien()==null) return false;
        if (hoaDon.getNhanVien()==null) return false;
        String sqlNotKH = "INSERT INTO tblhoadon(tblNhanVienId,ngayTT,tinhtrang) VALUES(?,?,?)";
        String sqlKH = "INSERT INTO tblhoadon(tblNhanVienId,ngayTT,tinhtrang,tblKhachHangId,diemDoi) VALUES(?,?,?,?,?)";
        String sqlThem="";
        if (hoaDon.getKhachHang()!=null)
            sqlThem=sqlKH;
        else sqlThem=sqlNotKH;
        try{
            this.con.setAutoCommit(false);
            PreparedStatement psThem = con.prepareStatement(sqlThem);
            psThem.setInt(1,hoaDon.getNhanVien().getId());
            psThem.setString(2,java.time.LocalDate.now()+"");
            psThem.setString(3, "da thanh toan");
            if (hoaDon.getKhachHang()!=null) {
                psThem.setInt(4,hoaDon.getKhachHang().getId());
                psThem.setInt(5,hoaDon.getDiemDoi());
            }
            System.out.println(psThem);
            psThem.executeUpdate();

//            this.con.commit();
            kq=true;
        }catch(Exception e){
            try{
//                this.con.rollback();
            }catch(Exception ex){
                kq=false;
                ex.printStackTrace();
            }
            kq=false;
            e.printStackTrace();
        }finally{
            try{
//                this.con.setAutoCommit(true);
            }catch(Exception ex){
                kq=false;
                ex.printStackTrace();
            }
        }
        return kq;
    }
    public int getHoaDonID(){
        int kq=-1;
        String sql = "SELECT id FROM tblhoadon order by id DESC limit 1;";
        try{
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                kq= rs.getInt("id");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return kq;
    }
}
