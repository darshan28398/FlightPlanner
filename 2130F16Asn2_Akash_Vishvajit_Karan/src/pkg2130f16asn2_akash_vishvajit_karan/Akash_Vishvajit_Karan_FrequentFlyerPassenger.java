/*COMP 2130 CRN :- 10454
 *Assignment 2
 * Group Member 1:- Akash Chamaria Student ID:- 101024951
 * Group Member 2:- Vishvajit Kher Student ID:- 101015270
 * Group Member 3:- Karan Amul Acharya Student ID:- 101026087
 Submitted to Anjana Shah
*/
package pkg2130f16asn2_akash_vishvajit_karan;

import java.util.Date;

/**
 *
 * @author MYPC
 */
public class Akash_Vishvajit_Karan_FrequentFlyerPassenger extends Akash_Vishvajit_Karan_Passenger{
    
    //Data Members
    private int frequentFlyerId = 12345;
    private double totalMiles = 0;
    private double airmiles = 0;
    private String meal;
    
    //Default Constructor
    public Akash_Vishvajit_Karan_FrequentFlyerPassenger(){
       
    }
    
    //Getters and Setters
    public int getFrequentFlyerId() {
        return frequentFlyerId;
    }
    
    
    public void setFrequentFlyerId(int frequentFlyerNumber) {
        this.frequentFlyerId = frequentFlyerNumber;
    }

    public double getTotalMiles() {
        return totalMiles;
    }

    public void setTotalMiles(double totalMiles) {
        this.totalMiles = totalMiles;
    }

    public double getAirmiles() {
        return airmiles;
    }

    public void setAirmiles(double airmiles) {
        this.airmiles = airmiles;
    }
    
    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }
    
}
