package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

/**
 * Тест-кейс для проверки создания группы в приложении Address Book.
 * Выполняет полный сценарий: вход в систему → создание группы
 * Использует Selenium WebDriver для автоматизации взаимодействия с веб-интерфейсом.
 */
public class WorkGroupCreationTests extends TestBase {

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
    goToGroupPage();// Переход к созданию группы
    initGroupCreation(); // Клик на кнопку "New Group"
    fillGroupForm(new GroupData("test1", "test2", "test3"));// Заполнение данных группы
    submitGroupGreation(); // Сохранение группы
    goToGroupPage();// Возврат к списку групп
  }

}