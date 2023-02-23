// Name: Sam Victorica
// Class: CS 3305 Section#: W03
// Term: Spring 2023
// Instructor: Prof. Majeed
// Assignment: 4
public class Queue <E>{
    public Node front, end; //points to the beginning and end of the queue
    public void enqueue(E element){ //Adds the new element to the end of the queue
        if (front == null) {
            front = new Node(element);
            end = front;
        }
        else {
            Node temp = end;
            end = new Node(element);
            end.next = temp;
        }
    }
    public void Clear(){ //clears the stack
        front = null;
    }//Clears the queue
    public E dequeue(){ //removes first element in the queue and returns its data
        if (front == null)
            return null;
        else {
            Node currnet = end, item;
            if(currnet == front){
                front = null;
                return currnet.data;
            }
            while (currnet.next != front){
                currnet = currnet.next;
            }
            item = front;
            front = currnet;
            front.next = null;
            return item.data;
        }
    }
    public E front(){ // returns the front element of the queue
        if (front == null)
            return null;
        else {
            return front.data;
        }
    }
    public int Size(){ //returns the total number of items in the queue
        if (front == null)
            return 0;
        else {
            int total = 1;
            Node current = end;
            while ( current.next != null) {
                total++;
                current = current.next;
            }
            return total;
        }
    }
    public boolean isEmpty(){ //returns true if the queue is empty
        if (front == null)
            return true;
        else
            return false;
    }
    public void Print(){ //prints the queue from end to front
        if (front == null)
            System.out.print("Queue is empty");
        else {
            Node current = end;
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