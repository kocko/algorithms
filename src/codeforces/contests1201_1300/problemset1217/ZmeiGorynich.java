package codeforces.contests1201_1300.problemset1217;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class ZmeiGorynich implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class Attack implements Comparable<Attack> {
    private int win, lose;

    private Attack(int win, int lose) {
      this.win = win;
      this.lose = lose;
    }

    private int getDiff() {
      return win - lose;
    }

    @Override
    public int compareTo(Attack o) {
      return Integer.compare(getDiff(), o.getDiff());
    }
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), heads = in.ni();
      List<Attack> list = new ArrayList<>();
      int maxAttack = 0;
      for (int i = 0; i < n; i++) {
        int attack = in.ni(), restore = in.ni();
        list.add(new Attack(attack, restore));
        if (attack > maxAttack) {
          maxAttack = attack;
        }
      }
      list.sort(Comparator.reverseOrder());
      Attack best = list.get(0);
      long result = -1;
      int diff = best.getDiff();
      if (diff > 0) {
        int toDefeat = heads - maxAttack;
        if (toDefeat > 0) {
          result = toDefeat / diff + (toDefeat % diff != 0 ? 1 : 0);
          result++;
        } else {
          result = 1;
        }
      } else if (maxAttack >= heads) {
        result = 1;
      }

      out.println(result);
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
    try (ZmeiGorynich instance = new ZmeiGorynich()) {
      instance.solve();
    }
  }
}
