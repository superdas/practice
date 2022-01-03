package superdas.practice.custom;

import java.util.Arrays;

public class ReverseLinkedList {
  public static void main(String[] args) {
    LinkedListNode list = generateLinkedList(10);
    print(list);
    print(reverse(list));
  }

  static LinkedListNode reverse(LinkedListNode list) {
    System.out.println("Reverse!");
    LinkedListNode next = list.next;
    list.next = null;
    while (next != null) {
      LinkedListNode temp = next.next;
      next.next = list;
      list = next;
      next = temp;
    }
    return list;
  }

  static class LinkedListNode {
    int value;
    LinkedListNode next;
  }

  static LinkedListNode generateLinkedList(int size) {
    LinkedListNode head = new LinkedListNode();
    head.value = 0;
    LinkedListNode last = head;
    for (int i = 1; i < size; i++) {
      LinkedListNode next = new LinkedListNode();
      next.value = i;
      last.next = next;
      last = next;
    }
    return head;
  }

  static void print(LinkedListNode list) {
    System.out.print("[" + list.value);
    list = list.next;
    while (list != null) {
      System.out.print(", " + list.value);
      list = list.next;
    }
    System.out.println("]");
  }
}
