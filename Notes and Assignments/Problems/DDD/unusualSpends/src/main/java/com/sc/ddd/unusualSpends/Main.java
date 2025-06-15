package com.sc.ddd.unusualSpends;

import com.sc.ddd.unusualSpends.domain.entity.CreditCard;
import com.sc.ddd.unusualSpends.domain.entity.Merchant;
import com.sc.ddd.unusualSpends.domain.entity.User;
import com.sc.ddd.unusualSpends.domain.valueobject.SpendingCategory;

import java.util.Collections;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        User user = new User("U101", "Akash", "akashhedau65@gmail.com", "8308985621", Collections.singletonList("1234567890123456"));

        Merchant merch1 = new Merchant("M101", "Mustafa", SpendingCategory.UTILITY);
        Merchant merch2 = new Merchant("M102", "Vidhi", SpendingCategory.FOOD);
        Merchant merch3 = new Merchant("M103", "Rakes", SpendingCategory.TRAVEL);
        Merchant merch4 = new Merchant("M103", "Max", SpendingCategory.FUEL);


        while (true) {
            int choice = getChoice(scanner);
            printMenu();
            switch (choice) {
                case 1:
                    user.spend(1200, merch1, user);
                    break;
                case 2:
                    createMerchant();
                    break;
                case 3:
                    System.out.println("Exiting. Bye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static int getChoice(Scanner sc) {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void printMenu() {
        System.out.println("\n===== Menu =====");
        System.out.println("1. Spend");
        System.out.println("2. Create Merchant");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

}