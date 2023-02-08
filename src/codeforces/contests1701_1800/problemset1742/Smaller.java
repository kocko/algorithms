package codeforces.contests1701_1800.problemset1742;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Smaller implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public Smaller() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      long[][] count = new long[2][26];
      count[0][0] = count[1][0] = 1;
      int q = in.ni();
      while (q-- > 0) {
        int where = in.ni() - 1;
        long times = in.nl();
        char[] what = in.next().toCharArray();
        for (char c : what) {
          count[where][c - 'a'] += times;
        }
        boolean hasOtherThanA = false;
        for (int i = 1; i < 26; i++) {
          if (count[1][i] > 0) {
            hasOtherThanA = true;
            break;
          }
        }
        boolean lessAsZeroOthers = count[0][0] < count[1][0];
        for (int i = 1; i < 26; i++) {
          lessAsZeroOthers &= count[0][i] == 0;
        }
        boolean smaller = hasOtherThanA || lessAsZeroOthers;
        out.println(smaller ? "YES" : "NO");
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
    try (Smaller instance = new Smaller()) {
      instance.solve();
    }
  }
}
