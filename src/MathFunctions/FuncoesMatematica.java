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
        if(operacoes.get(0).contains("√")) {
            resultado = Math.sqrt(resultado);
        }else if(operacoes.get(0).contains("^")) {
            resultado = Math.pow(resultado, numeros.get(1));
        }else if(operacoes.get(0).contains("numx")) {
            resultado = 1/numeros.get(1);
        }else if(operacoes.get(0).contains("1/x")) {
            System.out.println(numeros.toString());
            resultado = Math.pow(numeros.get(0), numeros.get(1));
        }else if(operacoes.get(0).contains("e")) {
            resultado = Math.pow(Math.E, numeros.get(0));
        }else if(operacoes.get(0).contains("ln")) {
            resultado = Math.log(numeros.get(0));
        }else if(operacoes.get(0).contains("CHS")) {
            resultado = -numeros.get(0);
        }else if(operacoes.get(0).contains("n!")) {
            if (resultado < 0 || resultado != Math.floor(resultado))
                        throw new ArithmeticException("Fatorial de número negativo ou não inteiro");
            resultado = fatorial((int) resultado);
        }

        /*for (int i = 0; i < operacoes.size(); i++) {
            double proximoNumero = i + 1 < numeros.size() ? numeros.get(i + 1) : 0;
            String op = operacoes.get(i);

            switch (op) {
                case "+":
                    resultado += proximoNumero;
                    break;
                case "-":
                    resultado -= proximoNumero;
                    break;
                case "*":
                    resultado *= proximoNumero;
                    break;
                case "/":
                    if (proximoNumero != 0)
                        resultado /= proximoNumero;
                    else
                        throw new ArithmeticException("Divisão por zero");
                    break;
                case "^":
                    resultado = Math.pow(resultado, proximoNumero);
                    break;
                case "√":
                    resultado = Math.sqrt(resultado);
                    break;
                case "1/x":
                    if (resultado != 0)
                        resultado = 1 / resultado;
                    else
                        throw new ArithmeticException("Divisão por zero");
                    break;
                case "10^x":
                    resultado = Math.pow(10, resultado);
                    break;
                case "e^x":
                    resultado = Math.exp(resultado);
                    break;
                case "ln":
                    if (resultado > 0)
                        resultado = Math.log(resultado);
                    else
                        throw new ArithmeticException("ln de número não positivo");
                    break;
                case "log":
                    if (resultado > 0)
                        resultado = Math.log10(resultado);
                    else
                        throw new ArithmeticException("log de número não positivo");
                    break;
                case "x²":
                    resultado = resultado * resultado;
                    break;
                case "CHS":
                    resultado = -resultado;
                    break;
                case "n!":
                    if (resultado < 0 || resultado != Math.floor(resultado))
                        throw new ArithmeticException("Fatorial de número negativo ou não inteiro");
                    resultado = fatorial((int) resultado);
                    break;
                case "π":
                    resultado = Math.PI;
                    break;
                case "EEX": 
                    resultado = resultado * Math.pow(10, proximoNumero);
                    break;
                case "x↔y":
                    if (numeros.size() >= 2) {
                        double temp = numeros.get(i);
                        numeros.set(i, numeros.get(i + 1));
                        numeros.set(i + 1, temp);
                        resultado = numeros.get(i);
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Operação inválida: " + op);
            }
        }

        numeros.clear();
        operacoes.clear();*/
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