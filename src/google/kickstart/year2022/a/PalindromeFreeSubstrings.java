package google.kickstart.year2022.a;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class PalindromeFreeSubstrings implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public PalindromeFreeSubstrings() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    for (int testCase = 1; testCase <= T; testCase++) {
      n = in.ni();
      x = in.next().toCharArray();
      dp = new Boolean[n][64];
      boolean result = recurse(0, 0);
      out.printf("Case #%d: %s\n", testCase, result ? "POSSIBLE" : "IMPOSSIBLE");
    }
  }

  private int n;
  private char[] x;
  private Boolean[][] dp;
  private final int SIX_BITS = (1 << 6) - 1;

  private boolean recurse(int idx, int mask) {
    if (idx == n) return true;

    if (dp[idx][mask] != null) return dp[idx][mask];

    boolean possible = false;

    if (x[idx] == '?') {
      for (char c = '0'; c <= '1'; c++) {
        int bit = c - '0';
        boolean proceed = idx < 4;
        boolean palindromic = (idx >= 4 && (lastBitsAreFormingPalindrome((mask << 1) | bit, 5)));
        palindromic |= (idx >= 5 && lastBitsAreFormingPalindrome((mask << 1) | bit, 6));
        proceed |= !palindromic;
        if (proceed) {
          possible |= recurse(idx + 1, ((mask << 1) | bit) & SIX_BITS);
        }
      }
    } else {
      int bit = (x[idx] - '0');
      boolean proceed = idx < 4;
      boolean palindromic = (idx >= 4 && (lastBitsAreFormingPalindrome((mask << 1) | bit, 5)));
      palindromic |= (idx >= 5 && lastBitsAreFormingPalindrome((mask << 1) | bit, 6));
      proceed |= !palindromic;
      if (proceed) {
        possible |= recurse(idx + 1, ((mask << 1) | bit) & SIX_BITS);
      }
    }
    return dp[idx][mask] = possible;
  }

  private boolean lastBitsAreFormingPalindrome(int mask, int size) {
    int[] x = new int[size];
    for (int i = 0; i < size; i++) {
      int value = mask & (1 << i);
      x[i] = value != 0 ? 1 : 0;
    }
    return isPalindrome(x);
  }

  private boolean isPalindrome(int[] x) {
    boolean result = true;
    for (int i = 0; i < x.length / 2; i++) {
      result &= x[i] == x[x.length - i - 1];
    }
    return result;
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
    try (PalindromeFreeSubstrings instance = new PalindromeFreeSubstrings()) {
      instance.solve();
    }
  }
}
