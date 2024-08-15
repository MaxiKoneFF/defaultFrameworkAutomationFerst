package pages.authorization;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.element;

public class AuthorizationPage {
    private final By EMAIL = By.xpath("//input[@name='email']");
    private final By PASSWORD = By.xpath("//input[@name='password']");
    private final By ENTER_BUTTON = By.xpath("//button[contains(text(), 'Войти')]");

    public SelenideElement inputEmail() {
        return element(EMAIL);
    }

    public SelenideElement inputPassword() {
        return element(PASSWORD);
    }

    public SelenideElement enterButton() {
        return element(ENTER_BUTTON);
    }

    public void enterEmail(String email) {
        inputEmail().setValue(email);
    }

    public void enterPassword(String password) {
        inputPassword().setValue(password);
    }

    public void clickEnterButton() {
        enterButton().shouldBe(visible.because("кнопка 'Лента заказов' не отображается на странице")).click();
    }
}