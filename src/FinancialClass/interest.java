package FinancialClass;

public class interest {
    private Double amount = 0.00;
   public Double calculateAmount(Double n, Double i, Double pv) {
       /*To calculate amount: M = C(1 + i)^n*/
       amount = Math.pow(pv*(i+1),n);
       return this.amount;
   };
}
