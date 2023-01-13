package codeforces.contests1701_1800.problemset1771;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class HossamAndCombinatorics implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      int max = 0, min = Integer.MAX_VALUE;
      long cntMax = 0, cntMin = 0;
      for (int i = 0; i < n; i++) {
        int next = in.ni();
        if (next > max) {
          max = next;
          cntMax = 1;
        } else if (next == max) {
          cntMax++;
        }
        if (next < min) {
          cntMin = 1;
          min = next;
        } else if (next == min) {
          cntMin++;
        }
      }
      if (max == min) {
        out.println(cntMax * (cntMax - 1L));
      } else {
        out.println(2 * cntMax * cntMin);
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
    try (HossamAndCombinatorics instance = new HossamAndCombinatorics()) {
      instance.solve();
    }
  }
}