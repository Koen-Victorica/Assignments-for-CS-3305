// Name: Sam Victorica
// Class: CS 3305 Section#: W03
// Term: Spring 2023
// Instructor: Prof. Majeed
// Assignment: 4
import java.util.Scanner;
public class TestQueue <E> {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Queue myQueue = new Queue();
        int choice = 0, store;
        do { //displays the menu
            System.out.println("--------MAIN MENU--------\n1 – Enqueue element\n2 – Dequeue element\n3 – Front element\n4 – Size of queue\n5 – Is Empty queue?\n6 - Print queue content\n7 - Exit program\n\nEnter option number: ");
            choice = Integer.parseInt(scan.nextLine()); // user input of choice
            while (choice < 1 || choice > 7) { //if choice is out of bounds they should re-enter a new choice
                System.out.println("Please choose a number between 1 - 7");
                choice = Integer.parseInt(scan.nextLine());
            }
            System.out.println();
            switch (choice){
                case 1: // displays the data in the queue before and after adding the new element to the end of the queue
                    System.out.println("Testing method Enqueue()\n");
                    System.out.println("Please provide data value to be stored: ");
                    store = Integer.parseInt(scan.nextLine());
                    System.out.println();
                    System.out.print("Queue content before adding to end of queue: ");
                    System.out.println();
                    myQueue.Print();
                    System.out.println();
                    System.out.print("\nQueue content after adding to end of queue: ");
                    myQueue.enqueue(store);
                    System.out.println();
                    myQueue.Print();
                    System.out.println();
                    System.out.println();
                    break;
                case 2: // displays the data in the Queue before removing the first element
                    System.out.println("Testing method Dequeue()\n");
                    System.out.print("Queue content before removing front element: ");
                    System.out.println();
                    myQueue.Print();
                    System.out.println();
                    System.out.print("\nQueue content after removing front element: ");
                    myQueue.dequeue();
                    System.out.println();
                    myQueue.Print();
                    System.out.println();
                    System.out.println();
                    break;
                case 3: // displays the first value in the queue without removing it
                    System.out.println("Testing method Front()\n");
                    System.out.println("Front value is: " + myQueue.front());
                    System.out.println();
                    break;
                case 4: // display the total number of items in the queue
                    System.out.println("Testing method Size()\n");
                    System.out.println("Total queue size is: " + myQueue.Size());
                    System.out.println();
                    break;
                case 5: // will tell you if the queue is empty or not
                    System.out.println("Testing method isEmpty()\n");
                    if (myQueue.isEmpty()){
                        System.out.println("Queue is empty");
                    }
                    else
                        System.out.println("Queue is not empty");
                    System.out.println("");
                    break;
                case 6: // will print out all the elements in the queue from end to front
                    System.out.println("Testing method Print()\n");
                    System.out.print("Printing queue: ");
                    myQueue.Print();
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