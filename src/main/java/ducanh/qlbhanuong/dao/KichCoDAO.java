package ducanh.qlbhanuong.dao;

import ducanh.qlbhanuong.model.DoAn;
import ducanh.qlbhanuong.model.KichCo;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class KichCoDAO extends DAO{
    public KichCoDAO() {
        super();
    }
    public ArrayList<KichCo> getKichCoByDA(int id){
        ArrayList<KichCo> kq=null;
        String sql = "SELECT * FROM tblkichco";
        try{
            CallableStatement cs = con.prepareCall(sql);
//            cs.setString(1,'%'+id+""+'%');
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                if(kq == null) kq = new ArrayList<KichCo>();
                KichCo kichCo=new KichCo();
                kichCo.setId(rs.getInt("id"));
                kichCo.setTen(rs.getString("ten"));
                kq.add(kichCo);
            }
        }catch(Exception e){
            e.printStackTrace();
            kq = new ArrayList<KichCo>();
        }
        return kq;
    }
    public KichCo getKichCoByID(int id){
        KichCo kichCo=new KichCo();
        String sql = "SELECT * FROM tblkichco where id=?";
        try{
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1,id+"");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                kichCo.setId(rs.getInt("id"));
                kichCo.setTen(rs.getString("ten"));
            }
        }catch(Exception e){

        }
        return kichCo;
    }
}
