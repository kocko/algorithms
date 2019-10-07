package codeforces.contests1101_1200.problemset1195;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class OpenStreetMap implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni(), a = in.ni(), b = in.ni();
    long g = in.nl(), x = in.nl(), y = in.nl(), z = in.nl();
    long[][] table = new long[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        table[i][j] = g;
        g = (g * x + y) % z;
      }
    }
    ArrayDeque<Long>[] queues = new ArrayDeque[m];
    for (int i = 0; i < m; i++) {
      queues[i] = new ArrayDeque<>();
    }
    for (int i = 0; i < a - 1; i++) {
      for (int j = 0; j < m; j++) {
        long value = table[i][j];
        while (queues[j].size() > 0 && queues[j].peekLast() > value) {
          queues[j].pollLast();
        }
        queues[j].addLast(value);
      }
    }
    long result = 0;
    for (int row = a - 1; row < n; row++) {
      ArrayDeque<Long> window = new ArrayDeque<>();
      if (row >= a) {
        for (int col = 0; col < m; col++) {
          long remove = table[row - a][col];
          if (queues[col].size() > 0 && queues[col].peekFirst() == remove) {
            queues[col].pollFirst();
          }
        }
      }

      for (int col = 0; col < m; col++) {
        long add = table[row][col];
        while (queues[col].size() > 0 && queues[col].peekLast() > add) {
          queues[col].pollLast();
        }
        queues[col].addLast(add);

        long columnMin = queues[col].peekFirst();
        while (window.size() > 0 && window.peekLast() > columnMin) {
          window.pollLast();
        }
        window.addLast(columnMin);
        if (col >= b) {
          long remove = queues[col - b].peekFirst();
          if (window.size() > 0 && window.peekFirst() == remove) {
            window.pollFirst();
          }
        }
        if (col >= b - 1) {
          result += window.peekFirst();
        }

      }
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
    try (OpenStreetMap instance = new OpenStreetMap()) {
      instance.solve();
    }
  }
}
