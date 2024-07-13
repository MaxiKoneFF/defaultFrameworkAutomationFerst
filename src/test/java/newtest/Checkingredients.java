package newtest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
class Checkingredients {
    @Test
    public static void main(String[] args) {
        // Указываем путь к драйверу для браузера Chrome
        System.setProperty("web-driver.chrome.driver", "C:\\Users\\konev\\OneDrive\\Рабочий стол\\ForTest\\chrome-for-testing-main");

        // Создаем экземпляр веб-драйвера для браузера Chrome
        WebDriver driver = new ChromeDriver();

        // Открываем сайт, на котором нужно оформить заказ
        driver.get("\"https://burger-frontend-6.prakticum-team.ru\"");

        // Используем метод findElement для нахождения элементов на странице и взаимодействия с ними
        WebElement bun = driver.findElement(By.id("Начинки"));
        bun.sendKeys("Хрустящие минеральные кольца");

        // Завершаем процесс оформления заказа
        WebElement placeOrderButton = driver.findElement(By.id("Оформить заказ"));
        placeOrderButton.click();

        // Переходим на страницу сформированных заказов
        WebElement orderFeedButton = driver.findElement(By.id("Лента заказов"));
        orderFeedButton.click();

        // Закрываем браузер
        driver.quit();
    }
}