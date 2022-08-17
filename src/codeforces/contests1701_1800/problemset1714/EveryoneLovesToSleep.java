package codeforces.contests1701_1800.problemset1714;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class EveryoneLovesToSleep implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni(), H = in.ni(), M = in.ni();
      int vlad = H * 60 + M;
      int result = 24 * 60 + 1;
      for (int i = 0; i < n; i++) {
        int h = in.ni(), m = in.ni();
        int time = h *  60 + m;
        if (time >= vlad) {
          result = min(result, time - vlad);
        } else {
          result = min(result, time - vlad + 24 * 60);
        }
      }
      out.println((result / 60) + " " + (result % 60));
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
    try (EveryoneLovesToSleep instance = new EveryoneLovesToSleep()) {
      instance.solve();
    }
  }
}