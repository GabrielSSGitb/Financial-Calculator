<p align="center">
  <img src="./FinancialCalculator\src\images/Logo.png" alt="Logo do Projeto" width="300"/>
</p>


# 🧠 HP-12C Financial Calculator (JavaFX)

Simulação de uma calculadora financeira HP-12C desenvolvida em Java, utilizando JavaFX para interface gráfica. Este projeto permite realizar cálculos financeiros e matemáticos exatamente como na clássica HP-12C, incluindo operações com juros compostos, valor presente (PV), valor futuro (FV), pagamentos periódicos (PMT), taxa de juros (i) e número de períodos (n).

---

## 🚀 Funcionalidades

### ✔️ Operações Matemáticas:
- Soma
- Subtração
- Multiplicação
- Divisão
- Potência (xʸ)
- Raiz quadrada (√)
- Fatorial (n!)
- Logaritmo neperiano (ln)
- Exponencial (eˣ)
- Inverso (1/x)
- Troca de posições entre registradores (x↔y)
- Operador CHS (troca de sinal)

### ✔️ Operações Financeiras:
- Cálculo de **n** (número de períodos)
- Cálculo de **i** (taxa de juros)
- Cálculo de **PV** (valor presente)
- Cálculo de **FV** (valor futuro)
- Cálculo de **PMT** (valor das prestações)

### ✔️ Memória:
- Função **STO** (armazenar valores em registradores)
- Função **RCL** (recuperar valores dos registradores)
- Limpeza de registradores via **CLX + f**

### ✔️ Teclas especiais:
- **f** e **g** para acessar funções secundárias
- Prefixos e manipulação igual à calculadora real

---

## 🏗️ Estrutura do Projeto

src/
│
├── financialcalculator/ -> Arquivo principal (Controller do FXML)
│
├── FinancialClass/
│ └── interest.java -> Classe responsável pelos cálculos financeiros (FV, PV, PMT, n, i)
│
├── MathFunctions/
│ └── FuncoesMatematica.java -> Classe responsável pelas funções matemáticas (potência, fatorial, raiz, etc.)
│
├── memory/
│ └── STO.java -> Controle da memória (STO e RCL)
│
└── resources/ -> Arquivos FXML e imagens



---

## 💻 Tecnologias Utilizadas

- Java 17+ ☕
- JavaFX (FXML)
- Scene Builder (para interface)
- IDE recomendada: IntelliJ, Eclipse ou NetBeans

---

## 🔢 Fórmulas Financeiras Implementadas

### 📍 Valor das Prestações (PMT):
\[
PMT = \frac{PV \cdot i \cdot (1 + i)^n}{(1 + i)^n - 1}
\]

### 📍 Valor Futuro (FV):
\[
FV = PV \cdot (1 + i)^n + PMT \cdot \frac{(1 + i)^n - 1}{i}
\]

### 📍 Valor Presente (PV):
\[
PV = \frac{FV - PMT \cdot \frac{(1 + i)^n - 1}{i}}{(1 + i)^n}
\]

### 📍 Taxa de Juros (i):
- Calculado iterativamente (não possui fórmula fechada)

### 📍 Número de Períodos (n):
- Calculado por logaritmo:
\[
n = \frac{\ln(\frac{FV \cdot i + PMT}{PV \cdot i + PMT})}{\ln(1 + i)}
\]

---

## 📲 Como Executar o Projeto

1. Clone o repositório:
```bash
git clone https://github.com/seuusuario/hp12c-javafx.git

1 - Importe o projeto na sua IDE.

2 - Configure o JavaFX:

3 - Configure o caminho das bibliotecas do JavaFX.


🧠 Melhorias Futuras
Salvar os dados em JSON ou XML.

Implementar tema dark e tema light.

Criar um modo científico além do modo financeiro.

Implemetar cálculos estatísticos


🙌 Contribuição
Sinta-se livre para:

Reportar bugs

Sugerir melhorias

Fazer um fork e enviar Pull Requests


👨‍💻 Autor
Gabriel Santos Silva
📧 gabrielsantossilva10gtv@gmail.com

Equipe:

👨‍💻 - João Pedro de Almeida
👨‍💻 - Arthur
👨‍💻 - Estevan



