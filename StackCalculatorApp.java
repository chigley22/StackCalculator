import java.util.Scanner;

public class StackCalculatorApp {
    public static void main(String[] args) {
        StackCalculator calculator = new StackCalculator();
        Scanner scanner = new Scanner(System.in);
        String input;

        calculator.displayWelcomeMessage();
        calculator.displayCommands();

        while (true) {
            System.out.print("\nstack> ");
            input = scanner.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0];

            switch (command.toLowerCase()) {
                case "push":
                    if (parts.length == 2) {
                        try {
                            double value = Double.parseDouble(parts[1]);
                            calculator.push(value);
                        } catch (NumberFormatException e) {
                            System.out.println("Unrecognized command.");
                        }
                    } else {
                        System.out.println("Unrecognized command.");
                    }
                    break;

                case "add":
                    double addResult = calculator.add();
                    if (!Double.isNaN(addResult)) {
                    }
                    break;

                case "sub":
                    double subResult = calculator.sub();
                    if (!Double.isNaN(subResult)) {
                    }
                    break;

                case "mult":
                    double multResult = calculator.mult();
                    if (!Double.isNaN(multResult)) {
                    }
                    break;

                case "div":
                    double divResult = calculator.div();
                    if (!Double.isNaN(divResult)) {
                    }
                    break;

                case "clear":
                    calculator.clearStack();
                    System.out.println("Empty.");
                    break;

                case "list":
                    calculator.listStack();
                    break;

                case "quit":
                    System.out.println("Thanks for using the Stack Calculator.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Unknown command.");
                    calculator.displayCommands();
                    break;
            }
        }
    }
}

