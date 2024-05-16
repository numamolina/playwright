import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Login {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://clockify.me/es/");
            page.navigate("https://app.clockify.me/en/login?abtesting=Mega%2520menu%2520changed%2520-%2520A");
            page.navigate("https://app.clockify.me/en/login");
            page.locator("[data-test-id='login-manual']").click();
            page.getByPlaceholder("Enter email").click();
            page.getByPlaceholder("Enter email").fill("numamolina19@gmail.com");
            page.getByPlaceholder("Enter password").click();
            page.getByPlaceholder("Enter password").fill("123455");
            page.locator("[data-test-id='login-button']").click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log In")).click();

        }
    }

}
