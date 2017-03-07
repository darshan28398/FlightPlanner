/*COMP 2130 CRN :- 10454
 *Assignment 2
 * Group Member 1:- Akash Chamaria Student ID:- 101024951
 * Group Member 2:- Vishvajit Kher Student ID:- 101015270
 * Group Member 3:- Karan Amul Acharya Student ID:- 101026087
 Submitted to Anjana Shah
*/
package pkg2130f16asn2_akash_vishvajit_karan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author MYPC
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setResizable(false);
        
        stage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
      
    }
    
}
