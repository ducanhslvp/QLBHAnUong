package ducanh.qlbhanuong.dao;

import ducanh.qlbhanuong.model.DoAn;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DoAnDAO extends DAO{
    public DoAnDAO() {
        super();
    }
//    public ArrayList<DoAn> getDoAn(){
//        ArrayList<DoAn> kq=null;
//        String sql = ""; //su dung stored procedure
//        try{
//            CallableStatement cs = con.prepareCall(sql);
//            ResultSet rs = cs.executeQuery();
//            while(rs.next()){
//                if(kq == null) kq = new ArrayList<>();
//
//                DoAn doAn=new DoAn();
//                doAn.setId(rs.getInt("id"));
//                doAn.setTen(rs.getString("ten"));
//                kq.add(doAn);
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//            kq = null;
//        }
//        return kq;
//    }
    public ArrayList<DoAn> getDoAnByName(String ten){
        ArrayList<DoAn> kq=null;
        String sql = "SELECT * FROM tbldoan WHERE ten LIKE ?";
        try{

            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1,'%'+ten+'%');
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                if(kq == null) kq = new ArrayList<DoAn>();

                DoAn doAn=new DoAn();
                doAn.setId(rs.getInt("id"));
                doAn.setTen(rs.getString("ten"));
                kq.add(doAn);
            }
        }catch(Exception e){
            e.printStackTrace();
            kq = new ArrayList<DoAn>();
        }
        return kq;
    }
    public DoAn getDoAnByID(int id){
        DoAn doAn=new DoAn();
        String sql = "SELECT * FROM tbldoan WHERE id=?";
        try{

            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1,id+"");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){

                doAn.setId(rs.getInt("id"));
                doAn.setTen(rs.getString("ten"));
            }
        }catch(Exception e){
            e.printStackTrace();

        }
        return doAn;
    }
}
