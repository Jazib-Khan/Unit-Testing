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


public class getHotelTest {

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
    public void testUnitHotel(){
        restaurants[] expectedObject = new restaurants[2];
        expectedObject[0] = localJsonObject.restaurants[9];
        expectedObject[1] = localJsonObject.restaurants[8];
        restaurants[] newRest = getHotel.getHotel(localJsonObject, "Queens");
        assertArrayEquals(expectedObject, newRest);
    }

    @Test
    public void testIntegrationHotel(){
        restaurants[] expectedObject = new restaurants[2];
        expectedObject[0] = jsonObject.restaurants[9];
        expectedObject[1] = jsonObject.restaurants[8];
        restaurants[] newRest = getHotel.getHotel(jsonObject, "Queens");
        assertArrayEquals(expectedObject, newRest);
    }

    @Test
    public void testNotSameUnitHotel(){
        restaurants[] expectedObject = new restaurants[2];
        expectedObject[0] = localJsonObject.restaurants[8];
    }

    @Test
    public void testNotSameIntegrationHotel(){
        restaurants[] expectedObject = new restaurants[2];
        expectedObject[0] = jsonObject.restaurants[8];
    }

    @Test
    public void testUnitIfNull() {
        restaurants[] newRest = getHotel.getHotel(localJsonObject, "Queenss");
        assertTrue(newRest.length == 0);
    }

    @Test
    public void testIntegrationIfNull() {
        restaurants[] newRest = getHotel.getHotel(jsonObject, "Queenss");
        assertTrue(newRest.length == 0);
    }

    @Test
    public void testUnitNotNull() {
        restaurants[] newRest = getHotel.getHotel(localJsonObject, "Queens");
        assertTrue(newRest.length > 0);
    }

    @Test
    public void testIntegrationNotNull() {
        restaurants[] newRest = getHotel.getHotel(jsonObject, "Queens");
        assertTrue(newRest.length > 0);
    }

    @Test
    public void testUnitDistance() {
        double testDouble = getHotel.calculateDistance(2, 40.752831, -73.985748, localJsonObject);
        assertTrue(testDouble > 0);
    }

    @Test
    public void testIntegrationDistance() {
        double testDouble = getHotel.calculateDistance(0, 40.752831, -73.985748, jsonObject);
        assertTrue(testDouble > 0);
    }


    @Test
    public void testUnitDistanceIfDouble(){
        Double testDouble = getHotel.calculateDistance(0,40.752831, -73.985748, localJsonObject);
        assertTrue(testDouble instanceof Double);

    }

    @Test
    public void testIntegrationDistanceIfDouble(){
        Double testDouble = getHotel.calculateDistance(0,40.752831, -73.985748, jsonObject);
        assertTrue(testDouble instanceof Double);
    }

}