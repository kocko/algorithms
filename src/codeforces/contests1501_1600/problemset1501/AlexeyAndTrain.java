package codeforces.contests1501_1600.problemset1501;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class AlexeyAndTrain implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      int[] a = new int[n];
      int[] b = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.ni();
        b[i] = in.ni();
      }
      int[] tm = new int[n];
      for (int i = 0; i < n; i++) {
        tm[i] = in.ni();
      }
      int time = 0, prev = 0;
      for (int i = 0; i < n; i++) {
        time += (a[i] - prev + tm[i]);
        if (i < n - 1) {
          int stay = (b[i] - a[i] + 1) / 2;
          time = Math.max(time + stay, b[i]);
        }
        prev = b[i];
      }
      out.println(time);
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
    try (AlexeyAndTrain instance = new AlexeyAndTrain()) {
      instance.solve();
    }
  }
}
