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
   public String calculatePV(Double n, Double i, Double fv) {
       /* To calculate Present Values: PV = FV/(1 + i)^n*/
       amount = fv/Math.pow((1 + i), n);
       return df.format(this.amount);
   }
   public String calculateAmort(Double pv, Double i, Double fv) {
       /* To calculate Amorts: N = ln(FV/PV)/ln(1 + i)*/
       return df.format(Math.log(fv/pv)/Math.log(1 + i));
   }
   public String calculateTax(Double fv, Double pv, Double n) {
       /*To Calculate Tax: i = (FV/PV)^1/n - 1*/
       return df.format(Math.pow(fv/pv, 1/n) - 1);
   }
}
