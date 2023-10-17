package codeforces.contests1201_1300.problemset1272;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class RemoveOneElement implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public RemoveOneElement() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int n = in.ni();
    int[] x = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = in.ni();
    }
    int[] maxEndingHere = new int[n];
    int[] resultToHere = new int[n];
    maxEndingHere[0] = 1;
    resultToHere[0] = 1;
    int result = 0;
    for (int i = 1; i < n; i++) {
      if (x[i] > x[i - 1]) {
        maxEndingHere[i] = maxEndingHere[i - 1] + 1;
      } else {
        maxEndingHere[i] = 1;
      }
      resultToHere[i] = max(resultToHere[i - 1], maxEndingHere[i]);
      result = max(result, resultToHere[i]);
    }

    int[] maxStartingHere = new int[n];
    int[] resultFromHere = new int[n];
    maxStartingHere[n - 1] = 1;
    resultFromHere[n - 1] = 1;
    for (int i = n - 2; i >= 0; i--) {
      if (x[i] < x[i + 1]) {
        maxStartingHere[i] = maxStartingHere[i + 1] + 1;
      } else {
        maxStartingHere[i] = 1;
      }
      resultFromHere[i] = max(resultFromHere[i + 1], maxStartingHere[i]);
      result = max(result, resultToHere[i]);
    }

    for (int remove = 0; remove < n; remove++) {
      if (remove == 0) {
        result = max(result, maxStartingHere[1]);
      } else if (remove == n - 1) {
        result = max(result, maxEndingHere[remove - 1]);
      } else {
        if (x[remove - 1] < x[remove + 1]) {
          result = max(result, maxEndingHere[remove - 1] + maxStartingHere[remove + 1]);
        }
      }
    }

    out.println(result);
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
    try (RemoveOneElement instance = new RemoveOneElement()) {
      instance.solve();
    }
  }
}
