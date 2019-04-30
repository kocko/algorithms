package codeforces.gyms.gym100971;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Palindromization implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    x = in.next().toCharArray();
    int n = x.length;
    int left = 0, right = n - 1, index = -1;
    while (left < right) {
      if (x[left] == x[right]) {
        left++;
        right--;
      } else {
        if (left + 1 <= right && isPalindrome(left + 1, right)) {
          index = left;
          break;
        } else if (right - 1 >= left && isPalindrome(left, right - 1)) {
          index = right;
          break;
        } else {
          out.println("NO");
          return;
        }
      }
    }
    if (index == -1) {
      if (left == right) {
        index = left;
      } else if (left == right + 1) {
        index = right;
      }
    }
    out.println("YES");
    out.println(index + 1);
  }

  private char[] x;

  private boolean isPalindrome(int left, int right) {
    boolean result = true;
    while (left < right) {
      result &= x[left] == x[right];
      left++;
      right--;
    }
    return result;
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
    try (Palindromization instance = new Palindromization()) {
      instance.solve();
    }
  }
}
