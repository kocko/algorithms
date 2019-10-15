package codeforces.contests1201_1300.problemset1238;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ABString implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    char[] x = in.next().toCharArray();
    List<Integer> groups = new ArrayList<>();
    long result = n * (n - 1L) / 2;
    for (int i = 1; i < n; i++) {
      if (x[i] != x[i - 1]) {
        groups.add(i);
      }
    }

    for (int i = 0; i < groups.size() - 1; i++) {
      result -= (groups.get(i + 1) - groups.get(i)) * 2;
    }
    if (groups.size() > 0) {
      result -= groups.get(0);
      result -= n - groups.get(groups.size() - 1);
    }
    result += groups.size();
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
    try (ABString instance = new ABString()) {
      instance.solve();
    }
  }
}
