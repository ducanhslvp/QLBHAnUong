package selenium;

import ducanh.qlbhanuong.dao.DAO;
import ducanh.qlbhanuong.model.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TestLuuHoaDon extends DAO {
    private WebDriver driver;

    @Test
    public void TestLuuHoaDonCo1DoAn(){

        WebElement table=driver.findElement(By.xpath("//table/tbody"));
        List<WebElement> rows=table.findElements(By.tagName("tr"));

        List<WebElement> columns=rows.get(0).findElements(By.tagName("td"));

        //doAnDat luc truoc
        DoAnDat doAnDatBefore=new DoAnDat();
        doAnDatBefore.setGiaMua(Long.parseLong(columns.get(2).getText()));
        doAnDatBefore.setSoLuong(Integer.parseInt(columns.get(4).getText()));
        DoAn doAn=new DoAn();
        doAn.setTen(columns.get(1).getText());
        doAnDatBefore.setDoAn(doAn);


        try{
            DAO.con.setAutoCommit(false);

            driver.findElement(By.cssSelector("button.btn.btn-success")).click();
            //doAnDat luc sau
            DoAnDat doAnDatAfter=getLastDoAnDat();

            Assert.assertEquals(doAnDatBefore.getGiaMua(),doAnDatAfter.getGiaMua());
            Assert.assertEquals(doAnDatBefore.getSoLuong(),doAnDatAfter.getSoLuong());
            Assert.assertEquals(doAnDatBefore.getDoAn().getTen(),doAnDatAfter.getDoAn().getTen());

            //kiem tra luu hoa don
            HoaDon hoaDon=getLastHoaDon();
            Assert.assertEquals(hoaDon.getTinhTrang(),"da thanh toan");
            Assert.assertEquals(hoaDon.getId(),getLastIDHoaDon());

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                DAO.con.rollback();
                DAO.con.setAutoCommit(true);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

    }

    @Test
    public void TestLuuHoaDonCoNhieuDoAnDat(){

        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

        String name="a";
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.cssSelector("input.btn")).click();
        driver.findElement(By.xpath("//div/table/tbody/tr[1]/td[3]/a")).click();
        WebElement soLuong=driver.findElement(By.name("soLuong"));
        soLuong.clear();
        soLuong.sendKeys("5");
        driver.findElement(By.cssSelector("input.btn")).click();

        WebElement table=driver.findElement(By.xpath("//table/tbody"));
        List<WebElement> rows=table.findElements(By.tagName("tr"));

        List<WebElement> columns=rows.get(1).findElements(By.tagName("td"));

        //doAnDat luc truoc
        DoAnDat doAnDatBefore=new DoAnDat();
        doAnDatBefore.setGiaMua(Long.parseLong(columns.get(2).getText()));
        doAnDatBefore.setSoLuong(Integer.parseInt(columns.get(4).getText()));
        DoAn doAn=new DoAn();
        doAn.setTen(columns.get(1).getText());
        doAnDatBefore.setDoAn(doAn);

        try{
            DAO.con.setAutoCommit(false);

            driver.findElement(By.cssSelector("button.btn.btn-success")).click();
            //doAnDat luc sau
            DoAnDat doAnDatAfter=getLastDoAnDat();

            Assert.assertEquals(doAnDatBefore.getGiaMua(),doAnDatAfter.getGiaMua());
            Assert.assertEquals(doAnDatBefore.getSoLuong(),doAnDatAfter.getSoLuong());
            Assert.assertEquals(doAnDatBefore.getDoAn().getTen(),doAnDatAfter.getDoAn().getTen());

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                DAO.con.rollback();
                DAO.con.setAutoCommit(true);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @Test
    public void TestLuuHoaDonKhongCoDoAnNao(){
        //xoa do an
        driver.findElement(By.cssSelector("a.btn")).click();
        String tb=driver.findElement(By.cssSelector("strong")).getText();
        Assert.assertEquals(tb,"Danh sách trống");

    }


    @Before
    public void Start(){
        System.setProperty("webdriver.chrome.driver"
                , "D:\\HOC TAP\\TOT NGHIEP\\PTTK DBCLPM\\Project\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("http://localhost:8080/QLBHAnUong_war_exploded/gdDangNhap.jsp");

        WebElement txt1=driver.findElement(By.name("username"));
        txt1.sendKeys("a");
        driver.findElement(By.name("password")).sendKeys("a");
        driver.findElement(By.cssSelector("input.btn")).click();
        driver.findElement(By.cssSelector("button")).click();

        String name="a";
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.cssSelector("input.btn")).click();
        driver.findElement(By.xpath("//div/table/tbody/tr[1]/td[3]/a")).click();
        WebElement soLuong=driver.findElement(By.name("soLuong"));
        soLuong.clear();
        soLuong.sendKeys("3");
        driver.findElement(By.cssSelector("input.btn")).click();
    }
    @After
    public void Finish(){
        driver.quit();
    }
    public DoAnDat getLastDoAnDat(){
        DoAnDat doAnDat=new DoAnDat();
        String sql = "SELECT * FROM tbldoandat,tblDoAn where " +
                "tblDoAn.id=tbldoandat.tblDoAnID ORDER BY tbldoandat.tblHoaDonID DESC LIMIT 1;";
        try{
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                doAnDat.setGiaMua(rs.getInt("giaMua"));
                doAnDat.setSoLuong(rs.getInt("soLuong"));
                DoAn doAn=new DoAn();
                doAn.setTen(rs.getString("ten"));
                doAnDat.setDoAn(doAn);
//                doAnDat.setKichCo(new KichCo(1,));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return doAnDat;
    }

    public HoaDon getLastHoaDon(){
        HoaDon hoaDon=new HoaDon();
        String sql = "SELECT * FROM qlbhanuong.tblhoadon ORDER BY id DESC LIMIT 1;";
        try{
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                hoaDon.setTinhTrang(rs.getString("tinhtrang"));
                hoaDon.setId(rs.getInt("id"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return hoaDon;
    }
    public int getLastIDHoaDon(){
        int kq=0;
        String sql = "SELECT * FROM tbldoandat ORDER BY tblHoaDonID DESC LIMIT 1;";
        try{
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                kq= rs.getInt("tblHoaDonID");
//                doAnDat.setKichCo(new KichCo(1,));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return kq;
    }

//    SELECT * FROM tbldoandat,tblDoAn,tblKichCo where (tblDoAn.id=tbldoandat.tblDoAnID and tblKichCo.id=tbldoandat.kichCo) ORDER BY tbldoandat.tblHoaDonID DESC LIMIT 1;
}
