package uva.volume105;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WavioSequence implements Closeable {

  private Scanner in = new Scanner(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    while (in.hasNextInt()) {
      int n = in.nextInt();
      int[] x = new int[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.nextInt();
      }
      int[] forward = new int[n], backward = new int[n];
      int[] tails = new int[n];
      int len = 0;
      for (int i = 0; i < n; i++) {
        int next = x[i];
        int left = 0, right = len;
        while (left < right) {
          int mid = (left + right) / 2;
          if (tails[mid] < next) {
            left = mid + 1;
          } else {
            right = mid;
          }
        }
        tails[left] = next;
        if (left == len) len++;
        forward[i] = left + 1;
      }
      len = 0;
      tails = new int[n];
      for (int i = n - 1; i >= 0; i--) {
        int next = x[i];
        int left = 0, right = len;
        while (left < right) {
          int mid = (left + right) / 2;
          if (tails[mid] < next) {
            left = mid + 1;
          } else {
            right = mid;
          }
        }
        tails[left] = next;
        if (left == len) len++;
        backward[i] = left + 1;
      }
      int max = 1;
      for (int i = 0; i < n; i++) {
        if (forward[i] > 1 && backward[i] > 1) {
          int min = Math.min(forward[i], backward[i]);
          int size = 2 * min - 1;
          if (size > max) {
            max = size;
          }
        }
      }
      out.println(max);
    }
  }

  @Override
  public void close() throws IOException {
    in.close();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    try (WavioSequence instance = new WavioSequence()) {
      instance.solve();
    }
  }
}
