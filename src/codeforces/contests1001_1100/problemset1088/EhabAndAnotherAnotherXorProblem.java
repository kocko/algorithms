package codeforces.contests1001_1100.problemset1088;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class EhabAndAnotherAnotherXorProblem implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int initial = ask(0, 0);
    int a = 0, b = 0;
    if (initial == 0) {
      for (int i = 0; i < 30; i++) {
        int response = ask(1 << i, 0);
        if (response == -1) {
          a |= (1 << i);
        }
      }
      b = a;
    } else {
      for (int i = 29; i >= 0; i--) {
        int response = ask(a | (1 << i), b | (1 << i));
        if (response != initial) {
          if (response == 1) {
            b |= (1 << i);
          } else {
            a |= (1 << i);
          }
          initial = ask(a, b);
        } else {
          response = ask(a | (1 << i), b);
          if (response == -1) {
            a |= (1 << i);
            b |= (1 << i);
          }
        }
        
      }
    }
    answer(a, b);
  }

  private int ask(int c, int d) {
    out.printf("? %d %d\n", c, d);
    out.flush();
    return in.ni();
  }

  private void answer(int a, int b) {
    out.printf("! %d %d\n", a, b);
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
    try (EhabAndAnotherAnotherXorProblem instance = new EhabAndAnotherAnotherXorProblem()) {
      instance.solve();
    }
  }
}
