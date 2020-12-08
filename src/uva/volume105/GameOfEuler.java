package uva.volume105;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class GameOfEuler implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    generateTransitions();
    dp = new Boolean[MAX_MASK];
    int t = in.ni();
    while (t-- > 0) {
      char[][] board = new char[4][4];
      for (int i = 0; i < 4; i++) {
        board[i] = in.next().toCharArray();
      }
      int mask = 0;
      for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
          if (board[i][j] == 'X') {
            int idx = 4 * i + j;
            mask |= (1 << idx);
          }
        }
      }
      boolean winning = recurse(mask);
      out.println(winning ? "WINNING" : "LOSING");
    }
  }

  private final int MAX_MASK = 1 << 16;
  private Boolean[] dp;

  private boolean recurse(int mask) {
    if (mask == MAX_MASK - 1) return true;

    if (dp[mask] != null) return dp[mask];

    boolean ans = false;

    for (int transition : transitions) {
      if ((mask & transition) == 0) {
        ans |= !recurse(mask | transition);
      }
    }

    return dp[mask] = ans;
  }

  private Set<Integer> transitions = new HashSet<>();

  private void generateTransitions() {
    for (int row = 0; row < 4; row++) {
      int idx = 4 * row;
      for (int size = 1; size <= 3; size++) {
        int mask = 0;
        for (int i = 0; i < size; i++) {
          mask |= (1 << (idx + i));
        }
        transitions.add(mask);
      }
      for (int size = 1; size <= 3; size++) {
        int mask = 0;
        for (int i = 0; i < size; i++) {
          mask |= (1 << (3 + idx - i));
        }
        transitions.add(mask);
      }
    }
    for (int col = 0; col < 4; col++) {
      for (int size = 1; size <= 3; size++) {
        int mask = 0;
        for (int i = 0; i < size; i++) {
          mask |= (1 << (col + 4 * i));
        }
        transitions.add(mask);
      }

      for (int size = 1; size <= 3; size++) {
        int mask = 0;
        for (int i = 0; i < size; i++) {
          mask |= (1 << (12 + col - 4 * i));
        }
        transitions.add(mask);
      }
    }
    for (int i = 0; i < 16; i++) {
      transitions.add(1 << i);
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
    try (GameOfEuler instance = new GameOfEuler()) {
      instance.solve();
    }
  }
}
