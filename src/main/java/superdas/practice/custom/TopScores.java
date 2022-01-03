package superdas.practice.custom;

import java.util.Arrays;
import java.util.Random;

public class TopScores {
  public static void main(String[] args) {
    System.out.println("Starting superdas.practice.custom.TopScores.");

    int numScores = 50;
    int highestPossibleScore = 100;

    System.out.println("Generating random numbers...");
    Random random = new Random();
    int[] scores = new int[numScores];
    for (int i = 0; i < scores.length; i++) {
      scores[i] = random.nextInt(highestPossibleScore + 1);
    }
    System.out.println("Generated:");
    System.out.println(Arrays.toString(scores));

    System.out.println("Sorted:");
    printSortedScores(scores, highestPossibleScore);

    System.out.println("End.");
  }

  static void printSortedScores(int[] scores, int highestPossibleScores) {
    int[] scoreToCount = new int[highestPossibleScores + 1];
    for (int i = 0; i < scores.length; i++) {
      scoreToCount[scores[i]] += 1;
    }

    int[] sortedScores = new int[scores.length];
    int sortedScoresIndex = 0;
    for (int i = 0; i < scoreToCount.length; i++) {
      for (int j = 0; j < scoreToCount[i]; j++) {
        sortedScores[sortedScoresIndex] = i;
        sortedScoresIndex++;
      }
    }

    System.out.println(Arrays.toString(sortedScores));
  }
}
