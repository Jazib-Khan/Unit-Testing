package com;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args){
        ObjectMapper mapper = new ObjectMapper();
        try {
            allRestaurants restaurant = mapper.readValue(new URL("http://intelligent-social-robots-ws.com/restaurant-data.json"), allRestaurants.class);
            //getCuisine.getCuisine(restaurant, "Mexican", "Queens");
            //getHotel.getHotel(restaurant, "Manhattan");
            //getReviews.getReviews(restaurant, "Mexican", 4);
            getScore.getScore(restaurant, "Queens");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
