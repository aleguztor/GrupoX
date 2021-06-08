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
public class ListadoMatriculaPruebaTest {
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
  public void listadoMatriculaPrueba() {
    driver.get("http://localhost:8080/AsignacionGrupos-war/");
    driver.manage().window().setSize(new Dimension(1057, 811));
    driver.findElement(By.cssSelector(".u-btn")).click();
    driver.findElement(By.id("myform:username")).click();
    driver.findElement(By.id("myform:username")).sendKeys("secretaria");
    driver.findElement(By.id("myform:login")).click();
    driver.findElement(By.id("myform:login")).sendKeys("secretaria");
    driver.findElement(By.id("myform:login")).sendKeys(Keys.ENTER);
    driver.findElement(By.cssSelector(".boton:nth-child(10)")).click();
    driver.findElement(By.id("j_idt5:tabla:1:pasoIdExp")).click();
    driver.findElement(By.id("j_idt5:j_idt6:0:pasoNumexp")).click();
    driver.findElement(By.cssSelector("td:nth-child(1)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(1)")).getText(), is("8123574"));
    driver.findElement(By.cssSelector("td:nth-child(2)")).click();
    driver.findElement(By.cssSelector("td:nth-child(3)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(3)")).getText(), is("M"));
    driver.findElement(By.cssSelector("td:nth-child(4)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(4)")).getText(), is("20/21"));
    driver.findElement(By.cssSelector("td:nth-child(5)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(5)")).getText(), is("Y"));
    assertThat(driver.findElement(By.cssSelector("td:nth-child(2)")).getText(), is("A"));
  }
}
*/