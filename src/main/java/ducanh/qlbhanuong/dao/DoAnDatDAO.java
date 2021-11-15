package ducanh.qlbhanuong.dao;

import ducanh.qlbhanuong.model.DoAnDat;

import java.sql.PreparedStatement;
import java.util.ArrayList;

public class DoAnDatDAO extends DAO{
    public boolean luuDoAnDat(ArrayList<DoAnDat> list){
        int idHoaDon=new HoaDonDAO().getHoaDonID();
        boolean kq = false;
        String sqlThem = "INSERT INTO tblDoAnDat(tblHoaDonId,tblDoAnId,giaMua,kichCo, soLuong) VALUES(?,?,?,?,?)";
        try{
            this.con.setAutoCommit(false);
            for(DoAnDat doAnDat:list){
                PreparedStatement psThem = con.prepareStatement(sqlThem);
                psThem.setInt(1,idHoaDon);
                psThem.setInt(2,doAnDat.getDoAn().getId());
                psThem.setLong(3,doAnDat.getGiaMua());
                psThem.setString(4,doAnDat.getKichCo().getTen());
                psThem.setInt(5,doAnDat.getSoLuong());
                System.out.println(psThem);
            }
            this.con.commit();
            kq=true;
        }catch(Exception e){
            try{
                this.con.rollback();
            }catch(Exception ex){
                kq=false;
                ex.printStackTrace();
            }
            kq=false;
            e.printStackTrace();
        }finally{
            try{
                this.con.setAutoCommit(true);
            }catch(Exception ex){
                kq=false;
                ex.printStackTrace();
            }
        }
        return kq;
    }
}