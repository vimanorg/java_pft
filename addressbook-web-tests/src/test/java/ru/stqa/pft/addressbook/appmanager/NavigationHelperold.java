package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;

public class NavigationHelperold extends HelperBaseold {


  public NavigationHelperold(WebDriver wd) {
    super(wd);
  }

  public void goToGrupePage(WebDriver wd) {
    wd.get("http://localhost:8080/addressbook/group.php");
  }
}

