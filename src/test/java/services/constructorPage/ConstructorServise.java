package services.constructorPage;

import base.BaseService;

import static com.codeborne.selenide.Selenide.open;

public class ConstructorServise extends BaseService {
    public void openBaseUrl() {
        open(baseUrl);
    }
}