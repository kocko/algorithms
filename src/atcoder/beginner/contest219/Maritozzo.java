package atcoder.beginner.contest219;

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

public class Maritozzo implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public Maritozzo() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public Maritozzo(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    String[] s = new String[3];
    for (int i = 0; i < 3; i++) {
      s[i] = in.next();
    }
    StringBuilder result = new StringBuilder();
    char[] t = in.next().toCharArray();
    for (char c : t) {
      result.append(s[c - '0' - 1]);
    }
    out.print(result);
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
    try (Maritozzo instance = new Maritozzo()) {
      instance.solve();
    }
  }
}
