package Stocks;

import java.util.*;

class BestStock {
  public double[] currentCost = {6, 5, 20};
  public double[] futureCost = {13, 10, 40};
  public ArrayList<Integer> profitable = new ArrayList<>();
  public List<Stock> rank = new ArrayList<>();
  public int budget = 25;

  public void GetMaxProfit() {
    int amount = currentCost.length;
    double profit = 0;

    for (int i = 0; i < amount; i++) {
      if (futureCost[i] > currentCost[i] && currentCost[i] <= budget) {
        profitable.add(i);
      }
    }

    for (Integer q : profitable) {
      rank.add(new Stock(currentCost[q], futureCost[q]));
    }

    Collections.sort(rank);
    Collections.reverse(rank);

    for (Stock stock : rank) {
      System.out.print(Math.round(stock.getCurrentPrice()) + " " + Math.round(stock.getFuturePrice()) + " " + Math.round(stock.getProfitRatio()) + " " + Math.round(stock.getProfit()) + " ");
      System.out.println();
    }

    ArrayList<Double> boughtCurrent = new ArrayList<>();
    ArrayList<Double> boughtFuture = new ArrayList<>();
    for (Stock o : rank) {
      double findCurrentPrice = o.getCurrentPrice();
      double findProfit = o.getProfit();
      if (budget >= findCurrentPrice) {
        budget -= findCurrentPrice;
        profit += findProfit;
        boughtCurrent.add(o.getCurrentPrice());
        boughtFuture.add(o.getFuturePrice());
      }
    }
    System.out.println("Current Price:");
    for (Double aDouble : boughtCurrent) {
      System.out.print(aDouble + " ");
    }
    System.out.println(" ");
    System.out.println("Future Price:");
    for (Double aDouble : boughtFuture) {
      System.out.print(aDouble + " ");
    }
    System.out.println(" ");
    System.out.println("Budget leftover: " + budget);
    System.out.println("Profit: " + profit);
  }
}