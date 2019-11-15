package codeforces.contests1201_1300.problemset1256;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MinimizeThePermutation implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int q = in.ni();
    while (q-- > 0) {
      int n = in.ni();
      int[] perm = new int[n], pos = new int[n + 1];
      boolean[] move = new boolean[n];
      for (int i = 0; i < n; i++) {
        int next = in.ni();
        pos[next] = i;
        perm[i] = next;
        move[i] = true;
      }
      for (int value = 1; value <= n; value++) {
         int position = pos[value];
         while (position > 0 && move[position - 1] && perm[position - 1] > value) {
           perm[position] = perm[position - 1];
           perm[position - 1] = value;

           pos[perm[position]] = position;
           pos[value] = position - 1;

           move[position - 1] = false;
           position--;
         }
      }
      for (int i = 0; i < n; i++) {
        out.print(perm[i]);
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
    try (MinimizeThePermutation instance = new MinimizeThePermutation()) {
      instance.solve();
    }
  }
}
