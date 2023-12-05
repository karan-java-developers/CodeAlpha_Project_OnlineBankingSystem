package CodeAlpha.task2;

import java.util.Scanner;

class BankDetails {

    private String accno;
    private String name;
    private long balance;
    Scanner sc = new Scanner(System.in);

    //method to open new account  
    public void openAccount() {
        System.out.print("Enter Account No: ");
        accno = sc.next();
        System.out.print("Enter Name: ");
        name = sc.next();
        System.out.print("Enter Balance: ");
        balance = sc.nextLong();
        System.out.println();
    }

    //method to display account details  
    public void showAccount() {
        System.out.println("Name of account holder: " + name);
        System.out.println("Account no.: " + accno);
        System.out.println("Balance: " + balance);
        System.out.println();
    }

    //method to deposit money  
    public void deposit() {
        long amt;
        System.out.print("Enter the amount you want to deposit: ");
        amt = sc.nextLong();
        balance = balance + amt;
        System.out.println("deposit of " + amt+ " is successful.");
        System.out.println("balance : "+ balance);
    }

    //method to withdraw money  
    public void withdrawal() {
        long amt;
        System.out.println("Enter the amount you want to withdraw: ");
        amt = sc.nextLong();
        if (balance >= amt) {
            balance = balance - amt;
            System.out.println("withdrawal is seccessful\tBalance after withdrawal: " + balance);
        } else {
            System.out.println("Your balance is less than the " + amt
                    + "\tTransaction failed...!!");
        }
    }

    //method to search an account number  
    public boolean search(String ac_no) {
        if (accno.equals(ac_no)) {
            System.out.println();
            showAccount();
            return (true);
        }
        return (false);
    }
}

public class OnlineBankingSystem {

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        //create initial accounts  
        System.out.print("Add Number of Clients : ");
        int n = sc.nextInt();
        BankDetails C[] = new BankDetails[n];
        for (int i = 0; i < C.length; i++) {
            C[i] = new BankDetails();
            int j=i+1;
            System.out.println("details of the client number " + j);
            C[i].openAccount();
        }
        // loop runs until number 5 is not pressed to exit  
        int ch;
        do {
            System.out.println("\n-----------Banking System by karan kashyap----------");
            System.out.println(" 1. Display all account details \n "
                    + "2. Search by Account number\n 3. Deposit the amount \n "
                    + "4. Withdraw the amount \n 5.Exit ");
            System.out.println("Enter your choice(1/2/3/4/5): ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    for (int i = 0; i < C.length; i++) {
                        C[i].showAccount();
                    }
                    break;
                case 2:
                    System.out.print("Enter account number you want to search: ");
                    String ac_no = sc.next();
                    boolean found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account no. : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            C[i].deposit();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account No : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            C[i].withdrawal();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 5:
                    System.out.println("See you soon...");
                    break;
                default:
                    System.out.println("please choose any one option given below");
            }
        } while (ch != 5);
        sc.close();
    }
    
}
