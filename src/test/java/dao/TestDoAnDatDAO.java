package dao;

import ducanh.qlbhanuong.dao.DAO;
import ducanh.qlbhanuong.dao.DoAnDatDAO;
import ducanh.qlbhanuong.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestDoAnDatDAO {
    public DoAnDatDAO doAnDatDAO=new DoAnDatDAO();

    @Test
    public void TestLuu1DoAnDat(){
        DoAnDat doAnDat=new DoAnDat(1,new DoAn(1,"bong"),1000,4,new KichCo(1,"L"));
        ArrayList<DoAnDat> list=new ArrayList<>();
        list.add(doAnDat);
        try{
            DAO.con.setAutoCommit(false);
            boolean ok = doAnDatDAO.luuDoAnDat(list);
            Assert.assertTrue(ok);

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                DAO.con.rollback();
                DAO.con.setAutoCommit(true);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    @Test
    public void TestLuuNhieuDoAnDat(){
        DoAnDat doAnDat1=new DoAnDat(1,new DoAn(1,"bong"),1000,4,new KichCo(1,"L"));
        DoAnDat doAnDat2=new DoAnDat(1,new DoAn(1,"bong"),1000,4,new KichCo(1,"L"));
        DoAnDat doAnDat3=new DoAnDat(1,new DoAn(1,"bong"),1000,4,new KichCo(1,"L"));
        ArrayList<DoAnDat> list=new ArrayList<>();

        list.add(doAnDat1);
        list.add(doAnDat2);
        list.add(doAnDat3);
        try{
            DAO.con.setAutoCommit(false);
            boolean ok = doAnDatDAO.luuDoAnDat(list);
            Assert.assertTrue(ok);

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                DAO.con.rollback();
                DAO.con.setAutoCommit(true);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    @Test
    public void TestLuuGiaMuaAmSLAm(){
        DoAnDat doAnDat=new DoAnDat(1,new DoAn(1,"bong"),-1000,-1,new KichCo(1,"L"));
        ArrayList<DoAnDat> list=new ArrayList<>();
        list.add(doAnDat);
        try{
            DAO.con.setAutoCommit(false);
            boolean ok = doAnDatDAO.luuDoAnDat(list);
            Assert.assertTrue(ok);

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                DAO.con.rollback();
                DAO.con.setAutoCommit(true);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    @Test
    public void TestLuuDoAnRong(){
        DoAnDat doAnDat=new DoAnDat(1,new DoAn(),1000,1,new KichCo(1,"L"));
        ArrayList<DoAnDat> list=new ArrayList<>();
        list.add(doAnDat);
        try{
            DAO.con.setAutoCommit(false);
            boolean ok = doAnDatDAO.luuDoAnDat(list);
            Assert.assertFalse(ok);

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                DAO.con.rollback();
                DAO.con.setAutoCommit(true);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    @Test
    public void TestLuuKichCoDoAnRong(){
        DoAnDat doAnDat=new DoAnDat(1,new DoAn(),1000,1,new KichCo());
        ArrayList<DoAnDat> list=new ArrayList<>();
        list.add(doAnDat);
        try{
            DAO.con.setAutoCommit(false);
            boolean ok = doAnDatDAO.luuDoAnDat(list);
            Assert.assertFalse(ok);

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                DAO.con.rollback();
                DAO.con.setAutoCommit(true);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
