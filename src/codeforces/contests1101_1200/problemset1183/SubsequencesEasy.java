package codeforces.contests1101_1200.problemset1183;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SubsequencesEasy implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), k = in.ni();
    int cost = 0;
    Set<String> set = new HashSet<>();
    ArrayDeque<String> deque = new ArrayDeque<>();
    String word = in.next();
    deque.add(word);
    set.add(word);
    while (set.size() < k) {
      if (deque.size() == 0) {
        cost = -1;
        break;
      }
      StringBuilder top = new StringBuilder(deque.pollFirst());
      for (int i = 0; i < top.length() && set.size() < k; i++) {
        StringBuilder temp = new StringBuilder();
        for (int j = 0; j < top.length(); j++) {
          if (i != j) {
            temp.append(top.charAt(j));
          }
        }
        if (set.add(temp.toString())) {
          cost += n - temp.length();
          deque.add(temp.toString());
        }
      }
    }
    out.println(cost);
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
    try (SubsequencesEasy instance = new SubsequencesEasy()) {
      instance.solve();
    }
  }
}
