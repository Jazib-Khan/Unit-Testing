package com;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class getTime {
    static public restaurants[] getTime(allRestaurants restArray, String dayInput, String timeInput){
        restaurants[] newRest;
        ArrayList<restaurants> newRestList = new ArrayList<>();

        String openTime;

        for (int i = 0; i < restArray.restaurants.length; i++) {

            switch(dayInput) {
                case "Monday":
                    if (!"Closed".equals(restArray.restaurants[i].operatingHours.Monday)) {
                        openTime = restArray.restaurants[i].operatingHours.Monday;
                        compareTime(openTime, restArray, newRestList, i, timeInput);
                    }
                    break;
                case "Tuesday":
                    if (!"Closed".equals(restArray.restaurants[i].operatingHours.Tuesday)) {
                        openTime = restArray.restaurants[i].operatingHours.Tuesday;
                        compareTime(openTime, restArray, newRestList, i, timeInput);
                    }
                    break;
                case "Wednesday":
                    if (!"Closed".equals(restArray.restaurants[i].operatingHours.Wednesday)) {
                        openTime = restArray.restaurants[i].operatingHours.Wednesday;
                        compareTime(openTime, restArray, newRestList, i, timeInput);
                    }
                    break;case "Thursday":
                    if (!"Closed".equals(restArray.restaurants[i].operatingHours.Thursday)) {
                        openTime = restArray.restaurants[i].operatingHours.Thursday;
                        compareTime(openTime, restArray, newRestList, i, timeInput);
                    }
                    break;case "Friday":
                    if (!"Closed".equals(restArray.restaurants[i].operatingHours.Friday)) {
                        openTime = restArray.restaurants[i].operatingHours.Friday;
                        compareTime(openTime, restArray, newRestList, i, timeInput);
                    }
                    break;case "Saturday":
                    if (!"Closed".equals(restArray.restaurants[i].operatingHours.Saturday)) {
                        openTime = restArray.restaurants[i].operatingHours.Saturday;
                        compareTime(openTime, restArray, newRestList, i, timeInput);
                    }
                    break;case "Sunday":
                    if (!"Closed".equals(restArray.restaurants[i].operatingHours.Sunday)) {
                        openTime = restArray.restaurants[i].operatingHours.Sunday;
                        compareTime(openTime, restArray, newRestList, i, timeInput);
                    }
                    break;
            }
        }
        newRest = newRestList.toArray(new restaurants[newRestList.size()]);
        return newRest;
    }
}
