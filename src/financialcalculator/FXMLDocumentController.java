
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
    //Apply JSON here!!
    
    
    @FXML
    private Label label;
    @FXML
    private TextField txtScreen;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        //Enter btn
        String addValue = txtScreen.getText();
        array.add(Integer.parseInt(addValue));
    }
    @FXML
    private void addUp(ActionEvent event) {
        //Addup calculating:
        int result = 0;
        for(int i = 0; i < array.size(); i++) {
            result += array.get(i);
        };
        
        txtScreen.setText(Integer.toString(result));
    };
    @FXML
    private void btn(ActionEvent event) {
        //Start adding buttons
    };
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
