package Memory;


public class STO {

    public double[] reg = new double[10];

    public void STOSave(int index, double value) {
        this.reg[index] = value;
    }

    public double getRCL(int index) {
    	System.out.println(this.reg[index]);
        return this.reg[index];
    }

    public void clearMemory() {
        this.reg = new double[10]; // Manter o tamanho original
    }
}