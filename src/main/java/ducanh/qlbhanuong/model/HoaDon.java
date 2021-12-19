package ducanh.qlbhanuong.model;

import java.util.ArrayList;

public class HoaDon {
    private int id;
    private NhanVien nhanVien;
    private KhachHang khachHang;
    private String ngayTT;
    private String tinhTrang;
    private ArrayList<DoAnDat> listDoAnDat;
    private int diemDoi;

    public HoaDon() {
    }

    public HoaDon(int id, NhanVien nhanVien, KhachHang khachHang, String ngayTT, String tinhTrang, ArrayList<DoAnDat> listDoAnDat, int diemDoi) {
        this.id = id;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.ngayTT = ngayTT;
        this.tinhTrang = tinhTrang;
        this.listDoAnDat = listDoAnDat;
        this.diemDoi = diemDoi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public String getNgayTT() {
        return ngayTT;
    }

    public void setNgayTT(String ngayTT) {
        this.ngayTT = ngayTT;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public ArrayList<DoAnDat> getListDoAnDat() {
        return listDoAnDat;
    }

    public void setListDoAnDat(ArrayList<DoAnDat> listDoAnDat) {
        this.listDoAnDat = listDoAnDat;
    }

    public int getDiemDoi() {
        return diemDoi;
    }

    public void setDiemDoi(int diemDoi) {
        this.diemDoi = diemDoi;
    }
}
