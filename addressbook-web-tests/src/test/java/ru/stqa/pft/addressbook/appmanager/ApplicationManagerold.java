package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import java.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationManagerold {
  protected WebDriver wd; // Экземпляр веб-драйвера для управления браузером
  private NavigationHelperold navigationHelper;
  private GroupHelperold groupHelper;
  private String browser;
  private static final Logger logger = LoggerFactory.getLogger(ApplicationManagerold.class);

  public ApplicationManagerold(String browser) {
    this.browser = browser;
  }

  public void init() {
    logger.info("Инициализация браузера: {}", browser);

    if ("firefox".equalsIgnoreCase(browser)) {
      System.setProperty("webdriver.gecko.driver", "C:\\Develop\\java_pft\\addressbook-web-tests\\WebDriver\\geckodriver.exe");
      FirefoxOptions options = new FirefoxOptions();
      options.setBinary("C:\\Users\\fayanovav\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
      wd = new FirefoxDriver(options);
    } else if ("chrome".equalsIgnoreCase(browser)) {
      ChromeOptions chromeOptions = new ChromeOptions();
      wd = new ChromeDriver(chromeOptions);
    } else if ("ie".equalsIgnoreCase(browser)) {
      InternetExplorerOptions ieOptions = new InternetExplorerOptions();
      wd = new InternetExplorerDriver(ieOptions);
    } else {
      throw new IllegalArgumentException("Не поддерживаемый браузер: " + browser);
    }

    wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    wd.manage().window().maximize();

    navigationHelper = new NavigationHelperold(wd);
    groupHelper = new GroupHelperold(wd);

    navigationHelper.goToGrupePage(wd);

    // Авторизация
    SessionHelperold sessionHelper = new SessionHelperold(wd);
    sessionHelper.login("admin", "secret");

    logger.info("Инициализация ApplicationManager завершена");
  }

  public void stop() {
    if (wd != null) {
      wd.quit();
    }
  }

  public GroupHelperold getGroupHelper() {
    return groupHelper;
  }
}