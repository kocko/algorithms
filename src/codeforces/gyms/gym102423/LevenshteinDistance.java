package codeforces.gyms.gym102423;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class LevenshteinDistance implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    char[] letters = in.next().toCharArray();
    char[] word = in.next().toCharArray();
    Set<String> result = new TreeSet<>();
    int n = word.length;
    //by deletion
    for (int i = 0; i < n; i++) {
      char[] entry = new char[n - 1];
      int idx = 0;
      for (int j = 0; j < n; j++) {
        if (i != j) {
          entry[idx++] = word[j];
        }
      }
      result.add(new String(entry));
    }
    //by addition
    for (char c : letters) {
      for (int slot = 0; slot <= n; slot++) {
        char[] entry = new char[n + 1];
        int idx = 0;
        entry[slot] = c;
        for (char ch : word) {
          if (idx == slot) {
            idx++;
          }
          entry[idx++] = ch;
        }
        result.add(new String(entry));
      }

    }
    //by change
    for (char c : letters) {
      for (int slot = 0; slot < n; slot++) {
        char[] entry = new char[n];
        entry[slot] = c;
        for (int i = 0; i < n; i++) {
          if (i != slot) {
            entry[i] = word[i];
          }
        }
        result.add(new String(entry));
      }
    }
    result.remove(new String(word));
    result.forEach(out::println);
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
    try (LevenshteinDistance instance = new LevenshteinDistance()) {
      instance.solve();
    }
  }
}
