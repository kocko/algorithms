package uva.volume012;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class FreeParentheses implements Closeable {

  private Scanner in = new Scanner(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    while (in.hasNextLine()) {
      read();
      recurse(0, 0, 0);
      out.println(possible.size());
    }
  }

  private void read() {
    list = new ArrayList<>();
    sign = new ArrayList<>();
    String line = in.nextLine();
    Scanner sc = new Scanner(line);
    list.add(Integer.parseInt(sc.next()));
    sign.add(1);
    while (sc.hasNext()) {
      char operator = sc.next().charAt(0);
      int value = Integer.parseInt(sc.next());
      int signum = 1;
      if (operator == '-') {
        signum = -1;
      }
      list.add(value);
      sign.add(signum);
    }

    calculated = new boolean[list.size() + 1][105][6000];
    possible = new HashSet<>();
  }

  private List<Integer> sign;
  private List<Integer> list;

  private boolean[][][] calculated;
  private Set<Integer> possible;

  private void recurse(int idx, int open, int value) {
    if (calculated[idx][open][value + 3000]) return;
    calculated[idx][open][value + 3000] = true;
    if (idx == list.size()) {
      possible.add(value);
      return;
    }
    int current = list.get(idx);
    int signum = sign.get(idx);
    int next = value + current * signum * (open % 2 == 0 ? 1 : -1);
    if (signum < 0) {
      recurse(idx + 1, open + 1, next);
    }
    if (open > 0) {
      recurse(idx + 1, open - 1, next);
    }
    recurse(idx + 1, open, next);
  }

  @Override
  public void close() throws IOException {
    in.close();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    try (FreeParentheses instance = new FreeParentheses()) {
      instance.solve();
    }
  }
}
