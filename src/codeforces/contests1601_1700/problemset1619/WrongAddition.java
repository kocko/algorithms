package codeforces.contests1601_1700.problemset1619;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class WrongAddition implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public WrongAddition() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public WrongAddition(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      char[] x = in.next().toCharArray(), sum = in.next().toCharArray();
      int i = x.length - 1, j = sum.length - 1;
      ArrayDeque<Integer> result = new ArrayDeque<>();
      boolean ok = true;
      while (i >= 0) {
        if (j < 0) {
          ok = false;
          break;
        }
        int a = x[i] - '0', b = sum[j] - '0';
        if (a > b) {
          j--;
          if (j < 0) {
            ok = false;
            break;
          } else {
            b += (10 * (sum[j] - '0'));
            if (b < a) {
              ok = false;
              break;
            }
          }
        }
        int p = b - a;
        if (p >= 10) {
          ok = false;
          break;
        }
        result.addFirst(p);
        i--;
        j--;
      }
      if (ok) {
        while (j >= 0) {
          result.addFirst(sum[j] - '0');
          j--;
        }
        while (result.size() > 0 && result.peekFirst() == 0) {
          result.pollFirst();
        }
        if (result.size() == 0) {
          ok = false;
        }
      }
      if (ok) {
        while (result.size() > 0) {
          out.print(result.pollFirst());
        }
        out.println();
      } else {
        out.println(-1);
      }
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
    try (WrongAddition instance = new WrongAddition()) {
      instance.solve();
    }
  }
}
