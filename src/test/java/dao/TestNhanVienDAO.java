package dao;

import ducanh.qlbhanuong.dao.NhanVienDAO;
import ducanh.qlbhanuong.model.NhanVien;
import org.junit.Assert;
import org.junit.Test;

public class TestNhanVienDAO {
    NhanVienDAO nhanVienDAO=new NhanVienDAO();

    @Test
    public void TestDN1() {
        String username = "aaa";
        String password = "a";
        NhanVien nhanVien1 = new NhanVien();
        nhanVien1.setUsername(username);
        nhanVien1.setPassword(password);
        Boolean kq = nhanVienDAO.kiemtraDangnhap(nhanVien1);
        Assert.assertTrue(kq);
    }

    @Test
    public void TestDN2() {
        String username = "aaa";
        String password = "aaa";
        NhanVien nhanVien1 = new NhanVien();
        nhanVien1.setUsername(username);
        nhanVien1.setPassword(password);
        Boolean kq = nhanVienDAO.kiemtraDangnhap(nhanVien1);
        Assert.assertTrue(kq);
    }
    @Test
    public void TestDN3() {
        String username = "";
        String password = "";
        NhanVien nhanVien1 = new NhanVien();
        nhanVien1.setUsername(username);
        nhanVien1.setPassword(password);
        Boolean kq = nhanVienDAO.kiemtraDangnhap(nhanVien1);
        Assert.assertTrue(kq);
    }
}
