package uva.volume116;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Rooks implements Closeable {

  private final Scanner in = new Scanner(System.in);
  private final PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    board = new char[MAX_N][MAX_N];
    String line;
    while (!"END".equals(line = in.nextLine())) {
      board[0] = line.toCharArray();
      for (int i = 1; i < MAX_N; i++) {
        board[i] = in.nextLine().toCharArray();
      }
      int result = 15;
      for (int mask = 0; mask < (1 << MAX_N); mask++) {
        int rooks = findRooks(mask);
        if (rooks < result) {
          result = rooks;
        }
      }
      out.println(result);
    }
  }

  private final int MAX_N = 15;
  private char[][] board;

  private int findRooks(int mask) {
    Set<Integer> columns = new HashSet<>();
    int rooks = 0;
    for (int i = 0; i < MAX_N; i++) {
      int bit = 1 << i;
      if ((mask & bit) == 0) {
        for (int j = 0; j < MAX_N; j++) {
          if (board[i][j] == '#') {
            columns.add(j);
          }
        }
      } else {
        rooks++;
      }
    }
    if (rooks < columns.size()) {
      rooks = columns.size();
    }
    return rooks;
  }

  @Override
  public void close() throws IOException {
    in.close();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    try (Rooks instance = new Rooks()) {
      instance.solve();
    }
  }
}
