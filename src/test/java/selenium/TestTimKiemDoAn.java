package selenium;

import ducanh.qlbhanuong.dao.DoAnDAO;
import ducanh.qlbhanuong.model.DoAn;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestTimKiemDoAn {
    private WebDriver driver;
    private DoAnDAO doAnDAO=new DoAnDAO();

    @Test
    public void TestTimDanhSachNhieuDoAn(){
        //danh sach do an tim duoc co nhieu mon
        String name="a";
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.cssSelector("input.btn")).click();

        WebElement table=driver.findElement(By.xpath("//div/table/tbody"));
        List<WebElement> rows=table.findElements(By.tagName("tr"));

        List<DoAn> list=doAnDAO.getDoAnByName(name);
        Assert.assertEquals(rows.size(),list.size());

        for (int i=0;i<rows.size();i++){
            List<WebElement> columns=rows.get(i).findElements(By.tagName("td"));
//            System.out.println(rows.get(i).findElement(By.tagName("td")).getText());
            Assert.assertEquals(columns.get(1).getText(),list.get(i).getTen());
        }

//        String ten=driver.findElement(By.xpath("//div/table/tbody/tr[1]/td[2]")).getText();

    }

    @Test
    public void TestTimDanhSachTrong(){
        String name="9999";
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.cssSelector("input.btn")).click();

        String tb=driver.findElement(By.cssSelector("strong")).getText();
        Assert.assertEquals(tb,"Không tìm thấy đồ ăn nào!");
    }

    @Test
    public void TestTimVoiTenLaKiTuDacBiet(){
        String name="^$%#^#%$#";
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.cssSelector("input.btn")).click();

        String tb=driver.findElement(By.cssSelector("strong")).getText();
        Assert.assertEquals(tb,"Không tìm thấy đồ ăn nào!");
    }

    @Test
    public void TestTimVoiTenRatDai(){
        String name="sdfghusdifghsdfgosfhsiofghisfghisfghisrhgiwsergheiwrghweiorghioesfghseiorhgieor" +
                "hugeiorghiodufhgiosehgisedhfugioseurghiosehgioseghseioghisdofghseiogrhseiofghiseghseg";
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.cssSelector("input.btn")).click();

        String tb=driver.findElement(By.cssSelector("strong")).getText();
        Assert.assertEquals(tb,"Không tìm thấy đồ ăn nào!");
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

    }
    @After
    public void Finish(){
        driver.quit();
    }
}
