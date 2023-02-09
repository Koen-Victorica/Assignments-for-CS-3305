/*
This class define a linked list that stores integer values.
*/
// Name: Sam Victorica
// Class: CS 3305 Section#: W03
// Term: Spring 2023
// Instructor: Prof. Majeed
// Assignment: 2
public class LinkedList
{
   public Node head, tail;

   //constructor method to create a list of object with head, tail, and size. 
   public LinkedList()
   {
      head = null;
      tail = null;
   }
  
   //method add node to end of list
   public void addLastNode(int data) 
   {
      if (tail == null) 
         head = tail = new Node(data); //empty list
      else 
      {
         tail.next = new Node(data); //link new node as last node
         tail = tail.next; //make tail pointer points to last node
      }
   }
  
   //======== Your part to complete for this assignment =========
   
   //method #1: add first node
   public void addFirstNode(int data)
   {
      Node temp;
      if (tail == null) //if the list is empty head and tail are set to the new mode
         head = tail = new Node(data); //empty list
         else
         { //if the list is not empty head is made the new node in the list
            temp = head;
            head = new Node(data);
            head.next = temp;
         }
   }

      
   //method #2: add node at index
   public void addAtIndex(int index, int data)
   {
      Node temp, temp2;
      if (tail == null) //if the list is empty head and tail are set to the new mode
         head = tail = new Node(data); //empty list
      else{
         temp = head;
         for (int i = 0; i < index-1; i++){ //iterate through the list to find desired index
            temp = temp.next;
         }
         if (temp == tail){ //if the index would be past the tail set the tail to the new value
            temp.next = new Node(data);
            tail = temp.next;
            tail.next= null;
         }
         else if (index == 0){ //if the index would be the new head, set the head to the new value
            temp = head;
            head = new Node(data);
            head.next = temp;
         }
         else { //place the new node in the list
            temp2 = temp.next;
            temp.next = new Node(data);
            temp.next.next = temp2;
         }
      }
   }
      
   //method #3: remove first node
   public void removeFirstNode() // removes the first node
   {
         head = head.next;
   }
      
   //method #4: remove last node
   public void removeLastNode()
   {
      Node temp;
         temp = head;
         while (temp.next != tail){ // iterates to the tail
            temp = temp.next;
         }
         tail = temp; //removes the last node
         tail.next = null;
   }
    
   //method #5: remove node at index
   public void removeAtIndex(int index)
   {
      Node temp;
      temp = head;
         for (int i = 0; i < index-1; i++){ //iterate through the loop to find desired index
            temp = temp.next;
         }
         if (index == 0){ //if you are trying to remove the head then head is the next value
            head = head.next;
         }
         if (temp.next == tail){ //if you are trying to remove the tail redefine tail to the one before
            tail = temp;
            tail.next = null;
         }
         else { //remove the specified node
            temp.next = temp.next.next;
         }
   }
          
   //method #6: countNodes
   public int countNodes()
   {
      Node temp;
      //this methods returns the list size
         int listSize= 0;
         if (tail != null) {
            temp = head;
            while(temp.next != null){ //count the list by adding 1 for each node
               listSize++;
               temp=temp.next;
            }
            return listSize + 1; // add one to the final value to receive the total number of nodes
         }
      return listSize; //if the list is empty return 0
   }
   
   //method #7: pritnInReverse  (Recursive method)
   public void printInReverse(Node L)
   {
      Node temp;
      temp = head;
      if (tail == null) { //if the list is empty print that it is
         System.out.println("List is Empty");
         return;
      }

      if (L == head){ // if you have reached the head just print the heads data
         System.out.print(head.data);
         return;
      }
      else{
         System.out.print(L.data + "   "); //print the current nodes' data, it will start with the tail
         while (temp.next != L){ // traverse the list to the node before L
            temp = temp.next;
         }
         L = temp; // change L to the one before it
         printInReverse(L); // do the method again with the new Node L
         return;
      }
   }   

   //================= end of your part ==============

   //method to print out the list
   public void printList() 
   {
      if (tail == null)
         System.out.println("List is Empty");
      Node temp;
      temp = head;
      while (temp != null)
      {
         System.out.print(temp.data + "   ");
         temp = temp.next;
      }
   }
  
   //class to create nodes as objects
   private class Node
   {
      private int data;  //data field
      private Node next; //link field
       
      public Node(int item) //constructor method
      {
         data = item;
         next = null;
      }
   }
}

