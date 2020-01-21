package codeforces.contests1201_1300.problemset1287;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Hyperset implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), k = in.ni();
    String[] x = new String[n];
    for (int i = 0; i < n; i++) {
      x[i] = in.next();
    }
    Map<String, Integer> map = new HashMap<>();
    for (String s : x) {
      map.put(s, map.getOrDefault(s, 0) + 1);
    }
    long result = 0;
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      int count = entry.getValue();
      if (count >= 3) {
        result += combinations(count);
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        result += map.getOrDefault(getTarget(x[i], x[j]), 0);
      }
    }
    out.println(result / 3);
  }

  private long combinations(int n) {
    long result = 1;
    for (int i = 1; i <= 3; i++) {
      result *= n;
      result /= i;
    }
    return result;
  }

  private String getTarget(String a, String b) {
    StringBuilder result = new StringBuilder();
    int n = a.length();
    for (int i = 0; i < n; i++) {
      if (a.charAt(i) == b.charAt(i)) {
        result.append(a.charAt(i));
      } else {
        for (char c : "SET".toCharArray()) {
          if (c != a.charAt(i) && c != b.charAt(i)) {
            result.append(c);
          }
        }
      }
    }
    return result.toString();
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
    try (Hyperset instance = new Hyperset()) {
      instance.solve();
    }
  }
}
