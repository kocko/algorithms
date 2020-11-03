package codeforces.contests1401_1500.problemset1419;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class SagesBirthday implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(in.ni());
    }
    list.sort(Comparator.naturalOrder());
    int result = 0;
    int[] order = new int[n];
    int idx = 0;
    for (int i = 1; i < n; i += 2) {
      order[i] = list.get(idx++);
    }
    for (int i = 0; i < n; i += 2) {
      order[i] = list.get(idx++);
    }
    for (int i = 1; i < n - 1; i++) {
      if (order[i] < order[i - 1] && order[i] < order[i + 1]) {
        result++;
      }
    }
    out.println(result);
    for (int i = 0; i < n; i++) {
      out.print(order[i]);
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
    try (SagesBirthday instance = new SagesBirthday()) {
      instance.solve();
    }
  }
}
