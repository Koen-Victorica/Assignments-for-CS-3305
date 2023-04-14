// Generic code for class priority_queue_heap for Assignment 5 
// Name: Sam Victorica
// Class: CS 3305 Section#: W03
// Term: Spring 2023
// Instructor: Prof. Majeed
// Assignment: 6
 public class PQ_Heap <E extends Comparable<E>>{
    Heap<E> heap = new Heap<E>();
    int max = 0;
    // Constructor method
    PQ_Heap() {};
    PQ_Heap(int Max) {
        max = Max;
    };

    // Return true if priority queue is empty; otherwise return false
    public boolean is_empty() {
        if (heap.getSize() == 0){
            return true;
        }
        else return false;
    };

    //prints the heap
    public void print() {
        heap.print();
    };

    // Return true if priority queue is full; otherwise return false
    public boolean is_full() {
       if (heap.getSize() == max){
           return true;
       }
       else return false;
    };

    // Return (don't remove) the front element from the priority queue
    // Precondition: priority queue is not empty.
    public E front() {
        if (is_empty() == true){
            return null;
        }
        else return heap.front();
    };

    // return number of elements in the queue
    public int size() {
        return heap.getSize();
    };

    // Remove the largest value from this priority queue and return it.
    // Precondition: priority queue is not empty.
    public E dequeue() {
        if (is_empty() == true){
            return null;
        }
        else return heap.remove();
    };

    // Inserts the 'value' into the priority queue.
    // Precondition: priority queue is not full
    public void enqueue(E value) {
        if (is_full() != true){
            heap.add(value);
        }
        else {
            System.out.println("Priority Queue is full");
        }
    };
};
