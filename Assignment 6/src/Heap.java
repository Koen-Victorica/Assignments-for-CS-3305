import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
// Class Heap.java
// Textbook - Listing 23.9, Page 878
// Name: Sam Victorica
// Class: CS 3305 Section#: W03
// Term: Spring 2023
// Instructor: Prof. Majeed
// Assignment: 6
public class Heap<E extends Comparable<E>> {
  private java.util.ArrayList<E> list = new java.util.ArrayList<E>();

  /**
   * Create a default heap
   */
  public Heap() {
  }

  /**
   * Create a heap from an array of objects
   */
  public Heap(E[] objects) {
    for (int i = 0; i < objects.length; i++)
      add(objects[i]);
  }

  /**
   * Add a new object into the heap
   */
  public void add(E newObject) {
    list.add(newObject); // Append to the heap
    int currentIndex = list.size() - 1; // The index of the last node

    while (currentIndex > 0) {
      int parentIndex = (currentIndex - 1) / 2;
      // Swap if the current object is greater than its parent
      if (list.get(currentIndex).compareTo(
              list.get(parentIndex)) > 0) {
        E temp = list.get(currentIndex);
        list.set(currentIndex, list.get(parentIndex));
        list.set(parentIndex, temp);
      } else
        break; // the tree is a heap now

      currentIndex = parentIndex;
    }
  }

  /**
   * Remove the root from the heap
   */
  public E remove() {
    if (list.size() == 0) return null;

    E removedObject = list.get(0);
    list.set(0, list.get(list.size() - 1));
    list.remove(list.size() - 1);

    int currentIndex = 0;
    while (currentIndex < list.size()) {
      int leftChildIndex = 2 * currentIndex + 1;
      int rightChildIndex = 2 * currentIndex + 2;

      // Find the maximum between two children
      if (leftChildIndex >= list.size()) break; // The tree is a heap
      int maxIndex = leftChildIndex;
      if (rightChildIndex < list.size()) {
        if (list.get(maxIndex).compareTo(
                list.get(rightChildIndex)) < 0) {
          maxIndex = rightChildIndex;
        }
      }

      // Swap if the current node is less than the maximum
      if (list.get(currentIndex).compareTo(
              list.get(maxIndex)) < 0) {
        E temp = list.get(maxIndex);
        list.set(maxIndex, list.get(currentIndex));
        list.set(currentIndex, temp);
        currentIndex = maxIndex;
      } else
        break; // The tree is a heap
    }

    return removedObject;
  }

  //return root node
  public E front() {
    return list.get(0);
  }

  /**
   * Get the number of nodes in the tree
   */
  public int getSize() {
    return list.size();
  }
// prints the queue (this was the best solution I could come up with because I struggled with the formatting)
  public void print() {
    int index = 0;
    ArrayList<E> children = new ArrayList<E>();
    for (E data : list) {
      System.out.print("Index " + index + ": " + data + " ");
      if (index + 1 < list.size()){
        if (children.contains(list.get(index+1))) {
          if (index + 2 < list.size()) {
            if (children.contains(list.get(index+2))){

            }
            else {
              System.out.print(list.get(index + 2) + " ");
              children.add(list.get(index + 2));
            }
          }
        }
        else {
          System.out.print(list.get(index + 1) + " ");
          children.add(list.get(index+1));
        }
      }
      if (index + 2 < list.size()){
        if (children.contains(list.get(index+2))) {
          if (index + 3 < list.size()) {
            if (children.contains(list.get(index+3))){

            }
            else {
              System.out.print(list.get(index + 3) + " ");
              children.add(list.get(index + 3));
            }
          }
        }
        else {
          System.out.print(list.get(index + 2) + " ");
          children.add(list.get(index+2));
        }
        }
      System.out.println();
      index++;
      }
    }
  }




