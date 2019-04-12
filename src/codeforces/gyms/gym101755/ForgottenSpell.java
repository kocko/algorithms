package codeforces.gyms.gym101755;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class ForgottenSpell implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    char[][] x = {in.next().toCharArray(), in.next().toCharArray(), in.next().toCharArray()};
    final String ambiguous = "Ambiguous", impossible = "Impossible";
    int n = x[0].length;

    int[][][] diff = new int[3][3][n];
    for (int i = 0; i < 3; i++) {
      for (int j = i + 1; j < 3; j++) {
        diff[i][j] = diff[j][i] = diff(x[i], x[j]);
      }
    }
    Set<String> possible = new HashSet<>();
    for (int i = 0; i < n; i++) {
      for (char ch = 'a'; ch <= 'z' && possible.size() <= 1; ch++) {
        List<Integer> wrong = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
          if (x[j][i] != ch) {
            wrong.add(j);
          } else {
            right.add(j);
          }
        }
        boolean ok = true;
        for (int j = 0; j < wrong.size() - 1; j++) {
          ok &= check(diff[wrong.get(j)][wrong.get(j + 1)], i) == 0;
        }
        if (ok) {
          for (int r : right) {
            for (int w : wrong) {
              ok &= check(diff[w][r], i) <= 1;
            }
          }
          if (ok && wrong.size() >= 1) {
            StringBuilder spell = new StringBuilder();
            int w = wrong.get(0);
            for (int j = 0; j < i; j++) {
              spell.append(x[w][j]);
            }
            spell.append(ch);
            for (int j = i + 1; j < n; j++) {
              spell.append(x[w][j]);
            }
            possible.add(spell.toString());
          }
        }
      }
    }
    if (possible.size() == 2) {
      out.println(ambiguous);
    } else if (possible.size() == 1) {
      out.println(possible.iterator().next());
    } else {
      out.println(impossible);
    }
  }

  private int[] diff(char[] x, char[] y) {
    int n = x.length;
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      if (i > 0) result[i] = result[i - 1];
      if (x[i] != y[i]) result[i]++;
    }
    return result;
  }

  private int check(int[] diff, int idx) {
    int result = 0;
    if (idx >= 1) {
      result += diff[idx - 1];
    }
    result += (diff[diff.length - 1] - diff[idx]);
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
    try (ForgottenSpell instance = new ForgottenSpell()) {
      instance.solve();
    }
  }
}
