package pages.account;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.element;

public class AccountPage {
    private final By ACCOUNT_BUTTON = By.xpath("//*[@class = 'app-header_link__2y8TU app-header_link_position_last__3skWP']");
    private final By EXIT_BUTTON = By.xpath("//button[contains(text(), 'Выход')]");

    public SelenideElement personalAccount() {
        return element(ACCOUNT_BUTTON);
    }
    public void comeToPersonalAccount(){
        personalAccount().click();
    }
    public SelenideElement exitFromAccount(){
        return element(EXIT_BUTTON);
    }
    public void pressExitButton(){
        exitFromAccount().click();
    }
}