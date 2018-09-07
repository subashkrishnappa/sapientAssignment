package services;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;
import java.util.*;


public class BookTests {
	private static String ENDPOINT_PLACE_SEARCH = "/maps/api/place/findplacefromtext/json";

	@Test
	public void testGetByISBN() {
		RestAssured.baseURI = "https://maps.googleapis.com";
		//String isbn = "isbn:9781451648546";

		given().
				param("input", "Museum of Contemporary Art Australia").
				param("inputtype", "textquery").
				param("fields", "photos,formatted_address,name,rating,opening_hours,geometry").
				param("key","AIzaSyDO_i3VoeO38L6xA0Dab_owqqdgQUV-ch4").
		when().
				get(ENDPOINT_PLACE_SEARCH).
		then().
				assertThat().statusCode(HttpStatus.SC_OK).
				and().
				body("candidates[0].name",equalTo("Museum of Contemporary Art Australia"));
		}

	@Test
	public void removeUniqueCharacters(){
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter the string");
				String str = sc.nextLine();
				String finalString= new String();
				char temp;
				char[] chars = str.toCharArray();
				System.out.println("Entered String is:"+ str);
				for(int i=0;i<str.length();i++){
					temp = chars[i];
					int firstIndex = str.indexOf(temp);
					int lastIndex = str.lastIndexOf(temp);
					if(firstIndex!=lastIndex){
						finalString+= temp;
					}
				}
				System.out.println("Final String is: "+finalString);
			}
		}

