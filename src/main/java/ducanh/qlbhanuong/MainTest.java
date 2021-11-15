package ducanh.qlbhanuong;

import ducanh.qlbhanuong.dao.*;
import ducanh.qlbhanuong.model.*;

import java.util.ArrayList;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
//        ThanhVienDAO thanhVienDAO=new ThanhVienDAO();
//        NhanVien nhanVien=new NhanVien(1,"aaa","bbb","ccc","a","aa","nvbh");
//        System.out.println(thanhVienDAO.kiemtraDangnhap(nhanVien));

//        DoAnDAO doAnDAO= new DoAnDAO();
//        System.out.println(doAnDAO.getDoAnByID(1));
//
//        KichCoDAO kichCoDAO=new KichCoDAO();
//        kichCoDAO.getKichCoByDA(1).forEach(System.out::println);
//
//        HoaDonDAO hoaDonDAO=new HoaDonDAO();
//        System.out.println(hoaDonDAO.getHoaDonID());

        DoAnDatDAO doAnDatDAO=new DoAnDatDAO();

        ArrayList<DoAnDat> list=new ArrayList<>();
        list.add(new DoAnDat(1,new DoAn(),10,10,new KichCo(1,"AC")));
        doAnDatDAO.luuDoAnDat(list);

    }
}
