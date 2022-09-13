package codeforces.contests1701_1800.problemset1729;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class GuessTheCycleSize implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    for (int b = 3; b < 28; b++) {
      long[] answer = ask(b);
      if (answer[0] == -1) {
        answer(b - 1);
        break;
      } else if (answer[0] != answer[1]) {
        answer(answer[0] + answer[1]);
        break;
      }
    }
  }

  private long[] ask(int b) {
    long[] result = new long[2];
    out.printf("? 1 %d\n", b);
    out.flush();
    result[0] = in.nl();

    out.printf("? %d 1\n", b);
    out.flush();
    result[1] = in.nl();

    return result;
  }

  private void answer(long n) {
    out.printf("! %d\n", n);
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
    try (GuessTheCycleSize instance = new GuessTheCycleSize()) {
      instance.solve();
    }
  }
}