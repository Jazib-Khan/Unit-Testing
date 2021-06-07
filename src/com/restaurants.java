package com;

public class restaurants {
    public int id;
    public String name;
    public int DOHMH_inspection_score;
    public String neighborhood;
    public String photograph;
    public String address;
    public latlng latlng;
    public String cuisine_type;
    public operating_hours operating_hours;
    public reviews[] reviews;
    public double distance;

    public String getName() { return name;}

    public int getDOHMH_inspection_score() { return DOHMH_inspection_score;}

    public double getDistance() {
        return distance;
    }

}
