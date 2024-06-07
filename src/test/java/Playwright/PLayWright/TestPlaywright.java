package Playwright.PLayWright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class TestPlaywright {
	
  public static void main(String[] args) throws InterruptedException {
	  
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      
      page.navigate("https://demo.nopcommerce.com/");
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Register")).click();
      page.getByLabel("Male", new Page.GetByLabelOptions().setExact(true)).check();
      page.getByLabel("First name:").click();
      page.getByLabel("First name:").fill("Reduan");
      page.getByLabel("Last name:").click();
      page.getByLabel("Last name:").fill("Raju");
      page.locator("select[name=\"DateOfBirthDay\"]").selectOption("1");
      page.locator("select[name=\"DateOfBirthMonth\"]").selectOption("1");
      page.locator("select[name=\"DateOfBirthYear\"]").selectOption("1971");
      page.getByLabel("Email:").click();
      page.getByLabel("Email:").fill("abcdfi@gmail.com");
      page.getByLabel("Company name:").click();
      page.getByLabel("Company name:").fill("nocompany");
      page.getByLabel("Password:", new Page.GetByLabelOptions().setExact(true)).click();
      page.getByLabel("Password:", new Page.GetByLabelOptions().setExact(true)).fill("abcdfi@gmail.com");
      page.getByLabel("Confirm password:").click();
      page.getByLabel("Confirm password:").fill("abcdfi@gmail.com");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Register")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Continue")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Log in")).click();
      page.getByLabel("Email:").click();
      page.getByLabel("Email:").fill("abcdfi@gmail.com");
      page.getByLabel("Password:").click();
      page.getByLabel("Password:").fill("abcdfi@gmail.com");
      page.getByLabel("Remember me?").check();
      
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click();
      
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Electronics")).nth(1).click();
      page.wait(5);
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Computers")).click();
      
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Apparel")).nth(1).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Digital downloads")).nth(1).click();
      page.locator(".list > li:nth-child(5)").first().click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Jewelry")).nth(1).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Gift Cards")).nth(1).click();

      page.wait(5);
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Log out")).click();
      page.close();
    }
  }
}
  

      

