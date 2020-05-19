package codeforces.gyms.gym100030;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Triskaidekaphobia implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public Triskaidekaphobia() throws IOException {
    in = new InputReader(new FileInputStream(new File("input.txt")));
    out = new PrintWriter(new FileOutputStream(new File("output.txt")));
  }

  public void solve() {
    char[] x = in.next().toCharArray();
    int n = x.length;
    int[] three = new int[n], one = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      if (x[i] == '3') {
        three[i] = 1;
      }
      if (i + 1 < n) {
        three[i] += three[i + 1];
      }
    }
    for (int i = 0; i < n; i++) {
      if (x[i] == '1') {
        one[i]++;
      }
      if (i > 0) {
        one[i] += one[i - 1];
      }
    }
    int result = n;
    if (three[0] == n) {
      result = 0;
    }
    for (int i = 0; i < n; i++) {
      int onesBefore = i >= 1 ? one[i - 1] : 0;
      int threesAfter = i + 1 < n ? three[i + 1] : 0;
      result = Math.min(result, onesBefore + threesAfter);
    }
    out.println(result);
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
    try (Triskaidekaphobia instance = new Triskaidekaphobia()) {
      instance.solve();
    }
  }
}
