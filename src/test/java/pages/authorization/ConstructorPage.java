package pages.authorization;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.element;

public class ConstructorPage {
    private final By AFTHER_REGISTRATION_BUTTON = By.xpath("//button[contains(text(), 'Оформить заказ')]");
    public SelenideElement getAftherRegistrationButton() {
        return element(AFTHER_REGISTRATION_BUTTON);
    }
}