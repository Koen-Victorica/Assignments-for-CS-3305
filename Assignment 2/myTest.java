// Name: Sam Victorica
// Class: CS 3305 Section#: W03
// Term: Spring 2023
// Instructor: Prof. Majeed
// Assignment: 2
import java.util.Scanner;
public class myTest
{
   public static void main (String[] args)
   {
      Scanner scan = new Scanner(System.in);
      int choice = 0, store, index;
      LinkedList myList = new LinkedList(); //create a list object
      do{ // menu
      System.out.println("---------MAIN MENU--------\n1 – Add First Node\n2 – Add Last Node\n3 – Add At Index\n4 – Remove First Node\n5 – Remove Last Node\n6 – Remove At Index\n7 – Print List Size\n8 – Print List (Forward)\n9 – Print List In Reverse\n10- Exit program\n\nEnter option number:");
      choice = Integer.parseInt(scan.nextLine()); // user input of choice
      while (choice < 1 || choice > 10) { //if choice is out of bounds they should re-enter a new choice
         System.out.println("Please choose a number between 1 - 10");
         choice = Integer.parseInt(scan.nextLine());
      }
      switch (choice){ //switch statement for different options
         case 1: //tell the user they are adding the first node and ask for the data they want to store
            System.out.println("Testing method addFirstNode()\n");
            System.out.println("Please provide data value to be stored: ");
            store = Integer.parseInt(scan.nextLine());
            System.out.print("List content before adding first node is: ");
            myList.printList();
            System.out.println();
            myList.addFirstNode(store);
            System.out.print("\nList content after adding first node is: ");
            myList.printList();
            System.out.println();
            System.out.println();
            break;
         case 2://tell the user they are adding the last node and ask for the data they want to store
            System.out.println("Testing method addLastNode()\n");
            System.out.println("Please provide data value to be stored: ");
            store = Integer.parseInt(scan.nextLine());
            System.out.print("List content before adding last node is: ");
            myList.printList();
            System.out.println();
            myList.addLastNode(store);
            System.out.print("\nList content after adding last node is: ");
            myList.printList();
            System.out.println();
            System.out.println();
            break;
         case 3: //ask for the users index and value to be stored
            System.out.println("Testing method addAtIndex()\n");
            System.out.println("Please provide data value to be stored: ");
            store = Integer.parseInt(scan.nextLine());
            System.out.println("Please provide index in the list: ");
            index = Integer.parseInt(scan.nextLine());
            while (index < 0 || index > myList.countNodes()){ // if the index is out of bounds have the user try again
               System.out.println("Invalid index, try again");
               index = Integer.parseInt(scan.nextLine());
            }
            System.out.print("List content before adding at index is: ");
            myList.printList();
            System.out.println();
            myList.addAtIndex(index,store);
            System.out.print("\nList content after adding at index is: ");
            myList.printList();
            System.out.println();
            System.out.println();
            break;
         case 4:
            System.out.println("Testing method removeFirstNode()\n"); // removes the first node from the list
            if (myList.countNodes() != 0) {
               System.out.print("List content before removing first node is: ");
               myList.printList();
               System.out.println();
               myList.removeFirstNode();
               System.out.print("\nList content after removing first node is: ");
               myList.printList();
               System.out.println();
               System.out.println();
            }
            else {
               System.out.println("List is Empty\n");
            }
            break;
         case 5:
            System.out.println("Testing method removeLastNode()\n"); // removes the last node from the list
            if (myList.countNodes() != 0) {
               System.out.print("List content before removing last node is: ");
               myList.printList();
               System.out.println();
               myList.removeLastNode();
               System.out.print("\nList content after removing last node is: ");
               myList.printList();
               System.out.println();
               System.out.println();
            }
            else {
               System.out.println("List is Empty\n");
            }
            break;
         case 6:
            System.out.println("Testing method removeAtIndex()\n");// find the index the user would like to remove and remove that index
            if (myList.countNodes() != 0) {
               System.out.println("Please provide index in the list to remove: ");
               index = Integer.parseInt(scan.nextLine());
               while (index < 0 || index > myList.countNodes() - 1) { // if user chooses out of bounds tell them to try again
                  System.out.println("Invalid index, try again");
                  index = Integer.parseInt(scan.nextLine());
               }
               System.out.print("List content before removing at index is: ");
               myList.printList();
               System.out.println();
               myList.removeAtIndex(index);
               System.out.print("\nList content after removing at index is: ");
               myList.printList();
               System.out.println();
               System.out.println();
            }
            else {
               System.out.println("List is Empty\n");
            }
            break;
         case 7: // tells the user the amount of nodes
            System.out.println("Testing method countNodes()\n");
            myList.countNodes();
            System.out.println("The List contains " + myList.countNodes() + " nodes.\n");
            break;
         case 8: // prints the list
            System.out.println("Testing method printList()\n");
            System.out.print("List printed normally: ");
            myList.printList();
            System.out.println();
            break;
         case 9:// prints the list normally and then in reverse
            System.out.println("Testing method printInReverse()\n");
            System.out.print("List printed normally: ");
            myList.printList();
            System.out.println();
            System.out.print("\nList printed in reverse: ");
            myList.printInReverse(myList.tail);
            System.out.println();
            System.out.println();
            break;
         case 10: // ends program
            System.out.println("Exiting...");
            break;
      }
      } while (choice != 10);
   } 
}
    
