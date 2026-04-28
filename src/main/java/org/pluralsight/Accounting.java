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
                        //payment
                        break;
                        case "l":
                            //ledger page
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
        System.out.println("Enter amount to deposit: ");
            System.out.println("");
            System.out.println("");
            System.out.println("");
        System.out.println("X) To go back");
            double amount = Double.parseDouble(scanner.nextLine().toLowerCase().trim()); //google trim vs strip
            try(
                    FileWriter fw = new FileWriter("transactions.txt");
                    writer.write(""
                    )

                writer.close();
    }
        catch (IOException e)

    {
        System.out.println("ERROR: An unexpected error occurred. Please try again");
        e.printStackTrace();
    }




















}


