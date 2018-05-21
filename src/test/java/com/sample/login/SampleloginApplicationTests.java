package com.sample.login;

import com.sample.login.model.User;
import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.filter.session.SessionFilter;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleloginApplicationTests {

	private FormAuthConfig formConfig;
	@Before
	public void setup() {
		RestAssured.port = 8080;

		final String URL_PREFIX = "http://localhost:8080";
		formConfig = new FormAuthConfig(URL_PREFIX + "/login", "test@test.com", "test");
		/*RestAssured.baseURI = "http://localhost:8080/";
		RestAssured.useRelaxedHTTPSValidation();
		SessionFilter sessionFilter = new SessionFilter();
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.given()
				.log().all()
				.filter(sessionFilter)
				.formParam("username", "test@test.com")
				.formParam("password", "test")
				.when()
				.post("/login")
				.then()
				.statusCode(302);*/
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void addAdmin() {
		final RequestSpecification request = RestAssured.given().auth().form("test@test.com", "test", formConfig);
		final Response response = request
				.given()
				.body(new User("test1@test.com", "test1", "lastname", "password", true, false))
				.when().post("http://localhost:8080/createAdmin");
		assertEquals(200, response.getStatusCode());
//		assertTrue(response.body().asString().contains("Password updated successfully"));
		/*ValidatableResponse response = RestAssured.given().body(new User("test1@test.com", "test1", "lastname", "password", true, false)).when().post("/createAdmin")
				.then().assertThat().statusCode(200);
		assertEquals(302, response);*/
	}

	/*private RequestSpecification givenAuth(String username, String password) {

		*//*RestAssured.given()
				.log().all()
				.filter(sessionFilter)
				.get("/pdb/user")
				.then()
				.body();*//*
		return RestAssured.given().log().all().filter(sessionFilter);
	}*/

	/*private RequestSpecification givenAuth(String username, String password) {
		FormAuthConfig formAuthConfig =
				new FormAuthConfig("/login", username, password);

		return RestAssured.given().auth().form(username, password, formAuthConfig);
	}*/

}
