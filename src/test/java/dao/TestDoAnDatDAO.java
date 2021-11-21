package dao;

import ducanh.qlbhanuong.dao.DoAnDatDAO;
import ducanh.qlbhanuong.model.DoAn;
import ducanh.qlbhanuong.model.DoAnDat;
import ducanh.qlbhanuong.model.KichCo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestDoAnDatDAO {
    public DoAnDatDAO doAnDatDAO=new DoAnDatDAO();

    @Test
    public void TestLuu1(){
        DoAnDat doAnDat=new DoAnDat(1,new DoAn(1,"bong"),1000,4,new KichCo(1,"L"));
        ArrayList<DoAnDat> list=new ArrayList<>();
        list.add(doAnDat);
        doAnDatDAO.luuDoAnDat(list);
    }
    @Test
    public void TestLuu2(){
        DoAnDat doAnDat=new DoAnDat(1,new DoAn(1,"bong"),-1000,-1,new KichCo(1,"L"));
        ArrayList<DoAnDat> list=new ArrayList<>();
        list.add(doAnDat);
        doAnDatDAO.luuDoAnDat(list);
    }
    @Test
    public void TestLuu3(){
        DoAnDat doAnDat=new DoAnDat(1,new DoAn(),1000,1,new KichCo(1,"L"));
        ArrayList<DoAnDat> list=new ArrayList<>();
        list.add(doAnDat);
        doAnDatDAO.luuDoAnDat(list);
    }
    @Test
    public void TestLuu4(){
        DoAnDat doAnDat=new DoAnDat(1,new DoAn(),1000,1,new KichCo());
        ArrayList<DoAnDat> list=new ArrayList<>();
        list.add(doAnDat);
        doAnDatDAO.luuDoAnDat(list);
    }
}
