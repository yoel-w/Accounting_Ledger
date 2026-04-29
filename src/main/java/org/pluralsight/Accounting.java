package org.pluralsight;

import javax.imageio.stream.ImageInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Accounting {
    static Scanner scanner = new Scanner(System.in);


    static void main() {
        
        //displaying the home screen
        HomeScreen();

        }

        static void HomeScreen() {

        //Start of the Home Screen page
        while (true) {
            System.out.println("Welcome to Kings Bank ");
            System.out.println("-----------------------");
            System.out.println("D)Deposit");
            System.out.println("P)Make Payment");
            System.out.println("L)Ledger");
            System.out.println("X)Exit");
            System.out.println("Please enter your selection: ");
            String choice = scanner.nextLine().toLowerCase();
            System.out.println();

            switch (choice) {
                case "d":
                    depositPage();
                    break;
                    case "p":
                        paymentPage();
                        break;
                        case "l":
                            ledgerPage();
                            break;
                            case "x":
                                System.out.println("Thank you for choosing Kings Bank. Have a great day!");
                                return;
                                default:
                                    System.out.println("Invalid selection. Please try again");
            }
        }
        }

        private static void depositPage() {
        //Option screen for deposit
        System.out.println("Are you ready to Deposit?");
        System.out.println("Y)Yes");
        System.out.println("X)Go back");
        String choice = scanner.nextLine().toLowerCase();
        System.out.println();

        //first switch to deposit
        switch (choice) {
            case "y":
                String choice2 = "";
                do {
                    System.out.println("Please enter the amount you would like to deposit");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Your deposit total is: " + "$"+ amount);
                    System.out.println("Is that correct?");
                    System.out.println("Y)Yes (if selected, funds will be deposited and be sent back to home page)");
                    System.out.println("N)No (Will try again)");
                    System.out.println("X) Cancel");

                    // Using do/while loop for retry if customer put wrong information
                    choice2 = scanner.nextLine().toLowerCase();
                    switch (choice2) {
                        case "y":
                            String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                            String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                            try(FileWriter fw = new FileWriter("transactions.csv", true))
                            {
                                fw.write(date + "|" + time + "|ATM Deposit|Kings Bank|" + amount);
                            }
                            catch (IOException e) {
                                e.printStackTrace();
                            }
                            HomeScreen();
                            break;
                        case "x":
                            HomeScreen();
                            break;
                        case "n":
                            System.out.println("try again");
                            break;
                        default:
                            System.out.println("Invalid selection. Please try again");
                    }
                } while (choice2.equals("n"));
                break;

        }
            }

            private static void paymentPage() {

            System.out.println("Please enter debit card number");

            }
            private static void ledgerPage() {
        while (true) {
            System.out.println("Please selection one of the following");
            System.out.println("-------------------------------------");
            System.out.println("");
            System.out.println("A)Show all transactions");
            System.out.println("D)Show only deposits made");
            System.out.println("P)Show only payments made");
            System.out.println("R)Report/transactions search");
            System.out.println("X)Go back");
            String choice = scanner.nextLine().toLowerCase();
            System.out.println();
            switch (choice) {
                case "a":
                    allTransactions();
                    break;
                case"d":
                    depositsPage();
                    break;
                    case "p":
                        paymentsPage();
                        break;
                        case "r":
                            reportPage();
                            break;
                            case "x":
                                HomeScreen();
                                break;
                                default:
                                    System.out.println("Invalid selection. Please try again");
            }
        }

            }

private static void allTransactions() {
    System.out.println();
    System.out.println("=========== Transaction History ============");
   System.out.println("");
    System.out.println("--------------------------------------------------------------");

    try {
        FileReader fr = new FileReader("transactions.csv");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
    catch (IOException e){
        e.printStackTrace();
    }
    System.out.println("");
    System.out.println("--------------------------------------------------------------");
    System.out.println("");
    System.out.println("B)Go back");
    String choice = scanner.nextLine().toLowerCase();
    System.out.println();
    if (choice.equals("b")) {
        ledgerPage();
    } else {
        System.out.println("Invalid selection. Please try again");
    }
}


private static void depositsPage(){
    System.out.println();
    System.out.println("=========== Deposit History ============");
    System.out.println("");
    System.out.println("--------------------------------------------------------------");

    try {
        FileReader fr = new FileReader("transactions.csv");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains("Deposit"))
            {
                System.out.println(line);
            }
        }
    }
    catch (IOException e){
        e.printStackTrace();
    }
    System.out.println("");
    System.out.println("--------------------------------------------------------------");
    System.out.println("");
    System.out.println("B)Go back");
    String choice = scanner.nextLine().toLowerCase();
    System.out.println();
    if (choice.equals("b")) {
        ledgerPage();
    } else {
        System.out.println("Invalid selection. Please try again");
    }

}
private static void paymentsPage(){
    System.out.println();
    System.out.println("=========== Payment History ============");
    System.out.println("");
    System.out.println("--------------------------------------------------------------");

    try {
        FileReader fr = new FileReader("transactions.csv");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains("Payment"))
            {
                System.out.println(line);
            }
        }
    }
    catch (IOException e){
        e.printStackTrace();
    }
    System.out.println("");
    System.out.println("--------------------------------------------------------------");
    System.out.println("");
    System.out.println("B)Go back");
    String choice = scanner.nextLine().toLowerCase();
    System.out.println();
    if (choice.equals("b")) {
        ledgerPage();
    } else {
        System.out.println("Invalid selection. Please try again");
    }
}







private static void reportPage(){
    while (true) {
        System.out.println("Please selection one of the following");
        System.out.println("-------------------------------------");
        System.out.println("");
        System.out.println("1)Month to Date");
        System.out.println("2)Previous Month");
        System.out.println("3)Year to Date");
        System.out.println("4)Previous Year");
        System.out.println("5)Search by Vendor");
        System.out.println("0)Go back");
        String choice = scanner.nextLine().toLowerCase();
        System.out.println();
        switch (choice) {
            case "1":
                monthDatePage();
                break;
                case "2":
                    previousMonthPage();
                    break;
                    case "3":
                        yearDatePage();
                        break;
                        case "4":
                            previousYearPage();
                            break;
                            case "5":
                                vendorPage();
                                break;
                                case "0":
                                    ledgerPage();
                                    break;
                                    default:
                                        System.out.println("Invalid selection. Please try again");


        }
    }
}
private static void monthDatePage(){
        System.out.println();
        System.out.println("=========== Month to Date report ===========");


    }

    private static void previousMonthPage() {
        System.out.println();
        System.out.println("=========== Month to Date report ===========");
    }

    private static void yearDatePage() {
        System.out.println();
        System.out.println("=========== Month to Date report ===========");
    }

    private static void previousYearPage() {
        System.out.println();
        System.out.println("=========== Month to Date report ===========");
    }

    private static void vendorPage() {
        System.out.println();
        System.out.println("=========== Month to Date report ===========");
    }













}






















