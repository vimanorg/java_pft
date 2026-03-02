package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class GroupDeletionTests extends TestBase {

  @Test
  public void WorkGroupDeletionTests() throws Exception {
   goToGroupPage();
    selectGroup();
    deleteSelectedGroups();
    goToGroupPage();
  }


}




