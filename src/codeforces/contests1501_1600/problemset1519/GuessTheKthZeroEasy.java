package codeforces.contests1501_1600.problemset1519;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class GuessTheKthZeroEasy implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public GuessTheKthZeroEasy() throws FileNotFoundException {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int n = in.ni(), t = in.ni();
    while (t-- > 0) {
      int k = in.ni();
      int left = 1, right = n;
      int result = Integer.MAX_VALUE;
      while (left <= right) {
        int mid = left + (right - left) / 2;
        int response = ask(mid), zeroes = mid - response;
        if (zeroes < k) {
          left = mid + 1;
        } else if (zeroes == k) {
          right = mid - 1;
          result = Math.min(result, mid);
        } else {
          right = mid - 1;
        }
      }
      answer(result);
    }
  }

  private int ask(int right) {
    out.println("? 1 " + right);
    out.flush();
    return in.ni();
  }

  private void answer(int idx) {
    out.println("! " + idx);
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
    try (GuessTheKthZeroEasy instance = new GuessTheKthZeroEasy()) {
      instance.solve();
    }
  }
}
