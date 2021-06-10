package com;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class getCuisineTest {

    private static allRestaurants jsonObject;
    private static allRestaurants localJsonObject;

    @BeforeClass
    public static void setUpAPI(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonObject = mapper.readValue(new URL("http://intelligent-social-robots-ws.com/restaurant-data.json"), allRestaurants.class);
            localJsonObject = mapper.readValue(new File("./src/Data/restaurant-data.json"), allRestaurants.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testUnitCuisine(){
        restaurants[] expectedObject = new restaurants[1];
        expectedObject[0] = localJsonObject.restaurants[9];
        restaurants[] newRest = getCuisine.getCuisine(localJsonObject, "Mexican", "Queens");
        assertArrayEquals(expectedObject, newRest);
    }

    @Test
    public void testIntegrationCuisine() {
        restaurants[] expectedObject = new restaurants[1];
        expectedObject[0] = jsonObject.restaurants[9];
        restaurants[] newRest = getCuisine.getCuisine(jsonObject, "Mexican", "Queens");
        assertArrayEquals(expectedObject, newRest);
    }

    @Test
    public void testNotSameUnitCuisine(){
        restaurants[] expectedObject = new restaurants[1];
        expectedObject[0] = localJsonObject.restaurants[8];
        restaurants[] newRest = getCuisine.getCuisine(localJsonObject, "Mexican", "Queens");
        assertNotSame(expectedObject, newRest);
    }

    @Test
    public void testNotSameIntegrationCuisine() {
        restaurants[] expectedObject = new restaurants[1];
        expectedObject[0] = jsonObject.restaurants[8];
        restaurants[] newRest = getCuisine.getCuisine(jsonObject, "Mexican", "Queens");
        assertNotSame(expectedObject, newRest);
    }

    @Test
    public void testUnitIfNull(){
        restaurants[] newRest = getCuisine.getCuisine(localJsonObject, "Mexicana", "Queens");
        assertTrue(newRest.length == 0);
    }

    @Test
    public void testIntegrationIfNull(){
        restaurants[] newRest = getCuisine.getCuisine(jsonObject, "Mexicana", "Queens");
        assertTrue(newRest.length == 0);
    }

    @Test
    public void testUnitNotNull(){
        restaurants[] newRest = getCuisine.getCuisine(localJsonObject, "Mexican", "Queens");
        assertTrue(newRest.length > 0);
    }

    @Test
    public void testIntegrationNotNull(){
        restaurants[] newRest = getCuisine.getCuisine(jsonObject, "Mexican", "Queens");

        assertTrue(newRest.length > 0);
    }
}