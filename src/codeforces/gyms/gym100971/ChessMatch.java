package codeforces.gyms.gym100971;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class ChessMatch implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[] x = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = in.ni();
    }
    int[] y = new int[n];
    for (int i = 0; i < n; i++) {
      y[i] = in.ni();
    }
    String result = "";
    int p = play(x, y), q = play(y, x);
    if (p == 1) {
      if (q == 1) {
        result = "Both";
      } else {
        result = "First";
      }
    } else if (p == 0) {
      if (q == 0) {
        result = "None";
      } else if (q == 1) {
        result = "Second";
      }
    } else {
      if (q == 0) {
        result = "None";
      } else if (q == 1) {
        result = "Second";
      }
    }
    out.println(result);
  }

  private int play(int[] a, int[] b) {
    int x = 0, y = 0;

    TreeSet<Integer> second = new TreeSet<>(Comparator.naturalOrder());
    for (int player : b) second.add(player);

    for (int player : a) {
      Integer bestOpponent = second.floor(player);
      if (bestOpponent != null) {
        x++;
        second.remove(bestOpponent);
      } else {
        y++;
      }
    }
    return Integer.compare(x, y);
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
    try (ChessMatch instance = new ChessMatch()) {
      instance.solve();
    }
  }
}
