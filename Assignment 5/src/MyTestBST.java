// Name: Sam Victorica
// Class: CS 3305 Section#: W03
// Term: Spring 2023
// Instructor: Prof. Majeed
// Assignment: 5
import java.util.Scanner;
public class MyTestBST <E>{
    public static void main(String[] args) {
        // Create a BST
        BST tree = null;
        Scanner scan = new Scanner(System.in);
        int choice = 0, storeI = 0, data;
        String storeS = null;
        System.out.println("Select Tree Data Type (integer = 1 or string = 2): ");
        data = Integer.parseInt(scan.nextLine());
        while (data < 1 || data > 2) { //if data is out of bounds they should re-enter a new data value
            System.out.println("Please choose a number between 1 - 2");
            data = Integer.parseInt(scan.nextLine());
        }
        if(data == 1) {
             tree = new BST<Integer>();
        }
        else if (data == 2) {
             tree = new BST<String>();
        }
        do { //displays the menu
            System.out.println("\n----------------MAIN MENU---------------\n0. Enter Tree Data Type (integer or string)\n1. Insert Data Element\n2. Delete Data Element\n3. Search for Data Element\n4. Print Tree Size\n5. Path from Root to Data Element\n6. Check if Empty Tree\n7. Print Preorder Traversal\n8. Print Inorder Traversal\n9. Print Postorder Traversal\n10. Exit program\n\nEnter option number:");
            choice = Integer.parseInt(scan.nextLine()); // user input of choice
            while (choice < 0 || choice > 10) { //if choice is out of bounds they should re-enter a new choice
                System.out.println("Please choose a number between 0 - 10");
                choice = Integer.parseInt(scan.nextLine());
            }
            System.out.println();
            switch (choice){
                case 0: // changes the tree data type and clears the tree
                    System.out.println("Select Tree Data Type (integer = 1 or string = 2): ");
                    data = Integer.parseInt(scan.nextLine());
                    while (data < 1 || data > 2) { //if data is out of bounds they should re-enter a new data value
                        System.out.println("Please choose a number between 1 - 2");
                        data = Integer.parseInt(scan.nextLine());
                    }
                    if(data == 1) {
                         tree = new BST<Integer>();
                    }
                    else if (data == 2) {
                         tree = new BST<String>();
                    }
                    break;
                case 1: // displays the data in the tree before and after inserting an element
                    System.out.println("Testing method insert()\n");
                    System.out.println("Please provide data value to be stored: ");
                    if(data == 1) {
                        storeI = Integer.parseInt(scan.nextLine());
                    }
                    else if (data == 2) {
                        storeS = scan.nextLine();
                        }
                    System.out.println();
                    System.out.print("Tree content before inserting element: \n\n");
                    tree.inorder();
                    System.out.println();
                    System.out.print("\nTree content after inserting element: \n");
                    if(data == 1) {
                        tree.insert(storeI);
                    }
                    else if (data == 2) {
                        tree.insert(storeS);
                    }
                    System.out.println();
                    tree.inorder();
                    System.out.println();
                    break;
                case 2: // displays the data in the tree before and after deleting an element
                    System.out.println("Testing method delete()\n");
                    System.out.println("Please provide data value to be deleted: ");
                    if(data == 1) {
                        storeI = Integer.parseInt(scan.nextLine());
                    }
                    else if (data == 2) {
                        storeS = scan.nextLine();
                    }
                    System.out.println();
                    System.out.print("Tree content before deleting element: \n\n");
                    tree.inorder();
                    System.out.println();
                    System.out.print("\nTree content after deleting element: \n");
                    if(data == 1) {
                        tree.delete(storeI);
                    }
                    else if (data == 2) {
                        tree.delete(storeS);
                    }
                    System.out.println();
                    tree.inorder();
                    System.out.println();
                    break;
                case 3: // Searches for Data Element to see if it is in the tree
                    System.out.println("Testing method search()\n");
                    System.out.println("Please provide data value to be searched for: ");
                    if(data == 1) {
                        storeI = Integer.parseInt(scan.nextLine());
                    }
                    else if (data == 2) {
                        storeS = scan.nextLine();
                    }
                    System.out.println();
                    System.out.print("Searching... ");
                    if(data == 1){
                    if(tree.search(storeI)) {
                        System.out.println(storeI + " is in the tree");
                    }
                    else {
                        System.out.println("The element you searched for is not in the tree");
                    }
                    }
                    if(data == 2) {
                     if (tree.search(storeS)) {
                            System.out.println(storeS + " is in the tree");
                        }
                     else {
                         System.out.println("The element you searched for is not in the tree");
                     }
                    }
                    break;
                case 4: // will tell you how many elements are in the tree
                    System.out.println("Testing method getSize()\n");
                    System.out.println("Tree Size is: " + tree.getSize());
                    break;
                case 5: // will tell you the path from the root to a data element
                    System.out.println("Testing method path()\n");
                    System.out.println("Please provide data value to be looked for: ");
                    if(data == 1) {
                        storeI = Integer.parseInt(scan.nextLine());
                    }
                    else if (data == 2) {
                        storeS = scan.nextLine();
                    }
                    System.out.println();
                    System.out.print("Printing path: ");
                    if(data == 1) {
                        java.util.ArrayList<BST.TreeNode<Integer>> path = tree.path(storeI);
                        for (int i = 0; path != null && i < path.size(); i++)
                            System.out.print(path.get(i).element + " ");
                    }
                    else if (data == 2) {
                        java.util.ArrayList<BST.TreeNode<String>> path = tree.path(storeS);
                        for (int i = 0; path != null && i < path.size(); i++)
                            System.out.print(path.get(i).element + " ");
                    }
                    System.out.println();
                    break;
                case 6: // checks if tree is empty
                    System.out.println("Testing method isEmpty()\n");
                    if(tree.isEmpty()){
                        System.out.println("The tree is empty");
                    } else if (tree.isEmpty() == false) {
                        System.out.println("The tree is not empty");
                    }
                    break;
                case 7: // prints the tree in preorder
                    System.out.println("Testing method preorder()\n");
                    System.out.println("Printing the tree in preorder: \n");
                    tree.preorder();
                    System.out.println();
                    break;
                case 8: // prints the tree in inorder
                    System.out.println("Testing method inorder()\n");
                    System.out.println("Printing the tree in inorder: \n");
                    tree.inorder();
                    System.out.println();
                    break;
                case 9: // prints the tree in postorder
                    System.out.println("Testing method postorder()\n");
                    System.out.println("Printing the tree in postorder: \n");
                    tree.postorder();
                    System.out.println();
                    break;
                case 10: //terminates program
                    System.out.println("Exiting...");
                    break;
            }
        } while (choice != 10);
    }
}


