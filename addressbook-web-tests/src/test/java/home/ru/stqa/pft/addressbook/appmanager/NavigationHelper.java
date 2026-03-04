package home.ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;

public class NavigationHelper {
   private WebDriver wd;

    public NavigationHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void goToGroupPage() {

            wd.get("http://localhost/addressbook/group.php");
    }
}
