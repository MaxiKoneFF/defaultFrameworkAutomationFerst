package test.authorization;

import org.testng.annotations.Test;
import pages.authorization.AuthorizationPage;
import services.authorizationservice.AuthorizationService;
import services.mainpageservice.MainPageService;

public class Authorization {

  private final AuthorizationService authorizationService = new AuthorizationService();
  private final AuthorizationPage authorizationPage = new AuthorizationPage();
  private final MainPageService mainPageService = new MainPageService();

  @Test
  public void checkAuthorization() {
    String email = "konev.tonystark@gmail.com";
    String password = "94949697";

    authorizationService.openAutorizationPage();
    authorizationPage.setEmail(email);
    authorizationPage.setPassword(password);
    authorizationPage.getEnterButton().click();
    mainPageService.openBaseUrl();
  }
}