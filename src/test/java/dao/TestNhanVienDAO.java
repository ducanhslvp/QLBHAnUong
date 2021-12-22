package dao;

import ducanh.qlbhanuong.dao.NhanVienDAO;
import ducanh.qlbhanuong.model.NhanVien;
import org.junit.Assert;
import org.junit.Test;

public class TestNhanVienDAO {
    NhanVienDAO nhanVienDAO=new NhanVienDAO();

    @Test
    public void TestDNKhongTonTai() {
        String username = "aaa";
        String password = "a";
        NhanVien nhanVien1 = new NhanVien();
        nhanVien1.setUsername(username);
        nhanVien1.setPassword(password);
        boolean kq = nhanVienDAO.kiemtraDangnhap(nhanVien1);
        Assert.assertFalse(kq);
    }

    @Test
    public void TestDNTKiTuDacBiet() {
        String username = "$%#$%#";
        String password = "@#%$@$";
        NhanVien nhanVien1 = new NhanVien();
        nhanVien1.setUsername(username);
        nhanVien1.setPassword(password);
        boolean kq = nhanVienDAO.kiemtraDangnhap(nhanVien1);
        Assert.assertFalse(kq);
    }
    @Test
    public void TestDNRong() {
        String username = "";
        String password = "";
        NhanVien nhanVien1 = new NhanVien();
        nhanVien1.setUsername(username);
        nhanVien1.setPassword(password);
        boolean kq = nhanVienDAO.kiemtraDangnhap(nhanVien1);
        Assert.assertFalse(kq);
    }
    @Test
    public void TestDNTonTai() {
        String username = "a";
        String password = "a";
        NhanVien nhanVien1 = new NhanVien();
        nhanVien1.setUsername(username);
        nhanVien1.setPassword(password);
        boolean kq = nhanVienDAO.kiemtraDangnhap(nhanVien1);
        Assert.assertTrue(kq);
    }
    @Test
    public void TestDNTenQuaDai() {
        String username = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String password = "";
        NhanVien nhanVien1 = new NhanVien();
        nhanVien1.setUsername(username);
        nhanVien1.setPassword(password);
        boolean kq = nhanVienDAO.kiemtraDangnhap(nhanVien1);
        Assert.assertFalse(kq);
    }
}
