package dao;

import ducanh.qlbhanuong.dao.KhachHangDAO;
import ducanh.qlbhanuong.model.KhachHang;
import org.junit.Assert;
import org.junit.Test;

public class TestKhachHangDAO {
    private KhachHangDAO khachHangDAO=new KhachHangDAO();

    @Test
    public void TestGetKHbyMa1(){
        String ma="";
        KhachHang khachHang=khachHangDAO.getKhachHangByMaTV(ma);
        Assert.assertNotNull(khachHang);
        Assert.assertEquals(ma,khachHang.getMaTV());
    }

    @Test
    public void TestGetKHbyMa2(){
        String ma="%#@#%@#";
        KhachHang khachHang=khachHangDAO.getKhachHangByMaTV(ma);
        Assert.assertNotNull(khachHang);
        Assert.assertEquals(ma,khachHang.getMaTV());
    }

    @Test
    public void TestGetKHbyMa3(){
        String ma="11";
        KhachHang khachHang=khachHangDAO.getKhachHangByMaTV(ma);
        Assert.assertNotNull(khachHang);
        Assert.assertEquals(ma,khachHang.getMaTV());
    }
}
