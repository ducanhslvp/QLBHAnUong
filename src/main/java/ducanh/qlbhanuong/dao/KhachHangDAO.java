package ducanh.qlbhanuong.dao;

import ducanh.qlbhanuong.model.HoaDon;
import ducanh.qlbhanuong.model.KhachHang;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class KhachHangDAO extends DAO{
    public KhachHangDAO() {
    }
    public KhachHang getKhachHangByMaTV(String ma){
        if (ma.equals("") ||ma.equals(" ")) return null;
        KhachHang khachHang=new KhachHang();
        String sql = "select * from tblkhachhang where mathanhvien = ?";
        try{
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1,ma);
            ResultSet rs = cs.executeQuery();
            if(rs.next()){
                khachHang.setId(rs.getInt("id"));
                khachHang.setTen(rs.getString("ten"));
                khachHang.setMaTV(ma);
                khachHang.setDiaChi(rs.getString("diachi"));
                khachHang.setSdt(rs.getString("sdt"));
                khachHang.setDiem(rs.getInt("diem"));
            }
            else return null;
        }catch(Exception e){
            e.printStackTrace();
        }
        return khachHang;
    }

    public boolean updateDiem(KhachHang khachHang,int diem){
        boolean kq = false;
        String sqlUpdate = "UPDATE `qlbhanuong`.`tblkhachhang` SET `Diem` = ? WHERE (`Id` = ?);";
        try{
            this.con.setAutoCommit(false);
            PreparedStatement psThem = con.prepareStatement(sqlUpdate);
            psThem.setInt(1,diem);
            psThem.setInt(2,khachHang.getId());
            psThem.executeUpdate();

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
}
