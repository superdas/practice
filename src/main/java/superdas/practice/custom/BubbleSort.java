package superdas.practice.custom;

class BubbleSort {

  public static void main(String[] args) {
    System.out.println("bubble sort");

    int[] numbers = new int[] {2, 8, 9, 1, 7, 4, 5, 3, 6};
    System.out.print("Input ");
    printArray(numbers);

    //int[] sortedNumbers = bubbleSort(numbers);
    int[] sortedNumbers = bubbleSort2(numbers);

    System.out.print("Output ");
    printArray(sortedNumbers);
  }

  private static void printArray(int[] arr) {
    System.out.print("[");
    for (int i = 0; i < arr.length; i++) {
      if (i > 0) {
        System.out.print(", ");
      }
      System.out.print(arr[i]);
    }
    System.out.println("]");
  }

  private static int[] bubbleSort(int[] input) {
    for (int i = 1; i < input.length; i++) {
      for (int j = 1; j <= input.length - i; j++) {
        if (input[j - 1] > input[j]) {
          int tmp = input[j - 1];
          input[j - 1] = input[j];
          input[j] = tmp;
        }
      }
    }
    return input;
  }

  private static int[] bubbleSort2(int[] input) {
    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j < input.length - i - 1; j++) {
        if (input[j] > input[j + 1]) {
          int tmp = input[j];
          input[j] = input[j + 1];
          input[j + 1] = tmp;
        }
      }
    }
    return input;
  }
}
