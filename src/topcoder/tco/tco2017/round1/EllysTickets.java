package topcoder.tco.tco2017.round1;

public class EllysTickets {

  public double getPrice(int[] ticketPrice, int fine) {
    int n = ticketPrice.length;
    double min = fine;
    for (int buyAt = 0; buyAt < n; buyAt++) {
      int price = ticketPrice[buyAt];
      double penalty = (double) buyAt / n;
      min = Math.min(fine * penalty + (1 - penalty) * price, min);
    }
    return min;
  }

}
