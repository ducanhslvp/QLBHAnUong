package dao;

import ducanh.qlbhanuong.dao.KichCoDoAnDAO;
import ducanh.qlbhanuong.model.KichCoDoAn;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestKichCoDoAnDAO {
    private KichCoDoAnDAO kichCoDoAnDAO=new KichCoDoAnDAO();

    @Test
    public void TestGetKCDAByDATonTai() {
        int id=1;
        ArrayList<KichCoDoAn> listKCDA = kichCoDoAnDAO.getKichCoDAByDA(id);
        Assert.assertNotNull(listKCDA);
        Assert.assertEquals(3, listKCDA.size());
        Assert.assertEquals(id,listKCDA.get(0).getKichCo().getId());
    }

    @Test
    public void TestGetKCDAByDAVoiIDAm() {
        int id=-1;
        ArrayList<KichCoDoAn> listKCDA = kichCoDoAnDAO.getKichCoDAByDA(id);
        Assert.assertNull(listKCDA);
    }

    @Test
    public void TestGetKCDAByDAKhongTonTai() {
        int id=999999;
        ArrayList<KichCoDoAn> listKCDA = kichCoDoAnDAO.getKichCoDAByDA(id);
        Assert.assertNull(listKCDA);

    }

    @Test
    public void TestGetKCDAByIDTonTai() {
        int idDA = 2;
        int idKC = 4;
        KichCoDoAn kichCoDoAn=kichCoDoAnDAO.getKichCoDA(idDA,idKC);
        Assert.assertNull(kichCoDoAn);
    }

    @Test
    public void TestGetKCDAByIDKhongTonTaiIDAm() {
        int idDA = -1;
        int idKC = 4;
        KichCoDoAn kichCoDoAn=kichCoDoAnDAO.getKichCoDA(idDA,idKC);
        Assert.assertNull(kichCoDoAn);
    }
    @Test
    public void TestGetKCDAByIDKhongTonTaiIDLon() {
        int idDA = 2;
        int idKC = 100000000;
        KichCoDoAn kichCoDoAn=kichCoDoAnDAO.getKichCoDA(idDA,idKC);
        Assert.assertNull(kichCoDoAn);
    }
}
