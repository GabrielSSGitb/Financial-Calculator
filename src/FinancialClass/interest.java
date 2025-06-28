package FinancialClass;


public class interest {
   
	public double amount = 0.00;
	
   public double calculateAmount(Double n, Double i, Double pv) {
       /*To calculate amount: M = C(1 + i)^n*/
       amount = pv * Math.pow(1 + i, n);
       return this.amount;
   };
   public double calculatePV(Double n, Double i, Double fv) {
       /* To calculate Present Values: PV = FV/(1 + i)^n*/
       amount = fv/Math.pow((1 + i), n);
       return this.amount;
   }
   public double calculateAmort(Double pv, Double i, Double fv) {
       /* To calculate Amorts: N = ln(FV/PV)/ln(1 + i)*/
       return Math.log(fv/pv)/Math.log(1 + i);
   }
   public double calculateTax(Double fv, Double pv, Double n) {
       /*To Calculate Tax: i = (FV/PV)^1/n - 1*/
       return Math.pow(fv/pv, 1/n) - 1;
   }
   public double calculatePMT(Double pv, Double i, Double n) {
        /*PMT = PV*i*(1+i)^n / (1 + i)^n - 1 */
        double fator = Math.pow(1 + i, n);
        double pmt = (pv * i * fator) / (fator - 1);
        return pmt;
    }
   public double calculateFVWithPMT(Double pv, Double i, Double n, Double pmt) {
        double fator = Math.pow(1 + i, n);
        double fv = (pv * fator) + (pmt * (fator - 1) / i);
        return fv;
   }}
