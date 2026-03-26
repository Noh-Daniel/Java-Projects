// Noh Daniel
// Account class
// This class stores account information and allows deposits, withdrawals, and transfers.

public class Account {

    // Instance variables
    private String firstName;
    private String lastName;
    private int accountNumber;
    private double balance;

    // Default constructor
    public Account() {
        firstName = "";
        lastName = "";
        accountNumber = 0;
        balance = 0.0;
    }

    // Full constructor
    public Account(String f, String l, int i, double a) {
        firstName = f;
        lastName = l;
        accountNumber = i;
        balance = a;
    }

    // Sets the name
    public void setName(String first, String last) {
        firstName = first;
        lastName = last;
    }

    // Returns name as "Last, First"
    public String getName() {
        return lastName + ", " + firstName;
    }

    // Sets account number (must be 6 digits)
    public void setAcctNum(int num) {
        if (num >= 100000 && num <= 999999) {
            accountNumber = num;
        }
    }

    public int getAcctNum() {
        return accountNumber;
    }

    public void setBalance(double amount) {
        balance = amount;
    }

    public double getBalance() {
        return balance;
    }

    // Adds money
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        }
    }

    // Removes money if enough funds
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
        }
    }

    // Transfers money to another account
    public void transfer(double amount, Account other) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            other.deposit(amount);
        }
    }

    // Returns formatted account info
    public String toString() {
        return "Account Holder Name:\t" + getName() + "\n"
                + "Account Number:\t\t" + accountNumber + "\n"
                + "Balance:\t\t$" + String.format("%.2f", balance);
    }
}