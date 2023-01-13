package codeforces.gyms.gym103150;

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

public class ArrowingProcess implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public ArrowingProcess() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public ArrowingProcess(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int n = in.ni(), m = in.ni();
    char[][] x = new char[n][m];
    for (int i = 0; i < n; i++) {
      x[i] = in.next().toCharArray();
    }
    out.println(horizontal(x) + vertical(x));
  }

  private int horizontal(char[][] x) {
    int n = x.length, m = x[0].length;
    int result = 0;
    for (int i = 0; i < n; i++) {
      int right = 0;
      for (int j = 0; j < m; j++) {
        if (x[i][j] == '^' || x[i][j] == 'v') {
          right = 0;
        } else {
          if (x[i][j] == '>') {
            right++;
          } else {
            result += right;
          }
        }
      }
    }
    return result;
  }

  private int vertical(char[][] x) {
    int n = x.length, m = x[0].length;
    int result = 0;
    for (int j = 0; j < m; j++) {
      int down = 0;
      for (int i = 0; i < n; i++) {
        if (x[i][j] == '<' || x[i][j] == '>') {
          down = 0;
        } else {
          if (x[i][j] == 'v') {
            down++;
          } else {
            result += down;
          }
        }
      }
    }
    return result;
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
    try (ArrowingProcess instance = new ArrowingProcess()) {
      instance.solve();
    }
  }
}