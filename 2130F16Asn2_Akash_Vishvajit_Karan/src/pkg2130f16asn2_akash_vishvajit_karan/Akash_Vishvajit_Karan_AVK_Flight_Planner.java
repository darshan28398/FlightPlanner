/*COMP 2130 CRN :- 10454
 *Assignment 2
 * Group Member 1:- Akash Chamaria Student ID:- 101024951
 * Group Member 2:- Vishvajit Kher Student ID:- 101015270
 * Group Member 3:- Karan Amul Acharya Student ID:- 101026087
 Submitted to Anjana Shah
*/
/*
package pkg2130f16asn2_akash_vishvajit_karan;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EmptyStackException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Akash_Vishvajit_Karan_AVK_Flight_Planner {

    public static Scanner input = new Scanner(System.in); //Scanner to take input from the user
    public static Akash_Vishvajit_Karan_FinalBooking finalBooking = new Akash_Vishvajit_Karan_FinalBooking(); //Object which contain final booking details

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_CYANBG = "\u001B[46m";
    public static final String ANSI_REDBG = "\u001B[41m";
    public static final String ANSI_BLUEBG = "\u001B[44m";
    public static final String ANSI_MAGNETABG = "\u001B[45m";
    public static final String ANSI_GREENBG = "\u001B[42m";
    
    public static void main(String[] args) { // main method
        Akash_Vishvajit_Karan_Flights flights = new Akash_Vishvajit_Karan_Flights(); //Object which contain all the flight information
        displayLogo();//method to display logo
        displayWelcomeMessage();//method to display welcome message
        int tripType = getTripType(); //method to get trip type (one way or two way)
        flights.displayFlights(tripType); // method to display all available flights to the user
        int tripNumber = getTripNumber(tripType); //method to get trip number
        int numberOfPassengers = getNumberOfPassengers(); //method to get number of passengers
        int travelClass = getTravelClass(); //method to get travel class (economy or business)
        getDateOfDeparture(tripType); //method to get departure date and return date
        finalBooking.setTravelClass(travelClass);
        finalBooking.setFlightIndex(tripNumber - 1);
        Akash_Vishvajit_Karan_FrequentFlyerPassenger[] passenger = new Akash_Vishvajit_Karan_FrequentFlyerPassenger[numberOfPassengers]; //array of passengers

        for (int i = 0; i < numberOfPassengers; i++) {
            passenger[i] = new Akash_Vishvajit_Karan_FrequentFlyerPassenger();
            System.out.println("\n"+ANSI_PURPLE+"Enter details of passenger " + (i + 1));
            getFirstName(passenger[i]);
            getLastName(passenger[i]);
            getAge(passenger[i]);
            getMeal(passenger[i]);
            System.out.println();
        }
        passenger[0].setAirmiles(passenger[0].getAirmiles() + (numberOfPassengers * flights.miles[tripNumber]));
        if (isFrequentFlyerId()) {
            if (getFrequentFlyerId(passenger[0])) {
            } else {
                passenger[0].setFrequentFlyerId(generateFFID());
            }
        } else {
            passenger[0].setFrequentFlyerId(generateFFID());
        }

        getPaymentMethod(finalBooking);

        finalBooking.setNumberOfPassengers(numberOfPassengers);
        finalBooking.setTravelClass(travelClass);
        showFinalBooking(finalBooking, passenger, tripNumber, tripType); //method to show final booking ticket

    }

    //Method to Display Correct Choice
    public static void displayCorrectChoice() {
        System.out.println(ANSI_RED+"Please Enter Correct Choice.");
    }

    public static void getPaymentMethod(Akash_Vishvajit_Karan_FinalBooking booking) {
        int payMethod = 0;
        boolean redo = false;
        System.out.println();
        do {
            redo = false;
            System.out.println(ANSI_BLUE+"How would you like to pay?");
            System.out.println(ANSI_PURPLE+"1. Credit\n"+ANSI_PURPLE+"2. Debit");
            try {
                payMethod = Integer.parseInt(input.nextLine());
                if (payMethod != 1 && payMethod != 2) {
                    displayCorrectChoice();
                    redo = true;
                } else {
                    booking.setPaymentMethod(payMethod);
                    String cardNumber;
                    boolean redo1 = false;
                    do {
                        redo1 = false;
                        System.out.print(ANSI_BLUE+"Enter 16 Digit Card Number: ");
                        cardNumber = input.nextLine();
                        try {
                            if (Long.parseLong(cardNumber) > 0 && cardNumber.length() == 16) {
                                booking.setCardNumber(Long.parseLong(cardNumber));
                                break;
                            } else {
                                System.out.println(ANSI_RED+"Please enter valid card number");
                                redo1 = true;
                            }
                        } catch (Exception e) {
                            System.out.println(ANSI_RED+"Please enter valid card number");
                            redo1 = true;
                        }

                    } while (redo1);
                }
            } catch (Exception e) {
                displayCorrectChoice();
                redo = true;
            }
        } while (redo);
    }

    //Method to Display Logo
    public static void displayLogo() {
        System.out.println(ANSI_CYANBG);
        System.out.println(ANSI_BLACK + "*****************                *****************");
        System.out.println(ANSI_BLACK +"*****************                *****************");
        System.out.println(ANSI_BLACK +"                ***            ***                ");
        System.out.println(ANSI_BLACK+"    ********     ***         ***      **    **    ");
        System.out.println(ANSI_BLACK+"   **      **     ***       ***      **    **     ");
        System.out.println(ANSI_RED+"   **********      ***   ***       *********      ");
        System.out.println(ANSI_RED+"  ************      **   **       *********       ");
        System.out.println(ANSI_RED+" **          **       ***       **        **      ");
        System.out.println(ANSI_RED+"**            **       *      **           **     \n");
        System.out.println(ANSI_RESET);
    }

    //Method to Display Welcome Message
    public static void displayWelcomeMessage() {
        System.out.println(ANSI_PURPLE+"**********************************************");
        System.out.println(ANSI_PURPLE+"*     Welcome to the AVK Flight Planner      *");
        System.out.println(ANSI_PURPLE+"**********************************************\n");
    }

    //Method to Get Trip Type
    public static int getTripType() {

        int tripType = 1;
        boolean redo = false;
        System.out.println();
        do {
            redo = false;
            System.out.print(ANSI_BLUE+"Enter 1 for One Way, 2 for Round Trip: ");
            try {
                tripType = Integer.parseInt(input.nextLine());
                if (tripType != 1 && tripType != 2) {
                    displayCorrectChoice();
                    redo = true;
                }
            } catch (Exception e) {
                displayCorrectChoice();
                redo = true;
            }
        } while (redo);
        return tripType;
    }

    //Method to Get Trip Number
    public static int getTripNumber(int tripType) {
        int tripNumber = 1;
        boolean redo = false;
        System.out.println();
        do {
            redo = false;
            System.out.print(ANSI_BLUE+"Enter your ");
            if (tripType == 2) {
                System.out.print(ANSI_BLUE+"origin ");
            }
            System.out.print(ANSI_BLUE+"flight number(1/2/3/4/5/6): ");
            try {
                tripNumber = Integer.parseInt(input.nextLine());
                if (!(tripNumber >= 1 && tripNumber <= 6)) {
                    displayCorrectChoice();
                    redo = true;
                }
            } catch (Exception e) {
                displayCorrectChoice();
                redo = true;
            }
        } while (redo);
        return tripNumber;
    }

    //Method to Get Number of Passengers
    public static int getNumberOfPassengers() {
        int numOfPassengers = 0;
        boolean redo = false;
        System.out.println();
        do {
            redo = false;
            System.out.print(ANSI_BLUE+"Enter Number of Passengers: ");
            try {
                numOfPassengers = Integer.parseInt(input.nextLine());
                if (!(numOfPassengers >= 1)) {
                    displayCorrectChoice();
                    redo = true;
                }
            } catch (Exception e) {
                displayCorrectChoice();
                redo = true;
            }
        } while (redo);
        return numOfPassengers;
    }

    //Method to Get Travel Class
    public static int getTravelClass() {
        char travelClass = 'E';
        boolean redo = false;
        int i = 0;
        System.out.println();
        do {
            redo = false;
            System.out.print(ANSI_BLUE+"Class(Press 'E' for Economy / 'B' for Business): ");
            travelClass = input.next().charAt(0);
            input.nextLine();
            if (travelClass == 'E' || travelClass == 'B' || travelClass == 'e' || travelClass == 'b') {
                if (travelClass == 'B' || travelClass == 'b') {
                    i = 1;
                }
                break;
            } else {
                System.out.println(ANSI_RED+"Please Enter Correct Choice: ");
                redo = true;
            }
        } while (redo);
        return i;
    }

    //Method to Get Date of Departure
    public static String getDateOfDeparture(int tripType) {
        Date departDate = new Date();
        Date returnDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date todayDate = new Date();
        String dates = "Depart Date: ";
        boolean redo = false;
        System.out.println();
        do {
            redo = false;
            try {
                System.out.print(ANSI_BLUE+"Date of Departure(dd/mm/yyyy): ");
                String date = input.nextLine();
                departDate = dateFormat.parse(date);
                if (departDate.after(todayDate)) {
                    finalBooking.setDateOfDeparture(date);
                } else {
                    System.out.println(ANSI_RED+"Please enter future date.");
                    redo = true;
                }
            } catch (ParseException e) {
                System.out.println(ANSI_RED+"Please Enter Date in Correct Format(dd/mm/yyyy.");
                redo = true;
            }
        } while (redo);
        dates += departDate.toString();
        if (tripType == 2) {
            dates += "\nReturn Date: ";
            do {
                redo = false;
                try {
                    System.out.print(ANSI_BLUE+"Date of Return(dd/mm/yyyy): ");
                    String date = input.nextLine();
                    returnDate = dateFormat.parse(date);
                    if (returnDate.after(departDate)) {
                        finalBooking.setDateOfReturn(date);
                    } else {
                        System.out.println(ANSI_RED+"Please enter date after departure.");
                        redo = true;
                    }
                } catch (ParseException e) {
                    System.out.println(ANSI_RED+"Please Enter Date in Correct Format(dd/mm/yyyy.");
                    redo = true;
                }
            } while (redo);
            dates += returnDate;
        }
        return dates;
    }

    //Method to Get First Name
    public static void getFirstName(Akash_Vishvajit_Karan_FrequentFlyerPassenger passenger) {
        String firstName;
        boolean redo = false;
        do {
            redo = false;
            System.out.print(ANSI_BLUE+"Enter first name: ");
            firstName = input.nextLine();
            if (firstName.length() > 0 && firstName.matches("[a-zA-Z]+")) {
                firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
                passenger.setFirstName(firstName + "");
                break;
            } else {
                System.out.println(ANSI_RED+"Please enter correct detail.");
                redo = true;
            }
        } while (redo);
    }

    //Method to Get Last Name
    public static void getLastName(Akash_Vishvajit_Karan_FrequentFlyerPassenger passenger) {
        String lastName;
        boolean redo = false;
        do {
            redo = false;
            System.out.print(ANSI_BLUE+"Enter last name: ");
            lastName = input.nextLine();
            if (lastName.length() > 0 && lastName.matches("[a-zA-Z]+")) {
                lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
                passenger.setLastName(lastName);
                break;
            } else {
                System.out.println(ANSI_RED+"Please enter correct detail.");
                redo = true;
            }
        } while (redo);
    }

    //Method to Get Age
    public static void getAge(Akash_Vishvajit_Karan_FrequentFlyerPassenger passenger) {
        int age;
        boolean redo = false;
        do {
            redo = false;
            try {
                System.out.print(ANSI_BLUE+"Enter age: ");
                age = Integer.parseInt(input.nextLine());
                if (age > 0 && age <= 100) {
                    passenger.setAge(age);
                }
                if (age < 0 || age > 100) {
                    System.out.println(ANSI_RED+"Please enter age between 1 to 100");
                    redo = true;
                }
            } catch (Exception e) {
                System.out.println(ANSI_RED+"Please enter correct detail.");
                redo = true;
            }
        } while (redo);
    }

    //Method to Get Meal
    public static void getMeal(Akash_Vishvajit_Karan_FrequentFlyerPassenger passenger) {
        char meal = 'N';
        boolean redo = false;
        do {
            redo = false;
            System.out.print(ANSI_BLUE+"Meal in journey(Enter 'Y' for Yes / 'N' for No): ");
            meal = input.next().charAt(0);
            input.nextLine();
            if (meal == 'N' || meal == 'n' || meal == 'Y' || meal == 'y') {
                passenger.setMeal(meal + "");
                break;
            } else {
                System.out.println(ANSI_RED+"Please enter correct detail.");
                redo = true;
            }
        } while (redo);
    }

    //Method to verify Frequent Flyer ID
    public static boolean isFrequentFlyerId() {
        char id = 'N';
        boolean result = false;
        boolean redo = false;
        do {
            redo = false;
            System.out.print("\n"+ANSI_BLUE+"Do you have a frequent flyer ID(Enter 'Y' for Yes / 'N' for No):");
            id = input.next().charAt(0);
            input.nextLine();
            if (id == 'N' || id == 'n' || id == 'Y' || id == 'y') {
                if (id == 'Y' || id == 'y') {
                    result = true;
                }
            } else {
                System.out.println(ANSI_RED+"Please enter correct detail.");
                redo = true;
            }

        } while (redo);
        return result;
    }

    //Method to Get Frequent Flyer ID
    public static boolean getFrequentFlyerId(Akash_Vishvajit_Karan_FrequentFlyerPassenger passenger) {
        int id = 00000;
        boolean redo = false;
        boolean result = false;
        char yes = 'y';
        do {
            redo = false;
            try {
                System.out.print(ANSI_BLUE+"Enter your 5 digit Frequent Flyer Id(Ex.12345): ");
                id = Integer.parseInt(input.nextLine());
                if (id == passenger.getFrequentFlyerId()) {
                    return true;
                } else {
                    throw new EmptyStackException();
                }
            } catch (Exception e) {
                System.out.print(ANSI_RED+"Invalid Frequent Flyer Id is Entered.\n"+ANSI_RED+"Would You like to try again(Enter 'Y' for Yes: ");
                yes = input.next().charAt(0);
                input.nextLine();
                if (yes == 'N' || yes == 'n' || yes == 'Y' || yes == 'y') {
                    if (yes == 'y' || yes == 'Y') {
                        redo = true;
                    } else {
                        return false;
                    }
                } else {
                    System.out.print(ANSI_RED+"Please enter correct detail.");
                    redo = true;
                }

            }
        } while (redo);
        return result;
    }

    //Method to Generate New Frequent Flyer ID
    public static int generateFFID() {
        Random r = new Random(System.currentTimeMillis());
        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
    }

    //Method to Show Final Booking
    public static void showFinalBooking(Akash_Vishvajit_Karan_FinalBooking booking, Akash_Vishvajit_Karan_FrequentFlyerPassenger[] passenger, int tripNumber, int tripType) {
        try {
            String wait = "\nVerifying Payment. Please Wait.";
            System.out.println(wait);
            for (int g = 0; g < 2; g++) {
                for (int f = 0; f <= 2; f++) {
                    System.out.print(".");
                    Thread.sleep(1000);
                }
                System.out.print("\b");
                if (g == 1) {
                    System.out.println("\b");
                }
            }

            System.out.println(ANSI_GREEN+"Your payment successfully verified.");
            Thread.sleep(1500);
            System.out.print(ANSI_BLUE+"Printing Your Ticket");
            for (int f = 0; f < 3; f++) {
                System.out.print(".");
                Thread.sleep(1000);
            }

            System.out.println();
            System.out.println();

            int i = 0;
            System.out.println("\n\n\n--------------------------------------------------");
            System.out.println("                      Ticket                      ");
            displayLogo();
            System.out.println("\n"+ANSI_RED+"                 Booking Id - " + generateFFID() + "              \n");
            System.out.println("  Your booking is confirmed. Please print/retain \n"
                    + "  this page for your financial records (e.g. for \n"
                    + "  taxation, expense claim or payment card \n"
                    + "  reconciliation purposes). We thank you for \n"
                    + "  choosing AVK Planner and look forward to welcoming\n"
                    + "  you on board.");
            System.out.println();
            System.out.println(ANSI_BLUE+"Booking Information");
            System.out.print("Main Contact: ");
            System.out.println(passenger[i].getFirstName() + " " + passenger[i].getLastName());
            System.out.println();
            System.out.print(ANSI_BLUE+"Flight Itinerary");
            if (booking.getTravelClass() != 1) {
                System.out.println("(Economy Class): ");
            } else {
                System.out.println("(Business Class): ");
            }
            System.out.println(booking.flight.flightNumber[tripNumber - 1] + " - "
                    + booking.flight.origin[tripNumber - 1] + " to "
                    + booking.flight.destination[tripNumber - 1]
                    + " - " + booking.getDateOfDeparture() + " 11:50 AM");
            if (tripType != 1) {
                System.out.println(booking.flight.flightNumber[tripNumber - 1] + " - "
                        + booking.flight.destination[tripNumber - 1] + " to "
                        + booking.flight.origin[tripNumber - 1]
                        + " - " + booking.getDateOfReturn() + " 5:30 PM");
            }
            System.out.println();
            if (passenger[0].getFrequentFlyerId() != 12345) {
                System.out.print(ANSI_RED+"Your new ");
            }
            System.out.println(ANSI_RED+"Frequent Flyer Id: " + passenger[0].getFrequentFlyerId());
            System.out.println(ANSI_BLUE+"Total Miles: " + passenger[0].getAirmiles());
            System.out.println();
            System.out.println(ANSI_BLUE+"Passenger Information");
            for (i = 0; i < booking.getNumberOfPassengers(); i++) {
                System.out.print((i + 1) + ". " + passenger[i].getFirstName() + " " + passenger[i].getLastName() + " - " + passenger[i].getAge());
                if (passenger[i].getAge() > 16) {
                    System.out.print(" (Adult)");
                } else {
                    System.out.print(" (Minor)");
                }
                System.out.println(" - Meal(" + passenger[i].getMeal() + ")");

            }
            System.out.println();
            System.out.print(ANSI_BLUE+"Payment Information(Paid By - ");
            if (booking.getPaymentMethod() == 1) {
                System.out.print(ANSI_BLUE+"Credit - ");
            } else {
                System.out.print(ANSI_BLUE+"Debit - ");
            }
            System.out.println(ANSI_RED+"****" + Long.toString(booking.getCardNumber()).substring(12) + ")");
            System.out.println(booking.toString());
        } catch (Exception e) {
        }
    }

}
*/