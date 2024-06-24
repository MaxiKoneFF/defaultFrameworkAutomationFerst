package test.authorization;

import org.testng.annotations.Test;
import pages.authorization.AuthorizationPage;
import pages.authorization.ConstructorPage;
import services.authorization.AuthorizationService;
import services.authorization.PageAftherAutarization;
import static com.codeborne.selenide.Condition.visible;

public class Authorization {

  private final AuthorizationService authorizationService = new AuthorizationService();
  private final AuthorizationPage authorizationPage = new AuthorizationPage();
  private final PageAftherAutarization pageAftherAutarization = new PageAftherAutarization();
  private final ConstructorPage constructorPage = new ConstructorPage();

  @Test
  public void checkAuthorization() {
    String email = "konev.tonystark@gmail.com";
    String password = "94949697";

    authorizationService.openAutorizationPage();
    authorizationPage.setEmail(email);
    authorizationPage.setPassword(password);
    authorizationPage.getEnterButton().click();
    pageAftherAutarization.openPageAftherAutarization();
    constructorPage.getAftherRegistrationButton().click();
  }
}