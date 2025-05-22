package FinancialClass;

public class interest {
    private int[] variables = new int[4];
    
    public void instruction(int i, int function) {
        this.variables[i] = function;
        System.out.println(function);
        System.out.println(i);
    }
}
