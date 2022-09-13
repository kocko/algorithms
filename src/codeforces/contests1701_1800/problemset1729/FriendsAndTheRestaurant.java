package codeforces.contests1701_1800.problemset1729;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class FriendsAndTheRestaurant implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      int[] x = new int[n], y = new int[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
      }
      for (int i = 0; i < n; i++) {
        y[i] = in.ni();
      }
      List<Integer> positive = new ArrayList<>(), negative = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        int diff = y[i] - x[i];
        if (diff >= 0) {
          positive.add(diff);
        } else {
          negative.add(diff);
        }
      }
      positive.sort(Comparator.naturalOrder());
      negative.sort(Comparator.reverseOrder());
      int days = 0, idx = 0, spare = 0;
      for (int pos : positive) {
        if (idx < negative.size()) {
          if (pos + negative.get(idx) >= 0) {
            days++;
            idx++;
          } else {
            spare++;
          }
        } else {
          spare++;
        }
      }
      days += spare / 2;
      out.println(days);
    }
  }

  @Override
  public void close() throws IOException {
    in.close();
    out.close();
  }

  static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int ni() {
      return Integer.parseInt(next());
    }

    public long nl() {
      return Long.parseLong(next());
    }

    public void close() throws IOException {
      reader.close();
    }
  }

  public static void main(String[] args) throws IOException {
    try (FriendsAndTheRestaurant instance = new FriendsAndTheRestaurant()) {
      instance.solve();
    }
  }
}