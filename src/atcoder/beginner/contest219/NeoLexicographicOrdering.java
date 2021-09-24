package atcoder.beginner.contest219;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class NeoLexicographicOrdering implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public NeoLexicographicOrdering() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public NeoLexicographicOrdering(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    char[] order = in.next().toCharArray();
    int[] index = new int[26];
    for (int i = 0; i < 26; i++) {
      index[order[i] - 'a'] = i;
    }
    int n = in.ni();
    List<String> words = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      words.add(in.next());
    }
    words.sort((s, t) -> {
      for (int idx = 0; idx < Math.min(s.length(), t.length()); idx++) {
        if (s.charAt(idx) != t.charAt(idx)) {
          return Integer.compare(index[s.charAt(idx) - 'a'], index[t.charAt(idx) - 'a']);
        }
      }
      return Integer.compare(s.length(), t.length());
    });
    words.forEach(out::println);
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
    try (NeoLexicographicOrdering instance = new NeoLexicographicOrdering()) {
      instance.solve();
    }
  }
}
