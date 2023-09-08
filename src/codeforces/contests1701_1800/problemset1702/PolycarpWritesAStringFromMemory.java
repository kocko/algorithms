package codeforces.contests1701_1800.problemset1702;

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

public class PolycarpWritesAStringFromMemory implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public PolycarpWritesAStringFromMemory() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      char[] x = in.next().toCharArray();
      int result = 1;
      int has = 0;
      for (int i = 0; i < x.length; i++) {
        int p = x[i] - 'a';
        int bit = 1 << p;
        has |= bit;
        if (Integer.bitCount(has) == 4) {
          result++;
          has = bit;
        }
      }
      out.println(result);
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
    try (PolycarpWritesAStringFromMemory instance = new PolycarpWritesAStringFromMemory()) {
      instance.solve();
    }
  }
}
