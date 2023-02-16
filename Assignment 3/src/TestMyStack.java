// Name: Sam Victorica
// Class: CS 3305 Section#: W03
// Term: Spring 2023
// Instructor: Prof. Majeed
// Assignment: 3
import java.util.Scanner;
public class TestMyStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack myStack = new Stack();
        int choice = 0, store;
        do { //displays the menu
            System.out.println("---------MAIN MENU--------\n1 – Push element \n2 – Pop element \n3 – Top element \n4 – Size of stack \n5 – Is Empty stack? \n6 - Print stack content \n7 - Exit program \nEnter option number: ");
            choice = Integer.parseInt(scan.nextLine()); // user input of choice
            while (choice < 1 || choice > 7) { //if choice is out of bounds they should re-enter a new choice
                System.out.println("Please choose a number between 1 - 7");
                choice = Integer.parseInt(scan.nextLine());
            }
            System.out.println();
            switch (choice){
                case 1: // displays the data in the stack before and after pushing a new node to the top of the stack
                    System.out.println("Testing method Push()\n");
                    System.out.println("Please provide data value to be stored: ");
                    store = Integer.parseInt(scan.nextLine());
                    System.out.println();
                    System.out.print("Stack content before pushing new node: ");
                    System.out.println();
                    myStack.Print();
                    System.out.println();
                    System.out.print("\nStack content after pushing new node: ");
                    myStack.Push(store);
                    System.out.println();
                    myStack.Print();
                    System.out.println();
                    System.out.println();
                    break;
                case 2: // displays the data in the stack before and after popping the top node off
                    System.out.println("Testing method Pop()\n");
                    System.out.print("Stack content before popping: ");
                    System.out.println();
                    myStack.Print();
                    System.out.println();
                    System.out.print("\nStack content after popping: ");
                    myStack.Pop();
                    System.out.println();
                    myStack.Print();
                    System.out.println();
                    System.out.println();
                    break;
                case 3: // displays the top value in the stack without removing it
                    System.out.println("Testing method Top()\n");
                    System.out.println("Top value is: " + myStack.Top());
                    System.out.println();
                    break;
                case 4: // display the total number of items in the stack
                    System.out.println("Testing method Size()\n");
                    System.out.println("Total stack size is: " + myStack.Size());
                    System.out.println();
                    break;
                case 5: // will tell you if the stack is empty or not
                    System.out.println("Testing method isEmpty()\n");
                    if (myStack.isEmpty()){
                        System.out.println("Stack is empty");
                    }
                    else
                        System.out.println("Stack is not empty");
                    System.out.println("");
                    break;
                case 6: // will print out all the elements in the stack from top to bottom
                    System.out.println("Testing method Print()\n");
                    System.out.print("Printing stack: ");
                    myStack.Print();
                    System.out.println();
                    System.out.println();
                    break;
                case 7: //terminates program
                    System.out.println("Exiting...");
                    break;
            }
        } while (choice != 7);
    }
}