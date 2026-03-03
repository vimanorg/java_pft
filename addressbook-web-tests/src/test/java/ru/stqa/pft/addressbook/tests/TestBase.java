package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

public class TestBase {

  protected final ApplicationManager app = new ApplicationManager();

  /**
   * Инициализация перед каждым тестом.
   * - Устанавливает путь к драйверу GeckoDriver для Firefox.
   * - Настраивает Firefox с указанием пути к исполняемому файлу.
   * - Устанавливает неявное ожидание 30 секунд.
   * - Ожидает загрузки страницы group.php и проверяет, что это не ошибка "neterror".
   */
  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }


  /**
   * Очистка после каждого теста.
   * Закрывает браузер и освобождает ресурсы.
   */
  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop(); // Завершение сессии WebDriver
  }

}
