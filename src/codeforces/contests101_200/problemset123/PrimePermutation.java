package codeforces.contests101_200.problemset123;

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

public class PrimePermutation implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    char[] x = in.next().toCharArray();
    int n = x.length, max = 0, index = -1;
    int[] cnt = new int[26];
    for (char c : x) {
      if (++cnt[c - 'a'] > max) {
        max = cnt[c - 'a'];
        index = c - 'a';
      }
    }
    Set<Integer> indices = new HashSet<>();
    for (int i = 2; 2 * i <= n; i++) {
      if (isPrime(i)) {
        indices.add(i);
        for (int j = i * i; j <= n; j += i) {
          indices.add(j);
        }
      }
    }
    if (indices.size() <= max) {
      out.println("YES");
      char[] result = new char[n];
      for (int idx : indices) {
        result[idx - 1] = (char) ('a' + index);
        cnt[index]--;
      }
      ArrayDeque<Character> remaining = new ArrayDeque<>();
      for (int i = 0; i < 26; i++) {
        for (int j = 0; j < cnt[i]; j++) {
          remaining.add((char) ('a' + i));
        }
      }
      for (int i = 0; i < n; i++) {
        if (result[i] == 0x0000) {
          result[i] = remaining.pollFirst();
        }
      }
      for (char c : result) {
        out.print(c);
      }
    } else {
      out.println("NO");
    }
  }

  private boolean isPrime(int n) {
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) return false;
    }
    return true;
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
    try (PrimePermutation instance = new PrimePermutation()) {
      instance.solve();
    }
  }
}
