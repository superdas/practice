package superdas.practice.custom;

class MergeSort {

  public static void main(String[] args) {
    System.out.println("merge sort");

    int[] numbers = new int[] {2, 8, 9, 1, 7, 4, 5, 3, 6};
    System.out.print("Input ");
    printArray(numbers);

    int[] sortedNumbers = mergeSort(numbers, 0, numbers.length);

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

  private static int[] mergeSort(int[] input, int startInclusive, int endExclusive) {
    int length = endExclusive - startInclusive;
    if (length <= 1) {
      return new int[] { input[startInclusive] };
    }

    // Split input into two parts.
    int middle = startInclusive + length / 2;
    int[] part1 = mergeSort(input, startInclusive, middle);
    int[] part2 = mergeSort(input, middle, endExclusive);

    // Sort each part.
    int[] output = new int[length];
    int index1 = 0;
    int index2 = 0;
    for (int i = 0; i < length; i++) {
      if (index1 >= part1.length) {
        output[i] = part2[index2];
        index2++;
      } else if (index2 >= part2.length) {
        output[i] = part1[index1];
        index1++;
      } else if (part1[index1] < part2[index2]) {
        output[i] = part1[index1];
        index1++;
      } else {
        output[i] = part2[index2];
        index2++;
      }
    }
    return output;
  }
}
