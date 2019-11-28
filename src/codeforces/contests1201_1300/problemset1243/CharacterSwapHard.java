package codeforces.contests1201_1300.problemset1243;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CharacterSwapHard implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      char[] x = in.next().toCharArray(), y = in.next().toCharArray();
      List<int[]> operations = new ArrayList<>();
      boolean possible = true;
      for (int i = 0; i < n; i++) {
        if (x[i] != y[i]) {
          for (int j = i + 1; j < n; j++) {
            if (x[j] == x[i]) {
              operations.add(swap(x, j, y, i));
              break;
            }
          }
        }
        if (x[i] != y[i]) {
          for (int j = i + 1; j < n; j++) {
            if (y[j] == x[i]) {
              operations.add(swap(x, j, y, j));
              operations.add(swap(x, j, y, i));
              break;
            }
          }
        }
        possible &= x[i] == y[i];
      }
      if (possible) {
        out.println("Yes");
        out.println(operations.size());
        for (int[] operation : operations) {
          out.println((operation[0] + 1) + " " + (operation[1] + 1));
        }
      } else {
        out.println("No");
      }
    }
  }

  private int[] swap(char[] x, int i, char[] y, int j) {
    char temp = x[i];
    x[i] = y[j];
    y[j] = temp;
    return new int[]{i, j};
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
    try (CharacterSwapHard instance = new CharacterSwapHard()) {
      instance.solve();
    }
  }
}
