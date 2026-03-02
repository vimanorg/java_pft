package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Тест-кейс для проверки создания группы в приложении Address Book.
 * Выполняет полный сценарий: вход в систему → создание группы → выход.
 * Использует Selenium WebDriver для автоматизации взаимодействия с веб-интерфейсом.
 */
public class WorkGroupCreationTests {

  private WebDriver wd; // Экземпляр веб-драйвера для управления браузером

  /**
   * Инициализация перед каждым тестом.
   * - Устанавливает путь к драйверу GeckoDriver для Firefox.
   * - Настраивает Firefox с указанием пути к исполняемому файлу.
   * - Устанавливает неявное ожидание 30 секунд.
   * - Ожидает загрузки страницы group.php и проверяет, что это не ошибка "neterror".
   */
  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
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

    // Авторизация
    wd.findElement(By.id("LoginForm")).click(); // Клик по форме (возможно, лишний)
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys("admin"); // Ввод логина

    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys("secret"); // Ввод пароля

    wd.findElement(By.xpath("//input[@value='Login']")).click(); // Клик на кнопку "Login"
  }

  /**
   * Основной тест: создание новой группы.
   * Шаги:
   * 1. Открытие страницы входа.
   * 2. Ввод логина и пароля.
   * 3. Авторизация.
   * 4. Переход к созданию группы.
   * 5. Заполнение полей: имя, заголовок, подвал группы.
   * 6. Сохранение группы.
   * 7. Переход к списку групп.
   * 8. Выход из системы.
   */
  @Test
  public void testGroupCreation() throws Exception {


    // Переход к созданию группы
    wd.findElement(By.name("new")).click(); // Клик на кнопку "New Group"

    // Заполнение данных группы
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys("test1"); // Имя группы

    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys("test2"); // Заголовок

    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys("test3"); // Подвал

    wd.findElement(By.name("submit")).click(); // Сохранение группы

    // Навигация и выход
    wd.findElement(By.linkText("groups")).click(); // Переход к списку групп
    wd.findElement(By.linkText("Logout")).click(); // Выход из системы
  }

  /**
   * Очистка после каждого теста.
   * Закрывает браузер и освобождает ресурсы.
   */
  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit(); // Завершение сессии WebDriver
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
}