package ducanh.qlbhanuong.dao;

import ducanh.qlbhanuong.model.DoAn;
import ducanh.qlbhanuong.model.KichCo;
import ducanh.qlbhanuong.model.KichCoDoAn;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class KichCoDoAnDAO extends DAO{
    public KichCoDoAnDAO() {
    }
    public ArrayList<KichCoDoAn> getKichCoDAByDA(int id){
        ArrayList<KichCoDoAn> kq=null;
        String sql = "SELECT * FROM tblkichcodoan,tblKichCo where tblKichCoDoAn.tblKichCoId=tblkichco.id and tblkichcodoan.tblDoAnId=?";
        try{
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1,id+"");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                if(kq == null) kq = new ArrayList<KichCoDoAn>();
                KichCo kichCo=new KichCo();
                kichCo.setId(rs.getInt("id"));
                kichCo.setTen(rs.getString("ten"));
                KichCoDoAn kichCoDoAn=new KichCoDoAn(new DoAn(),kichCo,rs.getLong("giaBan"));
                kq.add(kichCoDoAn);
            }
        }catch(Exception e){
            e.printStackTrace();
            kq = new ArrayList<KichCoDoAn>();
        }
        return kq;
    }
    public KichCoDoAn getKichCoDA(int doAnID,int kichCoID){
        KichCoDoAn kichCoDoAn=null;
        String sql = "SELECT * FROM tblkichcodoan,tblKichCo where tblKichCoDoAn.tblKichCoId=tblkichco.id and " +
                "tblkichcodoan.tblDoAnId=? and tblkichcodoan.tblKichCoid=?";
        try{
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1,doAnID+"");
            cs.setString(2,kichCoID+"");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                KichCo kichCo=new KichCo();
                kichCo.setId(rs.getInt("id"));
                kichCo.setTen(rs.getString("ten"));
                kichCoDoAn=new KichCoDoAn(new DoAn(),kichCo,rs.getLong("giaBan"));
            }
        }catch(Exception e){
            e.printStackTrace();

        }
        return kichCoDoAn;
    }
}
