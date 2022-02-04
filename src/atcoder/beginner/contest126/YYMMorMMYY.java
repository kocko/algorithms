package atcoder.beginner.contest126;

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

public class YYMMorMMYY implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public YYMMorMMYY() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    char[] x = in.next().toCharArray();
    boolean mmyy = isValidMonth(x, 0, 1);
    boolean yymm = isValidMonth(x, 2, 3);
    if (mmyy && yymm) {
      out.println("AMBIGUOUS");
    } else if (mmyy) {
      out.println("MMYY");
    } else if (yymm) {
      out.println("YYMM");
    } else {
      out.println("NA");
    }
  }

  private boolean isValidMonth(char[] x, int first, int second) {
    int month = 10 * (x[first] - '0') + (x[second] - '0');
    return month >= 1 && month <= 12;
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
    try (YYMMorMMYY instance = new YYMMorMMYY()) {
      instance.solve();
    }
  }
}
