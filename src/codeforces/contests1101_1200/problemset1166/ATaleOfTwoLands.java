package codeforces.contests1101_1200.problemset1166;

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

public class ATaleOfTwoLands implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(Math.abs(in.ni()));
    }
    list.sort(Comparator.naturalOrder());

    long result = 0;
    int right = 0;
    for (int left = 0; left < n - 1; left++) {
      while (right < n - 1 && list.get(left) <= 2 * list.get(right + 1) && 2 * list.get(left) >= list.get(right + 1)) {
        right++;
      }
      if (right != left) {
        result += (right - left);
      }
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
    try (ATaleOfTwoLands instance = new ATaleOfTwoLands()) {
      instance.solve();
    }
  }
}
