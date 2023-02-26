package atcoder.beginner.contest291;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FindPermutation implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public FindPermutation() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int n = in.ni(), m = in.ni();
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    int[] degree = new int[n + 1];
    for (int i = 0; i < m; i++) {
      int u = in.ni(), v = in.ni();
      graph.get(u).add(v);
      degree[v]++;
    }
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    for (int i = 1; i <= n; i++) {
      if (degree[i] == 0) {
        queue.add(i);
      }
    }
    boolean can = queue.size() == 1;
    int idx = 1;
    int[] result = new int[n];
    while (queue.size() > 0) {
      if (queue.size() > 1) {
        can = false;
        break;
      }
      int top = queue.poll();
      result[top - 1] = idx++;
      for (int next : graph.get(top)) {
        if (--degree[next] == 0) {
          queue.add(next);
        }
      }
    }
    can &= idx == n + 1;
    if (can) {
      out.println("Yes");
      for (int i = 0; i < n; i++) {
        out.print(result[i]);
        out.print(' ');
      }
      out.println();
    } else {
      out.println("No");
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
    try (FindPermutation instance = new FindPermutation()) {
      instance.solve();
    }
  }
}
