package codeforces.contests1201_1300.problemset1283;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class ChristmasTrees implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    List<Integer> list = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    for (int i = 0; i < n; i++) {
      int tree = in.ni();
      list.add(tree);
      visited.add(tree);
    }
    List<Integer> result = new ArrayList<>();
    long total = 0;
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    Map<Integer, Long> dist = new HashMap<>();
    for (int tree : list) {
        queue.add(tree);
        dist.put(tree, 0L);
    }
    while (result.size() < m) {
      int top = queue.pollFirst();
      long dst = dist.get(top);
      for (int point : new int[]{top - 1, top + 1}) {
        if (!visited.contains(point)) {
          queue.add(point);
          result.add(point);
          visited.add(point);
          dist.put(point, dst + 1);
          total += dst + 1L;
          if (result.size() == m) break;
        }
      }
    }
    out.println(total);
    for (int person : result) {
      out.print(person);
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
    try (ChristmasTrees instance = new ChristmasTrees()) {
      instance.solve();
    }
  }
}
