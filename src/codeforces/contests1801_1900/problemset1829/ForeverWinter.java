package codeforces.contests1801_1900.problemset1829;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class ForeverWinter implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public ForeverWinter() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni(), m = in.ni();
      graph = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        graph.add(new ArrayList<>());
      }
      degree = new int[n];
      for (int i = 0; i < m; i++) {
        int u = in.ni() - 1, v = in.ni() - 1;
        graph.get(u).add(v);
        graph.get(v).add(u);
        degree[u]++;
        degree[v]++;
      }
      int x = shrink();
      int y = shrink();
      out.println(y + " " + x);
    }
  }

  private int[] degree;
  private List<List<Integer>> graph;

  private int shrink() {
    int n = graph.size();
    Map<Integer, Integer> incoming = new HashMap<>();
    List<Integer> leaves = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (degree[i] == 1) {
        leaves.add(i);
      }
    }
    for (int leave : leaves) {
      degree[leave]--;
      for (int next : graph.get(leave)) {
        if (degree[next] != 0) {
          degree[next]--;
          incoming.put(next, incoming.getOrDefault(next, 0) + 1);
        }
      }
    }
    return incoming.entrySet().iterator().next().getValue();
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
    try (ForeverWinter instance = new ForeverWinter()) {
      instance.solve();
    }
  }
}
