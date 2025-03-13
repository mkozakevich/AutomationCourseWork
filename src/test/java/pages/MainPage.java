package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

@Log4j2
public class MainPage {
    private static final Logger log = LoggerFactory.getLogger(MainPage.class);
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By SIGN_UP_NAV_BUTTON = By.id("signin2");
    private static final By USERNAME_INPUT = By.id("sign-username");
    private static final By PASSWORD_INPUT = By.id("sign-password");
    private static final By SIGN_UP_SUBMIT_BUTTON = By.cssSelector("button[onclick='register()']");

    public MainPage open() {
        log.info("Open main page");

        driver.get("https://www.demoblaze.com/");
        return this;
    }

    public MainPage openSignUpModal() {
        log.info("Открытие модального окна регистрации");

        driver.findElement(SIGN_UP_NAV_BUTTON).click();

        return this;
    }

    public MainPage signUp(String username, String password) {
        log.info("Try to sign up with '{}' username & '{}' password", username, password);

        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(SIGN_UP_SUBMIT_BUTTON).click();

        return this;
    }

    public String getConfirmMessage() {
        log.info("Get message from alert");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        return alert.getText();
    }
}
