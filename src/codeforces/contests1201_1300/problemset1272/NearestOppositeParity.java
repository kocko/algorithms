package codeforces.contests1201_1300.problemset1272;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Math.*;
import static java.util.Arrays.fill;

public class NearestOppositeParity implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public NearestOppositeParity() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int n = in.ni();
    int[] x = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = in.ni();
    }
    int[] result = new int[n];

    final int INF = (int) 1e7;
    fill(result, INF);

    Map<Integer, List<Integer>> reachableFrom = new HashMap<>();
    for (int i = 0; i < n; i++) {
      reachableFrom.put(i, new ArrayList<>());
    }
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    for (int idx = 0; idx < n; idx++) {
      for (int multiplier : new int[]{-1, 1}) {
        int to = idx + multiplier * x[idx];
        if (to >= 0 && to < n) {
          reachableFrom.get(to).add(idx);
          if (x[to] % 2 != x[idx] % 2) {
            result[idx] = 1;
            queue.add(idx);
          }
        }
      }
    }
    while (queue.size() > 0) {
      int to = queue.pollFirst();
      for (int from : reachableFrom.get(to)) {
        if (result[from] == INF) {
          result[from] = 1 + result[to];
          queue.add(from);
        }
      }
    }
    for (int idx = 0; idx < n; idx++) {
      out.print(result[idx] == INF ? -1: result[idx]);
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
    try (NearestOppositeParity instance = new NearestOppositeParity()) {
      instance.solve();
    }
  }
}
