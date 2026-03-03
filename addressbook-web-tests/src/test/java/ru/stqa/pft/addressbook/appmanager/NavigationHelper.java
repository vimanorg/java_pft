package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {


  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void goToGrupePage(WebDriver wd) {
    wd.get("http://localhost:8080/addressbook/group.php");
  }
}

