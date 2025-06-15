package financialcalculator;

import FinancialClass.interest;
import MathFunctions.FuncoesMatematica;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import memory.STO;

/**
 *
 * @author gabri
 */
public class FXMLDocumentController implements Initializable {

    //Values saving and variables declarations:
    ArrayList<Double> array = new ArrayList<>(); //Creating an arrayList
    private double result;
    private boolean sto = false;
    private boolean rcl = false;
    private boolean f = false;
    private boolean g = false;
    //For financial calculations:
    private Double i = 0.00;
    private Double n = 0.00;
    private Double pv = 0.00;
    private Double fv = 0.00;

    //FXML imports:
    @FXML
    private TextField txtScreen;
    @FXML
    private Label lbPrefix;

    //Basic functions:
    @FXML
    private void btnF(ActionEvent event) {
        f = true;
        lbPrefix.setText("f");
        /* If the variable equals 1 - and on CLX press = f helps to clean the input and array */
    }
    
    @FXML
    private void btnG(ActionEvent event) {
        g = true;
        lbPrefix.setText("g");
        /* To informe if the g function is being used */
    }
    
    @FXML
    private void btnOn(ActionEvent event) {
        array.clear();
        f = false;
        g = false;
        txtScreen.setText("0");
    }

    //Enter BTN:
    ;
    @FXML
    private void Enter(ActionEvent event) {
        array.add(Double.parseDouble(txtScreen.getText()));
        txtScreen.setText("0");
        if (g == true && f == true) {
            /*Cleans the prefix´s selection in case of wrong pressing*/
            f = true;
            g = true;
            lbPrefix.setText("");
            lbPrefix.setText("");
        }
    }

    //CLX Funtion BTN:
    @FXML
    private void CLX(ActionEvent event) {
        if (f == true) {
            STO stoClass = new STO();
            array.clear(); //Clean memory on the calculator
            txtScreen.setText("0");
            lbPrefix.setText("");
            f = false;
            stoClass.clearMemory(); //Clean the Calculator STO registers!
        } else {
            txtScreen.setText(""); //Clean only the textfield
        }
    }

    //Calculator btn´s Functions:
    ;
    @FXML
    public void btn(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String value = btn.getText();
        String current = txtScreen.getText();
        
        if (current.equals("0")) {
            txtScreen.setText(value); // Changes the initial 0
        } else {
            txtScreen.appendText(value);
        }
        if (value.equals("3") && g == true) {
            /* To calculate fatorial expressions */
            FuncoesMatematica funcoes = new FuncoesMatematica();
            funcoes.adicionarOperacao("n!");
            funcoes.adicionarNumero(array.get(0));
            funcoes.calcular();
            txtScreen.setText(Double.toString(funcoes.getResultado()));
            lbPrefix.setText("");
            
        } else if (sto == true) {
            /* Saving data with STO function: */
            STO stoClass = new STO();
            stoClass.STOInitialize();
            stoClass.STOSave(Integer.parseInt(value), Double.parseDouble(current));
            txtScreen.setText("");
            sto = false;
        } else if (rcl == true) {
            System.out.println("");
        }
    }
    
    @FXML
    private void stoBTN(ActionEvent event) {
        sto = true;
    }

    @FXML
    private void rclBTN(ActionEvent event) {
        rcl = true;
    }

    //Basic calculations:

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

    //Passing money interest information:
    ;
    @FXML
    public void nbtn(ActionEvent event) {
        n = Double.parseDouble(txtScreen.getText());
        txtScreen.setText("0");
        if (n == 0) {
            interest in = new interest();
            txtScreen.setText(in.calculateAmort(pv, i, fv));
        }
    }
    
    ;
    @FXML
    public void ibtn(ActionEvent event) {
        i = Double.parseDouble(txtScreen.getText());
        txtScreen.setText("0");
        if (i == 0) {
            interest in = new interest();
            txtScreen.setText(in.calculateTax(fv, pv, n)); //Put the result in the Screen
        }
    }
    
    ;
    @FXML
    public void pvbtn(ActionEvent event) {
        pv = Double.parseDouble(txtScreen.getText());
        txtScreen.setText("0");
        if (pv == 0) {
            interest in = new interest();
            txtScreen.setText(in.calculatePV(n, i, fv)); //Put the result in the Screen
        }
        
    }
    
    ;
    @FXML
    public void fvbtn(ActionEvent event) {
        fv = Double.parseDouble(txtScreen.getText());
        txtScreen.setText("0");
        if (fv == 0) {
            interest in = new interest();
            txtScreen.setText(in.calculateAmount(n, i, pv)); //Put the result in the Screen
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

    //Math functions:
    @FXML
    private void CHS(ActionEvent event) {
        /* To put negative numbers on the calculator */
        if (txtScreen.getText().equals("") || txtScreen.getText().equals("0") || txtScreen.getText().equals("0.00")) {
            txtScreen.setText("Error - no use");
        } else {
            FuncoesMatematica funcoes = new FuncoesMatematica();
            funcoes.adicionarOperacao("CHS");
            funcoes.adicionarNumero(Double.parseDouble(txtScreen.getText()));
            funcoes.calcular();
            txtScreen.setText(Double.toString(funcoes.getResultado()));
        }
    }
    
    @FXML
    private void exponencial(ActionEvent event) {
        FuncoesMatematica funcoes = new FuncoesMatematica();
        if (g == false) {
            funcoes.adicionarOperacao("^");
            funcoes.adicionarNumero(array.get(0)); //Base
            funcoes.adicionarNumero(Double.parseDouble(txtScreen.getText())); // Expoente
            funcoes.calcular();
            txtScreen.setText(Double.toString(funcoes.getResultado())); //Show the result on the screen

        } else if (g == true) {
            funcoes.adicionarOperacao("√"); //Inform operation
            funcoes.adicionarNumero(Double.parseDouble(txtScreen.getText())); //Pass the value
            funcoes.calcular();
            txtScreen.setText(Double.toString(funcoes.getResultado())); //Show the result on the screen
            array.add(funcoes.getResultado()); // add the result on the main array
            lbPrefix.setText("");
            g = false;
        }
    }
    
    @FXML
    private void btn1ByX(ActionEvent event) {
        FuncoesMatematica funcoes = new FuncoesMatematica();
        if (g == true) {
            /* To calculate the Euler´s exponential (e^x)*/
            funcoes.adicionarOperacao("e");
            funcoes.adicionarNumero(array.get(0));
            funcoes.calcular();
            txtScreen.setText(Double.toString(funcoes.getResultado()));
            lbPrefix.setText("");
            g = false;
        } else {
            /*To calculate the (1/x): */
            funcoes.adicionarNumero(array.get(0));
            funcoes.adicionarNumero(Double.parseDouble(txtScreen.getText()));
            funcoes.adicionarOperacao("numx");
            funcoes.calcular();
            txtScreen.setText(Double.toString(funcoes.getResultado()));
            array.add(funcoes.getResultado());
        }
    }
    
    @FXML
    private void TotalPercentage(ActionEvent event) {
        /* To calculate Neperian Logarithm and use the %T button*/
        FuncoesMatematica funcoes = new FuncoesMatematica();
        if (g == true) {
            funcoes.adicionarOperacao("ln");
            funcoes.adicionarNumero(Double.parseDouble(txtScreen.getText()));
            funcoes.calcular();
            txtScreen.setText(Double.toString(funcoes.getResultado()));
            lbPrefix.setText("");
            g = false;
        } else {
            System.out.println("%T");
        }
    }
    
    @FXML
    private void xy(ActionEvent event) {
        /* To invert the x and y on the calculator´s register */
        if (array.size() >= 2) {
            int x = 0;
            if (x == 0) {
                //case x has not been inverted yet:
                double temp = array.get(0);
                double temp2 = array.get(1);
                array.set(1, temp);
                array.set(0, temp2);
                txtScreen.setText(Double.toString(temp2));
                x = 1;
            } else {
                //case x has been moved:
                double temp = array.get(0);
                double temp2 = array.get(1);
                array.set(1, temp2);
                array.set(0, temp);
                txtScreen.setText(Double.toString(temp));
                x = 0;
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
}
