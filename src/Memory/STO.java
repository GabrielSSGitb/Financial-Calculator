package memory;

import java.util.HashMap;
import java.util.Map;


public class STO {
    private Map<Integer, Double> registers = new HashMap<>();
    
      public void STOSave(int num, Double current_value) {
          registers.put(num, current_value);
          System.out.println(registers);
      }
      public void clearMemory() {
          registers.clear();
          System.out.println(registers);
      }
   /* private Stack<Double> rpnStack;
    private Map<Integer, Double> registers;

    public STO() {
        rpnStack = new Stack<>();
        registers = new HashMap<>();
        for (int i = 0; i <= 9; i++) { // Inicializa os registradores de 0 a 9
            registers.put(i, 0.0);
        }
    }

    // ... outros métodos (enter, display, rcl, etc.) ...

   
    public void sto(int registerNumber) {
        if (rpnStack.isEmpty()) {
            System.out.println("Erro: Pilha vazia. Nada para armazenar."); // Mensagem para console
            return;
        }
        double valueToStore = rpnStack.peek(); // Pega o valor do topo da pilha SEM REMOVER
        registers.put(registerNumber, valueToStore); // Armazena o valor no registrador
        System.out.println("Armazenado " + valueToStore + " no registrador "
                + "[" + registerNumber + "]"); // Mensagem para console
    }
*/
}