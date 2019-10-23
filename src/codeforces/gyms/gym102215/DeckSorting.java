package codeforces.gyms.gym102215;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class DeckSorting implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    char[] x = in.next().toCharArray();
    int n = x.length;
    int R = 0, G = 1, B = 2;
    Map<Character, Integer> last = new HashMap<>();
    for (int i = 0; i < n; i++) {
      char value = x[i];
      if (value == 'R') {
        last.put('R', i);
      } else if (value == 'G') {
        last.put('G', i);
      } else {
        last.put('B', i);
      }
    }

    String[] permutations = {"RGB", "RBG", "GRB", "GBR", "BRG", "BGR"};
    boolean possible = false;
    for (String perm : permutations) {

      ArrayDeque<Character> left = new ArrayDeque<>(), right = new ArrayDeque<>();
      for (int i = 0; i < n; i++) {
        if (x[i] == perm.charAt(0)) {
          left.offerLast(x[i]);
        } else if (x[i] == perm.charAt(2)) {
          right.offerLast(x[i]);
        } else {
          if (left.size() > 0 && last.get(left.peekFirst()) < i) {
            left.offerLast(x[i]);
          } else {
            right.offerLast(x[i]);
          }
        }
      }
      char[] temp = new char[n];
      int idx = 0;
      while (left.size() > 0) {
        temp[idx++] = left.pollFirst();
      }
      while (right.size() > 0) {
        temp[idx++] = right.pollFirst();
      }
      int differences = 0;
      for (int i = 1; i < n; i++) {
        if (temp[i] != temp[i - 1]) {
          differences++;
        }
      }
      possible |= differences <= 2;
    }
    out.println(possible ? "YES" : "NO");
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
    try (DeckSorting instance = new DeckSorting()) {
      instance.solve();
    }
  }
}
