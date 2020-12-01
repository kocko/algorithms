package timus.volume05;

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

import static java.lang.Integer.compare;

public class Courier implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class Package implements Comparable<Package> {
    private int idx, deadline, price;

    private Package(int idx, int deadline, int price) {
      this.idx = idx;
      this.deadline = deadline;
      this.price = price;
    }

    @Override
    public int compareTo(Package other) {
      int x = Integer.compare(deadline, other.deadline);
      return x != 0 ? x : -compare(price, other.price);
    }
  }

  public void solve() {
    n = in.ni();
    list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(new Package(i + 1, in.ni(), in.ni()));
    }
    list.sort(Comparator.naturalOrder());
    dp = new Integer[n][1001];
    next = new int[n][1001];
    recurse(0, 1);
    restore();
  }

  private int n;
  private List<Package> list;
  private Integer[][] dp;
  private int[][] next;

  private int recurse(int idx, int time) {
    if (idx == n) return 0;

    if (dp[idx][time] != null) return dp[idx][time];

    int ans = recurse(idx + 1, time);
    Package current = list.get(idx);
    if (current.deadline >= time) {
      int take = current.price + recurse(idx + 1, time + 1);
      if (take > ans) {
        ans = take;
        next[idx][time] = current.idx;
      }
    }
    return dp[idx][time] = ans;
  }

  private void restore() {
    int idx = 0, time = 1;
    List<Integer> result = new ArrayList<>();
    while (idx < n) {
      if (next[idx][time] != 0) {
        result.add(next[idx][time]);
        time++;
      }
      idx++;
    }
    out.println(result.size());
    for (int value : result) {
      out.print(value);
      out.print(' ');
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
    try (Courier instance = new Courier()) {
      instance.solve();
    }
  }
}
