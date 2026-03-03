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
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;

  public void init() {
    System.setProperty("webdriver.gecko.driver", "C:\\Develop\\java_pft\\addressbook-web-tests\\WebDriver\\geckodriver.exe");
    FirefoxOptions options = new FirefoxOptions();
    options.setBinary("C:\\Users\\fayanovav\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
    wd = new FirefoxDriver(options);
    wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    navigationHelper = new NavigationHelper(wd);
    groupHelper = new GroupHelper(wd);
    navigationHelper.goToGrupePage(wd);

    // Авторизация
    SessionHelper sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }

  public void stop() {
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

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

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}