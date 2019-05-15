package codeforces.contests1101_1200.problemset1167;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LostNumbers implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int[] numbers = {4, 8, 15, 16, 23, 42};
    int[][] product = new int[6][6];
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++) {
        if (i != j) {
          product[i][j] = product[j][i] = numbers[i] * numbers[j];
        }
      }
    }
    int[] result = new int[6];
    int ab, bc;
    out.println("? 1 2");
    out.flush();
    ab = in.ni();
    int[] x = new int[2];
    out: for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++) {
        if (i != j && product[i][j] == ab) {
          x = new int[]{numbers[i], numbers[j]};
          break out;
        }
      }
    }
    out.println("? 2 3");
    out.flush();
    bc = in.ni();
    int[] y = new int[2];
    out: for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++) {
        if (i != j && product[i][j] == bc) {
          y = new int[]{numbers[i], numbers[j]};
          break out;
        }
      }
    }
    out:
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        if (x[i] == y[j]) {
          result[1] = x[i];
          result[0] = x[(i + 1) % 2];
          result[2] = y[(j + 1) % 2];
          break out;
        }
      }
    }

    out.println("? 4 5");
    out.flush();
    ab = in.ni();
    x = new int[2];
    out: for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++) {
        if (i != j && product[i][j] == ab) {
          x = new int[]{numbers[i], numbers[j]};
          break out;
        }
      }
    }
    out.println("? 5 6");
    out.flush();
    bc = in.ni();
    y = new int[2];
    out: for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++) {
        if (i != j && product[i][j] == bc) {
          y = new int[]{numbers[i], numbers[j]};
          break out;
        }
      }
    }
    out:
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        if (x[i] == y[j]) {
          result[4] = x[i];
          result[3] = x[(i + 1) % 2];
          result[5] = y[(j + 1) % 2];
          break out;
        }
      }
    }
    out.print("!");
    out.print(' ');
    for (int number : result) {
      out.print(number);
      out.print(' ');
    }
    out.println();
    out.flush();
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
    try (LostNumbers instance = new LostNumbers()) {
      instance.solve();
    }
  }
}
