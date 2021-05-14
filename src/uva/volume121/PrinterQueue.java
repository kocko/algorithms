package uva.volume121;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class PrinterQueue implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public PrinterQueue() throws FileNotFoundException {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), idx = in.ni();
      int[] priority = new int[n];
      int[] order = new int[n];
      ArrayDeque<Integer> deque = new ArrayDeque<>();
      for (int i = 0; i < n; i++) {
        priority[i] = in.ni();
        order[i] = priority[i];
        deque.add(i);
      }
      Arrays.sort(order);
      int j = n - 1, result = 0;
      while (deque.size() > 0) {
        int top = deque.pollFirst();
        if (priority[top] == order[j]) {
          result++;
          j--;
          if (top == idx) break;
        } else {
          deque.offerLast(top);
        }
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
    try (PrinterQueue instance = new PrinterQueue()) {
      instance.solve();
    }
  }
}
