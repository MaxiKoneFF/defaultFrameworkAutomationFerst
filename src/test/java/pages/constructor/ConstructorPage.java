package pages.constructor;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.element;

public class ConstructorPage {

    private final By TOPPING_BUTTON = By.xpath("//button[contains(text(), 'Булки')]");
    private final By CHOOSE_TOPPING_BUN = By.xpath("//button[contains(text(), 'Краторная булка N-200i')]");
    private final By MAKE_ORDER = By.xpath("//button[contains(text(), 'Оформить заказ')]");
    private final By SWITCHIN_ORDER_FEED = By.xpath("//button[contains(text(), 'Лента заказов')]");

    public SelenideElement getToppingButton() {return element(TOPPING_BUTTON);}
    public SelenideElement getChooseBun() {return element(CHOOSE_TOPPING_BUN);}
    public SelenideElement getMakeOrder() {return element(MAKE_ORDER);}
    public SelenideElement getOrderFeed() {return element(SWITCHIN_ORDER_FEED);}
}