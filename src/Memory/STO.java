package memory;

import java.util.HashMap;
import java.util.Map;

public class STO {

    private double[] registers = new double[9];
    private int exec = 0;
    public void STOInitialize() {
            if(this.exec == 0) {
                for(int i = 0; i < registers.length; i++) {
                    registers[i] = 0.00;
                }
                exec += 1;
            }
    }

    public void STOSave(int index, double current_value) {
        this.registers[index] = current_value;
        System.out.println(this.registers[index]);
        System.out.println(index);
    }

    public void clearMemory() {

    }
}
