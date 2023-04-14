// Class HeapSort.java 
// Textbook - Listing 23.10, Page 879
// Name: Sam Victorica
// Class: CS 3305 Section#: W03
// Term: Spring 2023
// Instructor: Prof. Majeed
// Assignment: 6
public class HeapSort {
   /** Heap sort method */
   public static <E extends Comparable<E>> void heapSort(E[] list) {
      // Create a Heap of integers
      Heap<E> heap = new Heap<E>();
   
      // Add elements to the heap
      for (int i = 0; i < list.length; i++)
         heap.add(list[i]);
   
      // Remove elements from the heap
      for (int i = list.length - 1; i >= 0; i--)
         list[i] = heap.remove();
   }
   
   /** A test method */
   public static void main(String[] args) {
    
      Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53}; 
      
      System.out.print("Original List:\t");  //print original list
      for (int i = 0; i < list.length; i++)
         System.out.print(list[i] + " ");
         
      heapSort(list);  //sort the list
      
      System.out.print("\n\nSorted List:\t");  //print original list
      for (int i = 0; i < list.length; i++)
         System.out.print(list[i] + " ");   
   }
}
