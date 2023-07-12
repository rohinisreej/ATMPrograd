import java.sql.SQLOutput;
import java.util.Scanner;
class InsufficientFundsException  extends  Exception{
    public InsufficientFundsException(String output){
        System.out.println(output);
    }

}
class InvalidAmountException  extends  Exception{
    public InvalidAmountException(String output){
        System.out.println(output);
    }

}
class ATM{
    private double balance;

    public ATM() {
        balance = 3000;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Current balance: Rs" + balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Invalid amount");
        }

        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds. Current balance: Rs" + balance);
        }

        balance -= amount;
        System.out.println("Withdrawal successful. Current balance: Rs" + balance);
    }


}

public class Main {
    public static void main(String[] args) {
        ATM rose = new ATM();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter 1 for deposit \nEnter 2 for withdraw \nEnter 3 to view balance\nEnter 4 for exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    rose.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    try {
                        rose.withdraw(withdrawalAmount);
                    } catch (InsufficientFundsException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (InvalidAmountException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Thank you ");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.Enter again");
            }

            System.out.println();
        }
    }
}

