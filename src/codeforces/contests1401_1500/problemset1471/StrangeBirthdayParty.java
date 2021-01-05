package codeforces.contests1401_1500.problemset1471;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class StrangeBirthdayParty implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni();
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        list.add(in.ni() - 1);
      }
      list.sort(Comparator.naturalOrder());
      long[] cost = new long[m];
      for (int i = 0; i < m; i++) {
        cost[i] = in.nl();
      }
      long result = 0;
      int nextPresent = 0;
      for (int i = n - 1; i >= 0; i--) {
        int k = list.get(i);
        if (cost[nextPresent] >= cost[k]) {
          result += cost[k];
        } else {
          result += cost[nextPresent];
          nextPresent++;
        }
      }
      out.println(result);
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
    try (StrangeBirthdayParty instance = new StrangeBirthdayParty()) {
      instance.solve();
    }
  }
}
