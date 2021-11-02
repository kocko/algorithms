package codeforces.contests1601_1700.problemset1607;

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

public class LinearKeyboard implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public LinearKeyboard() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public LinearKeyboard(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      char[] order = in.next().toCharArray();
      char[] word = in.next().toCharArray();
      int[] pos = new int[26];
      for (int idx = 0; idx < 26; idx++) {
        pos[order[idx] - 'a'] = idx;
      }
      int result = 0;
      for (int i = 1; i < word.length; i++) {
        result += Math.abs(pos[word[i] - 'a'] - pos[word[i - 1] - 'a']);
      }
      out.println(result);

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
    try (LinearKeyboard instance = new LinearKeyboard()) {
      instance.solve();
    }
  }
}
