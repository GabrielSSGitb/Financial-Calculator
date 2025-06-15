package memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class STO {

    public double[] reg = new double[10];

    public void STOSave(int index, double value) {
        this.reg[index] = value;
    }

    public double getRCL(int index) {
        return this.reg[index];
    }

    public void clearMemory() {
        for(int i = 0; i < this.reg.length; i++) {
            reg[i] = 0.00;
        }
        this.reg = new double[0];
    }
}
