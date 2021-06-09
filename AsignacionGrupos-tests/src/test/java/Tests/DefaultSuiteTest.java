// Generated by Selenium IDE
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
public class DefaultSuiteTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  
  private static final String UNIDAD_PERSISTENCIA_PRUEBAS = "AsignacionGruposTests";
	
  JavascriptExecutor js;
  @Before
  public void setUp() {
	System.setProperty("webdriver.chrome.driver","/home/alumno/git/GrupoX/AsignacionGrupos-tests/src/test/resources/chromedriver");
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
  public void insertarAlumnoPrueba() {
    driver.get("http://localhost:8080/AsignacionGrupos-war/");
    driver.manage().window().setSize(new Dimension(1056, 808));
    driver.findElement(By.cssSelector(".u-palette-2-light-2")).click();
    driver.findElement(By.id("myform:username")).click();
    driver.findElement(By.id("myform:username")).sendKeys("secretaria");
    driver.findElement(By.id("myform:login")).click();
    driver.findElement(By.id("myform:login")).sendKeys("secretaria");
    driver.findElement(By.id("myform:iniciarses")).click();
    driver.findElement(By.cssSelector(".u-expanded-width-md:nth-child(3) .u-align-center:nth-child(1) > .u-container-layout")).click();
    driver.findElement(By.id("form-insert:nombrein")).click();
    driver.findElement(By.id("form-insert:nombrein")).sendKeys("Jose");
    driver.findElement(By.id("form-insert:apellido1")).sendKeys("Gutierrez");
    driver.findElement(By.id("form-insert:apellido2")).sendKeys("Poyato");
    driver.findElement(By.id("form-insert:dni")).sendKeys("1295734a");
    driver.findElement(By.id("form-insert:emailinsti")).sendKeys("josemariagutierrez@uma.es");
    driver.findElement(By.id("form-insert:titualcionin")).sendKeys("1041");
    {
      WebElement dropdown = driver.findElement(By.id("form-insert:selecttrue"));
      dropdown.findElement(By.xpath("//option[. = 'Si']")).click();
    }
    driver.findElement(By.id("form-insert:notain")).sendKeys("7.0");
    driver.findElement(By.id("form-insert:submit")).click();
    driver.findElement(By.cssSelector(".u-container-layout-4")).click();
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(3) > td:nth-child(1)")).click();
    assertThat(driver.findElement(By.cssSelector(".ui-widget-content:nth-child(3) > td:nth-child(1)")).getText(), is("1295734a"));
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(3) > td:nth-child(2)")).click();
    assertThat(driver.findElement(By.cssSelector(".ui-widget-content:nth-child(3) > td:nth-child(2)")).getText(), is("Jose"));
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(3) > td:nth-child(3)")).click();
    assertThat(driver.findElement(By.cssSelector(".ui-widget-content:nth-child(3) > td:nth-child(3)")).getText(), is("Gutierrez"));
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(3) > td:nth-child(4)")).click();
    assertThat(driver.findElement(By.cssSelector(".ui-widget-content:nth-child(3) > td:nth-child(4)")).getText(), is("Poyato"));
    {
      WebElement element = driver.findElement(By.cssSelector(".ui-widget-content:nth-child(3) > td:nth-child(4)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".ui-widget-content:nth-child(3) > td:nth-child(4)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".ui-widget-content:nth-child(3) > td:nth-child(4)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(5)")).click();
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(3) > td:nth-child(5)")).click();
    assertThat(driver.findElement(By.cssSelector(".ui-widget-content:nth-child(3) > td:nth-child(5)")).getText(), is("josemariagutierrez@uma.es"));
    driver.findElement(By.id("j_idt5:listal:2:pasoIdExp")).click();
    driver.findElement(By.cssSelector("td:nth-child(1)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(1)")).getText(), is("10"));
    driver.findElement(By.cssSelector("td:nth-child(2)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(2)")).getText(), is("7.0"));
    driver.findElement(By.cssSelector("td:nth-child(3)")).click();
    driver.findElement(By.cssSelector("td:nth-child(3)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(3)")).getText(), is("1041"));
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(3)")).click();
  }
  @Test
  public void insertarCentroPrueba() {
    driver.get("http://localhost:8080/AsignacionGrupos-war/");
    driver.manage().window().setSize(new Dimension(1051, 806));
    driver.findElement(By.cssSelector(".u-palette-2-light-2")).click();
    driver.findElement(By.id("myform:username")).click();
    driver.findElement(By.id("myform:username")).sendKeys("secretaria");
    driver.findElement(By.id("myform:login")).click();
    driver.findElement(By.id("myform:login")).sendKeys("secretaria");
    driver.findElement(By.id("myform:iniciarses")).click();
    driver.findElement(By.cssSelector(".u-container-layout-2")).click();
    driver.findElement(By.id("centro_form:nombrecentro")).click();
    driver.findElement(By.id("centro_form:idcentro")).click();
    driver.findElement(By.id("centro_form:idcentro")).sendKeys("2167341");
    driver.findElement(By.id("centro_form:nombrecentro")).click();
    driver.findElement(By.id("centro_form:nombrecentro")).sendKeys("Escuela Ingenieria Informatica");
    driver.findElement(By.id("centro_form:direccion")).click();
    driver.findElement(By.id("centro_form:direccion")).sendKeys("Ortega Gasset");
    driver.findElement(By.id("centro_form:tlf")).click();
    driver.findElement(By.id("centro_form:tlf")).sendKeys("3265236");
    driver.findElement(By.id("centro_form:submit")).click();
    driver.findElement(By.cssSelector(".u-container-layout-2")).click();
    driver.findElement(By.cssSelector(".ui-widget-content > td:nth-child(1)")).click();
    assertThat(driver.findElement(By.cssSelector(".ui-widget-content > td:nth-child(1)")).getText(), is("2167341"));
    driver.findElement(By.cssSelector(".ui-widget-content > td:nth-child(2)")).click();
    driver.findElement(By.cssSelector(".ui-widget-content > td:nth-child(2)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".ui-widget-content > td:nth-child(2)"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    assertThat(driver.findElement(By.cssSelector(".ui-widget-content > td:nth-child(2)")).getText(), is("Escuela Ingenieria Informatica"));
    driver.findElement(By.cssSelector("td:nth-child(3)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(3)")).getText(), is("Ortega Gasset"));
    driver.findElement(By.cssSelector("td:nth-child(4)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(4)")).getText(), is("3265236"));
  }
  @Test
  public void insertarEncuestaPrueba() {
    driver.get("http://localhost:8080/AsignacionGrupos-war/");
    driver.manage().window().setSize(new Dimension(1051, 806));
    driver.findElement(By.cssSelector(".u-palette-2-light-2")).click();
    driver.findElement(By.id("myform:username")).click();
    driver.findElement(By.id("myform:username")).sendKeys("alumno");
    driver.findElement(By.id("myform:login")).sendKeys("alumno");
    driver.findElement(By.id("myform:login")).sendKeys(Keys.ENTER);
    driver.findElement(By.cssSelector(".u-icon-1 > .u-svg-link")).click();
    driver.findElement(By.id("centro_form:dni")).click();
    driver.findElement(By.id("centro_form:dni")).click();
    driver.findElement(By.id("centro_form:dni")).sendKeys("12345678a");
    driver.findElement(By.id("centro_form:submit")).click();
    driver.findElement(By.linkText("Log out")).click();
    driver.findElement(By.name("j_idt6:j_idt7")).click();
    driver.findElement(By.id("myform:username")).click();
    driver.findElement(By.id("myform:username")).sendKeys("secretaria");
    driver.findElement(By.id("myform:login")).click();
    driver.findElement(By.id("myform:login")).sendKeys("secretaria");
    driver.findElement(By.id("myform:iniciarses")).click();
    driver.findElement(By.cssSelector(".u-icon-6 use")).click();
    driver.findElement(By.cssSelector("td:nth-child(1)")).click();
    driver.findElement(By.cssSelector("td:nth-child(1)")).click();
    driver.findElement(By.cssSelector("td:nth-child(1)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(1)")).getText(), is("2021-06-09"));
    driver.findElement(By.cssSelector("td:nth-child(2)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(2)")).getText(), is("214623"));
    driver.findElement(By.cssSelector("td:nth-child(3)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(3)")).getText(), is("Manyana"));
  }
  @Test
  public void insertarGrupoPrueba() {
    driver.get("http://localhost:8080/AsignacionGrupos-war/");
    driver.manage().window().setSize(new Dimension(1053, 807));
    driver.findElement(By.cssSelector(".u-palette-2-light-2")).click();
    driver.findElement(By.id("myform:usertext")).click();
    driver.findElement(By.id("myform:username")).click();
    driver.findElement(By.id("myform:username")).sendKeys("secretaria");
    driver.findElement(By.id("myform:login")).click();
    driver.findElement(By.id("myform:login")).sendKeys("secretaria");
    driver.findElement(By.id("myform:iniciarses")).click();
    driver.findElement(By.cssSelector(".u-container-layout-3")).click();
    driver.findElement(By.id("j_idt5:idinput")).click();
    driver.findElement(By.id("j_idt5:idinput")).sendKeys("7125471");
    driver.findElement(By.id("j_idt5:eleccioncurso")).click();
    driver.findElement(By.id("j_idt5:eleccioncurso")).click();
    driver.findElement(By.id("j_idt5:inletra")).click();
    driver.findElement(By.id("j_idt5:inletra")).sendKeys("A");
    driver.findElement(By.id("j_idt5:inturno")).click();
    driver.findElement(By.id("j_idt5:inturno")).click();
    driver.findElement(By.id("j_idt5:iningles")).click();
    driver.findElement(By.id("j_idt5:iningles")).click();
    driver.findElement(By.id("j_idt5:visiblein")).click();
    driver.findElement(By.id("j_idt5:visiblein")).click();
    driver.findElement(By.id("j_idt5:inasignar")).click();
    driver.findElement(By.id("j_idt5:inasignar")).click();
    driver.findElement(By.id("j_idt5:inplazas")).click();
    driver.findElement(By.id("j_idt5:inplazas")).sendKeys("20");
    driver.findElement(By.id("j_idt5:boton")).click();
    driver.findElement(By.cssSelector(".u-container-layout-3")).click();
    driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(1)")).click();
    driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(1)")).click();
    driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(1)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(1)"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    assertThat(driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(1)")).getText(), is("7125471"));
    driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(2)")).click();
    driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(2)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(2)"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    assertThat(driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(2)")).getText(), is("A"));
    driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(3)")).click();
    driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(3)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    assertThat(driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(3)")).getText(), is("Manyana"));
    driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(4)")).click();
    driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(4)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(4)"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    assertThat(driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(4)")).getText(), is("Si"));
    {
      WebElement element = driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(5)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(5)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(5)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(5)")).click();
    driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(5)")).click();
    assertThat(driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(5)")).getText(), is("Si"));
    driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(6)")).click();
    driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(6)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(6)"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    assertThat(driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(6)")).getText(), is("Si"));
    driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(7)")).click();
    driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(7)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(7)"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    assertThat(driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(7)")).getText(), is("20"));
    driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(8)")).click();
    driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(8)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(8)"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    assertThat(driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(8)")).getText(), is("0"));
    driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(9)")).click();
    driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(9)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(9)"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    assertThat(driver.findElement(By.cssSelector(".ui-datatable-odd > td:nth-child(9)")).getText(), is("0"));
  }
  @Test
  public void insertarMatriculaPrueba() {
    driver.get("http://localhost:8080/AsignacionGrupos-war/");
    driver.manage().window().setSize(new Dimension(1051, 806));
    driver.findElement(By.cssSelector(".u-palette-2-light-2")).click();
    driver.findElement(By.id("myform:username")).click();
    driver.findElement(By.id("myform:username")).sendKeys("secretaria");
    driver.findElement(By.id("myform:login")).click();
    driver.findElement(By.id("myform:login")).sendKeys("secretaria");
    driver.findElement(By.id("myform:iniciarses")).click();
    driver.findElement(By.cssSelector(".u-container-layout-7")).click();
    driver.findElement(By.name("j_idt6:j_idt10")).click();
    driver.findElement(By.name("j_idt6:j_idt10")).sendKeys("214623");
    driver.findElement(By.name("j_idt6:j_idt14")).click();
    driver.findElement(By.name("j_idt6:j_idt14")).sendKeys("20/21");
    driver.findElement(By.name("j_idt6:j_idt18")).click();
    driver.findElement(By.name("j_idt6:j_idt18")).click();
    driver.findElement(By.name("j_idt6:j_idt24")).click();
    driver.findElement(By.name("j_idt6:j_idt24")).sendKeys("1261512");
    driver.findElement(By.name("j_idt6:j_idt28")).click();
    driver.findElement(By.name("j_idt6:j_idt28")).click();
    driver.findElement(By.name("j_idt6:j_idt34")).click();
    driver.findElement(By.name("j_idt6:j_idt34")).sendKeys("09/06/2021");
    driver.findElement(By.name("j_idt6:j_idt38")).click();
    driver.findElement(By.name("j_idt6:j_idt38")).click();
    driver.findElement(By.id("j_idt6:sumbtn")).click();
    driver.findElement(By.id("j_idt5:listal:0:pasoIdExp")).click();
    driver.findElement(By.id("form:j_idt5:0:pasoNumexp")).click();
    driver.findElement(By.cssSelector("td:nth-child(1)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(1)")).getText(), is("1261512"));
    driver.findElement(By.cssSelector("td:nth-child(2)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(2)")).getText(), is("A"));
    driver.findElement(By.cssSelector("td:nth-child(3)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(3)")).getText(), is("M"));
    driver.findElement(By.cssSelector("td:nth-child(4)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(4)")).getText(), is("20/21"));
    driver.findElement(By.cssSelector("td:nth-child(5)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(5)")).getText(), is("S"));
  }
  @Test
  public void insertarYborrarAsignatura() {
    driver.get("http://0.0.0.0:8080/AsignacionGrupos-war/faces/Login.xhtml");
    driver.manage().window().setSize(new Dimension(911, 947));
    driver.findElement(By.id("myform:username")).click();
    driver.findElement(By.id("myform:username")).sendKeys("secretaria");
    driver.findElement(By.id("myform:login")).sendKeys("secretaria");
    driver.findElement(By.id("myform:iniciarses")).click();
    driver.findElement(By.cssSelector(".u-container-layout-5")).click();
    driver.findElement(By.name("j_idt6:j_idt10")).click();
    driver.findElement(By.name("j_idt6:j_idt10")).sendKeys("000001");
    driver.findElement(By.name("j_idt6:j_idt14")).click();
    driver.findElement(By.name("j_idt6:j_idt14")).sendKeys("00000002");
    driver.findElement(By.name("j_idt6:j_idt18")).click();
    driver.findElement(By.name("j_idt6:j_idt18")).click();
    {
      WebElement element = driver.findElement(By.name("j_idt6:j_idt18"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.name("j_idt6:j_idt18")).sendKeys("6");
    driver.findElement(By.name("j_idt6:j_idt22")).click();
    driver.findElement(By.name("j_idt6:j_idt22")).sendKeys("Programacion");
    {
      WebElement dropdown = driver.findElement(By.name("j_idt6:j_idt26"));
      dropdown.findElement(By.xpath("//option[. = 'Si']")).click();
    }
    {
      WebElement element = driver.findElement(By.name("j_idt6:j_idt26"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.name("j_idt6:j_idt26"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.name("j_idt6:j_idt26"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.name("j_idt6:j_idt26")).click();
    {
      WebElement element = driver.findElement(By.name("j_idt6:j_idt32"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.name("j_idt6:j_idt32"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.name("j_idt6:j_idt32"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.name("j_idt6:j_idt32")).click();
    {
      WebElement element = driver.findElement(By.name("j_idt6:j_idt40"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.name("j_idt6:j_idt40"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.name("j_idt6:j_idt40"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.name("j_idt6:j_idt40")).click();
    {
      WebElement element = driver.findElement(By.name("j_idt6:j_idt47"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.name("j_idt6:j_idt47"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.name("j_idt6:j_idt47"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.name("j_idt6:j_idt47")).click();
    driver.findElement(By.cssSelector("tbody:nth-child(1)")).click();
    driver.findElement(By.name("j_idt6:j_idt59")).click();
    driver.findElement(By.name("j_idt6:j_idt59")).sendKeys("1041");
    driver.findElement(By.name("j_idt6:j_idt61")).click();
    driver.findElement(By.cssSelector(".u-container-layout-5")).click();
    driver.findElement(By.cssSelector(".ui-widget-content > td:nth-child(1)")).click();
    assertThat(driver.findElement(By.cssSelector(".ui-widget-content > td:nth-child(1)")).getText(), is("000001"));
    driver.findElement(By.id("j_idt65:listasg:0:elimbtn")).click();
    driver.findElement(By.cssSelector(".ui-widget-content > td")).click();
    assertThat(driver.findElement(By.cssSelector(".ui-widget-content > td")).getText(), is("No records found."));
  }
  @Test
  public void listadoAlumnosPrueba() {
    driver.get("http://localhost:8080/AsignacionGrupos-war/");
    driver.manage().window().setSize(new Dimension(1051, 806));
    driver.findElement(By.cssSelector(".u-palette-2-light-2")).click();
    driver.findElement(By.id("myform:username")).click();
    driver.findElement(By.id("myform:username")).sendKeys("secretaria");
    driver.findElement(By.id("myform:login")).click();
    driver.findElement(By.id("myform:login")).sendKeys("secretaria");
    driver.findElement(By.id("myform:iniciarses")).click();
    driver.findElement(By.cssSelector(".u-container-layout-4")).click();
    driver.findElement(By.cssSelector("td:nth-child(1)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(1)")).getText(), is("12345678a"));
    driver.findElement(By.cssSelector("td:nth-child(2)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(2)")).getText(), is("Mario"));
    driver.findElement(By.cssSelector("td:nth-child(3)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(3)")).getText(), is("Vazquez"));
    driver.findElement(By.cssSelector("td:nth-child(5)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(5)")).getText(), is("mario@uma.es"));
  }
  @Test
  public void listadoExpedientePrueba() {
    driver.get("http://localhost:8080/AsignacionGrupos-war/");
    driver.manage().window().setSize(new Dimension(1056, 808));
    driver.findElement(By.cssSelector(".u-palette-2-light-2")).click();
    driver.findElement(By.id("myform:username")).click();
    driver.findElement(By.id("myform:username")).sendKeys("secretaria");
    driver.findElement(By.id("myform:login")).click();
    driver.findElement(By.id("myform:login")).sendKeys("secretaria");
    driver.findElement(By.cssSelector(".u-container-layout-4")).click();
    driver.findElement(By.id("j_idt5:listal:0:pasoIdExp")).click();
    driver.findElement(By.cssSelector("td:nth-child(1)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(1)")).getText(), is("214623"));
    driver.findElement(By.cssSelector("td:nth-child(2)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(2)")).getText(), is("5.0"));
    driver.findElement(By.cssSelector("td:nth-child(3)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(3)")).getText(), is("1041"));
    driver.findElement(By.id("myform:iniciarses")).click();
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
  @Test
  public void importacionDatosYListados() {
    driver.get("http://0.0.0.0:8080/AsignacionGrupos-war/faces/Login.xhtml");
    driver.manage().window().setSize(new Dimension(911, 947));
    driver.findElement(By.id("myform:username")).click();
    driver.findElement(By.id("myform:username")).sendKeys("secretaria");
    driver.findElement(By.id("myform:login")).sendKeys("secretaria");
    driver.findElement(By.id("myform:iniciarses")).click();
    driver.findElement(By.cssSelector(".u-expanded-width-md:nth-child(1) .u-container-layout")).click();
    driver.findElement(By.id("import_form:file")).click();
    driver.findElement(By.id("import_form:file")).sendKeys("C:\\fakepath\\Datos alumnadoFAKE.xlsx");
    driver.findElement(By.id("import_form:botonencuesta")).click();
    driver.findElement(By.cssSelector(".u-container-layout-4")).click();
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(1)")).click();
    assertThat(driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(1)")).getText(), is("95115697E"));
    driver.findElement(By.id("j_idt5:listal:0:pasoIdExp")).click();
    driver.findElement(By.cssSelector("td:nth-child(1)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(1)")).getText(), is("2"));
    driver.findElement(By.id("form:j_idt5:0:pasoNumexp")).click();
    driver.findElement(By.cssSelector("td:nth-child(1)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(1)")).getText(), is("306000001"));
    driver.findElement(By.id("j_idt7:listadobtn")).click();
  }
  @Test
  public void importacionAsignaturas() {
    driver.get("http://0.0.0.0:8080/AsignacionGrupos-war/faces/Login.xhtml");
    driver.manage().window().setSize(new Dimension(911, 947));
    driver.findElement(By.id("myform:username")).click();
    driver.findElement(By.id("myform:username")).sendKeys("secretaria");
    driver.findElement(By.id("myform:login")).sendKeys("secretaria");
    driver.findElement(By.id("myform:iniciarses")).click();
    driver.findElement(By.cssSelector(".u-text-1:nth-child(2)")).click();
    driver.findElement(By.id("import_form_asignaturas:fileAsignaturas")).click();
    driver.findElement(By.id("import_form_asignaturas:fileAsignaturas")).sendKeys("C:\\fakepath\\Asignaturas.xlsx");
    driver.findElement(By.id("import_form_asignaturas:boton")).click();
    driver.findElement(By.cssSelector(".u-icon-5 > .u-svg-link")).click();
    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(1)")).click();
    assertThat(driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(1)")).getText(), is("50661.0"));
    driver.findElement(By.id("j_idt64:backButton")).click();
  }
}