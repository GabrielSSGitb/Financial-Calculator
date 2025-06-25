package Formater;

import java.text.DecimalFormat;

public class StringFormater {
	public String value = "0";
	public String sFormated;
	DecimalFormat df = new DecimalFormat(this.value);
	
	public void decimalFormater(String value) {
		if(value.equals("1")) {
			this.value = "0.0";
			System.out.println("0.0");
		}
	}
	public void formatNumber(String value) {
		this.sFormated = df.format(value);
		System.out.println(this.sFormated);
	}
	public String getFormatNumber() {
		return this.sFormated;
	}
}
