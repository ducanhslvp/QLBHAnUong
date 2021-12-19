package ducanh.qlbhanuong.model;

public class DoAn {
    private int id;
    private String ten;

    public DoAn(int id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public DoAn() {
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

    @Override
    public String toString() {
        return "DoAn{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                '}';
    }
}
