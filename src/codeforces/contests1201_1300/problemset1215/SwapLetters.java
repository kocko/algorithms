package codeforces.contests1201_1300.problemset1215;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SwapLetters implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    char[] s = in.next().toCharArray(), t = in.next().toCharArray();
    ArrayDeque<Integer> ab = new ArrayDeque<>(), ba = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      if (s[i] == 'a' && t[i] == 'b') {
        ab.add(i + 1);
      } else if (s[i] == 'b' && t[i] == 'a') {
        ba.add(i + 1);
      }
    }
    List<int[]> result = new ArrayList<>();
    if (ab.size() % 2 == 1 && ba.size() % 2 == 1) {
      int idx = ab.pollFirst();
      result.add(new int[]{idx, idx});
      ba.add(idx);
    }
    if (ab.size() % 2 == 0 && ba.size() % 2 == 0) {
      while (ab.size() > 0) {
        int x = ab.pollFirst(), y = ab.pollFirst();
        result.add(new int[]{x, y});
      }
      while (ba.size() > 0) {
        int x = ba.pollFirst(), y = ba.pollFirst();
        result.add(new int[]{x, y});
      }
      out.println(result.size());
      for (int[] pair : result) {
        out.println(pair[0] + " " + pair[1]);
      }
    } else {
      out.println(-1);
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
    try (SwapLetters instance = new SwapLetters()) {
      instance.solve();
    }
  }
}
