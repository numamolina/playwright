import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.util.Random;
import java.util.regex.Pattern;

public class CreandoNewProject {

    public static String generarProjectName() {
        // Generar dos números enteros aleatorios
        Random random = new Random();
        int num1 = random.nextInt(10); // Números entre 0 y 9
        int num2 = random.nextInt(10);

        // Generar el nombre del proyecto
        String projectName = "nuevoProyecto" + num1 + num2;
        return projectName;
    }

    public static void main(String[] args) {
        String projectName = generarProjectName(); // Aquí llamas a la función para obtener el nombre del proyecto

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
            page.locator("a").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Project$"))).click();
            page.locator("a").filter(new Locator.FilterOptions().setHasText("Create new project")).click();
            page.getByPlaceholder("Enter project name").click();
            page.getByPlaceholder("Enter project name").fill(projectName);
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create")).click();

        }
    }
}
