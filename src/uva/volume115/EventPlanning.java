package uva.volume115;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;

public class EventPlanning implements Closeable {

  private Scanner in = new Scanner(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    while (in.hasNextInt()) {
      int people = in.nextInt(), budget = in.nextInt(), hotels = in.nextInt(), weeks = in.nextInt();
      int result = MAX_VALUE;
      for (int i = 0; i < hotels; i++) {
        int pricePerNight = in.nextInt();
        int current = MAX_VALUE;
        for (int j = 0; j < weeks; j++) {
          int beds = in.nextInt();
          if (beds >= people && pricePerNight * people <= budget) {
            current = Math.min(current, pricePerNight * people);
          }
        }
        if (current < result) {
          result = current;
        }
      }
      out.println(result != MAX_VALUE ? result : "stay home");
    }
  }

  @Override
  public void close() throws IOException {
    in.close();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    try (EventPlanning instance = new EventPlanning()) {
      instance.solve();
    }
  }
}
