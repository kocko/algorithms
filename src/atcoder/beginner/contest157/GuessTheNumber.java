package atcoder.beginner.contest157;

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

public class GuessTheNumber implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public GuessTheNumber() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int n = in.ni(), m = in.ni();
    Integer[] number = new Integer[n];
    boolean possible = true;
    for (int i = 0; i < m; i++) {
      int idx = in.ni() - 1, value = in.ni();
      if (number[idx] != null && value != number[idx]) {
        possible = false;
        break;
      } else if (number[idx] == null) {
        number[idx] = value;
      }
    }
    if (n > 1 && number[0] == null) {
      number[0] = 1;
    }
    if (n > 1 && number[0] == 0) {
      possible = false;
    }

    if (possible) {
      for (int i = 0; i < n; i++) {
        out.print(number[i] != null ? number[i] : 0);
      }
    } else {
      out.println(-1);
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
    try (GuessTheNumber instance = new GuessTheNumber()) {
      instance.solve();
    }
  }
}
