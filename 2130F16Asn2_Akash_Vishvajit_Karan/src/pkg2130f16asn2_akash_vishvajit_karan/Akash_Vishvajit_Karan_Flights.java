/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2130f16asn2_akash_vishvajit_karan;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author MYPC
 */
public class Akash_Vishvajit_Karan_Flights {
    
    //Data Members
    public String[] origin = {"Mumbai", "Kolkata", "Ahmedabad", "Delhi", "Bengaluru","Goa"};
    public String[] destination = {"Delhi", "Bengaluru","Goa", "Mumbai", "Kolkata", "Ahmedabad"};
    public String[] flightNumber = {"MD127", "KB141", "AG147","MD127", "KB141", "AG147"};
    public double[] miles = {709, 962, 538, 709, 962, 538};
    public double fare[] = {0.20, 0.50};
    
    //Default Constructor
    public Akash_Vishvajit_Karan_Flights() {
        
    }
    
    
    // Method to Display Flights
    public void displayFlights(int tripType){
        for(int i=0;i<=2;i++){
            System.out.print((i+1)+". "+origin[i]+" to "+destination[i]);
            System.out.println("\t"+(i+4)+". "+origin[i+3]+" to "+destination[i+3]);
       } 
    }    
    
}
