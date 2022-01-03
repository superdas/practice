package superdas.practice.custom;

import java.util.Arrays;

public class MaximizeProfitFromTwoTrades {

  public static void main(String[] args) {
    System.out.println("Starting superdas.practice.custom.MaximizeProfitFromTwoTrades.");

    int[] stockPrices = {
      10, 20, 10, 30, 5, 27
    };
    print(stockPrices);
    System.out.println(Arrays.toString(stockPrices));

    int maximumProfit = getMaximumProfit(stockPrices);
    System.out.println("Maximum profit: $" + maximumProfit);

    System.out.println("End.");
  }

  private static void print(int[] stockPrices) {
    for (int i = 0; i < stockPrices.length; i++) {
      System.out.println(String.format("%2d min -> $%d", i, stockPrices[i]));
    }
  }

  private static int getMaximumProfit(int[] stockPrices) {
    int minBuyPrice = stockPrices[0];
    int maxProfit = Integer.MIN_VALUE;
    for (int i = 1; i < stockPrices.length; i++) {
      int sellPrice = stockPrices[i];
      int profit = sellPrice - minBuyPrice;
      maxProfit = Math.max(maxProfit, profit);
      minBuyPrice = Math.min(minBuyPrice, sellPrice);
    }
    return maxProfit;
  }
}
