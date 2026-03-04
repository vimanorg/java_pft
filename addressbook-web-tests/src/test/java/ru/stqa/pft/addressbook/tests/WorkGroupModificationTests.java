package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDataold;

public class WorkGroupModificationTests extends TestBaseold {

  @Test
  public void testGroupModification(){
    app.getGroupHelper().returnToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupDataold("test1", "test2", "test3"));
    app.getGroupHelper().submitGroupModification();//
    app.getGroupHelper().returnToGroupPage();// Возврат к списку групп// Заполнение данных группы
  }

}