package dao;

import ducanh.qlbhanuong.dao.DoAnDAO;
import ducanh.qlbhanuong.model.DoAn;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestDoAnDAO {
    private DoAnDAO doAnDAO=new DoAnDAO();

    @Test
    public void TestGetDoAnByNameTenTrong(){
        String name="";
        List<DoAn> list =doAnDAO.getDoAnByName(name);
        Assert.assertNull(list);
    }

    @Test
    public void TestGetDoAnByNameTenCoMotDoAn(){
        String name="m";
        List<DoAn> list =doAnDAO.getDoAnByName(name);
        Assert.assertNotNull(list);
        Assert.assertEquals(1, list.size());
    }

    @Test
    public void TestGetDoAnByNameKhongCoDoAnNao(){
        String name="*";
        List<DoAn> list =doAnDAO.getDoAnByName(name);
        Assert.assertNull(list);
    }

    @Test
    public void TestGetDoAnByNameCoNhieuDoAnNao(){
        String name="n";
        List<DoAn> list =doAnDAO.getDoAnByName(name);
        Assert.assertNotNull(list);
        Assert.assertEquals(8, list.size());
    }

    @Test
    public void TestGetDoAnByIDTonTaiDoAn(){
        int id=1;
        DoAn doAn=doAnDAO.getDoAnByID(id);
        Assert.assertNotNull(doAn);
//        Assert.assertEquals(id,doAn.getId());
    }

    @Test
    public void TestGetDoAnByIDVoiIDAm(){
        int id=-1;
        DoAn doAn=doAnDAO.getDoAnByID(id);
        Assert.assertNull(doAn);
    }
    @Test
    public void TestGetDoAnByIDKhongTonTaiDoAn(){
        int id=99999;
        DoAn doAn=doAnDAO.getDoAnByID(id);
        Assert.assertNull(doAn);
    }
    @Test
    public void TestGetDoAnByIDVoiIDRatLon(){
        int id=999999999;
        DoAn doAn=doAnDAO.getDoAnByID(id);
        Assert.assertNull(doAn);
    }
}
