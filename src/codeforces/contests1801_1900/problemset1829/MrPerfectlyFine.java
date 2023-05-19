package codeforces.contests1801_1900.problemset1829;

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

public class MrPerfectlyFine implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public MrPerfectlyFine() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      int[] time = new int[n];
      String[] skills = new String[n];
      for (int i = 0; i < n; i++) {
        time[i] = in.ni();
        skills[i] = in.next();
      }
      int result = Integer.MAX_VALUE;
      for (int i = 0; i < n; i++) {
        if ("11".equals(skills[i])) {
          result = min(result, time[i]);
        }
      }
      int minFirst = Integer.MAX_VALUE;
      int minSecond = Integer.MAX_VALUE;
      for (int i = 0; i < n; i++) {
        if ("10".equals(skills[i])) {
          minFirst = min(minFirst, time[i]);
        } else if ("01".equals(skills[i])) {
          minSecond = min(minSecond, time[i]);
        }
      }
      if (minFirst != Integer.MAX_VALUE && minSecond != Integer.MAX_VALUE) {
        result = min(result, minFirst + minSecond);
      }
      out.println(result == Integer.MAX_VALUE ? -1 : result);
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
    try (MrPerfectlyFine instance = new MrPerfectlyFine()) {
      instance.solve();
    }
  }
}
