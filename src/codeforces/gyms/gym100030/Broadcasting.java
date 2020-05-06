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

public class Broadcasting implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public Broadcasting() throws IOException {
    in = new InputReader(new FileInputStream(new File("input.txt")));
    out = new PrintWriter(new FileOutputStream(new File("output.txt")));
  }

  public void solve() {
    int n = in.ni(), k = in.ni();
    int result = 0;
    long temp = 1L;
    while (temp < n) {
      temp *= (k + 1);
      result++;
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
    try (Broadcasting instance = new Broadcasting()) {
      instance.solve();
    }
  }
}
