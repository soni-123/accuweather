package RestAPI;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;
public class GetCurrentWeather {
	float temp;
	@Test
	public void getCurrentWeather() {
		    given()
				.queryParam("q", "Patna")
				.queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea").  					
			when()
		    	.get("https://api.openweathermap.org/data/2.5/weather").
		    then().log().body();
		
	/* temp=given()
			.queryParam("q", "Patna")
			.queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea").  					
		when()
	    	.get("https://api.openweathermap.org/data/2.5/weather").    	
	    then()
	    	.extract().path("main.temp");
			System.out.println("Temprature "+temp);*/
	}
	
	
}
