package ducanh.qlbhanuong.dao;

import ducanh.qlbhanuong.model.DoAn;
import ducanh.qlbhanuong.model.DoAnDat;
import ducanh.qlbhanuong.model.HoaDon;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class HoaDonDAO extends DAO{
    public HoaDonDAO() {
    }
    public boolean luuHoaDon(HoaDon hoaDon){
        boolean kq = false;
        String sqlThem = "INSERT INTO tblhoadon(tblKhachHangId,tblNhanVienId,ngayTT,tinhtrang) VALUES(?,?,?,?)";
        try{
            this.con.setAutoCommit(false);
            PreparedStatement psThem = con.prepareStatement(sqlThem);
            psThem.setInt(1,1);
            psThem.setInt(2,hoaDon.getNhanVien().getId());
            psThem.setString(3,"20/11/2021");
            psThem.setString(4, "da thanh toan");
            System.out.println(psThem);
            psThem.executeUpdate();

//            if (getHoaDonID()!=1){
//                DoAnDatDAO doAnDatDAO=new DoAnDatDAO();
//                doAnDatDAO.luuDoAnDat(hoaDon.getListDoAnDat(),getHoaDonID());
//            }

            this.con.commit();
            kq=true;
        }catch(Exception e){
            try{
                this.con.rollback();
            }catch(Exception ex){
                kq=false;
                ex.printStackTrace();
            }
            kq=false;
            e.printStackTrace();
        }finally{
            try{
                this.con.setAutoCommit(true);
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
