// Name: Sam Victorica
// Class: CS 3305 Section#: W03
// Term: Spring 2023
// Instructor: Prof. Majeed
// Assignment: 5
import java.util.Scanner;
public class RemoveDuplicates {
    public static void main(String[] args) {
        // Create a BST
        BST tree = null;
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        String[] words = null;
        String store = null;
        do { //displays the menu
            System.out.println("\n-----------------MAIN MENU---------------\n1. Read input string\n2. Remove duplicates and display outputs \n3. Exit program\n\nEnter option number: ");
            choice = Integer.parseInt(scan.nextLine()); // user input of choice
            while (choice < 1 || choice > 3) { //if choice is out of bounds they should re-enter a new choice
                System.out.println("Please choose a number between 1 - 3");
                choice = Integer.parseInt(scan.nextLine());
            }
            System.out.println();
            switch (choice) {
                case 1: // Creates a new tree and fills it with all of the words
                    tree = new BST<String>();
                    System.out.println("Enter input: ");
                    store = scan.nextLine();
                    words = store.split(" ");
                    for (String i: words) {
                        tree.insert(i);
                    }
                    break;
                case 2: // removes all duplicates and prints the tree inroder
                    System.out.println("Original Text: ");
                    System.out.println(store);
                    System.out.println();
                    System.out.println("Processed Text: ");
                    tree.inorder();
                    System.out.println();
                    break;
                case 3: //terminates program
                    System.out.println("Exiting...");
                    break;
            }
        } while (choice != 3) ;
    }
}

