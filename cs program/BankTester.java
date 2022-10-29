package banka;
import banka.Bank;
import java.util.ArrayList;
import java.util.Scanner;
public class BankTester
{
    public static void main(String[] args) {
        Bank Account = new Bank();
        Scanner in = new Scanner(System.in);
        System.out.println("WELCOME BANKING SYSTEM.");
        char choice = 'y';
        do {
        System.out.println("Choose from the following.");
        System.out.println("1. Add account in bank.");
        System.out.println("2. Deposit in an account.");
        System.out.println("3. Withdraw from an account.");
        System.out.println("4. Get total balance in the bank.");
        System.out.println("5. Get account number with max and min balance.");
        System.out.println("6. Find an account given an account no.");
        System.out.println("7. Count the no. of accounts having atleast specific balance.");
        System.out.print("Enter your choice: ");
        int ch = in.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter an account number: ");
                    int accNo = in.nextInt();
                    System.out.print("Enter the opening balance: ");
                    double balanc = in.nextDouble();
                    BankAccount a = new BankAccount(accNo, balanc);
                    Account.addAccount(a);
                    System.out.println("Account created successfully.");
                    System.out.println("Welcome to Bank");
                    System.out.println("Account No: " + a.getAccountNumber()+"\tBalance: " + a.getBalance());
                    break;
                case 2:
                    System.out.print("Enter the account number: ");
                    int acc = in.nextInt();
                    a = Account.find(acc);
                    if (a == null) {
                        System.out.println("The requested account does not exist.");
                    } else {
                        System.out.print("Enter the amount to be deposited: ");
                        double bal = in.nextDouble();
                        a.deposit(bal);
                        System.out.println("The updated balance of the account is: " + a.getBalance());
                    }
                    break;
                case 3:
                    System.out.print("Enter the account number: ");
                    acc = in.nextInt();
                    a = Account.find(acc);
                    if (a == null) {
                        System.out.println("The requested account does not exist.");
                    } else {
                        System.out.print("Enter the amount to be withdrawn: ");
                        double bal = in.nextDouble();
                        a.withdraw(bal);
                        System.out.println("The updated balance of the account is: " + a.getBalance());
                    }
                    break;
                case 4:
                    System.out.println("The total balance in the bank is: " + Account.getTotalBalance());
                    break;
                case 5:
                    System.out.print("The account with maximum balance is: " + Account.getMaximum().getBalance());
                    System.out.println("\nThe account with least balance is: " + Account.getMinimum().getBalance());
                    break;
                case 6:
                    System.out.print("Enter an account no: ");
                    acc = in.nextInt();
                    a = Account.find(acc);
                    if (a == null) {
                        System.out.println("The srearched account does not exist.");
                    } else {
                        System.out.print("Account exists.");
                        System.out.println("Account No: "+ a.getAccountNumber());
                        System.out.println("\nBalance: " + a.getBalance());
                    }
                    break;
                case 7:
                    System.out.print("Enter the thresold balance: ");
                    double threshold = in.nextDouble();
                    int c = Account.countBalancesAtLeast(threshold);
                    System.out.println("No. of account having minimum balance of " + threshold + " are: " + c);
                    break;
                default:
                    System.out.println("Wrong choice!");
            }
            System.out.println("Press 'Y' to continue, any other key to exit.");
            choice=in.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }
}