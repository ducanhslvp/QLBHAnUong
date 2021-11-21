package dao;

import ducanh.qlbhanuong.dao.KichCoDoAnDAO;
import ducanh.qlbhanuong.model.KichCoDoAn;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestKichCoDoAnDAO {
    private KichCoDoAnDAO kichCoDoAnDAO=new KichCoDoAnDAO();

    @Test
    public void TestGetKCDAByDA1() {
        int id=1;
        ArrayList<KichCoDoAn> listKCDA = kichCoDoAnDAO.getKichCoDAByDA(id);
        Assert.assertNotNull(listKCDA);
        Assert.assertEquals(1, listKCDA.size());
        Assert.assertEquals(id,listKCDA.get(0).getDoAn().getId());
    }

    @Test
    public void TestGetKCDAByDA2() {
        int id=-1;
        ArrayList<KichCoDoAn> listKCDA = kichCoDoAnDAO.getKichCoDAByDA(id);
        Assert.assertNotNull(listKCDA);
        Assert.assertEquals(1, listKCDA.size());
        Assert.assertEquals(id,listKCDA.get(0).getDoAn().getId());
    }

    @Test
    public void TestGetKCDAByDA3() {
        int id=999999;
        ArrayList<KichCoDoAn> listKCDA = kichCoDoAnDAO.getKichCoDAByDA(id);
        Assert.assertNotNull(listKCDA);
        Assert.assertEquals(1, listKCDA.size());
        Assert.assertEquals(id,listKCDA.get(0).getDoAn().getId());
    }

    @Test
    public void TestGetKCDA1() {
        int idDA = 2;
        int idKC = 4;
        KichCoDoAn kichCoDoAn=kichCoDoAnDAO.getKichCoDA(idDA,idKC);
        Assert.assertNotNull(kichCoDoAn);

        Assert.assertEquals(idDA,kichCoDoAn.getDoAn());
        Assert.assertEquals(idKC,kichCoDoAn.getKichCo());
    }

    @Test
    public void TestGetKCDA2() {
        int idDA = -1;
        int idKC = 4;
        KichCoDoAn kichCoDoAn=kichCoDoAnDAO.getKichCoDA(idDA,idKC);
        Assert.assertNotNull(kichCoDoAn);

        Assert.assertEquals(idDA,kichCoDoAn.getDoAn());
        Assert.assertEquals(idKC,kichCoDoAn.getKichCo());
    }
    @Test
    public void TestGetKCDA3() {
        int idDA = 2;
        int idKC = 100000000;
        KichCoDoAn kichCoDoAn=kichCoDoAnDAO.getKichCoDA(idDA,idKC);
        Assert.assertNotNull(kichCoDoAn);

        Assert.assertEquals(idDA,kichCoDoAn.getDoAn());
        Assert.assertEquals(idKC,kichCoDoAn.getKichCo());
    }
}
