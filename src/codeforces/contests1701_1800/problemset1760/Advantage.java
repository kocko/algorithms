package codeforces.contests1701_1800.problemset1760;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Advantage implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public Advantage() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public Advantage(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      int[] x = new int[n];
      int[] max = {-1, -1};
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
        if (x[i] > max[0]) {
          max[1] = max[0];
          max[0] = x[i];
        } else if (x[i] > max[1]) {
          max[1] = x[i];
        }
      }
      for (int i = 0; i < n; i++) {
        int result = -1;
        if (x[i] == max[0]) {
          result = x[i] - max[1];
        } else {
          result = x[i] - max[0];
        }
        out.print(result);
        out.print(' ');
      }
      out.println();
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
    try (Advantage instance = new Advantage()) {
      instance.solve();
    }
  }
}
