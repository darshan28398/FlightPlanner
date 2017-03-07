/*COMP 2130 CRN :- 10454
 *Assignment 2
 * Group Member 1:- Akash Chamaria Student ID:- 101024951
 * Group Member 2:- Vishvajit Kher Student ID:- 101015270
 * Group Member 3:- Karan Amul Acharya Student ID:- 101026087
 Submitted to Anjana Shah
*/
package pkg2130f16asn2_akash_vishvajit_karan;

import java.net.URL;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class FXMLDocumentController extends Akash_Vishvajit_Karan_Flights implements Initializable {
    
    ObservableList<String> flightList = FXCollections.observableArrayList();
    ObservableList<String> classList = FXCollections.observableArrayList("Economy","Business");
    ObservableList<String> paymentList = FXCollections.observableArrayList("Credit","Debit");

    @FXML private ComboBox flightCmboBx;
    @FXML private ComboBox classCmboBx;
    @FXML private ComboBox paymentMethodCmboBx;
    @FXML private Button btn1;
    @FXML private Button btn2;
    @FXML private Button btn3;
    @FXML private Button newReservation;
    @FXML private Button showReservations;
    @FXML private Button backBtn;
    @FXML private Button nextBtn;
    @FXML private Button exitBtn;
    @FXML private AnchorPane pane1;
    @FXML private AnchorPane pane2;
    @FXML private AnchorPane pane3;
    @FXML private AnchorPane pane4;
    @FXML private RadioButton oneWay;
    @FXML private RadioButton roundTrip;
    @FXML private TextField numOfPassengers;
    @FXML private DatePicker departingDate;
    @FXML private DatePicker returningDate;
    @FXML private DatePicker cardValid;
    @FXML private TextField firstNameTxtBx;
    @FXML private TextField lastNameTxtBx;
    @FXML private TextField ageTxtBx;
    @FXML private TextField cvvTxtBx;
    @FXML private Label verifyTxtBx;
    @FXML private TextField ffidTxtBx;
    @FXML private TextField cardNumberTxtBx;
    @FXML private RadioButton mealYes;
    @FXML private RadioButton mealNo;
    @FXML private Label passengerNumLabel;
    @FXML private TextArea bookingLabel;
    @FXML private Label returnLabel;
    
    public static Akash_Vishvajit_Karan_FinalBooking finalBooking = new Akash_Vishvajit_Karan_FinalBooking();
    Akash_Vishvajit_Karan_FrequentFlyerPassenger[] passengers = new Akash_Vishvajit_Karan_FrequentFlyerPassenger[10];
    Akash_Vishvajit_Karan_Flights flights = new Akash_Vishvajit_Karan_Flights();
    public int index = 0;
    public int nor = 0;
    public int j=0;
    public int tripnumber = 0;
    public double airmiles=0;
    public int ffid=12345;
    ArrayList<String> booking = new ArrayList<String>();
    
    Alert alert = new Alert(AlertType.INFORMATION);
    
    public void initialize(URL url, ResourceBundle rb) {
        j = 0;
        alert.setTitle("Information Dialog");
    alert.setHeaderText("Look, an Information Dialog");
    alert.setContentText("Please enter correct information and complete all information to proceed");
        try{
        pane2.setVisible(false);
        pane3.setVisible(false);
        pane4.setVisible(false);
        returningDate.setVisible(false);
        returnLabel.setVisible(false);
        departingDate.setValue(LocalDate.now().plusDays(1));
        
        for(int i=0;i<origin.length;i++){
            flightList.add((origin[i]+" to "+destination[i]));
        }
        flightCmboBx.setItems(flightList);
        classCmboBx.setItems(classList);
        paymentMethodCmboBx.setItems(paymentList);
        
        btn1.setOnAction((event) -> {
            if(validatepane1()){
                pane1.setVisible(false);
                pane2.setVisible(true);
                pane3.setVisible(false);
                pane4.setVisible(false);
                passengerNumLabel.setText("Enter details of passenger "+(index+1));
            }
            
        });
        
        
        btn2.setOnAction((event) -> {
            if(validatepane2()){
                if(index==getNumberOfPassengers()-1){
                    index=0;
                    pane1.setVisible(false);
                    pane2.setVisible(false);
                    pane3.setVisible(true);
                    pane4.setVisible(false);
                    verifyTxtBx.setVisible(false);
                }else{
                    index++;
                    firstNameTxtBx.setText("");
                    lastNameTxtBx.setText("");
                    ageTxtBx.setText("");
                }
                passengerNumLabel.setText("Enter details of passenger "+(index+1));
            }
        });
        
        btn3.setOnAction((event) -> {
            try {
                validatepane3();
            } catch (InterruptedException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        exitBtn.setOnAction((event) -> {
            Platform.exit();
            System.exit(0);
        });
        
        newReservation.setOnAction((event) -> {
            pane1.setVisible(true);
            pane2.setVisible(false);
            pane3.setVisible(false);
            pane4.setVisible(false);
            numOfPassengers.setText("");
            departingDate.setValue(LocalDate.now().plusDays(1));
            returningDate.setValue(null);
            flightCmboBx.setValue(null);
            firstNameTxtBx.setText("");
            lastNameTxtBx.setText("");
            ageTxtBx.setText("");
            exitBtn.setVisible(false);
            nextBtn.setVisible(false);
            backBtn.setVisible(false);
            showReservations.setVisible(true);
            index=0;
            nor = 0;
        });
        
        showReservations.setOnAction((event) -> {
            try{
            pane1.setVisible(false);
            pane2.setVisible(false);
            pane3.setVisible(false);
            pane4.setVisible(true);
            nextBtn.setVisible(true);
            backBtn.setVisible(true);
            exitBtn.setVisible(true);
            showReservations.setVisible(false);
            showAllReservations();
            index=0;
            }catch(Exception e){
                
            }
        });
        
        
        Callback<DatePicker, DateCell> dayCellFactory = dp -> new DateCell()
        {
            @Override
            public void updateItem(LocalDate item, boolean empty)
            {
                super.updateItem(item, empty);

                if(item.isBefore(LocalDate.now().plusDays(1)) || item.isAfter(LocalDate.now().plusYears(1)))
                {
                    setStyle("-fx-background-color: #ffc0cb;");
                    Platform.runLater(() -> setDisable(true));
                }
                
                
            }
        };
        departingDate.setDayCellFactory(dayCellFactory);
        
        Callback<DatePicker, DateCell> dayCell = dp -> new DateCell()
        {
            @Override
            public void updateItem(LocalDate item, boolean empty)
            {
                super.updateItem(item, empty);

                if(item.isBefore(departingDate.getValue().plusDays(1)) || item.isAfter(departingDate.getValue().plusYears(1)))
                {
                    setStyle("-fx-background-color: #ffc0cb;");
                    Platform.runLater(() -> setDisable(true));
                }
                
                
            }
        };
        
        returningDate.setDayCellFactory(dayCell);
        
        Callback<DatePicker, DateCell> dayCel = dp -> new DateCell()
        {
            @Override
            public void updateItem(LocalDate item, boolean empty)
            {
                super.updateItem(item, empty);

                if(item.isBefore(LocalDate.now()) || item.isAfter(LocalDate.now().plusYears(10)))
                {
                    setStyle("-fx-background-color: #ffc0cb;");
                    Platform.runLater(() -> setDisable(true));
                }
                
                
            }
        };
        
        cardValid.setDayCellFactory(dayCel);
        }catch(Exception e){
            alert.showAndWait();
        }
    }
    
    
    public boolean validatepane1(){
        alert.setTitle("Information Dialog");
    alert.setHeaderText("Look, an Information Dialog");
    alert.setContentText("Please enter correct information and complete all information to proceed");
        try{
        if(getTripType()!=0){
            if(getTripNumber()!=0){
                tripnumber = getTripNumber(); 
                if(getNumberOfPassengers()!=0&&getNumberOfPassengers()<6){
                    if(getdepartingDate().length()==10){
                        if(getTripType()==2){
                            if(departingDate.getValue().isBefore(returningDate.getValue())){
                                finalBooking = new Akash_Vishvajit_Karan_FinalBooking();
                                finalBooking.setTravelClass(getTravelClass());
                                finalBooking.setFlightIndex(tripnumber-1);
                                finalBooking.setNumberOfPassengers(getNumberOfPassengers());
                                return true;
                            }
                        }else{
                            if(getTripType()!=2){
                                finalBooking = new Akash_Vishvajit_Karan_FinalBooking();
                                finalBooking.setTravelClass(getTravelClass());
                                finalBooking.setFlightIndex(tripnumber-1);
                                finalBooking.setNumberOfPassengers(getNumberOfPassengers());
                                System.out.println(tripnumber);
                                return true;
                            }
                        }
                    }
                }
        
            }
        }}catch(Exception e){
            alert.showAndWait();
        }
        return false;
    }
    
    public boolean validatepane2(){
        alert.setTitle("Information Dialog");
    alert.setHeaderText("Look, an Information Dialog");
    alert.setContentText("Please enter correct information and complete all information to proceed");
        try{
            passengers[index] = new Akash_Vishvajit_Karan_FrequentFlyerPassenger();
            if(getFirstName().matches("[a-zA-Z]+\\.?")&&getFirstName().length()>0&&getFirstName().length()<32){
                if(getLastName().matches("[a-zA-Z]+\\.?")&&getLastName().length()>0&&getLastName().length()<32){
                    if(getAge()>0&&getAge()<100){
                        if(!getMeal().equals("none")){
                            passengers[index].setFirstName(getFirstName());
                            passengers[index].setLastName(getLastName());
                            passengers[index].setAge(getAge());
                            passengers[index].setMeal(getMeal());
                            if(index==0){
                                passengers[0].setAirmiles(passengers[0].getAirmiles() + (getNumberOfPassengers() * flights.miles[getTripNumber()]));
                            }
                            return true;
                        }
                    }
                }
            }
        }catch(Exception e){
            alert.showAndWait();
        }
        return false;
    }
    
    public void validatepane3() throws InterruptedException{
        try{
            if(getffid().length()!=0){
                if(!(Integer.parseInt(getffid())==ffid)){
                    ffid = generateFFID();
                    airmiles = 0;
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Look, an Information Dialog");
                    alert.setContentText("You have entered invalid frequent flyer ID. You have been assigned new ID.");
                    alert.show();
                }
            }else{
                ffid = generateFFID();
                airmiles = 0;
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Look, an Information Dialog");
                alert.setContentText("You haven't entered any frequent flyer ID. You have been assigned new ID.");
                alert.show();
            }
            
            if(getPaymentMethod()!=0){
                finalBooking.setPaymentMethod(getPaymentMethod());
                if(getCardNumber().length()==16 && Long.parseLong(getCardNumber())>0){
                    finalBooking.setCardNumber(Long.parseLong(getCardNumber()));
                    if((getCvv().length()==3 || getCvv().length()==4) && (Integer.parseInt(getCvv())>0)){
                        finalBooking.setCvv(Integer.parseInt(getCvv()));
                        if(getCardValidDate().length()==10){
                            finalBooking.setCardValidDate(getCardValidDate());
                            verifyPayment();
                        }
                    }
                }
            }
        }catch(Exception e){
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Look, an Information Dialog");
            alert.setContentText("Please enter correct information and complete all information to proceed");
            alert.showAndWait();
        }
    }
    
    public void onRoundTrip(){
        returningDate.setVisible(true);
        returnLabel.setVisible(true);
    }
    
    public void onOneWay(){
        returningDate.setVisible(false);
        returnLabel.setVisible(false);
    }
    
    public int getTripType(){
        if(oneWay.isSelected())
            return 1;
        if(roundTrip.isSelected())
            return 2;
        return 0;
    }
    
    public int getTripNumber(){
        switch(flightCmboBx.getValue().toString()){
            case "Mumbai to Delhi":
                return 1;
            case "Kolkata to Bengaluru":
                return 2;
            case "Ahmedabad to Goa":
                return 3;
            case "Delhi to Mumbai":
                return 4;
            case "Bengaluru to Kolkata":
                return 5;
            case "Goa to Ahmedabad":
                return 6;      
        }
        return 0;
    }
    
    public double calculateAirmiles(){
        airmiles = airmiles+flights.miles[getTripNumber()];
        return airmiles;
    }
    
    public int getNumberOfPassengers(){
        if(Integer.parseInt(numOfPassengers.getText())>0){
            return Integer.parseInt(numOfPassengers.getText());
        }
        return 0;
    }
    
    public String getdepartingDate(){
        LocalDate date = departingDate.getValue();
        return date.toString();
    }

    public String getReturningDate(){
        LocalDate date = returningDate.getValue();
        return date.toString();
    }
    
    public int getTravelClass(){
        switch(classCmboBx.getValue().toString()){
            case "Economy":
                return 0;
            case "Business":
                return 1;
        }
        return 2;
    }
    
    public String getFirstName(){
        return firstNameTxtBx.getText();
    }
    
    public String getLastName(){
        return lastNameTxtBx.getText();
    }
    
    public int getAge(){
        if(Integer.parseInt(ageTxtBx.getText())>0){
            return Integer.parseInt(ageTxtBx.getText());
        }
        return 0;
    }
    
    public String getMeal(){
        if(mealYes.isSelected())
            return "Yes";
        if(mealNo.isSelected())
            return "No";
        return "none";
    }
    
    public String getCardNumber(){
        return cardNumberTxtBx.getText();
    }
    
    public String getCvv(){
        return cvvTxtBx.getText();
    }
    
    public String getCardValidDate(){
        LocalDate date = cardValid.getValue();
        return date.toString();
    }
    
    public String getffid(){
        return ffidTxtBx.getText();
    }
    
    public int generateFFID() {
        Random r = new Random(System.currentTimeMillis());
        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
    }
    
    public int getPaymentMethod(){
        switch(paymentMethodCmboBx.getValue().toString()){
            case "Credit":
                return 1;
            case "Debit":
                return 2;
        }
        return 0;
    }
    
    public void verifyPayment() throws InterruptedException{
        verifyTxtBx.setVisible(true);
        String wait = "Verifying Payment. Please Wait...";
        verifyTxtBx.setText(wait);
        verifyTxtBx.setText("Payment Successful");
        pane1.setVisible(false);
        pane2.setVisible(false);
        pane3.setVisible(false);
        pane4.setVisible(true);
        showFinalBooking();
    }
    
    public void showFinalBooking() {
        try {
            int i = 0;
            String print = "";
            print += "                 Booking Id - " + generateFFID() + "              \n"+
            "  Your booking is confirmed. Please print/retain \n"
                    + "  this page for your financial records (e.g. for \n"
                    + "  taxation, expense claim or payment card \n"
                    + "  reconciliation purposes). We thank you for \n"
                    + "  choosing AVK Planner and look forward to welcoming\n"
                    + "  you on board.\n\n"
                    + "Booking Information\n"+
            "Main Contact: \n"+
           passengers[i].getFirstName() + " " + passengers[i].getLastName()+"\n\n"+
            "Flight Itinerary";
            if (finalBooking.getTravelClass() != 1) {
                print+="\n(Economy Class): ";
            } else {
                print+="\n(Business Class): ";
            }
            print+="\n"+finalBooking.flight.flightNumber[getTripNumber() - 1] + " - "
                    + finalBooking.flight.origin[getTripNumber() - 1] + " to "
                    + finalBooking.flight.destination[getTripNumber() - 1]
                    + " - " + getdepartingDate() + " 11:50 AM";
            if (getTripType()!= 1) {
                print+="\n"+finalBooking.flight.flightNumber[getTripNumber() - 1] + " - "
                        + finalBooking.flight.destination[getTripNumber() - 1] + " to "
                        + finalBooking.flight.origin[getTripNumber() - 1]
                        + " - " + getReturningDate() + " 5:30 PM\n";
            }
            
            if (passengers[0].getFrequentFlyerId() != 12345) {
                print+="\nYour new ";
            }else{print+="\n";}
            print+="Frequent Flyer Id: " + ffid;
            print+="\n\nTotal Miles: " + calculateAirmiles();
            print+="\n\nPassenger Information:\n";
            for (i = 0; i <getNumberOfPassengers(); i++) {
                print+=(i + 1)+ ". " + passengers[i].getFirstName() + " " + passengers[i].getLastName() + " - " + passengers[i].getAge();
                if (passengers[i].getAge() > 16) {
                    print+=" (Adult)";
                } else {
                    print+=" (Minor)";
                }
                print+=" - Meal(" + passengers[i].getMeal() + ")\n";

            }
            print+="\nPayment Information(Paid By - ";
            if (finalBooking.getPaymentMethod() == 1) {
                print+="Credit - ";
            } else {
                print+="Debit - ";
            }
            print+="****" + Long.toString(finalBooking.getCardNumber()).substring(12) + ")";
            print+="\n"+finalBooking.toString();
            booking.add(j,print);
            j++;
            bookingLabel.setText(print);
            backBtn.setVisible(false);
            nextBtn.setVisible(false);
            btn3.setVisible(true);
        } catch (Exception e) {
        }
    }
    
    
    public void showAllReservations(){
            if(nor<booking.size()){
                bookingLabel.setText(booking.get(nor));
      
                nextBtn.setOnAction((event) -> {
                    nor++;
                    if(nor<booking.size()){
                        showAllReservations();
                    }
                    if(nor>=booking.size()){
                        nor--;
                    }
                });

                backBtn.setOnAction((event) -> {
                    nor--;
                    if(nor>=0&&nor<booking.size()){   
                        showAllReservations();
                    }
                    if(nor<0){
                        nor++;
                    }
                });
            }
        }
    
    }