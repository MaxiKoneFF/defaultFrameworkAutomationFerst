package newtest;
import static com.codeborne.selenide.Selenide.open;
public class ChooseToppingAndMakeOrderService {
    public void openUrlBase() {
        String baseUrl = "https://burger-frontend-6.prakticum-team.ru";
        open(baseUrl);
    }
}