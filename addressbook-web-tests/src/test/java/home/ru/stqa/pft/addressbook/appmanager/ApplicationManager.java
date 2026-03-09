package home.ru.stqa.pft.addressbook.appmanager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class ApplicationManager {
    WebDriver wd;

    private SessionHelper sessionHelper;
    private  NavigationHelper navigationHelper;
    private  GroupHelper groupHelper;

    public void init() {
        Browser BrowserType = null;
        Browser browser = BrowserType.FIREFOX;
        if (browser == BrowserType.FIREFOX) {wd = new FirefoxDriver();
        }
        else if (browser ==BrowserType.CHROME) { wd = new ChromeDriver();
        }
        else if (browser == BrowserType.IE) {wd = new internetExplorerDriver();
        }
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wd.get("http://localhost/addressbook/group.php");
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
    }


    public void stop() {
        wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
