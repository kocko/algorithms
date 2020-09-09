package codeforces.contests1401_1500.problemset1407;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ChocolateBunny implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[] result = new int[n + 1];

    int pos = 1;
    for (int i = 2; i <= n; i++) {
      int a = ask(pos, i);
      int b = ask(i, pos);
      if (a < b) {
        result[i] = b;
      } else {
        result[pos] = a;
        pos = i;
      }
    }
    result[pos] = n;
    answer(result);
  }

  private int ask(int i, int j) {
    out.printf("? %d %d\n", i, j);
    out.flush();
    return in.ni();
  }

  private void answer(int[] result) {
    out.print("!");
    for (int i = 1; i < result.length; i++) {
      out.print(' ');
      out.print(result[i]);
    }
    out.println();
    out.flush();
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
    try (ChocolateBunny instance = new ChocolateBunny()) {
      instance.solve();
    }
  }
}
