package codeforces.contests1201_1300.problemset1214;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BadSequence implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    char[] x = in.next().toCharArray();
    int maxBalanceIndex = -1, balance = 0;
    for (int i = n - 1; i >= 0; i--) {
      if (x[i] == '(') {
        balance++;
      } else {
        balance--;
      }
      if (balance > maxBalanceIndex) {
        maxBalanceIndex = i;
      }
    }
    int to = -1;
    balance = 0;
    for (int i = 0; i < n; i++) {
      if (x[i] == '(') {
        balance++;
      } else {
        balance--;
      }
      if (balance == -1) {
        to = i;
        break;
      }
    }
    if (to == -1) {
      if (balance == 0) {
        out.println("Yes");
      } else {
        out.println("No");
      }
    } else {
      if (maxBalanceIndex == -1) {
        out.println("No");
      } else {
        char[] result = new char[n];
        result[to] = '(';
        int idx = 0, i = 0;
        while (idx < n) {
          if (i == maxBalanceIndex) i++;
          if (idx == to) idx++;
          result[idx++] = x[i++];
        }
        balance = 0;
        boolean ok = true;
        for (i = 0; i < n; i++) {
          if (result[i] == '(') {
            balance++;
          } else {
            balance--;
          }
          ok &= balance >= 0;
        }
        ok &= balance == 0;
        out.println(ok ? "Yes" : "No");
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
    try (BadSequence instance = new BadSequence()) {
      instance.solve();
    }
  }
}
