package codeforces.contests1201_1300.problemset1245;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class RestrictedRPS implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), rock = in.ni(), paper = in.ni(), scissors = in.ni();
      char[] bob = in.next().toCharArray();
      char[] result = new char[n];
      int wins = 0;
      for (int i = 0; i < n; i++) {
        if (bob[i] == 'R') {
          if (paper >= 1) {
            result[i] = 'P';
            wins++;
            paper--;
          } else {
            result[i] = '?';
          }
        } else if (bob[i] == 'P') {
          if (scissors >= 1) {
            result[i] = 'S';
            wins++;
            scissors--;
          } else {
            result[i] = '?';
          }
        } else {
          if (rock >= 1) {
            result[i] = 'R';
            wins++;
            rock--;
          } else {
            result[i] = '?';
          }
        }
      }
      ArrayDeque<Character> loses = new ArrayDeque<>();
      for (int i = 0; i < rock; i++) loses.add('R');
      for (int i = 0; i < paper; i++) loses.add('P');
      for (int i = 0; i < scissors; i++) loses.add('S');
      for (int i = 0; i < n; i++) {
        if (result[i] == '?') {
          result[i] = loses.pollFirst();
        }
      }
      if (wins * 2 >= n) {
        out.println("YES");
        for (int i = 0; i < n; i++) {
          out.print(result[i]);
        }
        out.println();
      } else {
        out.println("NO");
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
    try (RestrictedRPS instance = new RestrictedRPS()) {
      instance.solve();
    }
  }
}
