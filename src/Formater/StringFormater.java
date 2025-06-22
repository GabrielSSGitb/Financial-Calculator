package Formater;

import java.text.DecimalFormat;

public class StringFormater {
	public String value = "0";
	DecimalFormat df = new DecimalFormat(this.value);
	public void decimalFormater(String value) {
		if(value.equals("1")) {
			this.value = "0.0";
		}
	}
	public String formatNumber(String value) {
		return df.format(value);
	}
}
