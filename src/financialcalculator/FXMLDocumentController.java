package financialcalculator;

import FinancialClass.interest;
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

    ArrayList<Double> array = new ArrayList<>(); //Creating an arrayList
    private double result;
    private int history;
    private int f = 0;
    //For financial calculations:
    private Double i = 0.00;
    private Double n = 0.00;
    private Double pv = 0.00;
    private Double fv = 0.00;
    //Apply JSON here!!

    @FXML
    private TextField txtScreen;

    @FXML
    private void btnF(ActionEvent event) {
        f = 1;
        /* If the variable equals 1 - and on CLX press = f helps to clean the input and array */
    }

    ;
    @FXML
    private void Enter(ActionEvent event) {
        array.add(Double.parseDouble(txtScreen.getText()));
        txtScreen.setText("0");
    }

    @FXML
    private void CLX(ActionEvent event) {
        if (f == 1) {
            array.clear();
            txtScreen.setText("0");
        };
    }

    ;
    @FXML
    private void addUp(ActionEvent event) {
        //Addup calculating:
        result = 0;
        for (int i = 0; i < array.size(); i++) {
            result += array.get(i);
        };
        array.clear(); //Clean the array
        array.add(result); //Update value on the array
        txtScreen.setText(Double.toString(result));
    }

    ;
    @FXML
    private void subtraction(ActionEvent event) {
        result = array.get(0); //Get the first value of the array
        array.remove(0); // Remove from the array the first value
        for (int i = 0; i < array.size(); i++) {
            result -= array.get(i);
        };
        array.clear();
        array.add(result);
        txtScreen.setText(Double.toString(result));
    }

    ;
    @FXML
    private void multiplication(ActionEvent event) {
        //Multi
        result = 1;
        for (int i = 0; i < array.size(); i++) {
            result *= array.get(i);
        };
        array.clear();
        array.add(result);
        txtScreen.setText(Double.toString(result));
    }

    ;
    @FXML
    private void division(ActionEvent event) {
        //Divide
        result = array.get(0);
        array.remove(0);
        for (int i = 0; i < array.size(); i++) {
            result /= array.get(i);
        }
        array.clear();
        array.add(result);
        txtScreen.setText(Double.toString(result));
    }

    ;
    @FXML
    public void nbtn(ActionEvent event) {
        n = Double.parseDouble(txtScreen.getText());
        txtScreen.setText("0");
    }

    ;
    @FXML
    public void ibtn(ActionEvent event) {
        i = Double.parseDouble(txtScreen.getText());
        txtScreen.setText("0");
    }

    ;
    @FXML
    public void pvbtn(ActionEvent event) {
        pv = Double.parseDouble(txtScreen.getText());
        txtScreen.setText("0");
    }

    ;
    @FXML
    public void fvbtn(ActionEvent event) {
        if (txtScreen.getText().contains("0")) {
            interest in = new interest();
            txtScreen.setText(in.calculateAmount(n, i, pv)); //Put the result in the Screen
        }
    }

    ;
    @FXML
    private void btn(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String value = btn.getText();
        String current = txtScreen.getText();
        
        if (current.equals("0")) {
            txtScreen.setText(value); // Changes the initial 0
        } else {
            txtScreen.appendText(value);
        }
    }

    ;
    @FXML
    private void dot(ActionEvent event) {
        //Put the point on decimal values in the textField
        if (!txtScreen.getText().contains(".")) {
            txtScreen.appendText(".");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
