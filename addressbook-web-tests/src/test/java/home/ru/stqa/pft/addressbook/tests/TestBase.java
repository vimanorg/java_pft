package home.ru.stqa.pft.addressbook.tests;

import home.ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import home.ru.stqa.pft.addressbook.appmanager.BrowserType;

public class TestBase {

    protected final  ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
      app.stop();

    }

}
