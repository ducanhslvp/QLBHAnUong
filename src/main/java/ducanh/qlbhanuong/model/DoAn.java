package ducanh.qlbhanuong.model;

public class DoAn {
    private int id;
    private String ten;
//    private long giaBan;


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
