import java.util.*;

class Calculate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Basic Calculator");
        System.out.print("Enter the value a : ");
        int a = sc.nextInt();
        System.out.print("Enter the value b : ");
        int b = sc.nextInt();
        System.out.print("Enter the operation (character- '+','-','*','%','/') : ");
        String op = sc.next();
        char ch = op.charAt(0);
        
        switch (ch) {
            case '+': System.out.println("Addition of " + a + " and " + b + " = " + (a + b));
                      break;
            case '-': System.out.println("Subtraction of " + a + " and " + b + " = " + (a - b));
                      break;
            case '*': System.out.println("Product of " + a + " and " + b + " = " + (a * b));
                      break;
            case '/': 
                      if (b != 0) {
                          System.out.println("Division of " + a + " and " + b + " = " + (a / b));
                      } else {
                          System.out.println("Error: Division by zero is not allowed.");
                      }
                      break;
            case '%': 
                      if (b != 0) {
                          System.out.println("Modulo of " + a + " and " + b + " = " + (a % b));
                      } else {
                          System.out.println("Error: Modulo by zero is not allowed.");
                      }
                      break;
            default: 
                System.out.println("Enter a Valid Character/Operator.");
        }
    }
}
