package codeforces.contests1701_1800.problemset1791;

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

public class TeleportersHard implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public TeleportersHard() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public class FenwickTree {
    private int MAX;
    private long[] tree;

    private FenwickTree(int n) {
      MAX = n;
      tree = new long[MAX + 1];
    }

    private void update(int idx, long delta) {
      for (; idx <= MAX; idx += (idx & -idx)) {
        tree[idx] += delta;
      }
    }

    private long query(int idx) {
      long result = 0;
      for (; idx > 0; idx -= (idx & -idx)) {
        result += tree[idx];
      }
      return result;
    }
  }

  private static class Teleporter implements Comparable<Teleporter> {
    private int idx;
    private int where;
    private int dist;
    private long cost;

    private Teleporter(int where, int dist, long cost) {
      this.where = where;
      this.dist = dist;
      this.cost = cost;
    }

    public long getTotalCost() {
      return dist + cost;
    }

    @Override
    public int compareTo(Teleporter other) {
      return Long.compare(this.getTotalCost(), other.getTotalCost());
    }
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      n = in.ni();
      long money = in.nl();
      List<Teleporter> teleporters = new ArrayList<>();
      long[] c = new long[n + 1];
      for (int i = 1; i <= n; i++) {
        long cost = in.nl();
        c[i] = cost;
        int dist = Math.min(i, n - i + 1);
        teleporters.add(new Teleporter(i, dist, cost));
      }
      teleporters.sort(Comparator.naturalOrder());
      FenwickTree tree = new FenwickTree(n);
      int idx = 1;
      for (Teleporter teleporter : teleporters) {
        teleporter.idx = idx;
        tree.update(idx++, teleporter.getTotalCost());
      }
      int result = 0;
      for (Teleporter teleporter : teleporters) {
        int hits = 0;
        long initialCost = teleporter.where + teleporter.cost;;
        if (initialCost <= money) {
          hits = 1;
          tree.update(teleporter.idx, -teleporter.getTotalCost());
          int additional = binarySearch(tree, money - initialCost);
          if (additional >= teleporter.idx) {
            additional--;
          }
          hits += additional;
          tree.update(teleporter.idx, teleporter.getTotalCost());
        }
        result = Math.max(result, hits);
      }
      out.println(result);
    }
  }

  private int n;

  private int binarySearch(FenwickTree tree, long money) {
    int left = 1, right = n;
    int result = 0;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      long prefix = tree.query(mid);
      if (prefix <= money) {
        result = Math.max(result, mid);
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return result;
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
    try (TeleportersHard instance = new TeleportersHard()) {
      instance.solve();
    }
  }
}
