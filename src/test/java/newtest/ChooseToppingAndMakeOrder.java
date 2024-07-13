package newtest;
import org.testng.annotations.Test;
public class ChooseToppingAndMakeOrder {
    private final IngredientsSelectionService ingredientsSelectionService = new IngredientsSelectionService();
    @Test
    public void selectionOfIngredients() {
        ingredientsSelectionService.openUrlBase();
        ingredientsSelectionService.getToppingButton();
        ingredientsSelectionService.getChooseBun();
        ingredientsSelectionService.getMakeOrder();
        ingredientsSelectionService.getOrderFeed();
    }
}