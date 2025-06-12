package MathFunctions;

import java.util.ArrayList;

public class FuncoesMatematica {
    private ArrayList<Double> numeros = new ArrayList<>();
    private ArrayList<String> operacoes = new ArrayList<>();
    private double resultado;

    public void adicionarNumero(double numero) {
        numeros.add(numero);
    }

    public void adicionarOperacao(String operacao) {
        operacoes.add(operacao);
    }

    public void calcular() {
        if (numeros.isEmpty()) {
            resultado = 0;
            return;
        }

        resultado = numeros.get(0);
        //To verify with function it must do:
        if(operacoes.get(0).contains("√")) {
            resultado = Math.sqrt(resultado); //SQRT
        }else if(operacoes.get(0).contains("^")) {
            resultado = Math.pow(resultado, numeros.get(1)); //Exponential
        }else if(operacoes.get(0).contains("numx")) {
            resultado = 1/numeros.get(1); // 1/x where g = 1
        }else if(operacoes.get(0).contains("1/x")) {
            resultado = Math.pow(numeros.get(0), numeros.get(1)); // 1/x
        }else if(operacoes.get(0).contains("e")) {
            resultado = Math.pow(Math.E, numeros.get(0)); //e^x
        }else if(operacoes.get(0).contains("ln")) {
            resultado = Math.log(numeros.get(0)); //ln and logs
        }else if(operacoes.get(0).contains("CHS")) {
            resultado = -numeros.get(0);
        }else if(operacoes.get(0).contains("n!")) {
            /* To calculate fatorial expressions:*/
            if (resultado < 0 || resultado != Math.floor(resultado))
                        throw new ArithmeticException("Fatorial de número negativo ou não inteiro");
            resultado = fatorial((int) resultado);
        }
    }

    public double getResultado() {
        return resultado;
    }

    private double fatorial(int n) {
        if (n == 0 || n == 1) return 1;
        double fat = 1;
        for (int i = 2; i <= n; i++) fat *= i;
        return fat;
    }
    }