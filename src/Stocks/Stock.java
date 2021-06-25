package Stocks;

public class Stock implements Comparable<Stock> {
  double CurrentPrice;
  double FuturePrice;
  double profitRatio;

  Stock (double currentPrice, double futurePrice) {
    CurrentPrice = currentPrice;
    FuturePrice = futurePrice;
    profitRatio = (FuturePrice - CurrentPrice) / CurrentPrice;
  }

  double getProfitRatio() {
    return profitRatio * 100;
  }

  double getCurrentPrice() {
    return CurrentPrice;
  }

  double getFuturePrice() {
    return FuturePrice;
  }

  double getProfit() {
    return FuturePrice - CurrentPrice;
  }

  public int compareTo(Stock compareStock) {
    return Double.compare(this.getProfitRatio(), compareStock.getProfitRatio());
  }
}