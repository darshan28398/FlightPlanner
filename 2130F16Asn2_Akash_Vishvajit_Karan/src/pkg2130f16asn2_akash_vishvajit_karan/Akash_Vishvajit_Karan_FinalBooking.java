/*COMP 2130 CRN :- 10454
 *Assignment 2
 * Group Member 1:- Akash Chamaria Student ID:- 101024951
 * Group Member 2:- Vishvajit Kher Student ID:- 101015270
 * Group Member 3:- Karan Amul Acharya Student ID:- 101026087
 Submitted to Anjana Shah
*/
package pkg2130f16asn2_akash_vishvajit_karan;

import com.sun.javafx.css.CalculatedValue;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import static jdk.nashorn.internal.objects.NativeMath.round;

/**
 *
 * @author MYPC
 */

public class Akash_Vishvajit_Karan_FinalBooking {
    public NumberFormat df = NumberFormat.getCurrencyInstance();
    //Data Members
    private final double Federal_Excise_Tax = 0.075;
    private final double Flight_Segment_Tax = 0.074;
    private final double Passenger_Facility_Charge = 0.09;
    
    //Composition
    Akash_Vishvajit_Karan_Flights flight = new Akash_Vishvajit_Karan_Flights();
    
    //Data Members
    private String origin;
    private String destination;
    private String flightNumber;
    private String miles;
    private double fare;
    private int numberOfPassengers;
    private String dateOfDeparture;
    private String dateOfReturn;
    private int travelClass;
    private int flightIndex;
    private double baseFare;
    private String Fare = "";
    private int paymentMethod;
    private long cardNumber;
    private int cvv;
    private String cardValidDate;

    //Getters and Setters
    
    

    public String getCardValidDate() {
        return cardValidDate;
    }

    public void setCardValidDate(String cardValidDate) {
        this.cardValidDate = cardValidDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
    
    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    
    
    public int getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    
    public int getFlightIndex() {
        return flightIndex;
    }

    public void setFlightIndex(int flightIndex) {
        this.flightIndex = flightIndex;
    }
    

    public double getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(double baseFare) {
        this.baseFare = baseFare;
    }
    
    //Constructor
    public Akash_Vishvajit_Karan_FinalBooking(int tn, int tc){
        flightIndex = tn;
        travelClass = tc;
    }
    
    //Method to calculate total fare
    public void calculateTotalFare(){ 
        fare = numberOfPassengers * (flight.miles[flightIndex]*flight.fare[travelClass]);
        setBaseFare(fare);
        this.Fare += "Base Fare: "+df.format(fare)+"\n";
        double fedTax = fare * Federal_Excise_Tax;
        this.Fare += "Federal Excise Tax: " + df.format(fedTax)+"\n";
        double fSegTax = fare * Flight_Segment_Tax;
        this.Fare += "Flight Segment Tax: "+df.format(fSegTax)+"\n";
        double pFacTax = fare * Passenger_Facility_Charge;
        this.Fare += "Passenger Facility Charge: "+df.format(pFacTax)+"\n";
        fare = fare + fedTax + fedTax + pFacTax;
        this.Fare += "Total Fare: "+df.format(fare);
    }
    
    
    
    //Getters and Setters
    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(String dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public String getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(String dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }


    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getMiles() {
        return miles;
    }

    public void setMiles(String miles) {
        this.miles = miles;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public int getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(int travelClass) {
        this.travelClass = travelClass;
    }
    
    
    
    
    public Akash_Vishvajit_Karan_FinalBooking() {
    }
    
    //Data Members
    public String toString() { 
        calculateTotalFare();
        return this.Fare;
    } 
    
}
