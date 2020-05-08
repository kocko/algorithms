package codeforces.contests1301_1400.problemset1352;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AliceBobAndCandies implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      long[] x = new long[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.nl();
      }
      int moves = 0, alice = 0, bob = 0, aliceLast = 0, bobLast = 0;
      int i = 0, j = n - 1;
      boolean isAlice = true;
      while (i <= j) {
        moves++;
        if (isAlice) {
          int move = 0;
          while (move <= bobLast && i <= j) {
            move += x[i++];
          }
          alice += move;
          aliceLast = move;
        } else {
          int move = 0;
          while (move <= aliceLast && i <= j) {
            move += x[j--];
          }
          bob += move;
          bobLast = move;
        }
        isAlice = !isAlice;
      }
      out.println(moves + " " + alice + " " + bob);
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
    try (AliceBobAndCandies instance = new AliceBobAndCandies()) {
      instance.solve();
    }
  }
}
