/*package Tests;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class InsertadoAlumnoPruebaTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void insertadoAlumnoPrueba() {
    driver.get("http://localhost:8080/AsignacionGrupos-war/");
    driver.manage().window().setSize(new Dimension(1051, 806));
    driver.findElement(By.cssSelector(".u-btn")).click();
    driver.findElement(By.id("myform:username")).click();
    driver.findElement(By.id("myform:username")).sendKeys("secretaria");
    driver.findElement(By.id("myform:login")).click();
    driver.findElement(By.id("myform:login")).sendKeys("secretaria");
    driver.findElement(By.id("myform:iniciarses")).click();
    driver.findElement(By.cssSelector(".boton:nth-child(5)")).click();
    driver.findElement(By.id("form-insert:nombrein")).click();
    driver.findElement(By.id("form-insert:nombrein")).sendKeys("Juan");
    driver.findElement(By.id("form-insert:apellido1")).sendKeys("Vazquez");
    driver.findElement(By.id("form-insert:apellido2")).sendKeys("Garcia");
    driver.findElement(By.id("form-insert:dni")).sendKeys("12345678z");
    driver.findElement(By.id("form-insert:emailinsti")).sendKeys("123552@uma.es");
    driver.findElement(By.id("form-insert:emailperso")).sendKeys("112341@gmail.com");
    driver.findElement(By.id("form-insert:movil")).sendKeys("123456789");
    driver.findElement(By.id("form-insert:telefono")).sendKeys("12346356");
    driver.findElement(By.id("form-insert:direccion")).sendKeys("sdfgs");
    driver.findElement(By.id("form-insert:localidad")).sendKeys("Malaga");
    driver.findElement(By.id("form-insert:provincia")).sendKeys("Malaga");
    driver.findElement(By.id("form-insert:cp")).sendKeys("29000");
    driver.findElement(By.id("form-insert:submit")).click();
    driver.findElement(By.cssSelector(".boton:nth-child(10)")).click();
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(4) > td:nth-child(1)")).click();
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".ui-widget-content:nth-child(4) > td:nth-child(1)"));
      assert(elements.size() > 0);
    }
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(4) > td:nth-child(2)")).click();
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".ui-widget-content:nth-child(4) > td:nth-child(2)"));
      assert(elements.size() > 0);
    }
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(4) > td:nth-child(3)")).click();
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".ui-widget-content:nth-child(4) > td:nth-child(3)"));
      assert(elements.size() > 0);
    }
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(4) > td:nth-child(4)")).click();
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".ui-widget-content:nth-child(4) > td:nth-child(4)"));
      assert(elements.size() > 0);
    }
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(4) > td:nth-child(5)")).click();
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".ui-widget-content:nth-child(4) > td:nth-child(5)"));
      assert(elements.size() > 0);
    }
  }
}
*/