package codeforces.contests1501_1600.problemset1571;

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

public class Sweepstake implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public Sweepstake() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public Sweepstake(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int n = in.ni(), m = in.ni();
    int first[] = new int[m];
    int last[] = new int[m];
    for (int i = 0; i < m; i++) {
      first[i] = in.ni();
      last[i] = in.ni();
    }
    int[][] table = new int[n + 1][n + 1];
    for (int i = 0; i < m; i++) {
      table[first[i]][last[i]]++;
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        table[i][0] += table[i][j];
        table[0][j] += table[i][j];
      }
    }
    int worstRank = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i != j) {
          int myScore = 0;
          if (first[0] == i) myScore++;
          if (last[0] == j) myScore++;
          int rank = 1;
          if (myScore == 1) {
            rank = table[i][j] + 1;
          } else if (myScore == 0) {
            rank = table[i][0] + table[0][j] - table[i][j] + 1;
          }
          worstRank = max(worstRank, rank);
        }
      }
    }
    out.println(worstRank);
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
    try (Sweepstake instance = new Sweepstake()) {
      instance.solve();
    }
  }
}
