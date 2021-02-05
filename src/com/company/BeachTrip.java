package com.company;

public class BeachTrip extends Trip{

    private String nameofbeach;
    private double temperatur;

    public BeachTrip(String c, int n, String h, int d, boolean sb, String name, double temp){
        super(c, n, h, d, sb);
        nameofbeach = name;
        temperatur = temp;
    }

    public String getName(){
        return nameofbeach;
    }

    public double getTemp(){
        return temperatur;
    }

    public void setName(String newName){
        nameofbeach = newName;
    }

    public void setTemperatur(double newTemp){
        temperatur = newTemp;
    }

    public String toString(){
        return(super.toString() + "\nName of the beach: " + nameofbeach + "\nGeneral temperature: " + temperatur);
    }

    public String toStringFileFormat(){
        return (super.toStringFileFormat() + ";" + nameofbeach + ";" + temperatur + ";");
    }
}
