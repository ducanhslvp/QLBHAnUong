package dao;

import ducanh.qlbhanuong.dao.KhachHangDAO;
import ducanh.qlbhanuong.model.KhachHang;
import org.junit.Assert;
import org.junit.Test;

public class TestKhachHangDAO {
    private KhachHangDAO khachHangDAO=new KhachHangDAO();

    @Test
    public void TestGetKHbyMaVoiMaRong(){
        String ma="";
        KhachHang khachHang=khachHangDAO.getKhachHangByMaTV(ma);
        Assert.assertNull(khachHang);
    }

    @Test
    public void TestGetKHbyMaVoiMaKiTuDacBiet(){
        String ma="$$$###@@";
        KhachHang khachHang=khachHangDAO.getKhachHangByMaTV(ma);
        Assert.assertNull(khachHang);
    }

    @Test
    public void TestGetKHbyMaTonTaiKhachHang(){
        String ma="1";
        KhachHang khachHang=khachHangDAO.getKhachHangByMaTV(ma);
        Assert.assertNotNull(khachHang);
        Assert.assertEquals(ma,khachHang.getMaTV());
    }
    @Test
    public void TestGetKHbyMaKhongTonTaiKhachHang(){
        String ma="99";
        KhachHang khachHang=khachHangDAO.getKhachHangByMaTV(ma);
        Assert.assertNull(khachHang);

    }
    @Test
    public void TestGetKHbyMaVoiMaRatLon(){
        String ma="9999999999999999999999999999999999999999999999999999999999";
        KhachHang khachHang=khachHangDAO.getKhachHangByMaTV(ma);
        Assert.assertNull(khachHang);
    }
}
