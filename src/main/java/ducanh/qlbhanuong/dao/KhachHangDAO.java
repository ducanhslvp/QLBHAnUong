package ducanh.qlbhanuong.dao;

import ducanh.qlbhanuong.model.KhachHang;

import java.sql.CallableStatement;
import java.sql.ResultSet;

public class KhachHangDAO extends DAO{
    public KhachHangDAO() {
    }
    public KhachHang getKhachHangByMaTV(String ma){
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
        }catch(Exception e){
            e.printStackTrace();
        }
        return khachHang;
    }
}
