package com;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class getCuisine {
    static public restaurants[] getCuisine(allRestaurants restArray, String cuisineInput, String neighInput) {
        restaurants[] newRest;
        ArrayList<restaurants> newRestList = new ArrayList<>();

        for (int i = 0; i < restArray.restaurants.length; i++) {
            if (restArray.restaurants[i].cuisinType.matches(cuisineInput)) {
                if (restArray.restaurants[i].neighborhood.matches(neighInput)) {
                    newRestList.add(restArray.restaurants[i]);
                }
            }
        }
        newRest = newRestList.toArray(new restaurants[newRestList.size()]);
        return newRest;

    }

}
