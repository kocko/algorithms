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

public class PinkElephants implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public PinkElephants() throws IOException {
    in = new InputReader(new FileInputStream(new File("input.txt")));
    out = new PrintWriter(new FileOutputStream(new File("output.txt")));
  }

  public void solve() {
    int n = in.ni(), m = in.ni();
    final int MOD = (int) 1e9 + 7;
    int[][] binom = new int[201][201];
    binom[0][0] = 1;
    for (int row = 1; row <= binom.length - 1; row++) {
      binom[row][0] = binom[row][row] = 1;
      for (int col = 1; col < row; col++) {
        binom[row][col] = binom[row - 1][col] + binom[row - 1][col - 1];
        binom[row][col] %= MOD;
      }
    }
    out.println(binom[m][n]);
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
    try (PinkElephants instance = new PinkElephants()) {
      instance.solve();
    }
  }
}
