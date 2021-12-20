package codeforces.contests1601_1700.problemset1619;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class UnusualMinesweeper implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public UnusualMinesweeper() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public class DisjointSet {

    private int[] root, size, minTime;

    public DisjointSet(int n) {
      root = new int[n];
      size = new int[n];
      minTime = new int[n];
      for (int i = 0; i < n; i++) {
        root[i] = i;
        size[i] = 1;
      }
    }

    private int root(int x) {
      return (x == root[x]) ? x : (root[x] = root(root[x]));
    }

    private void join(int a, int b) {
      int x = root(a), y = root(b);
      if (x != y) {
        if (size[x] < size[y]) {
          int t = x;
          x = y;
          y = t;
        }
        size[x] += size[y];
        root[y] = x;
        minTime[x] = Math.min(minTime[x], minTime[y]);
      }
    }

  }

  private class Mine {
    private int idx, x, y, time;

    private Mine(int idx, int x, int y, int time) {
      this.idx = idx;
      this.x = x;
      this.y = y;
      this.time = time;
    }

    public int getRow() {
      return y;
    }

    public int getCol() {
      return x;
    }
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), k = in.ni();
      DisjointSet dsu = new DisjointSet(n);
      List<Mine> mines = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        Mine next = new Mine(i, in.ni(), in.ni(), in.ni());
        mines.add(next);
        dsu.minTime[i] = next.time;
      }
      mines.sort(Comparator.comparingInt(Mine::getRow).thenComparing(Mine::getCol));
      Mine prev = null;
      for (Mine mine : mines) {
        int start = mine.getCol() - k, end = mine.getCol() + k;
        if (prev != null && prev.getRow() == mine.getRow()) {
          boolean reaching = prev.x >= start && prev.x <= end;
          if (reaching) {
            dsu.join(mine.idx, prev.idx);
          }
        }
        prev = mine;
      }
      mines.sort(Comparator.comparingInt(Mine::getCol));
      prev = null;
      for (Mine mine : mines) {
        int start = mine.getRow() - k, end = mine.getRow() + k;
        if (prev != null && prev.getCol() == mine.getCol()) {
          boolean reaching = prev.y >= start && prev.y <= end;
          if (reaching) {
            dsu.join(mine.idx, prev.idx);
          }
        }
        prev = mine;
      }

      List<Integer> minTimes = new ArrayList<>();
      for (int idx = 0; idx < n; idx++) {
        if (dsu.root(idx) == idx) {
          minTimes.add(dsu.minTime[idx]);
        }
      }
      minTimes.sort(Comparator.naturalOrder());
      int mt = minTimes.size();
      int left = 0, right = minTimes.get(mt - 1), result = Integer.MAX_VALUE;
      while (left <= right) {
        int mid = left + (right - left) / 2;
        int self = 0;
        for (int time : minTimes) {
          if (time <= mid) {
            self++;
          } else break;
        }
        int others = mt - self;
        if (others <= mid + 1) {
          result = Math.min(result, mid);
          right = mid - 1;
        } else {
          left = mid + 1;
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
    try (UnusualMinesweeper instance = new UnusualMinesweeper()) {
      instance.solve();
    }
  }
}
