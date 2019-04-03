package codeforces.contests1101_1200.problemset1141;

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

public class ColoredBoots implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    char[] a = in.next().toCharArray(), b = in.next().toCharArray();
    
    List<int[]> result = new ArrayList<>();
    boolean[] usedLeft = new boolean[n];
    boolean[] usedRight = new boolean[n];
    for (char c = 'a'; c <= 'z'; c++) {
      ArrayDeque<Integer> l = new ArrayDeque<>(), r = new ArrayDeque<>();
      for (int i = 0; i < n; i++) {
        if (a[i] == c && !usedLeft[i]) {
          l.add(i);
        }
        if (b[i] == c && !usedRight[i]) {
          r.add(i);
        }
        while (l.size() > 0 && r.size() > 0) {
          int u = l.pollFirst(), v = r.pollFirst();
          usedLeft[u] = usedRight[v] = true;
          result.add(new int[]{u + 1, v + 1});
        }
      }
    }
    ArrayDeque<Integer> left = new ArrayDeque<>(), right = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      if (!usedLeft[i] && a[i] != '?') left.add(i);
      if (!usedRight[i] && b[i] != '?') right.add(i);
    }
    List<Integer> unusedLeft = new ArrayList<>(), unusedRight = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (a[i] == '?') {
        if (right.size() > 0) {
          result.add(new int[]{i + 1, right.pollFirst() + 1});
        } else {
          unusedLeft.add(i);
        }
      }
      if (b[i] == '?') {
        if (left.size() > 0) {
          result.add(new int[]{left.pollFirst() + 1, i + 1});
        } else {
          unusedRight.add(i);
        }
      }
    }
    for (int i = 0; i < Math.min(unusedLeft.size(), unusedRight.size()); i++) {
      result.add(new int[]{unusedLeft.get(i) + 1, unusedRight.get(i) + 1});
    }
    out.println(result.size());
    for (int[] pair : result) {
      out.println(pair[0] + " " + pair[1]);
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
    try (ColoredBoots instance = new ColoredBoots()) {
      instance.solve();
    }
  }
}
