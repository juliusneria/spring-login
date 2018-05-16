package com.sample.login;

import com.sample.login.model.User;
import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleloginApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void addAdmin() {
		Response response = givenAuth("test@test.com", "test").contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
				.body(new User("test1@test.com", "test1", "lastname", "password", true, false))
				.post("/createAdmin");
		assertEquals(200, response.getStatusCode());
	}

	private RequestSpecification givenAuth(String username, String password) {
		FormAuthConfig formAuthConfig =
				new FormAuthConfig("/login", username, password);

		return RestAssured.given().auth().form(username, password, formAuthConfig);
	}

}
