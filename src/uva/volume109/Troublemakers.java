package uva.volume109;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;

public class Troublemakers implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni(), testCase = 1;
    while (T-- > 0) {
      n = in.ni();
      m = in.ni();
      graph = new int[n][n];
      for (int i = 0; i < m; i++) {
        int u = in.ni() - 1, v = in.ni() - 1;
        graph[u][v] = graph[v][u] = 1;
      }
      List<Integer> cut = split();
      int L = cut.size();
      out.printf("Case #%d: %d\n", testCase++, L);
      for (int i = 0; i < L; i++) {
        out.print(cut.get(i) + 1);
        if (i < cut.size() - 1) {
          out.print(' ');
        }
      }
      out.println();
    }
  }

  private int n, m;
  private int[][] graph;

  private List<Integer> split() {
    List<List<Integer>> seen = new ArrayList<>();
    for (int round = 0; round < 30; round++) {
      Random random = new Random();
      Set<Integer> selection = new HashSet<>();
      while (selection.size() < n / 2) {
        selection.add(random.nextInt(n));
      }
      List<Integer> first = new ArrayList<>(selection);
      if (seen(seen, first)) continue;
      List<Integer> second = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        if (!selection.contains(i)) {
          second.add(i);
        }
      }
      int a = score(first), b = score(second);
      if (2 * (a + b) <= m) {
        return first;
      }
      seen.add(first);
    }
    throw new RuntimeException();
  }

  private boolean seen(List<List<Integer>> seen, List<Integer> selection) {
    boolean result = false;
    for (List<Integer> entry : seen) {
      result |= match(entry, selection);
    }
    return result;
  }

  private boolean match(List<Integer> a, List<Integer> b) {
    boolean match = true;
    for (int i = 0; i < a.size(); i++) {
      match &= a.get(i).equals(b.get(i));
    }
    return match;
  }

  private int score(List<Integer> room) {
    int a = 0;
    for (int i = 0; i < room.size(); i++) {
      for (int j = i + 1; j < room.size(); j++) {
        int u = room.get(i), v = room.get(j);
        if (graph[u][v] == 1) {
          a++;
        }
      }
    }
    return a;
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
    try (Troublemakers instance = new Troublemakers()) {
      instance.solve();
    }
  }
}
