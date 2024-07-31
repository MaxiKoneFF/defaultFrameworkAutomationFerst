package pages.authorization;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.element;
import static java.lang.Thread.sleep;

public class AuthorizationPage {

    private final By EMAIL = By.xpath("//input[@name='email']");
    private final By PASSWORD = By.xpath("//input[@name='password']");
    private final By ENTER_BUTTON = By.xpath("//button[contains(text(), 'Войти')]");
    private final By LINK_REGISTER = By.xpath("//a[contains(text(), 'Зарегистрироваться')]");
    private final By LINK_FORGOT_PASSWORD = By.xpath("//a[contains(text(), 'Восстановить пароль')]");

    public SelenideElement inputEmail() {
        return element(EMAIL);
    }
    public void enterEmail(String email) {
        inputEmail().setValue(email);
    }
    public SelenideElement inputPassword() {
        return element(PASSWORD);
    }
    public void enterPassword(String password) {
        inputPassword().setValue(password);
    }
    public SelenideElement enterButton() {
        return element(ENTER_BUTTON);
    }

    public void clickEnterButton() {
        enterButton().click();
        try {
            sleep(2000);
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }
    public SelenideElement getLinkRegister() {
        return element(LINK_REGISTER);
    }
    public SelenideElement getLinkForgotPassword() {
        return element(LINK_FORGOT_PASSWORD);
    }
}