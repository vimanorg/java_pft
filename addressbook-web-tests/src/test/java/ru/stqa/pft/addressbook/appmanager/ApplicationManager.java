package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApplicationManager {
  protected WebDriver wd; // Экземпляр веб-драйвера для управления браузером
  private  GroupHelper groupHelper;

  public void init() {
    System.setProperty("webdriver.gecko.driver", "C:\\Develop\\java_pft\\addressbook-web-tests\\WebDriver\\geckodriver.exe");

    FirefoxOptions options = new FirefoxOptions();
    options.setBinary("C:\\Users\\fayanovav\\AppData\\Local\\Mozilla Firefox\\firefox.exe"); // Указание пути к Firefox

    wd = new FirefoxDriver(options);
    wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // Неявное ожидание элементов

    // Явное ожидание: ждём, пока страница group.php загрузится и не вернёт ошибку "neterror"
    WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(30));
    wait.until(driver -> {
      try {
        driver.get("http://localhost:8080/addressbook/group.php");
        return !driver.getTitle().contains("neterror"); // Проверка, что страница загружена корректно
      } catch (Exception e) {
        return false;
      }
    });
    wd.get("http://localhost:8080/addressbook/group.php"); // Открытие страницы входа
    groupHelper = new GroupHelper(wd);

    // Авторизация
    login("admin", "secret");
  }

  private void login(String username, String password) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username); // Ввод логина

    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password); // Ввод пароля

    wd.findElement(By.xpath("//input[@value='Login']")).click(); // Клик на кнопку "Login"
  }

  public void stop() {
    wd.quit();
  }

  /**
   * Вспомогательный метод: проверяет, присутствует ли элемент на странице.
   * Возвращает true, если элемент найден, false — если NoSuchElementException.
   * Используется для безопасной проверки наличия элементов без падения теста.
   */
  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  /**
   * Вспомогательный метод: проверяет, отображается ли всплывающее окно (alert).
   * Возвращает true, если alert присутствует, false — если NoAlertPresentException.
   * Используется для обработки JavaScript-предупреждений.
   */
  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }
}
