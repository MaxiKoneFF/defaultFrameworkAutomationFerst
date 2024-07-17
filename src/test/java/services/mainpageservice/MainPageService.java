package services.mainpageservice;

import base.BaseService;
import static com.codeborne.selenide.Selenide.open;

public class MainPageService extends BaseService {

    public void openBaseUrl() {open(baseUrl);
    }
}