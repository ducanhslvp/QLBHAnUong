package ducanh.qlbhanuong.model;

public class KichCo {
    private int id;
    private String ten;

    public KichCo(int id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public KichCo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
