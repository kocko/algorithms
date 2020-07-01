package codeforces.contests1001_1100.problemset1023;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class SingleWildcardPatternMatching implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    char[] pattern = in.next().toCharArray(), text = in.next().toCharArray();
    boolean match = true;
    if (!hasStar(pattern)) {
      match = n == m;
      for (int i = 0; i < Math.min(n, m); i++) {
        match &= pattern[i] == text[i];
      }
    } else {
      ArrayDeque<Character> p = new ArrayDeque<>(), t = new ArrayDeque<>();
      for (char c : pattern) {
        p.addLast(c);
      }
      for (char c : text) {
        t.addLast(c);
      }
      while (p.size() > 0 && p.peekFirst() != '*' && t.size() > 0) {
        match &= p.pollFirst() == t.pollFirst();
      }
      while (p.size() > 0 && p.peekLast() != '*' && t.size() > 0) {
        match &= p.pollLast() == t.pollLast();
      }
      match &= p.size() == 1 && p.peekFirst() == '*';
    }
    out.println(match ? "YES" : "NO");
  }

  private boolean hasStar(char[] x) {
    for (char c : x) if (c == '*') return true;
    return false;
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
    try (SingleWildcardPatternMatching instance = new SingleWildcardPatternMatching()) {
      instance.solve();
    }
  }
}
