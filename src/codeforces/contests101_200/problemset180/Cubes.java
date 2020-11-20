package codeforces.contests101_200.problemset180;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Cubes implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni(), k = in.ni();
    int[] x = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = in.ni();
    }
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      List<Integer> list = map.getOrDefault(x[i], new ArrayList<>());
      list.add(i);
      map.put(x[i], list);
    }
    int result = 0;
    for (List<Integer> list : map.values()) {
      int left = 0, right = 0, score = 1;
      while (right < list.size()) {
        int elements = list.get(right) - list.get(left) + 1;
        int delete = elements - (right - left + 1);
        while (delete > k) {
          left++;
          elements = list.get(right) - list.get(left);
          delete = elements - (right - left + 1);
        }
        if (elements - delete > result) {
          result = elements - delete;
        }
        right++;
      }
      result = Math.max(result, score);
    }
    out.println(result);
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
    try (Cubes instance = new Cubes()) {
      instance.solve();
    }
  }
}
