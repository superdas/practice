package superdas.practice.custom;

class InsertionSort {

  public static void main(String[] args) {
    System.out.println("insertion sort");

    int[] numbers = new int[] {2, 8, 9, 1, 7, 4, 5, 3, 6};
    System.out.print("Input ");
    printArray(numbers);

    int[] sortedNumbers = sort(numbers);

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

  private static int[] sort(int[] input) {
    for (int unsortedIndex = 1; unsortedIndex < input.length; unsortedIndex++) {
      int insertionIndex = 0;
      int unsortedValue = input[unsortedIndex];
      while (insertionIndex < unsortedIndex) {
        if (input[insertionIndex] > unsortedValue) {
          break;
        }
        insertionIndex++;
      }


      for (int j = unsortedIndex; j > insertionIndex; j--) {
        int tmp = input[j - 1];
        input[j - 1] = input[j];
        input[j] = tmp;
      }

      input[insertionIndex] = unsortedValue;
    }
    return input;
  }
}
