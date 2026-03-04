package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;


public class WorkGroupCreationTests extends TestBaseold {

  @Test
  public void testGroupCreation() throws Exception {
    app.getGroupHelper().returnToGroupPage();// Переход к созданию группы
    app.getGroupHelper().initGroupCreation(); // Клик на кнопку "New Group"
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));// Заполнение данных группы
    app.getGroupHelper().submitGroupGreation(); // Сохранение группы
    app.getGroupHelper().returnToGroupPage();// Возврат к списку групп
  }

}