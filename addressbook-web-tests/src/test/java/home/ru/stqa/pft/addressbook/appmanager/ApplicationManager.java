package home.ru.stqa.pft.addressbook.appmanager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.time.Duration;

public class ApplicationManager {

    WebDriver wd;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private BrowserType browser; // тип изменён с String на BrowserType

    public ApplicationManager(BrowserType browser) { // конструктор теперь принимает BrowserType
        this.browser = browser;
    }

    public void init() {
        if (browser == BrowserType.FIREFOX) {
            wd = new FirefoxDriver();
        } else if (browser == BrowserType.CHROME) {
            wd = new ChromeDriver();
        } else if (browser == BrowserType.IE) {
            wd = new InternetExplorerDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

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