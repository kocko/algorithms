package codeforces.contests1801_1900.problemset1851;

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
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class NastyaAndPotions implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public NastyaAndPotions() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni(), k = in.ni();
      long[] cost = new long[n + 1];
      long[] result = new long[n + 1];
      long[] sum = new long[n + 1];
      for (int i = 1; i <= n; i++) {
        cost[i] = in.nl();
        sum[i] = -1;
      }
      boolean[] has = new boolean[n + 1];
      for (int i = 0; i < k; i++) {
        int which = in.ni();
        has[which] = true;
        cost[which] = 0;
      }
      List<List<Integer>> graph = new ArrayList<>();
      for (int i = 0; i <= n; i++) {
        graph.add(new ArrayList<>());
      }
      int[] degree = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        int m = in.ni();
        for (int j = 0; j < m; j++) {
          int v = in.ni();
          degree[i]++;
          graph.get(v).add(i);
        }
      }

      ArrayDeque<Integer> queue = new ArrayDeque<>();
      for (int i = 1; i <= n; i++) {
        if (degree[i] == 0) {
          queue.add(i);
        }
      }

      while (queue.size() > 0) {
        int next = queue.pollFirst();
        if (sum[next] == -1) {
          result[next] = has[next] ? 0 : cost[next];
        } else {
          result[next] = Math.min(sum[next], cost[next]);
        }
        for (int v : graph.get(next)) {
          if (sum[v] == -1) {
            sum[v] = result[next];
          } else {
            sum[v] += result[next];
          }
          if (--degree[v] == 0) {
            queue.add(v);
          }
        }
      }
      for (int i = 1; i <= n; i++) {
        out.print(result[i]);
        out.print(' ');
      }
      out.println();
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
    try (NastyaAndPotions instance = new NastyaAndPotions()) {
      instance.solve();
    }
  }
}
