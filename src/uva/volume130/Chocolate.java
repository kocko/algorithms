package uva.volume130;

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

public class Chocolate implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public Chocolate() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    final int MAX_N = 100000;
    for (int testCase = 1; testCase <= T; testCase++) {
      int l = in.ni(), s = in.ni(), r = in.ni();
      int[] types = new int[MAX_N];
      for (int i = 0; i < l; i++) {
        int next = in.ni();
        types[next] |= 1;
      }
      for (int i = 0; i < s; i++) {
        int next = in.ni();
        types[next] |= 2;
      }
      for (int i = 0; i < r; i++) {
        int next = in.ni();
        types[next] |= 4;
      }
      int[][] score = new int[3][2];
      int MAX_MASK = 7;
      for (int i = 0; i < MAX_N; i++) {
        if (types[i] == 1 || types[i] == 2 || types[i] == 4) {
          for (int j = 0; j < 3; j++) {
            if ((1 << j) == types[i]) {
              score[j][0]++;
              break;
            }
          }
        }

        for (int j = 0; j < 3; j++) {
          if (MAX_MASK - (1 << j) == types[i]) {
            score[j][1]++;
          }
        }
      }
      out.printf("Case #%d:\n", testCase);
      for (int i = 0; i < 3; i++) {
        out.printf("%d %d\n", score[i][0], score[i][1]);
      }
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
    try (Chocolate instance = new Chocolate()) {
      instance.solve();
    }
  }
}
