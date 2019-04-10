package google.codejam2018.qualification;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SavingTheUniverseAgain implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    for (int testCase = 1; testCase <= t; testCase++) {
      int D = in.ni();
      char[] x = in.next().toCharArray();
      int damage = 0, n = x.length, power = 1;
      for (char c : x) {
        if (c == 'S') {
          damage += power;
        } else {
          power <<= 1;
        }
      }
      int result = 0;
      boolean possible = true;
      while (damage > D) {
        int idx = -1;
        for (int i = n - 1; i >= 1; i--) {
          if (x[i] == 'S' && x[i - 1] == 'C') {
            idx = i;
            x[i] = 'C';
            x[i - 1] = 'S';
            break;
          }
        }
        if (idx == -1) {
          possible = false;
          break;
        }
        int p = 1;
        for (int i = 0; i <= idx; i++) {
          if (x[i] == 'C') p <<= 1;
        }
        damage -= p >> 1;
        result++;
      }
      out.printf("Case #%d: ", testCase);
      out.println(possible ? result : "IMPOSSIBLE");
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
    try (SavingTheUniverseAgain instance = new SavingTheUniverseAgain()) {
      instance.solve();
    }
  }
}
