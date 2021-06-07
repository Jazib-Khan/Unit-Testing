package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class getHotel {
    public static restaurants[] getHotel(allRestaurants restArray, String neighInput){
        restaurants[] newRest;
        ArrayList<restaurants> newRestList = new ArrayList<>();

        double dif = 0;
        double lat = 0;
        double lng = 0;

        for (int i = 0; i < restArray.restaurants.length; i++) {
            switch (neighInput){
                case "Manhattan":
                    dif = calculateDistance(i, 40.752831, -73.985748, restArray);
                    break;
                case "Brooklyn":
                    dif = calculateDistance(i, 40.753990, -73.949240, restArray);
                    break;
                case "Queens":
                    dif = calculateDistance(i, 40.689510, -73.988100, restArray);
                    break;
            }
            restArray.restaurants[i].distance = dif;

            if (restArray.restaurants[i].neighborhood.equals(neighInput)) {
                newRestList.add(restArray.restaurants[i]);
            }
        }
        newRest = newRestList.toArray(new restaurants[newRestList.size()]);

        Comparator<restaurants> byDis = Comparator.comparing(restaurants::getDistance);
        Arrays.sort(newRest, byDis);

        return newRest;

    }

    public static double calculateDistance(int i, double lat, double lng, allRestaurants restArray) {
        double totalLat;
        double totalLng;
        double total = 0;

        double restLat = restArray.restaurants[i].latlng.lat;
        double restLng = restArray.restaurants[i].latlng.lng;

        if (restLat < lat) {
            totalLat = lat - restLat;
        } else {
            totalLat = restLat - lat;
        }
        if (restLng < lng) {
            totalLng = lng - restLng;
        } else {
            totalLng = restLng - lng;
        }

        total = totalLat + totalLng;
        return total;
    }

}
