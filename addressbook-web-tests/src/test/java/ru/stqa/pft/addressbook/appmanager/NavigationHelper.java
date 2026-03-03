package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;

public class NavigationHelper {
  private WebDriver wd; // Экземпляр веб-драйвера для управления браузером

  public NavigationHelper(WebDriver wd) {
    this.wd =wd;
  }

  public void goToGrupePage(WebDriver wd) {
    this.wd.get("http://localhost:8080/addressbook/group.php");
  }
}
