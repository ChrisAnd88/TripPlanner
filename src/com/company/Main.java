package com.company;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Trip> trip = loadTrips();
        Scanner console = new Scanner(System.in);
        System.out.println();
        menu(console, trip);

    }

    public static void menu(Scanner console, ArrayList<Trip> trip) throws FileNotFoundException {

        System.out.println("*****Welcome to TripPlanner!*****");
        System.out.println();
        System.out.println("    Press 1 to create a trip");
        System.out.println("     Press 2 to list a trip");
        System.out.println("   Press 3 to exit the program");
        System.out.println();
        int answer = console.nextInt();
        System.out.println();

        switch (answer) {
            case 1:
                System.out.println("You have chosen to create a new trip!");
                createTrip(console, trip);


                break;
            case 2:
                System.out.println("You have chosen to get a list of the trips:");
                readFromFile(console, trip);
                System.out.println("Returning to menu");
                menu(console, trip);

                break;
            case 3:
                System.out.println("You have chosen to exit the program. Goodbye!");
                break;
            default:
                System.out.println("Please press 1, 2 or 3.");
        }

    }

    public static void createTrip(Scanner console, ArrayList<Trip> trip) throws FileNotFoundException {
        console.nextLine();
        System.out.println("Please enter the country you're visiting: ");

        String country = console.nextLine();
        System.out.println("Please enter how many people that will be travelling: ");
        int amount = console.nextInt();
        System.out.println("Please enter the name of the hotel you'll be staying at: ");
        console.next();
        String hotelname = console.nextLine();
        System.out.println("Please enter the duration of the stay (in days): ");
        int time = console.nextInt();
        System.out.println("Are you going skiing or visiting the beach? Type 'true' for skiing and 'false' for beach: ");
        boolean choice = console.nextBoolean();

        if (choice == true) {
            System.out.println("How many hours will you be skiing? ");
            int hours = console.nextInt();
            System.out.println("How many will be skiing? ");
            int number = console.nextInt();
            SkiTrip skiTrip = new SkiTrip(country, amount, hotelname, time, choice, hours, number);
            trip.add(skiTrip);
        } else if (choice == false) {
            System.out.println("Please enter the name of the beach: ");
            console.next();
            String beach = console.nextLine();
            System.out.println("What is the general temperature (in celsius)there? ");
            double degrees = console.nextDouble();
            BeachTrip beachTrip = new BeachTrip(country, amount, hotelname, time, choice, beach, degrees);
            trip.add(beachTrip);
        }
        writeToFile(console, trip);
        System.out.println("Going back to menu");
        menu(console, trip);



    }

    public static void writeToFile(Scanner console, ArrayList<Trip> trip) throws FileNotFoundException {
        PrintStream write = new PrintStream(new File("tripplanner.txt"));
        for (int i = 0; i < trip.size(); i++) {
            write.print(trip.get(i).toStringFileFormat());

        }
        write.close();
    }

    public static void readFromFile(Scanner console, ArrayList<Trip> trip) throws FileNotFoundException{

        /*for (int i = 0; i < trip.size(); i++) {
            System.out.println(trip.get(i).toString());
        }
        return trip.toString(); */
        try {
            File file = new File("tripplanner.txt");
            Scanner read = new Scanner(file);

            while (read.hasNextLine())
                System.out.println(read.nextLine());

        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public static ArrayList<Trip> loadTrips() throws FileNotFoundException{
        Scanner load = new Scanner(new File("tripplanner.txt"));
        load.useDelimiter(";");
        ArrayList<Trip> trip = new ArrayList<>();
        while (load.hasNextLine()) {
            String country = load.next();
            int amount = Integer.parseInt(load.next());
            String bnb = load.next();
            int days = Integer.parseInt(load.next());
            boolean valg = load.nextBoolean();
            if (valg == true) {
                System.out.println("How many hours will you be skiing? ");
                int time = Integer.parseInt(load.next());
                System.out.println("How many will be skiing? ");
                int number = Integer.parseInt(load.next());
                SkiTrip skiTrip = new SkiTrip(country, amount, bnb, days, valg, time, number);
                load.nextLine();
                trip.add(skiTrip);

            } else if (valg == false) {
                System.out.println("Please enter the name of the beach: ");
                String strand = load.next();
                System.out.println("What is the general temperature (in celsius)there? ");
                double grader = load.nextDouble();
                BeachTrip beachTrip = new BeachTrip(country, amount, bnb, days, valg, strand, grader);
                load.nextLine();
                trip.add(beachTrip);

            }
        }
        return trip;

    }

}

