package oopHomeWork;

public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(400);
        bankAccount.deposit(400);
        bankAccount.deposit(400);
        bankAccount.deposit(400);
        bankAccount.deposit(400);
        System.out.println(bankAccount.getBalance());
    }
}
class BankAccount{
    private double balance;
    private int num = 0;
    private double interest = 0;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public void deposit(double amount){
        if (num < 3){
            balance += amount;
            num++;
            return;
        }
        balance += (amount-1);


    }
    public void withdraw(double amount){
        if (num != 3){
            balance -= amount;
            num++;
            return;
        }
        balance -= (amount+1);
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public void earnMonthlyInterest(){
        interest = 0.01*balance;
        balance += interest;
        num = 0;
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
