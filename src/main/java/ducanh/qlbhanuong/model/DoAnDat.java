package ducanh.qlbhanuong.model;

public class DoAnDat {
    private int id;
    private DoAn doAn;
    private long giaMua;
    private int soLuong;
    private KichCo kichCo;

    public DoAnDat(int id, DoAn doAn, long giaMua, int soLuong, KichCo kichCo) {
        this.id = id;
        this.doAn = doAn;
        this.giaMua = giaMua;
        this.soLuong = soLuong;
        this.kichCo = kichCo;
    }

    public DoAnDat() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DoAn getDoAn() {
        return doAn;
    }

    public void setDoAn(DoAn doAn) {
        this.doAn = doAn;
    }

    public long getGiaMua() {
        return giaMua;
    }

    public void setGiaMua(long giaMua) {
        this.giaMua = giaMua;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public KichCo getKichCo() {
        return kichCo;
    }

    public void setKichCo(KichCo kichCo) {
        this.kichCo = kichCo;
    }
}
