// Noh Daniel
// A5Q2
// reads bank accounts from a file and lets the user manage them.

import java.io.*;
import java.util.*;

public class A5Q2 {

    public static void main(String[] args) throws IOException {

        ArrayList<Account> accounts = loadAccounts("accounts_data.txt");
        Scanner input = new Scanner(System.in);

        while (true) {

            printMenu();
            int option = getIntInRange(input, "Choose an option: ", 0, 8);

            if (option == 0) {
                System.out.println("Goodbye.");
                break;
            }

            if (option == 1){
                createAccount(input, accounts);
            }
            else if (option == 2) {
                getBalance(input, accounts);
            }
            else if (option == 3) {
                deposit(input, accounts);
            }
            else if (option == 4) {
                withdraw(input, accounts);
            }
            else if (option == 5) {
                transfer(input, accounts);
            }
            else if (option == 6) {
                printAccount(input, accounts);
            }
            else if (option == 7) {
                exportByNumber(accounts);
            }
            else if (option == 8) {
                exportByName(accounts);
            }
        }
    }

    // Loads accounts from file
    public static ArrayList<Account> loadAccounts(String filename) throws IOException {

        ArrayList<Account> accounts = new ArrayList<>();
        Scanner reader = new Scanner(new File(filename));

        // skip the first line (the stuff at the top)
        if (reader.hasNextLine()) {
            reader.nextLine();
        }

        // reads each accounts first n last name, account number, then the balance
        while (reader.hasNext()) {
            String first = reader.next();
            String last = reader.next();
            int number = reader.nextInt();
            double bal = reader.nextDouble();

            accounts.add(new Account(first, last, number, bal));
        }

        return accounts;
    }

    public static void printMenu() {
        System.out.println(
                "1: Create a new Account\n" +
                        "2: Get Account Balance\n" +
                        "3: Deposit Amount\n" +
                        "4: Withdraw Amount\n" +
                        "5: Transfer Funds to Other Account\n" +
                        "6: Print Account Info\n" +
                        "7: Export listing of all Accounts (numerically ordered)\n" +
                        "8: Export listing of all Accounts (alphabetically ordered)\n" +
                        "0: Exit"
        );
    }

    // Menu option input (0 to 8)
    public static int getIntInRange(Scanner input, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = input.nextInt();
                input.nextLine();
                if (value < min || value > max) {
                    System.out.println("Enter a number between " + min + " and " + max);
                } else {
                    return value;
                }
            } catch (Exception e) {
                System.out.println("Must be an integer");
                input.nextLine();
            }
        }
    }

    // Gets an integer and makes sure it is one
    public static int getInt(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = input.nextInt();
                input.nextLine();
                return value;
            } catch (Exception e) {
                System.out.println("Enter an integer.");
                input.nextLine();
            }
        }
    }

    // Gets a positive money amount
    public static double getPositiveDouble(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = input.nextDouble();
                input.nextLine();
                if (value <= 0) {
                    System.out.println("Amount must be positive.");
                } else {
                    return value;
                }
            } catch (Exception e) {
                System.out.println("Enter a number.");
                input.nextLine();
            }
        }
    }

    // Finds account by account number
    public static Account findAccount(ArrayList<Account> accounts, int number) {
        for (Account a : accounts) {
            if (a.getAcctNum() == number) {
                return a;
            }
        }
        return null;
    }

    // Keeps asking for an account number until it's valid, or 0 to go back to menu
    public static Account getValidAccountOrCancel(Scanner input, ArrayList<Account> accounts, String prompt) {

        while (true) {
            int num = getInt(input, prompt + " (0 to go back): ");

            if (num == 0) {
                return null;
            }

            Account a = findAccount(accounts, num);
            if (a != null) {
                System.out.println("You selected: " + a.getName() + " (" + a.getAcctNum() + ")");
                return a;
            }

            System.out.println("Invalid account number");
        }
    }

    // Prints account info
    public static void printAccountInfo(Account a) {
        System.out.println("Account Holder Name:\t" + a.getName());
        System.out.println("Account Number:\t\t" + a.getAcctNum());
        System.out.println("Balance:\t\t$" + String.format("%.2f", a.getBalance()));
    }

    // Creates a new account with a unique 6 digit account number and starting balance of 0
    public static void createAccount(Scanner input, ArrayList<Account> accounts) {

        System.out.print("Enter first name: ");
        String first = input.nextLine().trim();

        System.out.print("Enter last name: ");
        String last = input.nextLine().trim();

        Random rand = new Random();
        int number;

        // generates an account number and makes sure it doesnt already exist
        do {
            number = rand.nextInt(900000) + 100000;
        } while (findAccount(accounts, number) != null);

        Account a = new Account(first, last, number, 0.0);
        accounts.add(a);

        // prints the new account info
        printAccountInfo(a);
    }

    // Finds an account and displays the current balance
    public static void getBalance(Scanner input, ArrayList<Account> accounts) {

        Account a = getValidAccountOrCancel(input, accounts, "Enter account number");
        if (a == null) {
            return;
        }

        System.out.println("Balance: $" + String.format("%.2f", a.getBalance()));
    }

    // Adds money to an account after checking the amount is valid
    public static void deposit(Scanner input, ArrayList<Account> accounts) {

        Account a = getValidAccountOrCancel(input, accounts, "Enter account number");
        if (a == null) {
            return;
        }

        double amount = getPositiveDouble(input, "Enter amount: ");
        a.deposit(amount);

        System.out.println("Deposit successful.");
    }

    // Removes money from an account if there is enough balance
    public static void withdraw(Scanner input, ArrayList<Account> accounts) {

        Account a = getValidAccountOrCancel(input, accounts, "Enter account number");
        if (a == null) {
            return;
        }

        double amount = getPositiveDouble(input, "Enter amount: ");

        if (amount > a.getBalance()) {
            System.out.println("Insufficient Funds.");
            return;
        }

        a.withdraw(amount);
        System.out.println("Withdrawal complete.");
    }

    // Moves money from one account to another if the amount is valid and there are enough funds
    public static void transfer(Scanner input, ArrayList<Account> accounts) {

        Account from = getValidAccountOrCancel(input, accounts, "Enter your account number");
        if (from == null) {
            return;
        }

        Account to = getValidAccountOrCancel(input, accounts, "Enter receiving account number");
        if (to == null) {
            return;
        }

        if (from.getAcctNum() == to.getAcctNum()) {
            System.out.println("You cannot transfer money to yourself.");
            return;
        }

        double amount = getPositiveDouble(input, "Enter amount: ");

        if (amount > from.getBalance()) {
            System.out.println("Insufficient Funds.");
            return;
        }

        from.transfer(amount, to);
        System.out.println("Transfer complete.");
    }

    // Displays all information about a specific account
    public static void printAccount(Scanner input, ArrayList<Account> accounts) {

        Account a = getValidAccountOrCancel(input, accounts, "Enter account number");
        if (a == null) {
            return;
        }

        printAccountInfo(a);
    }

    // Creates a file listing all accounts sorted by account number from smallest to biggest
    public static void exportByNumber(ArrayList<Account> accounts) throws IOException {

        ArrayList<Account> copy = new ArrayList<>(accounts);

        Collections.sort(copy, new Comparator<Account>() {
            public int compare(Account a, Account b) {
                return a.getAcctNum() - b.getAcctNum();
            }
        });

        try {
            PrintWriter writer = new PrintWriter("accounts_num.txt");

            for (Account a : copy) {
                writer.println("Account Holder Name:\t" + a.getName());
                writer.println("Account Number:\t\t" + a.getAcctNum());
                writer.println("Balance:\t\t$" + String.format("%.2f", a.getBalance()));
                writer.println();
            }

            writer.close();

            System.out.println("Exported accounts_num.txt");
        } catch (Exception e) {
            System.out.println("Could not write the file");
        }
    }

    // Creates a file listing all accounts sorted alphabetically by the last name of the account holder
    public static void exportByName(ArrayList<Account> accounts) throws IOException {

        ArrayList<Account> copy = new ArrayList<>(accounts);

        Collections.sort(copy, new Comparator<Account>() {
            public int compare(Account a, Account b) {
                return a.getName().compareToIgnoreCase(b.getName());
            }
        });

        try {
            PrintWriter writer = new PrintWriter("accounts_name.txt");

            for (Account a : copy) {
                writer.println("Account Holder Name:\t" + a.getName());
                writer.println("Account Number:\t\t" + a.getAcctNum());
                writer.println("Balance:\t\t$" + String.format("%.2f", a.getBalance()));
                writer.println();
            }

            writer.close();

            System.out.println("Exported accounts_name.txt");
        } catch (Exception e) {
            System.out.println("Could not write the file.");
        }
    }
}
