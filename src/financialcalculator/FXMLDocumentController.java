
package financialcalculator;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author gabri
 */
public class FXMLDocumentController implements Initializable {
    ArrayList<Integer> array = new ArrayList<>(); //Creating an arrayList
    private int result;
    private int history;
    private int f = 0;
    //Apply JSON here!!

    @FXML
    private TextField txtScreen;
    @FXML
    private void btnF(ActionEvent event) {
        f = 1; 
    /* If the variable equals 1 - and on CLX press = f helps to clean the input and array */
    };
    @FXML
    private void handleButtonAction(ActionEvent event) {
        //Enter btn
        array.add(Integer.parseInt(txtScreen.getText()));
        txtScreen.setText("0.00");
    }
    @FXML
    private void CLX(ActionEvent event) {
        if(f == 1) {
            array.clear();
            txtScreen.setText("0.00");
        };
    };
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
        result = array.get(0); //Get the first value of the array
        array.remove(0); // Remove from the array the first value
        for(int i = 0; i < array.size(); i++) {
            result -= array.get(i);
        };
        array.clear();
        array.add(result);
        txtScreen.setText(Integer.toString(result));
    };
    @FXML
    private void multiplication(ActionEvent event) {
        //Multi
        result = 1;
        for(int i = 0; i < array.size(); i++) {
            result *= array.get(i);
        };
        array.clear();
        array.add(result);
        txtScreen.setText(Integer.toString(result));
    };
    @FXML
    private void division(ActionEvent event) {
        //Divide
        result = array.get(0);
        array.remove(0);
        for(int i = 0; i < array.size(); i++) {
            result /= array.get(i);
        }
        array.clear();
        array.add(result);
        txtScreen.setText(Integer.toString(result));
    };
    @FXML
    private void btn(ActionEvent event) {
       double txt = Double.parseDouble(txtScreen.getText());
       if(txt == 0.00) {
           txtScreen.setText("");
           /* Conditional to update and set the text on the TextField */
       }
       Button btn = (Button) event.getSource();
       String value = btn.getText(); // Get the text from the button
       txtScreen.appendText(value); // Show it on the screen
    };
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
