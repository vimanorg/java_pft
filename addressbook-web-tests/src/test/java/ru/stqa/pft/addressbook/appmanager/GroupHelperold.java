package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupDataold;

public class GroupHelperold extends HelperBaseold {

  public GroupHelperold(WebDriver wd) {
    super(wd);
  }

  public void submitGroupGreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupDataold groupData) {
    type(By.name("group_name"), groupData.name());

    type(By.name("group_header"), groupData.header());

    type(By.name("group_footer"), groupData.footer());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void returnToGroupPage() {
    click(By.linkText("groups"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroup() {
    click(By.name("selected[]"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }
}
