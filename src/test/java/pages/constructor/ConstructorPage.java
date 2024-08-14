package pages.constructor;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ConstructorPage {
    private final By TOPPING_BUN = By.xpath("//p[contains(text(), 'Краторная булка N-200i')]");
    private final By SOURCE_ELEMENT = By.xpath("//*[contains(text(), 'Выберите булки')]");
    private final By ORDER = By.xpath("//button[contains(text(), 'Оформить заказ')]");
    private final By ORDER_FEED = By.xpath("//*[contains(text(), 'Лента заказов')]");
    private final By FIND_ORDER = By.xpath("//*[@class = 'order-details_title__FoYOr text text_type_digits-large mt-2 mb-4']");
    private final By FIND_ORDER_ON_FEED = By.xpath("//*[@class = text text_type_digits-default undefined");

    public SelenideElement toppingBun() {
        return element(TOPPING_BUN).shouldBe(visible.because("Элемент 'Краторная булка N-200i' не отображается на странице"));
    }

    public SelenideElement sourceElement() {
        return element(SOURCE_ELEMENT).shouldBe(visible.because("Элемент 'Выберите булки' не отображается на странице"));
    }

    public SelenideElement order() {
        return element(ORDER).shouldBe(visible.because("Элемент 'Оформить заказ' не отображается на странице"));
    }

    public SelenideElement orderFeed() {
        return element(ORDER_FEED).shouldBe(visible.because("Элемент 'Лента заказов' не отображается на странице"));
    }

    public SelenideElement findOrder() {
        SelenideElement orderElement = element(FIND_ORDER).find(FIND_ORDER_ON_FEED);
        if (!orderElement.isDisplayed()) {
            System.out.println("Не нашел заказ");
            return null;
        } else {
            System.out.println("Заказ найден");
        }
        return orderElement;
    }

    public void dragAndDropBun() {
        SelenideElement toppingBun = toppingBun();
        SelenideElement sourceElement = sourceElement();

        Actions actions = actions();
        actions.dragAndDrop(toppingBun, sourceElement).perform();
    }

    public void makeOrder() {
        order().shouldBe(visible.because("Кнопка 'Оформить заказ' не отображается на странице")).click();
        sleep(18000); //добавлено ожидание, так как заказ формируется долго.
        order().pressEscape();
    }

    public void clickOrderFeed() {
        orderFeed().shouldBe(visible.because("элемент 'Лента заказов' не отображается на странице")).click();
    }
}