package com.company;

public class SkiTrip extends Trip {

    private int hoursofski;
    private int numberofskiers;

    public SkiTrip(String c, int n, String h, int d, boolean sb, int hour, int num) {
        super(c, n, h, d, sb);
        hoursofski = hour;
        numberofskiers = num;
    }

    public int getHoursOfSki() {
        return hoursofski;
    }

    public int getNumberOfSkiers(){
        return numberofskiers;
    }

    public void setHoursOfSki(int newHour){
        hoursofski = newHour;
    }

    public void setNumberofskiers(int newNum){
        numberofskiers = newNum;
    }

    public String toString(){
        return(super.toString() + "\nHours of skiing: " + hoursofski + "\nNumber of skiers: " + numberofskiers);
    }

    public String toStringFileFormat(){
        return (super.toStringFileFormat() + ";" + hoursofski + ";" + numberofskiers + ";");
    }
}
