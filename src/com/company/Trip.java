package com.company;

public class Trip {

    String country;
    int numberpeople;
    String hotel;
    int duration;
    boolean skibeach;


public Trip(String c, int n, String h, int d, boolean sb){
    country = c;
    numberpeople = n;
    hotel = h;
    duration = d;
    skibeach = sb;
}

//public String getCountry(){
//     return country;
// }
//
// public int getNumberPeople(){
//     return numberpeople;
// }
//
// public String getHotel(){
//     return hotel;
// }
//
// public int getDuration(){
//     return duration;
// }
//
// public void setCountry(String newCountry){
//     country = newCountry;
// }
//
// public void setNumberPeople(int newNumberPeople){
//     numberpeople = newNumberPeople;
// }
//
// public void setHotel(String newHotel){
//     hotel = newHotel;
// }
//
// public void setDuration(int newDuration){
//     duration = newDuration;
// }
//
// public static void createTrip(){
//
// }

    public String toString() {
        return ("Country: " + country + "\nNumber of people: " + numberpeople +
                "\nName of hotel: " + hotel + "\nDuration of stay: " + duration + "\nSki/Beach" + skibeach);

    }

    public String toStringFileFormat(){
        return (country + ";" + numberpeople + ";" + hotel + ";" + duration + ";" + skibeach);

    }
}



