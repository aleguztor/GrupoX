package Tests;
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
public class InsertarGrupoTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  private static final String UNIDAD_PERSISTENCIA_PRUEBAS = "AsignacionGruposTests";
  @Before
  public void setUp() {
	  
	 System.setProperty("webdriver.chrome.driver", "/home/alumno/git/GrupoX/AsignacionGrupos-tests/src/test/resources/chromedriver");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
    Base.inicializar(UNIDAD_PERSISTENCIA_PRUEBAS);
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void insertarGrupo() {
    driver.get("http://localhost:8080/AsignacionGrupos-war/");
    driver.manage().window().setSize(new Dimension(911, 928));
    driver.findElement(By.cssSelector(".u-palette-2-light-2")).click();
    driver.findElement(By.id("myform:username")).click();
    driver.findElement(By.id("myform:username")).sendKeys("secretaria");
    driver.findElement(By.id("myform:login")).sendKeys("secretaria");
    driver.findElement(By.id("myform:iniciarses")).click();
    driver.findElement(By.cssSelector(".u-icon-3 > .u-svg-link")).click();
    driver.findElement(By.id("j_idt5:idinput")).click();
    driver.findElement(By.id("j_idt5:idinput")).sendKeys("23");
    driver.findElement(By.id("j_idt5:inletra")).click();
    driver.findElement(By.id("j_idt5:inletra")).sendKeys("A");
    {
      WebElement element = driver.findElement(By.id("j_idt5:eleccioncurso"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.id("j_idt5:eleccioncurso"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.id("j_idt5:eleccioncurso"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.id("j_idt5:eleccioncurso")).click();
    {
      WebElement element = driver.findElement(By.id("j_idt5:inturno"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.id("j_idt5:inturno"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.id("j_idt5:inturno"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.id("j_idt5:inturno")).click();
    {
      WebElement element = driver.findElement(By.id("j_idt5:iningles"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.id("j_idt5:iningles"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.id("j_idt5:iningles"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.id("j_idt5:iningles")).click();
    {
      WebElement element = driver.findElement(By.id("j_idt5:visiblein"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.id("j_idt5:visiblein"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.id("j_idt5:visiblein"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.id("j_idt5:visiblein")).click();
    {
      WebElement element = driver.findElement(By.id("j_idt5:inasignar"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.id("j_idt5:inasignar"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.id("j_idt5:inasignar"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.id("j_idt5:inasignar")).click();
    driver.findElement(By.id("j_idt5:inplazas")).click();
    driver.findElement(By.id("j_idt5:inplazas")).sendKeys("23");
    driver.findElement(By.id("j_idt5:boton")).click();
    driver.findElement(By.cssSelector(".u-container-layout-3")).click();
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(1)")).click();
    assertThat(driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(1)")).getText(), is("23"));
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(2)")).click();
    assertThat(driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(2)")).getText(), is("A"));
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(3)")).click();
    assertThat(driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(3)")).getText(), is("Manyana"));
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(4)")).click();
    assertThat(driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(4)")).getText(), is("Si"));
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(5)")).click();
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(5)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(5)"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    assertThat(driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(5)")).getText(), is("Si"));
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(6)")).click();
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(6)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(6)"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    assertThat(driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(6)")).getText(), is("Si"));
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(7)")).click();
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(7)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(7)"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    assertThat(driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(7)")).getText(), is("23"));
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(8)")).click();
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(8)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(8)"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    assertThat(driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(8)")).getText(), is("0"));
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(9)")).click();
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(9)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(9)"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(9)")).click();
    assertThat(driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(9)")).getText(), is("0"));
  }
}
