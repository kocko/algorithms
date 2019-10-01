package codeforces.contests1201_1300.problemset1234;

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

public class SocialNetwork implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), k = in.ni();
    Set<Integer> set = new HashSet<>();
    ArrayDeque<Integer> screen = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      int id = in.ni();
      if (!set.contains(id)) {
        if (screen.size() == k) {
          int last = screen.pollLast();
          set.remove(last);
        }
        screen.offerFirst(id);
        set.add(id);
      }
    }
    out.println(screen.size());
    while (screen.size() > 0) {
      out.print(screen.pollFirst());
      out.print(' ');
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
    try (SocialNetwork instance = new SocialNetwork()) {
      instance.solve();
    }
  }
}
