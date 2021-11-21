package ducanh.qlbhanuong.dao;

import ducanh.qlbhanuong.model.NhanVien;

import java.sql.CallableStatement;
import java.sql.ResultSet;

public class NhanVienDAO extends DAO {
    public NhanVienDAO() {
        super();
    }
    public boolean kiemtraDangnhap(NhanVien tv){
        boolean kq = false;
        if(tv.getUsername().contains("true") ||
                tv.getUsername().contains("=")||
                tv.getPassword().contains("true") ||
                tv.getPassword().contains("=")) return false;

        String sql = "select * from tblnhanvien where username = ? and password = ?";
        try{
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1,tv.getUsername());
            cs.setString(2,tv.getPassword());
            ResultSet rs = cs.executeQuery();
            if(rs.next()){
                tv.setId(rs.getInt("id"));
                tv.setVaiTro(rs.getString("vaitro"));
                tv.setTen(rs.getString("ten"));
                kq = true;
            }
        }catch(Exception e){
            e.printStackTrace();
            kq = false;
        }
        return kq;
    }
}

