package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

public class WorkGroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
   app.getGroupHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().goToGroupPage();
  }


}




