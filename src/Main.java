import java.util.Scanner;
public class Main {
    /**
     * Scanner for input elements.
     */
    private static Scanner scanner  = new Scanner(System.in);
    /**
     * main method in class Main for solve common task.
     * @param args
     */
    public static void main(String[] args) {
        final int min = 1;
        final  int max = 50;
        Main main = new Main();
        CalculatorType type = main.readCalculator();
        Calculator calculator;
        switch (type) {
            case INTEGER:
                calculator = new IntegerCalculator();
                break;
            case DOUBLE:
                calculator = new DoubleCalculator();
                break;
            case STRING:
                calculator = new StringCalculator();
                break;
            default:
                main.reportFatalError("Wrong calculator type");
                return;
        }
        int readCommand =  main.readCommand();
        if (readCommand >= min  && readCommand <= max) {
            while (readCommand > 0) {
                String operation = scanner.nextLine();
                String[] elements = operation.split(" ");
                String num1 = elements[1];
                String num2 = elements[2];
                OperationType operationType = main.parseOperation(elements[0]);
                String response;
                switch (operationType) {
                    case ADDITION:
                        response = calculator.add(num1, num2);
                        System.out.println(response);
                        break;
                    case SUBTRACTION:
                        response = calculator.subtract(num1, num2);
                        System.out.println(response);
                        break;
                    case MULTIPLICATION:
                        response = calculator.multiply(num1, num2);
                        System.out.println(response);
                        break;
                    case DIVISION:
                        response = calculator.divide(num1, num2);
                        System.out.println(response);
                        break;
                    default:
                        response = "Wrong operation type";
                        main.reportFatalError(response);
                        break;
                }
                readCommand -= 1;
            }
        } else {
            main.reportFatalError("Amount of commands is Not a Number");
        }
    }
    private CalculatorType readCalculator() {
        CalculatorType calculatorType;
        String t = scanner.nextLine();
        switch (t) {
            case "INTEGER":
                calculatorType = CalculatorType.INTEGER;
                break;
            case "DOUBLE":
                calculatorType = CalculatorType.DOUBLE;
                break;
            case "STRING":
                calculatorType = CalculatorType.STRING;
                break;
            default:
                calculatorType = CalculatorType.INCORRECT;
                break;
        }
        return calculatorType;
    }
    private int readCommand() {
        String s = scanner.nextLine();
        try {
            int r = Integer.parseInt(s);
            return r;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private OperationType parseOperation(String operation) {
        OperationType operationType;
        switch (operation.charAt(0)) {
            case '+':
                operationType = OperationType.ADDITION;
                break;
            case '-':
                operationType = OperationType.SUBTRACTION;
                break;
            case '*':
                operationType = OperationType.MULTIPLICATION;
                break;
            case '/':
                operationType = OperationType.DIVISION;
                break;
            default:
                operationType = OperationType.INCORRECT;
                break;
        }
        return operationType;
    }
    private void reportFatalError(String err) {
        System.out.println(err);
    }
}

/**
 * enum for any types of calculator.
 */
enum CalculatorType {
    /**
     * INTEGER.
     */
    INTEGER,
    /**
     * DOUBLE.
     */
    DOUBLE,
    /**
     * STRING.
     */
    STRING,
    /**
     * INCORRECT.
     */
    INCORRECT
}
/**
 * enum for any types of operations.
 */
enum OperationType {
    /**
     * ADDITION.
     */
    ADDITION,
    /**
     * SUBTRACTION.
     */
    SUBTRACTION,
    /**
     * MULTIPLICATION.
     */
    MULTIPLICATION,
    /**
     * DIVISION.
     */
    DIVISION,
    /**
     * INCORRECT.
     */
    INCORRECT
}

/**
 * This abstract class by called Calculator.
 */
abstract class Calculator {
    public abstract String add(String a, String b);
    public abstract String subtract(String a, String b);
    public abstract String multiply(String a, String b);
    public abstract String divide(String a, String b);
}

/**
 * This class by called IntegerCalculator extends by Calculator
 * consists all operations for solving this assignment.
 */
class IntegerCalculator extends Calculator {
    public String add(String a, String b) { // This method check input on integer and execute addition
        try {
            int n1 = Integer.parseInt(a);
            int n2 = Integer.parseInt(b);
            int res = n1 + n2;
            return Integer.toString(res);
        } catch (NumberFormatException e) {
            return "Wrong argument type";
        }

    }
    public String subtract(String a, String b) { // This method check input on integer and execute subtraction
        try {
            int n1 = Integer.parseInt(a);
            int n2 = Integer.parseInt(b);
            int res = n1 - n2;
            return Integer.toString(res);
        } catch (NumberFormatException e) {
            return "Wrong argument type";
        }
    }
    public String multiply(String a, String b) { // This method check input on integer and execute multiplication
        try {
            int n1 = Integer.parseInt(a);
            int n2 = Integer.parseInt(b);
            int res = n1 * n2;
            return Integer.toString(res);
        } catch (NumberFormatException e) {
            return "Wrong argument type";
        }
    }
    public String divide(String a, String b) { // This method check input on integer and execute division
        try {
            int n1 = Integer.parseInt(a);
            int n2 = Integer.parseInt(b);
            if (n2 == 0) {
                return "Division by zero";
            } else {
                int res = n1 / n2;
                return Integer.toString(res);
            }
        } catch (NumberFormatException e) {
            return "Wrong argument type";
        }
    }
}

/**
 * This class by called DoubleCalculator extends by Calculator
 * consists all operations for solving this assignment.
 */
class DoubleCalculator extends Calculator {
    public String add(String a, String b) { // This method check on double and execute addition
        try {
            double n1 = Double.parseDouble(a);
            double n2 = Double.parseDouble(b);
            double  res = n1 + n2;
            return Double.toString(res);
        } catch (NumberFormatException e) {
            return "Wrong argument type";
        }
    }
    public String subtract(String a, String b) { // This method check on double and execute subtraction
        try {
            double n1 = Double.parseDouble(a);
            double n2 = Double.parseDouble(b);
            double  res = n1 - n2;
            return Double.toString(res);
        } catch (NumberFormatException e) {
            return "Wrong argument type";
        }
    }
    public String multiply(String a, String b) { // This method check on double and execute multiplication
        try {
            double n1 = Double.parseDouble(a);
            double n2 = Double.parseDouble(b);
            double  res = n1 * n2;
            return Double.toString(res);
        } catch (NumberFormatException e) {
            return "Wrong argument type";
        }
    }
    public String divide(String a, String b) { // This method check on double and execute division
        try {
            double n1 = Double.parseDouble(a);
            double n2 = Double.parseDouble(b);
            if (n2 == 0.0) {
                return "Division by zero";
            } else {
                double res = n1 / n2;
                return Double.toString(res);
            }
        } catch (NumberFormatException e) {
            return "Wrong argument type";
        }
    }
}
/**
 * This class by called StringCalculator extends by Calculator
 * consists all operations for solving this assignment.
 */
class StringCalculator extends Calculator {
    public String add(String a, String b) { // This method execute addition for strings
        return a + b;
    }
    public String subtract(String a, String b) { // This method return invalid output for strings
        return "Unsupported operation for strings";
    }
    public String multiply(String a, String b) { // This method execute multiply for strings
        try {
            int n1 = Integer.parseInt(b);
            if (n1 <= 0) {
                return "Wrong argument type";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < n1; i++) {
                    stringBuilder.append(a);
                }
                return stringBuilder.toString();
            }
        } catch (NumberFormatException e) {
            return "Wrong argument type";
        }
    }
    public String divide(String a, String b) { // This method return invalid output for strings
        return "Unsupported operation for strings";
    }
}
