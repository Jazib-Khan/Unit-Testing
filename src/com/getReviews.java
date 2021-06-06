package com;

import java.util.ArrayList;

public class getReviews {
    public static restaurants[] getReviews(allRestaurants restArray, String neighInput, int reviewInput) {
        restaurants[] newRest;
        ArrayList<restaurants> newRestList = new ArrayList<>();

        for (int i = 0; i < restArray.restaurants.length; i++) {
            if (restArray.restaurants[i].neighborhood.matches(neighInput)) {
                double point = 0;
                double count = 0;
                for (int j = 0; j < restArray.restaurants.length; i++) {
                    double temp = restArray.restaurants[i].reviews[j].rating;

                    point += temp;
                    count ++;

                }
                double total = point / count;

                if (reviewInput <= total) {
                    newRestList.add(restArray.restaurants[i]);
                }
            }
        }
        newRest = newRestList.toArray(new restaurants[newRestList.size()]);
        return newRest;
    }
}
