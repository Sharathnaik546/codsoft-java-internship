import java.util.Scanner;

// Bank Account Class
class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else {
            balance -= amount;
            System.out.println("Amount withdrawn successfully.");
        }
    }

    // Check Balance
    public double getBalance() {
        return balance;
    }
}

// ATM Class
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void showMenu() {
        System.out.println("\n=== ATM MENU ===");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }
}

// Main Class
public class ATMInterface {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount userAccount = new BankAccount(1000); // initial balance
        ATM atm = new ATM(userAccount);

        int choice;

        do {
            atm.showMenu();

            // input validation
            while (!sc.hasNextInt()) {
                System.out.print("Enter a valid choice: ");
                sc.next();
            }

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    userAccount.withdraw(withdrawAmount);
                    break;

                case 3:
                    System.out.println("Current Balance: " + userAccount.getBalance());
                    break;

                case 4:
                    System.out.println("Thank you for using ATM!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 4);

        sc.close();
    }
}