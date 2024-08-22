package api.myApiTests.Pojo.test;

import api.Pojo.specifications.Specifications;
import api.myApiTests.Pojo.Get.GetResponse;
import api.myApiTests.Pojo.Post.PostResponse;
import java.util.List;
import java.util.stream.Collectors;
import api.myApiTests.Pojo.Post.UnSuccessLogin;
import api.myApiTests.Pojo.Put.PutResponse;
import api.myApiTests.Pojo.Put.PutResponseUpdate;
import api.myApiTests.specification.Specification;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.time.Clock;

import static io.restassured.RestAssured.given;

public class myReqrestTest {
    private final String baseURL = "https://reqres.in";
    private String id;

    @Test
    @DisplayName("проверка Get запроса")

    public void checkAvatarAndIdAndFirstName() {
        Specification.instalSpecification(Specification.requestSpec(baseURL),
                Specification.responseSpec200());

        List<GetResponse> user = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/users?page=2")
                .prettyPeek()
                .then().log().all()
                .extract().body().jsonPath().getList("data", GetResponse.class);

        Assert.assertTrue(user.stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")),
                "Не у всех пользователей адреса электронной почты заканчиваются на '@reqres.in'");
        Assert.assertEquals(user.get(3).getFirst_name(), "Byron", "first_name not 'Byron'");
        Assert.assertEquals(user.get(1).getFirst_name(), "Lindsay", "first_name not 'Lindsay'");

        List<String> avatars = user.stream().map(GetResponse::getAvatar).collect(Collectors.toList());
        List<String> ids = user.stream().map(x -> x.getId().toString()).collect(Collectors.toList());
        List<String> emails = user.stream().map(GetResponse::getEmail).collect(Collectors.toList());

        for (int i = 0; i < avatars.size(); i++) {
            Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
        }
        for (int j = 0; j < emails.size(); j++) {
            Assert.assertTrue(emails.get(j).endsWith("@reqres.in"));
        }
    }

    @Test
    @DisplayName("проверка Post запроса")

    public void checkId() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body("{\"name\": \"Max\", \"job\": \"QA-engineer\"}")
                .post(baseURL + "/api/users")
                .then().log().all()
                .extract()
                .response();

        Assert.assertEquals(201, response.getStatusCode());
        PostResponse user = response.as(PostResponse.class);
        Assert.assertNotNull(user.getId());

        System.out.println("User ID: " + user.getId());
    }

    @Test
    @DisplayName("проверка Post запроса")

    public void checkUnSuccessLogin() {
        UnSuccessLogin unSuccessLogin = (UnSuccessLogin) given()
                .contentType(ContentType.JSON)
                .when()
                .body("{ \"email\": \"peter@klaven\"}")
                .post(baseURL + "/api/login")
                .then().log().all()
                .extract()
                .response();

        Assert.assertEquals(400, unSuccessLogin.getStatusCode());
        Assert.assertEquals("Missing password", unSuccessLogin.getError());
    }

    @Test
    @DisplayName("проверка по id")

    public void checkGetRequestOnId() {
        JsonPath user = given()
                .contentType(ContentType.JSON)
                .when()
                .get(baseURL + "/api/users/" + id)
                .prettyPeek()
                .body()
                .jsonPath();

        Assert.assertEquals(user.get("data.id"), id);
    }

    @Test
    @DisplayName("проверка Put запроса")

    public void changeDateTest() {
        Specification.instalSpecification(Specification.requestSpec(baseURL),
                Specification.responseSpec200());
        PutResponse user = new PutResponse("morpheus", "zion resident");

        PutResponseUpdate response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(user)
                .put("/api/users/2")
                .prettyPeek()
                .then().log().all()
                .extract().as(PutResponseUpdate.class);

        String regex = "(.{20})$";
        String regex2 = "(.{14})$";
        String currentTime = Clock.systemUTC().toString().replaceAll(regex, "");
        Assert.assertEquals(currentTime, response.getUpdatedAt().replaceAll(regex2, ""));
    }

    @Test
    @DisplayName("проверка delete запроса")

    public void deleteTest() {
        Specifications.instalSpecification(Specifications.requestSpec(baseURL),
                Specifications.responseUnique(204));
        given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .delete("/api/users/2")
                .then()
                .log().all()
                .extract().response().statusCode();
    }
}