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

public class TestThemDoAnVaoHoaDon {
    private WebDriver driver;

    @Test
    public void TestThem1DoAnVaoHoaDon(){


        WebElement table=driver.findElement(By.xpath("//table/tbody"));
        List<WebElement> rows=table.findElements(By.tagName("tr"));

        Assert.assertEquals(rows.size(),1);
        List<WebElement> columns=rows.get(0).findElements(By.tagName("td"));
        Assert.assertEquals(columns.get(4).getText(),3+"");

        String tongTien="Tổng tiền: "+columns.get(5).getText()+" VND";
        Assert.assertEquals(tongTien,driver.findElement(By.cssSelector("h4")).getText());
    }

    @Test
    public void TestThem2DoAnVaoHoaDon(){

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

        Assert.assertEquals(rows.size(),2);
        List<WebElement> column1=rows.get(0).findElements(By.tagName("td"));
        Assert.assertEquals(column1.get(4).getText(),3+"");
        int tien1=Integer.parseInt(column1.get(5).getText());

        List<WebElement> column2=rows.get(1).findElements(By.tagName("td"));
        Assert.assertEquals(column2.get(4).getText(),5+"");
        int tien2=Integer.parseInt(column2.get(5).getText());

        String tongTien="Tổng tiền: "+(tien1+tien2)+" VND";
        Assert.assertEquals(tongTien,driver.findElement(By.cssSelector("h4")).getText());
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
}
