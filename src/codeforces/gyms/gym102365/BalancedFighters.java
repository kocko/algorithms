package codeforces.gyms.gym102365;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BalancedFighters implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class Fighter {
    private String name;
    private int health, attack, defence;

    private Fighter(String name, int health, int attack, int defence) {
      this.name = name;
      this.health = health;
      this.attack = attack;
      this.defence = defence;
    }
  }

  public void solve() {
    int n = in.ni();
    int[][] info = new int[n][n];
    Fighter[] fighters = new Fighter[n];
    for (int i = 0; i < n; i++) {
      fighters[i] = new Fighter(in.next(), in.ni(), in.ni(), in.ni());
    }
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int outcome = fight(fighters[i], fighters[j]);
        if (outcome == 1) {
          info[i][j] = 1;
        } else if (outcome == -1) {
          info[j][i] = 1;
        }
      }
    }
    Set<String> result = new HashSet<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          if (i != j && j != k && k != i && info[i][j] == 1 && info[j][k] == 1 && info[k][i] == 1) {
            String[] triple = new String[]{fighters[i].name, fighters[j].name, fighters[k].name};
            Arrays.sort(triple);
            result.add(triple[0] + " " + triple[1] + " " + triple[2]);
          }
        }
      }
    }
    out.println(result.size());
    result.forEach(out::println);
  }

  private int fight(Fighter a, Fighter b) {
    int health_a = a.health, health_b = b.health;
    int drop_a = Math.max(0, b.attack - a.defence), drop_b = Math.max(0, a.attack - b.defence);
    if (drop_a == 0) {
      if (drop_b == 0) {
        return 0;
      } else {
        return 1;
      }
    } else {
      if (drop_b == 0) {
        return -1;
      } else {
        int hits_a = (health_a / drop_a) + (health_a % drop_a != 0 ? 1 : 0);
        int hits_b = (health_b / drop_b) + (health_b % drop_b != 0 ? 1 : 0);
        return Integer.compare(hits_a, hits_b);
      }
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
    try (BalancedFighters instance = new BalancedFighters()) {
      instance.solve();
    }
  }
}
