
package financialcalculator;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author gabri
 */
public class FXMLDocumentController implements Initializable {
    ArrayList<Integer> array = new ArrayList<>(); //Creating an arrayList
    private int result;
    private int history;
    //Apply JSON here!!
    
    
    @FXML
    private Label label;
    @FXML
    private TextField txtScreen;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        //Enter btn
        array.add(Integer.parseInt(txtScreen.getText()));
        txtScreen.setText("0.00"); //Add 0.00 on btn again
        
    }
    @FXML
    private void addUp(ActionEvent event) {
        //Addup calculating:
        result = 0;
        for(int i = 0; i < array.size(); i++) {
            result += array.get(i);
        };
        array.clear(); //Clean the array
        array.add(result); //Update value on the array
        txtScreen.setText(Integer.toString(result));
    };
    @FXML
    private void subtraction(ActionEvent event) {
        result = array.get(0);
        array.remove(0);
        for(int i = 0; i < array.size(); i++) {
            result -= array.get(i);
        };
        System.out.println(result);
    };
    @FXML
    private void btn(ActionEvent event) {
       txtScreen.setText(""); //Clean Enter btn
       Button btn = (Button) event.getSource();
       String value = btn.getText(); // Get the text from the button
       txtScreen.appendText(value); // Show it on the screen
    };
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
