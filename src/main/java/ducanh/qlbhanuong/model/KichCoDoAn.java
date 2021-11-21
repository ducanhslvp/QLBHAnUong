package ducanh.qlbhanuong.model;

public class KichCoDoAn {
    private DoAn doAn;
    private KichCo kichCo;
    private long gia;

    public KichCoDoAn() {
    }

    public KichCoDoAn(DoAn doAn, KichCo kichCo, long gia) {
        this.doAn = doAn;
        this.kichCo = kichCo;
        this.gia = gia;
    }

    public DoAn getDoAn() {
        return doAn;
    }

    public void setDoAn(DoAn doAn) {
        this.doAn = doAn;
    }

    public KichCo getKichCo() {
        return kichCo;
    }

    public void setKichCo(KichCo kichCo) {
        this.kichCo = kichCo;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }
}
