package FinancialClass;

import java.text.DecimalFormat;

public class interest {
    DecimalFormat df = new DecimalFormat("0.00"); //To format the decimal values
    private Double amount = 0.00;
   public String calculateAmount(Double n, Double i, Double pv) {
       /*To calculate amount: M = C(1 + i)^n*/
       amount = pv * Math.pow(1 + i, n);
       return df.format(this.amount);
   };
}
