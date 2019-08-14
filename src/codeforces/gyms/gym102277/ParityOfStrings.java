package codeforces.gyms.gym102277;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ParityOfStrings implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    char[] x = in.next().toCharArray();
    int[] cnt = new int[26];
    for (char c : x) {
      cnt[c - 'a']++;
    }
    boolean odd = true, even = true;
    for (int i = 0; i < 26; i++) if (cnt[i] > 0) {
      odd &= cnt[i] % 2 == 1;
      even &= cnt[i] % 2 == 0;
    }
    if (odd) {
      out.println(1);
    } else if (even) {
      out.println(0);
    } else {
      out.println(2);
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
    try (ParityOfStrings instance = new ParityOfStrings()) {
      instance.solve();
    }
  }
}
