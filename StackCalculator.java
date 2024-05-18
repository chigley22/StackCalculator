import java.util.Stack;

public class StackCalculator {
    private Stack<Double> calculator;
    private String command;

    public StackCalculator() {
        calculator = new Stack<>();
    }

    public void displayWelcomeMessage() {
        System.out.println("Welcome to the Stack Calculator!");
    }

    public void displayCommands() {
        System.out.println("Commands: push n, add, sub, mult, div, list, clear, or quit");
    }

    public void push(double value) {
        calculator.push(value);
        command = "push " + value;
        System.out.println(getValues());
    }

    public double pop() {
        if (!calculator.isEmpty()) {
            command = "pop";
            return calculator.pop();
        }
        System.out.println(getValues());
        System.out.println("Error: Stack is empty.");
        return Double.NaN; 
    }

    public int size() {
        return calculator.size();
    }

    public String getValues() {
        if (calculator.isEmpty()) {
            return "empty";
        }
        StringBuilder sb = new StringBuilder();
        for (Double value : calculator) {
            sb.append(value).append("\n");
        }
        return sb.toString();
    }


    public void listStack() {
        if (calculator.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println(getValues());
        }
    }
    
    public void clearStack() {
        calculator.clear();
        command = "clear";
    }

    public double add() {
        if (calculator.size() >= 2) {
            double a = calculator.pop();
            double b = calculator.pop();
            double result = a + b;
            calculator.push(result);
            command = "add";
            System.out.println(getValues());
            return result;
        }
        
        System.out.println("Error: Not enough elements on the stack.");
        return Double.NaN; 
    }

    public double sub() {
        if (calculator.size() >= 2) {
            double a = calculator.pop();
            double b = calculator.pop();
            double result = a - b;
            calculator.push(result);
            command = "sub";
            System.out.println(getValues());
            return result;
        }
        System.out.println(getValues());
        System.out.println("Error: Not enough elements on the stack.");
        return Double.NaN;
    }

    public double mult() {
        if (calculator.size() >= 2) {
            double a = calculator.pop();
            double b = calculator.pop();
            double result = a * b;
            calculator.push(result);
            command = "mult";
            System.out.println(getValues());
            return result;
        }
        System.out.println(getValues());
        System.out.println("Error: Not enough elements on the stack.");
        return Double.NaN; 
    }

    public double div() {
        if (calculator.size() >= 2) {
            double a = calculator.pop();
            double b = calculator.pop();
            if (b != 0) {
                double result = b / a;
                calculator.push(result);
                command = "div";
                System.out.println(getValues());
                return result;
            }
            System.out.println("Error: Division by zero.");
            calculator.push(b); 
            calculator.push(a); 
            return Double.NaN; 
        }
        System.out.println(getValues());
        System.out.println("Error: Not enough elements on the stack.");
        return Double.NaN; 
    }
}
