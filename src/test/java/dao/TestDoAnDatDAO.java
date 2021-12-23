package dao;

import ducanh.qlbhanuong.dao.DAO;
import ducanh.qlbhanuong.dao.DoAnDatDAO;
import ducanh.qlbhanuong.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static ducanh.qlbhanuong.dao.DAO.con;

public class TestDoAnDatDAO {
    public DoAnDatDAO doAnDatDAO=new DoAnDatDAO();

    @Test
    public void TestLuu1DoAnDat(){
        DoAnDat doAnDat=new DoAnDat(1,new DoAn(1,"bong"),1000,4,new KichCo(1,"L"));
        ArrayList<DoAnDat> list=new ArrayList<>();
        list.add(doAnDat);
        try{
            con.setAutoCommit(false);
            DoAnDat doAnDat1=getLastDoAnDat();
            boolean ok = doAnDatDAO.luuDoAnDat(list);

            DoAnDat doAnDat2=getLastDoAnDat();
            Assert.assertTrue(ok);
            Assert.assertNotEquals(doAnDat1,doAnDat2);
            Assert.assertEquals(doAnDat2.getSoLuong(),list.get(list.size()-1).getSoLuong());
            Assert.assertEquals(doAnDat2.getDoAn().getId(),list.get(list.size()-1).getDoAn().getId());
            Assert.assertEquals(doAnDat2.getGiaMua(),list.get(list.size()-1).getGiaMua());
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                con.rollback();
                con.setAutoCommit(true);
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
            con.setAutoCommit(false);
            DoAnDat doAnDat11=getLastDoAnDat();
            boolean ok = doAnDatDAO.luuDoAnDat(list);
            Assert.assertTrue(ok);
            DoAnDat doAnDat22=getLastDoAnDat();
            Assert.assertTrue(ok);
            Assert.assertNotEquals(doAnDat11,doAnDat2);
            Assert.assertEquals(doAnDat22.getSoLuong(),list.get(list.size()-1).getSoLuong());
            Assert.assertEquals(doAnDat22.getDoAn().getId(),list.get(list.size()-1).getDoAn().getId());
            Assert.assertEquals(doAnDat22.getGiaMua(),list.get(list.size()-1).getGiaMua());

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                con.rollback();
                con.setAutoCommit(true);
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
            con.setAutoCommit(false);
            boolean ok = doAnDatDAO.luuDoAnDat(list);
            Assert.assertTrue(!ok);

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                con.rollback();
                con.setAutoCommit(true);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    @Test
    public void TestLuuDoAnRong(){
        ArrayList<DoAnDat> list=null;
        try{
            con.setAutoCommit(false);
            boolean ok = doAnDatDAO.luuDoAnDat(list);
            Assert.assertFalse(ok);

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                con.rollback();
                con.setAutoCommit(true);
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
            con.setAutoCommit(false);
            boolean ok = doAnDatDAO.luuDoAnDat(list);
            Assert.assertFalse(ok);

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                con.rollback();
                con.setAutoCommit(true);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    public DoAnDat getLastDoAnDat(){
        DoAnDat doAnDat=new DoAnDat();
        String sql = "SELECT * FROM qlbhanuong.tbldoandat ORDER BY tblHoaDonId DESC LIMIT 1;";
        try{
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            if(rs.next()){
                DoAn doAn=new DoAn();
                doAn.setId(rs.getInt("tblDoAnID"));
                doAnDat.setDoAn(doAn);
                doAnDat.setSoLuong(rs.getInt("soluong"));
                KichCo kichCo=new KichCo();
                kichCo.setId(Integer.parseInt(rs.getString("kichCo")));
                doAnDat.setKichCo(kichCo);
                doAnDat.setGiaMua(rs.getInt("giamua"));
            }else return null;
        }catch(Exception e){
            e.printStackTrace();
        }
        return doAnDat;
    }
}
