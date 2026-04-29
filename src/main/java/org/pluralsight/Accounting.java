package org.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
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
        System.out.println("X) To go back");
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

            }





    }

























