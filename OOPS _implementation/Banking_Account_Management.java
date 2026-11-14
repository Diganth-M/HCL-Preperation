
import java.util.Scanner;

class BankAccount
{
    int accountNumber;
    double balance;

    BankAccount(int number, double amount) 
    {
        accountNumber = number;
        balance = amount;
    }

    double calculateFinalBalance()
    {
        return balance;
    }
    
}

class  SavingsAccount extends BankAccount
{
    double interestRate;

    SavingsAccount(int number, double  amount, double rate)
    {
        super(number, amount);
        interestRate = rate;
    }

    double calculateFinalBalance()
    {
        return balance + (balance * interestRate / 100);
    }
    
}

class CurrentAccount extends BankAccount
{
    double overdragtLimit;

    CurrentAccount(int number, double amount, double limit) {
        super(number, amount);
        overdragtLimit = limit;
    }

    double calculateFinalBalance()
    {
        return balance + overdragtLimit;
    }
    
}


public class Banking_Account_Management {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();
        int number = sc.nextInt();
        double balance = sc.nextDouble();
        double value = sc.nextDouble();

        BankAccount account;

        if(type == 1)
        {
            account = new SavingsAccount(number, balance, value);
        }
        else
        {
            account = new CurrentAccount(number, balance, value);
        }

        System.out.printf(" %.4f", account.calculateFinalBalance());
        sc.close();
    }    
}
