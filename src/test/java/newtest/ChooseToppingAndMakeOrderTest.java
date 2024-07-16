package newtest;
import org.testng.annotations.Test;
public class ChooseToppingAndMakeOrderTest {
    private final ChooseToppingAndMakeOrderService chooseToppingAndMakeOrderService = new ChooseToppingAndMakeOrderService();
    private final ChooseToppingAndMakeOrderPage chooseToppingAndMakeOrderPage = new ChooseToppingAndMakeOrderPage();
    @Test
    public void selectionOfIngredients() {
        chooseToppingAndMakeOrderService.openUrlBase();
        chooseToppingAndMakeOrderPage.getToppingButton();
        chooseToppingAndMakeOrderPage.getChooseBun();
        chooseToppingAndMakeOrderPage.getMakeOrder();
        chooseToppingAndMakeOrderPage.getOrderFeed();
    }
}