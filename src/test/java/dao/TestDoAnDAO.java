package dao;

import ducanh.qlbhanuong.dao.DoAnDAO;
import ducanh.qlbhanuong.model.DoAn;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestDoAnDAO {
    private DoAnDAO doAnDAO=new DoAnDAO();

    @Test
    public void TestGetDoAnByName1(){
        String name="";
        List<DoAn> list =doAnDAO.getDoAnByName(name);
        Assert.assertNotNull(list);
        Assert.assertEquals(1, list.size());
    }

    @Test
    public void TestGetDoAnByName2(){
        String name="b";
        List<DoAn> list =doAnDAO.getDoAnByName(name);
        Assert.assertNotNull(list);
        Assert.assertEquals(1, list.size());
    }

    @Test
    public void TestGetDoAnByID1(){
        int id=1;
        DoAn doAn=doAnDAO.getDoAnByID(id);
        Assert.assertNotNull(doAn);
        Assert.assertEquals(id,doAn.getId());
    }

    @Test
    public void TestGetDoAnByID2(){
        int id=-1;
        DoAn doAn=doAnDAO.getDoAnByID(id);
        Assert.assertNotNull(doAn);
        Assert.assertEquals(id,doAn.getId());
    }
    @Test
    public void TestGetDoAnByID3(){
        int id=999999;
        DoAn doAn=doAnDAO.getDoAnByID(id);
        Assert.assertNotNull(doAn);
        Assert.assertEquals(id,doAn.getId());
    }
}
