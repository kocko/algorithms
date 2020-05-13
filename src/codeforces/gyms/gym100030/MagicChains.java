package codeforces.gyms.gym100030;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class MagicChains implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public MagicChains() throws IOException {
    in = new InputReader(new FileInputStream(new File("input.txt")));
    out = new PrintWriter(new FileOutputStream(new File("output.txt")));
  }

  public void solve() {
    n = in.ni();
    words = new String[n];
    for (int i = 0; i < n; i++) {
      words[i] = in.next();
      indexOf.put(words[i], i);
      graph.add(new ArrayList<>());
    }
    for (int u = 0; u < n; u++) {
      String word = words[u];
      for (int change = 0; change < word.length(); change++) {
        char[] newWord = word.toCharArray();
        for (int with = 0; with < 26; with++) {
          if (with != (word.charAt(change) - 'a')) {
            newWord[change] = (char) ('a' + with);
            String key = new String(newWord);
            if (indexOf.containsKey(key)) {
              int v = indexOf.get(key);
              graph.get(u).add(v);
            }
          }
        }
      }
    }
    bfs();
  }

  private int n;
  private String[] words;
  private Map<String, Integer> indexOf = new HashMap<>();
  private List<List<Integer>> graph = new ArrayList<>();

  private void bfs() {
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    boolean[] visited = new boolean[n];
    queue.add(0);
    visited[0] = true;
    int[] parent = new int[n];
    parent[0] = -1;
    int[] dist = new int[n];
    out:
    while (queue.size() > 0) {
      int u = queue.pollFirst();
      for (int v : graph.get(u)) {
        if (!visited[v]) {
          visited[v] = true;
          queue.add(v);
          parent[v] = u;
          dist[v] = dist[u] + 1;
          if (v == n - 1) {
            break out;
          }
        }
      }
    }
    if (!visited[n - 1]) {
      out.println("FAIL");
    } else {
      out.println(dist[n - 1] + 1);
      String[] result = new String[dist[n - 1] + 1];
      int c = n - 1, idx = result.length - 1;
      do {
        result[idx--] = words[c];
        c = parent[c];
      } while (c != -1);
      for (String s : result) {
        out.println(s);
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
    try (MagicChains instance = new MagicChains()) {
      instance.solve();
    }
  }
}
