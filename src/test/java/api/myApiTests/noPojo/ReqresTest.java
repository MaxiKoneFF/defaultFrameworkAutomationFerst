package api.myApiTests.noPojo;

import api.myApiTests.specification.Specification;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

public class ReqresTest {
    private static String URL = "https://reqres.in";

    @Test
    public void checkGetResponse() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(URL + "/api/users?page=2")
                .then().log().all()
                .body("page", equalTo(2))
                .body("data.id", notNullValue())
                .body("data.email", notNullValue())
                .body("data.first_name", notNullValue())
                .body("data.last_name", notNullValue())
                .body("data.avatar", notNullValue())
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        List<Integer> ids = jsonPath.get("data.id");
        List<String > emails = jsonPath.get("data.email");
        List<String > avatars = jsonPath.get("data.avatar");

        for (int i = 0; i < ids.size(); i++){
            Assert.assertTrue(avatars.get(i).contains(ids.get(i).toString()));
        }
        Assert.assertTrue(emails.stream().allMatch(x->x.endsWith("@reqres.in")));
    }

    @Test
    public void checkSuccessPostResponse() {
        Specification.instalSpecification(Specification.requestSpec(URL),
                Specification.responseSpec201());
        Map<String, String> user = new HashMap<>();
        user.put("name", "morpheus");
        user.put("job", "leader");
        Response response = given()
                .body(user)
                .when()
                .post(URL + "/api/users/2")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String job = jsonPath.get("job");
        String name = jsonPath.get("name");

        Assert.assertEquals(201, response.statusCode());
        Assert.assertEquals("morpheus", name);
        Assert.assertEquals("leader", job);
    }
    @Test
    public void checkUnSuccessPostResponse() {
        Specification.instalSpecification(Specification.requestSpec(URL),
                Specification.responseError400());
        Map<String, String> user = new HashMap<>();
        user.put("email", "sydney@fife");
        Response response = given()
                .body(user)
                .when()
                .post(URL + "/api/register")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String error = jsonPath.get("error");
        Assert.assertEquals("Missing password", error);
    }

    @Test
    public void testGetResponse(){
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/unknown")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String name = jsonPath.getString("data[0].name");
        assertThat(name, is("cerulean"));
    }
}