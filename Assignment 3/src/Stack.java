// Name: Sam Victorica
// Class: CS 3305 Section#: W03
// Term: Spring 2023
// Instructor: Prof. Majeed
// Assignment: 3
public class Stack <E> {
    public Node top; //points to the top of the stack
    public void Push(E element){ //replaces the top element with chose value
        if (top == null)
            top = new Node(element);
        else {
         Node temp = top;
         top = new Node(element);
         top.next = temp;
        }
    }
    public void Clear(){ //clears the stack
        top = null;
    }
    public E Pop(){ //removes the top element on the stack and returns its value
        if (top == null)
        return null;
        else {
            Node item = top;
            top = top.next;
            return item.data;
        }
    }
    public E Top(){ // returns the top element on the stack
        if (top == null)
            return null;
        else {
            return top.data;
        }
    }
    public int Size(){ //returns the total number of items in the stack
        if (top == null)
           return 0;
        else {
            int total = 1;
            Node current = top;
            while ( current.next != null) {
                total++;
                current = current.next;
            }
            return total;
        }
    }
    public boolean isEmpty(){ //returns true if the stack is empty
        if (top == null)
            return true;
        else
            return false;
    }
    public void Print(){ //prints the stack from top to bottom
        if (top == null)
           System.out.print("Stack is empty");
        else {
            Node current = top;
            System.out.print(current.data + "  ");
           while (current.next != null){
               current = current.next;
               System.out.print(current.data + "  ");
           }
        }
    }
    //class to create nodes as objects
    private class Node
    {
        private E data;  //data field
        private Node next; //link field

        public Node(E item) //constructor method
        {
            data = item;
            next = null;
        }
    }
}