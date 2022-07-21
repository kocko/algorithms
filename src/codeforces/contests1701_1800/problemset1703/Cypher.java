package codeforces.contests1701_1800.problemset1703;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Cypher implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      int[] x = new int[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
      }
      for (int i = 0; i < n; i++) {
        int count = in.ni();
        char[] moves = in.next().toCharArray();
        for (char move : moves) {
          switch (move) {
            case 'U' : {
              if (x[i] == 0) {
                x[i] = 9;
              } else {
                x[i]--;
              }
              break;
            }
            case 'D' : {
              if (x[i] == 9) {
                x[i] = 0;
              } else {
                x[i]++;
              }
              break;
            }
          }
        }
      }
      for (int i = 0; i < n; i++) {
        out.print(x[i]);
        out.print(' ');
      }
      out.println();
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
    try (Cypher instance = new Cypher()) {
      instance.solve();
    }
  }
}