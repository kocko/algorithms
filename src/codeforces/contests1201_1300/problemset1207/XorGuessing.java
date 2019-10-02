package codeforces.contests1201_1300.problemset1207;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class XorGuessing implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int MAX_N = 100;
    int mask_first = (1 << 7) - 1, mask_second = mask_first << 7;
    int[] first = new int[MAX_N], second = new int[MAX_N];
    for (int i = 1; i <= MAX_N; i++) {
      first[i - 1] = mask_first | (i << 7);
      second[i - 1] = mask_second | i;
    }
    int result = 0;
    int xor = ask(first);
    for (int i = 0; i < 7; i++) {
      int bit = (1 << i);
      if ((xor & bit) == 0) {
        result |= bit;
      }
    }
    xor = ask(second);
    for (int i = 7; i < 14; i++) {
      int bit = (1 << i);
      if ((xor & bit) == 0) {
        result |= bit;
      }
    }
    out.println("! " + result);
    out.flush();
  }

  private int ask(int[] query) {
    out.print('?');
    out.print(' ');
    for (int value : query) {
      out.print(value);
      out.print(' ');
    }
    out.flush();
    return in.ni();
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
    try (XorGuessing instance = new XorGuessing()) {
      instance.solve();
    }
  }
}
