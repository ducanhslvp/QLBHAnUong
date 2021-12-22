package dao;

import ducanh.qlbhanuong.dao.DAO;
import ducanh.qlbhanuong.dao.HoaDonDAO;
import ducanh.qlbhanuong.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestHoaDonDAO extends DAO {
    private HoaDonDAO hoaDonDAO=new HoaDonDAO();

    @Test
    public void TestLuuHDCo1DoAnCoKH(){
//        luu 1 do an
        DoAnDat doAnDat=new DoAnDat(1,new DoAn(1,"bong"),1000,4,new KichCo(1,"L"));
        KhachHang khachHang=new KhachHang(1,"Nguyen duc anh","ha Noi","03458345","11",1000);
        NhanVien nhanVien=new NhanVien(1,"Nguyen duc anh","ha Noi","03458345","ducanh","123","nvbh");
        ArrayList<DoAnDat> list=new ArrayList<>();
        list.add(doAnDat);
        HoaDon hoaDon=new HoaDon(1,nhanVien,khachHang,"15/11/2021","da thanh toan",list,100);

        try{
            DAO.con.setAutoCommit(false);
            boolean ok = hoaDonDAO.luuHoaDon(hoaDon);

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
    public void TestLuuHoaDonCoNhieuDoAnCoKH(){
        //luu nhieu do an
        DoAnDat doAnDat=new DoAnDat(1,new DoAn(1,"bong"),1000,4,new KichCo(1,"L"));
        KhachHang khachHang=new KhachHang(1,"Nguyen duc anh","ha Noi","03458345","11",1000);
        NhanVien nhanVien=new NhanVien(1,"Nguyen duc anh","ha Noi","03458345","ducanh","123","nvbh");
        ArrayList<DoAnDat> list=new ArrayList<>();
        list.add(doAnDat);
        list.add(doAnDat);
        HoaDon hoaDon=new HoaDon(1,nhanVien,khachHang,"15/11/2021","da thanh toan",list,1000);

        try{
            DAO.con.setAutoCommit(false);
            boolean ok = hoaDonDAO.luuHoaDon(hoaDon);
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
    public void TestLuuHoaDonKhongCoDoAnNaoCoKH(){
        //luu nhieu do an rong
        DoAnDat doAnDat=new DoAnDat();
        KhachHang khachHang=new KhachHang(1,"Nguyen duc anh","ha Noi","03458345","11",1000);
        NhanVien nhanVien=new NhanVien(1,"Nguyen duc anh","ha Noi","03458345","ducanh","123","nvbh");
        ArrayList<DoAnDat> list=new ArrayList<>();
        list.add(doAnDat);
        list.add(doAnDat);
        HoaDon hoaDon=new HoaDon(1,nhanVien,khachHang,"15/11/2021","da thanh toan",list,1000);

        try{
            DAO.con.setAutoCommit(false);
            boolean ok = hoaDonDAO.luuHoaDon(hoaDon);
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
    public void TestLuuHDKhongDoiDiem(){
        //luu nhieu khach rong, khong doi diem
        DoAnDat doAnDat=new DoAnDat();
        KhachHang khachHang=null;
        NhanVien nhanVien=new NhanVien(1,"Nguyen duc anh","ha Noi","03458345","ducanh","123","nvbh");
        ArrayList<DoAnDat> list=new ArrayList<>();
        list.add(doAnDat);
        list.add(doAnDat);
        HoaDon hoaDon=new HoaDon(1,nhanVien,khachHang,"15/11/2021","da thanh toan",list,1000);

        try{
            DAO.con.setAutoCommit(false);
            boolean ok = hoaDonDAO.luuHoaDon(hoaDon);
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
    public void TestLuuHDCo1DoAnKhongCoKH(){
//        luu 1 do an khong co khach hang doi diem
        DoAnDat doAnDat=new DoAnDat(1,new DoAn(1,"bong"),1000,4,new KichCo(1,"L"));
        KhachHang khachHang=null;
        NhanVien nhanVien=new NhanVien(1,"Nguyen duc anh","ha Noi","03458345","ducanh","123","nvbh");
        ArrayList<DoAnDat> list=new ArrayList<>();
        list.add(doAnDat);
        HoaDon hoaDon=new HoaDon(1,nhanVien,khachHang,"15/11/2021","da thanh toan",list,0);

        try{
            DAO.con.setAutoCommit(false);
            boolean ok = hoaDonDAO.luuHoaDon(hoaDon);
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
    public void TestLuuHoaDonCoNhieuDoAnKhongCoKH(){
        //luu nhieu do an khong co khach hang
        DoAnDat doAnDat=new DoAnDat(1,new DoAn(1,"bong"),1000,4,new KichCo(1,"L"));
        KhachHang khachHang=null;
        NhanVien nhanVien=new NhanVien(1,"Nguyen duc anh","ha Noi","03458345","ducanh","123","nvbh");
        ArrayList<DoAnDat> list=new ArrayList<>();
        list.add(doAnDat);
        list.add(doAnDat);
        HoaDon hoaDon=new HoaDon(1,nhanVien,khachHang,"15/11/2021","da thanh toan",list,1000);

        try{
            DAO.con.setAutoCommit(false);
            boolean ok = hoaDonDAO.luuHoaDon(hoaDon);
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
    public void TestLuuHoaDonKhongCoDoAnNaoKhongCoKH(){
        //luu nhieu do an rong khong co khach hang
        DoAnDat doAnDat=new DoAnDat();
        KhachHang khachHang=null;
        NhanVien nhanVien=new NhanVien(1,"Nguyen duc anh","ha Noi","03458345","ducanh","123","nvbh");
        ArrayList<DoAnDat> list=new ArrayList<>();
        list.add(doAnDat);
        list.add(doAnDat);
        HoaDon hoaDon=new HoaDon(1,nhanVien,khachHang,"15/11/2021","da thanh toan",list,1000);

        try{
            DAO.con.setAutoCommit(false);
            boolean ok = hoaDonDAO.luuHoaDon(hoaDon);
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

}
