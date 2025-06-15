<p align="center">
  <img src="./src/images/Logo.png" alt="Project Logo" width="300">
</p>

# 🧠 HP-12C Financial Calculator (JavaFX)

Simulation of an HP-12C financial calculator developed in Java, using JavaFX for the graphical interface. This project allows financial and mathematical calculations exactly like the classic HP-12C, including compound interest operations, present value (PV), future value (FV), payments (PMT), interest rate (i), and number of periods (n).

---

## 🚀 Features

### ✔️ Mathematical Operations:
- Addition
- Subtraction
- Multiplication
- Division
- Power (xʸ)
- Square root (√)
- Factorial (n!)
- Natural logarithm (ln)
- Exponential (eˣ)
- Inverse (1/x)
- Swap registers (x↔y)
- CHS operator (change sign)

### ✔️ Financial Operations:
- Calculate **n** (number of periods)
- Calculate **i** (interest rate)
- Calculate **PV** (present value)
- Calculate **FV** (future value)
- Calculate **PMT** (payment amount)

### ✔️ Memory Functions:
- **STO** (store values in registers)
- **RCL** (recall values from registers)
- Clear registers using **CLX + f**

### ✔️ Special Keys:
- **f** and **g** to access secondary functions
- Prefixes and handling just like the real HP-12C

---

## 🏗️ Project Structure

src/
│
├── financialcalculator/ -> Main file (FXML Controller)
│
├── FinancialClass/
│ └── interest.java -> Handles financial calculations (FV, PV, PMT, n, i)
│
├── MathFunctions/
│ └── FuncoesMatematica.java -> Handles mathematical functions (power, factorial, root, etc.)
│
├── memory/
│ └── STO.java -> Memory management (STO and RCL)
│
└── resources/ -> FXML files and images



---

## 💻 Technologies Used

- Java 17+ ☕
- JavaFX (FXML)
- Scene Builder (for UI design)
- Recommended IDEs: IntelliJ, Eclipse, or NetBeans

---


## 💻 Technologies Used

- Java 17+ ☕
- JavaFX (FXML)
- Scene Builder (for UI design)
- Recommended IDEs: IntelliJ, Eclipse, or NetBeans

---

## 🔢 Financial Formulas Implemented

### 📍 Payment (PMT):
\[
PMT = PV*i*(1+i)^n / (1 + i)^n - 1
\]

### 📍 Future Value (FV):
\[
FV = C(1 + i)^n
\]

### 📍 Present Value (PV):
\[
PV = FV/(1 + i)^n
\]

### 📍 Interest Rate (i):
\[
i = (FV/PV)^1/n - 1
\]

### 📍 Number of Periods (n):
\[
N = ln(FV/PV)/ln(1 + i)
\]

---

## 📲 How to Run the Project

1. Clone the repository:
```bash
git clone https://github.com/yourusername/hp12c-javafx.git


Import the project into your preferred IDE.

Configure JavaFX:

Download JavaFX SDK

Link JavaFX libraries to your project (VM Options and Build Path)

Run the project using the main class.




🧠 Future Improvements
Save data using JSON or XML.

Implement dark and light themes.

Add a scientific calculator mode.

Implement statistical calculations.



🙌 Contribution
Feel free to:

Report bugs

Suggest improvements

Fork the repository and submit Pull Requests



👨‍💻 Author
Gabriel Santos Silva
📧 gabrielsantossilva10gtv@gmail.com



Team:
👨‍💻 João Pedro de Almeida

👨‍💻 Arthur

👨‍💻 Estevan
