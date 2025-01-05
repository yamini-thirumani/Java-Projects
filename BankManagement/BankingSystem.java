import java.util.HashMap;
import java.util.Scanner;

class BankAccount {
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn ₹" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }
}

public class BankingSystem {
    private static HashMap<Integer, BankAccount> accounts = new HashMap<>();
    private static int accountIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Simple Banking System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    depositMoney(scanner);
                    break;
                case 3:
                    withdrawMoney(scanner);
                    break;
                case 4:
                    checkBalance(scanner);
                    break;
                case 5:
                    System.out.println("Thank you for using the banking system!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void createAccount(Scanner scanner) {
        System.out.print("Enter your name: ");
        scanner.nextLine(); // Consume newline
        String name = scanner.nextLine();
        System.out.print("Enter initial deposit: ₹");
        double initialDeposit = scanner.nextDouble();

        BankAccount newAccount = new BankAccount(name, initialDeposit);
        accounts.put(accountIdCounter, newAccount);
        System.out.println("Account created successfully! Your account ID is " + accountIdCounter);
        accountIdCounter++;
    }

    private static void depositMoney(Scanner scanner) {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        if (accounts.containsKey(accountId)) {
            System.out.print("Enter amount to deposit: ₹");
            double amount = scanner.nextDouble();
            accounts.get(accountId).deposit(amount);
        } else {
            System.out.println("Invalid account ID!");
        }
    }

    private static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        if (accounts.containsKey(accountId)) {
            System.out.print("Enter amount to withdraw: ₹");
            double amount = scanner.nextDouble();
            accounts.get(accountId).withdraw(amount);
        } else {
            System.out.println("Invalid account ID!");
        }
    }

    private static void checkBalance(Scanner scanner) {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        if (accounts.containsKey(accountId)) {
            BankAccount account = accounts.get(accountId);
            System.out.println("Account Holder: " + account.getAccountHolderName());
            System.out.println("Balance: ₹" + account.getBalance());
        } else {
            System.out.println("Invalid account ID!");
        }
    }
}
