package superdas.practice.custom;

import java.util.LinkedList;

public class MaxStack {
  public static void main(String[] args) {
    System.out.println("superdas.practice.custom.MaxStack START");

    MaxStack stack = new MaxStack();
    stack.push(1);
    stack.push(5);
    stack.push(3);
    stack.push(10);
    stack.pop();


    System.out.println("superdas.practice.custom.MaxStack END");
  }

  private final LinkedList<Integer> values = new LinkedList<>();
  private final LinkedList<Integer> maxValues = new LinkedList<>();

  void push(Integer value) {
    values.add(value);
    if (maxValues.isEmpty() || maxValues.getLast() <= value) {
      maxValues.add(value);
    }
    System.out.println("> Push " + value);
    System.out.println("< Max is now " + getMax());
  }

  Integer pop() {
    if (values.isEmpty()) {
      System.out.println("> !!! Trying to pop an empty stack.");
      return null;
    }

    int value = values.removeLast();
    if (maxValues.getLast() == value) {
      maxValues.removeLast();
    }

    System.out.println("> Pop " + value);
    System.out.println("< Max is now " + getMax());
    return value;
  }

  Integer getMax() {
    if (maxValues.isEmpty()) {
      return null;
    }
    return maxValues.getLast();
  }
}
