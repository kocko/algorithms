package codeforces.contests1301_1400.problemset1303;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class PerfectKeyboard implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      char[] p = in.next().toCharArray();
      List<Set<Integer>> graph = new ArrayList<>();
      for (int i = 0; i < 26; i++) {
        graph.add(new HashSet<>());
      }
      if (p.length == 1) {
        out.println("YES");
        out.println("bacdefghijklmnopqrstuvwxyz");
        continue;
      }
      for (int i = 0; i < p.length - 1; i++) {
        int u = p[i] - 'a', v = p[i + 1] - 'a';
        graph.get(u).add(v);
        graph.get(v).add(u);
      }
      boolean valid = true;
      int root = -1;
      for (int i = 0; i < 26; i++) {
        valid &= graph.get(i).size() <= 2;
        if (graph.get(i).size() == 1) {
          root = i;
        }
      }
      valid &= root != -1;
      if (valid) {
        boolean[] printed = new boolean[26];
        int current = root;
        StringBuilder keyboard = new StringBuilder();
        while (true) {
          if (!printed[current]) {
            keyboard.append((char) ('a' + current));
            printed[current] = true;
            for (int next : graph.get(current))
              if (!printed[next]) {
                current = next;
                break;
              }
          } else break;
        }
        for (int i = 0; i < 26; i++) {
          if (!printed[i]) {
            keyboard.append((char) ('a' + i));
          }
        }
        out.println("YES");
        out.println(keyboard);
      } else {
        out.println("NO");
      }
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
    try (PerfectKeyboard instance = new PerfectKeyboard()) {
      instance.solve();
    }
  }
}
