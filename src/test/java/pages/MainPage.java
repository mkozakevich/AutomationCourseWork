package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By SIGN_UP_NAV_BUTTON = By.id("signin2");
    private static final By USERNAME_INPUT = By.id("sign-username");
    private static final By PASSWORD_INPUT = By.id("sign-password");
    private static final By SIGN_UP_SUBMIT_BUTTON = By.cssSelector("button[onclick='register()']");

    public MainPage open() {
        driver.get("https://www.demoblaze.com/");
        return this;
    }

    public MainPage openSignUpModal() {
        driver.findElement(SIGN_UP_NAV_BUTTON).click();

        return this;
    }

    public MainPage signUp(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(SIGN_UP_SUBMIT_BUTTON).click();

        return this;
    }

    public String getConfirmMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        return alert.getText();
    }
}
