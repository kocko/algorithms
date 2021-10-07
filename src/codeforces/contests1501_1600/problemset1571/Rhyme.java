package codeforces.contests1501_1600.problemset1571;

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

public class Rhyme implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public Rhyme() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public Rhyme(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      int k = (int) 1e6;
      int m = 0;
      while (n-- > 0) {
        char[] a = new StringBuilder(in.next()).reverse().toString().toCharArray();
        char[] b = new StringBuilder(in.next()).reverse().toString().toCharArray();
        int rhyme = in.ni();
        int rhymeSize = 0;
        for (int idx = 0; idx < min(a.length, b.length); idx++) {
          if (a[idx] == b[idx]) {
            rhymeSize++;
          } else break;
        }
        if (rhyme == 1) {
          k = min(k, rhymeSize);
        } else {
          m = max(m, rhymeSize + 1);
        }
      }
      if (m <= k) {
        out.println(k - m + 1);
        while (m <= k) {
          out.print(m++);
          out.print(' ');
        }
        out.println();

      } else {
        out.println(0);
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
    try (Rhyme instance = new Rhyme()) {
      instance.solve();
    }
  }
}
