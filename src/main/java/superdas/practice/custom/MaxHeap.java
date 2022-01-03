package superdas.practice.custom;

import java.util.ArrayList;

/**
 * A data structure that optimizes keeping track of its maximum element.
 * It is a tree with a root that is always its maximum element. The invariant is that a node has a
 * higher value than its children.
 */
public class MaxHeap {
  public static void main(String[] args) {
    MaxHeap heap = new MaxHeap();
    heap.push(5);
    heap.push(1);
    heap.push(10);
    heap.push(50);
    heap.push(45);
    heap.push(100);
    heap.pop();
    heap.push(49);
    heap.pop();
    heap.pop();
    heap.pop();
    heap.pop();
    heap.pop();
    heap.pop();
  }

  private final ArrayList<Integer> arr = new ArrayList<>();

  public MaxHeap() {}

  public Integer getMax() {
    return arr.isEmpty() ? null : arr.get(0);
  }

  public void push(int value) {
    arr.add(value);
    int index = arr.size() - 1;
    bubbleUp(index);
    System.out.println("Pushing " + value + ". Heap: " + arr + ".");
  }

  private void bubbleUp(int index) {
    //     a
    //   b   c
    //  d e f g
    //
    // 0: a
    // 1: b 1/2=0
    // 2: c 2/2=1
    // 3: d 3/2=1
    // 4: e 4/2=2
    // 5: f 5/2=2
    // 6: g 6/2=3
    //
    // If 0, already at the root.
    // Otherwise, the parent is (index - 1) / 2.
    if (index == 0) {
      return;
    }

    int parentIndex = (index - 1) / 2;
    int thisValue = arr.get(index);
    int parentValue = arr.get(parentIndex);
    if (thisValue > parentValue) {
      arr.set(index, parentValue);
      arr.set(parentIndex, thisValue);
      bubbleUp(parentIndex);
    }
  }

  public Integer pop() {
    if (arr.isEmpty()) {
      System.out.println("Can't pop an empty stack.");
      return null;
    }
    int root = arr.get(0);
    int last = arr.remove(arr.size() - 1);
    if (!arr.isEmpty()) {
      arr.set(0, last);
      bubbleDown(0);
    }
    System.out.println("Popping " + root + ". Heap: " + arr + ".");
    return root;
  }

  private void bubbleDown(int index) {
    int thisValue = arr.get(index);
    int rightChildIndex = (index + 1) * 2;
    int leftChildIndex = rightChildIndex - 1;
    
    if (leftChildIndex >= arr.size()) {
      return;
    }
    int maxChild = arr.get(leftChildIndex);
    int maxChildIndex = leftChildIndex;

    if (rightChildIndex < arr.size()) {
      int rightChild = arr.get(rightChildIndex);
      if (rightChild > maxChild) {
        maxChild = rightChild;
        maxChildIndex = rightChildIndex;
      }
    }

    if (maxChild > thisValue) {
      arr.set(index, maxChild);
      arr.set(maxChildIndex, thisValue);
      bubbleDown(maxChildIndex);
    }
  }

  public void print() {
    System.out.println("{max: " + getMax() + ", arr: " + arr + "}");
  }
}
