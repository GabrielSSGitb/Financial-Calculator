package Formater;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class StringFormater {
	ArrayList<Double> tempArray = new ArrayList<>();
	DecimalFormat df = new DecimalFormat();
	
	//To format the decimal values according to the user´s choice:
	public String decimalFormater(double number, int decimalPoint) {
			if(decimalPoint == 0) {
				this.df = new DecimalFormat("0");
			}else if(decimalPoint == 1) {
				this.df = new DecimalFormat("0.0");
			}else if(decimalPoint == 2) {
				this.df = new DecimalFormat("0.00");
			}else if(decimalPoint == 3) {
				this.df = new DecimalFormat("0.000");
			}else if(decimalPoint == 4) {
				this.df = new DecimalFormat("0.0000");
			}else if(decimalPoint == 5) {
				this.df = new DecimalFormat("0.00000");
			}else if(decimalPoint == 6) {
				this.df = new DecimalFormat("0.000000");
			}else if(decimalPoint == 7) {
				this.df = new DecimalFormat("0.0000000");
			}else if(decimalPoint == 8) {
				this.df = new DecimalFormat("0.00000000");
			}else if(decimalPoint == 9) {
				this.df = new DecimalFormat("0.000000000");
			}
			return this.df.format(number);
		}
	public String getFormatedNumber(double number) {
		return this.df.format(number);
	}
}
