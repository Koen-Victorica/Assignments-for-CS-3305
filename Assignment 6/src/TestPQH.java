// Name: Sam Victorica
// Class: CS 3305 Section#: W03
// Term: Spring 2023
// Instructor: Prof. Majeed
// Assignment: 6
import java.util.Scanner;
public class TestPQH <E>{
    public static void main(String[] args) {
        // Create a PQ
        PQ_Heap PQ = null;
        Scanner scan = new Scanner(System.in);
        int choice = 0, storeI = 0, data, max;
        String storeS = null;
        System.out.println("Select Queue Data Type (integer = 1 or string = 2): ");
        data = Integer.parseInt(scan.nextLine());
        while (data < 1 || data > 2) { //if data is out of bounds they should re-enter a new data value
            System.out.println("Please choose a number between 1 - 2");
            data = Integer.parseInt(scan.nextLine());
        }
        System.out.println("Select Queue Max Size: ");
        max = Integer.parseInt(scan.nextLine());
        while (max < 1){
            System.out.println("Please choose a number greater then 0");
            max = Integer.parseInt(scan.nextLine());
        }
        if(data == 1) {
            PQ = new PQ_Heap<Integer>(max);
        }
        else if (data == 2) {
            PQ = new PQ_Heap<String>(max);
        }
        do { //displays the menu
            System.out.println("\n----------------MAIN MENU---------------\n0. Enter Queue Type (integer or string)\n1. Enqueue Element\n2. Dequeue Element\n3. Check is_Full\n4. Check is_Empty\n5. Print PQueue Size\n6. Display Front Element\n7. Print PQueue Elements\n8. Exit program\n\nEnter option number:");
            choice = Integer.parseInt(scan.nextLine()); // user input of choice
            while (choice < 0 || choice > 8) { //if choice is out of bounds they should re-enter a new choice
                System.out.println("Please choose a number between 0 - 8");
                choice = Integer.parseInt(scan.nextLine());
            }
            System.out.println();
            switch (choice){
                case 0: // changes the Queue data type, max size and clears the Queue
                    System.out.println("Select Queue Data Type (integer = 1 or string = 2): ");
                    data = Integer.parseInt(scan.nextLine());
                    while (data < 1 || data > 2) { //if data is out of bounds they should re-enter a new data value
                        System.out.println("Please choose a number between 1 - 2");
                        data = Integer.parseInt(scan.nextLine());
                    }
                    System.out.println("Select Queue Max Size: ");
                    max = Integer.parseInt(scan.nextLine());
                    while (max < 1){
                        System.out.println("Please choose a number greater then 0");
                        max = Integer.parseInt(scan.nextLine());
                    }
                    if(data == 1) {
                        PQ = new PQ_Heap<Integer>(max);
                    }
                    else if (data == 2) {
                        PQ = new PQ_Heap<String>(max);
                    }
                    break;
                case 1: // displays the data in the Queue before and after inserting an element
                    System.out.println("Testing method Enqueue()\n");
                    System.out.println("Please provide data value to be stored: ");
                    if(data == 1) {
                        storeI = Integer.parseInt(scan.nextLine());
                    }
                    else if (data == 2) {
                        storeS = scan.nextLine();
                    }
                    System.out.println();
                    System.out.print("Queue content before inserting element: \n\n");
                    PQ.print();
                    System.out.print("\nQueue content after inserting element: \n");
                    if(data == 1) {
                        PQ.enqueue(storeI);
                    }
                    else if (data == 2) {
                        PQ.enqueue(storeS);
                    }
                    System.out.println();
                    PQ.print();
                    break;
                case 2: // displays the data in the Queue before and after deleting the root
                    System.out.println("Testing method Dequeue()\n");
                    System.out.print("Queue content before deleting element: \n\n");
                    PQ.print();
                    System.out.print("\nQueue content after deleting element: \n");
                    PQ.dequeue();
                    System.out.println();
                    PQ.print();
                    break;
                case 3: // Sees if the Queue is full
                    System.out.println("Testing method is_full()\n");
                   if (PQ.is_full()){
                       System.out.println("Queue is full");
                   }
                   else {
                       System.out.println("Queue is not full");
                   }
                    break;
                case 4: // Sees if the Queue is Empty
                    System.out.println("Testing method is_Empty()\n");
                    if (PQ.is_empty()){
                        System.out.println("Queue is empty");
                    }
                    else {
                        System.out.println("Queue is not empty");
                    }
                    break;
                case 5: // will tell you how many elements are in the queue
                    System.out.println("Testing method Size()\n");
                    System.out.println("The queue has " + PQ.size() + " elements.");
                    break;
                case 6: // Displays front element
                    System.out.println("Testing method Front()\n");
                    System.out.println("The queue's first element is " + PQ.front() + ".");
                    break;
                case 7: // Prints the queue
                    System.out.println("Testing method print()\n");
                    System.out.println("Printing the Queue: \n");
                    PQ.print();
                    break;
                case 8: //terminates program
                    System.out.println("Exiting...");
                    break;
            }
        } while (choice != 8);
    }
}


