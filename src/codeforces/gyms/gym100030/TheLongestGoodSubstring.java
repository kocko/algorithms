package codeforces.gyms.gym100030;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class TheLongestGoodSubstring implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public TheLongestGoodSubstring() throws IOException {
    in = new InputReader(new FileInputStream(new File("input.txt")));
    out = new PrintWriter(new FileOutputStream(new File("output.txt")));
  }

  public void solve() {
    int k = in.ni();
    char[] x = in.next().toCharArray();
    int left = 0, right = -1;
    Map<Character, Integer> count = new HashMap<>();
    int size = 0, index = -1;
    while (++right < x.length) {
      count.put(x[right], count.getOrDefault(x[right], 0) + 1);
      if (count.size() <= k) {
        if (right - left + 1 > size) {
          size = right - left + 1;
          index = left;
        }
      }
      while (count.size() > k) {
        int cnt = count.get(x[left]);
        if (cnt == 1) {
          count.remove(x[left]);
        } else {
          count.put(x[left], cnt - 1);
        }
        left++;
      }
    }
    out.println((index + 1) + " " + (index + size));
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
    try (TheLongestGoodSubstring instance = new TheLongestGoodSubstring()) {
      instance.solve();
    }
  }
}
