package codeforces.contests1201_1300.problemset1250;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TheFeastAndTheBus implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), teams = in.ni();
    int[] count = new int[teams];
    for (int i = 0; i < n; i++) {
      int t = in.ni() - 1;
      count[t]++;
    }
    Arrays.sort(count);
    long result = Long.MAX_VALUE;
    for (int rounds = teams / 2 + (teams % 2); rounds <= teams; rounds++) {
      int pairs = teams - rounds;
      int capacity = 0;
      int left = 0, right = 2 * pairs - 1;
      while (pairs > 0) {
        capacity = Math.max(capacity, count[left] + count[right]);
        left++;
        right--;
        pairs--;
      }
      int idx = 2 * pairs;
      while (idx < teams) {
        capacity = Math.max(capacity, count[idx++]);
      }
      result = Math.min(result, ((long) rounds) * capacity);
    }
    out.println(result);
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
    try (TheFeastAndTheBus instance = new TheFeastAndTheBus()) {
      instance.solve();
    }
  }
}
