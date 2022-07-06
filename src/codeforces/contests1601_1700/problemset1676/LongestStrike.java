package codeforces.contests1601_1700.problemset1676;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class LongestStrike implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni(), k = in.ni();
      TreeMap<Integer, Integer> count = new TreeMap<>();
      for (int i = 0; i < n; i++) {
        int next = in.ni();
        count.put(next, count.getOrDefault(next, 0) + 1);
      }
      Iterator<Integer> iterator = count.keySet().iterator();
      int left = -1, right = -1;
      int currentLeft = -1, currentRight = -1;
      while (iterator.hasNext()) {
        int next = iterator.next(), cnt = count.get(next);
        if (cnt >= k) {
          if (currentLeft == -1) {
            currentLeft = currentRight = next;
          } else {
            if (next - 1 == currentRight) {
              currentRight++;
            } else {
              if (currentLeft != -1 && currentRight - currentLeft >= right - left) {
                left = currentLeft;
                right = currentRight;
              }
              currentLeft = currentRight = next;
            }
          }
        } else {
          if (currentLeft != -1 && currentRight - currentLeft >= right - left) {
            left = currentLeft;
            right = currentRight;
          }
          currentLeft = currentRight = -1;
        }
      }
      if (currentLeft != -1 && currentRight - currentLeft >= right - left) {
        left = currentLeft;
        right = currentRight;
      }
      out.println(left != -1 ? (left + " " + right) : "-1");
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
    try (LongestStrike instance = new LongestStrike()) {
      instance.solve();
    }
  }
}