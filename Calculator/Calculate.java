import java.util.*;

class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter the value a: ");
            int a = sc.nextInt();
            System.out.print("Enter the operation (character- '+','-','*','%','/'): ");
            char op = sc.next().charAt(0);
            System.out.print("Enter the value b: ");
            int b = sc.nextInt();
            
            try {
                int result = performOperation(a, b, op);
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
            
            System.out.print("Do you want to continue? (yes/no): ");
            String choice = sc.next();
            if (!choice.equalsIgnoreCase("yes")) break;
        }
        
        sc.close();
    }

    static int performOperation(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': 
                if (b == 0) throw new ArithmeticException("Division by zero");
                return a / b;
            case '%': 
                if (b == 0) throw new ArithmeticException("Modulo by zero");
                return a % b;
            default: throw new IllegalArgumentException("Invalid operator");
        }
    }
}
