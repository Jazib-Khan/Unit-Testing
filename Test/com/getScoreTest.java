package com;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class getScoreTest {
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
    public void testNotSameUnitScore(){
        restaurants[] expectedObject = new restaurants[1];
        expectedObject[0] = localJsonObject.restaurants[8];
        restaurants[] newRest = getScore.getScore(localJsonObject, "Mexican");
        assertNotSame(expectedObject, newRest);
    }

    @Test
    public void testNotSameIntegrationScore() {
        restaurants[] expectedObject = new restaurants[1];
        expectedObject[0] = jsonObject.restaurants[8];
        restaurants[] newRest = getScore.getScore(jsonObject, "Mexican");
        assertNotSame(expectedObject, newRest);
    }

    @Test
    public void testUnitIfNull(){
        restaurants[] newRest = getScore.getScore(localJsonObject, "Mexicana");
        assertTrue(newRest.length == 0);
    }

    @Test
    public void testIntegrationIfNull (){
        restaurants[] newRest = getScore.getScore(jsonObject, "Mexicana");
        assertTrue(newRest.length == 0);
    }

}