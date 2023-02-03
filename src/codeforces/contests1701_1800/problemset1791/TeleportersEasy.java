package codeforces.contests1701_1800.problemset1791;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class TeleportersEasy implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public TeleportersEasy() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  private class Teleporter implements Comparable<Teleporter> {
    private long where, cost;

    private Teleporter(long where, long cost) {
      this.where = where;
      this.cost = cost;
    }

    public long getTotalCost() {
      return where + cost;
    }

    @Override
    public int compareTo(Teleporter other) {
      return Long.compare(this.getTotalCost(), other.getTotalCost());
    }
  }


  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      long money = in.nl();
      List<Teleporter> teleporters = new ArrayList<>();
      for (int i = 1; i <= n; i++) {
        long cost = in.nl();
        teleporters.add(new Teleporter(i, cost));
      }
      teleporters.sort(Comparator.naturalOrder());
      int idx = 0;
      while (idx < n && money > 0) {
        long cost = teleporters.get(idx).getTotalCost();
        if (cost <= money) {
          money -= cost;
          idx++;
        } else break;
      }
      out.println(idx);
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
    try (TeleportersEasy instance = new TeleportersEasy()) {
      instance.solve();
    }
  }
}
