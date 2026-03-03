package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {


  public SessionHelper(WebDriver wd) {
    super(wd);
  }
  public void login(String username, String password) {
    // Ввод логина
    type(By.name("user"),username);
    // ввод пароля
    type(By.name("pass"),password);
    //Клик
    click(By.xpath("//input[@value='Login']")); // Клик на кнопку "Login"
  }
}
