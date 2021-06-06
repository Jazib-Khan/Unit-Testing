package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class getScore {
    public static restaurants[] getScore(allRestaurants restArray, String neighInput) {
        restaurants[] newRest;
        ArrayList<restaurants> newRestList = new ArrayList<>();

        //Comparator<restaurants> byScore = Comparator.comparing()

        //Arrays.sort(restArray.restaurants, );

        for (int i = 0; i < restArray.restaurants.length; i++) {
            if (restArray.restaurants[i].neighborhood.matches(neighInput)) {
                newRestList.add(restArray.restaurants[i]);
            }
        }
        newRest = newRestList.toArray(new restaurants[newRestList.size()]);
        return newRest;

    }
}
