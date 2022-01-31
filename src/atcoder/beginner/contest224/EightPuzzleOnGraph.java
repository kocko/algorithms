package atcoder.beginner.contest224;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class EightPuzzleOnGraph implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public EightPuzzleOnGraph() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    graph = new ArrayList<>();
    for (int i = 0; i <= 8; i++) {
      graph.add(new ArrayList<>());
    }
    int M = in.ni();
    for (int i = 0; i < M; i++) {
      int u = in.ni(), v = in.ni();
      u %= 9; v %= 9;
      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    int[] value = new int[9];
    for (int i = 1; i <= 8; i++) {
      int pos = in.ni() % 9;
      value[pos] = i;
    }
    StringBuilder start = new StringBuilder();
    for (int i = 0; i <= 8; i++) {
      start.append(value[i]);
    }
    int result = bfs(start.toString());
    out.println(result);
  }

  private List<List<Integer>> graph;

  private int bfs(String start) {
    final String target = "012345678";
    Map<String, Integer> dist = new HashMap<>();
    dist.put(start, 0);

    ArrayDeque<String> queue = new ArrayDeque<>();
    queue.add(start);

    while (queue.size() > 0) {
      String T = queue.pollFirst();
      int d = dist.get(T);
      char[] top = T.toCharArray();
      int empty = -1;
      for (int i = 0; i <= 8; i++) {
        if (top[i] == '0') {
          empty = i;
          break;
        }
      }
      for (int u : graph.get(empty)) {
        String next = swap(top, u, empty);
        if (!dist.containsKey(next)) {
          dist.put(next, d + 1);
          queue.add(next);
        }
      }
    }
    return dist.getOrDefault(target, -1);
  }

  private String swap(char[] x, int a, int b) {
    char[] result = new char[x.length];
    for (int i = 0; i < x.length; i++) {
      if (i == a) {
        result[i] = x[b];
      } else if (i == b) {
        result[i] = x[a];
      } else {
        result[i] = x[i];
      }
    }
    return new String(result);
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
    try (EightPuzzleOnGraph instance = new EightPuzzleOnGraph()) {
      instance.solve();
    }
  }
}
