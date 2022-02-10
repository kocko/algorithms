package codeforces.contests1601_1700.problemset1633;

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

public class KillTheMonster implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public KillTheMonster() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public KillTheMonster(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      long hc = in.nl(), dc = in.nl();
      long hm = in.nl(), dm = in.nl();
      long k = in.nl(), weapon = in.nl(), armor = in.nl();
      boolean can = false;
      for (int i = 0; i <= k; i++) {
        can |= canKill(hc + i * armor, dc + (k - i) * weapon, hm, dm);
      }
      out.println(can ? "YES" : "NO");
    }
  }

  private boolean canKill(long h1, long d1, long h2, long d2) {
    long masha = (h2 / d1) + (h2 % d1 != 0 ? 1 : 0);
    long monster = (h1 / d2) + (h1 % d2 != 0 ? 1 : 0);
    return masha <= monster;
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
    try (KillTheMonster instance = new KillTheMonster()) {
      instance.solve();
    }
  }
}
