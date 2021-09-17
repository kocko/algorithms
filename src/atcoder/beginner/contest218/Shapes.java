package atcoder.beginner.contest218;

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

public class Shapes implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public Shapes() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public Shapes(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int n = in.ni();
    char[][] a = new char[n][n], b = new char[n][n];
    for (int i = 0; i < n; i++) {
      a[i] = in.next().toCharArray();
    }
    for (int i = 0; i < n; i++) {
      b[i] = in.next().toCharArray();
    }
    boolean match = false;
    for (int i = 0; !match && i < 4; i++, a = rotate(a)) {
      //print(a);
      match = compare(a, b);
    }
    out.println(match ? "Yes" : "No");
  }

  private void print(char[][] image) {
    int n = image.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        out.print(image[i][j]);
      }
      out.println();
    }
    out.println();
  }

  private char[][] rotate(char[][] image) {
    int n = image.length;
    char[][] result = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        result[j][n - i - 1] = image[i][j];
      }
    }
    return result;
  }

  private boolean compare(char[][] a, char[][] b) {
    int n = a.length;
    int minRowA = n, maxRowA = -1, minColA = n, maxColA = -1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (a[i][j] == '#') {
          minRowA = Math.min(minRowA, i);
          maxRowA = Math.max(maxRowA, i);
          minColA = Math.min(minColA, j);
          maxColA = Math.max(maxColA, j);
        }
      }
    }
    int heightA = maxRowA - minRowA + 1;
    int widthA = maxColA - minColA + 1;

    int minRowB = n, maxRowB = -1, minColB = n, maxColB = -1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (b[i][j] == '#') {
          minRowB = Math.min(minRowB, i);
          maxRowB = Math.max(maxRowB, i);
          minColB = Math.min(minColB, j);
          maxColB = Math.max(maxColB, j);
        }
      }
    }

    int heightB = maxRowB - minRowB + 1;
    int widthB = maxColB - minColB + 1;
    if (heightA == heightB && widthA == widthB) {
      for (int i = minRowA; i < minRowA + heightA; i++) {
        for (int j = minColA; j < minColA + widthA; j++) {
          int p = i - minRowA, q = j - minColA;
          if (a[i][j] != b[minRowB + p][minColB + q]) {
            return false;
          }
        }
      }
      return true;
    } else {
      return false;
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
    try (Shapes instance = new Shapes()) {
      instance.solve();
    }
  }
}
