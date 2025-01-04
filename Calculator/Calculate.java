import java.util.*;

class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a mathematical expression (e.g., 10 + 20 * 3): ");
            String expression = sc.nextLine();

            try {
                int result = evaluateExpression(expression);
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.print("Do you want to continue? (yes/no): ");
            String choice = sc.nextLine();
            if (!choice.equalsIgnoreCase("yes")) break;
        }

        sc.close();
    }

    private static int evaluateExpression(String expression) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        StringTokenizer tokenizer = new StringTokenizer(expression, "+-*/%", true);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();

            if (token.isEmpty()) continue;

            if (isNumber(token)) {
                operands.push(Integer.parseInt(token));
            } else if (isOperator(token.charAt(0))) {
                while (!operators.isEmpty() && hasPrecedence(token.charAt(0), operators.peek())) {
                    performCalculation(operands, operators.pop());
                }
                operators.push(token.charAt(0));
            }
        }

        while (!operators.isEmpty()) {
            performCalculation(operands, operators.pop());
        }

        return operands.pop();
    }

    private static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }

    private static boolean hasPrecedence(char op1, char op2) {
        if ((op1 == '*' || op1 == '/' || op1 == '%') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }

    private static void performCalculation(Stack<Integer> operands, char operator) {
        if (operands.size() < 2) throw new IllegalArgumentException("Invalid expression");

        int b = operands.pop();
        int a = operands.pop();

        switch (operator) {
            case '+': operands.push(a + b); break;
            case '-': operands.push(a - b); break;
            case '*': operands.push(a * b); break;
            case '/': 
                if (b == 0) throw new ArithmeticException("Division by zero");
                operands.push(a / b); 
                break;
            case '%': 
                if (b == 0) throw new ArithmeticException("Modulo by zero");
                operands.push(a % b); 
                break;
            default: throw new IllegalArgumentException("Invalid operator");
        }
    }
}
