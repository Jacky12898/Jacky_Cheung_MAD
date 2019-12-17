package com.example.cheungfinal;

public class Burrito {
    public String location;

    public String suggestLocation(String area) {
        switch (area) {
            case "The Hill":
                location = "Illegal Petes";
                break;
            case "29th Street":
                location = "Chipotle";
                break;
            case "Pearl Street":
                location = "Bartaco";
            default:
                break;
        }

        return location;
    }
}
