package financialcalculator;

import FinancialClass.interest;
import Formater.StringFormater;
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
import Memory.STO;
import Statistics.Statistics;
/**
 *
 * @author gabri
 */
public class FXMLDocumentController implements Initializable {
	//Calling objects:
    ArrayList<Double> array = new ArrayList<>(); //Creating an arrayList for register memory
    StringFormater sf = new StringFormater();
    Statistics st = new Statistics();
    STO stoClass = new STO();
    //Values saving and variables declarations:
    private double result;
    private int decimalPoint = 0;
    private int sumCounter = 0;
    private int stoCounter = 0;
    private boolean sto = false;
    private boolean rcl = false;
    private boolean f = false;
    private boolean g = false;
    //For financial calculations:
    private Double i = 0.00;
    private Double n = 0.00;
    private Double pv = 0.00;
    private Double fv = 0.00;
    private Double pmt = 0.00;

    //FXML imports:
    @FXML
    private TextField txtScreen;
    @FXML
    private Label lbPrefix;

    //Basic functions:
    @FXML
    public void btnF(ActionEvent event) {
        f = true;
        lbPrefix.setText("f");
        /* If the variable equals 1 - and on CLX press = f helps to clean the input and array */
    }
    
    @FXML
    public void btnG(ActionEvent event) {
        g = true;
        lbPrefix.setText("g");
        /* To informe if the g function is being used */
    }
    
    @FXML
    public void btnOn(ActionEvent event) {
        array.clear();
        f = false;
        g = false;
        setText(0.00);
    }

    //Enter BTN:
    ;
    @FXML
    public void Enter(ActionEvent event) {
        array.add(Double.parseDouble(txtScreen.getText()));
        setText(0.00);
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
    public void CLX(ActionEvent event) {
        if (f == true) {
            array.clear(); //Clean memory on the calculator
            setText(0.00);
            lbPrefix.setText("");
            f = false;
            stoClass.clearMemory(); //Clean the Calculator STO registers!
        } else {
            txtScreen.setText(""); //Clean only the textfield
        }
    }
    @FXML
    public void SST(ActionEvent event) {
    	if(f == true) {
    		//For clening the sum memory array:
    		st.clearArray();
    		setText(0.00);
    		lbPrefix.setText("");
    		sumCounter = 0;
    		f = false;
    		g = false;
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
            stoClass.STOSave(Integer.parseInt(value), array.get(stoCounter)); //Pass the index and value to store on the class
            txtScreen.setText("0");
            stoCounter++; // Updates the array index
            sto = false;
        } else if (rcl == true) {
               /* To get data stored in the calculator: */
               txtScreen.setText(Double.toString(stoClass.getRCL(Integer.parseInt(current))));
                rcl = false;
        
        }else if(value.equals("0") && g == true) {
        	txtScreen.setText("");
        	lbPrefix.setText("");
        	simpleAVG();
        }else if(value.equals("6") && g == true) {
        	txtScreen.setText("");
        	lbPrefix.setText("");
        	evaluatedAVG();
        }else if(f == true && value != "") {
        	txtScreen.setText("");
        	decimalPoint = Integer.parseInt(value);
        	setText(Double.parseDouble(current));
        	txtScreen.setText(sf.decimalFormater(Double.parseDouble(txtScreen.getText()), decimalPoint));
        	lbPrefix.setText("");
        	f = false;
        }
        
    }
    @FXML
    public void setText(double number) {
    	txtScreen.setText(sf.getFormatedNumber(number));
    }
    @FXML
    public void stoBTN(ActionEvent event) {
        sto = true;
        array.add(Double.parseDouble(txtScreen.getText())); //Save the value on the array temporarily
    }

    @FXML
    public void rclBTN(ActionEvent event) {
        rcl = true;
    }

    //Basic calculations:

    ;
    @FXML
    public void addUp(ActionEvent event) {
        //Addup calculating:
        result = 0;
        for (int i = 0; i < array.size(); i++) {
            result += array.get(i);
        };
        array.clear(); //Clean the array
        array.add(result); //Update value on the array
        setText(result);
    }
    
    ;
    @FXML
    public void subtraction(ActionEvent event) {
        result = array.get(0); //Get the first value of the array
        array.remove(0); // Remove from the array the first value
        for (int i = 0; i < array.size(); i++) {
            result -= array.get(i);
        };
        array.clear();
        array.add(result);
        setText(result);
    }
    
    ;
    @FXML
    public void multiplication(ActionEvent event) {
        //Multi
        result = 1;
        for (int i = 0; i < array.size(); i++) {
            result *= array.get(i);
        };
        array.clear();
        array.add(result);
        setText(result);
    }
    
    ;
    @FXML
    public void division(ActionEvent event) {
        //
        result = array.get(0);
        array.remove(0);
        for (int i = 0; i < array.size(); i++) {
            result /= array.get(i);
        }
        array.clear();
        array.add(result);
        setText(result);
    }

    //Passing money interest information:
    ;
    @FXML
    public void nbtn(ActionEvent event) {
        n = Double.parseDouble(txtScreen.getText());
        txtScreen.setText("0");
        if (n == 0) {
            interest in = new interest();
            setText(in.calculateAmort(pv, i, fv));
        }
    }
    
    ;
    @FXML
    public void ibtn(ActionEvent event) {
        i = Double.parseDouble(txtScreen.getText());
        txtScreen.setText("0");
        if (i == 0) {
            interest in = new interest();
            setText(in.calculateTax(fv, pv, n)); //Put the result in the Screen
        }
    }
    
    ;
    @FXML
    public void pvbtn(ActionEvent event) {
        pv = Double.parseDouble(txtScreen.getText());
        txtScreen.setText("0");
        if (pv == 0) {
            interest in = new interest();
            setText(in.calculatePV(n, i, fv)); //Put the result in the Screen
        }
        
    }
    
    ;
    @FXML
    public void fvbtn(ActionEvent event) {
        fv = Double.parseDouble(txtScreen.getText());
        setText(0.00);
        if (fv == 0) {
            interest in = new interest();
            setText(in.calculateAmount(n, i, pv)); //Put the result in the Screen
        }else if(pmt != 0) {
            interest in = new interest();
            setText(in.calculateFVWithPMT(pv, i, n, pmt));
        }
    }
    @FXML
    public void PMTbtn(ActionEvent event) {
        pmt = Double.parseDouble(txtScreen.getText());
        setText(0.00);
        if (pmt == 0) {
            interest in = new interest();
            setText(in.calculatePMT(pv, i, n)); //Put the result in the Screen
        }
        
    }
    ;
    @FXML
    private void dot(ActionEvent event) {
        //Put the point on decimal values in the textField
        if (!txtScreen.getText().contains(".")) {
            txtScreen.appendText(".");
        }else if(g == true) {
        	deviationBTN();
        	g = false;
        }
    }

    //Math functions:
    @FXML
    public void CHS(ActionEvent event) {
        /* To put negative numbers on the calculator */
        if (txtScreen.getText().equals("")) {
            txtScreen.setText("Error - no use");
        } else {
            FuncoesMatematica funcoes = new FuncoesMatematica();
            funcoes.adicionarOperacao("CHS");
            funcoes.adicionarNumero(Double.parseDouble(txtScreen.getText()));
            funcoes.calcular();
            setText(funcoes.getResultado());
        }
    }
    
    @FXML
    public void exponencial(ActionEvent event) {
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
    public void btn1ByX(ActionEvent event) {
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
    public void TotalPercentage(ActionEvent event) {
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
    public void xy(ActionEvent event) {
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
    //To call statistical methods:
    @FXML
    public void sum(ActionEvent event) {
    	if(g == false) {
    		sumCounter++;
        	st.positiveSum(Double.parseDouble(txtScreen.getText()));
        	lbPrefix.setText(Integer.toString(sumCounter));
        	txtScreen.setText("0");
    	}else {
    		g = false;
    		lbPrefix.setText("");
    		st.removesimpleAVG(Double.parseDouble(txtScreen.getText()));
    	}
    }
    @FXML
    public void removeNumInSUM() {
    	txtScreen.setText("Okay!!");
    }
    @FXML
    public void simpleAVG() {
    	txtScreen.setText(Double.toString(st.avg()));
    	g = false;
    }
    @FXML
    public void deviationBTN() {
    	txtScreen.setText(Double.toString(st.deviation()));
    	lbPrefix.setText("");
    	g = false;
    	f = false;
    }
    @FXML
    public void evaluatedAVG() {
    	for(int i = 0; i < array.size(); i++) {
    		st.evaluateAVG(array.get(i));
    	}
    	txtScreen.setText(Double.toString(st.evaluatedAVGRESULT()));
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
}
